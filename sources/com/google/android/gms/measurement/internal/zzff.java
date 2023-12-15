package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.2 */
public final class zzff {
    final /* synthetic */ zzfj zza;
    private final String zzb;
    private final long zzc;
    private boolean zzd;
    private long zze;

    public zzff(zzfj zzfj, String str, long j) {
        this.zza = zzfj;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = j;
    }

    public final long zza() {
        if (!this.zzd) {
            this.zzd = true;
            this.zze = this.zza.zza().getLong(this.zzb, this.zzc);
        }
        return this.zze;
    }

    public final void zzb(long j) {
        SharedPreferences.Editor edit = this.zza.zza().edit();
        edit.putLong(this.zzb, j);
        edit.apply();
        this.zze = j;
    }
}
