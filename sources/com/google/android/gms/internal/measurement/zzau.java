package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
public final class zzau implements zzap {
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof zzau;
    }

    public final zzap zzbU(String str, zzg zzg, List list) {
        throw new IllegalStateException(String.format("Undefined has no function %s", new Object[]{str}));
    }

    public final zzap zzd() {
        return zzap.zzf;
    }

    public final Boolean zzg() {
        return false;
    }

    public final Double zzh() {
        return Double.valueOf(Double.NaN);
    }

    public final String zzi() {
        return "undefined";
    }

    public final Iterator zzl() {
        return null;
    }
}
