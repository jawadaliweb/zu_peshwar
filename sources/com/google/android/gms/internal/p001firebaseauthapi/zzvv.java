package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.InvalidKeyException;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzvv {
    public static byte[] zza(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        if (bArr.length == 32) {
            long[] jArr = new long[11];
            byte[] copyOf = Arrays.copyOf(bArr, 32);
            copyOf[0] = (byte) (copyOf[0] & 248);
            byte b = copyOf[31] & ByteCompanionObject.MAX_VALUE;
            copyOf[31] = (byte) b;
            copyOf[31] = (byte) (b | 64);
            zzjw.zza(jArr, copyOf, bArr2);
            return zzjy.zzj(jArr);
        }
        throw new InvalidKeyException("Private key must have 32 bytes.");
    }

    public static byte[] zzb(byte[] bArr) throws InvalidKeyException {
        if (bArr.length == 32) {
            byte[] bArr2 = new byte[32];
            bArr2[0] = 9;
            return zza(bArr, bArr2);
        }
        throw new InvalidKeyException("Private key must have 32 bytes.");
    }
}
