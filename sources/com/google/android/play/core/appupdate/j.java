package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.tasks.i;

final class j extends ah {
    final /* synthetic */ String a;
    final /* synthetic */ i b;
    final /* synthetic */ o c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    j(o oVar, i iVar, String str, i iVar2) {
        super(iVar);
        this.c = oVar;
        this.a = str;
        this.b = iVar2;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            this.c.a.c().c(this.c.d, o.d(this.c, this.a), new n(this.c, this.b, this.a));
        } catch (RemoteException e) {
            o.b.c(e, "requestUpdateInfo(%s)", this.a);
            this.b.d(new RuntimeException(e));
        }
    }
}
