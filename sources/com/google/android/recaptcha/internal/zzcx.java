package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzcx extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzda zzb;
    int zzc;
    zzda zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcx(zzda zzda, Continuation continuation) {
        super(continuation);
        this.zzb = zzda;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object zzg = this.zzb.zzg(this);
        return zzg == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? zzg : Result.m57boximpl(zzg);
    }
}
