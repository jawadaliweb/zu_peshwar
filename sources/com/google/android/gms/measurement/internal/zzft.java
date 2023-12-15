package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzr;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
final class zzft implements zzr {
    final /* synthetic */ zzfv zza;

    zzft(zzfv zzfv) {
        this.zza = zzfv;
    }

    public final void zza(int i, String str, List list, boolean z, boolean z2) {
        zzes zzes;
        int i2 = i - 1;
        if (i2 == 0) {
            zzes = this.zza.zzt.zzaA().zzc();
        } else if (i2 != 1) {
            if (i2 == 3) {
                zzes = this.zza.zzt.zzaA().zzj();
            } else if (i2 != 4) {
                zzes = this.zza.zzt.zzaA().zzi();
            } else if (z) {
                zzes = this.zza.zzt.zzaA().zzm();
            } else if (!z2) {
                zzes = this.zza.zzt.zzaA().zzl();
            } else {
                zzes = this.zza.zzt.zzaA().zzk();
            }
        } else if (z) {
            zzes = this.zza.zzt.zzaA().zzh();
        } else if (!z2) {
            zzes = this.zza.zzt.zzaA().zze();
        } else {
            zzes = this.zza.zzt.zzaA().zzd();
        }
        int size = list.size();
        if (size == 1) {
            zzes.zzb(str, list.get(0));
        } else if (size == 2) {
            zzes.zzc(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzes.zza(str);
        } else {
            zzes.zzd(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
