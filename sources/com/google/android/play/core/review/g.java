package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.ad;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.tasks.i;

class g<T> extends ad {
    final ag a;
    final i<T> b;
    final /* synthetic */ i c;

    g(i iVar, ag agVar, i<T> iVar2) {
        this.c = iVar;
        this.a = agVar;
        this.b = iVar2;
    }

    public void b(Bundle bundle) throws RemoteException {
        this.c.a.b();
        this.a.d("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}
