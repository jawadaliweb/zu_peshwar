package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zziz implements zzbj {
    private static final byte[] zza = new byte[0];
    private final zzjc zzb;
    private final zzjb zzc;
    private final zzix zzd;
    private final int zze;
    private final zziw zzf;

    private zziz(zzjc zzjc, zzjb zzjb, zziw zziw, zzix zzix, int i) {
        this.zzb = zzjc;
        this.zzc = zzjb;
        this.zzf = zziw;
        this.zzd = zzix;
        this.zze = i;
    }

    static zziz zzb(zzsh zzsh) throws GeneralSecurityException {
        int i;
        zzjc zzjc;
        if (!zzsh.zzk()) {
            throw new IllegalArgumentException("HpkePrivateKey is missing public_key field.");
        } else if (!zzsh.zze().zzl()) {
            throw new IllegalArgumentException("HpkePrivateKey.public_key is missing params field.");
        } else if (!zzsh.zzf().zzp()) {
            zzse zzb2 = zzsh.zze().zzb();
            zzjb zzb3 = zzjd.zzb(zzb2);
            zziw zzc2 = zzjd.zzc(zzb2);
            zzix zza2 = zzjd.zza(zzb2);
            int zzf2 = zzb2.zzf();
            int i2 = zzf2 - 2;
            if (i2 == 1) {
                i = 32;
            } else if (i2 == 2) {
                i = 65;
            } else if (i2 == 3) {
                i = 97;
            } else if (i2 == 4) {
                i = 133;
            } else {
                throw new IllegalArgumentException("Unable to determine KEM-encoding length for ".concat(zzry.zza(zzf2)));
            }
            int zzf3 = zzsh.zze().zzb().zzf() - 2;
            if (zzf3 == 1) {
                zzjc = zzjn.zzc(zzsh.zzf().zzq());
            } else if (zzf3 == 2 || zzf3 == 3 || zzf3 == 4) {
                zzjc = zzjl.zzc(zzsh.zzf().zzq(), zzsh.zze().zzg().zzq(), zzjj.zzg(zzsh.zze().zzb().zzf()));
            } else {
                throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
            }
            return new zziz(zzjc, zzb3, zzc2, zza2, i);
        } else {
            throw new IllegalArgumentException("HpkePrivateKey.private_key is empty.");
        }
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zze;
        if (length >= i) {
            byte[] copyOf = Arrays.copyOf(bArr, i);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, this.zze, length);
            zzjc zzjc = this.zzb;
            zzjb zzjb = this.zzc;
            zziw zziw = this.zzf;
            zzix zzix = this.zzd;
            return zziy.zzb(copyOf, zzjb.zza(copyOf, zzjc), zzjb, zziw, zzix, new byte[0]).zza(copyOfRange, zza);
        }
        throw new GeneralSecurityException("Ciphertext is too short.");
    }
}
