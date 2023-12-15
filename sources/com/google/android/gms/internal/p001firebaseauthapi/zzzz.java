package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzzz extends zzabg {
    private final zzwl zza;

    public zzzz(String str, String str2, ActionCodeSettings actionCodeSettings) {
        super(6);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(actionCodeSettings);
        this.zza = new zzwl(str, str2, actionCodeSettings);
    }

    public final String zza() {
        return "verifyBeforeUpdateEmail";
    }

    public final void zzb() {
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzH(this.zza, this.zzf);
    }
}
