package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzzg extends zzabg {
    public zzzg() {
        super(2);
    }

    public final String zza() {
        return "reload";
    }

    public final void zzb() {
        ((zzg) this.zzi).zza(this.zzn, zzaac.zzQ(this.zzg, this.zzo));
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzq(this.zzh.zzf(), this.zzf);
    }
}
