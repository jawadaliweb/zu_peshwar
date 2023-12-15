package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzgh extends zzkj {
    zzgh() {
        super(zztk.class, new zzgf(zzbd.class));
    }

    public final zzki zza() {
        return new zzgg(this, zztn.class);
    }

    public final zzso zzb() {
        return zzso.REMOTE;
    }

    public final /* synthetic */ zzahp zzc(zzaff zzaff) throws zzags {
        return zztk.zzd(zzaff, zzafx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzahp zzahp) throws GeneralSecurityException {
        zzvu.zzc(((zztk) zzahp).zza(), 0);
    }
}
