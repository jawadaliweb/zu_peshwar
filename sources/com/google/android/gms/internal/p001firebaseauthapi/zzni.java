package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzni  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzni extends zznq {
    private final int zza;
    private final int zzb;
    private final zzng zzc;
    private final zznf zzd;

    /* synthetic */ zzni(int i, int i2, zzng zzng, zznf zznf, zznh zznh) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzng;
        this.zzd = zznf;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzni)) {
            return false;
        }
        zzni zzni = (zzni) obj;
        if (zzni.zza == this.zza && zzni.zzb() == zzb() && zzni.zzc == this.zzc && zzni.zzd == this.zzd) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzni.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(this.zzd);
        int i = this.zzb;
        int i2 = this.zza;
        return "HMAC Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + ", " + i + "-byte tags, and " + i2 + "-byte key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        zzng zzng = this.zzc;
        if (zzng == zzng.zzd) {
            return this.zzb;
        }
        if (zzng == zzng.zza || zzng == zzng.zzb || zzng == zzng.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzng zzc() {
        return this.zzc;
    }

    public final boolean zzd() {
        return this.zzc != zzng.zzd;
    }
}
