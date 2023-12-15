package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzos;
import com.google.android.gms.internal.measurement.zzqr;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.2 */
final class zzkn {
    final /* synthetic */ zzko zza;

    zzkn(zzko zzko) {
        this.zza = zzko;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zza.zzg();
        if (this.zza.zzt.zzm().zzk(this.zza.zzt.zzax().currentTimeMillis())) {
            this.zza.zzt.zzm().zzg.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.zza.zzt.zzaA().zzj().zza("Detected application was in foreground");
                zzc(this.zza.zzt.zzax().currentTimeMillis(), false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(long j, boolean z) {
        this.zza.zzg();
        this.zza.zzm();
        if (this.zza.zzt.zzm().zzk(j)) {
            this.zza.zzt.zzm().zzg.zza(true);
            zzqr.zzc();
            if (this.zza.zzt.zzf().zzs((String) null, zzeh.zzan)) {
                this.zza.zzt.zzh().zzo();
            }
        }
        this.zza.zzt.zzm().zzj.zzb(j);
        if (this.zza.zzt.zzm().zzg.zzb()) {
            zzc(j, z);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(long j, boolean z) {
        this.zza.zzg();
        if (this.zza.zzt.zzJ()) {
            this.zza.zzt.zzm().zzj.zzb(j);
            this.zza.zzt.zzaA().zzj().zzb("Session started, time", Long.valueOf(this.zza.zzt.zzax().elapsedRealtime()));
            Long valueOf = Long.valueOf(j / 1000);
            this.zza.zzt.zzq().zzY(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid", valueOf, j);
            this.zza.zzt.zzm().zzk.zzb(valueOf.longValue());
            this.zza.zzt.zzm().zzg.zza(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            if (this.zza.zzt.zzf().zzs((String) null, zzeh.zzab) && z) {
                bundle.putLong("_aib", 1);
            }
            this.zza.zzt.zzq().zzH(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_s", j, bundle);
            zzos.zzc();
            if (this.zza.zzt.zzf().zzs((String) null, zzeh.zzae)) {
                String zza2 = this.zza.zzt.zzm().zzp.zza();
                if (!TextUtils.isEmpty(zza2)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_ffr", zza2);
                    this.zza.zzt.zzq().zzH(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ssr", j, bundle2);
                }
            }
        }
    }
}
