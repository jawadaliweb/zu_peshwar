package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final /* synthetic */ class zzgv implements zzka {
    public static final /* synthetic */ zzgv zza = new zzgv();

    private /* synthetic */ zzgv() {
    }

    public final zzbl zza(zzlp zzlp, zzcr zzcr) {
        zzgq zzgq;
        int i = zzgw.zza;
        if (((zzln) zzlp).zzg().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                zzub zzd = zzub.zzd(((zzln) zzlp).zze(), zzafx.zza());
                if (zzd.zza() == 0) {
                    zztv zzc = ((zzln) zzlp).zzc();
                    zztv zztv = zztv.UNKNOWN_PREFIX;
                    int ordinal = zzc.ordinal();
                    if (ordinal != 1) {
                        if (ordinal != 2) {
                            if (ordinal == 3) {
                                zzgq = zzgq.zzc;
                            } else if (ordinal != 4) {
                                int zza2 = zzc.zza();
                                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
                            }
                        }
                        zzgq = zzgq.zzb;
                    } else {
                        zzgq = zzgq.zza;
                    }
                    return zzgm.zza(zzgq, zzvy.zzb(zzd.zze().zzq(), zzcr), ((zzln) zzlp).zzf());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzags unused) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305Parameters.parseParameters");
        }
    }
}
