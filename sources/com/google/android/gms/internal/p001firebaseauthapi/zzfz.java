package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzfz extends zzcw {
    private final zzfy zza;

    private zzfz(zzfy zzfy) {
        this.zza = zzfy;
    }

    public static zzfz zzb(zzfy zzfy) {
        return new zzfz(zzfy);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzfz) && ((zzfz) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzfz.class, this.zza});
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "ChaCha20Poly1305 Parameters (variant: " + obj + ")";
    }

    public final zzfy zza() {
        return this.zza;
    }
}
