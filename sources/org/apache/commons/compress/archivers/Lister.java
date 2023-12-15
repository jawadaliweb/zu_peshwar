package org.apache.commons.compress.archivers;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;

public final class Lister {
    private static final ArchiveStreamFactory factory = new ArchiveStreamFactory();

    public static void main(String[] strArr) throws Exception {
        if (strArr.length == 0) {
            usage();
            return;
        }
        PrintStream printStream = System.out;
        printStream.println("Analysing " + strArr[0]);
        File file = new File(strArr[0]);
        if (!file.isFile()) {
            PrintStream printStream2 = System.err;
            printStream2.println(file + " doesn't exist or is a directory");
        }
        String detectFormat = strArr.length > 1 ? strArr[1] : detectFormat(file);
        if (ArchiveStreamFactory.SEVEN_Z.equalsIgnoreCase(detectFormat)) {
            list7z(file);
        } else if ("zipfile".equals(detectFormat)) {
            listZipUsingZipFile(file);
        } else {
            listStream(file, strArr);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        if (r3 != null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        if (r4 != null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r4.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005d, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005e, code lost:
        if (r3 != null) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0064, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0065, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0069, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006c, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void listStream(java.io.File r3, java.lang.String[] r4) throws org.apache.commons.compress.archivers.ArchiveException, java.io.IOException {
        /*
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            java.nio.file.Path r3 = r3.toPath()
            r1 = 0
            java.nio.file.OpenOption[] r1 = new java.nio.file.OpenOption[r1]
            java.io.InputStream r3 = java.nio.file.Files.newInputStream(r3, r1)
            r0.<init>(r3)
            org.apache.commons.compress.archivers.ArchiveInputStream r3 = createArchiveInputStream(r4, r0)     // Catch:{ all -> 0x005b }
            java.io.PrintStream r4 = java.lang.System.out     // Catch:{ all -> 0x0047 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0047 }
            r1.<init>()     // Catch:{ all -> 0x0047 }
            java.lang.String r2 = "Created "
            r1.append(r2)     // Catch:{ all -> 0x0047 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0047 }
            r1.append(r2)     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0047 }
            r4.println(r1)     // Catch:{ all -> 0x0047 }
        L_0x002e:
            org.apache.commons.compress.archivers.ArchiveEntry r4 = r3.getNextEntry()     // Catch:{ all -> 0x0047 }
            if (r4 == 0) goto L_0x003e
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ all -> 0x0047 }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0047 }
            r1.println(r4)     // Catch:{ all -> 0x0047 }
            goto L_0x002e
        L_0x003e:
            if (r3 == 0) goto L_0x0043
            r3.close()     // Catch:{ all -> 0x005b }
        L_0x0043:
            r0.close()
            return
        L_0x0047:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r1 = move-exception
            if (r3 == 0) goto L_0x005a
            if (r4 == 0) goto L_0x0057
            r3.close()     // Catch:{ all -> 0x0052 }
            goto L_0x005a
        L_0x0052:
            r3 = move-exception
            r4.addSuppressed(r3)     // Catch:{ all -> 0x005b }
            goto L_0x005a
        L_0x0057:
            r3.close()     // Catch:{ all -> 0x005b }
        L_0x005a:
            throw r1     // Catch:{ all -> 0x005b }
        L_0x005b:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x005d }
        L_0x005d:
            r4 = move-exception
            if (r3 == 0) goto L_0x0069
            r0.close()     // Catch:{ all -> 0x0064 }
            goto L_0x006c
        L_0x0064:
            r0 = move-exception
            r3.addSuppressed(r0)
            goto L_0x006c
        L_0x0069:
            r0.close()
        L_0x006c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.Lister.listStream(java.io.File, java.lang.String[]):void");
    }

    private static ArchiveInputStream createArchiveInputStream(String[] strArr, InputStream inputStream) throws ArchiveException {
        if (strArr.length > 1) {
            return factory.createArchiveInputStream(strArr[1], inputStream);
        }
        return factory.createArchiveInputStream(inputStream);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        r2.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        if (r2 != null) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String detectFormat(java.io.File r2) throws org.apache.commons.compress.archivers.ArchiveException, java.io.IOException {
        /*
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            java.nio.file.Path r2 = r2.toPath()
            r1 = 0
            java.nio.file.OpenOption[] r1 = new java.nio.file.OpenOption[r1]
            java.io.InputStream r2 = java.nio.file.Files.newInputStream(r2, r1)
            r0.<init>(r2)
            java.lang.String r2 = org.apache.commons.compress.archivers.ArchiveStreamFactory.detect(r0)     // Catch:{ all -> 0x0018 }
            r0.close()
            return r2
        L_0x0018:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001a }
        L_0x001a:
            r1 = move-exception
            if (r2 == 0) goto L_0x0026
            r0.close()     // Catch:{ all -> 0x0021 }
            goto L_0x0029
        L_0x0021:
            r0 = move-exception
            r2.addSuppressed(r0)
            goto L_0x0029
        L_0x0026:
            r0.close()
        L_0x0029:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.Lister.detectFormat(java.io.File):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0052, code lost:
        if (r3 != null) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0058, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0059, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005d, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void list7z(java.io.File r3) throws org.apache.commons.compress.archivers.ArchiveException, java.io.IOException {
        /*
            org.apache.commons.compress.archivers.sevenz.SevenZFile r0 = new org.apache.commons.compress.archivers.sevenz.SevenZFile
            r0.<init>((java.io.File) r3)
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ all -> 0x004f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
            r1.<init>()     // Catch:{ all -> 0x004f }
            java.lang.String r2 = "Created "
            r1.append(r2)     // Catch:{ all -> 0x004f }
            java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x004f }
            r1.append(r2)     // Catch:{ all -> 0x004f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x004f }
            r3.println(r1)     // Catch:{ all -> 0x004f }
        L_0x001f:
            org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry r3 = r0.getNextEntry()     // Catch:{ all -> 0x004f }
            if (r3 == 0) goto L_0x004b
            java.lang.String r1 = r3.getName()     // Catch:{ all -> 0x004f }
            if (r1 != 0) goto L_0x0041
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
            r3.<init>()     // Catch:{ all -> 0x004f }
            java.lang.String r1 = r0.getDefaultName()     // Catch:{ all -> 0x004f }
            r3.append(r1)     // Catch:{ all -> 0x004f }
            java.lang.String r1 = " (entry name was null)"
            r3.append(r1)     // Catch:{ all -> 0x004f }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x004f }
            goto L_0x0045
        L_0x0041:
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x004f }
        L_0x0045:
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ all -> 0x004f }
            r1.println(r3)     // Catch:{ all -> 0x004f }
            goto L_0x001f
        L_0x004b:
            r0.close()
            return
        L_0x004f:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0051 }
        L_0x0051:
            r1 = move-exception
            if (r3 == 0) goto L_0x005d
            r0.close()     // Catch:{ all -> 0x0058 }
            goto L_0x0060
        L_0x0058:
            r0 = move-exception
            r3.addSuppressed(r0)
            goto L_0x0060
        L_0x005d:
            r0.close()
        L_0x0060:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.Lister.list7z(java.io.File):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
        if (r3 != null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004b, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void listZipUsingZipFile(java.io.File r3) throws org.apache.commons.compress.archivers.ArchiveException, java.io.IOException {
        /*
            org.apache.commons.compress.archivers.zip.ZipFile r0 = new org.apache.commons.compress.archivers.zip.ZipFile
            r0.<init>((java.io.File) r3)
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ all -> 0x003d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x003d }
            r1.<init>()     // Catch:{ all -> 0x003d }
            java.lang.String r2 = "Created "
            r1.append(r2)     // Catch:{ all -> 0x003d }
            java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x003d }
            r1.append(r2)     // Catch:{ all -> 0x003d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x003d }
            r3.println(r1)     // Catch:{ all -> 0x003d }
            java.util.Enumeration r3 = r0.getEntries()     // Catch:{ all -> 0x003d }
        L_0x0023:
            boolean r1 = r3.hasMoreElements()     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x0039
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ all -> 0x003d }
            java.lang.Object r2 = r3.nextElement()     // Catch:{ all -> 0x003d }
            org.apache.commons.compress.archivers.zip.ZipArchiveEntry r2 = (org.apache.commons.compress.archivers.zip.ZipArchiveEntry) r2     // Catch:{ all -> 0x003d }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x003d }
            r1.println(r2)     // Catch:{ all -> 0x003d }
            goto L_0x0023
        L_0x0039:
            r0.close()
            return
        L_0x003d:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x003f }
        L_0x003f:
            r1 = move-exception
            if (r3 == 0) goto L_0x004b
            r0.close()     // Catch:{ all -> 0x0046 }
            goto L_0x004e
        L_0x0046:
            r0 = move-exception
            r3.addSuppressed(r0)
            goto L_0x004e
        L_0x004b:
            r0.close()
        L_0x004e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.Lister.listZipUsingZipFile(java.io.File):void");
    }

    private static void usage() {
        System.out.println("Parameters: archive-name [archive-type]\n");
        System.out.println("the magic archive-type 'zipfile' prefers ZipFile over ZipArchiveInputStream");
    }
}
