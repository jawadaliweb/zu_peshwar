package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.2 */
public final class zzgb extends zzgy {
    /* access modifiers changed from: private */
    public static final AtomicLong zza = new AtomicLong(Long.MIN_VALUE);
    /* access modifiers changed from: private */
    public zzga zzb;
    /* access modifiers changed from: private */
    public zzga zzc;
    private final PriorityBlockingQueue zzd = new PriorityBlockingQueue();
    private final BlockingQueue zze = new LinkedBlockingQueue();
    private final Thread.UncaughtExceptionHandler zzf = new zzfy(this, "Thread death: Uncaught exception on worker thread");
    private final Thread.UncaughtExceptionHandler zzg = new zzfy(this, "Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */
    public final Object zzh = new Object();
    /* access modifiers changed from: private */
    public final Semaphore zzi = new Semaphore(2);
    /* access modifiers changed from: private */
    public volatile boolean zzj;

    zzgb(zzge zzge) {
        super(zzge);
    }

    private final void zzt(zzfz zzfz) {
        synchronized (this.zzh) {
            this.zzd.add(zzfz);
            zzga zzga = this.zzb;
            if (zzga == null) {
                zzga zzga2 = new zzga(this, "Measurement Worker", this.zzd);
                this.zzb = zzga2;
                zzga2.setUncaughtExceptionHandler(this.zzf);
                this.zzb.start();
            } else {
                zzga.zza();
            }
        }
    }

    public final void zzaz() {
        if (Thread.currentThread() != this.zzc) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:11|12|13|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r3 = r1.zzt.zzaA().zzk();
        r3.zza("Interrupted waiting for " + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r2 = r2.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r2 != null) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r1.zzt.zzaA().zzk().zza("Timed out waiting for ".concat(r5));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzd(java.util.concurrent.atomic.AtomicReference r2, long r3, java.lang.String r5, java.lang.Runnable r6) {
        /*
            r1 = this;
            monitor-enter(r2)
            com.google.android.gms.measurement.internal.zzge r0 = r1.zzt     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.zzgb r0 = r0.zzaB()     // Catch:{ all -> 0x0049 }
            r0.zzp(r6)     // Catch:{ all -> 0x0049 }
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x0028 }
            monitor-exit(r2)     // Catch:{ all -> 0x0049 }
            java.lang.Object r2 = r2.get()
            if (r2 != 0) goto L_0x0027
            com.google.android.gms.measurement.internal.zzge r3 = r1.zzt
            com.google.android.gms.measurement.internal.zzeu r3 = r3.zzaA()
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzk()
            java.lang.String r4 = "Timed out waiting for "
            java.lang.String r4 = r4.concat(r5)
            r3.zza(r4)
        L_0x0027:
            return r2
        L_0x0028:
            com.google.android.gms.measurement.internal.zzge r3 = r1.zzt     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.zzeu r3 = r3.zzaA()     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzk()     // Catch:{ all -> 0x0049 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r4.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r6 = "Interrupted waiting for "
            r4.append(r6)     // Catch:{ all -> 0x0049 }
            r4.append(r5)     // Catch:{ all -> 0x0049 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0049 }
            r3.zza(r4)     // Catch:{ all -> 0x0049 }
            monitor-exit(r2)     // Catch:{ all -> 0x0049 }
            r2 = 0
            return r2
        L_0x0049:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0049 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgb.zzd(java.util.concurrent.atomic.AtomicReference, long, java.lang.String, java.lang.Runnable):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return false;
    }

    public final void zzg() {
        if (Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final Future zzh(Callable callable) throws IllegalStateException {
        zzv();
        Preconditions.checkNotNull(callable);
        zzfz zzfz = new zzfz(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzb) {
            if (!this.zzd.isEmpty()) {
                this.zzt.zzaA().zzk().zza("Callable skipped the worker queue.");
            }
            zzfz.run();
        } else {
            zzt(zzfz);
        }
        return zzfz;
    }

    public final Future zzi(Callable callable) throws IllegalStateException {
        zzv();
        Preconditions.checkNotNull(callable);
        zzfz zzfz = new zzfz(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzb) {
            zzfz.run();
        } else {
            zzt(zzfz);
        }
        return zzfz;
    }

    public final void zzo(Runnable runnable) throws IllegalStateException {
        zzv();
        Preconditions.checkNotNull(runnable);
        zzfz zzfz = new zzfz(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzh) {
            this.zze.add(zzfz);
            zzga zzga = this.zzc;
            if (zzga == null) {
                zzga zzga2 = new zzga(this, "Measurement Network", this.zze);
                this.zzc = zzga2;
                zzga2.setUncaughtExceptionHandler(this.zzg);
                this.zzc.start();
            } else {
                zzga.zza();
            }
        }
    }

    public final void zzp(Runnable runnable) throws IllegalStateException {
        zzv();
        Preconditions.checkNotNull(runnable);
        zzt(new zzfz(this, runnable, false, "Task exception on worker thread"));
    }

    public final void zzq(Runnable runnable) throws IllegalStateException {
        zzv();
        Preconditions.checkNotNull(runnable);
        zzt(new zzfz(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean zzs() {
        return Thread.currentThread() == this.zzb;
    }
}
