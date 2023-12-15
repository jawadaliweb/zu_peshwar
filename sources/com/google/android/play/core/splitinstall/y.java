package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.bh;
import com.google.android.play.core.internal.ce;

public final class y implements ce<Context> {
    private final x a;

    public y(x xVar) {
        this.a = xVar;
    }

    /* renamed from: b */
    public final Context a() {
        Context b = this.a.b();
        bh.k(b);
        return b;
    }
}
