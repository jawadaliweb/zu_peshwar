package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzpe;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.2 */
final class zzkm {
    protected long zza;
    protected long zzb;
    final /* synthetic */ zzko zzc;
    private final zzap zzd;

    public zzkm(zzko zzko) {
        this.zzc = zzko;
        this.zzd = new zzkl(this, zzko.zzt);
        long elapsedRealtime = zzko.zzt.zzax().elapsedRealtime();
        this.zza = elapsedRealtime;
        this.zzb = elapsedRealtime;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzd.zzb();
        this.zza = 0;
        this.zzb = 0;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(long j) {
        this.zzd.zzb();
    }

    /* access modifiers changed from: package-private */
    public final void zzc(long j) {
        this.zzc.zzg();
        this.zzd.zzb();
        this.zza = j;
        this.zzb = j;
    }

    public final boolean zzd(boolean z, boolean z2, long j) {
        this.zzc.zzg();
        this.zzc.zza();
        zzpe.zzc();
        if (!this.zzc.zzt.zzf().zzs((String) null, zzeh.zzaf)) {
            this.zzc.zzt.zzm().zzj.zzb(this.zzc.zzt.zzax().currentTimeMillis());
        } else if (this.zzc.zzt.zzJ()) {
            this.zzc.zzt.zzm().zzj.zzb(this.zzc.zzt.zzax().currentTimeMillis());
        }
        long j2 = j - this.zza;
        if (z || j2 >= 1000) {
            if (!z2) {
                j2 = j - this.zzb;
                this.zzb = j;
            }
            this.zzc.zzt.zzaA().zzj().zzb("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            zzlo.zzK(this.zzc.zzt.zzs().zzj(!this.zzc.zzt.zzf().zzu()), bundle, true);
            if (!z2) {
                this.zzc.zzt.zzq().zzG(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_e", bundle);
            }
            this.zza = j;
            this.zzd.zzb();
            this.zzd.zzd(3600000);
            return true;
        }
        this.zzc.zzt.zzaA().zzj().zzb("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }
}
