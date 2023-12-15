package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.BuildConfig;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.microsoft.appcenter.http.DefaultHttpClient;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class ConfigRealtimeHttpClient {
    private static final String API_KEY_HEADER = "X-Goog-Api-Key";
    static final int[] BACKOFF_TIME_DURATIONS_IN_MINUTES = {2, 4, 8, 16, 32, 64, 128, 256};
    private static final Pattern GMP_APP_ID_PATTERN = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");
    private static final String INSTALLATIONS_AUTH_TOKEN_HEADER = "X-Goog-Firebase-Installations-Auth";
    private static final String X_ACCEPT_RESPONSE_STREAMING = "X-Accept-Response-Streaming";
    private static final String X_ANDROID_CERT_HEADER = "X-Android-Cert";
    private static final String X_ANDROID_PACKAGE_HEADER = "X-Android-Package";
    private static final String X_GOOGLE_GFE_CAN_RETRY = "X-Google-GFE-Can-Retry";
    private final int ORIGINAL_RETRIES = 8;
    ConfigCacheClient activatedCache;
    private final Clock clock;
    private final ConfigFetchHandler configFetchHandler;
    private final Context context;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private int httpRetriesRemaining;
    private boolean isHttpConnectionRunning;
    private boolean isInBackground;
    private boolean isRealtimeDisabled;
    private final Set<ConfigUpdateListener> listeners;
    private final ConfigMetadataClient metadataClient;
    private final String namespace;
    private final Random random;
    private final ScheduledExecutorService scheduledExecutorService;

    private boolean isStatusCodeRetryable(int i) {
        return i == 408 || i == 429 || i == 502 || i == 503 || i == 504;
    }

    public ConfigRealtimeHttpClient(FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi, ConfigFetchHandler configFetchHandler2, ConfigCacheClient configCacheClient, Context context2, String str, Set<ConfigUpdateListener> set, ConfigMetadataClient configMetadataClient, ScheduledExecutorService scheduledExecutorService2) {
        this.listeners = set;
        this.isHttpConnectionRunning = false;
        this.scheduledExecutorService = scheduledExecutorService2;
        this.random = new Random();
        this.httpRetriesRemaining = Math.max(8 - configMetadataClient.getRealtimeBackoffMetadata().getNumFailedStreams(), 1);
        this.clock = DefaultClock.getInstance();
        this.firebaseApp = firebaseApp2;
        this.configFetchHandler = configFetchHandler2;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.activatedCache = configCacheClient;
        this.context = context2;
        this.namespace = str;
        this.metadataClient = configMetadataClient;
        this.isRealtimeDisabled = false;
        this.isInBackground = false;
    }

    private static String extractProjectNumberFromAppId(String str) {
        Matcher matcher = GMP_APP_ID_PATTERN.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    private void getInstallationAuthToken(HttpURLConnection httpURLConnection) {
        this.firebaseInstallations.getToken(false).onSuccessTask(this.scheduledExecutorService, new SuccessContinuation(httpURLConnection) {
            public final /* synthetic */ HttpURLConnection f$0;

            {
                this.f$0 = r1;
            }

            public final Task then(Object obj) {
                return this.f$0.setRequestProperty(ConfigRealtimeHttpClient.INSTALLATIONS_AUTH_TOKEN_HEADER, ((InstallationTokenResult) obj).getToken());
            }
        });
    }

    private String getFingerprintHashForPackage() {
        try {
            Context context2 = this.context;
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context2, context2.getPackageName());
            if (packageCertificateHashBytes != null) {
                return Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
            }
            Log.e(FirebaseRemoteConfig.TAG, "Could not get fingerprint hash for package: " + this.context.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.i(FirebaseRemoteConfig.TAG, "No such package: " + this.context.getPackageName());
            return null;
        }
    }

    private void setCommonRequestHeaders(HttpURLConnection httpURLConnection) {
        getInstallationAuthToken(httpURLConnection);
        httpURLConnection.setRequestProperty(API_KEY_HEADER, this.firebaseApp.getOptions().getApiKey());
        httpURLConnection.setRequestProperty(X_ANDROID_PACKAGE_HEADER, this.context.getPackageName());
        httpURLConnection.setRequestProperty(X_ANDROID_CERT_HEADER, getFingerprintHashForPackage());
        httpURLConnection.setRequestProperty(X_GOOGLE_GFE_CAN_RETRY, "yes");
        httpURLConnection.setRequestProperty(X_ACCEPT_RESPONSE_STREAMING, "true");
        httpURLConnection.setRequestProperty(DefaultHttpClient.CONTENT_TYPE_KEY, "application/json");
        httpURLConnection.setRequestProperty("Accept", "application/json");
    }

    private JSONObject createRequestBody() {
        HashMap hashMap = new HashMap();
        hashMap.put("project", extractProjectNumberFromAppId(this.firebaseApp.getOptions().getApplicationId()));
        hashMap.put("namespace", this.namespace);
        hashMap.put("lastKnownVersionNumber", Long.toString(this.configFetchHandler.getTemplateVersionNumber()));
        hashMap.put(RemoteConfigConstants.RequestFieldKey.APP_ID, this.firebaseApp.getOptions().getApplicationId());
        hashMap.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, BuildConfig.VERSION_NAME);
        return new JSONObject(hashMap);
    }

    private void setRequestParams(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.setRequestMethod("POST");
        byte[] bytes = createRequestBody().toString().getBytes("utf-8");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    /* access modifiers changed from: private */
    public synchronized void propagateErrors(FirebaseRemoteConfigException firebaseRemoteConfigException) {
        for (ConfigUpdateListener onError : this.listeners) {
            onError.onError(firebaseRemoteConfigException);
        }
    }

    public int getNumberOfFailedStreams() {
        return this.metadataClient.getRealtimeBackoffMetadata().getNumFailedStreams();
    }

    public Date getBackoffEndTime() {
        return this.metadataClient.getRealtimeBackoffMetadata().getBackoffEndTime();
    }

    private void updateBackoffMetadataWithLastFailedStreamConnectionTime(Date date) {
        int numFailedStreams = this.metadataClient.getRealtimeBackoffMetadata().getNumFailedStreams() + 1;
        this.metadataClient.setRealtimeBackoffMetadata(numFailedStreams, new Date(date.getTime() + getRandomizedBackoffDurationInMillis(numFailedStreams)));
    }

    private long getRandomizedBackoffDurationInMillis(int i) {
        int[] iArr = BACKOFF_TIME_DURATIONS_IN_MINUTES;
        int length = iArr.length;
        if (i >= length) {
            i = length;
        }
        long millis = TimeUnit.MINUTES.toMillis((long) iArr[i - 1]);
        return (millis / 2) + ((long) this.random.nextInt((int) millis));
    }

    /* access modifiers changed from: private */
    public synchronized void enableBackoff() {
        this.isRealtimeDisabled = true;
    }

    private synchronized boolean canMakeHttpStreamConnection() {
        return !this.listeners.isEmpty() && !this.isHttpConnectionRunning && !this.isRealtimeDisabled && !this.isInBackground;
    }

    private String getRealtimeURL(String str) {
        return String.format(RemoteConfigConstants.REALTIME_REGEX_URL, new Object[]{extractProjectNumberFromAppId(this.firebaseApp.getOptions().getApplicationId()), str});
    }

    private URL getUrl() {
        try {
            return new URL(getRealtimeURL(this.namespace));
        } catch (MalformedURLException unused) {
            Log.e(FirebaseRemoteConfig.TAG, "URL is malformed");
            return null;
        }
    }

    public HttpURLConnection createRealtimeConnection() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) getUrl().openConnection();
        setCommonRequestHeaders(httpURLConnection);
        setRequestParams(httpURLConnection);
        return httpURLConnection;
    }

    public void startHttpConnection() {
        makeRealtimeHttpConnection(0);
    }

    public synchronized void retryHttpConnectionWhenBackoffEnds() {
        makeRealtimeHttpConnection(Math.max(0, this.metadataClient.getRealtimeBackoffMetadata().getBackoffEndTime().getTime() - new Date(this.clock.currentTimeMillis()).getTime()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void makeRealtimeHttpConnection(long r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.canMakeHttpStreamConnection()     // Catch:{ all -> 0x0030 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r3)
            return
        L_0x0009:
            int r0 = r3.httpRetriesRemaining     // Catch:{ all -> 0x0030 }
            if (r0 <= 0) goto L_0x001e
            int r0 = r0 + -1
            r3.httpRetriesRemaining = r0     // Catch:{ all -> 0x0030 }
            java.util.concurrent.ScheduledExecutorService r0 = r3.scheduledExecutorService     // Catch:{ all -> 0x0030 }
            com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient$1 r1 = new com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient$1     // Catch:{ all -> 0x0030 }
            r1.<init>()     // Catch:{ all -> 0x0030 }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0030 }
            r0.schedule(r1, r4, r2)     // Catch:{ all -> 0x0030 }
            goto L_0x002e
        L_0x001e:
            boolean r4 = r3.isInBackground     // Catch:{ all -> 0x0030 }
            if (r4 != 0) goto L_0x002e
            com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException r4 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException     // Catch:{ all -> 0x0030 }
            java.lang.String r5 = "Unable to connect to the server. Check your connection and try again."
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r0 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR     // Catch:{ all -> 0x0030 }
            r4.<init>((java.lang.String) r5, (com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code) r0)     // Catch:{ all -> 0x0030 }
            r3.propagateErrors(r4)     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r3)
            return
        L_0x0030:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient.makeRealtimeHttpConnection(long):void");
    }

    /* access modifiers changed from: package-private */
    public void setRealtimeBackgroundState(boolean z) {
        this.isInBackground = z;
    }

    private synchronized void resetRetryCount() {
        this.httpRetriesRemaining = 8;
    }

    private synchronized void setIsHttpConnectionRunning(boolean z) {
        this.isHttpConnectionRunning = z;
    }

    public synchronized ConfigAutoFetch startAutoFetch(HttpURLConnection httpURLConnection) {
        HttpURLConnection httpURLConnection2;
        httpURLConnection2 = httpURLConnection;
        return new ConfigAutoFetch(httpURLConnection2, this.configFetchHandler, this.activatedCache, this.listeners, new ConfigUpdateListener() {
            public void onUpdate(ConfigUpdate configUpdate) {
            }

            public void onError(FirebaseRemoteConfigException firebaseRemoteConfigException) {
                ConfigRealtimeHttpClient.this.enableBackoff();
                ConfigRealtimeHttpClient.this.propagateErrors(firebaseRemoteConfigException);
            }
        }, this.scheduledExecutorService);
    }

    private String parseForbiddenErrorResponseMessage(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
        } catch (IOException unused) {
            if (sb.length() == 0) {
                return "Unable to connect to the server, access is forbidden. HTTP status code: 403";
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x016a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void beginRealtimeHttpStream() {
        /*
            r13 = this;
            java.lang.String r0 = "Unable to connect to the server. Try again in a few minutes. HTTP status code: %d"
            boolean r1 = r13.canMakeHttpStreamConnection()
            if (r1 != 0) goto L_0x0009
            return
        L_0x0009:
            com.google.firebase.remoteconfig.internal.ConfigMetadataClient r1 = r13.metadataClient
            com.google.firebase.remoteconfig.internal.ConfigMetadataClient$RealtimeBackoffMetadata r1 = r1.getRealtimeBackoffMetadata()
            java.util.Date r2 = new java.util.Date
            com.google.android.gms.common.util.Clock r3 = r13.clock
            long r3 = r3.currentTimeMillis()
            r2.<init>(r3)
            java.util.Date r1 = r1.getBackoffEndTime()
            boolean r1 = r2.before(r1)
            if (r1 == 0) goto L_0x0028
            r13.retryHttpConnectionWhenBackoffEnds()
            return
        L_0x0028:
            r1 = 1
            r13.setIsHttpConnectionRunning(r1)
            r2 = 0
            r3 = 403(0x193, float:5.65E-43)
            r4 = 200(0xc8, float:2.8E-43)
            r5 = 0
            java.net.HttpURLConnection r6 = r13.createRealtimeConnection()     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
            int r7 = r6.getResponseCode()     // Catch:{ IOException -> 0x00b3, all -> 0x00ad }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x00b3, all -> 0x00ad }
            int r7 = r2.intValue()     // Catch:{ IOException -> 0x00b3, all -> 0x00ad }
            if (r7 != r4) goto L_0x0053
            r13.resetRetryCount()     // Catch:{ IOException -> 0x00b3, all -> 0x00ad }
            com.google.firebase.remoteconfig.internal.ConfigMetadataClient r7 = r13.metadataClient     // Catch:{ IOException -> 0x00b3, all -> 0x00ad }
            r7.resetRealtimeBackoff()     // Catch:{ IOException -> 0x00b3, all -> 0x00ad }
            com.google.firebase.remoteconfig.internal.ConfigAutoFetch r7 = r13.startAutoFetch(r6)     // Catch:{ IOException -> 0x00b3, all -> 0x00ad }
            r7.listenForNotifications()     // Catch:{ IOException -> 0x00b3, all -> 0x00ad }
        L_0x0053:
            r13.closeRealtimeHttpStream(r6)
            r13.setIsHttpConnectionRunning(r5)
            if (r2 == 0) goto L_0x0068
            int r7 = r2.intValue()
            boolean r7 = r13.isStatusCodeRetryable(r7)
            if (r7 == 0) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            r7 = 0
            goto L_0x0069
        L_0x0068:
            r7 = 1
        L_0x0069:
            if (r7 == 0) goto L_0x0079
            java.util.Date r8 = new java.util.Date
            com.google.android.gms.common.util.Clock r9 = r13.clock
            long r9 = r9.currentTimeMillis()
            r8.<init>(r9)
            r13.updateBackoffMetadataWithLastFailedStreamConnectionTime(r8)
        L_0x0079:
            if (r7 != 0) goto L_0x00a8
            int r7 = r2.intValue()
            if (r7 != r4) goto L_0x0082
            goto L_0x00a8
        L_0x0082:
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r5] = r2
            java.lang.String r0 = java.lang.String.format(r0, r1)
            int r1 = r2.intValue()
            if (r1 != r3) goto L_0x0098
            java.io.InputStream r0 = r6.getErrorStream()
            java.lang.String r0 = r13.parseForbiddenErrorResponseMessage(r0)
        L_0x0098:
            com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException r1 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException
            int r2 = r2.intValue()
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r3 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR
            r1.<init>((int) r2, (java.lang.String) r0, (com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code) r3)
        L_0x00a3:
            r13.propagateErrors(r1)
            goto L_0x0115
        L_0x00a8:
            r13.retryHttpConnectionWhenBackoffEnds()
            goto L_0x0115
        L_0x00ad:
            r7 = move-exception
            r12 = r6
            r6 = r2
            r2 = r12
            goto L_0x0117
        L_0x00b3:
            r7 = move-exception
            r12 = r6
            r6 = r2
            r2 = r12
            goto L_0x00bd
        L_0x00b8:
            r7 = move-exception
            r6 = r2
            goto L_0x0117
        L_0x00bb:
            r7 = move-exception
            r6 = r2
        L_0x00bd:
            java.lang.String r8 = "FirebaseRemoteConfig"
            java.lang.String r9 = "Exception connecting to real-time RC backend. Retrying the connection..."
            android.util.Log.d(r8, r9, r7)     // Catch:{ all -> 0x0116 }
            r13.closeRealtimeHttpStream(r2)
            r13.setIsHttpConnectionRunning(r5)
            if (r6 == 0) goto L_0x00d9
            int r7 = r6.intValue()
            boolean r7 = r13.isStatusCodeRetryable(r7)
            if (r7 == 0) goto L_0x00d7
            goto L_0x00d9
        L_0x00d7:
            r7 = 0
            goto L_0x00da
        L_0x00d9:
            r7 = 1
        L_0x00da:
            if (r7 == 0) goto L_0x00ea
            java.util.Date r8 = new java.util.Date
            com.google.android.gms.common.util.Clock r9 = r13.clock
            long r9 = r9.currentTimeMillis()
            r8.<init>(r9)
            r13.updateBackoffMetadataWithLastFailedStreamConnectionTime(r8)
        L_0x00ea:
            if (r7 != 0) goto L_0x00a8
            int r7 = r6.intValue()
            if (r7 != r4) goto L_0x00f3
            goto L_0x00a8
        L_0x00f3:
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r5] = r6
            java.lang.String r0 = java.lang.String.format(r0, r1)
            int r1 = r6.intValue()
            if (r1 != r3) goto L_0x0109
            java.io.InputStream r0 = r2.getErrorStream()
            java.lang.String r0 = r13.parseForbiddenErrorResponseMessage(r0)
        L_0x0109:
            com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException r1 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException
            int r2 = r6.intValue()
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r3 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR
            r1.<init>((int) r2, (java.lang.String) r0, (com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code) r3)
            goto L_0x00a3
        L_0x0115:
            return
        L_0x0116:
            r7 = move-exception
        L_0x0117:
            r13.closeRealtimeHttpStream(r2)
            r13.setIsHttpConnectionRunning(r5)
            if (r6 == 0) goto L_0x012c
            int r8 = r6.intValue()
            boolean r8 = r13.isStatusCodeRetryable(r8)
            if (r8 == 0) goto L_0x012a
            goto L_0x012c
        L_0x012a:
            r8 = 0
            goto L_0x012d
        L_0x012c:
            r8 = 1
        L_0x012d:
            if (r8 == 0) goto L_0x013d
            java.util.Date r9 = new java.util.Date
            com.google.android.gms.common.util.Clock r10 = r13.clock
            long r10 = r10.currentTimeMillis()
            r9.<init>(r10)
            r13.updateBackoffMetadataWithLastFailedStreamConnectionTime(r9)
        L_0x013d:
            if (r8 != 0) goto L_0x016a
            int r8 = r6.intValue()
            if (r8 == r4) goto L_0x016a
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r5] = r6
            java.lang.String r0 = java.lang.String.format(r0, r1)
            int r1 = r6.intValue()
            if (r1 != r3) goto L_0x015b
            java.io.InputStream r0 = r2.getErrorStream()
            java.lang.String r0 = r13.parseForbiddenErrorResponseMessage(r0)
        L_0x015b:
            com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException r1 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException
            int r2 = r6.intValue()
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r3 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR
            r1.<init>((int) r2, (java.lang.String) r0, (com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code) r3)
            r13.propagateErrors(r1)
            goto L_0x016d
        L_0x016a:
            r13.retryHttpConnectionWhenBackoffEnds()
        L_0x016d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient.beginRealtimeHttpStream():void");
    }

    public void closeRealtimeHttpStream(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            try {
                httpURLConnection.getInputStream().close();
                if (httpURLConnection.getErrorStream() != null) {
                    httpURLConnection.getErrorStream().close();
                }
            } catch (IOException unused) {
            }
        }
    }
}
