package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfs  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final /* synthetic */ class zzfs implements zzka {
    public static final /* synthetic */ zzfs zza = new zzfs();

    private /* synthetic */ zzfs() {
    }

    public final zzbl zza(zzlp zzlp, zzcr zzcr) {
        zzfm zzfm;
        int i = zzft.zza;
        if (((zzln) zzlp).zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzpx zzd = zzpx.zzd(((zzln) zzlp).zze(), zzafx.zza());
                if (zzd.zza() == 0) {
                    zzfl zzfl = new zzfl((zzfk) null);
                    zzfl.zza(zzd.zze().zzd());
                    zztv zzc = ((zzln) zzlp).zzc();
                    zztv zztv = zztv.UNKNOWN_PREFIX;
                    int ordinal = zzc.ordinal();
                    if (ordinal != 1) {
                        if (ordinal != 2) {
                            if (ordinal == 3) {
                                zzfm = zzfm.zzc;
                            } else if (ordinal != 4) {
                                int zza2 = zzc.zza();
                                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
                            }
                        }
                        zzfm = zzfm.zzb;
                    } else {
                        zzfm = zzfm.zza;
                    }
                    zzfl.zzb(zzfm);
                    zzfo zzc2 = zzfl.zzc();
                    zzfe zzfe = new zzfe((zzfd) null);
                    zzfe.zzc(zzc2);
                    zzfe.zzb(zzvy.zzb(zzd.zze().zzq(), zzcr));
                    zzfe.zza(((zzln) zzlp).zzf());
                    return zzfe.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzags unused) {
                throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivParameters.parseParameters");
        }
    }
}
