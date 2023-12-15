package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.bh;
import com.google.android.play.core.internal.ce;

public final class p implements ce<Context> {
    private final l a;

    public p(l lVar) {
        this.a = lVar;
    }

    public static Context c(l lVar) {
        Context a2 = lVar.a();
        bh.k(a2);
        return a2;
    }

    /* renamed from: b */
    public final Context a() {
        return c(this.a);
    }
}
