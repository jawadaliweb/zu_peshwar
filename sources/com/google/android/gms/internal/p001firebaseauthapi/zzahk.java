package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzahk {
    zzahk() {
    }

    public static final int zza(int i, Object obj, Object obj2) {
        zzahj zzahj = (zzahj) obj;
        zzahi zzahi = (zzahi) obj2;
        if (zzahj.isEmpty()) {
            return 0;
        }
        Iterator it = zzahj.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final boolean zzb(Object obj) {
        return !((zzahj) obj).zze();
    }

    public static final Object zzc(Object obj, Object obj2) {
        zzahj zzahj = (zzahj) obj;
        zzahj zzahj2 = (zzahj) obj2;
        if (!zzahj2.isEmpty()) {
            if (!zzahj.zze()) {
                zzahj = zzahj.zzb();
            }
            zzahj.zzd(zzahj2);
        }
        return zzahj;
    }
}
