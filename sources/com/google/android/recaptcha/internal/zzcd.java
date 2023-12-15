package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzcd implements zzby {
    public static final zzcd zza = new zzcd();

    private zzcd() {
    }

    public final void zza(int i, zzbl zzbl, Object... objArr) throws zzt {
        if (objArr.length >= 2) {
            Class<?> cls = objArr[0];
            if (true != (cls instanceof Object)) {
                cls = null;
            }
            if (cls != null) {
                Class<?> cls2 = cls instanceof Class ? cls : cls.getClass();
                String str = objArr[1];
                if (true != (str instanceof String)) {
                    str = null;
                }
                String str2 = str;
                if (str2 != null) {
                    String zza2 = zzbx.zza(this, str2, zzbl.zza());
                    if (!Intrinsics.areEqual((Object) zza2, (Object) "forName")) {
                        List<Object> drop = ArraysKt.drop((T[]) objArr, 2);
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(drop, 10));
                        for (Object zza3 : drop) {
                            arrayList.add(zzbk.zza(zza3));
                        }
                        Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
                        try {
                            zzbl.zzc().zzf(i, cls2.getMethod(zza2, (Class[]) Arrays.copyOf(clsArr, clsArr.length)));
                        } catch (Exception e) {
                            throw new zzt(6, 13, e);
                        }
                    } else {
                        throw new zzt(6, 48, (Throwable) null);
                    }
                } else {
                    throw new zzt(4, 5, (Throwable) null);
                }
            } else {
                throw new zzt(4, 5, (Throwable) null);
            }
        } else {
            throw new zzt(4, 3, (Throwable) null);
        }
    }
}
