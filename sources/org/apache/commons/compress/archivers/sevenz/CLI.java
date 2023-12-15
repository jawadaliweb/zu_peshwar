package org.apache.commons.compress.archivers.sevenz;

import br.com.sapereaude.maskedEditText.MaskedEditText;
import java.io.IOException;
import java.io.PrintStream;

public class CLI {

    private enum Mode {
        LIST("Analysing") {
            public void takeAction(SevenZFile sevenZFile, SevenZArchiveEntry sevenZArchiveEntry) {
                System.out.print(sevenZArchiveEntry.getName());
                if (sevenZArchiveEntry.isDirectory()) {
                    System.out.print(" dir");
                } else {
                    PrintStream printStream = System.out;
                    printStream.print(MaskedEditText.SPACE + sevenZArchiveEntry.getCompressedSize() + "/" + sevenZArchiveEntry.getSize());
                }
                if (sevenZArchiveEntry.getHasLastModifiedDate()) {
                    PrintStream printStream2 = System.out;
                    printStream2.print(MaskedEditText.SPACE + sevenZArchiveEntry.getLastModifiedDate());
                } else {
                    System.out.print(" no last modified date");
                }
                if (!sevenZArchiveEntry.isDirectory()) {
                    PrintStream printStream3 = System.out;
                    printStream3.println(MaskedEditText.SPACE + getContentMethods(sevenZArchiveEntry));
                    return;
                }
                System.out.println("");
            }

            private String getContentMethods(SevenZArchiveEntry sevenZArchiveEntry) {
                StringBuilder sb = new StringBuilder();
                boolean z = true;
                for (SevenZMethodConfiguration sevenZMethodConfiguration : sevenZArchiveEntry.getContentMethods()) {
                    if (!z) {
                        sb.append(", ");
                    }
                    z = false;
                    sb.append(sevenZMethodConfiguration.getMethod());
                    if (sevenZMethodConfiguration.getOptions() != null) {
                        sb.append("(");
                        sb.append(sevenZMethodConfiguration.getOptions());
                        sb.append(")");
                    }
                }
                return sb.toString();
            }
        },
        EXTRACT("Extracting") {
            private final byte[] buf;

            /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ee, code lost:
                r12 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ef, code lost:
                if (r0 != null) goto L_0x00f1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f1, code lost:
                if (r11 != null) goto L_0x00f3;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
                r0.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f7, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f8, code lost:
                r11.addSuppressed(r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:40:0x00fc, code lost:
                r0.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ff, code lost:
                throw r12;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void takeAction(org.apache.commons.compress.archivers.sevenz.SevenZFile r11, org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry r12) throws java.io.IOException {
                /*
                    r10 = this;
                    java.io.File r0 = new java.io.File
                    java.lang.String r1 = r12.getName()
                    r0.<init>(r1)
                    boolean r1 = r12.isDirectory()
                    if (r1 == 0) goto L_0x004a
                    boolean r11 = r0.isDirectory()
                    if (r11 != 0) goto L_0x0033
                    boolean r11 = r0.mkdirs()
                    if (r11 == 0) goto L_0x001c
                    goto L_0x0033
                L_0x001c:
                    java.io.IOException r11 = new java.io.IOException
                    java.lang.StringBuilder r12 = new java.lang.StringBuilder
                    r12.<init>()
                    java.lang.String r1 = "Cannot create directory "
                    r12.append(r1)
                    r12.append(r0)
                    java.lang.String r12 = r12.toString()
                    r11.<init>(r12)
                    throw r11
                L_0x0033:
                    java.io.PrintStream r11 = java.lang.System.out
                    java.lang.StringBuilder r12 = new java.lang.StringBuilder
                    r12.<init>()
                    java.lang.String r1 = "created directory "
                    r12.append(r1)
                    r12.append(r0)
                    java.lang.String r12 = r12.toString()
                    r11.println(r12)
                    return
                L_0x004a:
                    java.io.PrintStream r1 = java.lang.System.out
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "extracting to "
                    r2.append(r3)
                    r2.append(r0)
                    java.lang.String r2 = r2.toString()
                    r1.println(r2)
                    java.io.File r1 = r0.getParentFile()
                    if (r1 == 0) goto L_0x008a
                    boolean r2 = r1.exists()
                    if (r2 != 0) goto L_0x008a
                    boolean r2 = r1.mkdirs()
                    if (r2 == 0) goto L_0x0073
                    goto L_0x008a
                L_0x0073:
                    java.io.IOException r11 = new java.io.IOException
                    java.lang.StringBuilder r12 = new java.lang.StringBuilder
                    r12.<init>()
                    java.lang.String r0 = "Cannot create "
                    r12.append(r0)
                    r12.append(r1)
                    java.lang.String r12 = r12.toString()
                    r11.<init>(r12)
                    throw r11
                L_0x008a:
                    java.nio.file.Path r0 = r0.toPath()
                    r1 = 0
                    java.nio.file.OpenOption[] r2 = new java.nio.file.OpenOption[r1]
                    java.io.OutputStream r0 = java.nio.file.Files.newOutputStream(r0, r2)
                    long r2 = r12.getSize()     // Catch:{ all -> 0x00ec }
                    r4 = 0
                L_0x009b:
                    int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                    if (r6 >= 0) goto L_0x00e6
                    long r6 = r2 - r4
                    byte[] r8 = r10.buf     // Catch:{ all -> 0x00ec }
                    int r8 = r8.length     // Catch:{ all -> 0x00ec }
                    long r8 = (long) r8     // Catch:{ all -> 0x00ec }
                    long r6 = java.lang.Math.min(r6, r8)     // Catch:{ all -> 0x00ec }
                    int r7 = (int) r6     // Catch:{ all -> 0x00ec }
                    byte[] r6 = r10.buf     // Catch:{ all -> 0x00ec }
                    int r6 = r11.read(r6, r1, r7)     // Catch:{ all -> 0x00ec }
                    r7 = 1
                    if (r6 < r7) goto L_0x00bb
                    long r7 = (long) r6     // Catch:{ all -> 0x00ec }
                    long r4 = r4 + r7
                    byte[] r7 = r10.buf     // Catch:{ all -> 0x00ec }
                    r0.write(r7, r1, r6)     // Catch:{ all -> 0x00ec }
                    goto L_0x009b
                L_0x00bb:
                    java.io.IOException r11 = new java.io.IOException     // Catch:{ all -> 0x00ec }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ec }
                    r1.<init>()     // Catch:{ all -> 0x00ec }
                    java.lang.String r6 = "Reached end of entry "
                    r1.append(r6)     // Catch:{ all -> 0x00ec }
                    java.lang.String r12 = r12.getName()     // Catch:{ all -> 0x00ec }
                    r1.append(r12)     // Catch:{ all -> 0x00ec }
                    java.lang.String r12 = " after "
                    r1.append(r12)     // Catch:{ all -> 0x00ec }
                    r1.append(r4)     // Catch:{ all -> 0x00ec }
                    java.lang.String r12 = " bytes, expected "
                    r1.append(r12)     // Catch:{ all -> 0x00ec }
                    r1.append(r2)     // Catch:{ all -> 0x00ec }
                    java.lang.String r12 = r1.toString()     // Catch:{ all -> 0x00ec }
                    r11.<init>(r12)     // Catch:{ all -> 0x00ec }
                    throw r11     // Catch:{ all -> 0x00ec }
                L_0x00e6:
                    if (r0 == 0) goto L_0x00eb
                    r0.close()
                L_0x00eb:
                    return
                L_0x00ec:
                    r11 = move-exception
                    throw r11     // Catch:{ all -> 0x00ee }
                L_0x00ee:
                    r12 = move-exception
                    if (r0 == 0) goto L_0x00ff
                    if (r11 == 0) goto L_0x00fc
                    r0.close()     // Catch:{ all -> 0x00f7 }
                    goto L_0x00ff
                L_0x00f7:
                    r0 = move-exception
                    r11.addSuppressed(r0)
                    goto L_0x00ff
                L_0x00fc:
                    r0.close()
                L_0x00ff:
                    throw r12
                */
                throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.sevenz.CLI.Mode.AnonymousClass2.takeAction(org.apache.commons.compress.archivers.sevenz.SevenZFile, org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry):void");
            }
        };
        
        private final String message;

        public abstract void takeAction(SevenZFile sevenZFile, SevenZArchiveEntry sevenZArchiveEntry) throws IOException;

        private Mode(String str) {
            this.message = str;
        }

        public String getMessage() {
            return this.message;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0063, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0064, code lost:
        if (r0 != null) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006b, code lost:
        r0.addSuppressed(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006f, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0072, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r5) throws java.lang.Exception {
        /*
            int r0 = r5.length
            if (r0 != 0) goto L_0x0007
            usage()
            return
        L_0x0007:
            org.apache.commons.compress.archivers.sevenz.CLI$Mode r0 = grabMode(r5)
            java.io.PrintStream r1 = java.lang.System.out
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r0.getMessage()
            r2.append(r3)
            java.lang.String r3 = " "
            r2.append(r3)
            r3 = 0
            r4 = r5[r3]
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.println(r2)
            java.io.File r1 = new java.io.File
            r5 = r5[r3]
            r1.<init>(r5)
            boolean r5 = r1.isFile()
            if (r5 != 0) goto L_0x004e
            java.io.PrintStream r5 = java.lang.System.err
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r3 = " doesn't exist or is a directory"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r5.println(r2)
        L_0x004e:
            org.apache.commons.compress.archivers.sevenz.SevenZFile r5 = new org.apache.commons.compress.archivers.sevenz.SevenZFile
            r5.<init>((java.io.File) r1)
        L_0x0053:
            org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry r1 = r5.getNextEntry()     // Catch:{ all -> 0x0061 }
            if (r1 == 0) goto L_0x005d
            r0.takeAction(r5, r1)     // Catch:{ all -> 0x0061 }
            goto L_0x0053
        L_0x005d:
            r5.close()
            return
        L_0x0061:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0063 }
        L_0x0063:
            r1 = move-exception
            if (r0 == 0) goto L_0x006f
            r5.close()     // Catch:{ all -> 0x006a }
            goto L_0x0072
        L_0x006a:
            r5 = move-exception
            r0.addSuppressed(r5)
            goto L_0x0072
        L_0x006f:
            r5.close()
        L_0x0072:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.sevenz.CLI.main(java.lang.String[]):void");
    }

    private static void usage() {
        System.out.println("Parameters: archive-name [list|extract]");
    }

    private static Mode grabMode(String[] strArr) {
        if (strArr.length < 2) {
            return Mode.LIST;
        }
        return (Mode) Enum.valueOf(Mode.class, strArr[1].toUpperCase());
    }
}
