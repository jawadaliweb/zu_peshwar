package com.google.android.play.core.internal;

public final class cb<T> implements ce<T> {
    private ce<T> a;

    public static <T> void b(ce<T> ceVar, ce<T> ceVar2) {
        bh.j(ceVar2);
        cb cbVar = (cb) ceVar;
        if (cbVar.a == null) {
            cbVar.a = ceVar2;
            return;
        }
        throw new IllegalStateException();
    }

    public final T a() {
        ce<T> ceVar = this.a;
        if (ceVar != null) {
            return ceVar.a();
        }
        throw new IllegalStateException();
    }
}
