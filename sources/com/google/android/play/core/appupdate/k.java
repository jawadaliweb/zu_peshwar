package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.tasks.i;

final class k extends ah {
    final /* synthetic */ i a;
    final /* synthetic */ String b;
    final /* synthetic */ o c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    k(o oVar, i iVar, i iVar2, String str) {
        super(iVar);
        this.c = oVar;
        this.a = iVar2;
        this.b = str;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            this.c.a.c().d(this.c.d, o.j(), new m(this.c, this.a));
        } catch (RemoteException e) {
            o.b.c(e, "completeUpdate(%s)", this.b);
            this.a.d(new RuntimeException(e));
        }
    }
}
