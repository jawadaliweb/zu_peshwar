package com.google.android.play.core.splitinstall;

import java.util.concurrent.atomic.AtomicReference;

public enum l implements e {
    ;
    
    private static final AtomicReference<f> b = null;

    static {
        a = new l();
        b = new AtomicReference<>((Object) null);
    }

    private l() {
    }

    public final f a() {
        return b.get();
    }

    public final void b(f fVar) {
        b.set(fVar);
    }
}
