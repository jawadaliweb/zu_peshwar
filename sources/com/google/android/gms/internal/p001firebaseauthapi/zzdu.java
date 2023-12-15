package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzdu extends zzkj {
    zzdu() {
        super(zzoz.class, new zzds(zzvm.class));
    }

    public static final void zzh(zzoz zzoz) throws GeneralSecurityException {
        zzvu.zzc(zzoz.zza(), 0);
        zzvu.zzb(zzoz.zzg().zzd());
        zzi(zzoz.zzf());
    }

    /* access modifiers changed from: private */
    public static final void zzi(zzpf zzpf) throws GeneralSecurityException {
        if (zzpf.zza() < 12 || zzpf.zza() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    public final zzki zza() {
        return new zzdt(this, zzpc.class);
    }

    public final zzso zzb() {
        return zzso.SYMMETRIC;
    }

    public final /* synthetic */ zzahp zzc(zzaff zzaff) throws zzags {
        return zzoz.zze(zzaff, zzafx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzahp zzahp) throws GeneralSecurityException {
        zzh((zzoz) zzahp);
    }
}
