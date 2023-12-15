package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.internal.bh;
import com.google.android.play.core.internal.ce;
import com.google.android.play.core.splitinstall.p;

public final class g implements ce<AppUpdateManager> {
    private final ce a;
    private final /* synthetic */ int b = 0;

    public g(ce<d> ceVar) {
        this.a = ceVar;
    }

    public g(ce<Context> ceVar, byte[] bArr) {
        this.a = ceVar;
    }

    public g(ce<Context> ceVar, char[] cArr) {
        this.a = ceVar;
    }

    public g(ce<Context> ceVar, short[] sArr) {
        this.a = ceVar;
    }

    public static g b(ce<Context> ceVar) {
        return new g(ceVar, (short[]) null);
    }

    public final /* bridge */ /* synthetic */ Object a() {
        int i = this.b;
        if (i != 0) {
            return i != 1 ? i != 2 ? new p((Context) this.a.a()) : new q(((h) this.a).a()) : new a(((h) this.a).a());
        }
        d dVar = (d) this.a.a();
        bh.k(dVar);
        return dVar;
    }
}
