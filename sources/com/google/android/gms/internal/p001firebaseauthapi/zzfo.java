package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzfo extends zzcw {
    private final int zza;
    private final zzfm zzb;

    /* synthetic */ zzfo(int i, zzfm zzfm, zzfn zzfn) {
        this.zza = i;
        this.zzb = zzfm;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfo)) {
            return false;
        }
        zzfo zzfo = (zzfo) obj;
        return zzfo.zza == this.zza && zzfo.zzb == this.zzb;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzfo.class, Integer.valueOf(this.zza), this.zzb});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        int i = this.zza;
        return "AesGcmSiv Parameters (variant: " + valueOf + ", " + i + "-byte key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final zzfm zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zzb != zzfm.zzc;
    }
}
