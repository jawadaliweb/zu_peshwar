package com.google.android.recaptcha.internal;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzax extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzba zzb;
    final /* synthetic */ List zzc;
    final /* synthetic */ zzn zzd;
    final /* synthetic */ zzn zze;
    private /* synthetic */ Object zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzax(zzba zzba, List list, zzn zzn, zzn zzn2, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzba;
        this.zzc = list;
        this.zzd = zzn;
        this.zze = zzn2;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        zzax zzax = new zzax(this.zzb, this.zzc, this.zzd, this.zze, continuation);
        zzax.zzf = obj;
        return zzax;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzax) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i == 0) {
            CoroutineScope coroutineScope = (CoroutineScope) this.zzf;
            zzbl zzbl = new zzbl(this.zzb.zzb());
            zzdk zzb2 = zzdk.zzb();
            while (zzbl.zzb() >= 0 && zzbl.zzb() < this.zzc.size() && CoroutineScopeKt.isActive(coroutineScope)) {
                zzmv zzmv = (zzmv) this.zzc.get(zzbl.zzb());
                try {
                    int zzk = zzmv.zzk();
                    int zzg = zzmv.zzg();
                    List zzj = zzmv.zzj();
                    if (!this.zzb.zzw(zzmv, zzbl)) {
                        zzdk zzb3 = zzdk.zzb();
                        int i2 = zzk - 2;
                        if (i2 == 7) {
                            zzba.zzo(this.zzb, zzg, zzj);
                        } else if (i2 == 15) {
                            zzba.zzi(this.zzb, zzj);
                        } else if (i2 == 30) {
                            zzba.zzh(this.zzb, zzg, zzj);
                        } else if (i2 != 40) {
                            switch (i2) {
                                case 10:
                                    zzba.zzm(this.zzb, zzg, zzj);
                                    break;
                                case 11:
                                    zzba.zzn(this.zzb, zzg, zzj);
                                    break;
                                case 12:
                                    zzba.zzp(this.zzb, zzj);
                                    break;
                                case 13:
                                    zzba.zzq(this.zzb, zzj);
                                    break;
                                default:
                                    switch (i2) {
                                        case 18:
                                            zzba.zzk(this.zzb, zzg, zzj);
                                            break;
                                        case 19:
                                            zzba.zzl(this.zzb, zzg, zzj);
                                            break;
                                        case 20:
                                            zzba.zzj(this.zzb, zzj);
                                            break;
                                        default:
                                            throw new zzt(5, 2, (Throwable) null);
                                    }
                            }
                        } else {
                            zzba.zzr(this.zzb, this.zzd, zzg, zzj);
                        }
                        zzb3.zzf();
                        long zza2 = zzb3.zza(TimeUnit.MICROSECONDS);
                        zzj zzj2 = zzj.zza;
                        zzj.zza(zzms.zza(zzk), zza2);
                        Boxing.boxLong(zza2);
                        Boxing.boxInt(zzg);
                        CollectionsKt.joinToString$default(zzj, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new zzaw(this.zzb), 31, (Object) null);
                        zzbl.zzg(zzbl.zzb() + 1);
                    }
                } catch (Exception e) {
                    zzba zzba = this.zzb;
                    String zzd2 = zzbl.zzd();
                    zzn zzn = this.zzd;
                    zzn zzn2 = this.zze;
                    int zzb4 = zzbl.zzb();
                    this.zza = 1;
                    if (zzba.zzu(e, zzd2, zzn, zzn2, zzb4, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            zzb2.zzf();
            Boxing.boxLong(zzb2.zza(TimeUnit.MICROSECONDS));
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
