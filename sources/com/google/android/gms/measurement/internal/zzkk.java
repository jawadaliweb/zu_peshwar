package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.2 */
final class zzkk {
    final /* synthetic */ zzko zza;
    private zzkj zzb;

    zzkk(zzko zzko) {
        this.zza = zzko;
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j) {
        this.zzb = new zzkj(this, this.zza.zzt.zzax().currentTimeMillis(), j);
        this.zza.zzd.postDelayed(this.zzb, 2000);
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        this.zza.zzg();
        zzkj zzkj = this.zzb;
        if (zzkj != null) {
            this.zza.zzd.removeCallbacks(zzkj);
        }
        this.zza.zzt.zzm().zzm.zza(false);
    }
}
