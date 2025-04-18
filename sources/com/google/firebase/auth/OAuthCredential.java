package com.google.firebase.auth;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public abstract class OAuthCredential extends AuthCredential {
    public abstract String getAccessToken();

    public abstract String getIdToken();

    public abstract String getSecret();
}
