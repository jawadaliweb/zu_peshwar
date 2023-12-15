package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final /* synthetic */ class zzbh implements OnCompleteListener {
    public final /* synthetic */ RecaptchaActivity zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbh(RecaptchaActivity recaptchaActivity, String str) {
        this.zza = recaptchaActivity;
        this.zzb = str;
    }

    public final void onComplete(Task task) {
        this.zza.zzh(this.zzb, task);
    }
}
