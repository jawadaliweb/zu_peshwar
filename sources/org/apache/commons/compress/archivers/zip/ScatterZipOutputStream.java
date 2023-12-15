package org.apache.commons.compress.archivers.zip;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.compress.parallel.FileBasedScatterGatherBackingStore;
import org.apache.commons.compress.parallel.ScatterGatherBackingStore;

public class ScatterZipOutputStream implements Closeable {
    /* access modifiers changed from: private */
    public final ScatterGatherBackingStore backingStore;
    private AtomicBoolean isClosed = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final Queue<CompressedEntry> items = new ConcurrentLinkedQueue();
    private final StreamCompressor streamCompressor;
    private ZipEntryWriter zipEntryWriter = null;

    private static class CompressedEntry {
        final long compressedSize;
        final long crc;
        final long size;
        final ZipArchiveEntryRequest zipArchiveEntryRequest;

        public CompressedEntry(ZipArchiveEntryRequest zipArchiveEntryRequest2, long j, long j2, long j3) {
            this.zipArchiveEntryRequest = zipArchiveEntryRequest2;
            this.crc = j;
            this.compressedSize = j2;
            this.size = j3;
        }

        public ZipArchiveEntry transferToArchiveEntry() {
            ZipArchiveEntry zipArchiveEntry = this.zipArchiveEntryRequest.getZipArchiveEntry();
            zipArchiveEntry.setCompressedSize(this.compressedSize);
            zipArchiveEntry.setSize(this.size);
            zipArchiveEntry.setCrc(this.crc);
            zipArchiveEntry.setMethod(this.zipArchiveEntryRequest.getMethod());
            return zipArchiveEntry;
        }
    }

