package com.google.android.play.core.assetpacks;

import android.os.Bundle;

final /* synthetic */ class aq implements Runnable {
    private final ar a;
    private final Bundle b;

    aq(ar arVar, Bundle bundle) {
        this.a = arVar;
        this.b = bundle;
    }

    public final void run() {
        this.a.c(this.b);
    }
}
