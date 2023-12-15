package com.google.android.play.core.internal;

import java.io.File;
import java.util.List;

final class bd implements bc {
    private final /* synthetic */ int a = 0;

    bd() {
    }

    bd(byte[] bArr) {
    }

    public final Object[] a(Object obj, List list, List list2) {
        Object a2;
        if (this.a != 0) {
            a2 = bh.b(obj, "makePathElements", Object[].class, List.class, list, File.class, null, List.class, list2);
        } else {
            a2 = bh.a(obj, "makePathElements", Object[].class, List.class, list);
        }
        return (Object[]) a2;
    }
}
