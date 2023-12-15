package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaba  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaba implements zzabe {
    final /* synthetic */ String zza;

    zzaba(zzabd zzabd, String str) {
        this.zza = str;
    }

    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onCodeAutoRetrievalTimeOut(this.zza);
    }
}
