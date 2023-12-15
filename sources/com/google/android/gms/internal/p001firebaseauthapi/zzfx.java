package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzfx extends zzkj {
    zzfx() {
        super(zzqj.class, new zzfv(zzbd.class));
    }

    public final zzki zza() {
        return new zzfw(this, zzqm.class);
    }

    public final zzso zzb() {
        return zzso.SYMMETRIC;
    }

    public final /* synthetic */ zzahp zzc(zzaff zzaff) throws zzags {
        return zzqj.zzd(zzaff, zzafx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public final /* bridge */ /* synthetic */ void zze(zzahp zzahp) throws GeneralSecurityException {
        zzqj zzqj = (zzqj) zzahp;
        zzvu.zzc(zzqj.zza(), 0);
        if (zzqj.zze().zzd() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }
}
