package com.google.android.play.core.assetpacks;

final /* synthetic */ class cg implements Runnable {
    private final cj a;
    private final int b;
    private final String c;

    cg(cj cjVar, int i, String str) {
        this.a = cjVar;
        this.b = i;
        this.c = str;
    }

    public final void run() {
        this.a.m(this.b, this.c);
    }
}
