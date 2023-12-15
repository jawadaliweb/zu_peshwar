package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.tasks.i;

final class ai extends ah {
    final /* synthetic */ int a;
    final /* synthetic */ i b;
    final /* synthetic */ au c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ai(au auVar, i iVar, int i, i iVar2) {
        super(iVar);
        this.c = auVar;
        this.a = i;
        this.b = iVar2;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            this.c.a.c().e(this.c.d, this.a, new aq(this.c, this.b));
        } catch (RemoteException e) {
            au.b.c(e, "getSessionState(%d)", Integer.valueOf(this.a));
            this.b.d(new RuntimeException(e));
        }
    }
}
