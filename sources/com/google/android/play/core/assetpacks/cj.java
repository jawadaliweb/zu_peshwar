package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import androidx.core.app.NotificationCompat;
import com.google.android.play.core.common.LocalTestingException;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.ax;
import com.google.android.play.core.internal.ca;
import com.google.android.play.core.internal.i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

final class cj implements t {
    private static final ag a = new ag("FakeAssetPackService");
    private static final AtomicInteger h = new AtomicInteger(1);
    private final String b;
    private final ar c;
    private final bo d;
    private final Context e;
    private final cv f;
    private final ca<Executor> g;
    private final Handler i = new Handler(Looper.getMainLooper());

    cj(File file, ar arVar, bo boVar, Context context, cv cvVar, ca<Executor> caVar) {
        this.b = file.getAbsolutePath();
        this.c = arVar;
        this.d = boVar;
        this.e = context;
        this.f = cvVar;
        this.g = caVar;
    }

    static long k(int i2, long j) {
        if (i2 == 2) {
            return j / 2;
        }
        if (i2 == 3 || i2 == 4) {
            return j;
        }
        return 0;
    }

    private final AssetPackState p(String str, int i2) throws LocalTestingException {
        long j = 0;
        for (File length : q(str)) {
            j += length.length();
        }
        return AssetPackState.c(str, i2, 0, k(i2, j), j, this.d.b(str), 1, "");
    }

