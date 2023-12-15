package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.bz;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

final class au {
    private static final ag a = new ag("AssetPackStorage");
    private static final long b = TimeUnit.DAYS.toMillis(14);
    private static final long c = TimeUnit.DAYS.toMillis(28);
    private final Context d;
    private final cv e;

    au(Context context, cv cvVar) {
        this.d = context;
        this.e = cvVar;
    }

    private final File D(String str, int i) {
        return new File(E(str), String.valueOf(i));
    }

    private final File E(String str) {
        return new File(O(), str);
    }

    private final File F(String str, int i, long j) {
        return new File(j(str, i, j), "merge.tmp");
    }

    private static void G(File file) {
        if (file.listFiles() != null && file.listFiles().length > 1) {
            long J = J(file);
            for (File file2 : file.listFiles()) {
                if (!file2.getName().equals(String.valueOf(J)) && !file2.getName().equals("stale.tmp")) {
                    P(file2);
                }
            }
        }
    }

    private static long H(File file) {
        return I(file, true);
    }

    private static long I(File file, boolean z) {
        if (!file.exists()) {
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        if (z && file.listFiles().length > 1) {
            a.e("Multiple pack versions found, using highest version code.", new Object[0]);
        }
        try {
            for (File file2 : file.listFiles()) {
                if (!file2.getName().equals("stale.tmp")) {
                    arrayList.add(Long.valueOf(file2.getName()));
                }
            }
        } catch (NumberFormatException e2) {
            a.c(e2, "Corrupt asset pack directories.", new Object[0]);
        }
        if (arrayList.isEmpty()) {
            return -1;
        }
        Collections.sort(arrayList);
        return ((Long) arrayList.get(arrayList.size() - 1)).longValue();
    }

    private static long J(File file) {
        return I(file, false);
    }

    private static List<String> K(PackageInfo packageInfo, String str) {
        ArrayList arrayList = new ArrayList();
        if (packageInfo.splitNames == null) {
            return arrayList;
        }
        int i = (-Arrays.binarySearch(packageInfo.splitNames, str)) - 1;
        while (i < packageInfo.splitNames.length && packageInfo.splitNames[i].startsWith(str)) {
            arrayList.add(packageInfo.applicationInfo.splitSourceDirs[i]);
            i++;
        }
        return arrayList;
    }

    private final List<File> L() {
        ArrayList arrayList = new ArrayList();
        try {
            if (O().exists()) {
                if (O().listFiles() != null) {
                    for (File file : O().listFiles()) {
                        if (!file.getCanonicalPath().equals(N().getCanonicalPath())) {
                            arrayList.add(file);
                        }
                    }
                    return arrayList;
                }
            }
            return arrayList;
        } catch (IOException e2) {
            a.b("Could not process directory while scanning installed packs. %s", e2);
        }
    }

    private final File M(String str, int i, long j) {
        return new File(new File(new File(N(), str), String.valueOf(i)), String.valueOf(j));
    }

    private final File N() {
        return new File(O(), "_tmp");
    }

    private final File O() {
        return new File(this.d.getFilesDir(), "assetpacks");
    }

    private static boolean P(File file) {
        boolean z;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            z = true;
            for (File P : listFiles) {
                z &= P(P);
            }
        } else {
            z = true;
        }
        return file.delete() && true == z;
    }

