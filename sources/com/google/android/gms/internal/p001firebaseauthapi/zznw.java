package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zznw implements zzmr {
    private final zzmy zza;

    public zznw(zzmy zzmy) throws GeneralSecurityException {
        if (zzhj.zza(2)) {
            this.zza = zzmy;
            return;
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
