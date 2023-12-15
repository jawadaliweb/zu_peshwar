package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.i;

final class w extends ah {
    final /* synthetic */ String a;
    final /* synthetic */ i b;
    final /* synthetic */ an c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    w(an anVar, i iVar, String str, i iVar2) {
        super(iVar);
        this.c = anVar;
        this.a = str;
        this.b = iVar2;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            ((t) this.c.e.c()).l(this.c.c, an.A(0, this.a), an.C(), new ag(this.c, this.b, (short[]) null));
        } catch (RemoteException e) {
            an.a.c(e, "removePack(%s)", this.a);
        }
    }
}
