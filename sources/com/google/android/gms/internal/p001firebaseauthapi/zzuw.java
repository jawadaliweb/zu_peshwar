package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.Provider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzuw implements zzvb {
    private final zzvk zza;

    /* synthetic */ zzuw(zzvk zzvk, zzuv zzuv) {
        this.zza = zzvk;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        for (Provider zza2 : zzvc.zzb(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL")) {
            try {
                return this.zza.zza(str, zza2);
            } catch (Exception unused) {
            }
        }
        return this.zza.zza(str, (Provider) null);
    }
}
