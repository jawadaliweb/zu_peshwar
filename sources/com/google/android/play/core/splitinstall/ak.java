package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.tasks.i;

final class ak extends ah {
    final /* synthetic */ int a;
    final /* synthetic */ i b;
    final /* synthetic */ au c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ak(au auVar, i iVar, int i, i iVar2) {
        super(iVar);
        this.c = auVar;
        this.a = i;
        this.b = iVar2;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            this.c.a.c().d(this.c.d, this.a, au.l(), new al(this.c, this.b));
        } catch (RemoteException e) {
            au.b.c(e, "cancelInstall(%d)", Integer.valueOf(this.a));
            this.b.d(new RuntimeException(e));
        }
    }
}
