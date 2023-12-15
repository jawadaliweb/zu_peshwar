package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzjk implements zzjb {
    private final zziw zza;
    private final int zzb;

    private zzjk(zziw zziw, int i) {
        this.zza = zziw;
        this.zzb = i;
    }

    static zzjk zzc(int i) throws GeneralSecurityException {
        int i2 = i - 1;
        if (i2 == 0) {
            return new zzjk(new zziw("HmacSha256"), 1);
        }
        if (i2 != 1) {
            return new zzjk(new zziw("HmacSha512"), 3);
        }
        return new zzjk(new zziw("HmacSha384"), 2);
    }

    public final byte[] zza(byte[] bArr, zzjc zzjc) throws GeneralSecurityException {
        byte[] zzf = zzut.zzf(zzut.zzg(this.zzb, zzjc.zza().zzc()), zzut.zzh(zzut.zzi(this.zzb), 1, bArr));
        byte[] zzb2 = zzum.zzb(bArr, zzjc.zzb().zzc());
        byte[] zzd = zzjj.zzd(zzb());
        zziw zziw = this.zza;
        return zziw.zzb((byte[]) null, zzf, "eae_prk", zzb2, "shared_secret", zzd, zziw.zza());
    }

    public final byte[] zzb() throws GeneralSecurityException {
        int i = this.zzb - 1;
        if (i == 0) {
            return zzjj.zzc;
        }
        if (i != 1) {
            return zzjj.zze;
        }
        return zzjj.zzd;
    }
}
