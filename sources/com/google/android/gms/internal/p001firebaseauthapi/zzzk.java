package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzzk extends zzabg {
    private final String zza;

    public zzzk(String str) {
        super(2);
        this.zza = str;
    }

    public final String zza() {
        return "signInAnonymously";
    }

    public final void zzb() {
        zzx zzQ = zzaac.zzQ(this.zzg, this.zzo);
        ((zzg) this.zzi).zza(this.zzn, zzQ);
        zzm(new zzr(zzQ));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzv(this.zza, this.zzf);
    }
}
