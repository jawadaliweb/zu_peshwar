package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzbg extends zzbd {
    private final zzbf zza;
    private final String zzb;

    public zzbg(zzbf zzbf, String str, Object obj) {
        super(obj);
        this.zza = zzbf;
        this.zzb = str;
    }

    public final boolean zza(Object obj, Method method, Object[] objArr) {
        List list;
        if (!Intrinsics.areEqual((Object) method.getName(), (Object) this.zzb)) {
            return false;
        }
        zzbf zzbf = this.zza;
        if (objArr == null || (list = ArraysKt.asList((T[]) objArr)) == null) {
            list = CollectionsKt.emptyList();
        }
        zzbf.zzb(list);
        return true;
    }
}
