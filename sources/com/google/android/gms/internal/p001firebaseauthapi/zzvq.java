package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzvq implements zzcd {
    private final zzoh zza;
    private final int zzb;

    public zzvq(zzoh zzoh, int i) throws GeneralSecurityException {
        this.zza = zzoh;
        this.zzb = i;
        if (i >= 10) {
            zzoh.zza(new byte[0], i);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!MessageDigest.isEqual(this.zza.zza(bArr2, this.zzb), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
