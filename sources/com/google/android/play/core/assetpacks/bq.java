package com.google.android.play.core.assetpacks;

import android.os.Bundle;

final /* synthetic */ class bq implements bz {
    private final ca a;
    private final Bundle b;
    private final /* synthetic */ int c = 0;

    bq(ca caVar, Bundle bundle) {
        this.a = caVar;
        this.b = bundle;
    }

    bq(ca caVar, Bundle bundle, byte[] bArr) {
        this.a = caVar;
        this.b = bundle;
    }

    public final Object a() {
        return this.c != 0 ? this.a.l(this.b) : this.a.k(this.b);
    }
}
