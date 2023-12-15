package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzzh extends zzabg {
    private final zzwe zza;

    public zzzh(String str, ActionCodeSettings actionCodeSettings) {
        super(6);
        Preconditions.checkNotEmpty(str, "token cannot be null or empty");
        this.zza = new zzwe(str, actionCodeSettings);
    }

    public final String zza() {
        return "sendEmailVerification";
    }

    public final void zzb() {
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzr(this.zza, this.zzf);
    }
}
