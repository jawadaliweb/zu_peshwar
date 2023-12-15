package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.listener.b;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class s extends b<SplitInstallSessionState> {
    private static s c;
    private final Handler d = new Handler(Looper.getMainLooper());
    private final e e;
    private final Set<SplitInstallStateUpdatedListener> f = new LinkedHashSet();

    public s(Context context, e eVar) {
        super(new ag("SplitInstallListenerRegistry"), new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), context);
        this.e = eVar;
    }

    public static synchronized s b(Context context) {
        s sVar;
        synchronized (s.class) {
            if (c == null) {
                c = new s(context, l.a);
            }
            sVar = c;
        }
        return sVar;
    }

    /* access modifiers changed from: protected */
    public final void a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("session_state");
        if (bundleExtra != null) {
            SplitInstallSessionState d2 = SplitInstallSessionState.d(bundleExtra);
            this.a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", d2);
            f a = this.e.a();
            if (d2.status() != 3 || a == null) {
                k(d2);
            } else {
                a.a(d2.c(), new q(this, d2, intent, context));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void c(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f.add(splitInstallStateUpdatedListener);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void d(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f.remove(splitInstallStateUpdatedListener);
    }

    public final synchronized void k(SplitInstallSessionState splitInstallSessionState) {
        Iterator it = new LinkedHashSet(this.f).iterator();
        while (it.hasNext()) {
            ((SplitInstallStateUpdatedListener) it.next()).onStateUpdate(splitInstallSessionState);
        }
        super.i(splitInstallSessionState);
    }
}
