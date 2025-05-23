package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzif  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzif implements zzbi {
    private final zzcl zza;
    private final zzoa zzb;
    private final zzoa zzc;

    public zzif(zzcl zzcl) {
        zzoa zzoa;
        this.zza = zzcl;
        if (zzcl.zzf()) {
            zzob zzb2 = zzkr.zza().zzb();
            zzog zza2 = zzko.zza(zzcl);
            this.zzb = zzb2.zza(zza2, "daead", "encrypt");
            zzoa = zzb2.zza(zza2, "daead", "decrypt");
        } else {
            zzoa = zzko.zza;
            this.zzb = zzoa;
        }
        this.zzc = zzoa;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, length);
            for (zzch zzch : this.zza.zze(copyOf)) {
                try {
                    byte[] zza2 = ((zzbi) zzch.zze()).zza(copyOfRange, bArr2);
                    zzch.zza();
                    int length2 = copyOfRange.length;
                    return zza2;
                } catch (GeneralSecurityException e) {
                    zzig.zza.logp(Level.INFO, "com.google.crypto.tink.daead.DeterministicAeadWrapper$WrappedDeterministicAead", "decryptDeterministically", "ciphertext prefix matches a key, but cannot decrypt: ".concat(e.toString()));
                }
            }
        }
        for (zzch zzch2 : this.zza.zze(zzbh.zza)) {
            try {
                byte[] zza3 = ((zzbi) zzch2.zze()).zza(bArr, bArr2);
                zzch2.zza();
                int length3 = bArr.length;
                return zza3;
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
