package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.Settings;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

class CrashlyticsController {
    static final FilenameFilter APP_EXCEPTION_MARKER_FILTER = $$Lambda$CrashlyticsController$KdOR_Yifvg9Sk8KSAhQ8lZy6az4.INSTANCE;
    static final String APP_EXCEPTION_MARKER_PREFIX = ".ae";
    static final String FIREBASE_APPLICATION_EXCEPTION = "_ae";
    static final String FIREBASE_CRASH_TYPE = "fatal";
    static final int FIREBASE_CRASH_TYPE_FATAL = 1;
    static final String FIREBASE_TIMESTAMP = "timestamp";
    private static final String GENERATOR_FORMAT = "Crashlytics Android SDK/%s";
    static final String NATIVE_SESSION_DIR = "native-sessions";
    /* access modifiers changed from: private */
    public final AnalyticsEventLogger analyticsEventLogger;
    private final AppData appData;
    /* access modifiers changed from: private */
    public final CrashlyticsBackgroundWorker backgroundWorker;
    final AtomicBoolean checkForUnsentReportsCalled = new AtomicBoolean(false);
    private final Context context;
    private CrashlyticsUncaughtExceptionHandler crashHandler;
    /* access modifiers changed from: private */
    public final CrashlyticsFileMarker crashMarker;
    /* access modifiers changed from: private */
    public final DataCollectionArbiter dataCollectionArbiter;
    private final FileStore fileStore;
    /* access modifiers changed from: private */
    public final IdManager idManager;
    /* access modifiers changed from: private */
    public final LogFileManager logFileManager;
    private final CrashlyticsNativeComponent nativeComponent;
    final TaskCompletionSource<Boolean> reportActionProvided = new TaskCompletionSource<>();
    /* access modifiers changed from: private */
    public final SessionReportingCoordinator reportingCoordinator;
    private SettingsProvider settingsProvider = null;
    final TaskCompletionSource<Boolean> unsentReportsAvailable = new TaskCompletionSource<>();
    final TaskCompletionSource<Void> unsentReportsHandled = new TaskCompletionSource<>();
    private final UserMetadata userMetadata;

    CrashlyticsController(Context context2, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, IdManager idManager2, DataCollectionArbiter dataCollectionArbiter2, FileStore fileStore2, CrashlyticsFileMarker crashlyticsFileMarker, AppData appData2, UserMetadata userMetadata2, LogFileManager logFileManager2, SessionReportingCoordinator sessionReportingCoordinator, CrashlyticsNativeComponent crashlyticsNativeComponent, AnalyticsEventLogger analyticsEventLogger2) {
        this.context = context2;
        this.backgroundWorker = crashlyticsBackgroundWorker;
        this.idManager = idManager2;
        this.dataCollectionArbiter = dataCollectionArbiter2;
        this.fileStore = fileStore2;
        this.crashMarker = crashlyticsFileMarker;
        this.appData = appData2;
        this.userMetadata = userMetadata2;
        this.logFileManager = logFileManager2;
        this.nativeComponent = crashlyticsNativeComponent;
        this.analyticsEventLogger = analyticsEventLogger2;
        this.reportingCoordinator = sessionReportingCoordinator;
    }

    private Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: package-private */
    public void enableExceptionHandling(String str, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, SettingsProvider settingsProvider2) {
        this.settingsProvider = settingsProvider2;
        openSession(str);
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = new CrashlyticsUncaughtExceptionHandler(new CrashlyticsUncaughtExceptionHandler.CrashListener() {
            public void onUncaughtException(SettingsProvider settingsProvider, Thread thread, Throwable th) {
                CrashlyticsController.this.handleUncaughtException(settingsProvider, thread, th);
            }
        }, settingsProvider2, uncaughtExceptionHandler, this.nativeComponent);
        this.crashHandler = crashlyticsUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(crashlyticsUncaughtExceptionHandler);
    }

    /* access modifiers changed from: package-private */
    public void handleUncaughtException(SettingsProvider settingsProvider2, Thread thread, Throwable th) {
        handleUncaughtException(settingsProvider2, thread, th, false);
    }

