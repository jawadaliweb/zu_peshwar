package com.google.firebase.auth;

import com.google.firebase.auth.PhoneAuthProvider;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final /* synthetic */ class zzi implements Runnable {
    public final /* synthetic */ PhoneAuthProvider.OnVerificationStateChangedCallbacks zza;
    public final /* synthetic */ FirebaseAuthMissingActivityForRecaptchaException zzb;

    public /* synthetic */ zzi(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, FirebaseAuthMissingActivityForRecaptchaException firebaseAuthMissingActivityForRecaptchaException) {
        this.zza = onVerificationStateChangedCallbacks;
        this.zzb = firebaseAuthMissingActivityForRecaptchaException;
    }

    public final void run() {
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks = this.zza;
        FirebaseAuthMissingActivityForRecaptchaException firebaseAuthMissingActivityForRecaptchaException = this.zzb;
        int i = FirebaseAuth.zza;
        onVerificationStateChangedCallbacks.onVerificationFailed(firebaseAuthMissingActivityForRecaptchaException);
    }
}
