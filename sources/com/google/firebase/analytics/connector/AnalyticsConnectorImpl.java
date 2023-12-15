package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzef;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzha;
import com.google.android.gms.measurement.internal.zzip;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zza;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.2.2 */
public class AnalyticsConnectorImpl implements AnalyticsConnector {
    private static volatile AnalyticsConnector zzc;
    final AppMeasurementSdk zza;
    final Map zzb = new ConcurrentHashMap();

    AnalyticsConnectorImpl(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.checkNotNull(appMeasurementSdk);
        this.zza = appMeasurementSdk;
    }

    public static AnalyticsConnector getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    static /* synthetic */ void zza(Event event) {
        boolean z = ((DataCollectionDefaultChange) event.getPayload()).enabled;
        synchronized (AnalyticsConnectorImpl.class) {
            ((AnalyticsConnectorImpl) Preconditions.checkNotNull(zzc)).zza.zza(z);
        }
    }

    /* access modifiers changed from: private */
    public final boolean zzc(String str) {
        return !str.isEmpty() && this.zzb.containsKey(str) && this.zzb.get(str) != null;
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (str2 == null || zzc.zzb(str2, bundle)) {
            this.zza.clearConditionalUserProperty(str, str2, bundle);
        }
    }

    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (Bundle next : this.zza.getConditionalUserProperties(str, str2)) {
            int i = zzc.zza;
            Preconditions.checkNotNull(next);
            AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
            conditionalUserProperty.origin = (String) Preconditions.checkNotNull((String) zzha.zza(next, "origin", String.class, (Object) null));
            conditionalUserProperty.name = (String) Preconditions.checkNotNull((String) zzha.zza(next, "name", String.class, (Object) null));
            conditionalUserProperty.value = zzha.zza(next, "value", Object.class, (Object) null);
            conditionalUserProperty.triggerEventName = (String) zzha.zza(next, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, (Object) null);
            conditionalUserProperty.triggerTimeout = ((Long) zzha.zza(next, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L)).longValue();
            conditionalUserProperty.timedOutEventName = (String) zzha.zza(next, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, (Object) null);
            conditionalUserProperty.timedOutEventParams = (Bundle) zzha.zza(next, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, (Object) null);
            conditionalUserProperty.triggeredEventName = (String) zzha.zza(next, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, (Object) null);
            conditionalUserProperty.triggeredEventParams = (Bundle) zzha.zza(next, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, (Object) null);
            conditionalUserProperty.timeToLive = ((Long) zzha.zza(next, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L)).longValue();
            conditionalUserProperty.expiredEventName = (String) zzha.zza(next, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, (Object) null);
            conditionalUserProperty.expiredEventParams = (Bundle) zzha.zza(next, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, (Object) null);
            conditionalUserProperty.active = ((Boolean) zzha.zza(next, AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.class, false)).booleanValue();
            conditionalUserProperty.creationTimestamp = ((Long) zzha.zza(next, AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.class, 0L)).longValue();
            conditionalUserProperty.triggeredTimestamp = ((Long) zzha.zza(next, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.class, 0L)).longValue();
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    public int getMaxUserProperties(String str) {
        return this.zza.getMaxUserProperties(str);
    }

    public Map<String, Object> getUserProperties(boolean z) {
        return this.zza.getUserProperties((String) null, (String) null, z);
    }

    public void logEvent(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzc.zzd(str) && zzc.zzb(str2, bundle) && zzc.zza(str, str2, bundle)) {
            if ("clx".equals(str) && "_ae".equals(str2)) {
                bundle.putLong("_r", 1);
            }
            this.zza.logEvent(str, str2, bundle);
        }
    }

    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(final String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        Object obj;
        Preconditions.checkNotNull(analyticsConnectorListener);
        if (!zzc.zzd(str) || zzc(str)) {
            return null;
        }
        AppMeasurementSdk appMeasurementSdk = this.zza;
        if ("fiam".equals(str)) {
            obj = new zze(appMeasurementSdk, analyticsConnectorListener);
        } else {
            obj = "clx".equals(str) ? new zzg(appMeasurementSdk, analyticsConnectorListener) : null;
        }
        if (obj == null) {
            return null;
        }
        this.zzb.put(str, obj);
        return new AnalyticsConnector.AnalyticsConnectorHandle() {
            public void registerEventNames(Set<String> set) {
                if (AnalyticsConnectorImpl.this.zzc(str) && str.equals("fiam") && set != null && !set.isEmpty()) {
                    ((zza) AnalyticsConnectorImpl.this.zzb.get(str)).zzb(set);
                }
            }

            public final void unregister() {
                if (AnalyticsConnectorImpl.this.zzc(str)) {
                    AnalyticsConnector.AnalyticsConnectorListener zza2 = ((zza) AnalyticsConnectorImpl.this.zzb.get(str)).zza();
                    if (zza2 != null) {
                        zza2.onMessageTriggered(0, (Bundle) null);
                    }
                    AnalyticsConnectorImpl.this.zzb.remove(str);
                }
            }

            public void unregisterEventNames() {
                if (AnalyticsConnectorImpl.this.zzc(str) && str.equals("fiam")) {
                    ((zza) AnalyticsConnectorImpl.this.zzb.get(str)).zzc();
                }
            }
        };
    }

