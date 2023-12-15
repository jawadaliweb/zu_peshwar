package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzacb {
    public static String zza(String str) {
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
            if (invoke != null && String.class.isAssignableFrom(invoke.getClass())) {
                return (String) invoke;
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
