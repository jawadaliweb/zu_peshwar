package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzeg extends zzcw {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzee zzd;

    /* synthetic */ zzeg(int i, int i2, int i3, zzee zzee, zzef zzef) {
        this.zza = i;
        this.zzb = i2;
        this.zzd = zzee;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzeg)) {
            return false;
        }
        zzeg zzeg = (zzeg) obj;
        if (zzeg.zza == this.zza && zzeg.zzb == this.zzb) {
            int i = zzeg.zzc;
            if (zzeg.zzd == this.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzeg.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        int i = this.zzb;
        int i2 = this.zza;
        return "AesEax Parameters (variant: " + valueOf + ", " + i + "-byte IV, " + 16 + "-byte tag, and " + i2 + "-byte key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final zzee zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        return this.zzd != zzee.zzc;
    }
}
