package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzhf extends zzhd {
    public zzhf(byte[] bArr) throws GeneralSecurityException {
        super(bArr);
    }

    /* access modifiers changed from: package-private */
    public final zzhb zza(byte[] bArr, int i) throws InvalidKeyException {
        return new zzhe(bArr, i);
    }
}
