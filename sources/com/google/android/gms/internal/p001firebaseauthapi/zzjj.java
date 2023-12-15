package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzjj {
    public static final byte[] zza = zzc(1, 0);
    public static final byte[] zzb = zzc(2, 32);
    public static final byte[] zzc = zzc(2, 16);
    public static final byte[] zzd = zzc(2, 17);
    public static final byte[] zze = zzc(2, 18);
    public static final byte[] zzf = zzc(2, 1);
    public static final byte[] zzg = zzc(2, 2);
    public static final byte[] zzh = zzc(2, 3);
    public static final byte[] zzi = zzc(2, 1);
    public static final byte[] zzj = zzc(2, 2);
    public static final byte[] zzk = zzc(2, 3);
    public static final byte[] zzl = new byte[0];
    private static final byte[] zzm = "KEM".getBytes(zzly.zza);
    private static final byte[] zzn = "HPKE".getBytes(zzly.zza);
    private static final byte[] zzo = "HPKE-v1".getBytes(zzly.zza);

    static void zza(zzse zzse) throws GeneralSecurityException {
        if (zzse.zzf() == 2 || zzse.zzf() == 1) {
            throw new GeneralSecurityException("Invalid KEM param: ".concat(zzry.zza(zzse.zzf())));
        }
        String str = "UNRECOGNIZED";
        if (zzse.zze() == 2 || zzse.zze() == 1) {
            int zze2 = zzse.zze();
            if (zze2 == 2) {
                str = "KDF_UNKNOWN";
            } else if (zze2 == 3) {
                str = "HKDF_SHA256";
            } else if (zze2 == 4) {
                str = "HKDF_SHA384";
            } else if (zze2 == 5) {
                str = "HKDF_SHA512";
            }
            throw new GeneralSecurityException("Invalid KDF param: ".concat(str));
        } else if (zzse.zzd() == 2 || zzse.zzd() == 1) {
            int zzd2 = zzse.zzd();
            if (zzd2 == 2) {
                str = "AEAD_UNKNOWN";
            } else if (zzd2 == 3) {
                str = "AES_128_GCM";
            } else if (zzd2 == 4) {
                str = "AES_256_GCM";
            } else if (zzd2 == 5) {
                str = "CHACHA20_POLY1305";
            }
            throw new GeneralSecurityException("Invalid AEAD param: ".concat(str));
        }
    }

    static byte[] zzb(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return zzum.zzb(zzn, bArr, bArr2, bArr3);
    }

    public static byte[] zzc(int i, int i2) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((i2 >> (((i - i3) - 1) * 8)) & 255);
        }
        return bArr;
    }

    static byte[] zzd(byte[] bArr) throws GeneralSecurityException {
        return zzum.zzb(zzm, bArr);
    }

    static byte[] zze(String str, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzum.zzb(zzo, bArr2, str.getBytes(zzly.zza), bArr);
    }

    static byte[] zzf(String str, byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        return zzum.zzb(zzc(2, i), zzo, bArr2, str.getBytes(zzly.zza), bArr);
    }

    static int zzg(int i) throws GeneralSecurityException {
        int i2 = i - 2;
        if (i2 == 2) {
            return 1;
        }
        if (i2 == 3) {
            return 2;
        }
        if (i2 == 4) {
            return 3;
        }
        throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
    }
}
