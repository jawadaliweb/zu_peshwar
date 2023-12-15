package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.i;
import java.util.List;

final /* synthetic */ class cf implements Runnable {
    private final cj a;
    private final List b;
    private final as c;
    private final i d;

    cf(cj cjVar, List list, as asVar, i iVar) {
        this.a = cjVar;
        this.b = list;
        this.c = asVar;
        this.d = iVar;
    }

    public final void run() {
        this.a.n(this.b, this.c, this.d);
    }
}
