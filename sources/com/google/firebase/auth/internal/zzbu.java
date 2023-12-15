package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzbu implements BackgroundDetector.BackgroundStateChangeListener {
    final /* synthetic */ zzbv zza;

    zzbu(zzbv zzbv) {
        this.zza = zzbv;
    }

    public final void onBackgroundStateChanged(boolean z) {
        if (z) {
            this.zza.zzc = true;
            this.zza.zzc();
            return;
        }
        this.zza.zzc = false;
        if (this.zza.zzg()) {
            this.zza.zzb.zzc();
        }
    }
}
