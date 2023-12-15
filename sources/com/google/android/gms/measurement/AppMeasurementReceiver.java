package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzfn;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzfn.zza {
    private zzfn zza;

    public BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }

    public void doStartService(Context context, Intent intent) {
        startWakefulService(context, intent);
    }

    public void onReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new zzfn(this);
        }
        this.zza.zza(context, intent);
    }
}
