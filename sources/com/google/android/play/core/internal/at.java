package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitcompat.c;
import com.google.android.play.core.splitcompat.p;
import com.google.android.play.core.splitinstall.d;
import com.google.android.play.core.splitinstall.f;
import java.util.List;
import java.util.concurrent.Executor;

public final class at implements f {
    private final Context a;
    private final c b;
    /* access modifiers changed from: private */
    public final av c;
    private final Executor d;
    private final p e;

    public at(Context context, Executor executor, av avVar, c cVar, p pVar) {
        this.a = context;
        this.b = cVar;
        this.c = avVar;
        this.d = executor;
        this.e = pVar;
    }

    static /* synthetic */ void c(at atVar, d dVar) {
        try {
            if (!SplitCompat.a(p.c(atVar.a))) {
                Log.e("SplitCompat", "Emulating splits failed.");
                dVar.c(-12);
                return;
            }
            Log.i("SplitCompat", "Splits installed.");
            dVar.a();
        } catch (Exception e2) {
            Log.e("SplitCompat", "Error emulating splits.", e2);
            dVar.c(-12);
        }
    }

    static /* synthetic */ void d(at atVar, List list, d dVar) {
        Integer e2 = atVar.e(list);
        if (e2 != null) {
            if (e2.intValue() == 0) {
                dVar.b();
            } else {
                dVar.c(e2.intValue());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:88:0x0129 A[Catch:{ all -> 0x001b, all -> 0x0122, Exception -> 0x012d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Integer e(java.util.List<android.content.Intent> r15) {
        /*
            r14 = this;
            java.lang.String r0 = "SplitCompat"
            r1 = -13
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x012d }
            com.google.android.play.core.splitcompat.c r3 = r14.b     // Catch:{ Exception -> 0x012d }
            java.io.File r3 = r3.f()     // Catch:{ Exception -> 0x012d }
            java.lang.String r4 = "rw"
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x012d }
            java.nio.channels.FileChannel r2 = r2.getChannel()     // Catch:{ Exception -> 0x012d }
            r3 = 0
            java.nio.channels.FileLock r4 = r2.tryLock()     // Catch:{ OverlappingFileLockException -> 0x001e }
            goto L_0x001f
        L_0x001b:
            r15 = move-exception
            goto L_0x011c
        L_0x001e:
            r4 = r3
        L_0x001f:
            if (r4 == 0) goto L_0x0127
            r3 = 0
            r5 = -11
            java.lang.String r6 = "Copying splits."
            android.util.Log.i(r0, r6)     // Catch:{ Exception -> 0x010e }
            java.util.Iterator r15 = r15.iterator()     // Catch:{ Exception -> 0x010e }
        L_0x002d:
            boolean r6 = r15.hasNext()     // Catch:{ Exception -> 0x010e }
            if (r6 == 0) goto L_0x00b1
            java.lang.Object r6 = r15.next()     // Catch:{ Exception -> 0x010e }
            android.content.Intent r6 = (android.content.Intent) r6     // Catch:{ Exception -> 0x010e }
            java.lang.String r7 = "split_id"
            java.lang.String r7 = r6.getStringExtra(r7)     // Catch:{ Exception -> 0x010e }
            android.content.Context r8 = r14.a     // Catch:{ Exception -> 0x010e }
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch:{ Exception -> 0x010e }
            android.net.Uri r6 = r6.getData()     // Catch:{ Exception -> 0x010e }
            java.lang.String r9 = "r"
            android.content.res.AssetFileDescriptor r6 = r8.openAssetFileDescriptor(r6, r9)     // Catch:{ Exception -> 0x010e }
            com.google.android.play.core.splitcompat.c r8 = r14.b     // Catch:{ Exception -> 0x010e }
            java.io.File r8 = r8.b(r7)     // Catch:{ Exception -> 0x010e }
            boolean r9 = r8.exists()     // Catch:{ Exception -> 0x010e }
            if (r9 == 0) goto L_0x0068
            long r9 = r8.length()     // Catch:{ Exception -> 0x010e }
            long r11 = r6.getLength()     // Catch:{ Exception -> 0x010e }
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x0068
            goto L_0x006e
        L_0x0068:
            boolean r9 = r8.exists()     // Catch:{ Exception -> 0x010e }
            if (r9 != 0) goto L_0x002d
        L_0x006e:
            com.google.android.play.core.splitcompat.c r9 = r14.b     // Catch:{ Exception -> 0x010e }
            java.io.File r7 = r9.c(r7)     // Catch:{ Exception -> 0x010e }
            boolean r7 = r7.exists()     // Catch:{ Exception -> 0x010e }
            if (r7 != 0) goto L_0x002d
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x010e }
            java.io.FileInputStream r6 = r6.createInputStream()     // Catch:{ Exception -> 0x010e }
            r7.<init>(r6)     // Catch:{ Exception -> 0x010e }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x00a7 }
            r6.<init>(r8)     // Catch:{ all -> 0x00a7 }
            r8 = 4096(0x1000, float:5.74E-42)
            byte[] r8 = new byte[r8]     // Catch:{ all -> 0x009d }
        L_0x008c:
            int r9 = r7.read(r8)     // Catch:{ all -> 0x009d }
            if (r9 <= 0) goto L_0x0096
            r6.write(r8, r3, r9)     // Catch:{ all -> 0x009d }
            goto L_0x008c
        L_0x0096:
            r6.close()     // Catch:{ all -> 0x00a7 }
            r7.close()     // Catch:{ Exception -> 0x010e }
            goto L_0x002d
        L_0x009d:
            r15 = move-exception
            r6.close()     // Catch:{ all -> 0x00a2 }
            goto L_0x00a6
        L_0x00a2:
            r3 = move-exception
            com.google.android.play.core.internal.bz.a(r15, r3)     // Catch:{ all -> 0x00a7 }
        L_0x00a6:
            throw r15     // Catch:{ all -> 0x00a7 }
        L_0x00a7:
            r15 = move-exception
            r7.close()     // Catch:{ all -> 0x00ac }
            goto L_0x00b0
        L_0x00ac:
            r3 = move-exception
            com.google.android.play.core.internal.bz.a(r15, r3)     // Catch:{ Exception -> 0x010e }
        L_0x00b0:
            throw r15     // Catch:{ Exception -> 0x010e }
        L_0x00b1:
            java.lang.String r15 = "Splits copied."
            android.util.Log.i(r0, r15)     // Catch:{ Exception -> 0x010e }
            com.google.android.play.core.splitcompat.c r15 = r14.b     // Catch:{ IOException -> 0x010a }
            java.io.File r15 = r15.g()     // Catch:{ IOException -> 0x010a }
            java.io.File[] r15 = r15.listFiles()     // Catch:{ IOException -> 0x010a }
            com.google.android.play.core.internal.av r6 = r14.c     // Catch:{ Exception -> 0x0101 }
            boolean r6 = r6.a(r15)     // Catch:{ Exception -> 0x0101 }
            if (r6 == 0) goto L_0x00fb
            com.google.android.play.core.internal.av r6 = r14.c     // Catch:{ Exception -> 0x0101 }
            boolean r15 = r6.b(r15)     // Catch:{ Exception -> 0x0101 }
            if (r15 == 0) goto L_0x00fb
            com.google.android.play.core.splitcompat.c r15 = r14.b     // Catch:{ IOException -> 0x00f4 }
            java.io.File r15 = r15.g()     // Catch:{ IOException -> 0x00f4 }
            java.io.File[] r15 = r15.listFiles()     // Catch:{ IOException -> 0x00f4 }
            java.util.Arrays.sort(r15)     // Catch:{ IOException -> 0x00f4 }
            int r5 = r15.length     // Catch:{ IOException -> 0x00f4 }
        L_0x00de:
            int r5 = r5 + -1
            if (r5 < 0) goto L_0x00ee
            r6 = r15[r5]     // Catch:{ IOException -> 0x00f4 }
            com.google.android.play.core.splitcompat.c r7 = r14.b     // Catch:{ IOException -> 0x00f4 }
            java.io.File r7 = r7.d(r6)     // Catch:{ IOException -> 0x00f4 }
            r6.renameTo(r7)     // Catch:{ IOException -> 0x00f4 }
            goto L_0x00de
        L_0x00ee:
            java.lang.String r15 = "Splits verified."
            android.util.Log.i(r0, r15)     // Catch:{ all -> 0x001b }
            goto L_0x0114
        L_0x00f4:
            r15 = move-exception
            java.lang.String r3 = "Cannot write verified split."
        L_0x00f7:
            android.util.Log.e(r0, r3, r15)     // Catch:{ all -> 0x001b }
            goto L_0x0112
        L_0x00fb:
            java.lang.String r15 = "Split verification failed."
            android.util.Log.e(r0, r15)     // Catch:{ all -> 0x001b }
            goto L_0x0107
        L_0x0101:
            r15 = move-exception
            java.lang.String r3 = "Error verifying splits."
            android.util.Log.e(r0, r3, r15)     // Catch:{ all -> 0x001b }
        L_0x0107:
            r3 = -11
            goto L_0x0114
        L_0x010a:
            r15 = move-exception
            java.lang.String r3 = "Cannot access directory for unverified splits."
            goto L_0x00f7
        L_0x010e:
            r15 = move-exception
            java.lang.String r3 = "Error copying splits."
            goto L_0x00f7
        L_0x0112:
            r3 = -13
        L_0x0114:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x001b }
            r4.release()     // Catch:{ all -> 0x001b }
            goto L_0x0127
        L_0x011c:
            if (r2 == 0) goto L_0x0126
            r2.close()     // Catch:{ all -> 0x0122 }
            goto L_0x0126
        L_0x0122:
            r2 = move-exception
            com.google.android.play.core.internal.bz.a(r15, r2)     // Catch:{ Exception -> 0x012d }
        L_0x0126:
            throw r15     // Catch:{ Exception -> 0x012d }
        L_0x0127:
            if (r2 == 0) goto L_0x012c
            r2.close()     // Catch:{ Exception -> 0x012d }
        L_0x012c:
            return r3
        L_0x012d:
            r15 = move-exception
            java.lang.String r2 = "Error locking files."
            android.util.Log.e(r0, r2, r15)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r1)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.internal.at.e(java.util.List):java.lang.Integer");
    }

    public final void a(List<Intent> list, d dVar) {
        if (SplitCompat.b()) {
            this.d.execute(new as(this, list, dVar));
            return;
        }
        throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
    }
}
