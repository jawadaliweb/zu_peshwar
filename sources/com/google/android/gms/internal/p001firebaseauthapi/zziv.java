package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zziv implements zzix {
    zziv() {
    }

    public final int zza() {
        return 32;
    }

    public final byte[] zzb() {
        return zzjj.zzk;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length == 32) {
            return new zzhc(bArr).zzc(bArr2, bArr3, bArr4);
        }
        throw new InvalidAlgorithmParameterException("Unexpected key length: 32");
    }
}
