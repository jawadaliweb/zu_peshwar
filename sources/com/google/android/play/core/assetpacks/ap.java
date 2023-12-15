package com.google.android.play.core.assetpacks;

import android.os.Bundle;

final /* synthetic */ class ap implements Runnable {
    private final ar a;
    private final Bundle b;
    private final AssetPackState c;

    ap(ar arVar, Bundle bundle, AssetPackState assetPackState) {
        this.a = arVar;
        this.b = bundle;
        this.c = assetPackState;
    }

    public final void run() {
        this.a.d(this.b, this.c);
    }
}
