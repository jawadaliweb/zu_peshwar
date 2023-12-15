package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.aa;
import com.google.android.play.integrity.internal.ac;
import com.google.android.play.integrity.internal.k;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
public final class v implements aa {
    private final ac a;
    private final ac b;

    public v(ac acVar, ac acVar2) {
        this.a = acVar;
        this.b = acVar2;
    }

    public final /* bridge */ /* synthetic */ Object a() {
        return new t((Context) this.a.a(), (k) this.b.a());
    }
}
