package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final /* synthetic */ class zznm implements zzka {
    public static final /* synthetic */ zznm zza = new zznm();

    private /* synthetic */ zznm() {
    }

    public final zzbl zza(zzlp zzlp, zzcr zzcr) {
        zznf zznf;
        zzng zzng;
        int i = zznn.zza;
        if (((zzln) zzlp).zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzrq zze = zzrq.zze(((zzln) zzlp).zze(), zzafx.zza());
                if (zze.zza() == 0) {
                    zzne zzne = new zzne((zznd) null);
                    zzne.zzb(zze.zzg().zzd());
                    zzne.zzc(zze.zzf().zza());
                    int zzf = zze.zzf().zzf();
                    zztv zztv = zztv.UNKNOWN_PREFIX;
                    int i2 = zzf - 2;
                    if (i2 == 1) {
                        zznf = zznf.zza;
                    } else if (i2 == 2) {
                        zznf = zznf.zzd;
                    } else if (i2 == 3) {
                        zznf = zznf.zzc;
                    } else if (i2 == 4) {
                        zznf = zznf.zze;
                    } else if (i2 == 5) {
                        zznf = zznf.zzb;
                    } else {
                        throw new GeneralSecurityException("Unable to parse HashType: " + zzrn.zza(zzf));
                    }
                    zzne.zza(zznf);
                    zztv zzc = ((zzln) zzlp).zzc();
                    int ordinal = zzc.ordinal();
                    if (ordinal == 1) {
                        zzng = zzng.zza;
                    } else if (ordinal == 2) {
                        zzng = zzng.zzc;
                    } else if (ordinal == 3) {
                        zzng = zzng.zzd;
                    } else if (ordinal == 4) {
                        zzng = zzng.zzb;
                    } else {
                        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzc.zza());
                    }
                    zzne.zzd(zzng);
                    zzni zze2 = zzne.zze();
                    zzmw zzmw = new zzmw((zzmv) null);
                    zzmw.zzc(zze2);
                    zzmw.zzb(zzvy.zzb(zze.zzg().zzq(), zzcr));
                    zzmw.zza(((zzln) zzlp).zzf());
                    return zzmw.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzags | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing HmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
    }
}
