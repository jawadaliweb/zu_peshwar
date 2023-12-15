package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final /* synthetic */ class zzmp implements zzka {
    public static final /* synthetic */ zzmp zza = new zzmp();

    private /* synthetic */ zzmp() {
    }

    public final zzbl zza(zzlp zzlp, zzcr zzcr) {
        zzmj zzmj;
        int i = zzmq.zza;
        if (((zzln) zzlp).zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzok zzd = zzok.zzd(((zzln) zzlp).zze(), zzafx.zza());
                if (zzd.zza() == 0) {
                    zzmi zzmi = new zzmi((zzmh) null);
                    zzmi.zza(zzd.zzf().zzd());
                    zzmi.zzb(zzd.zze().zza());
                    zztv zzc = ((zzln) zzlp).zzc();
                    zztv zztv = zztv.UNKNOWN_PREFIX;
                    int ordinal = zzc.ordinal();
                    if (ordinal == 1) {
                        zzmj = zzmj.zza;
                    } else if (ordinal == 2) {
                        zzmj = zzmj.zzc;
                    } else if (ordinal == 3) {
                        zzmj = zzmj.zzd;
                    } else if (ordinal == 4) {
                        zzmj = zzmj.zzb;
                    } else {
                        int zza2 = zzc.zza();
                        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
                    }
                    zzmi.zzc(zzmj);
                    zzml zzd2 = zzmi.zzd();
                    zzma zzma = new zzma((zzlz) null);
                    zzma.zzc(zzd2);
                    zzma.zza(zzvy.zzb(zzd.zzf().zzq(), zzcr));
                    zzma.zzb(((zzln) zzlp).zzf());
                    return zzma.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzags | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing AesCmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters");
        }
    }
}
