package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.internal.ce;

public final class e implements ce<d> {
    private final ce<o> a;
    private final ce<a> b;
    private final ce<Context> c;

    public e(ce<o> ceVar, ce<a> ceVar2, ce<Context> ceVar3) {
        this.a = ceVar;
        this.b = ceVar2;
        this.c = ceVar3;
    }

    public final /* bridge */ /* synthetic */ Object a() {
        return new d(this.a.a(), this.b.a(), ((h) this.c).a());
    }
}
