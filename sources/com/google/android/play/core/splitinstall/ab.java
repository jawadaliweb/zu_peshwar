package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.bh;
import com.google.android.play.core.internal.ce;

public final class ab implements ce<SplitInstallManager> {
    private final x a;
    private final ce<i> b;

    public ab(x xVar, ce<i> ceVar) {
        this.a = xVar;
        this.b = ceVar;
    }

    public final /* bridge */ /* synthetic */ Object a() {
        i a2 = this.b.a();
        bh.k(a2);
        return a2;
    }
}
