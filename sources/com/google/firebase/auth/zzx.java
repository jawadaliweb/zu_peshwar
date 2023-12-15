package com.google.firebase.auth;

import com.google.android.gms.internal.p001firebaseauthapi.zzac;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzx implements Continuation {
    zzx(FirebaseAuth firebaseAuth) {
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        if (task.isSuccessful()) {
            return Tasks.forResult(null);
        }
        Exception exception = task.getException();
        return Tasks.forException(new FirebaseAuthException("INTERNAL_ERROR", zzac.zzc(exception != null ? exception.getMessage() : "")));
    }
}
