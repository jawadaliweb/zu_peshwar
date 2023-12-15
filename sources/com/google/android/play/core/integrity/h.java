package com.google.android.play.core.integrity;

import android.content.Context;
import java.util.Objects;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
final class h implements k {
    private Context a;

    private h() {
    }

    /* synthetic */ h(g gVar) {
    }

    public final h a(Context context) {
        Objects.requireNonNull(context);
        this.a = context;
        return this;
    }

    public final j b() {
        Context context = this.a;
        if (context != null) {
            return new j(context, (i) null);
        }
        throw new IllegalStateException(String.valueOf(Context.class.getCanonicalName()).concat(" must be set"));
    }
}
