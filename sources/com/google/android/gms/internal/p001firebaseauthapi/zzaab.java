package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaab  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaab extends zzabg {
    private final zzwg zza;

    public zzaab(zzado zzado) {
        super(8);
        Preconditions.checkNotNull(zzado);
        this.zza = new zzwg(zzado);
    }

    public final String zza() {
        return "verifyPhoneNumber";
    }

    public final void zzb() {
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzt(this.zza, this.zzf);
    }
}
