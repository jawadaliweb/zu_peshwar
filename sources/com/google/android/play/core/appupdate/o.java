package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.play.core.common.PlayCoreVersion;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.aq;
import com.google.android.play.core.internal.bp;
import com.google.android.play.core.splitcompat.p;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import com.google.android.play.core.tasks.i;

final class o {
    /* access modifiers changed from: private */
    public static final ag b = new ag("AppUpdateService");
    private static final Intent c = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");
    aq<com.google.android.play.core.internal.o> a;
    /* access modifiers changed from: private */
    public final String d;
    private final Context e;
    private final q f;

    public o(Context context, q qVar) {
        this.d = context.getPackageName();
        this.e = context;
        this.f = qVar;
        if (bp.a(context)) {
            this.a = new aq(p.c(context), b, "AppUpdateService", c, i.a);
        }
    }

    static /* synthetic */ Bundle d(o oVar, String str) {
        Integer num;
        Bundle bundle = new Bundle();
        bundle.putAll(j());
        bundle.putString("package.name", str);
        try {
            num = Integer.valueOf(oVar.e.getPackageManager().getPackageInfo(oVar.e.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            b.b("The current version of the app could not be retrieved", new Object[0]);
            num = null;
        }
        if (num != null) {
            bundle.putInt("app.version.code", num.intValue());
        }
        return bundle;
    }

    static /* synthetic */ AppUpdateInfo h(o oVar, Bundle bundle, String str) {
        Bundle bundle2 = bundle;
        return AppUpdateInfo.a(str, bundle2.getInt("version.code", -1), bundle2.getInt("update.availability"), bundle2.getInt("install.status", 0), bundle2.getInt("client.version.staleness", -1) == -1 ? null : Integer.valueOf(bundle2.getInt("client.version.staleness")), bundle2.getInt("in.app.update.priority", 0), bundle2.getLong("bytes.downloaded"), bundle2.getLong("total.bytes.to.download"), bundle2.getLong("additional.size.required"), oVar.f.a(), (PendingIntent) bundle2.getParcelable("blocking.intent"), (PendingIntent) bundle2.getParcelable("nonblocking.intent"), (PendingIntent) bundle2.getParcelable("blocking.destructive.intent"), (PendingIntent) bundle2.getParcelable("nonblocking.destructive.intent"));
    }

    private static <T> Task<T> i() {
        b.b("onError(%d)", -9);
        return Tasks.b(new InstallException(-9));
    }

    /* access modifiers changed from: private */
    public static Bundle j() {
        Bundle bundle = new Bundle();
        bundle.putAll(PlayCoreVersion.b("app_update"));
        bundle.putInt("playcore.version.code", 11000);
        return bundle;
    }

    public final Task<AppUpdateInfo> a(String str) {
        if (this.a == null) {
            return i();
        }
        b.d("requestUpdateInfo(%s)", str);
        i iVar = new i();
        this.a.a(new j(this, iVar, str, iVar));
        return iVar.c();
    }

    public final Task<Void> b(String str) {
        if (this.a == null) {
            return i();
        }
        b.d("completeUpdate(%s)", str);
        i iVar = new i();
        this.a.a(new k(this, iVar, iVar, str));
        return iVar.c();
    }
}
