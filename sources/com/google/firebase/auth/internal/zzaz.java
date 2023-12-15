package com.google.firebase.auth.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.appcheck.AppCheckTokenResult;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final /* synthetic */ class zzaz implements Continuation {
    public final /* synthetic */ Uri zza;

    public /* synthetic */ zzaz(Uri uri) {
        this.zza = uri;
    }

    public final Object then(Task task) {
        Uri uri = this.zza;
        int i = GenericIdpActivity.zzb;
        Uri.Builder buildUpon = uri.buildUpon();
        if (task.isSuccessful()) {
            AppCheckTokenResult appCheckTokenResult = (AppCheckTokenResult) task.getResult();
            if (appCheckTokenResult.getError() != null) {
                Log.w("GenericIdpActivity", "Error getting App Check token; using placeholder token instead. Error: ".concat(String.valueOf(String.valueOf(appCheckTokenResult.getError()))));
            }
            buildUpon.fragment("fac=".concat(String.valueOf(appCheckTokenResult.getToken())));
        } else {
            Log.e("GenericIdpActivity", "Unexpected error getting App Check token: ".concat(String.valueOf(task.getException().getMessage())));
        }
        return buildUpon.build();
    }
}
