package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Iterator;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzay  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzay {
    static int zza(Set set) {
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i += next != null ? next.hashCode() : 0;
        }
        return i;
    }
}
