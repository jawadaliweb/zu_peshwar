package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzct  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzct {
    public static final String zza = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    public static final String zzb = "type.googleapis.com/google.crypto.tink.AesGcmKey";
    @Deprecated
    static final zzty zzc;
    @Deprecated
    static final zzty zzd;
    @Deprecated
    static final zzty zze;

    static {
        new zzdg();
        new zzes();
        new zzfj();
        new zzeb();
        new zzgh();
        new zzgl();
        new zzfx();
        new zzgp();
        zzty zzb2 = zzty.zzb();
        zzc = zzb2;
        zzd = zzb2;
        zze = zzb2;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzcz.zze();
        zzno.zza();
        zzcq.zzi(new zzdg(), true);
        int i = zzdr.zza;
        zzdr.zza(zzkt.zzb());
        zzcq.zzi(new zzes(), true);
        int i2 = zzfc.zza;
        zzfc.zza(zzkt.zzb());
        if (!zzhk.zzb()) {
            zzcq.zzi(new zzeb(), true);
            int i3 = zzel.zza;
            zzel.zza(zzkt.zzb());
            zzfj.zzg(true);
            zzcq.zzi(new zzfx(), true);
            int i4 = zzge.zza;
            zzge.zza(zzkt.zzb());
            zzcq.zzi(new zzgh(), true);
            zzcq.zzi(new zzgl(), true);
            zzcq.zzi(new zzgp(), true);
            int i5 = zzgw.zza;
            zzgw.zza(zzkt.zzb());
        }
    }
}
