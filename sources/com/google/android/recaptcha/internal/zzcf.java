package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.collections.ArraysKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzcf implements zzby {
    public static final zzcf zza = new zzcf();

    private zzcf() {
    }

    public final void zza(int i, zzbl zzbl, Object... objArr) throws zzt {
        int length = objArr.length;
        if (length != 0) {
            Method method = objArr[0];
            if (true != (method instanceof Method)) {
                method = null;
            }
            Method method2 = method;
            if (method2 != null) {
                Object[] array = ArraysKt.toList((T[]) objArr).subList(1, length).toArray(new Object[0]);
                try {
                    zzbl.zzc().zzf(i, method2.invoke((Object) null, Arrays.copyOf(array, array.length)));
                } catch (Exception e) {
                    throw new zzt(6, 15, e);
                }
            } else {
                throw new zzt(4, 5, (Throwable) null);
            }
        } else {
            throw new zzt(4, 3, (Throwable) null);
        }
    }
}
