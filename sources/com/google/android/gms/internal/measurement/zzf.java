package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
public final class zzf {
    final zzax zza;
    final zzg zzb;
    final zzg zzc;
    final zzj zzd;

    public zzf() {
        zzax zzax = new zzax();
        this.zza = zzax;
        zzg zzg = new zzg((zzg) null, zzax);
        this.zzc = zzg;
        this.zzb = zzg.zza();
        zzj zzj = new zzj();
        this.zzd = zzj;
        zzg.zzg("require", new zzw(zzj));
        zzj.zza("internal.platform", zze.zza);
        zzg.zzg("runtime.counter", new zzah(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)));
    }

    public final zzap zza(zzg zzg, zzgy... zzgyArr) {
        zzap zzap = zzap.zzf;
        for (zzgy zza2 : zzgyArr) {
            zzap = zzi.zza(zza2);
            zzh.zzc(this.zzc);
            if ((zzap instanceof zzaq) || (zzap instanceof zzao)) {
                zzap = this.zza.zza(zzg, zzap);
            }
        }
        return zzap;
    }
}
