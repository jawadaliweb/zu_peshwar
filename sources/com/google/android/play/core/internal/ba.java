package com.google.android.play.core.internal;

import android.util.Log;
import com.google.android.play.core.splitinstall.k;
import com.richpath.RichPath;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;

final class ba implements aw {
    private final /* synthetic */ int a = 0;

    ba() {
    }

    ba(byte[] bArr) {
    }

    ba(char[] cArr) {
    }

    ba(float[] fArr) {
    }

    ba(int[] iArr) {
    }

    ba(short[] sArr) {
    }

    ba(boolean[] zArr) {
    }

    ba(byte[][] bArr) {
    }

    static void c(ClassLoader classLoader, Set<File> set) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File next : set) {
                String valueOf = String.valueOf(next.getParentFile().getAbsolutePath());
                Log.d("Splitcompat", valueOf.length() != 0 ? "Adding native library parent directory: ".concat(valueOf) : new String("Adding native library parent directory: "));
                hashSet.add(next.getParentFile());
            }
            bg e = bh.e(e(classLoader), "nativeLibraryDirectories", File.class);
            hashSet.removeAll(Arrays.asList((File[]) e.a()));
            synchronized (k.class) {
                int size = hashSet.size();
                StringBuilder sb = new StringBuilder(30);
                sb.append("Adding directories ");
                sb.append(size);
                Log.d("Splitcompat", sb.toString());
                e.e(hashSet);
            }
        }
    }

    static boolean d(ClassLoader classLoader, File file, File file2, boolean z, az azVar, String str, ay ayVar) {
        ArrayList arrayList = new ArrayList();
        Object e = e(classLoader);
        bg e2 = bh.e(e, "dexElements", Object.class);
        List<Object> asList = Arrays.asList((Object[]) e2.a());
        ArrayList arrayList2 = new ArrayList();
        for (Object d : asList) {
            arrayList2.add(bh.d(d, str, File.class).a());
        }
        if (arrayList2.contains(file2)) {
            return true;
        }
        if (z || ayVar.a(e, file2, file)) {
            e2.d(Arrays.asList(azVar.a(e, new ArrayList(Collections.singleton(file2)), file, arrayList)));
            if (arrayList.isEmpty()) {
                return true;
            }
            bf bfVar = new bf("DexPathList.makeDexElement failed");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                IOException iOException = (IOException) arrayList.get(i);
                Log.e("SplitCompat", "DexPathList.makeDexElement failed", iOException);
                bz.a(bfVar, iOException);
            }
            bh.e(e, "dexElementsSuppressedExceptions", IOException.class).d(arrayList);
            throw bfVar;
        }
        String valueOf = String.valueOf(file2.getPath());
        Log.w("SplitCompat", valueOf.length() != 0 ? "Should be optimized ".concat(valueOf) : new String("Should be optimized "));
        return false;
    }

    static Object e(ClassLoader classLoader) {
        return bh.d(classLoader, "pathList", Object.class).a();
    }

    static az f() {
        return new bb((byte[]) null);
    }

    static ay g() {
        return new be((byte[]) null);
    }

    public static void h(ClassLoader classLoader, Set<File> set, bc bcVar) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File parentFile : set) {
                hashSet.add(parentFile.getParentFile());
            }
            Object e = e(classLoader);
            bg<List> d = bh.d(e, "nativeLibraryDirectories", List.class);
            synchronized (k.class) {
                ArrayList arrayList = new ArrayList(d.a());
                hashSet.removeAll(arrayList);
                arrayList.addAll(hashSet);
                d.b(arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            Object[] a2 = bcVar.a(e, new ArrayList(hashSet), arrayList2);
            if (!arrayList2.isEmpty()) {
                bf bfVar = new bf("Error in makePathElements");
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    bz.a(bfVar, (IOException) arrayList2.get(i));
                }
                throw bfVar;
            }
            synchronized (k.class) {
                bh.e(e, "nativeLibraryPathElements", Object.class).e(Arrays.asList(a2));
            }
        }
    }

    static az i() {
        return new bb();
    }

    static bc j() {
        return new bd((byte[]) null);
    }

    public static boolean k(ClassLoader classLoader, File file, File file2, boolean z) {
        return d(classLoader, file, file2, z, i(), ArchiveStreamFactory.ZIP, g());
    }

    static void l(ClassLoader classLoader, Set<File> set) {
        h(classLoader, set, new bd());
    }

    static boolean m(ClassLoader classLoader, File file, File file2, boolean z) {
        return d(classLoader, file, file2, z, i(), RichPath.TAG_NAME, new be());
    }

    public final void a(ClassLoader classLoader, Set set) {
        switch (this.a) {
            case 0:
                c(classLoader, set);
                return;
            case 1:
                c(classLoader, set);
                return;
            case 2:
            case 3:
            case 4:
                h(classLoader, set, j());
                return;
            case 5:
                l(classLoader, set);
                return;
            case 6:
                l(classLoader, set);
                return;
            default:
                l(classLoader, set);
                return;
        }
    }

    public final boolean b(ClassLoader classLoader, File file, File file2, boolean z) {
        az f;
        ay g;
        String str;
        switch (this.a) {
            case 0:
            case 1:
                f = f();
                g = g();
                str = ArchiveStreamFactory.ZIP;
                break;
            case 2:
                return k(classLoader, file, file2, z);
            case 3:
                return k(classLoader, file, file2, z);
            case 4:
                return k(classLoader, file, file2, z);
            case 5:
                return m(classLoader, file, file2, z);
            case 6:
                return m(classLoader, file, file2, z);
            default:
                f = i();
                g = new be((char[]) null);
                str = RichPath.TAG_NAME;
                break;
        }
        return d(classLoader, file, file2, z, f, str, g);
    }
}
