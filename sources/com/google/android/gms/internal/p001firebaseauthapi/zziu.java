package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zziu implements zzix {
    private final int zza;

    zziu(int i) throws InvalidAlgorithmParameterException {
        if (i == 16 || i == 32) {
            this.zza = i;
            return;
        }
        throw new InvalidAlgorithmParameterException("Unsupported key length: " + i);
    }

    public final int zza() {
        return this.zza;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        int length = bArr.length;
        if (length == this.zza) {
            return new zzgz(bArr, false).zza(bArr2, bArr3, bArr4);
        }
        throw new InvalidAlgorithmParameterException("Unexpected key length: " + length);
    }

    public final byte[] zzb() throws GeneralSecurityException {
        int i = this.zza;
        if (i == 16) {
            return zzjj.zzi;
        }
        if (i == 32) {
            return zzjj.zzj;
        }
        throw new GeneralSecurityException("Could not determine HPKE AEAD ID");
    }
}
