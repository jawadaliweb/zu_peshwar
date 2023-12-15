package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final /* synthetic */ class zzdq implements zzka {
    public static final /* synthetic */ zzdq zza = new zzdq();

    private /* synthetic */ zzdq() {
    }

    public final zzbl zza(zzlp zzlp, zzcr zzcr) {
        zzdj zzdj;
        zzdk zzdk;
        int i = zzdr.zza;
        if (((zzln) zzlp).zzg().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzot zzd = zzot.zzd(((zzln) zzlp).zze(), zzafx.zza());
                if (zzd.zza() == 0) {
                    zzdi zzdi = new zzdi((zzdh) null);
                    zzdi.zza(zzd.zze().zzg().zzd());
                    zzdi.zzc(zzd.zzf().zzg().zzd());
                    zzdi.zzd(zzd.zze().zzf().zza());
                    zzdi.zze(zzd.zzf().zzf().zza());
                    int zzf = zzd.zzf().zzf().zzf();
                    zztv zztv = zztv.UNKNOWN_PREFIX;
                    int i2 = zzf - 2;
                    if (i2 == 1) {
                        zzdj = zzdj.zza;
                    } else if (i2 == 2) {
                        zzdj = zzdj.zzd;
                    } else if (i2 == 3) {
                        zzdj = zzdj.zzc;
                    } else if (i2 == 4) {
                        zzdj = zzdj.zze;
                    } else if (i2 == 5) {
                        zzdj = zzdj.zzb;
                    } else {
                        throw new GeneralSecurityException("Unable to parse HashType: " + zzrn.zza(zzf));
                    }
                    zzdi.zzb(zzdj);
                    zztv zzc = ((zzln) zzlp).zzc();
                    int ordinal = zzc.ordinal();
                    if (ordinal != 1) {
                        if (ordinal != 2) {
                            if (ordinal == 3) {
                                zzdk = zzdk.zzc;
                            } else if (ordinal != 4) {
                                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzc.zza());
                            }
                        }
                        zzdk = zzdk.zzb;
                    } else {
                        zzdk = zzdk.zza;
                    }
                    zzdi.zzf(zzdk);
                    zzdm zzg = zzdi.zzg();
                    zzdb zzdb = new zzdb((zzda) null);
                    zzdb.zzd(zzg);
                    zzdb.zza(zzvy.zzb(zzd.zze().zzg().zzq(), zzcr));
                    zzdb.zzb(zzvy.zzb(zzd.zzf().zzg().zzq(), zzcr));
                    zzdb.zzc(((zzln) zzlp).zzf());
                    return zzdb.zze();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzags unused) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
    }
}
