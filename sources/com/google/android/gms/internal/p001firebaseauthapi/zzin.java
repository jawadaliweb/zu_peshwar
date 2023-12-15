package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzin  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzin implements zzbj {
    private final zzcl zza;
    private final zzoa zzb;

    public zzin(zzcl zzcl) {
        this.zza = zzcl;
        this.zzb = zzcl.zzf() ? zzkr.zza().zzb().zza(zzko.zza(zzcl), "hybrid_decrypt", "decrypt") : zzko.zza;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, length);
            for (zzch zzch : this.zza.zze(copyOfRange)) {
                try {
                    byte[] zza2 = ((zzbj) zzch.zze()).zza(copyOfRange2, (byte[]) null);
                    zzch.zza();
                    int length2 = copyOfRange2.length;
                    return zza2;
                } catch (GeneralSecurityException e) {
                    zzio.zza.logp(Level.INFO, "com.google.crypto.tink.hybrid.HybridDecryptWrapper$WrappedHybridDecrypt", "decrypt", "ciphertext prefix matches a key, but cannot decrypt: ".concat(String.valueOf(e.toString())));
                }
            }
        }
        for (zzch zzch2 : this.zza.zze(zzbh.zza)) {
            try {
                byte[] zza3 = ((zzbj) zzch2.zze()).zza(bArr, (byte[]) null);
                zzch2.zza();
                int length3 = bArr.length;
                return zza3;
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
