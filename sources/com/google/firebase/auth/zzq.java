package com.google.firebase.auth;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzq implements Continuation {
    zzq(FirebaseAuth firebaseAuth) {
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        return (task.isSuccessful() || !(task.getException() instanceof FirebaseAuthException) || !((FirebaseAuthException) task.getException()).getErrorCode().equals("ERROR_INTERNAL_SUCCESS_SIGN_OUT")) ? task : Tasks.forResult(null);
    }
}
