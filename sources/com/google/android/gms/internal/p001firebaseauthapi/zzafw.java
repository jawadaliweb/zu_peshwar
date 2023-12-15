package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzafw {
    private final Object zza;
    private final int zzb;

    zzafw(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzafw)) {
            return false;
        }
        zzafw zzafw = (zzafw) obj;
        if (this.zza == zzafw.zza && this.zzb == zzafw.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
