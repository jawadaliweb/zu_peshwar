package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzzx extends zzabg {
    private final PhoneAuthCredential zza;

    public zzzx(PhoneAuthCredential phoneAuthCredential) {
        super(2);
        this.zza = (PhoneAuthCredential) Preconditions.checkNotNull(phoneAuthCredential);
    }

    public final String zza() {
        return "updatePhoneNumber";
    }

    public final void zzb() {
        ((zzg) this.zzi).zza(this.zzn, zzaac.zzQ(this.zzg, this.zzo));
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzp(new zzwd(this.zzh.zzf(), this.zza), this.zzf);
    }
}
