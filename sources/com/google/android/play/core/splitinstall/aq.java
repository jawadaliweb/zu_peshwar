package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.i;

final class aq extends at<SplitInstallSessionState> {
    aq(au auVar, i<SplitInstallSessionState> iVar) {
        super(auVar, iVar);
    }

    public final void g(int i, Bundle bundle) throws RemoteException {
        super.g(i, bundle);
        this.a.e(SplitInstallSessionState.d(bundle));
    }
}
