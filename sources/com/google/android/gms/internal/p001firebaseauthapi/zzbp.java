package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzbp implements zzbr {
    final /* synthetic */ zzkj zza;

    zzbp(zzkj zzkj) {
        this.zza = zzkj;
    }

    public final zzbm zza(Class cls) throws GeneralSecurityException {
        try {
            return new zzbo(this.zza, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    public final zzbm zzb() {
        zzkj zzkj = this.zza;
        return new zzbo(zzkj, zzkj.zzj());
    }

    public final Class zzc() {
        return this.zza.getClass();
    }

    public final Class zzd() {
        return null;
    }

    public final Set zze() {
        return this.zza.zzm();
    }
}
