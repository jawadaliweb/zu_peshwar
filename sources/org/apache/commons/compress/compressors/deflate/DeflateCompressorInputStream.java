package org.apache.commons.compress.compressors.deflate;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

public class DeflateCompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private static final int MAGIC_1 = 120;
    private static final int MAGIC_2a = 1;
    private static final int MAGIC_2b = 94;
    private static final int MAGIC_2c = 156;
    private static final int MAGIC_2d = 218;
    private final CountingInputStream countingStream;

    /* renamed from: in  reason: collision with root package name */
    private final InputStream f22in;
    private final Inflater inflater;

    public DeflateCompressorInputStream(InputStream inputStream) {
        this(inputStream, new DeflateParameters());
    }

    public DeflateCompressorInputStream(InputStream inputStream, DeflateParameters deflateParameters) {
        Inflater inflater2 = new Inflater(!deflateParameters.withZlibHeader());
        this.inflater = inflater2;
        CountingInputStream countingInputStream = new CountingInputStream(inputStream);
        this.countingStream = countingInputStream;
        this.f22in = new InflaterInputStream(countingInputStream, inflater2);
    }

    public int read() throws IOException {
        int read = this.f22in.read();
        count(read == -1 ? 0 : 1);
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.f22in.read(bArr, i, i2);
        count(read);
        return read;
    }

    public long skip(long j) throws IOException {
        return IOUtils.skip(this.f22in, j);
    }

    public int available() throws IOException {
        return this.f22in.available();
    }

    public void close() throws IOException {
        try {
            this.f22in.close();
        } finally {
            this.inflater.end();
        }
    }

    public long getCompressedCount() {
        return this.countingStream.getBytesRead();
    }

    public static boolean matches(byte[] bArr, int i) {
        if (i <= 3 || bArr[0] != 120) {
            return false;
        }
        return bArr[1] == 1 || bArr[1] == 94 || bArr[1] == -100 || bArr[1] == -38;
    }
}
