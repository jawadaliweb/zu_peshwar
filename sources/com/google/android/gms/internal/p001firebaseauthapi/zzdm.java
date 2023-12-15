package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzdm extends zzcw {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzdk zze;
    private final zzdj zzf;

    /* synthetic */ zzdm(int i, int i2, int i3, int i4, zzdk zzdk, zzdj zzdj, zzdl zzdl) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = zzdk;
        this.zzf = zzdj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdm)) {
            return false;
        }
        zzdm zzdm = (zzdm) obj;
        return zzdm.zza == this.zza && zzdm.zzb == this.zzb && zzdm.zzc == this.zzc && zzdm.zzd == this.zzd && zzdm.zze == this.zze && zzdm.zzf == this.zzf;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzdm.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zze);
        String valueOf2 = String.valueOf(this.zzf);
        int i = this.zzc;
        int i2 = this.zzd;
        int i3 = this.zza;
        int i4 = this.zzb;
        return "AesCtrHmacAead Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + ", " + i + "-byte IV, and " + i2 + "-byte tags, and " + i3 + "-byte AES key, and " + i4 + "-byte HMAC key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final zzdk zzc() {
        return this.zze;
    }

    public final boolean zzd() {
        return this.zze != zzdk.zzc;
    }
}
