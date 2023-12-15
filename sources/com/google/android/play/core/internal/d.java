package com.google.android.play.core.internal;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

final class d implements c {
    private final FileChannel a;
    private final long b;
    private final long c;

    public d(FileChannel fileChannel, long j, long j2) {
        this.a = fileChannel;
        this.b = j;
        this.c = j2;
    }

    public final long a() {
        return this.c;
    }

    public final void b(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        MappedByteBuffer map = this.a.map(FileChannel.MapMode.READ_ONLY, this.b + j, (long) i);
        map.load();
        for (MessageDigest update : messageDigestArr) {
            map.position(0);
            update.update(map);
        }
    }
}
