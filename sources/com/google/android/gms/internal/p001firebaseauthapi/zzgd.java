package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final /* synthetic */ class zzgd implements zzka {
    public static final /* synthetic */ zzgd zza = new zzgd();

    private /* synthetic */ zzgd() {
    }

    public final zzbl zza(zzlp zzlp, zzcr zzcr) {
        zzfy zzfy;
        int i = zzge.zza;
        if (((zzln) zzlp).zzg().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzqj zzd = zzqj.zzd(((zzln) zzlp).zze(), zzafx.zza());
                if (zzd.zza() == 0) {
                    zztv zzc = ((zzln) zzlp).zzc();
                    zztv zztv = zztv.UNKNOWN_PREFIX;
                    int ordinal = zzc.ordinal();
                    if (ordinal != 1) {
                        if (ordinal != 2) {
                            if (ordinal == 3) {
                                zzfy = zzfy.zzc;
                            } else if (ordinal != 4) {
                                int zza2 = zzc.zza();
                                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
                            }
                        }
                        zzfy = zzfy.zzb;
                    } else {
                        zzfy = zzfy.zza;
                    }
                    return zzfu.zza(zzfy, zzvy.zzb(zzd.zze().zzq(), zzcr), ((zzln) zzlp).zzf());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzags unused) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305Parameters.parseParameters");
        }
    }
}
