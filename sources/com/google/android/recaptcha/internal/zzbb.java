package com.google.android.recaptcha.internal;

import android.webkit.ValueCallback;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzbb extends SuspendLambda implements Function2 {
    final /* synthetic */ String[] zza;
    final /* synthetic */ zzbc zzb;
    final /* synthetic */ String zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbb(String[] strArr, zzbc zzbc, String str, Continuation continuation) {
        super(2, continuation);
        this.zza = strArr;
        this.zzb = zzbc;
        this.zzc = str;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzbb(this.zza, this.zzb, this.zzc, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzbb) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        ArrayList arrayList = new ArrayList(r1);
        for (String str : this.zza) {
            arrayList.add("\"" + str + "\"");
        }
        this.zzb.zza.evaluateJavascript(this.zzc + "(" + CollectionsKt.joinToString$default(arrayList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + ")", (ValueCallback) null);
        return Unit.INSTANCE;
    }
}
