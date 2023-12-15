package com.google.android.play.core.assetpacks;

final /* synthetic */ class cr implements Runnable {
    private final ct a;
    private final cq b;

    cr(ct ctVar, cq cqVar) {
        this.a = ctVar;
        this.b = cqVar;
    }

    public final void run() {
        this.a.b(this.b);
    }
}
