package com.google.android.recaptcha.internal;

import android.content.ContentValues;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzan extends SuspendLambda implements Function2 {
    final /* synthetic */ zzkx zza;
    final /* synthetic */ zzao zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzan(zzkx zzkx, zzao zzao, Continuation continuation) {
        super(2, continuation);
        this.zza = zzkx;
        this.zzb = zzao;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzan(this.zza, this.zzb, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzan) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zzkx zzkx = this.zza;
        zzao zzao = this.zzb;
        synchronized (zzaj.class) {
            byte[] zzd = zzkx.zzd();
            zzae zzae = new zzae(zzeb.zzg().zzi(zzd, 0, zzd.length), System.currentTimeMillis(), 0);
            zzad zza2 = zzao.zze;
            ContentValues contentValues = new ContentValues();
            contentValues.put("ss", zzae.zzc());
            contentValues.put("ts", Long.valueOf(zzae.zzb()));
            zza2.getWritableDatabase().insert("ce", (String) null, contentValues);
            int zzb2 = zzao.zze.zzb() - 500;
            if (zzb2 > 0) {
                zzao.zze.zza(CollectionsKt.take(zzao.zze.zzd(), zzb2));
            }
            if (zzao.zze.zzb() >= 20) {
                zzao.zzg();
            }
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
