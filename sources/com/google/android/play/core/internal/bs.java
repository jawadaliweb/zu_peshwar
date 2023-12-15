package com.google.android.play.core.internal;

import java.io.IOException;
import java.io.InputStream;

public final class bs extends br {
    private final br a;
    private final long b;
    private final long c;

    public bs(br brVar, long j, long j2) {
        this.a = brVar;
        long d = d(j);
        this.b = d;
        this.c = d(d + j2);
    }

    private final long d(long j) {
        if (j < 0) {
            return 0;
        }
        return j > this.a.a() ? this.a.a() : j;
    }

    public final long a() {
        return this.c - this.b;
    }

    /* access modifiers changed from: protected */
    public final InputStream b(long j, long j2) throws IOException {
        long d = d(this.b);
        return this.a.b(d, d(j2 + d) - d);
    }

    public final void close() throws IOException {
    }
}
