package com.google.firebase.auth;

import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zze;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzj implements OnCompleteListener {
    final /* synthetic */ PhoneAuthOptions zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ FirebaseAuth zzc;

    zzj(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, String str) {
        this.zzc = firebaseAuth;
        this.zza = phoneAuthOptions;
        this.zzb = str;
    }

    public final void onComplete(Task task) {
        String str;
        String str2 = null;
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            if (exception instanceof FirebaseAuthMissingActivityForRecaptchaException) {
                FirebaseAuth.zzW((FirebaseAuthMissingActivityForRecaptchaException) exception, this.zza, this.zzb);
                return;
            }
            Log.e("FirebaseAuth", "Error while validating application identity: ".concat(String.valueOf(task.getException() != null ? task.getException().getMessage() : "")));
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
            str = null;
        } else {
            str2 = ((zze) task.getResult()).zzb();
            str = ((zze) task.getResult()).zza();
        }
        this.zzc.zzU(this.zza, str2, str);
    }
}
