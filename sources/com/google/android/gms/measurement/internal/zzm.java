package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.2.2 */
final class zzm implements Runnable {
    final /* synthetic */ zzcf zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ AppMeasurementDynamiteService zzd;

    zzm(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcf, String str, String str2) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzcf;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void run() {
        this.zzd.zza.zzt().zzv(this.zza, this.zzb, this.zzc);
    }
}
