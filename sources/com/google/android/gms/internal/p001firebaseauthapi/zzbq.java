package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzbq implements zzbr {
    final /* synthetic */ zzlm zza;
    final /* synthetic */ zzkj zzb;

    zzbq(zzlm zzlm, zzkj zzkj) {
        this.zza = zzlm;
        this.zzb = zzkj;
    }

    public final zzbm zza(Class cls) throws GeneralSecurityException {
        try {
            return new zzco(this.zza, this.zzb, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    public final zzbm zzb() {
        zzlm zzlm = this.zza;
        return new zzco(zzlm, this.zzb, zzlm.zzj());
    }

    public final Class zzc() {
        return this.zza.getClass();
    }

    public final Class zzd() {
        return this.zzb.getClass();
    }

    public final Set zze() {
        return this.zza.zzm();
    }
}
