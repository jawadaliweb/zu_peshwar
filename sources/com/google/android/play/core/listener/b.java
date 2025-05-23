package com.google.android.play.core.listener;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.ax;
import com.google.android.play.core.splitcompat.p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class b<StateT> {
    protected final ag a;
    protected final Set<StateUpdatedListener<StateT>> b = new HashSet();
    private final IntentFilter c;
    private final Context d;
    private a e = null;
    private volatile boolean f = false;

    protected b(ag agVar, IntentFilter intentFilter, Context context) {
        this.a = agVar;
        this.c = intentFilter;
        this.d = p.c(context);
    }

    private final void b() {
        a aVar;
        if ((this.f || !this.b.isEmpty()) && this.e == null) {
            a aVar2 = new a(this);
            this.e = aVar2;
            this.d.registerReceiver(aVar2, this.c);
        }
        if (!this.f && this.b.isEmpty() && (aVar = this.e) != null) {
            this.d.unregisterReceiver(aVar);
            this.e = null;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(Context context, Intent intent);

    public final synchronized void e(boolean z) {
        this.f = z;
        b();
    }

    public final synchronized void f(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.a.d("registerListener", new Object[0]);
        ax.d(stateUpdatedListener, "Registered Play Core listener should not be null.");
        this.b.add(stateUpdatedListener);
        b();
    }

    public final synchronized void g(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.a.d("unregisterListener", new Object[0]);
        ax.d(stateUpdatedListener, "Unregistered Play Core listener should not be null.");
        this.b.remove(stateUpdatedListener);
        b();
    }

    public final synchronized void h() {
        this.a.d("clearListeners", new Object[0]);
        this.b.clear();
        b();
    }

    public final synchronized void i(StateT statet) {
        Iterator it = new HashSet(this.b).iterator();
        while (it.hasNext()) {
            ((StateUpdatedListener) it.next()).onStateUpdate(statet);
        }
    }

    public final synchronized boolean j() {
        return this.e != null;
    }
}
