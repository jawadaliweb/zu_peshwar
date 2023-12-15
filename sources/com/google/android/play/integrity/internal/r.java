package com.google.android.play.integrity.internal;

import android.os.IBinder;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
final class r extends l {
    final /* synthetic */ IBinder a;
    final /* synthetic */ u b;

    r(u uVar, IBinder iBinder) {
        this.b = uVar;
        this.a = iBinder;
    }

    public final void b() {
        this.b.a.n = g.b(this.a);
        v.n(this.b.a);
        this.b.a.h = false;
        for (Runnable run : this.b.a.e) {
            run.run();
        }
        this.b.a.e.clear();
    }
}
