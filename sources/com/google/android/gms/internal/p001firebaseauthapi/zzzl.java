package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzh;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzzl extends zzabg {
    private final zzaec zza;

    public zzzl(AuthCredential authCredential, String str) {
        super(2);
        Preconditions.checkNotNull(authCredential, "credential cannot be null");
        this.zza = zzh.zza(authCredential, str);
    }

    public final String zza() {
        return "signInWithCredential";
    }

    public final void zzb() {
        zzx zzQ = zzaac.zzQ(this.zzg, this.zzo);
        ((zzg) this.zzi).zza(this.zzn, zzQ);
        zzm(new zzr(zzQ));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzw(this.zza, this.zzf);
    }
}
