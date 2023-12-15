package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.cc;
import com.google.android.play.core.internal.ce;

public final class cp implements ce<co> {
    private final ce a;
    private final /* synthetic */ int b = 0;

    public cp(ce<au> ceVar) {
        this.a = ceVar;
    }

    public cp(ce<t> ceVar, byte[] bArr) {
        this.a = ceVar;
    }

    public cp(ce<Context> ceVar, char[] cArr) {
        this.a = ceVar;
    }

    public cp(ce<au> ceVar, short[] sArr) {
        this.a = ceVar;
    }

    public final /* bridge */ /* synthetic */ Object a() {
        int i = this.b;
        return i != 0 ? i != 1 ? i != 2 ? new dd((au) this.a.a()) : new cv(((p) this.a).a()) : new bc(cc.c(this.a)) : new co((au) this.a.a());
    }
}
