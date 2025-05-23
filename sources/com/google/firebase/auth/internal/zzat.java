package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzat implements OnFailureListener {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ Context zzb;

    zzat(zzax zzax, TaskCompletionSource taskCompletionSource, Context context) {
        this.zza = taskCompletionSource;
        this.zzb = context;
    }

    public final void onFailure(Exception exc) {
        this.zza.setException(exc);
        zzax.zze(this.zzb);
    }
}
