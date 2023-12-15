package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzau extends Lambda implements Function2 {
    final /* synthetic */ zzba zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzau(zzba zzba, String str, int i) {
        super(2);
        this.zza = zzba;
        this.zzb = str;
        this.zzc = i;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        Object[] objArr = (Object[]) obj;
        this.zza.zzv(this.zzb, (String) obj2);
        int i = this.zzc;
        if (i != -1) {
            this.zza.zzb().zzb().zzf(i, objArr);
        }
        return Unit.INSTANCE;
    }
}
