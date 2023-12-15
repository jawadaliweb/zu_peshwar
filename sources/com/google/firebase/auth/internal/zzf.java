package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p001firebaseauthapi.zzaag;
import com.google.android.gms.internal.p001firebaseauthapi.zzaas;
import com.google.android.gms.internal.p001firebaseauthapi.zzace;
import com.google.android.gms.internal.p001firebaseauthapi.zzada;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzf {
    /* access modifiers changed from: private */
    public static final String zza = "zzf";
    private static final zzf zzb = new zzf();
    /* access modifiers changed from: private */
    public String zzc;

    private zzf() {
    }

    public static zzf zzb() {
        return zzb;
    }

    private final void zzf(FirebaseAuth firebaseAuth, zzby zzby, Activity activity, TaskCompletionSource taskCompletionSource) {
        Task task;
        if (activity == null) {
            taskCompletionSource.setException(new FirebaseAuthMissingActivityForRecaptchaException());
            return;
        }
        zzby.zzg(firebaseAuth.getApp().getApplicationContext(), firebaseAuth);
        Preconditions.checkNotNull(activity);
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        if (!zzax.zza().zzg(activity, taskCompletionSource2)) {
            task = Tasks.forException(zzaag.zza(new Status(17057, "reCAPTCHA flow already in progress")));
        } else {
            Intent intent = new Intent("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
            intent.setClass(activity, RecaptchaActivity.class);
            intent.setPackage(activity.getPackageName());
            intent.putExtra("com.google.firebase.auth.KEY_API_KEY", firebaseAuth.getApp().getOptions().getApiKey());
            if (!TextUtils.isEmpty(firebaseAuth.getTenantId())) {
                intent.putExtra("com.google.firebase.auth.KEY_TENANT_ID", firebaseAuth.getTenantId());
            }
            intent.putExtra("com.google.firebase.auth.internal.CLIENT_VERSION", zzaas.zza().zzb());
            intent.putExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME", firebaseAuth.getApp().getName());
            activity.startActivity(intent);
            task = taskCompletionSource2.getTask();
        }
        task.addOnSuccessListener(new zzd(this, taskCompletionSource)).addOnFailureListener(new zzc(this, taskCompletionSource));
    }

    public final Task zza(FirebaseAuth firebaseAuth, String str, Activity activity, boolean z, boolean z2) {
        Task task;
        zzw zzw = (zzw) firebaseAuth.getFirebaseAuthSettings();
        zzby zzc2 = zzby.zzc();
        if (zzace.zzg(firebaseAuth.getApp()) || zzw.zze()) {
            return Tasks.forResult(new zze((String) null, (String) null));
        }
        String str2 = zza;
        boolean zzc3 = zzw.zzc();
        Log.i(str2, "ForceRecaptchaFlow from phoneAuthOptions = " + z2 + ", ForceRecaptchaFlow from firebaseSettings = " + zzc3);
        boolean zzc4 = z2 | zzw.zzc();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Task zzb2 = zzc2.zzb();
        if (zzb2 != null) {
            if (zzb2.isSuccessful()) {
                return Tasks.forResult(new zze((String) zzb2.getResult(), (String) null));
            }
            Log.e(str2, "Error in previous reCAPTCHA flow: ".concat(String.valueOf(zzb2.getException().getMessage())));
            Log.e(str2, "Continuing with application verification as normal");
        }
        if (!z || zzc4) {
            zzf(firebaseAuth, zzc2, activity, taskCompletionSource);
        } else {
            IntegrityManager create = IntegrityManagerFactory.create(firebaseAuth.getApp().getApplicationContext());
            if (!TextUtils.isEmpty(this.zzc)) {
                task = Tasks.forResult(new zzada(this.zzc));
            } else {
                task = firebaseAuth.zzd();
            }
            task.continueWithTask(firebaseAuth.zzL(), new zzb(this, str, create)).addOnCompleteListener(new zza(this, taskCompletionSource, firebaseAuth, zzc2, activity));
        }
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, zzby zzby, Activity activity, Task task) {
        if (!task.isSuccessful() || task.getResult() == null || TextUtils.isEmpty(((IntegrityTokenResponse) task.getResult()).token())) {
            Log.e(zza, "Play Integrity Token fetch failed, falling back to Recaptcha".concat(String.valueOf(task.getException() == null ? "" : task.getException().getMessage())));
            zzf(firebaseAuth, zzby, activity, taskCompletionSource);
            return;
        }
        taskCompletionSource.setResult(new zze((String) null, ((IntegrityTokenResponse) task.getResult()).token()));
    }
}
