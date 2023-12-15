package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.aa;
import com.google.android.play.integrity.internal.ab;
import com.google.android.play.integrity.internal.ac;
import com.google.android.play.integrity.internal.z;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
final class j {
    private final j a = this;
    private final ac b;
    private final ac c;
    private final ac d;
    private final ac e;

    /* synthetic */ j(Context context, i iVar) {
        aa b2 = ab.b(context);
        this.b = b2;
        ac b3 = z.b(o.a);
        this.c = b3;
        ac b4 = z.b(new v(b2, b3));
        this.d = b4;
        this.e = z.b(new n(b4));
    }

    public final IntegrityManager a() {
        return (IntegrityManager) this.e.a();
    }
}
