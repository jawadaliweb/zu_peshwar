package com.google.firebase.remoteconfig;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.ConfigRealtimeHandler;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import com.google.firebase.remoteconfig.internal.Personalization;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

public class RemoteConfigComponent {
    public static final String ACTIVATE_FILE_NAME = "activate";
    public static final long CONNECTION_TIMEOUT_IN_SECONDS = 60;
    public static final String DEFAULTS_FILE_NAME = "defaults";
    private static final Clock DEFAULT_CLOCK = DefaultClock.getInstance();
    public static final String DEFAULT_NAMESPACE = "firebase";
    private static final Random DEFAULT_RANDOM = new Random();
    public static final String FETCH_FILE_NAME = "fetch";
    private static final String FIREBASE_REMOTE_CONFIG_FILE_NAME_PREFIX = "frc";
    private static final String PREFERENCES_FILE_NAME = "settings";
    private static final Map<String, FirebaseRemoteConfig> frcNamespaceInstancesStatic = new HashMap();
    private final Provider<AnalyticsConnector> analyticsConnector;
    private final String appId;
    private final Context context;
    private Map<String, String> customHeaders;
    private final ScheduledExecutorService executor;
    private final FirebaseABTesting firebaseAbt;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Map<String, FirebaseRemoteConfig> frcNamespaceInstances;

    static /* synthetic */ AnalyticsConnector lambda$getFetchHandler$0() {
        return null;
    }

    RemoteConfigComponent(Context context2, ScheduledExecutorService scheduledExecutorService, FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Provider<AnalyticsConnector> provider) {
        this(context2, scheduledExecutorService, firebaseApp2, firebaseInstallationsApi, firebaseABTesting, provider, true);
    }

