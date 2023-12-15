package org.apache.commons.compress.compressors.xz;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.tukaani.xz.MemoryLimitException;
import org.tukaani.xz.SingleXZInputStream;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZInputStream;

public class XZCompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private final CountingInputStream countingStream;

    /* renamed from: in  reason: collision with root package name */
    private final InputStream f30in;

    public static boolean matches(byte[] bArr, int i) {
        if (i < XZ.HEADER_MAGIC.length) {
            return false;
        }
        for (int i2 = 0; i2 < XZ.HEADER_MAGIC.length; i2++) {
            if (bArr[i2] != XZ.HEADER_MAGIC[i2]) {
                return false;
            }
        }
        return true;
    }

    public XZCompressorInputStream(InputStream inputStream) throws IOException {
        this(inputStream, false);
    }

    public XZCompressorInputStream(InputStream inputStream, boolean z) throws IOException {
        this(inputStream, z, -1);
    }

    public XZCompressorInputStream(InputStream inputStream, boolean z, int i) throws IOException {
        CountingInputStream countingInputStream = new CountingInputStream(inputStream);
        this.countingStream = countingInputStream;
        if (z) {
            this.f30in = new XZInputStream(countingInputStream, i);
        } else {
            this.f30in = new SingleXZInputStream(countingInputStream, i);
        }
    }

    public int read() throws IOException {
        try {
            int read = this.f30in.read();
            int i = -1;
            if (read != -1) {
                i = 1;
            }
            count(i);
            return read;
        } catch (MemoryLimitException e) {
            throw new org.apache.commons.compress.MemoryLimitException((long) e.getMemoryNeeded(), e.getMemoryLimit(), e);
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int read = this.f30in.read(bArr, i, i2);
            count(read);
            return read;
        } catch (MemoryLimitException e) {
            throw new org.apache.commons.compress.MemoryLimitException((long) e.getMemoryNeeded(), e.getMemoryLimit(), e);
        }
    }

    public long skip(long j) throws IOException {
        try {
            return IOUtils.skip(this.f30in, j);
        } catch (MemoryLimitException e) {
            throw new org.apache.commons.compress.MemoryLimitException((long) e.getMemoryNeeded(), e.getMemoryLimit(), e);
        }
    }

    public int available() throws IOException {
        return this.f30in.available();
    }

    public void close() throws IOException {
        this.f30in.close();
    }

    public long getCompressedCount() {
        return this.countingStream.getBytesRead();
    }
}
