package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Comparator;
import kotlin.UByte;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaex  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaex implements Comparator {
    zzaex() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzaff zzaff = (zzaff) obj;
        zzaff zzaff2 = (zzaff) obj2;
        zzaew zzaew = new zzaew(zzaff);
        zzaew zzaew2 = new zzaew(zzaff2);
        while (zzaew.hasNext() && zzaew2.hasNext()) {
            int compareTo = Integer.valueOf(zzaew.zza() & UByte.MAX_VALUE).compareTo(Integer.valueOf(zzaew2.zza() & UByte.MAX_VALUE));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzaff.zzd()).compareTo(Integer.valueOf(zzaff2.zzd()));
    }
}