    public void setConditionalUserProperty(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        String str;
        int i = zzc.zza;
        if (conditionalUserProperty != null && (str = conditionalUserProperty.origin) != null && !str.isEmpty()) {
            if ((conditionalUserProperty.value != null && zzip.zza(conditionalUserProperty.value) == null) || !zzc.zzd(str) || !zzc.zze(str, conditionalUserProperty.name)) {
                return;
            }
            if (conditionalUserProperty.expiredEventName != null && (!zzc.zzb(conditionalUserProperty.expiredEventName, conditionalUserProperty.expiredEventParams) || !zzc.zza(str, conditionalUserProperty.expiredEventName, conditionalUserProperty.expiredEventParams))) {
                return;
            }
            if (conditionalUserProperty.triggeredEventName != null && (!zzc.zzb(conditionalUserProperty.triggeredEventName, conditionalUserProperty.triggeredEventParams) || !zzc.zza(str, conditionalUserProperty.triggeredEventName, conditionalUserProperty.triggeredEventParams))) {
                return;
            }
            if (conditionalUserProperty.timedOutEventName == null || (zzc.zzb(conditionalUserProperty.timedOutEventName, conditionalUserProperty.timedOutEventParams) && zzc.zza(str, conditionalUserProperty.timedOutEventName, conditionalUserProperty.timedOutEventParams))) {
                AppMeasurementSdk appMeasurementSdk = this.zza;
                Bundle bundle = new Bundle();
                if (conditionalUserProperty.origin != null) {
                    bundle.putString("origin", conditionalUserProperty.origin);
                }
                if (conditionalUserProperty.name != null) {
                    bundle.putString("name", conditionalUserProperty.name);
                }
                if (conditionalUserProperty.value != null) {
                    zzha.zzb(bundle, conditionalUserProperty.value);
                }
                if (conditionalUserProperty.triggerEventName != null) {
                    bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, conditionalUserProperty.triggerEventName);
                }
                bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, conditionalUserProperty.triggerTimeout);
                if (conditionalUserProperty.timedOutEventName != null) {
                    bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, conditionalUserProperty.timedOutEventName);
                }
                if (conditionalUserProperty.timedOutEventParams != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, conditionalUserProperty.timedOutEventParams);
                }
                if (conditionalUserProperty.triggeredEventName != null) {
                    bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, conditionalUserProperty.triggeredEventName);
                }
                if (conditionalUserProperty.triggeredEventParams != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, conditionalUserProperty.triggeredEventParams);
                }
                bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, conditionalUserProperty.timeToLive);
                if (conditionalUserProperty.expiredEventName != null) {
                    bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, conditionalUserProperty.expiredEventName);
                }
                if (conditionalUserProperty.expiredEventParams != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, conditionalUserProperty.expiredEventParams);
                }
                bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, conditionalUserProperty.creationTimestamp);
                bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, conditionalUserProperty.active);
                bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, conditionalUserProperty.triggeredTimestamp);
                appMeasurementSdk.setConditionalUserProperty(bundle);
            }
        }
    }

    public void setUserProperty(String str, String str2, Object obj) {
        if (zzc.zzd(str) && zzc.zze(str, str2)) {
            this.zza.setUserProperty(str, str2, obj);
        }
    }

    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp) {
        return (AnalyticsConnector) firebaseApp.get(AnalyticsConnector.class);
    }

    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp, Context context, Subscriber subscriber) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzc == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                if (zzc == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.isDefaultApp()) {
                        subscriber.subscribe(DataCollectionDefaultChange.class, zza.zza, zzb.zza);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                    }
                    zzc = new AnalyticsConnectorImpl(zzef.zzg(context, (String) null, (String) null, (String) null, bundle).zzd());
                }
            }
        }
        return zzc;
    }
}
