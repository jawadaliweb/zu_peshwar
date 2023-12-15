package com.google.android.play.core.review;

import android.os.RemoteException;
import com.google.android.play.core.common.PlayCoreVersion;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.tasks.i;

final class f extends ah {
    final /* synthetic */ i a;
    final /* synthetic */ i b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    f(i iVar, i iVar2, i iVar3) {
        super(iVar2);
        this.b = iVar;
        this.a = iVar3;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            this.b.a.c().c(this.b.c, PlayCoreVersion.b("review"), new h(this.b, this.a));
        } catch (RemoteException e) {
            i.b.c(e, "error requesting in-app review for %s", this.b.c);
            this.a.d(new RuntimeException(e));
        }
    }
}
