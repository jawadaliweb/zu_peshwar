package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzul  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzul implements zzbi {
    private static final Collection zza = Arrays.asList(new Integer[]{64});
    private static final byte[] zzb = new byte[16];
    private final zzvn zzc;
    private final byte[] zzd;

    public zzul(byte[] bArr) throws GeneralSecurityException {
        if (zzhj.zza(1)) {
            Collection collection = zza;
            int length = bArr.length;
            if (collection.contains(Integer.valueOf(length))) {
                int i = length >> 1;
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, i);
                this.zzd = Arrays.copyOfRange(bArr, i, length);
                this.zzc = new zzvn(copyOfRange);
                return;
            }
            throw new InvalidKeyException("invalid key size: " + length + " bytes; key must have 64 bytes");
        }
        throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        int length = bArr.length;
        if (length >= 16) {
            Cipher cipher = (Cipher) zzvc.zza.zza("AES/CTR/NoPadding");
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 16);
            byte[] bArr4 = (byte[]) copyOfRange.clone();
            bArr4[8] = (byte) (bArr4[8] & ByteCompanionObject.MAX_VALUE);
            bArr4[12] = (byte) (bArr4[12] & ByteCompanionObject.MAX_VALUE);
            cipher.init(2, new SecretKeySpec(this.zzd, "AES"), new IvParameterSpec(bArr4));
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 16, length);
            byte[] doFinal = cipher.doFinal(copyOfRange2);
            if (copyOfRange2.length == 0 && doFinal == null && zzvt.zza()) {
                doFinal = new byte[0];
            }
            byte[][] bArr5 = {bArr2, doFinal};
            byte[] zza2 = this.zzc.zza(zzb, 16);
            for (int i = 0; i <= 0; i++) {
                byte[] bArr6 = bArr5[i];
                if (bArr6 == null) {
                    bArr6 = new byte[0];
                }
                zza2 = zzum.zzc(zznu.zzb(zza2), this.zzc.zza(bArr6, 16));
            }
            byte[] bArr7 = bArr5[1];
            int length2 = bArr7.length;
            if (length2 >= 16) {
                int length3 = zza2.length;
                if (length2 >= length3) {
                    bArr3 = Arrays.copyOf(bArr7, length2);
                    for (int i2 = 0; i2 < zza2.length; i2++) {
                        int i3 = (length2 - length3) + i2;
                        bArr3[i3] = (byte) (bArr3[i3] ^ zza2[i2]);
                    }
                } else {
                    throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
                }
            } else {
                bArr3 = zzum.zzc(zznu.zza(bArr7), zznu.zzb(zza2));
            }
            if (MessageDigest.isEqual(copyOfRange, this.zzc.zza(bArr3, 16))) {
                return doFinal;
            }
            throw new AEADBadTagException("Integrity check failed.");
        }
        throw new GeneralSecurityException("Ciphertext too short.");
    }
}
