package com.google.android.play.integrity.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
final class u implements ServiceConnection {
    final /* synthetic */ v a;

    /* synthetic */ u(v vVar, t tVar) {
        this.a = vVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a.c.d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        v vVar = this.a;
        vVar.c().post(new r(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.c.d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        v vVar = this.a;
        vVar.c().post(new s(this));
    }
}
