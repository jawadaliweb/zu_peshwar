package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.i;

final class ad extends ah {
    final /* synthetic */ int a;
    final /* synthetic */ i b;
    final /* synthetic */ an c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ad(an anVar, i iVar, int i, i iVar2) {
        super(iVar);
        this.c = anVar;
        this.a = i;
        this.b = iVar2;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            ((t) this.c.e.c()).h(this.c.c, an.B(this.a), an.C(), new ag(this.c, this.b, (int[]) null));
        } catch (RemoteException e) {
            an.a.c(e, "notifySessionFailed", new Object[0]);
        }
    }
}
