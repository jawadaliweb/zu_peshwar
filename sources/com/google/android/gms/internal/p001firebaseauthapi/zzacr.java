package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public enum zzacr {
    REFRESH_TOKEN("refresh_token"),
    AUTHORIZATION_CODE("authorization_code");
    
    private final String zzd;

    private zzacr(String str) {
        this.zzd = str;
    }

    public final String toString() {
        return this.zzd;
    }
}
