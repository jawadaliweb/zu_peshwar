package com.google.android.play.core.internal;

public final class cc<T> implements ce, ca {
    private static final Object a = new Object();
    private volatile ce<T> b;
    private volatile Object c = a;

    private cc(ce<T> ceVar) {
        this.b = ceVar;
    }

    public static <P extends ce<T>, T> ce<T> b(P p) {
        bh.j(p);
        return p instanceof cc ? p : new cc(p);
    }

    public static <P extends ce<T>, T> ca<T> c(P p) {
        if (p instanceof ca) {
            return (ca) p;
        }
        bh.j(p);
        return new cc(p);
    }

    public final T a() {
        T t = this.c;
        T t2 = a;
        if (t == t2) {
            synchronized (this) {
                t = this.c;
                if (t == t2) {
                    t = this.b.a();
                    T t3 = this.c;
                    if (t3 != t2 && !(t3 instanceof cd)) {
                        if (t3 != t) {
                            String valueOf = String.valueOf(t3);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.c = t;
                    this.b = null;
                }
            }
        }
        return t;
    }
}
