package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.p001firebaseauthapi.zzc;
import com.google.firebase.FirebaseApp;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzam {
    /* access modifiers changed from: private */
    public static final Logger zzg = new Logger("TokenRefresher", "FirebaseAuth:");
    volatile long zza;
    volatile long zzb;
    final long zzc = 300000;
    final HandlerThread zzd;
    final Handler zze;
    final Runnable zzf;
    private final FirebaseApp zzh;

    public zzam(FirebaseApp firebaseApp) {
        zzg.v("Initializing TokenRefresher", new Object[0]);
        FirebaseApp firebaseApp2 = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zzh = firebaseApp2;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.zzd = handlerThread;
        handlerThread.start();
        this.zze = new zzc(handlerThread.getLooper());
        this.zzf = new zzal(this, firebaseApp2.getName());
    }

    public final void zzb() {
        this.zze.removeCallbacks(this.zzf);
    }

    public final void zzc() {
        Logger logger = zzg;
        long j = this.zza - this.zzc;
        logger.v("Scheduling refresh for " + j, new Object[0]);
        zzb();
        this.zzb = Math.max((this.zza - DefaultClock.getInstance().currentTimeMillis()) - this.zzc, 0) / 1000;
        this.zze.postDelayed(this.zzf, this.zzb * 1000);
    }

    /* access modifiers changed from: package-private */
    public final void zzd() {
        long j;
        int i = (int) this.zzb;
        if (i == 30 || i == 60 || i == 120 || i == 240 || i == 480) {
            long j2 = this.zzb;
            j = j2 + j2;
        } else {
            j = i != 960 ? 30 : 960;
        }
        this.zzb = j;
        this.zza = DefaultClock.getInstance().currentTimeMillis() + (this.zzb * 1000);
        Logger logger = zzg;
        long j3 = this.zza;
        logger.v("Scheduling refresh for " + j3, new Object[0]);
        this.zze.postDelayed(this.zzf, this.zzb * 1000);
    }
}
