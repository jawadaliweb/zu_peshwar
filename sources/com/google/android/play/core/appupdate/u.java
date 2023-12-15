package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.splitcompat.p;

public final /* synthetic */ class u {
    private static w a;

    static synchronized w a(Context context) {
        w wVar;
        synchronized (u.class) {
            if (a == null) {
                v vVar = new v((byte[]) null);
                vVar.b(new f(p.c(context)));
                a = vVar.a();
            }
            wVar = a;
        }
        return wVar;
    }
}
