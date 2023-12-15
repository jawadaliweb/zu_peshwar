package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.tasks.i;
import java.util.List;

final class ah extends com.google.android.play.core.internal.ah {
    final /* synthetic */ List a;
    final /* synthetic */ i b;
    final /* synthetic */ au c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ah(au auVar, i iVar, List list, i iVar2) {
        super(iVar);
        this.c = auVar;
        this.a = list;
        this.b = iVar2;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            this.c.a.c().j(this.c.d, au.j(this.a), au.l(), new ao(this.c, this.b));
        } catch (RemoteException e) {
            au.b.c(e, "deferredLanguageUninstall(%s)", this.a);
            this.b.d(new RuntimeException(e));
        }
    }
}
