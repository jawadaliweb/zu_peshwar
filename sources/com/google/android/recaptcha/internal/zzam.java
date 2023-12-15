package com.google.android.recaptcha.internal;

import java.util.Timer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzam extends SuspendLambda implements Function2 {
    final /* synthetic */ zzao zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzam(zzao zzao, Continuation continuation) {
        super(2, continuation);
        this.zza = zzao;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzam(this.zza, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzam) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zzao zzao = this.zza;
        synchronized (zzaj.class) {
            if (zzao.zze.zzb() == 0) {
                Timer zzb = zzao.zzb;
                if (zzb != null) {
                    zzb.cancel();
                }
                zzao.zzb = null;
            }
            zzao.zzg();
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
