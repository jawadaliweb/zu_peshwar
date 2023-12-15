package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzzj extends zzabg {
    private final zzwh zza;

    public zzzj(String str) {
        super(9);
        this.zza = new zzwh(str);
    }

    public final String zza() {
        return "setFirebaseUIVersion";
    }

    public final void zzb() {
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzu(this.zza, this.zzf);
    }
}
