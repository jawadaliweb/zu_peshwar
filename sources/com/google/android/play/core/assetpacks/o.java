package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.bh;
import com.google.android.play.core.internal.cc;
import com.google.android.play.core.internal.ce;

public final class o implements ce<t> {
    private final ce<Context> a;
    private final ce<an> b;
    private final ce<cj> c;

    public o(ce<Context> ceVar, ce<an> ceVar2, ce<cj> ceVar3) {
        this.a = ceVar;
        this.b = ceVar2;
        this.c = ceVar3;
    }

    public final /* bridge */ /* synthetic */ Object a() {
        t tVar = (t) (l.b(((p) this.a).a()) == null ? cc.c(this.b).a() : cc.c(this.c).a());
        bh.k(tVar);
        return tVar;
    }
}
