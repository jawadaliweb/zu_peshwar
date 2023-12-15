package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzabc implements Runnable {
    final /* synthetic */ zzabe zza;
    final /* synthetic */ zzabd zzb;

    zzabc(zzabd zzabd, zzabe zzabe) {
        this.zzb = zzabd;
        this.zza = zzabe;
    }

    public final void run() {
        synchronized (this.zzb.zza.zzl) {
            if (!this.zzb.zza.zzl.isEmpty()) {
                this.zza.zza((PhoneAuthProvider.OnVerificationStateChangedCallbacks) this.zzb.zza.zzl.get(0), new Object[0]);
            }
        }
    }
}
