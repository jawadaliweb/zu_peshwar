package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.GetTokenResult;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzab implements Continuation {
    final /* synthetic */ zzac zza;

    zzab(zzac zzac) {
        this.zza = zzac;
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(task.getException());
        }
        return Tasks.forResult(zzag.zza(((GetTokenResult) task.getResult()).getToken(), this.zza.zza));
    }
}
