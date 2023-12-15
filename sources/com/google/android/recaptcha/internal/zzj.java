package com.google.android.recaptcha.internal;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzj {
    public static final zzj zza = new zzj();
    private static final ConcurrentHashMap zzb = new ConcurrentHashMap();

    private zzj() {
    }

    public static final void zza(int i, long j) {
        ConcurrentHashMap concurrentHashMap = zzb;
        Integer valueOf = Integer.valueOf(i);
        Object obj = concurrentHashMap.get(valueOf);
        if (obj == null) {
            obj = new zzi();
        }
        zzi zzi = (zzi) obj;
        zzi.zzg(zzi.zzb() + 1);
        zzi.zzf(zzi.zzd() + j);
        zzi.zze(Math.max(j, zzi.zzc()));
        concurrentHashMap.put(valueOf, zzi);
    }
}