    public ScatterZipOutputStream(ScatterGatherBackingStore scatterGatherBackingStore, StreamCompressor streamCompressor2) {
        this.backingStore = scatterGatherBackingStore;
        this.streamCompressor = streamCompressor2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0033, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r0 != null) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        if (r11 != null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        r11.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addArchiveEntry(org.apache.commons.compress.archivers.zip.ZipArchiveEntryRequest r11) throws java.io.IOException {
        /*
            r10 = this;
            java.io.InputStream r0 = r11.getPayloadStream()
            org.apache.commons.compress.archivers.zip.StreamCompressor r1 = r10.streamCompressor     // Catch:{ all -> 0x0031 }
            int r2 = r11.getMethod()     // Catch:{ all -> 0x0031 }
            r1.deflate(r0, r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0012
            r0.close()
        L_0x0012:
            java.util.Queue<org.apache.commons.compress.archivers.zip.ScatterZipOutputStream$CompressedEntry> r0 = r10.items
            org.apache.commons.compress.archivers.zip.ScatterZipOutputStream$CompressedEntry r9 = new org.apache.commons.compress.archivers.zip.ScatterZipOutputStream$CompressedEntry
            org.apache.commons.compress.archivers.zip.StreamCompressor r1 = r10.streamCompressor
            long r3 = r1.getCrc32()
            org.apache.commons.compress.archivers.zip.StreamCompressor r1 = r10.streamCompressor
            long r5 = r1.getBytesWrittenForLastEntry()
            org.apache.commons.compress.archivers.zip.StreamCompressor r1 = r10.streamCompressor
            long r7 = r1.getBytesRead()
            r1 = r9
            r2 = r11
            r1.<init>(r2, r3, r5, r7)
            r0.add(r9)
            return
        L_0x0031:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x0033 }
        L_0x0033:
            r1 = move-exception
            if (r0 == 0) goto L_0x0044
            if (r11 == 0) goto L_0x0041
            r0.close()     // Catch:{ all -> 0x003c }
            goto L_0x0044
        L_0x003c:
            r0 = move-exception
            r11.addSuppressed(r0)
            goto L_0x0044
        L_0x0041:
            r0.close()
        L_0x0044:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.zip.ScatterZipOutputStream.addArchiveEntry(org.apache.commons.compress.archivers.zip.ZipArchiveEntryRequest):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r7 != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r7.addSuppressed(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0049, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004a, code lost:
        if (r0 != null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004c, code lost:
        if (r7 != null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0052, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0053, code lost:
        r7.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0057, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x005a, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeTo(org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream r7) throws java.io.IOException {
        /*
            r6 = this;
            org.apache.commons.compress.parallel.ScatterGatherBackingStore r0 = r6.backingStore
            r0.closeForWriting()
            org.apache.commons.compress.parallel.ScatterGatherBackingStore r0 = r6.backingStore
            java.io.InputStream r0 = r0.getInputStream()
            java.util.Queue<org.apache.commons.compress.archivers.zip.ScatterZipOutputStream$CompressedEntry> r1 = r6.items     // Catch:{ all -> 0x0047 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0047 }
        L_0x0011:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x0041
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0047 }
            org.apache.commons.compress.archivers.zip.ScatterZipOutputStream$CompressedEntry r2 = (org.apache.commons.compress.archivers.zip.ScatterZipOutputStream.CompressedEntry) r2     // Catch:{ all -> 0x0047 }
            org.apache.commons.compress.utils.BoundedInputStream r3 = new org.apache.commons.compress.utils.BoundedInputStream     // Catch:{ all -> 0x0047 }
            long r4 = r2.compressedSize     // Catch:{ all -> 0x0047 }
            r3.<init>(r0, r4)     // Catch:{ all -> 0x0047 }
            org.apache.commons.compress.archivers.zip.ZipArchiveEntry r2 = r2.transferToArchiveEntry()     // Catch:{ all -> 0x002f }
            r7.addRawArchiveEntry(r2, r3)     // Catch:{ all -> 0x002f }
            r3.close()     // Catch:{ all -> 0x0047 }
            goto L_0x0011
        L_0x002f:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0031 }
        L_0x0031:
            r1 = move-exception
            if (r7 == 0) goto L_0x003d
            r3.close()     // Catch:{ all -> 0x0038 }
            goto L_0x0040
        L_0x0038:
            r2 = move-exception
            r7.addSuppressed(r2)     // Catch:{ all -> 0x0047 }
            goto L_0x0040
        L_0x003d:
            r3.close()     // Catch:{ all -> 0x0047 }
        L_0x0040:
            throw r1     // Catch:{ all -> 0x0047 }
        L_0x0041:
            if (r0 == 0) goto L_0x0046
            r0.close()
        L_0x0046:
            return
        L_0x0047:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r1 = move-exception
            if (r0 == 0) goto L_0x005a
            if (r7 == 0) goto L_0x0057
            r0.close()     // Catch:{ all -> 0x0052 }
            goto L_0x005a
        L_0x0052:
            r0 = move-exception
            r7.addSuppressed(r0)
            goto L_0x005a
        L_0x0057:
            r0.close()
        L_0x005a:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.zip.ScatterZipOutputStream.writeTo(org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream):void");
    }

    public static class ZipEntryWriter implements Closeable {
        private final Iterator<CompressedEntry> itemsIterator;
        private final InputStream itemsIteratorData;

        public ZipEntryWriter(ScatterZipOutputStream scatterZipOutputStream) throws IOException {
            scatterZipOutputStream.backingStore.closeForWriting();
            this.itemsIterator = scatterZipOutputStream.items.iterator();
            this.itemsIteratorData = scatterZipOutputStream.backingStore.getInputStream();
        }

        public void close() throws IOException {
            InputStream inputStream = this.itemsIteratorData;
            if (inputStream != null) {
                inputStream.close();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
            r6.addSuppressed(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
            if (r6 != null) goto L_0x0021;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeNextZipEntry(org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream r6) throws java.io.IOException {
            /*
                r5 = this;
                java.util.Iterator<org.apache.commons.compress.archivers.zip.ScatterZipOutputStream$CompressedEntry> r0 = r5.itemsIterator
                java.lang.Object r0 = r0.next()
                org.apache.commons.compress.archivers.zip.ScatterZipOutputStream$CompressedEntry r0 = (org.apache.commons.compress.archivers.zip.ScatterZipOutputStream.CompressedEntry) r0
                org.apache.commons.compress.utils.BoundedInputStream r1 = new org.apache.commons.compress.utils.BoundedInputStream
                java.io.InputStream r2 = r5.itemsIteratorData
                long r3 = r0.compressedSize
                r1.<init>(r2, r3)
                org.apache.commons.compress.archivers.zip.ZipArchiveEntry r0 = r0.transferToArchiveEntry()     // Catch:{ all -> 0x001c }
                r6.addRawArchiveEntry(r0, r1)     // Catch:{ all -> 0x001c }
                r1.close()
                return
            L_0x001c:
                r6 = move-exception
                throw r6     // Catch:{ all -> 0x001e }
            L_0x001e:
                r0 = move-exception
                if (r6 == 0) goto L_0x002a
                r1.close()     // Catch:{ all -> 0x0025 }
                goto L_0x002d
            L_0x0025:
                r1 = move-exception
                r6.addSuppressed(r1)
                goto L_0x002d
            L_0x002a:
                r1.close()
            L_0x002d:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.zip.ScatterZipOutputStream.ZipEntryWriter.writeNextZipEntry(org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream):void");
        }
    }

    public ZipEntryWriter zipEntryWriter() throws IOException {
        if (this.zipEntryWriter == null) {
            this.zipEntryWriter = new ZipEntryWriter(this);
        }
        return this.zipEntryWriter;
    }

    public void close() throws IOException {
        if (this.isClosed.compareAndSet(false, true)) {
            try {
                ZipEntryWriter zipEntryWriter2 = this.zipEntryWriter;
                if (zipEntryWriter2 != null) {
                    zipEntryWriter2.close();
                }
                this.backingStore.close();
            } finally {
                this.streamCompressor.close();
            }
        }
    }

    public static ScatterZipOutputStream fileBased(File file) throws FileNotFoundException {
        return fileBased(file, -1);
    }

    public static ScatterZipOutputStream fileBased(File file, int i) throws FileNotFoundException {
        FileBasedScatterGatherBackingStore fileBasedScatterGatherBackingStore = new FileBasedScatterGatherBackingStore(file);
        return new ScatterZipOutputStream(fileBasedScatterGatherBackingStore, StreamCompressor.create(i, (ScatterGatherBackingStore) fileBasedScatterGatherBackingStore));
    }
}
