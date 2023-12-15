package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzgr extends zzcw {
    private final zzgq zza;

    private zzgr(zzgq zzgq) {
        this.zza = zzgq;
    }

    public static zzgr zzb(zzgq zzgq) {
        return new zzgr(zzgq);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzgr) && ((zzgr) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgr.class, this.zza});
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "XChaCha20Poly1305 Parameters (variant: " + obj + ")";
    }

    public final zzgq zza() {
        return this.zza;
    }
}
