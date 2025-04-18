package com.google.firebase.auth;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class FirebaseAuthWeakPasswordException extends FirebaseAuthInvalidCredentialsException {
    private final String zza;

    public FirebaseAuthWeakPasswordException(String str, String str2, String str3) {
        super(str, str2);
        this.zza = str3;
    }

    public String getReason() {
        return this.zza;
    }
}
