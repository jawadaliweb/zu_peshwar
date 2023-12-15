package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.ce;

public final class w implements ce<v> {
    private final ce<au> a;
    private final ce<s> b;
    private final ce<p> c;
    private final ce<av> d;

    public w(ce<au> ceVar, ce<s> ceVar2, ce<p> ceVar3, ce<av> ceVar4) {
        this.a = ceVar;
        this.b = ceVar2;
        this.c = ceVar3;
        this.d = ceVar4;
    }

    public final /* bridge */ /* synthetic */ Object a() {
        return new v(this.a.a(), this.b.a(), this.c.a(), this.d.a());
    }
}
