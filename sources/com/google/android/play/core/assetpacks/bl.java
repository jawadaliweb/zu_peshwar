package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.ca;
import java.util.concurrent.atomic.AtomicBoolean;

final class bl {
    private static final ag a = new ag("ExtractorLooper");
    private final ca b;
    private final bj c;
    private final dd d;
    private final co e;
    private final ct f;
    private final cx g;
    private final ca<t> h;
    private final cd i;
    private final AtomicBoolean j = new AtomicBoolean(false);

    bl(ca caVar, ca<t> caVar2, bj bjVar, dd ddVar, co coVar, ct ctVar, cx cxVar, cd cdVar) {
        this.b = caVar;
        this.h = caVar2;
        this.c = bjVar;
        this.d = ddVar;
        this.e = coVar;
        this.f = ctVar;
        this.g = cxVar;
        this.i = cdVar;
    }

    private final void b(int i2, Exception exc) {
        try {
            this.b.p(i2);
            this.b.g(i2);
        } catch (bk unused) {
            a.b("Error during error handling: %s", exc.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ag agVar = a;
        agVar.a("Run extractor loop", new Object[0]);
        if (this.j.compareAndSet(false, true)) {
            while (true) {
                cc ccVar = null;
                try {
                    ccVar = this.i.a();
                } catch (bk e2) {
                    a.b("Error while getting next extraction task: %s", e2.getMessage());
                    if (e2.a >= 0) {
                        this.h.a().g(e2.a);
                        b(e2.a, e2);
                    }
                }
                if (ccVar != null) {
                    try {
                        if (ccVar instanceof bi) {
                            this.c.a((bi) ccVar);
                        } else if (ccVar instanceof dc) {
                            this.d.a((dc) ccVar);
                        } else if (ccVar instanceof cn) {
                            this.e.a((cn) ccVar);
                        } else if (ccVar instanceof cq) {
                            this.f.a((cq) ccVar);
                        } else if (ccVar instanceof cw) {
                            this.g.a((cw) ccVar);
                        } else {
                            a.b("Unknown task type: %s", ccVar.getClass().getName());
                        }
                    } catch (Exception e3) {
                        a.b("Error during extraction task: %s", e3.getMessage());
                        this.h.a().g(ccVar.j);
                        b(ccVar.j, e3);
                    }
                } else {
                    this.j.set(false);
                    return;
                }
            }
        } else {
            agVar.e("runLoop already looping; return", new Object[0]);
        }
    }
}
