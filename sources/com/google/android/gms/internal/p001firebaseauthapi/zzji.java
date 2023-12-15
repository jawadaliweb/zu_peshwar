package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzji  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzji extends zzkj {
    public zzji() {
        super(zzsk.class, new zzjh(zzbk.class));
    }

    public final zzso zzb() {
        return zzso.ASYMMETRIC_PUBLIC;
    }

    public final /* synthetic */ zzahp zzc(zzaff zzaff) throws zzags {
        return zzsk.zzf(zzaff, zzafx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HpkePublicKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzahp zzahp) throws GeneralSecurityException {
        zzsk zzsk = (zzsk) zzahp;
        zzvu.zzc(zzsk.zza(), 0);
        if (zzsk.zzl()) {
            zzjj.zza(zzsk.zzb());
            return;
        }
        throw new GeneralSecurityException("Missing HPKE key params.");
    }
}
