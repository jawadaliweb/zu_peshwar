package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.zzke;
import com.google.android.gms.measurement.internal.zzkf;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
public final class AppMeasurementService extends Service implements zzke {
    private zzkf zza;

    private final zzkf zzd() {
        if (this.zza == null) {
            this.zza = new zzkf(this);
        }
        return this.zza;
    }

    public IBinder onBind(Intent intent) {
        return zzd().zzb(intent);
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

    public int onStartCommand(Intent intent, int i, int i2) {
        zzd().zza(intent, i, i2);
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        zzd().zzj(intent);
        return true;
    }

    public final void zza(Intent intent) {
        AppMeasurementReceiver.completeWakefulIntent(intent);
    }

    public final void zzb(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final boolean zzc(int i) {
        return stopSelfResult(i);
    }
}
