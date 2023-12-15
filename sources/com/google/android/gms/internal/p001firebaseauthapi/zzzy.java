package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzzy extends zzabg {
    private final UserProfileChangeRequest zza;

    public zzzy(UserProfileChangeRequest userProfileChangeRequest) {
        super(2);
        this.zza = (UserProfileChangeRequest) Preconditions.checkNotNull(userProfileChangeRequest, "request cannot be null");
    }

    public final String zza() {
        return "updateProfile";
    }

    public final void zzb() {
        ((zzg) this.zzi).zza(this.zzn, zzaac.zzQ(this.zzg, this.zzo));
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzG(this.zzh.zzf(), this.zza, this.zzf);
    }
}
