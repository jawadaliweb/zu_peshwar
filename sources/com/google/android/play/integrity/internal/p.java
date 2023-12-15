package com.google.android.play.integrity.internal;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
final class p extends l {
    final /* synthetic */ v a;

    p(v vVar) {
        this.a = vVar;
    }

    public final void b() {
        v vVar = this.a;
        if (vVar.n != null) {
            vVar.c.d("Unbind from service.", new Object[0]);
            v vVar2 = this.a;
            vVar2.b.unbindService(vVar2.m);
            this.a.h = false;
            this.a.n = null;
            this.a.m = null;
        }
        this.a.t();
    }
}
