package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.InvalidKeyException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzha  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzha extends zzhb {
    public zzha(byte[] bArr, int i) throws InvalidKeyException {
        super(bArr, i);
    }

    public final int zza() {
        return 12;
    }

    public final int[] zzb(int[] iArr, int i) {
        int length = iArr.length;
        if (length == 3) {
            int[] iArr2 = new int[16];
            zzgx.zzb(iArr2, this.zza);
            iArr2[12] = i;
            System.arraycopy(iArr, 0, iArr2, 13, 3);
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", new Object[]{Integer.valueOf(length * 32)}));
    }
}
