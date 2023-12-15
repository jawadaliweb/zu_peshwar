package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzir  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzir {
    public static final zzsu zza;
    public static final zzsu zzb;
    public static final zzsu zzc;
    private static final byte[] zzd;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        byte[] bArr2 = bArr;
        zza = zza(4, 5, 3, zzcv.zza, zztv.TINK, bArr2);
        zzb = zza(4, 5, 4, zzcv.zza, zztv.RAW, bArr2);
        zzc = zza(4, 5, 3, zzcv.zze, zztv.TINK, bArr2);
    }

    public static zzsu zza(int i, int i2, int i3, zzsu zzsu, zztv zztv, byte[] bArr) {
        zzqt zza2 = zzqu.zza();
        zzrf zza3 = zzrg.zza();
        zza3.zzb(4);
        zza3.zzc(5);
        zza3.zza(zzaff.zzn(bArr, 0, 0));
        zzqq zza4 = zzqr.zza();
        zza4.zza(zzsu);
        zzqw zzb2 = zzqx.zzb();
        zzb2.zzb((zzrg) zza3.zzi());
        zzb2.zza((zzqr) zza4.zzi());
        zzb2.zzc(i3);
        zza2.zza((zzqx) zzb2.zzi());
        zzst zza5 = zzsu.zza();
        new zzij();
        zza5.zzb("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
        zza5.zza(zztv);
        zza5.zzc(((zzqu) zza2.zzi()).zzo());
        return (zzsu) zza5.zzi();
    }
}
