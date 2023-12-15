package com.google.android.recaptcha;

import android.app.Application;
import android.webkit.WebView;
import com.google.android.recaptcha.internal.zzaa;
import com.google.android.recaptcha.internal.zzr;
import com.google.android.recaptcha.internal.zzw;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class Recaptcha$getClient$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super zzaa>, Object> {
    int zza;
    final /* synthetic */ Application zzb;
    final /* synthetic */ String zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recaptcha$getClient$2$1(Application application, String str, Continuation continuation) {
        super(2, continuation);
        this.zzb = application;
        this.zzc = str;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new Recaptcha$getClient$2$1(this.zzb, this.zzc, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((Recaptcha$getClient$2$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i == 0) {
            zzw zzw = zzaa.zza;
            Application application = this.zzb;
            String str = this.zzc;
            this.zza = 1;
            obj = zzw.zza(application, str, new zzr((String) null, 0, 0, 7, (DefaultConstructorMarker) null), (WebView) null, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
