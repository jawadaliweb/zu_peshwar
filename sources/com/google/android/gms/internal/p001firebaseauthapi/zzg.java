package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzg extends zzf {
    private final char zza;

    zzg(char c) {
        this.zza = c;
    }

    public final String toString() {
        int i = this.zza;
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(i & 15);
            i >>= 4;
        }
        String copyValueOf = String.copyValueOf(cArr);
        return "CharMatcher.is('" + copyValueOf + "')";
    }

    public final boolean zza(char c) {
        return c == this.zza;
    }
}
