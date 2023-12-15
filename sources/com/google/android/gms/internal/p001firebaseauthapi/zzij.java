package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzij  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzij extends zzlm {
    /* access modifiers changed from: private */
    public static final byte[] zza = new byte[0];

    zzij() {
        super(zzra.class, zzrd.class, new zzih(zzbj.class));
    }

    static /* bridge */ /* synthetic */ zzkh zzi(int i, int i2, int i3, zzbu zzbu, byte[] bArr, int i4) {
        zztv zztv;
        zzqt zza2 = zzqu.zza();
        zzrf zza3 = zzrg.zza();
        zza3.zzb(4);
        zza3.zzc(5);
        zza3.zza(zzaff.zzn(bArr, 0, 0));
        zzrg zzrg = (zzrg) zza3.zzi();
        zzst zza4 = zzsu.zza();
        zza4.zzb(zzbu.zzb());
        byte[] zzc = zzbu.zzc();
        zza4.zzc(zzaff.zzn(zzc, 0, zzc.length));
        int zzd = zzbu.zzd() - 1;
        if (zzd == 0) {
            zztv = zztv.TINK;
        } else if (zzd == 1) {
            zztv = zztv.LEGACY;
        } else if (zzd != 2) {
            zztv = zztv.CRUNCHY;
        } else {
            zztv = zztv.RAW;
        }
        zza4.zza(zztv);
        zzqq zza5 = zzqr.zza();
        zza5.zza((zzsu) zza4.zzi());
        zzqw zzb = zzqx.zzb();
        zzb.zzb(zzrg);
        zzb.zza((zzqr) zza5.zzi());
        zzb.zzc(i3);
        zza2.zza((zzqx) zzb.zzi());
        return new zzkh((zzqu) zza2.zzi(), i4);
    }

    public final zzki zza() {
        return new zzii(this, zzqu.class);
    }

    public final zzso zzb() {
        return zzso.ASYMMETRIC_PRIVATE;
    }

    public final /* synthetic */ zzahp zzc(zzaff zzaff) throws zzags {
        return zzra.zzd(zzaff, zzafx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzahp zzahp) throws GeneralSecurityException {
        zzra zzra = (zzra) zzahp;
        if (!zzra.zzf().zzp()) {
            zzvu.zzc(zzra.zza(), 0);
            zzis.zza(zzra.zze().zzb());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }

    public final /* synthetic */ zzahp zzg(zzahp zzahp) throws GeneralSecurityException {
        return ((zzra) zzahp).zze();
    }
}
