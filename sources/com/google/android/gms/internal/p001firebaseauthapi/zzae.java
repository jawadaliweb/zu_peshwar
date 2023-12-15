package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzae  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzae {
    static void zza(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(String.valueOf(obj2))));
        } else if (obj2 == null) {
            String obj3 = obj.toString();
            throw new NullPointerException("null value in entry: " + obj3 + "=null");
        }
    }
}
