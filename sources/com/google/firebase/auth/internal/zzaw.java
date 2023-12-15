package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001firebaseauthapi.zzaag;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import java.lang.ref.WeakReference;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaw extends BroadcastReceiver {
    final /* synthetic */ zzax zza;
    private final WeakReference zzb;
    private final TaskCompletionSource zzc;

    zzaw(zzax zzax, Activity activity, TaskCompletionSource taskCompletionSource) {
        this.zza = zzax;
        this.zzb = new WeakReference(activity);
        this.zzc = taskCompletionSource;
    }

    public final void onReceive(Context context, Intent intent) {
        if (((Activity) this.zzb.get()) == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            this.zzc.setException(zzaag.zza(new Status((int) FirebaseError.ERROR_INTERNAL_ERROR, "Activity that started the web operation is no longer alive; see logcat for details")));
            zzax.zze(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(stringExtra)) {
                this.zzc.setResult(intent.getStringExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN"));
                zzax.zze(context);
                return;
            }
            TaskCompletionSource taskCompletionSource = this.zzc;
            taskCompletionSource.setException(zzaag.zza(zzai.zza("WEB_CONTEXT_CANCELED:Unknown operation received (" + stringExtra + ")")));
        } else if (zzbx.zzc(intent)) {
            this.zzc.setException(zzaag.zza(zzbx.zza(intent)));
            zzax.zze(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
            this.zzc.setException(zzaag.zza(zzai.zza("WEB_CONTEXT_CANCELED")));
            zzax.zze(context);
        }
    }
}
