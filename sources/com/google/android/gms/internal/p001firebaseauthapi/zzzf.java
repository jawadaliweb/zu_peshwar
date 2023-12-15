package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzzf extends zzabg {
    private final zzwj zza;

    public zzzf(PhoneAuthCredential phoneAuthCredential, String str) {
        super(2);
        Preconditions.checkNotNull(phoneAuthCredential, "credential cannot be null");
        phoneAuthCredential.zze(false);
        this.zza = new zzwj(phoneAuthCredential, str);
    }

    public final String zza() {
        return "reauthenticateWithPhoneCredentialWithData";
    }

    public final void zzb() {
        zzx zzQ = zzaac.zzQ(this.zzg, this.zzo);
        if (this.zzh.getUid().equalsIgnoreCase(zzQ.getUid())) {
            ((zzg) this.zzi).zza(this.zzn, zzQ);
            zzm(new zzr(zzQ));
            return;
        }
        zzl(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzA(this.zza, this.zzf);
    }
}
