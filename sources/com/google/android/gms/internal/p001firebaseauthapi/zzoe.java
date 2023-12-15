package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoe  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzoe {
    private final zzbt zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;

    /* synthetic */ zzoe(zzbt zzbt, int i, String str, String str2, zzod zzod) {
        this.zza = zzbt;
        this.zzb = i;
        this.zzc = str;
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzoe)) {
            return false;
        }
        zzoe zzoe = (zzoe) obj;
        if (this.zza != zzoe.zza || this.zzb != zzoe.zzb || !this.zzc.equals(zzoe.zzc) || !this.zzd.equals(zzoe.zzd)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final String toString() {
        return String.format("(status=%s, keyId=%s, keyType='%s', keyPrefix='%s')", new Object[]{this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final int zza() {
        return this.zzb;
    }
}
