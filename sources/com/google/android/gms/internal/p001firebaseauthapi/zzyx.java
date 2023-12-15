package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzyx extends zzabg {
    private final EmailAuthCredential zza;

    public zzyx(EmailAuthCredential emailAuthCredential) {
        super(2);
        this.zza = (EmailAuthCredential) Preconditions.checkNotNull(emailAuthCredential, "credential cannot be null");
    }

    public final String zza() {
        return "linkEmailAuthCredential";
    }

    public final void zzb() {
        zzx zzQ = zzaac.zzQ(this.zzg, this.zzo);
        ((zzg) this.zzi).zza(this.zzn, zzQ);
        zzm(new zzr(zzQ));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        EmailAuthCredential emailAuthCredential = this.zza;
        emailAuthCredential.zzb(this.zzh);
        zzaaf.zzz(new zzwi(emailAuthCredential, (String) null), this.zzf);
    }
}
