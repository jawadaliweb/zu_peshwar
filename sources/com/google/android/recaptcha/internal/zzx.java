package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzx extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzaa zzb;
    int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzx(zzaa zzaa, Continuation continuation) {
        super(continuation);
        this.zzb = zzaa;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object r2 = this.zzb.m3executegIAlus((RecaptchaAction) null, this);
        return r2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r2 : Result.m57boximpl(r2);
    }
}
