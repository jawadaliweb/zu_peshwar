package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.ca;
import java.io.File;

final class bj {
    private static final ag a = new ag("ExtractChunkTaskHandler");
    private final byte[] b = new byte[8192];
    private final au c;
    private final ca<t> d;
    private final ca<ar> e;
    private final bo f;

    bj(au auVar, ca<t> caVar, ca<ar> caVar2, bo boVar) {
        this.c = auVar;
        this.d = caVar;
        this.e = caVar2;
        this.f = boVar;
    }

    private final File b(bi biVar) {
        File h = this.c.h(biVar.k, biVar.a, biVar.b, biVar.c);
        if (!h.exists()) {
            h.mkdirs();
        }
        return h;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x030c  */
    /* JADX WARNING: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x017d A[Catch:{ all -> 0x032f, all -> 0x0335, IOException -> 0x033b }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01a2 A[Catch:{ all -> 0x032f, all -> 0x0335, IOException -> 0x033b }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01d6 A[Catch:{ all -> 0x032f, all -> 0x0335, IOException -> 0x033b }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0291 A[SYNTHETIC, Splitter:B:93:0x0291] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.google.android.play.core.assetpacks.bi r23) {
        /*
            r22 = this;
            r1 = r22
            r2 = r23
            com.google.android.play.core.assetpacks.cz r0 = new com.google.android.play.core.assetpacks.cz
            com.google.android.play.core.assetpacks.au r4 = r1.c
            java.lang.String r5 = r2.k
            int r6 = r2.a
            long r7 = r2.b
            java.lang.String r9 = r2.c
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r9)
            com.google.android.play.core.assetpacks.au r10 = r1.c
            java.lang.String r11 = r2.k
            int r12 = r2.a
            long r13 = r2.b
            java.lang.String r15 = r2.c
            java.io.File r3 = r10.o(r11, r12, r13, r15)
            boolean r4 = r3.exists()
            if (r4 != 0) goto L_0x002b
            r3.mkdirs()
        L_0x002b:
            r11 = 3
            r12 = 2
            r13 = 1
            r14 = 0
            java.io.InputStream r3 = r2.i     // Catch:{ IOException -> 0x033b }
            int r4 = r2.d     // Catch:{ IOException -> 0x033b }
            if (r4 == r13) goto L_0x0037
            r15 = r3
            goto L_0x003f
        L_0x0037:
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x033b }
            r5 = 8192(0x2000, float:1.14794E-41)
            r4.<init>(r3, r5)     // Catch:{ IOException -> 0x033b }
            r15 = r4
        L_0x003f:
            int r3 = r2.e     // Catch:{ all -> 0x032f }
            r16 = 0
            if (r3 <= 0) goto L_0x017a
            com.google.android.play.core.assetpacks.cy r3 = r0.e()     // Catch:{ all -> 0x032f }
            int r4 = r3.e()     // Catch:{ all -> 0x032f }
            int r5 = r2.e     // Catch:{ all -> 0x032f }
            int r6 = r5 + -1
            if (r4 != r6) goto L_0x015a
            int r4 = r3.a()     // Catch:{ all -> 0x032f }
            if (r4 == r13) goto L_0x00d8
            if (r4 == r12) goto L_0x009b
            if (r4 != r11) goto L_0x0081
            com.google.android.play.core.internal.ag r4 = a     // Catch:{ all -> 0x032f }
            java.lang.String r5 = "Resuming central directory from last chunk."
            java.lang.Object[] r6 = new java.lang.Object[r14]     // Catch:{ all -> 0x032f }
            r4.a(r5, r6)     // Catch:{ all -> 0x032f }
            long r3 = r3.c()     // Catch:{ all -> 0x032f }
            r0.f(r15, r3)     // Catch:{ all -> 0x032f }
            boolean r3 = r23.a()     // Catch:{ all -> 0x032f }
            if (r3 == 0) goto L_0x0077
        L_0x0073:
            r4 = r16
            goto L_0x017b
        L_0x0077:
            com.google.android.play.core.assetpacks.bk r0 = new com.google.android.play.core.assetpacks.bk     // Catch:{ all -> 0x032f }
            java.lang.String r3 = "Chunk has ended twice during central directory. This should not be possible with chunk sizes of 50MB."
            int r4 = r2.j     // Catch:{ all -> 0x032f }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x032f }
            throw r0     // Catch:{ all -> 0x032f }
        L_0x0081:
            com.google.android.play.core.assetpacks.bk r0 = new com.google.android.play.core.assetpacks.bk     // Catch:{ all -> 0x032f }
            java.lang.Object[] r4 = new java.lang.Object[r13]     // Catch:{ all -> 0x032f }
            int r3 = r3.a()     // Catch:{ all -> 0x032f }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x032f }
            r4[r14] = r3     // Catch:{ all -> 0x032f }
            java.lang.String r3 = "Slice checkpoint file corrupt. Unexpected FileExtractionStatus %s."
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ all -> 0x032f }
            int r4 = r2.j     // Catch:{ all -> 0x032f }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x032f }
            throw r0     // Catch:{ all -> 0x032f }
        L_0x009b:
            com.google.android.play.core.internal.ag r3 = a     // Catch:{ all -> 0x032f }
            java.lang.String r4 = "Resuming zip entry from last chunk during local file header."
            java.lang.Object[] r5 = new java.lang.Object[r14]     // Catch:{ all -> 0x032f }
            r3.a(r4, r5)     // Catch:{ all -> 0x032f }
            com.google.android.play.core.assetpacks.au r3 = r1.c     // Catch:{ all -> 0x032f }
            java.lang.String r4 = r2.k     // Catch:{ all -> 0x032f }
            int r5 = r2.a     // Catch:{ all -> 0x032f }
            long r6 = r2.b     // Catch:{ all -> 0x032f }
            java.lang.String r8 = r2.c     // Catch:{ all -> 0x032f }
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r21 = r8
            java.io.File r3 = r16.n(r17, r18, r19, r21)     // Catch:{ all -> 0x032f }
            boolean r4 = r3.exists()     // Catch:{ all -> 0x032f }
            if (r4 == 0) goto L_0x00ce
            java.io.SequenceInputStream r4 = new java.io.SequenceInputStream     // Catch:{ all -> 0x032f }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ all -> 0x032f }
            r5.<init>(r3)     // Catch:{ all -> 0x032f }
            r4.<init>(r5, r15)     // Catch:{ all -> 0x032f }
            goto L_0x017b
        L_0x00ce:
            com.google.android.play.core.assetpacks.bk r0 = new com.google.android.play.core.assetpacks.bk     // Catch:{ all -> 0x032f }
            java.lang.String r3 = "Checkpoint extension file not found."
            int r4 = r2.j     // Catch:{ all -> 0x032f }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x032f }
            throw r0     // Catch:{ all -> 0x032f }
        L_0x00d8:
            com.google.android.play.core.internal.ag r4 = a     // Catch:{ all -> 0x032f }
            java.lang.Object[] r5 = new java.lang.Object[r13]     // Catch:{ all -> 0x032f }
            java.lang.String r6 = r3.b()     // Catch:{ all -> 0x032f }
            r5[r14] = r6     // Catch:{ all -> 0x032f }
            java.lang.String r6 = "Resuming zip entry from last chunk during file %s."
            r4.a(r6, r5)     // Catch:{ all -> 0x032f }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x032f }
            java.lang.String r5 = r3.b()     // Catch:{ all -> 0x032f }
            r4.<init>(r5)     // Catch:{ all -> 0x032f }
            boolean r5 = r4.exists()     // Catch:{ all -> 0x032f }
            if (r5 == 0) goto L_0x0150
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ all -> 0x032f }
            java.lang.String r6 = "rw"
            r5.<init>(r4, r6)     // Catch:{ all -> 0x032f }
            long r6 = r3.c()     // Catch:{ all -> 0x032f }
            r5.seek(r6)     // Catch:{ all -> 0x032f }
            long r6 = r3.d()     // Catch:{ all -> 0x032f }
        L_0x0108:
            r8 = 8192(0x2000, double:4.0474E-320)
            long r8 = java.lang.Math.min(r6, r8)     // Catch:{ all -> 0x032f }
            int r3 = (int) r8     // Catch:{ all -> 0x032f }
            byte[] r8 = r1.b     // Catch:{ all -> 0x032f }
            int r8 = r15.read(r8, r14, r3)     // Catch:{ all -> 0x032f }
            int r8 = java.lang.Math.max(r8, r14)     // Catch:{ all -> 0x032f }
            if (r8 <= 0) goto L_0x0120
            byte[] r9 = r1.b     // Catch:{ all -> 0x032f }
            r5.write(r9, r14, r8)     // Catch:{ all -> 0x032f }
        L_0x0120:
            long r10 = (long) r8     // Catch:{ all -> 0x032f }
            long r9 = r6 - r10
            r6 = 0
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 <= 0) goto L_0x012f
            if (r8 > 0) goto L_0x012c
            goto L_0x012f
        L_0x012c:
            r6 = r9
            r11 = 3
            goto L_0x0108
        L_0x012f:
            long r6 = r5.length()     // Catch:{ all -> 0x032f }
            r5.close()     // Catch:{ all -> 0x032f }
            if (r8 == r3) goto L_0x017a
            com.google.android.play.core.internal.ag r3 = a     // Catch:{ all -> 0x032f }
            java.lang.String r5 = "Chunk has ended while resuming the previous chunks file content."
            java.lang.Object[] r8 = new java.lang.Object[r14]     // Catch:{ all -> 0x032f }
            r3.a(r5, r8)     // Catch:{ all -> 0x032f }
            java.lang.String r4 = r4.getCanonicalPath()     // Catch:{ all -> 0x032f }
            int r11 = r2.e     // Catch:{ all -> 0x032f }
            r3 = r0
            r5 = r6
            r7 = r9
            r9 = r11
            r3.a(r4, r5, r7, r9)     // Catch:{ all -> 0x032f }
            goto L_0x0073
        L_0x0150:
            com.google.android.play.core.assetpacks.bk r0 = new com.google.android.play.core.assetpacks.bk     // Catch:{ all -> 0x032f }
            java.lang.String r3 = "Partial file specified in checkpoint does not exist. Corrupt directory."
            int r4 = r2.j     // Catch:{ all -> 0x032f }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x032f }
            throw r0     // Catch:{ all -> 0x032f }
        L_0x015a:
            com.google.android.play.core.assetpacks.bk r0 = new com.google.android.play.core.assetpacks.bk     // Catch:{ all -> 0x032f }
            java.lang.String r4 = "Trying to resume with chunk number %s when previously processed chunk was number %s."
            java.lang.Object[] r6 = new java.lang.Object[r12]     // Catch:{ all -> 0x032f }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x032f }
            r6[r14] = r5     // Catch:{ all -> 0x032f }
            int r3 = r3.e()     // Catch:{ all -> 0x032f }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x032f }
            r6[r13] = r3     // Catch:{ all -> 0x032f }
            java.lang.String r3 = java.lang.String.format(r4, r6)     // Catch:{ all -> 0x032f }
            int r4 = r2.j     // Catch:{ all -> 0x032f }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x032f }
            throw r0     // Catch:{ all -> 0x032f }
        L_0x017a:
            r4 = r15
        L_0x017b:
            if (r4 == 0) goto L_0x0288
            com.google.android.play.core.assetpacks.bd r3 = new com.google.android.play.core.assetpacks.bd     // Catch:{ all -> 0x032f }
            r3.<init>(r4)     // Catch:{ all -> 0x032f }
            java.io.File r5 = r22.b(r23)     // Catch:{ all -> 0x032f }
        L_0x0186:
            com.google.android.play.core.assetpacks.de r6 = r3.a()     // Catch:{ all -> 0x032f }
            boolean r7 = r6.g()     // Catch:{ all -> 0x032f }
            if (r7 != 0) goto L_0x01dd
            boolean r7 = r3.c()     // Catch:{ all -> 0x032f }
            if (r7 != 0) goto L_0x01dd
            boolean r7 = r6.c()     // Catch:{ all -> 0x032f }
            if (r7 == 0) goto L_0x01d6
            boolean r7 = r6.b()     // Catch:{ all -> 0x032f }
            if (r7 != 0) goto L_0x01d6
            byte[] r7 = r6.i()     // Catch:{ all -> 0x032f }
            r0.g(r7)     // Catch:{ all -> 0x032f }
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x032f }
            java.lang.String r8 = r6.d()     // Catch:{ all -> 0x032f }
            r7.<init>(r5, r8)     // Catch:{ all -> 0x032f }
            java.io.File r8 = r7.getParentFile()     // Catch:{ all -> 0x032f }
            r8.mkdirs()     // Catch:{ all -> 0x032f }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ all -> 0x032f }
            r8.<init>(r7)     // Catch:{ all -> 0x032f }
            byte[] r7 = r1.b     // Catch:{ all -> 0x032f }
            int r7 = r3.read(r7)     // Catch:{ all -> 0x032f }
        L_0x01c4:
            if (r7 <= 0) goto L_0x01d2
            byte[] r9 = r1.b     // Catch:{ all -> 0x032f }
            r8.write(r9, r14, r7)     // Catch:{ all -> 0x032f }
            byte[] r7 = r1.b     // Catch:{ all -> 0x032f }
            int r7 = r3.read(r7)     // Catch:{ all -> 0x032f }
            goto L_0x01c4
        L_0x01d2:
            r8.close()     // Catch:{ all -> 0x032f }
            goto L_0x01dd
        L_0x01d6:
            byte[] r7 = r6.i()     // Catch:{ all -> 0x032f }
            r0.h(r7, r3)     // Catch:{ all -> 0x032f }
        L_0x01dd:
            boolean r7 = r3.b()     // Catch:{ all -> 0x032f }
            if (r7 != 0) goto L_0x01e9
            boolean r7 = r3.c()     // Catch:{ all -> 0x032f }
            if (r7 == 0) goto L_0x0186
        L_0x01e9:
            boolean r5 = r3.c()     // Catch:{ all -> 0x032f }
            if (r5 == 0) goto L_0x01ff
            com.google.android.play.core.internal.ag r5 = a     // Catch:{ all -> 0x032f }
            java.lang.String r7 = "Writing central directory metadata."
            java.lang.Object[] r8 = new java.lang.Object[r14]     // Catch:{ all -> 0x032f }
            r5.a(r7, r8)     // Catch:{ all -> 0x032f }
            byte[] r5 = r6.i()     // Catch:{ all -> 0x032f }
            r0.h(r5, r4)     // Catch:{ all -> 0x032f }
        L_0x01ff:
            boolean r4 = r23.a()     // Catch:{ all -> 0x032f }
            if (r4 != 0) goto L_0x0288
            boolean r4 = r6.g()     // Catch:{ all -> 0x032f }
            if (r4 == 0) goto L_0x021e
            com.google.android.play.core.internal.ag r3 = a     // Catch:{ all -> 0x032f }
            java.lang.String r4 = "Writing slice checkpoint for partial local file header."
            java.lang.Object[] r5 = new java.lang.Object[r14]     // Catch:{ all -> 0x032f }
            r3.a(r4, r5)     // Catch:{ all -> 0x032f }
            byte[] r3 = r6.i()     // Catch:{ all -> 0x032f }
            int r4 = r2.e     // Catch:{ all -> 0x032f }
            r0.b(r3, r4)     // Catch:{ all -> 0x032f }
            goto L_0x0288
        L_0x021e:
            boolean r4 = r3.c()     // Catch:{ all -> 0x032f }
            if (r4 == 0) goto L_0x0233
            com.google.android.play.core.internal.ag r3 = a     // Catch:{ all -> 0x032f }
            java.lang.String r4 = "Writing slice checkpoint for central directory."
            java.lang.Object[] r5 = new java.lang.Object[r14]     // Catch:{ all -> 0x032f }
            r3.a(r4, r5)     // Catch:{ all -> 0x032f }
            int r3 = r2.e     // Catch:{ all -> 0x032f }
            r0.c(r3)     // Catch:{ all -> 0x032f }
            goto L_0x0288
        L_0x0233:
            int r4 = r6.f()     // Catch:{ all -> 0x032f }
            if (r4 != 0) goto L_0x0269
            com.google.android.play.core.internal.ag r4 = a     // Catch:{ all -> 0x032f }
            java.lang.String r5 = "Writing slice checkpoint for partial file."
            java.lang.Object[] r7 = new java.lang.Object[r14]     // Catch:{ all -> 0x032f }
            r4.a(r5, r7)     // Catch:{ all -> 0x032f }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x032f }
            java.io.File r5 = r22.b(r23)     // Catch:{ all -> 0x032f }
            java.lang.String r7 = r6.d()     // Catch:{ all -> 0x032f }
            r4.<init>(r5, r7)     // Catch:{ all -> 0x032f }
            long r5 = r6.e()     // Catch:{ all -> 0x032f }
            long r7 = r3.d()     // Catch:{ all -> 0x032f }
            long r5 = r5 - r7
            long r7 = r4.length()     // Catch:{ all -> 0x032f }
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 != 0) goto L_0x0261
            goto L_0x027a
        L_0x0261:
            com.google.android.play.core.assetpacks.bk r0 = new com.google.android.play.core.assetpacks.bk     // Catch:{ all -> 0x032f }
            java.lang.String r3 = "Partial file is of unexpected size."
            r0.<init>(r3)     // Catch:{ all -> 0x032f }
            throw r0     // Catch:{ all -> 0x032f }
        L_0x0269:
            com.google.android.play.core.internal.ag r4 = a     // Catch:{ all -> 0x032f }
            java.lang.String r5 = "Writing slice checkpoint for partial unextractable file."
            java.lang.Object[] r6 = new java.lang.Object[r14]     // Catch:{ all -> 0x032f }
            r4.a(r5, r6)     // Catch:{ all -> 0x032f }
            java.io.File r4 = r0.j()     // Catch:{ all -> 0x032f }
            long r5 = r4.length()     // Catch:{ all -> 0x032f }
        L_0x027a:
            java.lang.String r4 = r4.getCanonicalPath()     // Catch:{ all -> 0x032f }
            long r7 = r3.d()     // Catch:{ all -> 0x032f }
            int r9 = r2.e     // Catch:{ all -> 0x032f }
            r3 = r0
            r3.a(r4, r5, r7, r9)     // Catch:{ all -> 0x032f }
        L_0x0288:
            r15.close()     // Catch:{ IOException -> 0x033b }
            boolean r3 = r23.a()
            if (r3 == 0) goto L_0x02b1
            int r3 = r2.e     // Catch:{ IOException -> 0x0297 }
            r0.d(r3)     // Catch:{ IOException -> 0x0297 }
            goto L_0x02b1
        L_0x0297:
            r0 = move-exception
            com.google.android.play.core.internal.ag r3 = a
            java.lang.Object[] r4 = new java.lang.Object[r13]
            java.lang.String r5 = r0.getMessage()
            r4[r14] = r5
            java.lang.String r5 = "Writing extraction finished checkpoint failed with %s."
            r3.b(r5, r4)
            com.google.android.play.core.assetpacks.bk r3 = new com.google.android.play.core.assetpacks.bk
            int r2 = r2.j
            java.lang.String r4 = "Writing extraction finished checkpoint failed."
            r3.<init>(r4, r0, r2)
            throw r3
        L_0x02b1:
            com.google.android.play.core.internal.ag r0 = a
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            int r4 = r2.e
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r14] = r4
            java.lang.String r4 = r2.c
            r3[r13] = r4
            java.lang.String r4 = r2.k
            r3[r12] = r4
            int r4 = r2.j
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 3
            r3[r5] = r4
            java.lang.String r4 = "Extraction finished for chunk %s of slice %s of pack %s of session %s."
            r0.d(r4, r3)
            com.google.android.play.core.internal.ca<com.google.android.play.core.assetpacks.t> r0 = r1.d
            java.lang.Object r0 = r0.a()
            com.google.android.play.core.assetpacks.t r0 = (com.google.android.play.core.assetpacks.t) r0
            int r3 = r2.j
            java.lang.String r4 = r2.k
            java.lang.String r5 = r2.c
            int r6 = r2.e
            r0.e(r3, r4, r5, r6)
            java.io.InputStream r0 = r2.i     // Catch:{ IOException -> 0x02ed }
            r0.close()     // Catch:{ IOException -> 0x02ed }
            goto L_0x0307
        L_0x02ed:
            com.google.android.play.core.internal.ag r0 = a
            r3 = 3
            java.lang.Object[] r4 = new java.lang.Object[r3]
            int r3 = r2.e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4[r14] = r3
            java.lang.String r3 = r2.c
            r4[r13] = r3
            java.lang.String r3 = r2.k
            r4[r12] = r3
            java.lang.String r3 = "Could not close file for chunk %s of slice %s of pack %s."
            r0.e(r3, r4)
        L_0x0307:
            int r0 = r2.h
            r3 = 3
            if (r0 != r3) goto L_0x032e
            com.google.android.play.core.internal.ca<com.google.android.play.core.assetpacks.ar> r0 = r1.e
            java.lang.Object r0 = r0.a()
            com.google.android.play.core.assetpacks.ar r0 = (com.google.android.play.core.assetpacks.ar) r0
            java.lang.String r3 = r2.k
            long r7 = r2.g
            r4 = 3
            r5 = 0
            com.google.android.play.core.assetpacks.bo r6 = r1.f
            double r9 = r6.c(r3, r2)
            r11 = 1
            java.lang.String r12 = ""
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            com.google.android.play.core.assetpacks.AssetPackState r2 = com.google.android.play.core.assetpacks.AssetPackState.c(r2, r3, r4, r5, r7, r9, r11, r12)
            r0.b(r2)
        L_0x032e:
            return
        L_0x032f:
            r0 = move-exception
            r3 = r0
            r15.close()     // Catch:{ all -> 0x0335 }
            goto L_0x033a
        L_0x0335:
            r0 = move-exception
            r4 = r0
            com.google.android.play.core.internal.bz.a(r3, r4)     // Catch:{ IOException -> 0x033b }
        L_0x033a:
            throw r3     // Catch:{ IOException -> 0x033b }
        L_0x033b:
            r0 = move-exception
            com.google.android.play.core.internal.ag r3 = a
            java.lang.Object[] r4 = new java.lang.Object[r13]
            java.lang.String r5 = r0.getMessage()
            r4[r14] = r5
            java.lang.String r5 = "IOException during extraction %s."
            r3.b(r5, r4)
            com.google.android.play.core.assetpacks.bk r3 = new com.google.android.play.core.assetpacks.bk
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]
            int r5 = r2.e
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4[r14] = r5
            java.lang.String r5 = r2.c
            r4[r13] = r5
            java.lang.String r5 = r2.k
            r4[r12] = r5
            int r5 = r2.j
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6 = 3
            r4[r6] = r5
            java.lang.String r5 = "Error extracting chunk %s of slice %s of pack %s of session %s."
            java.lang.String r4 = java.lang.String.format(r5, r4)
            int r2 = r2.j
            r3.<init>(r4, r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.bj.a(com.google.android.play.core.assetpacks.bi):void");
    }
}
