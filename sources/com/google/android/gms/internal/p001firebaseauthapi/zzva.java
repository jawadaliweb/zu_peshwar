package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.Provider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzva  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzva implements zzvb {
    private final zzvk zza;

    /* synthetic */ zzva(zzvk zzvk, zzuz zzuz) {
        this.zza = zzvk;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        Exception exc = null;
        for (Provider zza2 : zzvc.zzb(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL", "Conscrypt")) {
            try {
                return this.zza.zza(str, zza2);
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
