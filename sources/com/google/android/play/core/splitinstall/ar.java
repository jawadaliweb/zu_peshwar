package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.List;

final class ar extends at<List<SplitInstallSessionState>> {
    ar(au auVar, i<List<SplitInstallSessionState>> iVar) {
        super(auVar, iVar);
    }

    public final void h(List<Bundle> list) throws RemoteException {
        super.h(list);
        ArrayList arrayList = new ArrayList(list.size());
        for (Bundle d : list) {
            arrayList.add(SplitInstallSessionState.d(d));
        }
        this.a.e(arrayList);
    }
}
