package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzyt extends zzabg {
    private final zzwc zza;

    public zzyt(String str, String str2) {
        super(10);
        Preconditions.checkNotEmpty("RECAPTCHA_ENTERPRISE");
        this.zza = new zzwc(str, "RECAPTCHA_ENTERPRISE");
    }

    public final String zza() {
        return "getRecaptchaConfig";
    }

    public final void zzb() {
        zzm(this.zzx);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzm(this.zza, this.zzf);
    }
}
