package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzdj {
    public static final zzdj zza = new zzdj("SHA1");
    public static final zzdj zzb = new zzdj("SHA224");
    public static final zzdj zzc = new zzdj("SHA256");
    public static final zzdj zzd = new zzdj("SHA384");
    public static final zzdj zze = new zzdj("SHA512");
    private final String zzf;

    private zzdj(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}
