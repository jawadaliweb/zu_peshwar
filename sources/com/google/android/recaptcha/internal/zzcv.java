package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzcv extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzda zzb;
    int zzc;
    zzda zzd;
    String zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcv(zzda zzda, Continuation continuation) {
        super(continuation);
        this.zzb = zzda;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object zzf = this.zzb.zzf((RecaptchaAction) null, this);
        return zzf == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? zzf : Result.m57boximpl(zzf);
    }
}
