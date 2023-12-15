package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzek  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final /* synthetic */ class zzek implements zzka {
    public static final /* synthetic */ zzek zza = new zzek();

    private /* synthetic */ zzek() {
    }

    public final zzbl zza(zzlp zzlp, zzcr zzcr) {
        zzee zzee;
        int i = zzel.zza;
        if (((zzln) zzlp).zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzpi zzd = zzpi.zzd(((zzln) zzlp).zze(), zzafx.zza());
                if (zzd.zza() == 0) {
                    zzed zzed = new zzed((zzec) null);
                    zzed.zzb(zzd.zzf().zzd());
                    zzed.zza(zzd.zze().zza());
                    zzed.zzc(16);
                    zztv zzc = ((zzln) zzlp).zzc();
                    zztv zztv = zztv.UNKNOWN_PREFIX;
                    int ordinal = zzc.ordinal();
                    if (ordinal != 1) {
                        if (ordinal != 2) {
                            if (ordinal == 3) {
                                zzee = zzee.zzc;
                            } else if (ordinal != 4) {
                                int zza2 = zzc.zza();
                                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
                            }
                        }
                        zzee = zzee.zzb;
                    } else {
                        zzee = zzee.zza;
                    }
                    zzed.zzd(zzee);
                    zzeg zze = zzed.zze();
                    zzdw zzdw = new zzdw((zzdv) null);
                    zzdw.zzc(zze);
                    zzdw.zzb(zzvy.zzb(zzd.zzf().zzq(), zzcr));
                    zzdw.zza(((zzln) zzlp).zzf());
                    return zzdw.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzags unused) {
                throw new GeneralSecurityException("Parsing AesEaxcKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxParameters.parseParameters");
        }
    }
}
