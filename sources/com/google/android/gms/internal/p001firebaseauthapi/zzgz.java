package com.google.android.gms.internal.p001firebaseauthapi;

import android.os.Build;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzgz {
    private static final ThreadLocal zza = new zzgy();
    private final SecretKey zzb;
    private final boolean zzc;

    public zzgz(byte[] bArr, boolean z) throws GeneralSecurityException {
        if (zzhj.zza(2)) {
            zzvu.zzb(bArr.length);
            this.zzb = new SecretKeySpec(bArr, "AES");
            this.zzc = z;
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        AlgorithmParameterSpec algorithmParameterSpec;
        int i = 12;
        if (bArr.length == 12) {
            boolean z = this.zzc;
            int i2 = true != z ? 16 : 28;
            int length = bArr2.length;
            if (length < i2) {
                throw new GeneralSecurityException("ciphertext too short");
            } else if (!z || ByteBuffer.wrap(bArr).equals(ByteBuffer.wrap(bArr2, 0, 12))) {
                String property = System.getProperty("java.vendor");
                Integer num = null;
                if (property == "The Android Project" || (property != null && property.equals("The Android Project"))) {
                    num = Integer.valueOf(Build.VERSION.SDK_INT);
                }
                if (num == null || num.intValue() > 19) {
                    algorithmParameterSpec = new GCMParameterSpec(128, bArr, 0, 12);
                } else {
                    algorithmParameterSpec = new IvParameterSpec(bArr, 0, 12);
                }
                ThreadLocal threadLocal = zza;
                ((Cipher) threadLocal.get()).init(2, this.zzb, algorithmParameterSpec);
                boolean z2 = this.zzc;
                if (true != z2) {
                    i = 0;
                }
                if (z2) {
                    length -= 12;
                }
                return ((Cipher) threadLocal.get()).doFinal(bArr2, i, length);
            } else {
                throw new GeneralSecurityException("iv does not match prepended iv");
            }
        } else {
            throw new GeneralSecurityException("iv is wrong size");
        }
    }
}
