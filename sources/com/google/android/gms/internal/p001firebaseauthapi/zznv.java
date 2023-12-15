package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zznv implements zzmr {
    private final zzmc zza;

    public zznv(zzmc zzmc) throws GeneralSecurityException {
        if (zzhj.zza(1)) {
            this.zza = zzmc;
            return;
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }
}
