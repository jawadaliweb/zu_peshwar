package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzz extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzaa zzb;
    final /* synthetic */ RecaptchaAction zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzz(zzaa zzaa, RecaptchaAction recaptchaAction, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzaa;
        this.zzc = recaptchaAction;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzz(this.zzb, this.zzc, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzz) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i != 0) {
            obj2 = ((Result) obj).m67unboximpl();
        } else {
            zzda zzb2 = this.zzb.zzb();
            RecaptchaAction recaptchaAction = this.zzc;
            this.zza = 1;
            obj2 = zzb2.zzf(recaptchaAction, this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        ResultKt.throwOnFailure(obj2);
        return obj2;
    }
}
