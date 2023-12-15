package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.2 */
final class zzga extends Thread {
    final /* synthetic */ zzgb zza;
    private final Object zzb;
    private final BlockingQueue zzc;
    private boolean zzd = false;

    public zzga(zzgb zzgb, String str, BlockingQueue blockingQueue) {
        this.zza = zzgb;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zzb = new Object();
        this.zzc = blockingQueue;
        setName(str);
    }

    private final void zzb() {
        synchronized (this.zza.zzh) {
            if (!this.zzd) {
                this.zza.zzi.release();
                this.zza.zzh.notifyAll();
                zzgb zzgb = this.zza;
                if (this == zzgb.zzb) {
                    zzgb.zzb = null;
                } else if (this == zzgb.zzc) {
                    zzgb.zzc = null;
                } else {
                    zzgb.zzt.zzaA().zzd().zza("Current scheduler thread is neither worker nor network");
                }
                this.zzd = true;
            }
        }
    }

    private final void zzc(InterruptedException interruptedException) {
        this.zza.zzt.zzaA().zzk().zzb(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void run() {
        boolean z = false;
        while (!z) {
            try {
                this.zza.zzi.acquire();
                z = true;
            } catch (InterruptedException e) {
                zzc(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzfz zzfz = (zzfz) this.zzc.poll();
                if (zzfz != null) {
                    Process.setThreadPriority(true != zzfz.zza ? 10 : threadPriority);
                    zzfz.run();
                } else {
                    synchronized (this.zzb) {
                        if (this.zzc.peek() == null) {
                            boolean unused = this.zza.zzj;
                            try {
                                this.zzb.wait(30000);
                            } catch (InterruptedException e2) {
                                zzc(e2);
                            }
                        }
                    }
                    synchronized (this.zza.zzh) {
                        if (this.zzc.peek() == null) {
                            zzb();
                            zzb();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            zzb();
            throw th;
        }
    }

    public final void zza() {
        synchronized (this.zzb) {
            this.zzb.notifyAll();
        }
    }
}
