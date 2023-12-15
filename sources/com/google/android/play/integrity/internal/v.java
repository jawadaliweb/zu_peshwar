package com.google.android.play.integrity.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.integrity.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
public final class v {
    private static final Map a = new HashMap();
    /* access modifiers changed from: private */
    public final Context b;
    /* access modifiers changed from: private */
    public final k c;
    private final String d;
    /* access modifiers changed from: private */
    public final List e = new ArrayList();
    private final Set f = new HashSet();
    private final Object g = new Object();
    /* access modifiers changed from: private */
    public boolean h;
    private final Intent i;
    private final WeakReference j;
    private final IBinder.DeathRecipient k = new n(this);
    private final AtomicInteger l = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public ServiceConnection m;
    /* access modifiers changed from: private */
    public IInterface n;
    private final q o;

    public v(Context context, k kVar, String str, Intent intent, q qVar, q qVar2, byte[] bArr) {
        this.b = context;
        this.c = kVar;
        this.d = "IntegrityService";
        this.i = intent;
        this.o = qVar;
        this.j = new WeakReference((Object) null);
    }

    public static /* synthetic */ void h(v vVar) {
        vVar.c.d("reportBinderDeath", new Object[0]);
        q qVar = (q) vVar.j.get();
        if (qVar != null) {
            vVar.c.d("calling onBinderDied", new Object[0]);
            qVar.a();
        } else {
            vVar.c.d("%s : Binder has died.", vVar.d);
            for (l a2 : vVar.e) {
                a2.a(vVar.s());
            }
            vVar.e.clear();
        }
        vVar.t();
    }

    static /* bridge */ /* synthetic */ void n(v vVar) {
        vVar.c.d("linkToDeath", new Object[0]);
        try {
            vVar.n.asBinder().linkToDeath(vVar.k, 0);
        } catch (RemoteException e2) {
            vVar.c.c(e2, "linkToDeath failed", new Object[0]);
        }
    }

    static /* bridge */ /* synthetic */ void o(v vVar) {
        vVar.c.d("unlinkToDeath", new Object[0]);
        vVar.n.asBinder().unlinkToDeath(vVar.k, 0);
    }

    private final RemoteException s() {
        if (Build.VERSION.SDK_INT < 15) {
            return new RemoteException();
        }
        return new RemoteException(String.valueOf(this.d).concat(" : Binder has died."));
    }

    /* access modifiers changed from: private */
    public final void t() {
        synchronized (this.g) {
            for (TaskCompletionSource trySetException : this.f) {
                trySetException.trySetException(s());
            }
            this.f.clear();
        }
    }

    public final Handler c() {
        Handler handler;
        Map map = a;
        synchronized (map) {
            if (!map.containsKey(this.d)) {
                HandlerThread handlerThread = new HandlerThread(this.d, 10);
                handlerThread.start();
                map.put(this.d, new Handler(handlerThread.getLooper()));
            }
            handler = (Handler) map.get(this.d);
        }
        return handler;
    }

    public final IInterface e() {
        return this.n;
    }

    public final void p(l lVar, TaskCompletionSource taskCompletionSource) {
        synchronized (this.g) {
            this.f.add(taskCompletionSource);
            taskCompletionSource.getTask().addOnCompleteListener(new m(this, taskCompletionSource));
        }
        synchronized (this.g) {
            if (this.l.getAndIncrement() > 0) {
                this.c.a("Already connected to the service.", new Object[0]);
            }
        }
        c().post(new o(this, lVar.c(), lVar));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void q(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.g) {
            this.f.remove(taskCompletionSource);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        c().post(new com.google.android.play.integrity.internal.p(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r(com.google.android.gms.tasks.TaskCompletionSource r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.g
            monitor-enter(r0)
            java.util.Set r1 = r3.f     // Catch:{ all -> 0x0039 }
            r1.remove(r4)     // Catch:{ all -> 0x0039 }
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            java.lang.Object r4 = r3.g
            monitor-enter(r4)
            java.util.concurrent.atomic.AtomicInteger r0 = r3.l     // Catch:{ all -> 0x0036 }
            int r0 = r0.get()     // Catch:{ all -> 0x0036 }
            if (r0 <= 0) goto L_0x0028
            java.util.concurrent.atomic.AtomicInteger r0 = r3.l     // Catch:{ all -> 0x0036 }
            int r0 = r0.decrementAndGet()     // Catch:{ all -> 0x0036 }
            if (r0 <= 0) goto L_0x0028
            com.google.android.play.integrity.internal.k r0 = r3.c     // Catch:{ all -> 0x0036 }
            java.lang.String r1 = "Leaving the connection open for other ongoing calls."
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0036 }
            r0.d(r1, r2)     // Catch:{ all -> 0x0036 }
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            return
        L_0x0028:
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            com.google.android.play.integrity.internal.p r4 = new com.google.android.play.integrity.internal.p
            r4.<init>(r3)
            android.os.Handler r0 = r3.c()
            r0.post(r4)
            return
        L_0x0036:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            throw r0
        L_0x0039:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.integrity.internal.v.r(com.google.android.gms.tasks.TaskCompletionSource):void");
    }

    static /* bridge */ /* synthetic */ void m(v vVar, l lVar) {
        if (vVar.n == null && !vVar.h) {
            vVar.c.d("Initiate binding to the service.", new Object[0]);
            vVar.e.add(lVar);
            u uVar = new u(vVar, (t) null);
            vVar.m = uVar;
            vVar.h = true;
            if (!vVar.b.bindService(vVar.i, uVar, 1)) {
                vVar.c.d("Failed to bind to the service.", new Object[0]);
                vVar.h = false;
                for (l a2 : vVar.e) {
                    a2.a(new w());
                }
                vVar.e.clear();
            }
        } else if (vVar.h) {
            vVar.c.d("Waiting to bind to the service.", new Object[0]);
            vVar.e.add(lVar);
        } else {
            lVar.run();
        }
    }
}
