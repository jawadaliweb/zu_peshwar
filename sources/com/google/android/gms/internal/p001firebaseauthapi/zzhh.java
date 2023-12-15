package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzhh extends ThreadLocal {
    zzhh() {
    }

    protected static final Cipher zza() {
        try {
            return (Cipher) zzvc.zza.zza("AES/GCM-SIV/NoPadding");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
