package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzml  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzml extends zznq {
    private final int zza;
    private final int zzb;
    private final zzmj zzc;

    /* synthetic */ zzml(int i, int i2, zzmj zzmj, zzmk zzmk) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzmj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzml)) {
            return false;
        }
        zzml zzml = (zzml) obj;
        if (zzml.zza == this.zza && zzml.zzb() == zzb() && zzml.zzc == this.zzc) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzml.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        int i = this.zzb;
        int i2 = this.zza;
        return "AES-CMAC Parameters (variant: " + valueOf + ", " + i + "-byte tags, and " + i2 + "-byte key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        zzmj zzmj = this.zzc;
        if (zzmj == zzmj.zzd) {
            return this.zzb;
        }
        if (zzmj == zzmj.zza || zzmj == zzmj.zzb || zzmj == zzmj.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzmj zzc() {
        return this.zzc;
    }

    public final boolean zzd() {
        return this.zzc != zzmj.zzd;
    }
}
