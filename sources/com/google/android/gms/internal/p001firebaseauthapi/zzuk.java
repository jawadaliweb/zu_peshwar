package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzuk implements zzbd {
    private final zzgz zza;

    public zzuk(byte[] bArr) throws GeneralSecurityException {
        if (zzhj.zza(2)) {
            this.zza = new zzgz(bArr, true);
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return this.zza.zza(Arrays.copyOf(bArr, 12), bArr, bArr2);
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
