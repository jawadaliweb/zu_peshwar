package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzzw extends zzabg {
    private final String zza;

    public zzzw(String str) {
        super(2);
        this.zza = Preconditions.checkNotEmpty(str, "password cannot be null or empty");
    }

    public final String zza() {
        return "updatePassword";
    }

    public final void zzb() {
        ((zzg) this.zzi).zza(this.zzn, zzaac.zzQ(this.zzg, this.zzo));
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzc(this.zzh.zzf(), this.zza, this.zzf);
    }
}
