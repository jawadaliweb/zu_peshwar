package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzzp extends zzabg {
    private final zzwj zza;

    public zzzp(PhoneAuthCredential phoneAuthCredential, String str) {
        super(2);
        Preconditions.checkNotNull(phoneAuthCredential);
        this.zza = new zzwj(phoneAuthCredential, str);
    }

    public final String zza() {
        return "signInWithPhoneNumber";
    }

    public final void zzb() {
        zzx zzQ = zzaac.zzQ(this.zzg, this.zzo);
        ((zzg) this.zzi).zza(this.zzn, zzQ);
        zzm(new zzr(zzQ));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzA(this.zza, this.zzf);
    }
}
