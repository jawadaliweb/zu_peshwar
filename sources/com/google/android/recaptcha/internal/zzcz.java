package com.google.android.recaptcha.internal;

import android.os.Build;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzcz extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzda zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcz(zzda zzda, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzda;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzcz(this.zzb, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzcz) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i == 0) {
            zzu zzu = zzu.zza;
            String zza2 = zzu.zza(this.zzb.zze);
            String zzj = this.zzb.zzd;
            String packageName = this.zzb.zze.getPackageName();
            String zzi = this.zzb.zzh;
            int i2 = Build.VERSION.SDK_INT;
            String encode = URLEncoder.encode(zzj, "UTF-8");
            String encode2 = URLEncoder.encode(packageName, "UTF-8");
            String encode3 = URLEncoder.encode(zza2, "UTF-8");
            String encode4 = URLEncoder.encode("18.1.2", "UTF-8");
            String encode5 = URLEncoder.encode(zzi, "UTF-8");
            byte[] bytes = ("k=" + encode + "&pk=" + encode2 + "&mst=" + encode3 + "&msv=" + encode4 + "&msi=" + encode5 + "&mov=" + i2).getBytes(Charset.forName("UTF-8"));
            zzai zzai = zzai.zza;
            zzai.zzc(new zzaf(zzkw.INIT_NATIVE, this.zzb.zzg, this.zzb.zzh, this.zzb.zzh, (String) null), this.zzb.zze, this.zzb.zzf);
            zzai.zzb(new zzaf(zzkw.INIT_NETWORK, this.zzb.zzg, this.zzb.zzh, this.zzb.zzh, (String) null), this.zzb.zzd, new zzs());
            zzp zzp = zzp.zza;
            Job unused = BuildersKt__Builders_commonKt.launch$default(zzp.zza(), (CoroutineContext) null, (CoroutineStart) null, new zzcy(this.zzb, zza2, (Continuation) null), 3, (Object) null);
            this.zzb.zzn.zzd();
            this.zzb.zzn.zze();
            zzda zzda = this.zzb;
            zzda.zzb().postUrl(zzda.zzf.zza(), bytes);
            Boxing.boxInt(this.zzb.zzm().hashCode());
            CompletableDeferred zzm = this.zzb.zzm();
            this.zza = 1;
            if (zzm.await(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Result.m57boximpl(Result.m58constructorimpl(Unit.INSTANCE));
    }
}
