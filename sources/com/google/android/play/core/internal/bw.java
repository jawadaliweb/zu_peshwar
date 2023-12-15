package com.google.android.play.core.internal;

import java.util.Objects;

final class bw extends bt {
    private final bv a = new bv();

    bw() {
    }

    public final void a(Throwable th, Throwable th2) {
        if (th2 != th) {
            Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
            this.a.a(th).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
