package com.google.android.recaptcha.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadPoolDispatcherKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzp {
    public static final zzp zza = new zzp();
    private static final CoroutineScope zzb = CoroutineScopeKt.MainScope();
    private static final CoroutineScope zzc;
    private static final CoroutineScope zzd = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());

    static {
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(ThreadPoolDispatcherKt.newSingleThreadContext("reCaptcha"));
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new zzo((Continuation) null), 3, (Object) null);
        zzc = CoroutineScope;
    }

    private zzp() {
    }

    public static final CoroutineScope zza() {
        return zzd;
    }

    public static final CoroutineScope zzb() {
        return zzb;
    }

    public static final CoroutineScope zzc() {
        return zzc;
    }
}
