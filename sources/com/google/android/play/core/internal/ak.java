package com.google.android.play.core.internal;

final class ak extends ah {
    final /* synthetic */ aq a;

    ak(aq aqVar) {
        this.a = aqVar;
    }

    public final void a() {
        if (this.a.l != null) {
            this.a.c.d("Unbind from service.", new Object[0]);
            this.a.b.unbindService(this.a.k);
            this.a.f = false;
            this.a.l = null;
            this.a.k = null;
        }
    }
}
