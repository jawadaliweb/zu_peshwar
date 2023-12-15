package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzmg extends zzkj {
    private static final zzlf zza = zzlf.zzb(zzmd.zza, zzmc.class, zzmr.class);

    zzmg() {
        super(zzok.class, new zzme(zzcd.class));
    }

    public static void zzi(boolean z) throws GeneralSecurityException {
        zzcq.zzi(new zzmg(), true);
        int i = zzmq.zza;
        zzmq.zza(zzkt.zzb());
        zzks.zza().zze(zza);
    }

    /* access modifiers changed from: private */
    public static void zzn(zzoq zzoq) throws GeneralSecurityException {
        if (zzoq.zza() < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (zzoq.zza() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* access modifiers changed from: private */
    public static void zzo(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    public final zzki zza() {
        return new zzmf(this, zzon.class);
    }

    public final zzso zzb() {
        return zzso.SYMMETRIC;
    }

    public final /* synthetic */ zzahp zzc(zzaff zzaff) throws zzags {
        return zzok.zzd(zzaff, zzafx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzahp zzahp) throws GeneralSecurityException {
        zzok zzok = (zzok) zzahp;
        zzvu.zzc(zzok.zza(), 0);
        zzo(zzok.zzf().zzd());
        zzn(zzok.zze());
    }
}
