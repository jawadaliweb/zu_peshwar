package com.google.android.play.core.splitinstall.testing;

import android.content.Context;
import com.google.android.play.core.internal.ce;
import com.google.android.play.core.splitinstall.p;
import com.google.android.play.core.splitinstall.y;
import java.io.File;

public final class j implements ce<FakeSplitInstallManager> {
    private final ce<Context> a;
    private final ce<File> b;
    private final ce<p> c;

    public j(ce<Context> ceVar, ce<File> ceVar2, ce<p> ceVar3) {
        this.a = ceVar;
        this.b = ceVar2;
        this.c = ceVar3;
    }

    public final /* bridge */ /* synthetic */ Object a() {
        return new FakeSplitInstallManager(((y) this.a).a(), this.b.a(), this.c.a());
    }
}
