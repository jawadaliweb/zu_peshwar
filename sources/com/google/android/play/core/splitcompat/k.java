package com.google.android.play.core.splitcompat;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class k {
    public static final /* synthetic */ int a = 0;
    private static final Pattern b = Pattern.compile("lib/([^/]+)/(.*\\.so)$");
    private final c c;

    k(c cVar) throws IOException {
        this.c = cVar;
    }

    static /* synthetic */ Set d(k kVar, Set set, q qVar, ZipFile zipFile) throws IOException {
        HashSet hashSet = new HashSet();
        kVar.f(qVar, set, new g(hashSet, qVar, zipFile));
        return hashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f4 A[SYNTHETIC, Splitter:B:34:0x00f4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void e(com.google.android.play.core.splitcompat.q r13, com.google.android.play.core.splitcompat.h r14) throws java.io.IOException {
        /*
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x00f0 }
            java.io.File r1 = r13.a()     // Catch:{ IOException -> 0x00f0 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x00f0 }
            java.lang.String r13 = r13.b()     // Catch:{ IOException -> 0x00ee }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ IOException -> 0x00ee }
            r1.<init>()     // Catch:{ IOException -> 0x00ee }
            java.util.Enumeration r2 = r0.entries()     // Catch:{ IOException -> 0x00ee }
        L_0x0016:
            boolean r3 = r2.hasMoreElements()     // Catch:{ IOException -> 0x00ee }
            r4 = 2
            java.lang.String r5 = "SplitCompat"
            r6 = 0
            r7 = 1
            if (r3 == 0) goto L_0x006a
            java.lang.Object r3 = r2.nextElement()     // Catch:{ IOException -> 0x00ee }
            java.util.zip.ZipEntry r3 = (java.util.zip.ZipEntry) r3     // Catch:{ IOException -> 0x00ee }
            java.lang.String r8 = r3.getName()     // Catch:{ IOException -> 0x00ee }
            java.util.regex.Pattern r9 = b     // Catch:{ IOException -> 0x00ee }
            java.util.regex.Matcher r8 = r9.matcher(r8)     // Catch:{ IOException -> 0x00ee }
            boolean r9 = r8.matches()     // Catch:{ IOException -> 0x00ee }
            if (r9 == 0) goto L_0x0016
            java.lang.String r9 = r8.group(r7)     // Catch:{ IOException -> 0x00ee }
            java.lang.String r8 = r8.group(r4)     // Catch:{ IOException -> 0x00ee }
            r10 = 3
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ IOException -> 0x00ee }
            r10[r6] = r13     // Catch:{ IOException -> 0x00ee }
            r10[r7] = r8     // Catch:{ IOException -> 0x00ee }
            r10[r4] = r9     // Catch:{ IOException -> 0x00ee }
            java.lang.String r4 = "NativeLibraryExtractor: split '%s' has native library '%s' for ABI '%s'"
            java.lang.String r4 = java.lang.String.format(r4, r10)     // Catch:{ IOException -> 0x00ee }
            android.util.Log.d(r5, r4)     // Catch:{ IOException -> 0x00ee }
            java.lang.Object r4 = r1.get(r9)     // Catch:{ IOException -> 0x00ee }
            java.util.Set r4 = (java.util.Set) r4     // Catch:{ IOException -> 0x00ee }
            if (r4 != 0) goto L_0x0061
            java.util.HashSet r4 = new java.util.HashSet     // Catch:{ IOException -> 0x00ee }
            r4.<init>()     // Catch:{ IOException -> 0x00ee }
            r1.put(r9, r4)     // Catch:{ IOException -> 0x00ee }
        L_0x0061:
            com.google.android.play.core.splitcompat.j r5 = new com.google.android.play.core.splitcompat.j     // Catch:{ IOException -> 0x00ee }
            r5.<init>(r3, r8)     // Catch:{ IOException -> 0x00ee }
            r4.add(r5)     // Catch:{ IOException -> 0x00ee }
            goto L_0x0016
        L_0x006a:
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ IOException -> 0x00ee }
            r13.<init>()     // Catch:{ IOException -> 0x00ee }
            java.lang.String[] r2 = android.os.Build.SUPPORTED_ABIS     // Catch:{ IOException -> 0x00ee }
            int r3 = r2.length     // Catch:{ IOException -> 0x00ee }
            r8 = 0
        L_0x0073:
            if (r8 >= r3) goto L_0x00de
            r9 = r2[r8]     // Catch:{ IOException -> 0x00ee }
            boolean r10 = r1.containsKey(r9)     // Catch:{ IOException -> 0x00ee }
            if (r10 == 0) goto L_0x00ce
            java.lang.Object[] r10 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x00ee }
            r10[r6] = r9     // Catch:{ IOException -> 0x00ee }
            java.lang.String r11 = "NativeLibraryExtractor: there are native libraries for supported ABI %s; will use this ABI"
            java.lang.String r10 = java.lang.String.format(r11, r10)     // Catch:{ IOException -> 0x00ee }
            android.util.Log.d(r5, r10)     // Catch:{ IOException -> 0x00ee }
            java.lang.Object r10 = r1.get(r9)     // Catch:{ IOException -> 0x00ee }
            java.util.Set r10 = (java.util.Set) r10     // Catch:{ IOException -> 0x00ee }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ IOException -> 0x00ee }
        L_0x0094:
            boolean r11 = r10.hasNext()     // Catch:{ IOException -> 0x00ee }
            if (r11 == 0) goto L_0x00db
            java.lang.Object r11 = r10.next()     // Catch:{ IOException -> 0x00ee }
            com.google.android.play.core.splitcompat.j r11 = (com.google.android.play.core.splitcompat.j) r11     // Catch:{ IOException -> 0x00ee }
            java.lang.String r12 = r11.a     // Catch:{ IOException -> 0x00ee }
            boolean r12 = r13.containsKey(r12)     // Catch:{ IOException -> 0x00ee }
            if (r12 == 0) goto L_0x00ba
            java.lang.Object[] r12 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x00ee }
            java.lang.String r11 = r11.a     // Catch:{ IOException -> 0x00ee }
            r12[r6] = r11     // Catch:{ IOException -> 0x00ee }
            r12[r7] = r9     // Catch:{ IOException -> 0x00ee }
            java.lang.String r11 = "NativeLibraryExtractor: skipping library %s for ABI %s; already present for a better ABI"
            java.lang.String r11 = java.lang.String.format(r11, r12)     // Catch:{ IOException -> 0x00ee }
        L_0x00b6:
            android.util.Log.d(r5, r11)     // Catch:{ IOException -> 0x00ee }
            goto L_0x0094
        L_0x00ba:
            java.lang.String r12 = r11.a     // Catch:{ IOException -> 0x00ee }
            r13.put(r12, r11)     // Catch:{ IOException -> 0x00ee }
            java.lang.Object[] r12 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x00ee }
            java.lang.String r11 = r11.a     // Catch:{ IOException -> 0x00ee }
            r12[r6] = r11     // Catch:{ IOException -> 0x00ee }
            r12[r7] = r9     // Catch:{ IOException -> 0x00ee }
            java.lang.String r11 = "NativeLibraryExtractor: using library %s for ABI %s"
            java.lang.String r11 = java.lang.String.format(r11, r12)     // Catch:{ IOException -> 0x00ee }
            goto L_0x00b6
        L_0x00ce:
            java.lang.Object[] r10 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x00ee }
            r10[r6] = r9     // Catch:{ IOException -> 0x00ee }
            java.lang.String r9 = "NativeLibraryExtractor: there are no native libraries for supported ABI %s"
            java.lang.String r9 = java.lang.String.format(r9, r10)     // Catch:{ IOException -> 0x00ee }
            android.util.Log.d(r5, r9)     // Catch:{ IOException -> 0x00ee }
        L_0x00db:
            int r8 = r8 + 1
            goto L_0x0073
        L_0x00de:
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ IOException -> 0x00ee }
            java.util.Collection r13 = r13.values()     // Catch:{ IOException -> 0x00ee }
            r1.<init>(r13)     // Catch:{ IOException -> 0x00ee }
            r14.a(r0, r1)     // Catch:{ IOException -> 0x00ee }
            r0.close()     // Catch:{ IOException -> 0x00ee }
            return
        L_0x00ee:
            r13 = move-exception
            goto L_0x00f2
        L_0x00f0:
            r13 = move-exception
            r0 = 0
        L_0x00f2:
            if (r0 == 0) goto L_0x00fc
            r0.close()     // Catch:{ IOException -> 0x00f8 }
            goto L_0x00fc
        L_0x00f8:
            r14 = move-exception
            com.google.android.play.core.internal.bz.a(r13, r14)
        L_0x00fc:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitcompat.k.e(com.google.android.play.core.splitcompat.q, com.google.android.play.core.splitcompat.h):void");
    }

    /* access modifiers changed from: private */
    public final void f(q qVar, Set<j> set, i iVar) throws IOException {
        for (j next : set) {
            File e = this.c.e(qVar.b(), next.a);
            boolean z = false;
            if (e.exists() && e.length() == next.b.getSize()) {
                z = true;
            }
            iVar.a(next, e, z);
        }
    }

    /* access modifiers changed from: package-private */
    public final Set<File> a() throws IOException {
        Log.d("SplitCompat", "NativeLibraryExtractor: synchronizing native libraries");
        Set<q> i = this.c.i();
        for (String next : this.c.j()) {
            Iterator<q> it = i.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().b().equals(next)) {
                        break;
                    }
                } else {
                    Log.i("SplitCompat", String.format("NativeLibraryExtractor: extracted split '%s' has no corresponding split; deleting", new Object[]{next}));
                    this.c.k(next);
                    break;
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (q next2 : i) {
            HashSet hashSet2 = new HashSet();
            e(next2, new f(this, hashSet2, next2));
            for (File next3 : this.c.m(next2.b())) {
                if (!hashSet2.contains(next3)) {
                    Log.i("SplitCompat", String.format("NativeLibraryExtractor: file '%s' found in split '%s' that is not in the split file '%s'; removing", new Object[]{next3.getAbsolutePath(), next2.b(), next2.a().getAbsolutePath()}));
                    this.c.l(next3);
                }
            }
            hashSet.addAll(hashSet2);
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    public final Set<File> b(q qVar) throws IOException {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        HashSet hashSet = new HashSet();
        e(qVar, new e(this, qVar, hashSet, atomicBoolean));
        if (atomicBoolean.get()) {
            return hashSet;
        }
        return null;
    }
}
