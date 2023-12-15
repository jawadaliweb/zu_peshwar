package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzex  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzex extends zzcw {
    private final int zza;
    private final int zzb = 12;
    private final int zzc = 16;
    private final zzev zzd;

    /* synthetic */ zzex(int i, int i2, int i3, zzev zzev, zzew zzew) {
        this.zza = i;
        this.zzd = zzev;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzex)) {
            return false;
        }
        zzex zzex = (zzex) obj;
        if (zzex.zza == this.zza) {
            int i = zzex.zzb;
            int i2 = zzex.zzc;
            if (zzex.zzd == this.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzex.class, Integer.valueOf(this.zza), 12, 16, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        int i = this.zza;
        return "AesGcm Parameters (variant: " + valueOf + ", " + 12 + "-byte IV, " + 16 + "-byte tag, and " + i + "-byte key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final zzev zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        return this.zzd != zzev.zzc;
    }
}
