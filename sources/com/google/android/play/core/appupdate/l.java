package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.p;
import com.google.android.play.core.tasks.i;

class l<T> extends p {
    final ag a;
    final i<T> b;
    final /* synthetic */ o c;

    l(o oVar, ag agVar, i<T> iVar) {
        this.c = oVar;
        this.a = agVar;
        this.b = iVar;
    }

    public void b(Bundle bundle) throws RemoteException {
        this.c.a.b();
        this.a.d("onRequestInfo", new Object[0]);
    }

    public void c(Bundle bundle) throws RemoteException {
        this.c.a.b();
        this.a.d("onCompleteUpdate", new Object[0]);
    }
}
