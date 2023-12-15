package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.d;
import java.util.List;

final class h implements d {
    final /* synthetic */ List a;
    final /* synthetic */ List b;
    final /* synthetic */ long c;
    final /* synthetic */ boolean d;
    final /* synthetic */ List e;
    final /* synthetic */ FakeSplitInstallManager f;

    h(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2, long j, boolean z, List list3) {
        this.f = fakeSplitInstallManager;
        this.a = list;
        this.b = list2;
        this.c = j;
        this.d = z;
        this.e = list3;
    }

    public final void a() {
        this.f.v(this.a, this.b, this.c);
    }

    public final void b() {
        if (!this.d) {
            this.f.u(this.e, this.a, this.b, this.c, true);
        }
    }

    public final void c(int i) {
        this.f.w(i);
    }
}