    protected RemoteConfigComponent(Context context2, ScheduledExecutorService scheduledExecutorService, FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Provider<AnalyticsConnector> provider, boolean z) {
        this.frcNamespaceInstances = new HashMap();
        this.customHeaders = new HashMap();
        this.context = context2;
        this.executor = scheduledExecutorService;
        this.firebaseApp = firebaseApp2;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.firebaseAbt = firebaseABTesting;
        this.analyticsConnector = provider;
        this.appId = firebaseApp2.getOptions().getApplicationId();
        GlobalBackgroundListener.ensureBackgroundListenerIsRegistered(context2);
        if (z) {
            Tasks.call(scheduledExecutorService, new Callable() {
                public final Object call() {
                    return RemoteConfigComponent.this.getDefault();
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public FirebaseRemoteConfig getDefault() {
        return get("firebase");
    }

    public synchronized FirebaseRemoteConfig get(String str) {
        ConfigCacheClient cacheClient;
        ConfigCacheClient cacheClient2;
        ConfigCacheClient cacheClient3;
        ConfigMetadataClient metadataClient;
        ConfigGetParameterHandler getHandler;
        cacheClient = getCacheClient(str, FETCH_FILE_NAME);
        cacheClient2 = getCacheClient(str, ACTIVATE_FILE_NAME);
        cacheClient3 = getCacheClient(str, DEFAULTS_FILE_NAME);
        metadataClient = getMetadataClient(this.context, this.appId, str);
        getHandler = getGetHandler(cacheClient2, cacheClient3);
        Personalization personalization = getPersonalization(this.firebaseApp, str, this.analyticsConnector);
        if (personalization != null) {
            Objects.requireNonNull(personalization);
            getHandler.addListener(new BiConsumer() {
                public final void accept(Object obj, Object obj2) {
                    Personalization.this.logArmActive((String) obj, (ConfigContainer) obj2);
                }
            });
        }
        return get(this.firebaseApp, str, this.firebaseInstallations, this.firebaseAbt, this.executor, cacheClient, cacheClient2, cacheClient3, getFetchHandler(str, cacheClient, metadataClient), getHandler, metadataClient);
    }

    /* access modifiers changed from: package-private */
    public synchronized FirebaseRemoteConfig get(FirebaseApp firebaseApp2, String str, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor2, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient) {
        FirebaseRemoteConfig firebaseRemoteConfig;
        String str2 = str;
        synchronized (this) {
            if (!this.frcNamespaceInstances.containsKey(str2)) {
                Context context2 = this.context;
                FirebaseABTesting firebaseABTesting2 = isAbtSupported(firebaseApp2, str) ? firebaseABTesting : null;
                FirebaseRemoteConfig firebaseRemoteConfig2 = r10;
                FirebaseRemoteConfig firebaseRemoteConfig3 = new FirebaseRemoteConfig(context2, firebaseApp2, firebaseInstallationsApi, firebaseABTesting2, executor2, configCacheClient, configCacheClient2, configCacheClient3, configFetchHandler, configGetParameterHandler, configMetadataClient, getRealtime(firebaseApp2, firebaseInstallationsApi, configFetchHandler, configCacheClient2, this.context, str, configMetadataClient));
                firebaseRemoteConfig2.startLoadingConfigsFromDisk();
                this.frcNamespaceInstances.put(str2, firebaseRemoteConfig2);
                frcNamespaceInstancesStatic.put(str2, firebaseRemoteConfig2);
            }
            firebaseRemoteConfig = this.frcNamespaceInstances.get(str2);
        }
        return firebaseRemoteConfig;
    }

    public synchronized void setCustomHeaders(Map<String, String> map) {
        this.customHeaders = map;
    }

    private ConfigCacheClient getCacheClient(String str, String str2) {
        return ConfigCacheClient.getInstance(this.executor, ConfigStorageClient.getInstance(this.context, String.format("%s_%s_%s_%s.json", new Object[]{"frc", this.appId, str, str2})));
    }

    /* access modifiers changed from: package-private */
    public ConfigFetchHttpClient getFrcBackendApiClient(String str, String str2, ConfigMetadataClient configMetadataClient) {
        return new ConfigFetchHttpClient(this.context, this.firebaseApp.getOptions().getApplicationId(), str, str2, configMetadataClient.getFetchTimeoutInSeconds(), configMetadataClient.getFetchTimeoutInSeconds());
    }

    /* access modifiers changed from: package-private */
    public synchronized ConfigFetchHandler getFetchHandler(String str, ConfigCacheClient configCacheClient, ConfigMetadataClient configMetadataClient) {
        return new ConfigFetchHandler(this.firebaseInstallations, isPrimaryApp(this.firebaseApp) ? this.analyticsConnector : $$Lambda$RemoteConfigComponent$USEUB2rdY7rQSucdXyvQR4z8Fg.INSTANCE, this.executor, DEFAULT_CLOCK, DEFAULT_RANDOM, configCacheClient, getFrcBackendApiClient(this.firebaseApp.getOptions().getApiKey(), str, configMetadataClient), configMetadataClient, this.customHeaders);
    }

    /* access modifiers changed from: package-private */
    public synchronized ConfigRealtimeHandler getRealtime(FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Context context2, String str, ConfigMetadataClient configMetadataClient) {
        ConfigRealtimeHandler configRealtimeHandler;
        synchronized (this) {
            configRealtimeHandler = new ConfigRealtimeHandler(firebaseApp2, firebaseInstallationsApi, configFetchHandler, configCacheClient, context2, str, configMetadataClient, this.executor);
        }
        return configRealtimeHandler;
    }

    private ConfigGetParameterHandler getGetHandler(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        return new ConfigGetParameterHandler(this.executor, configCacheClient, configCacheClient2);
    }

    static ConfigMetadataClient getMetadataClient(Context context2, String str, String str2) {
        return new ConfigMetadataClient(context2.getSharedPreferences(String.format("%s_%s_%s_%s", new Object[]{"frc", str, str2, PREFERENCES_FILE_NAME}), 0));
    }

    private static Personalization getPersonalization(FirebaseApp firebaseApp2, String str, Provider<AnalyticsConnector> provider) {
        if (!isPrimaryApp(firebaseApp2) || !str.equals("firebase")) {
            return null;
        }
        return new Personalization(provider);
    }

    private static boolean isAbtSupported(FirebaseApp firebaseApp2, String str) {
        return str.equals("firebase") && isPrimaryApp(firebaseApp2);
    }

    private static boolean isPrimaryApp(FirebaseApp firebaseApp2) {
        return firebaseApp2.getName().equals(FirebaseApp.DEFAULT_APP_NAME);
    }

    /* access modifiers changed from: private */
    public static synchronized void notifyRCInstances(boolean z) {
        synchronized (RemoteConfigComponent.class) {
            for (FirebaseRemoteConfig configUpdateBackgroundState : frcNamespaceInstancesStatic.values()) {
                configUpdateBackgroundState.setConfigUpdateBackgroundState(z);
            }
        }
    }

    private static class GlobalBackgroundListener implements BackgroundDetector.BackgroundStateChangeListener {
        private static final AtomicReference<GlobalBackgroundListener> INSTANCE = new AtomicReference<>();

        private GlobalBackgroundListener() {
        }

        /* access modifiers changed from: private */
        public static void ensureBackgroundListenerIsRegistered(Context context) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference<GlobalBackgroundListener> atomicReference = INSTANCE;
            if (atomicReference.get() == null) {
                GlobalBackgroundListener globalBackgroundListener = new GlobalBackgroundListener();
                if (atomicReference.compareAndSet((Object) null, globalBackgroundListener)) {
                    BackgroundDetector.initialize(application);
                    BackgroundDetector.getInstance().addListener(globalBackgroundListener);
                }
            }
        }

        public void onBackgroundStateChanged(boolean z) {
            RemoteConfigComponent.notifyRCInstances(z);
        }
    }
}
