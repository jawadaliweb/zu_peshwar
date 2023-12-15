package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzay extends SuspendLambda implements Function2 {
    final /* synthetic */ Exception zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzn zzc;
    final /* synthetic */ zzn zzd;
    final /* synthetic */ String zze;
    final /* synthetic */ zzba zzf;
    private /* synthetic */ Object zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzay(Exception exc, int i, zzn zzn, zzn zzn2, String str, zzba zzba, Continuation continuation) {
        super(2, continuation);
        this.zza = exc;
        this.zzb = i;
        this.zzc = zzn;
        this.zzd = zzn2;
        this.zze = str;
        this.zzf = zzba;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        zzay zzay = new zzay(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, continuation);
        zzay.zzg = obj;
        return zzay;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzay) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        zzmi zzmi;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.zzg;
        Exception exc = this.zza;
        if (exc instanceof zzt) {
            zzmi = ((zzt) exc).zza();
            zzmi.zzd(this.zzb);
        } else {
            zzmi = zzmj.zzf();
            zzmi.zzd(this.zzb);
            zzmi.zzp(2);
            zzmi.zze(2);
        }
        zzmj zzmj = (zzmj) zzmi.zzj();
        zzmj.zzk();
        zzmj.zzj();
        Reflection.getOrCreateKotlinClass(this.zza.getClass()).getSimpleName();
        this.zza.getMessage();
        zzlg zza2 = zzar.zza(this.zzc, this.zzd);
        String str = this.zze;
        if (str.length() == 0) {
            str = "recaptcha.m.Main.rge";
        }
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            zzba zzba = this.zzf;
            zzeb zzh = zzeb.zzh();
            byte[] zzd2 = zzmj.zzd();
            zzeb zzh2 = zzeb.zzh();
            byte[] zzd3 = zza2.zzd();
            zzba.zzv(str, zzh.zzi(zzd2, 0, zzd2.length), zzh2.zzi(zzd3, 0, zzd3.length));
        }
        return Unit.INSTANCE;
    }
}
