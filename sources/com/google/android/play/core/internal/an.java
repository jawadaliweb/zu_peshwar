package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

final class an extends ah {
    final /* synthetic */ IBinder a;
    final /* synthetic */ ap b;

    an(ap apVar, IBinder iBinder) {
        this.b = apVar;
        this.a = iBinder;
    }

    public final void a() {
        aq aqVar = this.b.a;
        aqVar.l = (IInterface) aqVar.h.a(this.a);
        aq.j(this.b.a);
        this.b.a.f = false;
        for (Runnable run : this.b.a.e) {
            run.run();
        }
        this.b.a.e.clear();
    }
}