    /* access modifiers changed from: package-private */
    public final void A(List<String> list) {
        int a2 = this.e.a();
        for (File next : L()) {
            if (!list.contains(next.getName()) && H(next) != ((long) a2)) {
                P(next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void B(String str, int i, long j) {
        if (M(str, i, j).exists()) {
            P(M(str, i, j));
        }
    }

    /* access modifiers changed from: package-private */
    public final void C(String str, int i, long j) {
        if (f(str, i, j).exists()) {
            P(f(str, i, j));
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(String str) {
        try {
            return e(str) != null;
        } catch (IOException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<String, AssetPackLocation> b() {
        HashMap hashMap = new HashMap();
        try {
            for (File next : L()) {
                AssetPackLocation d2 = d(next.getName());
                if (d2 != null) {
                    hashMap.put(next.getName(), d2);
                }
            }
        } catch (IOException e2) {
            a.b("Could not process directory while scanning installed packs: %s", e2);
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public final Map<String, Long> c() {
        HashMap hashMap = new HashMap();
        for (String next : b().keySet()) {
            hashMap.put(next, Long.valueOf(u(next)));
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public final AssetPackLocation d(String str) throws IOException {
        String e2 = e(str);
        if (e2 == null) {
            return null;
        }
        File file = new File(e2, "assets");
        if (file.isDirectory()) {
            return AssetPackLocation.b(e2, file.getCanonicalPath());
        }
        a.b("Failed to find assets directory: %s", file);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final String e(String str) throws IOException {
        int length;
        File file = new File(O(), str);
        if (!file.exists()) {
            a.a("Pack not found with pack name: %s", str);
            return null;
        }
        File file2 = new File(file, String.valueOf(this.e.a()));
        if (!file2.exists()) {
            a.a("Pack not found with pack name: %s app version: %s", str, Integer.valueOf(this.e.a()));
            return null;
        }
        File[] listFiles = file2.listFiles();
        if (listFiles == null || (length = listFiles.length) == 0) {
            a.a("No pack version found for pack name: %s app version: %s", str, Integer.valueOf(this.e.a()));
            return null;
        } else if (length <= 1) {
            return listFiles[0].getCanonicalPath();
        } else {
            a.b("Multiple pack versions found for pack name: %s app version: %s", str, Integer.valueOf(this.e.a()));
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final File f(String str, int i, long j) {
        return new File(D(str, i), String.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final File g(String str, int i, long j) {
        return new File(f(str, i, j), "_metadata");
    }

    /* access modifiers changed from: package-private */
    public final File h(String str, int i, long j, String str2) {
        return new File(new File(new File(M(str, i, j), "_slices"), "_unverified"), str2);
    }

    /* access modifiers changed from: package-private */
    public final File i(String str, int i, long j, String str2) {
        return new File(new File(new File(M(str, i, j), "_slices"), "_verified"), str2);
    }

    /* access modifiers changed from: package-private */
    public final File j(String str, int i, long j) {
        return new File(M(str, i, j), "_packs");
    }

    /* access modifiers changed from: package-private */
    public final int k(String str, int i, long j) throws IOException {
        File F = F(str, i, j);
        if (!F.exists()) {
            return 0;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(F);
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("numberOfMerges") != null) {
                try {
                    return Integer.parseInt(properties.getProperty("numberOfMerges"));
                } catch (NumberFormatException e2) {
                    throw new bk("Merge checkpoint file corrupt.", (Exception) e2);
                }
            } else {
                throw new bk("Merge checkpoint file corrupt.");
            }
        } catch (Throwable th) {
            bz.a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public final void l(String str, int i, long j, int i2) throws IOException {
        File F = F(str, i, j);
        Properties properties = new Properties();
        properties.put("numberOfMerges", String.valueOf(i2));
        F.getParentFile().mkdirs();
        F.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(F);
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
    }

    /* access modifiers changed from: package-private */
    public final File m(String str, int i, long j, String str2) {
        return new File(o(str, i, j, str2), "checkpoint.dat");
    }

    /* access modifiers changed from: package-private */
    public final File n(String str, int i, long j, String str2) {
        return new File(o(str, i, j, str2), "checkpoint_ext.dat");
    }

    /* access modifiers changed from: package-private */
    public final File o(String str, int i, long j, String str2) {
        return new File(p(str, i, j), str2);
    }

    /* access modifiers changed from: package-private */
    public final File p(String str, int i, long j) {
        return new File(new File(M(str, i, j), "_slices"), "_metadata");
    }

    /* access modifiers changed from: package-private */
    public final boolean q(String str) {
        if (!E(str).exists()) {
            return true;
        }
        return P(E(str));
    }

    /* access modifiers changed from: package-private */
    public final void r(String str, int i, long j) {
        File E = E(str);
        if (E.exists()) {
            for (File file : E.listFiles()) {
                if (!file.getName().equals(String.valueOf(i)) && !file.getName().equals("stale.tmp")) {
                    P(file);
                } else if (file.getName().equals(String.valueOf(i))) {
                    for (File file2 : file.listFiles()) {
                        if (!file2.getName().equals(String.valueOf(j))) {
                            P(file2);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void s() {
        for (File next : L()) {
            if (next.listFiles() != null) {
                G(next);
                long J = J(next);
                if (((long) this.e.a()) != J) {
                    try {
                        new File(new File(next, String.valueOf(J)), "stale.tmp").createNewFile();
                    } catch (IOException unused) {
                        a.b("Could not write staleness marker.", new Object[0]);
                    }
                }
                for (File G : next.listFiles()) {
                    G(G);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int t(String str) {
        return (int) H(E(str));
    }

    /* access modifiers changed from: package-private */
    public final long u(String str) {
        return H(D(str, t(str)));
    }

    /* access modifiers changed from: package-private */
    public final void v() {
        for (File next : L()) {
            if (next.listFiles() != null) {
                for (File file : next.listFiles()) {
                    File file2 = new File(file, "stale.tmp");
                    if (file2.exists() && System.currentTimeMillis() - file2.lastModified() > c) {
                        P(file);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void w() {
        if (N().exists()) {
            for (File file : N().listFiles()) {
                if (System.currentTimeMillis() - file.lastModified() > b) {
                    P(file);
                } else {
                    G(file);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void x() {
        P(O());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.play.core.assetpacks.AssetLocation y(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            android.content.Context r2 = r8.d     // Catch:{ NameNotFoundException -> 0x0013 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0013 }
            android.content.Context r3 = r8.d     // Catch:{ NameNotFoundException -> 0x0013 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ NameNotFoundException -> 0x0013 }
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r3, r0)     // Catch:{ NameNotFoundException -> 0x0013 }
            goto L_0x001d
        L_0x0013:
            com.google.android.play.core.internal.ag r2 = a
            java.lang.Object[] r3 = new java.lang.Object[r0]
            java.lang.String r4 = "Could not find PackageInfo."
            r2.b(r4, r3)
            r2 = r1
        L_0x001d:
            r3 = 1
            if (r2 != 0) goto L_0x0022
            r4 = r1
            goto L_0x0087
        L_0x0022:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 21
            if (r5 >= r6) goto L_0x0035
            android.content.pm.ApplicationInfo r2 = r2.applicationInfo
            java.lang.String r2 = r2.sourceDir
            r4.add(r2)
            goto L_0x0087
        L_0x0035:
            java.lang.String[] r5 = r2.splitNames
            if (r5 == 0) goto L_0x005b
            android.content.pm.ApplicationInfo r5 = r2.applicationInfo
            java.lang.String[] r5 = r5.splitSourceDirs
            if (r5 != 0) goto L_0x0040
            goto L_0x005b
        L_0x0040:
            java.lang.String[] r5 = r2.splitNames
            int r5 = java.util.Arrays.binarySearch(r5, r9)
            if (r5 >= 0) goto L_0x0054
            com.google.android.play.core.internal.ag r5 = a
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r6[r0] = r9
            java.lang.String r7 = "Asset Pack '%s' is not installed."
            r5.a(r7, r6)
            goto L_0x0066
        L_0x0054:
            android.content.pm.ApplicationInfo r6 = r2.applicationInfo
            java.lang.String[] r6 = r6.splitSourceDirs
            r5 = r6[r5]
            goto L_0x0067
        L_0x005b:
            com.google.android.play.core.internal.ag r5 = a
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r6[r0] = r9
            java.lang.String r7 = "No splits present for package %s."
            r5.a(r7, r6)
        L_0x0066:
            r5 = r1
        L_0x0067:
            if (r5 != 0) goto L_0x0073
            android.content.pm.ApplicationInfo r5 = r2.applicationInfo
            java.lang.String r5 = r5.sourceDir
            r4.add(r5)
            java.lang.String r5 = "config."
            goto L_0x0080
        L_0x0073:
            r4.add(r5)
            java.lang.String r5 = java.lang.String.valueOf(r9)
            java.lang.String r6 = ".config."
            java.lang.String r5 = r5.concat(r6)
        L_0x0080:
            java.util.List r2 = K(r2, r5)
            r4.addAll(r2)
        L_0x0087:
            if (r4 != 0) goto L_0x008a
            goto L_0x00cd
        L_0x008a:
            java.io.File r2 = new java.io.File
            java.lang.String r5 = "assets"
            r2.<init>(r5, r10)
            java.lang.String r2 = r2.getPath()
            java.util.Iterator r5 = r4.iterator()
        L_0x0099:
            boolean r6 = r5.hasNext()
            r7 = 2
            if (r6 == 0) goto L_0x00bd
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            com.google.android.play.core.assetpacks.AssetLocation r6 = com.google.android.play.core.assetpacks.ck.b(r6, r2)     // Catch:{ IOException -> 0x00ae }
            if (r6 == 0) goto L_0x0099
            r1 = r6
            goto L_0x00cd
        L_0x00ae:
            r9 = move-exception
            com.google.android.play.core.internal.ag r2 = a
            java.lang.Object[] r4 = new java.lang.Object[r7]
            r4[r0] = r6
            r4[r3] = r10
            java.lang.String r10 = "Failed to parse APK file '%s' looking for asset '%s'."
            r2.c(r9, r10, r4)
            goto L_0x00cd
        L_0x00bd:
            com.google.android.play.core.internal.ag r2 = a
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r0] = r10
            r5[r3] = r9
            r5[r7] = r4
            java.lang.String r9 = "The asset %s is not present in Asset Pack %s. Searched in APKs: %s"
            r2.a(r9, r5)
        L_0x00cd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.au.y(java.lang.String, java.lang.String):com.google.android.play.core.assetpacks.AssetLocation");
    }

    /* access modifiers changed from: package-private */
    public final AssetLocation z(String str, String str2, AssetPackLocation assetPackLocation) {
        File file = new File(assetPackLocation.assetsPath(), str2);
        if (file.exists()) {
            return AssetLocation.a(file.getPath(), 0, file.length());
        }
        a.a("The asset %s is not present in Asset Pack %s. Searched in folder: %s", str2, str, assetPackLocation.assetsPath());
        return null;
    }
}
