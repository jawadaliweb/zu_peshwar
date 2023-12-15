package com.google.android.recaptcha.internal;

import android.app.Application;
import android.webkit.WebView;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzv extends ContinuationImpl {
    Object zza;
    Object zzb;
    Object zzc;
    Object zzd;
    /* synthetic */ Object zze;
    final /* synthetic */ zzw zzf;
    int zzg;
    zzw zzh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzv(zzw zzw, Continuation continuation) {
        super(continuation);
        this.zzf = zzw;
    }

    public final Object invokeSuspend(Object obj) {
        this.zze = obj;
        this.zzg |= Integer.MIN_VALUE;
        return this.zzf.zza((Application) null, (String) null, (zzr) null, (WebView) null, this);
    }
}
