package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.cc;
import com.google.android.play.core.internal.ce;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import java.io.File;

public final class j implements ce<i> {
    private final ce<v> a;
    private final ce<FakeSplitInstallManager> b;
    private final ce<File> c;

    public j(ce<v> ceVar, ce<FakeSplitInstallManager> ceVar2, ce<File> ceVar3) {
        this.a = ceVar;
        this.b = ceVar2;
        this.c = ceVar3;
    }

    public final /* bridge */ /* synthetic */ Object a() {
        return new i(cc.c(this.a), cc.c(this.b), cc.c(this.c));
    }
}
