package com.google.android.play.core.assetpacks;

import android.content.Intent;

final /* synthetic */ class ci implements Runnable {
    private final cj a;
    private final Intent b;

    ci(cj cjVar, Intent intent) {
        this.a = cjVar;
        this.b = intent;
    }

    public final void run() {
        this.a.l(this.b);
    }
}
