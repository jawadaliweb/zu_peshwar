package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzan;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzyn extends zzabg {
    public zzyn() {
        super(5);
    }

    public final String zza() {
        return "delete";
    }

    public final void zzb() {
        ((zzan) this.zzi).zza();
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzg(this.zzh.zzf(), this.zzf);
    }
}
