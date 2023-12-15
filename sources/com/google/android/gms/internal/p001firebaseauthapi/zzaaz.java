package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaaz implements zzabe {
    final /* synthetic */ PhoneAuthCredential zza;

    zzaaz(zzabd zzabd, PhoneAuthCredential phoneAuthCredential) {
        this.zza = phoneAuthCredential;
    }

    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationCompleted(this.zza);
    }
}
