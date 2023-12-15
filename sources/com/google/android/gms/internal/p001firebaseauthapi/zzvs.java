package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvs  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzvs {
    private static final ThreadLocal zza = new zzvr();

    public static byte[] zza(int i) {
        byte[] bArr = new byte[i];
        ((SecureRandom) zza.get()).nextBytes(bArr);
        return bArr;
    }
}
