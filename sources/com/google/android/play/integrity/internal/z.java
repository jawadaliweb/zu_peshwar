package com.google.android.play.integrity.internal;

import java.util.Objects;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
public final class z implements ac {
    private static final Object a = new Object();
    private volatile ac b;
    private volatile Object c = a;

    private z(ac acVar) {
        this.b = acVar;
    }

    public final Object a() {
        Object obj = this.c;
        Object obj2 = a;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.c;
                if (obj == obj2) {
                    obj = this.b.a();
                    Object obj3 = this.c;
                    if (obj3 != obj2) {
                        if (obj3 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                    }
                    this.c = obj;
                    this.b = null;
                }
            }
        }
        return obj;
    }

    public static ac b(ac acVar) {
        Objects.requireNonNull(acVar);
        if (acVar instanceof z) {
            return acVar;
        }
        return new z(acVar);
    }
}
