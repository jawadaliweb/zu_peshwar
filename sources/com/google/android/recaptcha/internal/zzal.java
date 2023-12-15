package com.google.android.recaptcha.internal;

import java.util.TimerTask;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzal extends TimerTask {
    final /* synthetic */ zzao zza;

    public zzal(zzao zzao) {
        this.zza = zzao;
    }

    public final void run() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.zza.zzd, (CoroutineContext) null, (CoroutineStart) null, new zzam(this.zza, (Continuation) null), 3, (Object) null);
    }
}
