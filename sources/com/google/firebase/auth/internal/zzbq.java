package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaTasksClient;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzbq implements Continuation {
    final /* synthetic */ RecaptchaAction zza;

    zzbq(zzbr zzbr, RecaptchaAction recaptchaAction) {
        this.zza = recaptchaAction;
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        if (task.isSuccessful()) {
            return ((RecaptchaTasksClient) task.getResult()).executeTask(this.zza);
        }
        Exception exc = (Exception) Preconditions.checkNotNull(task.getException());
        if (!(exc instanceof zzbo)) {
            return Tasks.forException(exc);
        }
        if (Log.isLoggable("RecaptchaHandler", 4)) {
            Log.i("RecaptchaHandler", "Ignoring error related to fetching recaptcha config - ".concat(String.valueOf(exc.getMessage())));
        }
        return Tasks.forResult("");
    }
}
