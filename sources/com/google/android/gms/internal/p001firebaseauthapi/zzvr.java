package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzvr extends ThreadLocal {
    zzvr() {
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }
}
