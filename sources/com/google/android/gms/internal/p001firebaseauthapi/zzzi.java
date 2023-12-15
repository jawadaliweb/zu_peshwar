package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzzi extends zzabg {
    private final zzwf zza;
    private final String zzb;

    public zzzi(String str, ActionCodeSettings actionCodeSettings, String str2, String str3, String str4) {
        super(4);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        this.zza = new zzwf(str, actionCodeSettings, str2, str3);
        this.zzb = str4;
    }

    public final String zza() {
        return this.zzb;
    }

    public final void zzb() {
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzs(this.zza, this.zzf);
    }
}
