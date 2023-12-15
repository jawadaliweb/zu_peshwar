package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzys  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzys extends zzabg {
    private final zzwb zza = new zzwb();

    public zzys() {
        super(11);
    }

    public final String zza() {
        return "getRecaptchaParam";
    }

    public final void zzb() {
        zzm(this.zzy);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzk(this.zza, this.zzf);
    }
}
