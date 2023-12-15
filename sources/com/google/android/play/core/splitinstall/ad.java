package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.Collection;

final class ad extends ah {
    final /* synthetic */ Collection a;
    final /* synthetic */ Collection b;
    final /* synthetic */ i c;
    final /* synthetic */ au d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ad(au auVar, i iVar, Collection collection, Collection collection2, i iVar2) {
        super(iVar);
        this.d = auVar;
        this.a = collection;
        this.b = collection2;
        this.c = iVar2;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        ArrayList i = au.i(this.a);
        i.addAll(au.j(this.b));
        try {
            this.d.a.c().c(this.d.d, i, au.l(), new as(this.d, this.c));
        } catch (RemoteException e) {
            au.b.c(e, "startInstall(%s,%s)", this.a, this.b);
            this.c.d(new RuntimeException(e));
        }
    }
}
