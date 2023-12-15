package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzgl extends zzkj {
    zzgl() {
        super(zztq.class, new zzgj(zzbd.class));
    }

    public final zzki zza() {
        return new zzgk(this, zztt.class);
    }

    public final zzso zzb() {
        return zzso.REMOTE;
    }

    public final /* synthetic */ zzahp zzc(zzaff zzaff) throws zzags {
        return zztq.zzd(zzaff, zzafx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzahp zzahp) throws GeneralSecurityException {
        zzvu.zzc(((zztq) zzahp).zza(), 0);
    }
}
