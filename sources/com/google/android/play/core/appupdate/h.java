package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.internal.bh;
import com.google.android.play.core.internal.ce;

public final class h implements ce<Context> {
    private final f a;

    public h(f fVar) {
        this.a = fVar;
    }

    /* renamed from: b */
    public final Context a() {
        Context a2 = this.a.a();
        bh.k(a2);
        return a2;
    }
}
