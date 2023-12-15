package com.google.android.play.core.assetpacks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.common.a;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.ca;
import com.google.android.play.core.splitinstall.p;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

final class i implements AssetPackManager {
    private static final ag a = new ag("AssetPackManager");
    private final au b;
    private final ca<t> c;
    private final ar d;
    private final p e;
    private final ca f;
    private final bo g;
    /* access modifiers changed from: private */
    public final be h;
    private final ca<Executor> i;
    private final a j;
    private final Handler k = new Handler(Looper.getMainLooper());
    private boolean l;

    i(au auVar, ca<t> caVar, ar arVar, p pVar, ca caVar2, bo boVar, be beVar, ca<Executor> caVar3, a aVar) {
        this.b = auVar;
        this.c = caVar;
        this.d = arVar;
        this.e = pVar;
        this.f = caVar2;
        this.g = boVar;
        this.h = beVar;
        this.i = caVar3;
        this.j = aVar;
    }

    private final void h() {
        this.i.a().execute(new e(this, (byte[]) null));
    }

    private final void i() {
        this.i.a().execute(new e(this));
        this.l = true;
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        boolean j2 = this.d.j();
        this.d.e(z);
        if (z && !j2) {
            h();
        }
    }

    /* access modifiers changed from: package-private */
    public final int b(int i2, String str) {
        if (!this.b.a(str) && i2 == 4) {
            return 8;
        }
        if (!this.b.a(str) || i2 == 4) {
            return i2;
        }
        return 4;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void c() {
        this.b.v();
        this.b.s();
        this.b.w();
    }

    public final AssetPackStates cancel(List<String> list) {
        List<String> list2 = list;
        Map<String, Integer> h2 = this.f.h(list2);
        HashMap hashMap = new HashMap();
        for (String next : list) {
            Integer num = h2.get(next);
            hashMap.put(next, AssetPackState.c(next, num == null ? 0 : num.intValue(), 0, 0, 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0, ""));
        }
        this.c.a().b(list2);
        return AssetPackStates.a(0, hashMap);
    }

    public final void clearListeners() {
        this.d.h();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void d() {
        Task<List<String>> c2 = this.c.a().c(this.b.c());
        au auVar = this.b;
        auVar.getClass();
        c2.addOnSuccessListener(this.i.a(), f.a(auVar));
        c2.addOnFailureListener(this.i.a(), g.a);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void f(String str, com.google.android.play.core.tasks.i iVar) {
        if (this.b.q(str)) {
            iVar.a(null);
            this.c.a().i(str);
            return;
        }
        iVar.b(new IOException(String.format("Failed to remove pack %s.", new Object[]{str})));
    }

    public final Task<AssetPackStates> fetch(List<String> list) {
        Map<String, Long> c2 = this.b.c();
        ArrayList arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList();
        if (!this.j.a()) {
            arrayList.removeAll(c2.keySet());
            arrayList2.addAll(list);
            arrayList2.removeAll(arrayList);
        }
        if (!arrayList.isEmpty()) {
            return this.c.a().a(arrayList2, arrayList, c2);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt("error_code", 0);
        for (String next : list) {
            bundle.putInt(com.google.android.play.core.internal.i.e(NotificationCompat.CATEGORY_STATUS, next), 4);
            bundle.putInt(com.google.android.play.core.internal.i.e("error_code", next), 0);
            bundle.putLong(com.google.android.play.core.internal.i.e("total_bytes_to_download", next), 0);
            bundle.putLong(com.google.android.play.core.internal.i.e("bytes_downloaded", next), 0);
        }
        bundle.putStringArrayList("pack_names", new ArrayList(list));
        bundle.putLong("total_bytes_to_download", 0);
        bundle.putLong("bytes_downloaded", 0);
        return Tasks.a(AssetPackStates.b(bundle, this.g));
    }

    public final AssetLocation getAssetLocation(String str, String str2) {
        AssetPackLocation assetPackLocation;
        if (!this.l) {
            this.i.a().execute(new e(this));
            this.l = true;
        }
        if (this.b.a(str)) {
            try {
                assetPackLocation = this.b.d(str);
            } catch (IOException unused) {
            }
        } else {
            if (this.e.a().contains(str)) {
                assetPackLocation = AssetPackLocation.a();
            }
            assetPackLocation = null;
        }
        if (assetPackLocation == null) {
            return null;
        }
        if (assetPackLocation.packStorageMethod() == 1) {
            return this.b.y(str, str2);
        }
        if (assetPackLocation.packStorageMethod() == 0) {
            return this.b.z(str, str2, assetPackLocation);
        }
        a.a("The asset %s is not present in Asset Pack %s", str2, str);
        return null;
    }

    public final AssetPackLocation getPackLocation(String str) {
        if (!this.l) {
            i();
        }
        if (this.b.a(str)) {
            try {
                return this.b.d(str);
            } catch (IOException unused) {
                return null;
            }
        } else if (this.e.a().contains(str)) {
            return AssetPackLocation.a();
        } else {
            return null;
        }
    }

    public final Map<String, AssetPackLocation> getPackLocations() {
        Map<String, AssetPackLocation> b2 = this.b.b();
        HashMap hashMap = new HashMap();
        for (String put : this.e.a()) {
            hashMap.put(put, AssetPackLocation.a());
        }
        b2.putAll(hashMap);
        return b2;
    }

    public final Task<AssetPackStates> getPackStates(List<String> list) {
        return this.c.a().d(list, new c(this), this.b.c());
    }

    public final synchronized void registerListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
        boolean j2 = this.d.j();
        this.d.f(assetPackStateUpdateListener);
        if (!j2) {
            h();
        }
    }

    public final Task<Void> removePack(String str) {
        com.google.android.play.core.tasks.i iVar = new com.google.android.play.core.tasks.i();
        this.i.a().execute(new d(this, str, iVar));
        return iVar.c();
    }

    public final Task<Integer> showCellularDataConfirmation(Activity activity) {
        if (activity == null) {
            return Tasks.b(new AssetPackException(-3));
        }
        if (this.h.b() == null) {
            return Tasks.b(new AssetPackException(-12));
        }
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", this.h.b());
        com.google.android.play.core.tasks.i iVar = new com.google.android.play.core.tasks.i();
        intent.putExtra("result_receiver", new h(this, this.k, iVar));
        activity.startActivity(intent);
        return iVar.c();
    }

    public final void unregisterListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
        this.d.g(assetPackStateUpdateListener);
    }
}
