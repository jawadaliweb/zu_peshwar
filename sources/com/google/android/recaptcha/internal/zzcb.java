package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Arrays;
import kotlin.collections.CollectionsKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzcb implements zzby {
    public static final zzcb zza = new zzcb();

    private zzcb() {
    }

    public final void zza(int i, zzbl zzbl, Object... objArr) throws zzt {
        int length = objArr.length;
        if (length != 0) {
            Class cls = objArr[0];
            if (true != (cls instanceof Class)) {
                cls = null;
            }
            Class cls2 = cls;
            if (cls2 != null) {
                ArrayList<Object> arrayList = new ArrayList<>();
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    Object obj = objArr[i2];
                    int i4 = i3 + 1;
                    if (i3 > 0) {
                        arrayList.add(obj);
                    }
                    i2++;
                    i3 = i4;
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                for (Object zza2 : arrayList) {
                    arrayList2.add(zzbk.zza(zza2));
                }
                Class[] clsArr = (Class[]) arrayList2.toArray(new Class[0]);
                try {
                    zzbl.zzc().zzf(i, cls2.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length)));
                } catch (Exception e) {
                    throw new zzt(6, 9, e);
                }
            } else {
                throw new zzt(4, 5, (Throwable) null);
            }
        } else {
            throw new zzt(4, 3, (Throwable) null);
        }
    }
}
