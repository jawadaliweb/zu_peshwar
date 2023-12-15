package com.google.android.recaptcha.internal;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.android.recaptcha.RecaptchaAction;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzcw extends SuspendLambda implements Function2 {
    Object zza;
    Object zzb;
    Object zzc;
    int zzd;
    final /* synthetic */ RecaptchaAction zze;
    final /* synthetic */ zzda zzf;
    final /* synthetic */ String zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcw(RecaptchaAction recaptchaAction, zzda zzda, String str, Continuation continuation) {
        super(2, continuation);
        this.zze = recaptchaAction;
        this.zzf = zzda;
        this.zzg = str;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzcw(this.zze, this.zzf, this.zzg, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzcw) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zzd;
        ResultKt.throwOnFailure(obj);
        if (i == 0) {
            zzda zzda = this.zzf;
            String str = this.zzg;
            RecaptchaAction recaptchaAction = this.zze;
            this.zza = zzda;
            this.zzb = str;
            this.zzc = recaptchaAction;
            this.zzd = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.initCancellability();
            zzda.zzk.put(str, cancellableContinuationImpl);
            zzma zzf2 = zzmb.zzf();
            zzf2.zze(str);
            zzf2.zzd(recaptchaAction.getAction());
            byte[] zzd2 = ((zzmb) zzf2.zzj()).zzd();
            String zzi = zzeb.zzh().zzi(zzd2, 0, zzd2.length);
            zzai zzai = zzai.zza;
            zzai.zzc(new zzaf(zzkw.EXECUTE_NATIVE, zzda.zzg, zzda.zzh, str, (String) null), zzda.zze, zzda.zzf);
            WebView zzb2 = zzda.zzb();
            zzb2.evaluateJavascript("recaptcha.m.Main.execute(\"" + zzi + "\")", (ValueCallback) null);
            obj = cancellableContinuationImpl.getResult();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