    /* access modifiers changed from: package-private */
    public synchronized void handleUncaughtException(SettingsProvider settingsProvider2, Thread thread, Throwable th, boolean z) {
        Logger logger = Logger.getLogger();
        logger.d("Handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        final long currentTimeMillis = System.currentTimeMillis();
        final Throwable th2 = th;
        final Thread thread2 = thread;
        final SettingsProvider settingsProvider3 = settingsProvider2;
        final boolean z2 = z;
        try {
            Utils.awaitEvenIfOnMainThread(this.backgroundWorker.submitTask(new Callable<Task<Void>>() {
                public Task<Void> call() throws Exception {
                    long access$000 = CrashlyticsController.getTimestampSeconds(currentTimeMillis);
                    final String access$100 = CrashlyticsController.this.getCurrentSessionId();
                    if (access$100 == null) {
                        Logger.getLogger().e("Tried to write a fatal exception while no session was open.");
                        return Tasks.forResult(null);
                    }
                    CrashlyticsController.this.crashMarker.create();
                    CrashlyticsController.this.reportingCoordinator.persistFatalEvent(th2, thread2, access$100, access$000);
                    CrashlyticsController.this.doWriteAppExceptionMarker(currentTimeMillis);
                    CrashlyticsController.this.doCloseSessions(settingsProvider3);
                    CrashlyticsController.this.doOpenSession(new CLSUUID(CrashlyticsController.this.idManager).toString());
                    if (!CrashlyticsController.this.dataCollectionArbiter.isAutomaticDataCollectionEnabled()) {
                        return Tasks.forResult(null);
                    }
                    final Executor executor = CrashlyticsController.this.backgroundWorker.getExecutor();
                    return settingsProvider3.getSettingsAsync().onSuccessTask(executor, new SuccessContinuation<Settings, Void>() {
                        public Task<Void> then(Settings settings) throws Exception {
                            String str = null;
                            if (settings == null) {
                                Logger.getLogger().w("Received null app settings, cannot send reports at crash time.");
                                return Tasks.forResult(null);
                            }
                            Task[] taskArr = new Task[2];
                            taskArr[0] = CrashlyticsController.this.logAnalyticsAppExceptionEvents();
                            SessionReportingCoordinator access$300 = CrashlyticsController.this.reportingCoordinator;
                            Executor executor = executor;
                            if (z2) {
                                str = access$100;
                            }
                            taskArr[1] = access$300.sendReports(executor, str);
                            return Tasks.whenAll((Task<?>[]) taskArr);
                        }
                    });
                }
            }));
        } catch (TimeoutException unused) {
            Logger.getLogger().e("Cannot send reports. Timed out while fetching settings.");
        } catch (Exception e) {
            Logger.getLogger().e("Error handling uncaught exception", e);
        }
    }

    private Task<Boolean> waitForReportAction() {
        if (this.dataCollectionArbiter.isAutomaticDataCollectionEnabled()) {
            Logger.getLogger().d("Automatic data collection is enabled. Allowing upload.");
            this.unsentReportsAvailable.trySetResult(false);
            return Tasks.forResult(true);
        }
        Logger.getLogger().d("Automatic data collection is disabled.");
        Logger.getLogger().v("Notifying that unsent reports are available.");
        this.unsentReportsAvailable.trySetResult(true);
        Task<TContinuationResult> onSuccessTask = this.dataCollectionArbiter.waitForAutomaticDataCollectionEnabled().onSuccessTask(new SuccessContinuation<Void, Boolean>() {
            public Task<Boolean> then(Void voidR) throws Exception {
                return Tasks.forResult(true);
            }
        });
        Logger.getLogger().d("Waiting for send/deleteUnsentReports to be called.");
        return Utils.race(onSuccessTask, this.reportActionProvided.getTask());
    }

    /* access modifiers changed from: package-private */
    public boolean didCrashOnPreviousExecution() {
        if (!this.crashMarker.isPresent()) {
            String currentSessionId = getCurrentSessionId();
            if (currentSessionId == null || !this.nativeComponent.hasCrashDataForSession(currentSessionId)) {
                return false;
            }
            return true;
        }
        Logger.getLogger().v("Found previous crash marker.");
        this.crashMarker.remove();
        Boolean bool = Boolean.TRUE;
        return true;
    }

    /* access modifiers changed from: package-private */
    public Task<Boolean> checkForUnsentReports() {
        if (this.checkForUnsentReportsCalled.compareAndSet(false, true)) {
            return this.unsentReportsAvailable.getTask();
        }
        Logger.getLogger().w("checkForUnsentReports should only be called once per execution.");
        return Tasks.forResult(false);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> sendUnsentReports() {
        this.reportActionProvided.trySetResult(true);
        return this.unsentReportsHandled.getTask();
    }

    /* access modifiers changed from: package-private */
    public Task<Void> deleteUnsentReports() {
        this.reportActionProvided.trySetResult(false);
        return this.unsentReportsHandled.getTask();
    }

    /* access modifiers changed from: package-private */
    public Task<Void> submitAllReports(final Task<Settings> task) {
        if (!this.reportingCoordinator.hasReportsToSend()) {
            Logger.getLogger().v("No crash reports are available to be sent.");
            this.unsentReportsAvailable.trySetResult(false);
            return Tasks.forResult(null);
        }
        Logger.getLogger().v("Crash reports are available to be sent.");
        return waitForReportAction().onSuccessTask(new SuccessContinuation<Boolean, Void>() {
            public Task<Void> then(final Boolean bool) throws Exception {
                return CrashlyticsController.this.backgroundWorker.submitTask(new Callable<Task<Void>>() {
                    public Task<Void> call() throws Exception {
                        if (!bool.booleanValue()) {
                            Logger.getLogger().v("Deleting cached crash reports...");
                            CrashlyticsController.deleteFiles(CrashlyticsController.this.listAppExceptionMarkerFiles());
                            CrashlyticsController.this.reportingCoordinator.removeAllReports();
                            CrashlyticsController.this.unsentReportsHandled.trySetResult(null);
                            return Tasks.forResult(null);
                        }
                        Logger.getLogger().d("Sending cached crash reports...");
                        CrashlyticsController.this.dataCollectionArbiter.grantDataCollectionPermission(bool.booleanValue());
                        final Executor executor = CrashlyticsController.this.backgroundWorker.getExecutor();
                        return task.onSuccessTask(executor, new SuccessContinuation<Settings, Void>() {
                            public Task<Void> then(Settings settings) throws Exception {
                                if (settings == null) {
                                    Logger.getLogger().w("Received null app settings at app startup. Cannot send cached reports");
                                    return Tasks.forResult(null);
                                }
                                Task unused = CrashlyticsController.this.logAnalyticsAppExceptionEvents();
                                CrashlyticsController.this.reportingCoordinator.sendReports(executor);
                                CrashlyticsController.this.unsentReportsHandled.trySetResult(null);
                                return Tasks.forResult(null);
                            }
                        });
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void writeToLog(final long j, final String str) {
        this.backgroundWorker.submit(new Callable<Void>() {
            public Void call() throws Exception {
                if (CrashlyticsController.this.isHandlingException()) {
                    return null;
                }
                CrashlyticsController.this.logFileManager.writeToLog(j, str);
                return null;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void writeNonFatalException(Thread thread, Throwable th) {
        final long currentTimeMillis = System.currentTimeMillis();
        final Throwable th2 = th;
        final Thread thread2 = thread;
        this.backgroundWorker.submit((Runnable) new Runnable() {
            public void run() {
                if (!CrashlyticsController.this.isHandlingException()) {
                    long access$000 = CrashlyticsController.getTimestampSeconds(currentTimeMillis);
                    String access$100 = CrashlyticsController.this.getCurrentSessionId();
                    if (access$100 == null) {
                        Logger.getLogger().w("Tried to write a non-fatal exception while no session was open.");
                    } else {
                        CrashlyticsController.this.reportingCoordinator.persistNonFatalEvent(th2, thread2, access$100, access$000);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void logFatalException(Thread thread, Throwable th) {
        SettingsProvider settingsProvider2 = this.settingsProvider;
        if (settingsProvider2 == null) {
            Logger.getLogger().w("settingsProvider not set");
        } else {
            handleUncaughtException(settingsProvider2, thread, th, true);
        }
    }

    /* access modifiers changed from: package-private */
    public void setUserId(String str) {
        this.userMetadata.setUserId(str);
    }

    /* access modifiers changed from: package-private */
    public void setCustomKey(String str, String str2) {
        try {
            this.userMetadata.setCustomKey(str, str2);
        } catch (IllegalArgumentException e) {
            Context context2 = this.context;
            if (context2 == null || !CommonUtils.isAppDebuggable(context2)) {
                Logger.getLogger().e("Attempting to set custom attribute with null key, ignoring.");
                return;
            }
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public void setCustomKeys(Map<String, String> map) {
        this.userMetadata.setCustomKeys(map);
    }

    /* access modifiers changed from: package-private */
    public void setInternalKey(String str, String str2) {
        try {
            this.userMetadata.setInternalKey(str, str2);
        } catch (IllegalArgumentException e) {
            Context context2 = this.context;
            if (context2 == null || !CommonUtils.isAppDebuggable(context2)) {
                Logger.getLogger().e("Attempting to set custom attribute with null key, ignoring.");
                return;
            }
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public void openSession(final String str) {
        this.backgroundWorker.submit(new Callable<Void>() {
            public Void call() throws Exception {
                CrashlyticsController.this.doOpenSession(str);
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public String getCurrentSessionId() {
        SortedSet<String> listSortedOpenSessionIds = this.reportingCoordinator.listSortedOpenSessionIds();
        if (!listSortedOpenSessionIds.isEmpty()) {
            return listSortedOpenSessionIds.first();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean finalizeSessions(SettingsProvider settingsProvider2) {
        this.backgroundWorker.checkRunningOnThread();
        if (isHandlingException()) {
            Logger.getLogger().w("Skipping session finalization because a crash has already occurred.");
            Boolean bool = Boolean.FALSE;
            return false;
        }
        Logger.getLogger().v("Finalizing previously open sessions.");
        try {
            doCloseSessions(true, settingsProvider2);
            Logger.getLogger().v("Closed all previously open sessions.");
            return true;
        } catch (Exception e) {
            Logger.getLogger().e("Unable to finalize previously open sessions.", e);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void doOpenSession(String str) {
        long currentTimestampSeconds = getCurrentTimestampSeconds();
        Logger logger = Logger.getLogger();
        logger.d("Opening a new session with ID " + str);
        String format = String.format(Locale.US, GENERATOR_FORMAT, new Object[]{CrashlyticsCore.getVersion()});
        StaticSessionData.AppData createAppData = createAppData(this.idManager, this.appData);
        StaticSessionData.OsData createOsData = createOsData();
        StaticSessionData.DeviceData createDeviceData = createDeviceData();
        this.nativeComponent.prepareNativeSession(str, format, currentTimestampSeconds, StaticSessionData.create(createAppData, createOsData, createDeviceData));
        this.logFileManager.setCurrentSession(str);
        this.reportingCoordinator.onBeginSession(str, currentTimestampSeconds);
    }

    /* access modifiers changed from: package-private */
    public void doCloseSessions(SettingsProvider settingsProvider2) {
        doCloseSessions(false, settingsProvider2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void doCloseSessions(boolean r4, com.google.firebase.crashlytics.internal.settings.SettingsProvider r5) {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator r1 = r3.reportingCoordinator
            java.util.SortedSet r1 = r1.listSortedOpenSessionIds()
            r0.<init>(r1)
            int r1 = r0.size()
            if (r1 > r4) goto L_0x001b
            com.google.firebase.crashlytics.internal.Logger r4 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.String r5 = "No open sessions to be closed."
            r4.v(r5)
            return
        L_0x001b:
            java.lang.Object r1 = r0.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            com.google.firebase.crashlytics.internal.settings.Settings r5 = r5.getSettingsSync()
            com.google.firebase.crashlytics.internal.settings.Settings$FeatureFlagData r5 = r5.featureFlagData
            boolean r5 = r5.collectAnrs
            if (r5 == 0) goto L_0x002f
            r3.writeApplicationExitInfoEventIfRelevant(r1)
            goto L_0x0038
        L_0x002f:
            com.google.firebase.crashlytics.internal.Logger r5 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.String r2 = "ANR feature disabled."
            r5.v(r2)
        L_0x0038:
            com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent r5 = r3.nativeComponent
            boolean r5 = r5.hasCrashDataForSession(r1)
            if (r5 == 0) goto L_0x0043
            r3.finalizePreviousNativeSession(r1)
        L_0x0043:
            r5 = 0
            if (r4 == 0) goto L_0x004e
            r4 = 0
            java.lang.Object r4 = r0.get(r4)
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5
        L_0x004e:
            com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator r4 = r3.reportingCoordinator
            long r0 = getCurrentTimestampSeconds()
            r4.finalizeSessions(r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.CrashlyticsController.doCloseSessions(boolean, com.google.firebase.crashlytics.internal.settings.SettingsProvider):void");
    }

    /* access modifiers changed from: package-private */
    public List<File> listAppExceptionMarkerFiles() {
        return this.fileStore.getCommonFiles(APP_EXCEPTION_MARKER_FILTER);
    }

    private void finalizePreviousNativeSession(String str) {
        Logger logger = Logger.getLogger();
        logger.v("Finalizing native report for session " + str);
        NativeSessionFileProvider sessionFileProvider = this.nativeComponent.getSessionFileProvider(str);
        File minidumpFile = sessionFileProvider.getMinidumpFile();
        if (minidumpFile == null || !minidumpFile.exists()) {
            Logger logger2 = Logger.getLogger();
            logger2.w("No minidump data found for session " + str);
            return;
        }
        long lastModified = minidumpFile.lastModified();
        LogFileManager logFileManager2 = new LogFileManager(this.fileStore, str);
        File nativeSessionDir = this.fileStore.getNativeSessionDir(str);
        if (!nativeSessionDir.isDirectory()) {
            Logger.getLogger().w("Couldn't create directory to store native session files, aborting.");
            return;
        }
        doWriteAppExceptionMarker(lastModified);
        List<NativeSessionFile> nativeSessionFiles = getNativeSessionFiles(sessionFileProvider, str, this.fileStore, logFileManager2.getBytesForLog());
        NativeSessionFileGzipper.processNativeSessions(nativeSessionDir, nativeSessionFiles);
        Logger.getLogger().d("CrashlyticsController#finalizePreviousNativeSession");
        this.reportingCoordinator.finalizeSessionWithNativeEvent(str, nativeSessionFiles);
        logFileManager2.clearLog();
    }

    private static long getCurrentTimestampSeconds() {
        return getTimestampSeconds(System.currentTimeMillis());
    }

    /* access modifiers changed from: private */
    public static long getTimestampSeconds(long j) {
        return j / 1000;
    }

    /* access modifiers changed from: private */
    public void doWriteAppExceptionMarker(long j) {
        try {
            FileStore fileStore2 = this.fileStore;
            if (!fileStore2.getCommonFile(APP_EXCEPTION_MARKER_PREFIX + j).createNewFile()) {
                throw new IOException("Create new file failed.");
            }
        } catch (IOException e) {
            Logger.getLogger().w("Could not create app exception marker file.", e);
        }
    }

    private static StaticSessionData.AppData createAppData(IdManager idManager2, AppData appData2) {
        return StaticSessionData.AppData.create(idManager2.getAppIdentifier(), appData2.versionCode, appData2.versionName, idManager2.getCrashlyticsInstallId(), DeliveryMechanism.determineFrom(appData2.installerPackageName).getId(), appData2.developmentPlatformProvider);
    }

    private static StaticSessionData.OsData createOsData() {
        return StaticSessionData.OsData.create(Build.VERSION.RELEASE, Build.VERSION.CODENAME, CommonUtils.isRooted());
    }

    private static StaticSessionData.DeviceData createDeviceData() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return StaticSessionData.DeviceData.create(CommonUtils.getCpuArchitectureInt(), Build.MODEL, Runtime.getRuntime().availableProcessors(), CommonUtils.getTotalRamInBytes(), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), CommonUtils.isEmulator(), CommonUtils.getDeviceState(), Build.MANUFACTURER, Build.PRODUCT);
    }

    /* access modifiers changed from: package-private */
    public UserMetadata getUserMetadata() {
        return this.userMetadata;
    }

    /* access modifiers changed from: package-private */
    public boolean isHandlingException() {
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = this.crashHandler;
        return crashlyticsUncaughtExceptionHandler != null && crashlyticsUncaughtExceptionHandler.isHandlingException();
    }

    /* access modifiers changed from: private */
    public Task<Void> logAnalyticsAppExceptionEvents() {
        ArrayList arrayList = new ArrayList();
        for (File next : listAppExceptionMarkerFiles()) {
            try {
                arrayList.add(logAnalyticsAppExceptionEvent(Long.parseLong(next.getName().substring(3))));
            } catch (NumberFormatException unused) {
                Logger logger = Logger.getLogger();
                logger.w("Could not parse app exception timestamp from file " + next.getName());
            }
            next.delete();
        }
        return Tasks.whenAll((Collection<? extends Task<?>>) arrayList);
    }

    private Task<Void> logAnalyticsAppExceptionEvent(final long j) {
        if (firebaseCrashExists()) {
            Logger.getLogger().w("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return Tasks.forResult(null);
        }
        Logger.getLogger().d("Logging app exception event to Firebase Analytics");
        return Tasks.call(new ScheduledThreadPoolExecutor(1), new Callable<Void>() {
            public Void call() throws Exception {
                Bundle bundle = new Bundle();
                bundle.putInt(CrashlyticsController.FIREBASE_CRASH_TYPE, 1);
                bundle.putLong("timestamp", j);
                CrashlyticsController.this.analyticsEventLogger.logEvent(CrashlyticsController.FIREBASE_APPLICATION_EXCEPTION, bundle);
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public static void deleteFiles(List<File> list) {
        for (File delete : list) {
            delete.delete();
        }
    }

    private static boolean firebaseCrashExists() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    static List<NativeSessionFile> getNativeSessionFiles(NativeSessionFileProvider nativeSessionFileProvider, String str, FileStore fileStore2, byte[] bArr) {
        File sessionFile = fileStore2.getSessionFile(str, UserMetadata.USERDATA_FILENAME);
        File sessionFile2 = fileStore2.getSessionFile(str, UserMetadata.KEYDATA_FILENAME);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BytesBackedNativeSessionFile("logs_file", "logs", bArr));
        arrayList.add(new FileBackedNativeSessionFile("crash_meta_file", "metadata", nativeSessionFileProvider.getMetadataFile()));
        arrayList.add(new FileBackedNativeSessionFile("session_meta_file", "session", nativeSessionFileProvider.getSessionFile()));
        arrayList.add(new FileBackedNativeSessionFile("app_meta_file", "app", nativeSessionFileProvider.getAppFile()));
        arrayList.add(new FileBackedNativeSessionFile("device_meta_file", "device", nativeSessionFileProvider.getDeviceFile()));
        arrayList.add(new FileBackedNativeSessionFile("os_meta_file", "os", nativeSessionFileProvider.getOsFile()));
        arrayList.add(new FileBackedNativeSessionFile("minidump_file", "minidump", nativeSessionFileProvider.getMinidumpFile()));
        arrayList.add(new FileBackedNativeSessionFile("user_meta_file", "user", sessionFile));
        arrayList.add(new FileBackedNativeSessionFile("keys_file", UserMetadata.KEYDATA_FILENAME, sessionFile2));
        return arrayList;
    }

    private void writeApplicationExitInfoEventIfRelevant(String str) {
        if (Build.VERSION.SDK_INT >= 30) {
            List historicalProcessExitReasons = ((ActivityManager) this.context.getSystemService("activity")).getHistoricalProcessExitReasons((String) null, 0, 0);
            if (historicalProcessExitReasons.size() != 0) {
                this.reportingCoordinator.persistRelevantAppExitInfoEvent(str, historicalProcessExitReasons, new LogFileManager(this.fileStore, str), UserMetadata.loadFromExistingSession(str, this.fileStore, this.backgroundWorker));
                return;
            }
            Logger logger = Logger.getLogger();
            logger.v("No ApplicationExitInfo available. Session: " + str);
            return;
        }
        Logger logger2 = Logger.getLogger();
        logger2.v("ANR feature enabled, but device is API " + Build.VERSION.SDK_INT);
    }
}
