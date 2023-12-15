package com.google.android.gms.internal.p001firebaseauthapi;

import androidx.collection.ArrayMap;
import com.google.firebase.FirebaseApp;
import com.microsoft.appcenter.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzace  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzace {
    private static final Map zza = new ArrayMap();
    private static final Map zzb = new ArrayMap();

    public static String zza(String str) {
        zzacc zzacc;
        Map map = zza;
        synchronized (map) {
            zzacc = (zzacc) map.get(str);
        }
        if (zzacc != null) {
            return zzh(zzacc.zzb(), zzacc.zza(), zzacc.zzb().contains(Constants.COMMON_SCHEMA_PREFIX_SEPARATOR)).concat("emulator/auth/handler");
        }
        throw new IllegalStateException("Tried to get the emulator widget endpoint, but no emulator endpoint overrides found.");
    }

    public static String zzb(String str) {
        zzacc zzacc;
        Map map = zza;
        synchronized (map) {
            zzacc = (zzacc) map.get(str);
        }
        return (zzacc != null ? "".concat(zzh(zzacc.zzb(), zzacc.zza(), zzacc.zzb().contains(Constants.COMMON_SCHEMA_PREFIX_SEPARATOR))) : "https://").concat("www.googleapis.com/identitytoolkit/v3/relyingparty");
    }

    public static String zzc(String str) {
        zzacc zzacc;
        Map map = zza;
        synchronized (map) {
            zzacc = (zzacc) map.get(str);
        }
        return (zzacc != null ? "".concat(zzh(zzacc.zzb(), zzacc.zza(), zzacc.zzb().contains(Constants.COMMON_SCHEMA_PREFIX_SEPARATOR))) : "https://").concat("identitytoolkit.googleapis.com/v2");
    }

    public static String zzd(String str) {
        zzacc zzacc;
        Map map = zza;
        synchronized (map) {
            zzacc = (zzacc) map.get(str);
        }
        return (zzacc != null ? "".concat(zzh(zzacc.zzb(), zzacc.zza(), zzacc.zzb().contains(Constants.COMMON_SCHEMA_PREFIX_SEPARATOR))) : "https://").concat("securetoken.googleapis.com/v1");
    }

    public static void zze(String str, zzacd zzacd) {
        Map map = zzb;
        synchronized (map) {
            if (map.containsKey(str)) {
                ((List) map.get(str)).add(new WeakReference(zzacd));
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new WeakReference(zzacd));
                map.put(str, arrayList);
            }
        }
    }

    public static void zzf(FirebaseApp firebaseApp, String str, int i) {
        String apiKey = firebaseApp.getOptions().getApiKey();
        Map map = zza;
        synchronized (map) {
            map.put(apiKey, new zzacc(str, i));
        }
        Map map2 = zzb;
        synchronized (map2) {
            if (map2.containsKey(apiKey)) {
                boolean z = false;
                for (WeakReference weakReference : (List) map2.get(apiKey)) {
                    zzacd zzacd = (zzacd) weakReference.get();
                    if (zzacd != null) {
                        zzacd.zzi();
                        z = true;
                    }
                }
                if (!z) {
                    zza.remove(apiKey);
                }
            }
        }
    }

    public static boolean zzg(FirebaseApp firebaseApp) {
        return zza.containsKey(firebaseApp.getOptions().getApiKey());
    }

    private static String zzh(String str, int i, boolean z) {
        if (z) {
            return "http://[" + str + "]:" + i + "/";
        }
        return "http://" + str + Constants.COMMON_SCHEMA_PREFIX_SEPARATOR + i + "/";
    }
}
