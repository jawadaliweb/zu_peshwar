package com.google.android.play.core.assetpacks;

final /* synthetic */ class ao implements Runnable {
    private final ar a;
    private final AssetPackState b;

    ao(ar arVar, AssetPackState assetPackState) {
        this.a = arVar;
        this.b = assetPackState;
    }

    public final void run() {
        this.a.i(this.b);
    }
}
