package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final /* synthetic */ class zzfb implements zzka {
    public static final /* synthetic */ zzfb zza = new zzfb();

    private /* synthetic */ zzfb() {
    }

    public final zzbl zza(zzlp zzlp, zzcr zzcr) {
        zzev zzev;
        int i = zzfc.zza;
        if (((zzln) zzlp).zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzpr zzd = zzpr.zzd(((zzln) zzlp).zze(), zzafx.zza());
                if (zzd.zza() == 0) {
                    zzeu zzeu = new zzeu((zzet) null);
                    zzeu.zzb(zzd.zze().zzd());
                    zzeu.zza(12);
                    zzeu.zzc(16);
                    zztv zzc = ((zzln) zzlp).zzc();
                    zztv zztv = zztv.UNKNOWN_PREFIX;
                    int ordinal = zzc.ordinal();
                    if (ordinal != 1) {
                        if (ordinal != 2) {
                            if (ordinal == 3) {
                                zzev = zzev.zzc;
                            } else if (ordinal != 4) {
                                int zza2 = zzc.zza();
                                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
                            }
                        }
                        zzev = zzev.zzb;
                    } else {
                        zzev = zzev.zza;
                    }
                    zzeu.zzd(zzev);
                    zzex zze = zzeu.zze();
                    zzen zzen = new zzen((zzem) null);
                    zzen.zzc(zze);
                    zzen.zzb(zzvy.zzb(zzd.zze().zzq(), zzcr));
                    zzen.zza(((zzln) zzlp).zzf());
                    return zzen.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzags unused) {
                throw new GeneralSecurityException("Parsing AesGcmKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmParameters.parseParameters");
        }
    }
}
