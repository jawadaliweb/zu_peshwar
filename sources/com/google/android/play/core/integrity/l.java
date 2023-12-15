package com.google.android.play.core.integrity;

import android.content.Context;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
final class l {
    private static j a;

    static synchronized j a(Context context) {
        j jVar;
        synchronized (l.class) {
            if (a == null) {
                h hVar = new h((g) null);
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                hVar.a(context);
                a = hVar.b();
            }
            jVar = a;
        }
        return jVar;
    }
}
