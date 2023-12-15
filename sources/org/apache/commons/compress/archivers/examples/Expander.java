package org.apache.commons.compress.archivers.examples;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.SeekableByteChannel;
import java.util.Enumeration;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;

public class Expander {

    private interface ArchiveEntrySupplier {
        ArchiveEntry getNextReadableEntry() throws IOException;
    }

    private interface EntryWriter {
        void writeEntryDataTo(ArchiveEntry archiveEntry, OutputStream outputStream) throws IOException;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        r4.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        if (r4 != null) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void expand(java.io.File r4, java.io.File r5) throws java.io.IOException, org.apache.commons.compress.archivers.ArchiveException {
        /*
            r3 = this;
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            java.nio.file.Path r1 = r4.toPath()
            r2 = 0
            java.nio.file.OpenOption[] r2 = new java.nio.file.OpenOption[r2]
            java.io.InputStream r1 = java.nio.file.Files.newInputStream(r1, r2)
            r0.<init>(r1)
            org.apache.commons.compress.archivers.ArchiveStreamFactory r1 = new org.apache.commons.compress.archivers.ArchiveStreamFactory     // Catch:{ all -> 0x0020 }
            r1.<init>()     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = org.apache.commons.compress.archivers.ArchiveStreamFactory.detect(r0)     // Catch:{ all -> 0x0020 }
            r0.close()
            r3.expand((java.lang.String) r1, (java.io.File) r4, (java.io.File) r5)
            return
        L_0x0020:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r5 = move-exception
            if (r4 == 0) goto L_0x002e
            r0.close()     // Catch:{ all -> 0x0029 }
            goto L_0x0031
        L_0x0029:
            r0 = move-exception
            r4.addSuppressed(r0)
            goto L_0x0031
        L_0x002e:
            r0.close()
        L_0x0031:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Expander.expand(java.io.File, java.io.File):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        if (r5 != null) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        if (r4 != null) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        r4.addSuppressed(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004f, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0050, code lost:
        if (r4 != null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0056, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0057, code lost:
        r4.addSuppressed(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005b, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005e, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void expand(java.lang.String r4, java.io.File r5, java.io.File r6) throws java.io.IOException, org.apache.commons.compress.archivers.ArchiveException {
        /*
            r3 = this;
            boolean r0 = r3.prefersSeekableByteChannel(r4)
            r1 = 0
            if (r0 == 0) goto L_0x0035
            java.nio.file.Path r5 = r5.toPath()
            r0 = 1
            java.nio.file.OpenOption[] r0 = new java.nio.file.OpenOption[r0]
            java.nio.file.StandardOpenOption r2 = java.nio.file.StandardOpenOption.READ
            r0[r1] = r2
            java.nio.channels.FileChannel r5 = java.nio.channels.FileChannel.open(r5, r0)
            org.apache.commons.compress.archivers.examples.CloseableConsumer r0 = org.apache.commons.compress.archivers.examples.CloseableConsumer.CLOSING_CONSUMER     // Catch:{ all -> 0x0021 }
            r3.expand((java.lang.String) r4, (java.nio.channels.SeekableByteChannel) r5, (java.io.File) r6, (org.apache.commons.compress.archivers.examples.CloseableConsumer) r0)     // Catch:{ all -> 0x0021 }
            if (r5 == 0) goto L_0x0020
            r5.close()
        L_0x0020:
            return
        L_0x0021:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r6 = move-exception
            if (r5 == 0) goto L_0x0034
            if (r4 == 0) goto L_0x0031
            r5.close()     // Catch:{ all -> 0x002c }
            goto L_0x0034
        L_0x002c:
            r5 = move-exception
            r4.addSuppressed(r5)
            goto L_0x0034
        L_0x0031:
            r5.close()
        L_0x0034:
            throw r6
        L_0x0035:
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            java.nio.file.Path r5 = r5.toPath()
            java.nio.file.OpenOption[] r1 = new java.nio.file.OpenOption[r1]
            java.io.InputStream r5 = java.nio.file.Files.newInputStream(r5, r1)
            r0.<init>(r5)
            org.apache.commons.compress.archivers.examples.CloseableConsumer r5 = org.apache.commons.compress.archivers.examples.CloseableConsumer.CLOSING_CONSUMER     // Catch:{ all -> 0x004d }
            r3.expand((java.lang.String) r4, (java.io.InputStream) r0, (java.io.File) r6, (org.apache.commons.compress.archivers.examples.CloseableConsumer) r5)     // Catch:{ all -> 0x004d }
            r0.close()
            return
        L_0x004d:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x004f }
        L_0x004f:
            r5 = move-exception
            if (r4 == 0) goto L_0x005b
            r0.close()     // Catch:{ all -> 0x0056 }
            goto L_0x005e
        L_0x0056:
            r6 = move-exception
            r4.addSuppressed(r6)
            goto L_0x005e
        L_0x005b:
            r0.close()
        L_0x005e:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Expander.expand(java.lang.String, java.io.File, java.io.File):void");
    }

    @Deprecated
    public void expand(InputStream inputStream, File file) throws IOException, ArchiveException {
        expand(inputStream, file, CloseableConsumer.NULL_CONSUMER);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        r2.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        if (r2 != null) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void expand(java.io.InputStream r2, java.io.File r3, org.apache.commons.compress.archivers.examples.CloseableConsumer r4) throws java.io.IOException, org.apache.commons.compress.archivers.ArchiveException {
        /*
            r1 = this;
            org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter r0 = new org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter
            r0.<init>(r4)
            org.apache.commons.compress.archivers.ArchiveStreamFactory r4 = new org.apache.commons.compress.archivers.ArchiveStreamFactory     // Catch:{ all -> 0x001b }
            r4.<init>()     // Catch:{ all -> 0x001b }
            org.apache.commons.compress.archivers.ArchiveInputStream r2 = r4.createArchiveInputStream(r2)     // Catch:{ all -> 0x001b }
            java.io.Closeable r2 = r0.track(r2)     // Catch:{ all -> 0x001b }
            org.apache.commons.compress.archivers.ArchiveInputStream r2 = (org.apache.commons.compress.archivers.ArchiveInputStream) r2     // Catch:{ all -> 0x001b }
            r1.expand((org.apache.commons.compress.archivers.ArchiveInputStream) r2, (java.io.File) r3)     // Catch:{ all -> 0x001b }
            r0.close()
            return
        L_0x001b:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001d }
        L_0x001d:
            r3 = move-exception
            if (r2 == 0) goto L_0x0029
            r0.close()     // Catch:{ all -> 0x0024 }
            goto L_0x002c
        L_0x0024:
            r4 = move-exception
            r2.addSuppressed(r4)
            goto L_0x002c
        L_0x0029:
            r0.close()
        L_0x002c:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Expander.expand(java.io.InputStream, java.io.File, org.apache.commons.compress.archivers.examples.CloseableConsumer):void");
    }

    @Deprecated
    public void expand(String str, InputStream inputStream, File file) throws IOException, ArchiveException {
        expand(str, inputStream, file, CloseableConsumer.NULL_CONSUMER);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        r2.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        if (r2 != null) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void expand(java.lang.String r2, java.io.InputStream r3, java.io.File r4, org.apache.commons.compress.archivers.examples.CloseableConsumer r5) throws java.io.IOException, org.apache.commons.compress.archivers.ArchiveException {
        /*
            r1 = this;
            org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter r0 = new org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter
            r0.<init>(r5)
            org.apache.commons.compress.archivers.ArchiveStreamFactory r5 = new org.apache.commons.compress.archivers.ArchiveStreamFactory     // Catch:{ all -> 0x001b }
            r5.<init>()     // Catch:{ all -> 0x001b }
            org.apache.commons.compress.archivers.ArchiveInputStream r2 = r5.createArchiveInputStream(r2, r3)     // Catch:{ all -> 0x001b }
            java.io.Closeable r2 = r0.track(r2)     // Catch:{ all -> 0x001b }
            org.apache.commons.compress.archivers.ArchiveInputStream r2 = (org.apache.commons.compress.archivers.ArchiveInputStream) r2     // Catch:{ all -> 0x001b }
            r1.expand((org.apache.commons.compress.archivers.ArchiveInputStream) r2, (java.io.File) r4)     // Catch:{ all -> 0x001b }
            r0.close()
            return
        L_0x001b:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001d }
        L_0x001d:
            r3 = move-exception
            if (r2 == 0) goto L_0x0029
            r0.close()     // Catch:{ all -> 0x0024 }
            goto L_0x002c
        L_0x0024:
            r4 = move-exception
            r2.addSuppressed(r4)
            goto L_0x002c
        L_0x0029:
            r0.close()
        L_0x002c:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Expander.expand(java.lang.String, java.io.InputStream, java.io.File, org.apache.commons.compress.archivers.examples.CloseableConsumer):void");
    }

    @Deprecated
    public void expand(String str, SeekableByteChannel seekableByteChannel, File file) throws IOException, ArchiveException {
        expand(str, seekableByteChannel, file, CloseableConsumer.NULL_CONSUMER);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0063, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0064, code lost:
        if (r2 != null) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006b, code lost:
        r2.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006f, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0072, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void expand(java.lang.String r2, java.nio.channels.SeekableByteChannel r3, java.io.File r4, org.apache.commons.compress.archivers.examples.CloseableConsumer r5) throws java.io.IOException, org.apache.commons.compress.archivers.ArchiveException {
        /*
            r1 = this;
            org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter r0 = new org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter
            r0.<init>(r5)
            boolean r5 = r1.prefersSeekableByteChannel(r2)     // Catch:{ all -> 0x0061 }
            if (r5 != 0) goto L_0x0019
            java.io.InputStream r3 = java.nio.channels.Channels.newInputStream(r3)     // Catch:{ all -> 0x0061 }
            java.io.Closeable r3 = r0.track(r3)     // Catch:{ all -> 0x0061 }
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch:{ all -> 0x0061 }
            r1.expand((java.lang.String) r2, (java.io.InputStream) r3, (java.io.File) r4)     // Catch:{ all -> 0x0061 }
            goto L_0x0046
        L_0x0019:
            java.lang.String r5 = "zip"
            boolean r5 = r5.equalsIgnoreCase(r2)     // Catch:{ all -> 0x0061 }
            if (r5 == 0) goto L_0x0030
            org.apache.commons.compress.archivers.zip.ZipFile r2 = new org.apache.commons.compress.archivers.zip.ZipFile     // Catch:{ all -> 0x0061 }
            r2.<init>((java.nio.channels.SeekableByteChannel) r3)     // Catch:{ all -> 0x0061 }
            java.io.Closeable r2 = r0.track(r2)     // Catch:{ all -> 0x0061 }
            org.apache.commons.compress.archivers.zip.ZipFile r2 = (org.apache.commons.compress.archivers.zip.ZipFile) r2     // Catch:{ all -> 0x0061 }
            r1.expand((org.apache.commons.compress.archivers.zip.ZipFile) r2, (java.io.File) r4)     // Catch:{ all -> 0x0061 }
            goto L_0x0046
        L_0x0030:
            java.lang.String r5 = "7z"
            boolean r5 = r5.equalsIgnoreCase(r2)     // Catch:{ all -> 0x0061 }
            if (r5 == 0) goto L_0x004a
            org.apache.commons.compress.archivers.sevenz.SevenZFile r2 = new org.apache.commons.compress.archivers.sevenz.SevenZFile     // Catch:{ all -> 0x0061 }
            r2.<init>((java.nio.channels.SeekableByteChannel) r3)     // Catch:{ all -> 0x0061 }
            java.io.Closeable r2 = r0.track(r2)     // Catch:{ all -> 0x0061 }
            org.apache.commons.compress.archivers.sevenz.SevenZFile r2 = (org.apache.commons.compress.archivers.sevenz.SevenZFile) r2     // Catch:{ all -> 0x0061 }
            r1.expand((org.apache.commons.compress.archivers.sevenz.SevenZFile) r2, (java.io.File) r4)     // Catch:{ all -> 0x0061 }
        L_0x0046:
            r0.close()
            return
        L_0x004a:
            org.apache.commons.compress.archivers.ArchiveException r3 = new org.apache.commons.compress.archivers.ArchiveException     // Catch:{ all -> 0x0061 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r4.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = "Don't know how to handle format "
            r4.append(r5)     // Catch:{ all -> 0x0061 }
            r4.append(r2)     // Catch:{ all -> 0x0061 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0061 }
            r3.<init>(r2)     // Catch:{ all -> 0x0061 }
            throw r3     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0063 }
        L_0x0063:
            r3 = move-exception
            if (r2 == 0) goto L_0x006f
            r0.close()     // Catch:{ all -> 0x006a }
            goto L_0x0072
        L_0x006a:
            r4 = move-exception
            r2.addSuppressed(r4)
            goto L_0x0072
        L_0x006f:
            r0.close()
        L_0x0072:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Expander.expand(java.lang.String, java.nio.channels.SeekableByteChannel, java.io.File, org.apache.commons.compress.archivers.examples.CloseableConsumer):void");
    }

    public void expand(final ArchiveInputStream archiveInputStream, File file) throws IOException, ArchiveException {
        expand((ArchiveEntrySupplier) new ArchiveEntrySupplier() {
            public ArchiveEntry getNextReadableEntry() throws IOException {
                ArchiveEntry nextEntry = archiveInputStream.getNextEntry();
                while (nextEntry != null && !archiveInputStream.canReadEntryData(nextEntry)) {
                    nextEntry = archiveInputStream.getNextEntry();
                }
                return nextEntry;
            }
        }, (EntryWriter) new EntryWriter() {
            public void writeEntryDataTo(ArchiveEntry archiveEntry, OutputStream outputStream) throws IOException {
                IOUtils.copy(archiveInputStream, outputStream);
            }
        }, file);
    }

    public void expand(final ZipFile zipFile, File file) throws IOException, ArchiveException {
        final Enumeration<ZipArchiveEntry> entries = zipFile.getEntries();
        expand((ArchiveEntrySupplier) new ArchiveEntrySupplier() {
            /* JADX WARNING: Removed duplicated region for block: B:10:0x002e A[EDGE_INSN: B:11:0x002e->B:10:0x002e ?: BREAK  
            EDGE_INSN: B:13:0x002e->B:10:0x002e ?: BREAK  , RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:7:0x001d  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public org.apache.commons.compress.archivers.ArchiveEntry getNextReadableEntry() throws java.io.IOException {
                /*
                    r3 = this;
                    java.util.Enumeration r0 = r0
                    boolean r0 = r0.hasMoreElements()
                    r1 = 0
                    if (r0 == 0) goto L_0x0012
                    java.util.Enumeration r0 = r0
                    java.lang.Object r0 = r0.nextElement()
                    org.apache.commons.compress.archivers.zip.ZipArchiveEntry r0 = (org.apache.commons.compress.archivers.zip.ZipArchiveEntry) r0
                    goto L_0x0013
                L_0x0012:
                    r0 = r1
                L_0x0013:
                    if (r0 == 0) goto L_0x002e
                    org.apache.commons.compress.archivers.zip.ZipFile r2 = r3
                    boolean r2 = r2.canReadEntryData(r0)
                    if (r2 != 0) goto L_0x002e
                    java.util.Enumeration r0 = r0
                    boolean r0 = r0.hasMoreElements()
                    if (r0 == 0) goto L_0x0012
                    java.util.Enumeration r0 = r0
                    java.lang.Object r0 = r0.nextElement()
                    org.apache.commons.compress.archivers.zip.ZipArchiveEntry r0 = (org.apache.commons.compress.archivers.zip.ZipArchiveEntry) r0
                    goto L_0x0013
                L_0x002e:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Expander.AnonymousClass3.getNextReadableEntry():org.apache.commons.compress.archivers.ArchiveEntry");
            }
        }, (EntryWriter) new EntryWriter() {
            /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
                r2.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
                r2 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
                r3.addSuppressed(r2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
                if (r2 != null) goto L_0x0016;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void writeEntryDataTo(org.apache.commons.compress.archivers.ArchiveEntry r2, java.io.OutputStream r3) throws java.io.IOException {
                /*
                    r1 = this;
                    org.apache.commons.compress.archivers.zip.ZipFile r0 = r3
                    org.apache.commons.compress.archivers.zip.ZipArchiveEntry r2 = (org.apache.commons.compress.archivers.zip.ZipArchiveEntry) r2
                    java.io.InputStream r2 = r0.getInputStream(r2)
                    org.apache.commons.compress.utils.IOUtils.copy(r2, r3)     // Catch:{ all -> 0x0011 }
                    if (r2 == 0) goto L_0x0010
                    r2.close()
                L_0x0010:
                    return
                L_0x0011:
                    r3 = move-exception
                    throw r3     // Catch:{ all -> 0x0013 }
                L_0x0013:
                    r0 = move-exception
                    if (r2 == 0) goto L_0x001e
                    r2.close()     // Catch:{ all -> 0x001a }
                    goto L_0x001e
                L_0x001a:
                    r2 = move-exception
                    r3.addSuppressed(r2)
                L_0x001e:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Expander.AnonymousClass4.writeEntryDataTo(org.apache.commons.compress.archivers.ArchiveEntry, java.io.OutputStream):void");
            }
        }, file);
    }

    public void expand(final SevenZFile sevenZFile, File file) throws IOException, ArchiveException {
        expand((ArchiveEntrySupplier) new ArchiveEntrySupplier() {
            public ArchiveEntry getNextReadableEntry() throws IOException {
                return sevenZFile.getNextEntry();
            }
        }, (EntryWriter) new EntryWriter() {
            public void writeEntryDataTo(ArchiveEntry archiveEntry, OutputStream outputStream) throws IOException {
                byte[] bArr = new byte[8024];
                while (true) {
                    int read = sevenZFile.read(bArr);
                    if (-1 != read) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        return;
                    }
                }
            }
        }, file);
    }

    private boolean prefersSeekableByteChannel(String str) {
        return ArchiveStreamFactory.ZIP.equalsIgnoreCase(str) || ArchiveStreamFactory.SEVEN_Z.equalsIgnoreCase(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a0, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a1, code lost:
        if (r2 != null) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a7, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a8, code lost:
        r7.addSuppressed(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ab, code lost:
        throw r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void expand(org.apache.commons.compress.archivers.examples.Expander.ArchiveEntrySupplier r7, org.apache.commons.compress.archivers.examples.Expander.EntryWriter r8, java.io.File r9) throws java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = r9.getCanonicalPath()
            java.lang.String r1 = java.io.File.separator
            boolean r1 = r0.endsWith(r1)
            if (r1 != 0) goto L_0x001d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = java.io.File.separator
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x001d:
            org.apache.commons.compress.archivers.ArchiveEntry r1 = r7.getNextReadableEntry()
        L_0x0021:
            if (r1 == 0) goto L_0x00cf
            java.io.File r2 = new java.io.File
            java.lang.String r3 = r1.getName()
            r2.<init>(r9, r3)
            java.lang.String r3 = r2.getCanonicalPath()
            boolean r3 = r3.startsWith(r0)
            if (r3 == 0) goto L_0x00ac
            boolean r3 = r1.isDirectory()
            java.lang.String r4 = "Failed to create directory "
            if (r3 == 0) goto L_0x0060
            boolean r1 = r2.isDirectory()
            if (r1 != 0) goto L_0x0099
            boolean r1 = r2.mkdirs()
            if (r1 == 0) goto L_0x004b
            goto L_0x0099
        L_0x004b:
            java.io.IOException r7 = new java.io.IOException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r4)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0060:
            java.io.File r3 = r2.getParentFile()
            boolean r5 = r3.isDirectory()
            if (r5 != 0) goto L_0x0086
            boolean r5 = r3.mkdirs()
            if (r5 == 0) goto L_0x0071
            goto L_0x0086
        L_0x0071:
            java.io.IOException r7 = new java.io.IOException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r4)
            r8.append(r3)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0086:
            java.nio.file.Path r2 = r2.toPath()
            r3 = 0
            java.nio.file.OpenOption[] r3 = new java.nio.file.OpenOption[r3]
            java.io.OutputStream r2 = java.nio.file.Files.newOutputStream(r2, r3)
            r8.writeEntryDataTo(r1, r2)     // Catch:{ all -> 0x009e }
            if (r2 == 0) goto L_0x0099
            r2.close()
        L_0x0099:
            org.apache.commons.compress.archivers.ArchiveEntry r1 = r7.getNextReadableEntry()
            goto L_0x0021
        L_0x009e:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x00a0 }
        L_0x00a0:
            r8 = move-exception
            if (r2 == 0) goto L_0x00ab
            r2.close()     // Catch:{ all -> 0x00a7 }
            goto L_0x00ab
        L_0x00a7:
            r9 = move-exception
            r7.addSuppressed(r9)
        L_0x00ab:
            throw r8
        L_0x00ac:
            java.io.IOException r7 = new java.io.IOException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Expanding "
            r8.append(r0)
            java.lang.String r0 = r1.getName()
            r8.append(r0)
            java.lang.String r0 = " would create file outside of "
            r8.append(r0)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Expander.expand(org.apache.commons.compress.archivers.examples.Expander$ArchiveEntrySupplier, org.apache.commons.compress.archivers.examples.Expander$EntryWriter, java.io.File):void");
    }
}
