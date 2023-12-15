package com.google.android.gms.internal.p001firebaseauthapi;

import java.math.BigInteger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzjv {
    public static byte[] zza(BigInteger bigInteger) {
        if (bigInteger.signum() != -1) {
            return bigInteger.toByteArray();
        }
        throw new IllegalArgumentException("n must not be negative");
    }
}
