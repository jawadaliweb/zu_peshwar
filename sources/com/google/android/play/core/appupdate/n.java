package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.tasks.i;

final class n extends l<AppUpdateInfo> {
    final /* synthetic */ o d;
    private final String e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    n(o oVar, i<AppUpdateInfo> iVar, String str) {
        super(oVar, new ag("OnRequestInstallCallback"), iVar);
        this.d = oVar;
        this.e = str;
    }

    public final void b(Bundle bundle) throws RemoteException {
        super.b(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.b.d(new InstallException(bundle.getInt("error.code", -2)));
        } else {
            this.b.e(o.h(this.d, bundle, this.e));
        }
    }
}
