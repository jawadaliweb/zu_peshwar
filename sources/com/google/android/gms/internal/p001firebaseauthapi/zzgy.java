package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzgy extends ThreadLocal {
    zzgy() {
    }

    protected static final Cipher zza() {
        try {
            return (Cipher) zzvc.zza.zza("AES/GCM/NoPadding");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
