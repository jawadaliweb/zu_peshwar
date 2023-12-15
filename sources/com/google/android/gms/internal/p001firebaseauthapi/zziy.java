package com.google.android.gms.internal.p001firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zziy {
    private static final byte[] zza = new byte[0];
    private final zzix zzb;
    private final BigInteger zzc;
    private final byte[] zzd;
    private final byte[] zze;
    private final byte[] zzf;
    private BigInteger zzg = BigInteger.ZERO;

    private zziy(byte[] bArr, byte[] bArr2, byte[] bArr3, BigInteger bigInteger, zzix zzix) {
        this.zzf = bArr;
        this.zzd = bArr2;
        this.zze = bArr3;
        this.zzc = bigInteger;
        this.zzb = zzix;
    }

    static zziy zzb(byte[] bArr, byte[] bArr2, zzjb zzjb, zziw zziw, zzix zzix, byte[] bArr3) throws GeneralSecurityException {
        zziw zziw2 = zziw;
        byte[] zzb2 = zzjj.zzb(zzjb.zzb(), zziw.zzc(), zzix.zzb());
        byte[] bArr4 = zzjj.zzl;
        byte[] bArr5 = zza;
        byte[] zzb3 = zzum.zzb(zzjj.zza, zziw2.zze(bArr4, bArr5, "psk_id_hash", zzb2), zziw2.zze(zzjj.zzl, bArr3, "info_hash", zzb2));
        zziw zziw3 = zziw;
        byte[] zze2 = zziw2.zze(bArr2, bArr5, "secret", zzb2);
        byte[] bArr6 = zzb3;
        byte[] bArr7 = zzb2;
        return new zziy(bArr, zziw3.zzd(zze2, bArr6, "key", bArr7, zzix.zza()), zziw3.zzd(zze2, bArr6, "base_nonce", bArr7, 12), BigInteger.ONE.shiftLeft(96).subtract(BigInteger.ONE), zzix);
    }

    private final synchronized byte[] zzc() throws GeneralSecurityException {
        byte[] zzc2;
        byte[] bArr = this.zze;
        BigInteger bigInteger = this.zzg;
        if (bigInteger.signum() != -1) {
            byte[] byteArray = bigInteger.toByteArray();
            int length = byteArray.length;
            if (length != 12) {
                if (length > 13) {
                    throw new GeneralSecurityException("integer too large");
                } else if (length != 13) {
                    byte[] bArr2 = new byte[12];
                    System.arraycopy(byteArray, 0, bArr2, 12 - length, length);
                    byteArray = bArr2;
                } else if (byteArray[0] == 0) {
                    byteArray = Arrays.copyOfRange(byteArray, 1, 13);
                } else {
                    throw new GeneralSecurityException("integer too large");
                }
            }
            zzc2 = zzum.zzc(bArr, byteArray);
            if (this.zzg.compareTo(this.zzc) < 0) {
                this.zzg = this.zzg.add(BigInteger.ONE);
            } else {
                throw new GeneralSecurityException("message limit reached");
            }
        } else {
            throw new IllegalArgumentException("integer must be nonnegative");
        }
        return zzc2;
    }

    /* access modifiers changed from: package-private */
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return this.zzb.zzc(this.zzd, zzc(), bArr, bArr2);
    }
}
