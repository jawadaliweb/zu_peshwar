package com.google.android.gms.measurement;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzke;
import com.google.android.gms.measurement.internal.zzkf;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
public final class AppMeasurementJobService extends JobService implements zzke {
    private zzkf zza;

    private final zzkf zzd() {
        if (this.zza == null) {
            this.zza = new zzkf(this);
        }
        return this.zza;
    }

    public void onCreate() {
        super.onCreate();
        zzd().zze();
    }

    public void onDestroy() {
        zzd().zzf();
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        zzd().zzg(intent);
    }

    public boolean onStartJob(JobParameters jobParameters) {
        zzd().zzi(jobParameters);
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public boolean onUnbind(Intent intent) {
        zzd().zzj(intent);
        return true;
    }

    public final void zza(Intent intent) {
    }

    public final void zzb(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    public final boolean zzc(int i) {
        throw new UnsupportedOperationException();
    }
}
