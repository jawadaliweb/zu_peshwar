package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzjd {
    static zzix zza(zzse zzse) throws GeneralSecurityException {
        if (zzse.zzd() == 3) {
            return new zziu(16);
        }
        if (zzse.zzd() == 4) {
            return new zziu(32);
        }
        if (zzse.zzd() == 5) {
            return new zziv();
        }
        throw new IllegalArgumentException("Unrecognized HPKE AEAD identifier");
    }

    static zzjb zzb(zzse zzse) throws GeneralSecurityException {
        if (zzse.zzf() == 3) {
            return new zzjm(new zziw("HmacSha256"));
        }
        if (zzse.zzf() == 4) {
            return zzjk.zzc(1);
        }
        if (zzse.zzf() == 5) {
            return zzjk.zzc(2);
        }
        if (zzse.zzf() == 6) {
            return zzjk.zzc(3);
        }
        throw new IllegalArgumentException("Unrecognized HPKE KEM identifier");
    }

    static zziw zzc(zzse zzse) {
        if (zzse.zze() == 3) {
            return new zziw("HmacSha256");
        }
        if (zzse.zze() == 4) {
            return new zziw("HmacSha384");
        }
        if (zzse.zze() == 5) {
            return new zziw("HmacSha512");
        }
        throw new IllegalArgumentException("Unrecognized HPKE KDF identifier");
    }
}
