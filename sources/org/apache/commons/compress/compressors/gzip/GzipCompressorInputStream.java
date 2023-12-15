package org.apache.commons.compress.compressors.gzip;

import java.io.BufferedInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.UByte;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

public class GzipCompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int FCOMMENT = 16;
    private static final int FEXTRA = 4;
    private static final int FHCRC = 2;
    private static final int FNAME = 8;
    private static final int FRESERVED = 224;
    private final byte[] buf;
    private int bufUsed;
    private final CountingInputStream countingStream;
    private final CRC32 crc;
    private final boolean decompressConcatenated;
    private boolean endReached;

    /* renamed from: in  reason: collision with root package name */
    private final InputStream f24in;
    private Inflater inf;
    private final byte[] oneByte;
    private final GzipParameters parameters;

    public GzipCompressorInputStream(InputStream inputStream) throws IOException {
        this(inputStream, false);
    }

    public GzipCompressorInputStream(InputStream inputStream, boolean z) throws IOException {
        this.buf = new byte[8192];
        this.inf = new Inflater(true);
        this.crc = new CRC32();
        this.endReached = false;
        this.oneByte = new byte[1];
        this.parameters = new GzipParameters();
        CountingInputStream countingInputStream = new CountingInputStream(inputStream);
        this.countingStream = countingInputStream;
        if (countingInputStream.markSupported()) {
            this.f24in = countingInputStream;
        } else {
            this.f24in = new BufferedInputStream(countingInputStream);
        }
        this.decompressConcatenated = z;
        init(true);
    }

    public GzipParameters getMetaData() {
        return this.parameters;
    }

    private boolean init(boolean z) throws IOException {
        int read = this.f24in.read();
        if (read == -1 && !z) {
            return false;
        }
        if (read == 31 && this.f24in.read() == 139) {
            DataInputStream dataInputStream = new DataInputStream(this.f24in);
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            if (readUnsignedByte == 8) {
                int readUnsignedByte2 = dataInputStream.readUnsignedByte();
                if ((readUnsignedByte2 & FRESERVED) == 0) {
                    this.parameters.setModificationTime(ByteUtils.fromLittleEndian((DataInput) dataInputStream, 4) * 1000);
                    int readUnsignedByte3 = dataInputStream.readUnsignedByte();
                    if (readUnsignedByte3 == 2) {
                        this.parameters.setCompressionLevel(9);
                    } else if (readUnsignedByte3 == 4) {
                        this.parameters.setCompressionLevel(1);
                    }
                    this.parameters.setOperatingSystem(dataInputStream.readUnsignedByte());
                    if ((readUnsignedByte2 & 4) != 0) {
                        int readUnsignedByte4 = (dataInputStream.readUnsignedByte() << 8) | dataInputStream.readUnsignedByte();
                        while (true) {
                            int i = readUnsignedByte4 - 1;
                            if (readUnsignedByte4 <= 0) {
                                break;
                            }
                            dataInputStream.readUnsignedByte();
                            readUnsignedByte4 = i;
                        }
                    }
                    if ((readUnsignedByte2 & 8) != 0) {
                        this.parameters.setFilename(new String(readToNull(dataInputStream), "ISO-8859-1"));
                    }
                    if ((readUnsignedByte2 & 16) != 0) {
                        this.parameters.setComment(new String(readToNull(dataInputStream), "ISO-8859-1"));
                    }
                    if ((readUnsignedByte2 & 2) != 0) {
                        dataInputStream.readShort();
                    }
                    this.inf.reset();
                    this.crc.reset();
                    return true;
                }
                throw new IOException("Reserved flags are set in the .gz header");
            }
            throw new IOException("Unsupported compression method " + readUnsignedByte + " in the .gz header");
        }
        throw new IOException(z ? "Input is not in the .gz format" : "Garbage after a valid .gz stream");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        if (r2 != null) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
        r2.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] readToNull(java.io.DataInput r2) throws java.io.IOException {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
        L_0x0005:
            int r1 = r2.readUnsignedByte()     // Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x000f
            r0.write(r1)     // Catch:{ all -> 0x0017 }
            goto L_0x0005
        L_0x000f:
            byte[] r2 = r0.toByteArray()     // Catch:{ all -> 0x0017 }
            r0.close()
            return r2
        L_0x0017:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0019 }
        L_0x0019:
            r1 = move-exception
            if (r2 == 0) goto L_0x0025
            r0.close()     // Catch:{ all -> 0x0020 }
            goto L_0x0028
        L_0x0020:
            r0 = move-exception
            r2.addSuppressed(r0)
            goto L_0x0028
        L_0x0025:
            r0.close()
        L_0x0028:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream.readToNull(java.io.DataInput):byte[]");
    }

    public int read() throws IOException {
        if (read(this.oneByte, 0, 1) == -1) {
            return -1;
        }
        return this.oneByte[0] & UByte.MAX_VALUE;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.endReached) {
            return -1;
        }
        int i3 = 0;
        while (i2 > 0) {
            if (this.inf.needsInput()) {
                this.f24in.mark(this.buf.length);
                int read = this.f24in.read(this.buf);
                this.bufUsed = read;
                if (read != -1) {
                    this.inf.setInput(this.buf, 0, read);
                } else {
                    throw new EOFException();
                }
            }
            try {
                int inflate = this.inf.inflate(bArr, i, i2);
                this.crc.update(bArr, i, inflate);
                i += inflate;
                i2 -= inflate;
                i3 += inflate;
                count(inflate);
                if (this.inf.finished()) {
                    this.f24in.reset();
                    long remaining = (long) (this.bufUsed - this.inf.getRemaining());
                    if (IOUtils.skip(this.f24in, remaining) == remaining) {
                        this.bufUsed = 0;
                        DataInputStream dataInputStream = new DataInputStream(this.f24in);
                        if (ByteUtils.fromLittleEndian((DataInput) dataInputStream, 4) != this.crc.getValue()) {
                            throw new IOException("Gzip-compressed data is corrupt (CRC32 error)");
                        } else if (ByteUtils.fromLittleEndian((DataInput) dataInputStream, 4) != (this.inf.getBytesWritten() & 4294967295L)) {
                            throw new IOException("Gzip-compressed data is corrupt(uncompressed size mismatch)");
                        } else if (!this.decompressConcatenated || !init(false)) {
                            this.inf.end();
                            this.inf = null;
                            this.endReached = true;
                            if (i3 == 0) {
                                return -1;
                            }
                            return i3;
                        }
                    } else {
                        throw new IOException();
                    }
                }
            } catch (DataFormatException unused) {
                throw new IOException("Gzip-compressed data is corrupt");
            }
        }
        return i3;
    }

    public static boolean matches(byte[] bArr, int i) {
        return i >= 2 && bArr[0] == 31 && bArr[1] == -117;
    }

    public void close() throws IOException {
        Inflater inflater = this.inf;
        if (inflater != null) {
            inflater.end();
            this.inf = null;
        }
        if (this.f24in != System.in) {
            this.f24in.close();
        }
    }

    public long getCompressedCount() {
        return this.countingStream.getBytesRead();
    }
}
