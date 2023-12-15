package com.google.android.play.core.assetpacks;

import java.util.List;

final /* synthetic */ class bt implements bz {
    private final ca a;
    private final List b;
    private final /* synthetic */ int c = 0;

    bt(ca caVar, List list) {
        this.a = caVar;
        this.b = list;
    }

    bt(ca caVar, List list, byte[] bArr) {
        this.a = caVar;
        this.b = list;
    }

    public final Object a() {
        return this.c != 0 ? this.a.j(this.b) : this.a.i(this.b);
    }
}
