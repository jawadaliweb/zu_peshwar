package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzjm implements zzjb {
    private final zziw zza;

    zzjm(zziw zziw) {
        this.zza = zziw;
    }

    public final byte[] zza(byte[] bArr, zzjc zzjc) throws GeneralSecurityException {
        byte[] zza2 = zzvv.zza(zzjc.zza().zzc(), bArr);
        byte[] zzb = zzum.zzb(bArr, zzjc.zzb().zzc());
        byte[] zzd = zzjj.zzd(zzjj.zzb);
        zziw zziw = this.zza;
        return zziw.zzb((byte[]) null, zza2, "eae_prk", zzb, "shared_secret", zzd, zziw.zza());
    }

    public final byte[] zzb() throws GeneralSecurityException {
        if (Arrays.equals(this.zza.zzc(), zzjj.zzf)) {
            return zzjj.zzb;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
