package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.internal.cc;
import com.google.android.play.core.internal.ce;

public final class w {
    private ce<Context> a;
    private ce<q> b;
    private ce<o> c;
    private ce<a> d;
    private ce<d> e;
    private ce<AppUpdateManager> f;

    /* synthetic */ w(f fVar) {
        h hVar = new h(fVar);
        this.a = hVar;
        ce<q> b2 = cc.b(new g((ce<Context>) hVar, (char[]) null));
        this.b = b2;
        this.c = cc.b(new p(this.a, b2));
        ce<a> b3 = cc.b(new g(this.a, (byte[]) null));
        this.d = b3;
        ce<d> b4 = cc.b(new e(this.c, b3, this.a));
        this.e = b4;
        this.f = cc.b(new g(b4));
    }

    public final AppUpdateManager a() {
        return this.f.a();
    }
}
