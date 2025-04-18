package com.google.android.gms.internal.p001firebaseauthapi;

import kotlin.UByte;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzvl {
    public static String zza(byte[] bArr) {
        StringBuilder sb = new StringBuilder(r1 + r1);
        for (byte b : bArr) {
            byte b2 = b & UByte.MAX_VALUE;
            sb.append("0123456789abcdef".charAt(b2 >> 4));
            sb.append("0123456789abcdef".charAt(b2 & 15));
        }
        return sb.toString();
    }
}
