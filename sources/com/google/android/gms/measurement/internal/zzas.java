package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.2 */
final class zzas {
    final String zza;
    final String zzb;
    final long zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final Long zzh;
    final Long zzi;
    final Long zzj;
    final Boolean zzk;

    zzas(String str, String str2, long j, long j2, long j3, long j4, long j5, Long l, Long l2, Long l3, Boolean bool) {
        long j6 = j;
        long j7 = j2;
        long j8 = j3;
        long j9 = j5;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        boolean z = true;
        Preconditions.checkArgument(j6 >= 0);
        Preconditions.checkArgument(j7 >= 0);
        Preconditions.checkArgument(j8 >= 0);
        Preconditions.checkArgument(j9 < 0 ? false : z);
        this.zza = str;
        this.zzb = str2;
        this.zzc = j6;
        this.zzd = j7;
        this.zze = j8;
        this.zzf = j4;
        this.zzg = j9;
        this.zzh = l;
        this.zzi = l2;
        this.zzj = l3;
        this.zzk = bool;
    }

    /* access modifiers changed from: package-private */
    public final zzas zza(Long l, Long l2, Boolean bool) {
        if (bool != null) {
            bool.booleanValue();
        }
        return new zzas(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, l, l2, bool);
    }

    /* access modifiers changed from: package-private */
    public final zzas zzb(long j, long j2) {
        return new zzas(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, j, Long.valueOf(j2), this.zzi, this.zzj, this.zzk);
    }

    /* access modifiers changed from: package-private */
    public final zzas zzc(long j) {
        return new zzas(this.zza, this.zzb, this.zzc, this.zzd, this.zze, j, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk);
    }
}
