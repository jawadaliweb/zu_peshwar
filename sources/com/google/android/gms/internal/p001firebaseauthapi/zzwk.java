package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.PhoneMultiFactorInfo;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzwk {
    private final PhoneMultiFactorInfo zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final boolean zze;
    private final String zzf;
    private final String zzg;
    private final boolean zzh;

    public zzwk(PhoneMultiFactorInfo phoneMultiFactorInfo, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, boolean z3) {
        this.zza = phoneMultiFactorInfo;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = j;
        this.zze = z;
        this.zzf = str3;
        this.zzg = str4;
        this.zzh = z3;
    }

    public final long zza() {
        return this.zzd;
    }

    public final PhoneMultiFactorInfo zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zzg;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return this.zze;
    }

    public final boolean zzh() {
        return this.zzh;
    }
}
