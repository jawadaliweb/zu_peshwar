package com.google.android.recaptcha.internal;

import java.util.Collection;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.Charsets;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzbt implements zzby {
    public static final zzbt zza = new zzbt();

    private zzbt() {
    }

    public final void zza(int i, zzbl zzbl, Object... objArr) throws zzt {
        String str;
        String str2;
        Object[] objArr2 = objArr;
        if (objArr2.length == 1) {
            Object obj = objArr2[0];
            if (true != (obj instanceof Object)) {
                obj = null;
            }
            if (obj != null) {
                if (obj instanceof int[]) {
                    str = ArraysKt.joinToString$default((int[]) obj, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                } else {
                    if (obj instanceof byte[]) {
                        str2 = new String((byte[]) obj, Charsets.UTF_8);
                    } else if (obj instanceof long[]) {
                        str = ArraysKt.joinToString$default((long[]) obj, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (obj instanceof short[]) {
                        str = ArraysKt.joinToString$default((short[]) obj, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (obj instanceof float[]) {
                        str = ArraysKt.joinToString$default((float[]) obj, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (obj instanceof double[]) {
                        str = ArraysKt.joinToString$default((double[]) obj, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (obj instanceof char[]) {
                        str2 = new String((char[]) obj);
                    } else if (obj instanceof Object[]) {
                        str = ArraysKt.joinToString$default((Object[]) obj, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (obj instanceof Collection) {
                        str = CollectionsKt.joinToString$default((Iterable) obj, ",", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else {
                        throw new zzt(4, 5, (Throwable) null);
                    }
                    str = str2;
                }
                int i2 = i;
                zzbl.zzc().zzf(i, str);
                return;
            }
            throw new zzt(4, 5, (Throwable) null);
        }
        throw new zzt(4, 3, (Throwable) null);
    }
}
