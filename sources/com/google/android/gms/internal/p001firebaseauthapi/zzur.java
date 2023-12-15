package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzur  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzur {
    private final ECPrivateKey zza;

    public zzur(ECPrivateKey eCPrivateKey) {
        this.zza = eCPrivateKey;
    }

    public final byte[] zza(byte[] bArr, String str, byte[] bArr2, byte[] bArr3, int i, int i2) throws GeneralSecurityException {
        int i3 = 1;
        byte[] zzb = zzum.zzb(bArr, zzut.zzf(this.zza, zzut.zzh(this.zza.getParams(), i2, bArr)));
        Mac mac = (Mac) zzvc.zzb.zza(str);
        if (i <= mac.getMacLength() * 255) {
            if (bArr2 == null || bArr2.length == 0) {
                mac.init(new SecretKeySpec(new byte[mac.getMacLength()], str));
            } else {
                mac.init(new SecretKeySpec(bArr2, str));
            }
            byte[] doFinal = mac.doFinal(zzb);
            byte[] bArr4 = new byte[i];
            mac.init(new SecretKeySpec(doFinal, str));
            byte[] bArr5 = new byte[0];
            int i4 = 0;
            while (true) {
                mac.update(bArr5);
                mac.update((byte[]) null);
                mac.update((byte) i3);
                bArr5 = mac.doFinal();
                int length = bArr5.length;
                int i5 = i4 + length;
                if (i5 < i) {
                    System.arraycopy(bArr5, 0, bArr4, i4, length);
                    i3++;
                    i4 = i5;
                } else {
                    System.arraycopy(bArr5, 0, bArr4, i4, i - i4);
                    return bArr4;
                }
            }
        } else {
            throw new GeneralSecurityException("size too large");
        }
    }
}
