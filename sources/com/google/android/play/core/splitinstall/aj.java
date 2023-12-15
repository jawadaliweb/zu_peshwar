package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.tasks.i;

final class aj extends ah {
    final /* synthetic */ i a;
    final /* synthetic */ au b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aj(au auVar, i iVar, i iVar2) {
        super(iVar);
        this.b = auVar;
        this.a = iVar2;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            this.b.a.c().f(this.b.d, new ar(this.b, this.a));
        } catch (RemoteException e) {
            au.b.c(e, "getSessionStates", new Object[0]);
            this.a.d(new RuntimeException(e));
        }
    }
}