    private final File[] q(String str) throws LocalTestingException {
        File file = new File(this.b);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles(new ch(str));
            if (listFiles != null) {
                if (r1 != 0) {
                    for (File b2 : listFiles) {
                        if (ax.b(b2).equals(str)) {
                            return listFiles;
                        }
                    }
                    throw new LocalTestingException(String.format("No master slice available for pack '%s'.", new Object[]{str}));
                }
                throw new LocalTestingException(String.format("No APKs available for pack '%s'.", new Object[]{str}));
            }
            throw new LocalTestingException(String.format("Failed fetching APKs for pack '%s'.", new Object[]{str}));
        }
        throw new LocalTestingException(String.format("Local testing directory '%s' not found.", new Object[]{file}));
    }

    private static String r(File file) throws LocalTestingException {
        try {
            return ck.a(Arrays.asList(new File[]{file}));
        } catch (NoSuchAlgorithmException e2) {
            throw new LocalTestingException("SHA256 algorithm not supported.", e2);
        } catch (IOException e3) {
            throw new LocalTestingException(String.format("Could not digest file: %s.", new Object[]{file}), e3);
        }
    }

    private final void s(int i2, String str, int i3) throws LocalTestingException {
        Bundle bundle = new Bundle();
        bundle.putInt("app_version_code", this.f.a());
        bundle.putInt("session_id", i2);
        File[] q = q(str);
        ArrayList arrayList = new ArrayList();
        long j = 0;
        for (File file : q) {
            j += file.length();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(i3 == 3 ? new Intent().setData(Uri.EMPTY) : null);
            String b2 = ax.b(file);
            bundle.putParcelableArrayList(i.f("chunk_intents", str, b2), arrayList2);
            bundle.putString(i.f("uncompressed_hash_sha256", str, b2), r(file));
            bundle.putLong(i.f("uncompressed_size", str, b2), file.length());
            arrayList.add(b2);
        }
        bundle.putStringArrayList(i.e("slice_ids", str), arrayList);
        bundle.putLong(i.e("pack_version", str), (long) this.f.a());
        bundle.putInt(i.e(NotificationCompat.CATEGORY_STATUS, str), i3);
        bundle.putInt(i.e("error_code", str), 0);
        bundle.putLong(i.e("bytes_downloaded", str), k(i3, j));
        bundle.putLong(i.e("total_bytes_to_download", str), j);
        bundle.putStringArrayList("pack_names", new ArrayList(Arrays.asList(new String[]{str})));
        bundle.putLong("bytes_downloaded", k(i3, j));
        bundle.putLong("total_bytes_to_download", j);
        this.i.post(new ci(this, new Intent("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE").putExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE", bundle)));
    }

    public final Task<AssetPackStates> a(List<String> list, List<String> list2, Map<String, Long> map) {
        a.d("startDownload(%s)", list2);
        com.google.android.play.core.tasks.i iVar = new com.google.android.play.core.tasks.i();
        this.g.a().execute(new ce(this, list2, iVar, list));
        return iVar.c();
    }

    public final void b(List<String> list) {
        a.d("cancelDownload(%s)", list);
    }

    public final Task<List<String>> c(Map<String, Long> map) {
        a.d("syncPacks()", new Object[0]);
        return Tasks.a(new ArrayList());
    }

    public final Task<AssetPackStates> d(List<String> list, as asVar, Map<String, Long> map) {
        a.d("getPackStates(%s)", list);
        com.google.android.play.core.tasks.i iVar = new com.google.android.play.core.tasks.i();
        this.g.a().execute(new cf(this, list, asVar, iVar));
        return iVar.c();
    }

    public final void e(int i2, String str, String str2, int i3) {
        a.d("notifyChunkTransferred", new Object[0]);
    }

    public final void f(int i2, String str) {
        a.d("notifyModuleCompleted", new Object[0]);
        this.g.a().execute(new cg(this, i2, str));
    }

    public final void g(int i2) {
        a.d("notifySessionFailed", new Object[0]);
    }

    public final Task<ParcelFileDescriptor> h(int i2, String str, String str2, int i3) {
        a.d("getChunkFileDescriptor(session=%d, %s, %s, %d)", Integer.valueOf(i2), str, str2, Integer.valueOf(i3));
        com.google.android.play.core.tasks.i iVar = new com.google.android.play.core.tasks.i();
        try {
            for (File file : q(str)) {
                if (ax.b(file).equals(str2)) {
                    iVar.a(ParcelFileDescriptor.open(file, 268435456));
                    return iVar.c();
                }
            }
            throw new LocalTestingException(String.format("Local testing slice for '%s' not found.", new Object[]{str2}));
        } catch (FileNotFoundException e2) {
            a.e("getChunkFileDescriptor failed", e2);
            iVar.b(new LocalTestingException("Asset Slice file not found.", e2));
        } catch (LocalTestingException e3) {
            a.e("getChunkFileDescriptor failed", e3);
            iVar.b(e3);
        }
    }

    public final void i(String str) {
        a.d("removePack(%s)", str);
    }

    public final void j() {
        a.d("keepAlive", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void l(Intent intent) {
        this.c.a(this.e, intent);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void m(int i2, String str) {
        try {
            s(i2, str, 4);
        } catch (LocalTestingException e2) {
            a.e("notifyModuleCompleted failed", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void n(List list, as asVar, com.google.android.play.core.tasks.i iVar) {
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                AssetPackState p = p(str, asVar.a(8, str));
                j += p.totalBytesToDownload();
                hashMap.put(str, p);
            } catch (LocalTestingException e2) {
                iVar.b(e2);
                return;
            }
        }
        iVar.a(AssetPackStates.a(j, hashMap));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void o(List list, com.google.android.play.core.tasks.i iVar, List list2) {
        com.google.android.play.core.tasks.i iVar2 = iVar;
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                AssetPackState p = p(str, 1);
                j += p.totalBytesToDownload();
                hashMap.put(str, p);
            } catch (LocalTestingException e2) {
                iVar2.b(e2);
                return;
            }
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            try {
                int andIncrement = h.getAndIncrement();
                s(andIncrement, str2, 1);
                s(andIncrement, str2, 2);
                s(andIncrement, str2, 3);
            } catch (LocalTestingException e3) {
                iVar2.b(e3);
                return;
            }
        }
        Iterator it3 = list2.iterator();
        while (it3.hasNext()) {
            String str3 = (String) it3.next();
            hashMap.put(str3, AssetPackState.c(str3, 4, 0, 0, 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1, ""));
        }
        iVar2.a(AssetPackStates.a(j, hashMap));
    }
}
