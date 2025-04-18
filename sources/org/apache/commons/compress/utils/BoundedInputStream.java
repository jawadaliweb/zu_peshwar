package org.apache.commons.compress.utils;

import java.io.IOException;
import java.io.InputStream;

public class BoundedInputStream extends InputStream {
    private long bytesRemaining;

    /* renamed from: in  reason: collision with root package name */
    private final InputStream f32in;

    public void close() {
    }

    public BoundedInputStream(InputStream inputStream, long j) {
        this.f32in = inputStream;
        this.bytesRemaining = j;
    }

    public int read() throws IOException {
        long j = this.bytesRemaining;
        if (j <= 0) {
            return -1;
        }
        this.bytesRemaining = j - 1;
        return this.f32in.read();
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.bytesRemaining;
        if (j == 0) {
            return -1;
        }
        if (((long) i2) > j) {
            i2 = (int) j;
        }
        int read = this.f32in.read(bArr, i, i2);
        if (read >= 0) {
            this.bytesRemaining -= (long) read;
        }
        return read;
    }
}
