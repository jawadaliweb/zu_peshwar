package com.google.android.recaptcha.internal;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzaz extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzba zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzn zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaz(zzba zzba, String str, zzn zzn, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzba;
        this.zzd = str;
        this.zze = zzn;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzaz(this.zzc, this.zzd, this.zze, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzaz) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zzb;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            zzn zzn = new zzn();
            zzmp zzg = zzmp.zzg(zzeb.zzh().zzj(this.zzd));
            obj2 = zzn;
            zzdk zzb2 = zzdk.zzb();
            zzmh zzc2 = zzba.zzy(zzg.zzi(), zzg.zzj());
            zzb2.zzf();
            long zza2 = zzb2.zza(TimeUnit.MICROSECONDS);
            zzj zzj = zzj.zza;
            zzj.zza(zzl.zzm.zza(), zza2);
            zzba zzba = this.zzc;
            List zzi = zzc2.zzi();
            zzn zzn2 = this.zze;
            this.zza = zzn;
            this.zzb = 1;
            if (zzba.zzt(zzi, zzn2, zzn, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            Object obj3 = this.zza;
            try {
                obj2 = obj3;
                ResultKt.throwOnFailure(obj);
                obj2 = obj3;
            } catch (Exception e) {
                zzba zzba2 = this.zzc;
                zzn zzn3 = this.zze;
                this.zza = null;
                this.zzb = 2;
                if (zzba2.zzu(e, "recaptcha.m.Main.rge", zzn3, (zzn) obj2, 0, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
