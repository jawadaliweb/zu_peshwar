package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzvn implements zzoh {
    private final SecretKey zza;
    private final byte[] zzb;
    private final byte[] zzc;

    public zzvn(byte[] bArr) throws GeneralSecurityException {
        zzvu.zzb(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zza = secretKeySpec;
        Cipher zzb2 = zzb();
        zzb2.init(1, secretKeySpec);
        byte[] zzb3 = zznu.zzb(zzb2.doFinal(new byte[16]));
        this.zzb = zzb3;
        this.zzc = zznu.zzb(zzb3);
    }

    private static Cipher zzb() throws GeneralSecurityException {
        if (zzhj.zza(1)) {
            return (Cipher) zzvc.zza.zza("AES/ECB/NoPadding");
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        byte[] bArr2;
        if (i <= 16) {
            Cipher zzb2 = zzb();
            zzb2.init(1, this.zza);
            int length = bArr.length;
            int max = Math.max(1, (int) Math.ceil(((double) length) / 16.0d));
            if (max * 16 == length) {
                bArr2 = zzum.zzd(bArr, (max - 1) * 16, this.zzb, 0, 16);
            } else {
                bArr2 = zzum.zzc(zznu.zza(Arrays.copyOfRange(bArr, (max - 1) * 16, length)), this.zzc);
            }
            byte[] bArr3 = new byte[16];
            for (int i2 = 0; i2 < max - 1; i2++) {
                bArr3 = zzb2.doFinal(zzum.zzd(bArr3, 0, bArr, i2 * 16, 16));
            }
            return Arrays.copyOf(zzb2.doFinal(zzum.zzc(bArr2, bArr3)), i);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
