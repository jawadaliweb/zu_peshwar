package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzil  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzil extends zzkj {
    public zzil() {
        super(zzrd.class, new zzik(zzbk.class));
    }

    public final zzso zzb() {
        return zzso.ASYMMETRIC_PUBLIC;
    }

    public final /* synthetic */ zzahp zzc(zzaff zzaff) throws zzags {
        return zzrd.zzf(zzaff, zzafx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzahp zzahp) throws GeneralSecurityException {
        zzrd zzrd = (zzrd) zzahp;
        zzvu.zzc(zzrd.zza(), 0);
        zzis.zza(zzrd.zzb());
    }
}
