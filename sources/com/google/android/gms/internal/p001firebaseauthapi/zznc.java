package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zznc extends zzkj {
    private static final zzlf zza = zzlf.zzb(zzmz.zza, zzmy.class, zzmr.class);

    public zznc() {
        super(zzrq.class, new zzna(zzcd.class));
    }

    public static void zzh(boolean z) throws GeneralSecurityException {
        zzcq.zzi(new zznc(), true);
        int i = zznn.zza;
        zznn.zza(zzkt.zzb());
        zzks.zza().zze(zza);
    }

    public static final void zzi(zzrq zzrq) throws GeneralSecurityException {
        zzvu.zzc(zzrq.zza(), 0);
        if (zzrq.zzg().zzd() >= 16) {
            zzo(zzrq.zzf());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    static /* bridge */ /* synthetic */ zzkh zzn(int i, int i2, int i3, int i4) {
        zzrs zzb = zzrt.zzb();
        zzrv zzb2 = zzrw.zzb();
        zzb2.zzb(i3);
        zzb2.zza(i2);
        zzb.zzb((zzrw) zzb2.zzi());
        zzb.zza(i);
        return new zzkh((zzrt) zzb.zzi(), i4);
    }

    /* access modifiers changed from: private */
    public static void zzo(zzrw zzrw) throws GeneralSecurityException {
        if (zzrw.zza() >= 10) {
            int zzf = zzrw.zzf() - 2;
            if (zzf != 1) {
                if (zzf != 2) {
                    if (zzf != 3) {
                        if (zzf != 4) {
                            if (zzf != 5) {
                                throw new GeneralSecurityException("unknown hash type");
                            } else if (zzrw.zza() > 28) {
                                throw new GeneralSecurityException("tag size too big");
                            }
                        } else if (zzrw.zza() > 64) {
                            throw new GeneralSecurityException("tag size too big");
                        }
                    } else if (zzrw.zza() > 32) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (zzrw.zza() > 48) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (zzrw.zza() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    public final zzki zza() {
        return new zznb(this, zzrt.class);
    }

    public final zzso zzb() {
        return zzso.SYMMETRIC;
    }

    public final /* synthetic */ zzahp zzc(zzaff zzaff) throws zzags {
        return zzrq.zze(zzaff, zzafx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzahp zzahp) throws GeneralSecurityException {
        zzi((zzrq) zzahp);
    }

    public final int zzf() {
        return 2;
    }
}
