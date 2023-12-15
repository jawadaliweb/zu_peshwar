package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzvw implements zzbd {
    private final zzhf zza;

    public zzvw(byte[] bArr) throws GeneralSecurityException {
        this.zza = new zzhf(bArr);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length >= 40) {
            byte[] copyOf = Arrays.copyOf(bArr, 24);
            return this.zza.zzb(ByteBuffer.wrap(bArr, 24, length - 24), copyOf, bArr2);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
