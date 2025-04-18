package com.google.android.recaptcha.internal;

import java.util.Comparator;
import kotlin.UByte;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzer implements Comparator {
    zzer() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzez zzez = (zzez) obj;
        zzez zzez2 = (zzez) obj2;
        zzeq zzeq = new zzeq(zzez);
        zzeq zzeq2 = new zzeq(zzez2);
        while (zzeq.hasNext() && zzeq2.hasNext()) {
            int compareTo = Integer.valueOf(zzeq.zza() & UByte.MAX_VALUE).compareTo(Integer.valueOf(zzeq2.zza() & UByte.MAX_VALUE));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzez.zzd()).compareTo(Integer.valueOf(zzez2.zzd()));
    }
}
