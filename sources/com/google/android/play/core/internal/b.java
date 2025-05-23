package com.google.android.play.core.internal;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class b implements c {
    private final ByteBuffer a;

    public b(ByteBuffer byteBuffer) {
        this.a = byteBuffer.slice();
    }

    public final long a() {
        return (long) this.a.capacity();
    }

    public final void b(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        ByteBuffer slice;
        synchronized (this.a) {
            int i2 = (int) j;
            this.a.position(i2);
            this.a.limit(i2 + i);
            slice = this.a.slice();
        }
        for (MessageDigest update : messageDigestArr) {
            slice.position(0);
            update.update(slice);
        }
    }
}
