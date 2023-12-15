package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcs  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzcs {
    public static final Charset zza = Charset.forName("UTF-8");

    public static zzth zza(zztc zztc) {
        zzte zza2 = zzth.zza();
        zza2.zzb(zztc.zzb());
        for (zztb zztb : zztc.zzh()) {
            zztf zzb = zztg.zzb();
            zzb.zzc(zztb.zzb().zzf());
            zzb.zzd(zztb.zzk());
            zzb.zzb(zztb.zze());
            zzb.zza(zztb.zza());
            zza2.zza((zztg) zzb.zzi());
        }
        return (zzth) zza2.zzi();
    }
}
