package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.appupdate.g;
import com.google.android.play.core.internal.cc;
import com.google.android.play.core.internal.ce;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import com.google.android.play.core.splitinstall.testing.j;
import java.io.File;

public final class c implements m {
    private ce<Context> a;
    private ce<au> b;
    private ce<s> c;
    private ce<p> d = cc.b(g.b(this.a));
    private ce<av> e;
    private ce<v> f;
    private ce<File> g;
    private ce<FakeSplitInstallManager> h;
    private ce<i> i;
    private ce<SplitInstallManager> j;

    /* synthetic */ c(x xVar) {
        y yVar = new y(xVar);
        this.a = yVar;
        this.b = cc.b(new aw(yVar, (byte[]) null));
        this.c = cc.b(new aa(xVar));
        ce<av> b2 = cc.b(new aw(this.a));
        this.e = b2;
        this.f = cc.b(new w(this.b, this.c, this.d, b2));
        ce<File> b3 = cc.b(new z(this.a));
        this.g = b3;
        ce<FakeSplitInstallManager> b4 = cc.b(new j(this.a, b3, this.d));
        this.h = b4;
        ce<i> b5 = cc.b(new j(this.f, b4, this.g));
        this.i = b5;
        this.j = cc.b(new ab(xVar, b5));
    }

    public final SplitInstallManager a() {
        return this.j.a();
    }

    public final File b() {
        return this.g.a();
    }
}
