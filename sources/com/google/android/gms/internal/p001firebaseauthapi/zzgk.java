package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzgk extends zzki {
    final /* synthetic */ zzgl zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgk(zzgl zzgl, Class cls) {
        super(cls);
        this.zza = zzgl;
    }

    public final /* bridge */ /* synthetic */ zzahp zza(zzahp zzahp) throws GeneralSecurityException {
        zztp zzb = zztq.zzb();
        zzb.zza((zztt) zzahp);
        zzb.zzb(0);
        return (zztq) zzb.zzi();
    }

    public final /* synthetic */ zzahp zzb(zzaff zzaff) throws zzags {
        return zztt.zzd(zzaff, zzafx.zza());
    }

    public final /* bridge */ /* synthetic */ void zzd(zzahp zzahp) throws GeneralSecurityException {
        zztt zztt = (zztt) zzahp;
        if (zztt.zze().isEmpty() || !zztt.zzf()) {
            throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
        }
    }
}
