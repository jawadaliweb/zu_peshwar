package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public class zzabj {
    zzaaf zza;
    Executor zzb;

    public final Task zzS(zzabi zzabi) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzb.execute(new zzabh(this, zzabi, taskCompletionSource));
        return taskCompletionSource.getTask();
    }
}
