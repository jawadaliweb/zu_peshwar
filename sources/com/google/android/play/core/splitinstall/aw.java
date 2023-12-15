package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.ce;

public final class aw implements ce<av> {
    private final ce a;
    private final /* synthetic */ int b = 0;

    public aw(ce<Context> ceVar) {
        this.a = ceVar;
    }

    public aw(ce<Context> ceVar, byte[] bArr) {
        this.a = ceVar;
    }

    public final /* bridge */ /* synthetic */ Object a() {
        return this.b != 0 ? new au(((y) this.a).a()) : new av(((y) this.a).a());
    }
}
