package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.i;
import java.util.List;

final /* synthetic */ class ce implements Runnable {
    private final cj a;
    private final List b;
    private final i c;
    private final List d;

    ce(cj cjVar, List list, i iVar, List list2) {
        this.a = cjVar;
        this.b = list;
        this.c = iVar;
        this.d = list2;
    }

    public final void run() {
        this.a.o(this.b, this.c, this.d);
    }
}
