package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class aa extends ah {
    final /* synthetic */ List a;
    final /* synthetic */ Map b;
    final /* synthetic */ i c;
    final /* synthetic */ as d;
    final /* synthetic */ an e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aa(an anVar, i iVar, List list, Map map, i iVar2, as asVar) {
        super(iVar);
        this.e = anVar;
        this.a = list;
        this.b = map;
        this.c = iVar2;
        this.d = asVar;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        ArrayList k = an.k(this.a);
        try {
            String l = this.e.c;
            Bundle m = an.m(this.b);
            an anVar = this.e;
            ((t) this.e.e.c()).k(l, k, m, new al(anVar, this.c, anVar.d, this.d));
        } catch (RemoteException e2) {
            an.a.c(e2, "getPackStates(%s)", this.a);
            this.c.d(new RuntimeException(e2));
        }
    }
}
