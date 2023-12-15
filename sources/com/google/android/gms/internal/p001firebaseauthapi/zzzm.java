package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzzm extends zzabg {
    private final zzaef zza;

    public zzzm(String str, String str2) {
        super(2);
        Preconditions.checkNotEmpty(str, "token cannot be null or empty");
        this.zza = new zzaef(str, str2);
    }

    public final String zza() {
        return "signInWithCustomToken";
    }

    public final void zzb() {
        zzx zzQ = zzaac.zzQ(this.zzg, this.zzo);
        ((zzg) this.zzi).zza(this.zzn, zzQ);
        zzm(new zzr(zzQ));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzx(this.zza, this.zzf);
    }
}
