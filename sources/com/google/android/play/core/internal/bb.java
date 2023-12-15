package com.google.android.play.core.internal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

final class bb implements az {
    private final /* synthetic */ int a = 0;

    bb() {
    }

    bb(byte[] bArr) {
    }

    public final Object[] a(Object obj, ArrayList arrayList, File file, ArrayList arrayList2) {
        Object b;
        if (this.a != 0) {
            b = bh.b(obj, "makeDexElements", Object[].class, ArrayList.class, arrayList, File.class, file, ArrayList.class, arrayList2);
        } else {
            b = bh.b(obj, "makePathElements", Object[].class, List.class, arrayList, File.class, file, List.class, arrayList2);
        }
        return (Object[]) b;
    }
}
