package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzit  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzit implements zzuo {
    private final String zza;
    private final int zzb;
    private zzpr zzc;
    private zzot zzd;
    private int zze;
    private zzqd zzf;

    zzit(zzsu zzsu) throws GeneralSecurityException {
        String zzf2 = zzsu.zzf();
        this.zza = zzf2;
        if (zzf2.equals(zzct.zzb)) {
            try {
                zzpu zzd2 = zzpu.zzd(zzsu.zze(), zzafx.zza());
                this.zzc = (zzpr) zzcq.zzc(zzsu);
                this.zzb = zzd2.zza();
            } catch (zzags e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (zzf2.equals(zzct.zza)) {
            try {
                zzow zzc2 = zzow.zzc(zzsu.zze(), zzafx.zza());
                this.zzd = (zzot) zzcq.zzc(zzsu);
                this.zze = zzc2.zzd().zza();
                this.zzb = this.zze + zzc2.zze().zza();
            } catch (zzags e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        } else if (zzf2.equals(zzic.zza)) {
            try {
                zzqg zzd3 = zzqg.zzd(zzsu.zze(), zzafx.zza());
                this.zzf = (zzqd) zzcq.zzc(zzsu);
                this.zzb = zzd3.zza();
            } catch (zzags e3) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
            }
        } else {
            throw new GeneralSecurityException("unsupported AEAD DEM key type: ".concat(String.valueOf(zzf2)));
        }
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzjo zzb(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.zzb) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        } else if (this.zza.equals(zzct.zzb)) {
            zzpq zzb2 = zzpr.zzb();
            zzb2.zzh(this.zzc);
            zzb2.zza(zzaff.zzn(bArr, 0, this.zzb));
            return new zzjo((zzbd) zzcq.zzf(this.zza, (zzpr) zzb2.zzi(), zzbd.class));
        } else if (this.zza.equals(zzct.zza)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zze);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zze, this.zzb);
            zzoy zzb3 = zzoz.zzb();
            zzb3.zzh(this.zzd.zze());
            zzaff zzaff = zzaff.zzb;
            zzb3.zza(zzaff.zzn(copyOfRange, 0, copyOfRange.length));
            zzrp zzb4 = zzrq.zzb();
            zzb4.zzh(this.zzd.zzf());
            zzb4.zza(zzaff.zzn(copyOfRange2, 0, copyOfRange2.length));
            zzos zzb5 = zzot.zzb();
            zzb5.zzc(this.zzd.zza());
            zzb5.zza((zzoz) zzb3.zzi());
            zzb5.zzb((zzrq) zzb4.zzi());
            return new zzjo((zzbd) zzcq.zzf(this.zza, (zzot) zzb5.zzi(), zzbd.class));
        } else if (this.zza.equals(zzic.zza)) {
            zzqc zzb6 = zzqd.zzb();
            zzb6.zzh(this.zzf);
            zzb6.zza(zzaff.zzn(bArr, 0, this.zzb));
            return new zzjo((zzbi) zzcq.zzf(this.zza, (zzqd) zzb6.zzi(), zzbi.class));
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
