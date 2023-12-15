package com.google.android.play.core.assetpacks;

final /* synthetic */ class cs implements Runnable {
    private final au a;

    private cs(au auVar) {
        this.a = auVar;
    }

    static Runnable a(au auVar) {
        return new cs(auVar);
    }

    public final void run() {
        this.a.s();
    }
}
