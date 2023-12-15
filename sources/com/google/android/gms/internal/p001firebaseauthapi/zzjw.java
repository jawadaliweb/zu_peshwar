package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzjw {
    static final byte[][] zza = {new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{-32, -21, 122, 124, 59, 65, -72, -82, 22, 86, -29, -6, -15, -97, -60, 106, -38, 9, -115, -21, -100, TarConstants.LF_SYMLINK, -79, -3, -122, 98, 5, 22, 95, 73, -72, 0}, new byte[]{95, -100, -107, -68, -93, 80, -116, 36, -79, -48, -79, 85, -100, -125, -17, 91, 4, 68, 92, -60, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 28, -114, -122, -40, 34, 78, -35, -48, -97, 17, 87}, new byte[]{-20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, ByteCompanionObject.MAX_VALUE}, new byte[]{-19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, ByteCompanionObject.MAX_VALUE}, new byte[]{-18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, ByteCompanionObject.MAX_VALUE}};

    public static void zza(long[] jArr, byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        long[] jArr2 = jArr;
        byte[] bArr3 = bArr2;
        int i = 32;
        if (bArr3.length == 32) {
            byte[] copyOf = Arrays.copyOf(bArr3, 32);
            copyOf[31] = (byte) (copyOf[31] & ByteCompanionObject.MAX_VALUE);
            int i2 = 0;
            int i3 = 0;
            while (i3 < 7) {
                byte[][] bArr4 = zza;
                if (!MessageDigest.isEqual(bArr4[i3], copyOf)) {
                    i3++;
                } else {
                    throw new InvalidKeyException("Banned public key: ".concat(zzvl.zza(bArr4[i3])));
                }
            }
            long[] zzk = zzjy.zzk(copyOf);
            long[] jArr3 = new long[19];
            long[] jArr4 = new long[19];
            jArr4[0] = 1;
            long[] jArr5 = new long[19];
            jArr5[0] = 1;
            long[] jArr6 = new long[19];
            long[] jArr7 = new long[19];
            long[] jArr8 = new long[19];
            jArr8[0] = 1;
            long[] jArr9 = new long[19];
            long[] jArr10 = new long[19];
            jArr10[0] = 1;
            int i4 = 10;
            System.arraycopy(zzk, 0, jArr3, 0, 10);
            int i5 = 0;
            while (i5 < i) {
                byte b = bArr[(32 - i5) - 1] & UByte.MAX_VALUE;
                while (i2 < 8) {
                    int i6 = (b >> (7 - i2)) & 1;
                    zzb(jArr5, jArr3, i6);
                    zzb(jArr6, jArr4, i6);
                    long[] copyOf2 = Arrays.copyOf(jArr5, i4);
                    byte b2 = b;
                    long[] jArr11 = new long[19];
                    int i7 = i5;
                    long[] jArr12 = new long[19];
                    int i8 = i2;
                    long[] jArr13 = new long[19];
                    int i9 = i6;
                    long[] jArr14 = new long[19];
                    long[] jArr15 = jArr10;
                    long[] jArr16 = new long[19];
                    long[] jArr17 = new long[19];
                    zzjy.zzi(jArr5, jArr5, jArr6);
                    zzjy.zzh(jArr6, copyOf2, jArr6);
                    long[] copyOf3 = Arrays.copyOf(jArr3, 10);
                    zzjy.zzi(jArr3, jArr3, jArr4);
                    zzjy.zzh(jArr4, copyOf3, jArr4);
                    zzjy.zzb(jArr13, jArr3, jArr6);
                    zzjy.zzb(jArr14, jArr5, jArr4);
                    zzjy.zze(jArr13);
                    zzjy.zzd(jArr13);
                    zzjy.zze(jArr14);
                    zzjy.zzd(jArr14);
                    long[] jArr18 = jArr3;
                    System.arraycopy(jArr13, 0, copyOf3, 0, 10);
                    zzjy.zzi(jArr13, jArr13, jArr14);
                    zzjy.zzh(jArr14, copyOf3, jArr14);
                    zzjy.zzg(jArr17, jArr13);
                    zzjy.zzg(jArr16, jArr14);
                    zzjy.zzb(jArr14, jArr16, zzk);
                    zzjy.zze(jArr14);
                    zzjy.zzd(jArr14);
                    System.arraycopy(jArr17, 0, jArr7, 0, 10);
                    System.arraycopy(jArr14, 0, jArr8, 0, 10);
                    zzjy.zzg(jArr11, jArr5);
                    zzjy.zzg(jArr12, jArr6);
                    zzjy.zzb(jArr9, jArr11, jArr12);
                    zzjy.zze(jArr9);
                    zzjy.zzd(jArr9);
                    zzjy.zzh(jArr12, jArr11, jArr12);
                    long[] jArr19 = new long[19];
                    Arrays.fill(jArr19, 10, 18, 0);
                    zzjy.zzf(jArr19, jArr12, 121665);
                    zzjy.zzd(jArr19);
                    zzjy.zzi(jArr19, jArr19, jArr11);
                    long[] jArr20 = jArr15;
                    zzjy.zzb(jArr20, jArr12, jArr19);
                    zzjy.zze(jArr20);
                    zzjy.zzd(jArr20);
                    int i10 = i9;
                    zzb(jArr9, jArr7, i10);
                    zzb(jArr20, jArr8, i10);
                    i2 = i8 + 1;
                    long[] jArr21 = jArr;
                    byte[] bArr5 = bArr2;
                    jArr3 = jArr7;
                    b = b2;
                    i5 = i7;
                    jArr7 = jArr18;
                    i4 = 10;
                    long[] jArr22 = jArr8;
                    jArr8 = jArr4;
                    jArr4 = jArr22;
                    long[] jArr23 = jArr9;
                    jArr9 = jArr5;
                    jArr5 = jArr23;
                    long[] jArr24 = jArr20;
                    jArr10 = jArr6;
                    jArr6 = jArr24;
                }
                long[] jArr25 = jArr3;
                i5++;
                long[] jArr26 = jArr;
                byte[] bArr6 = bArr2;
                i = 32;
                i2 = 0;
                i4 = 10;
            }
            long[] jArr27 = new long[10];
            long[] jArr28 = new long[10];
            long[] jArr29 = new long[10];
            long[] jArr30 = new long[10];
            long[] jArr31 = new long[10];
            long[] jArr32 = new long[10];
            long[] jArr33 = new long[10];
            long[] jArr34 = new long[10];
            long[] jArr35 = new long[10];
            long[] jArr36 = new long[10];
            long[] jArr37 = jArr3;
            long[] jArr38 = new long[10];
            zzjy.zzg(jArr28, jArr6);
            zzjy.zzg(jArr38, jArr28);
            zzjy.zzg(jArr36, jArr38);
            zzjy.zza(jArr29, jArr36, jArr6);
            zzjy.zza(jArr30, jArr29, jArr28);
            zzjy.zzg(jArr36, jArr30);
            zzjy.zza(jArr31, jArr36, jArr29);
            zzjy.zzg(jArr36, jArr31);
            zzjy.zzg(jArr38, jArr36);
            zzjy.zzg(jArr36, jArr38);
            zzjy.zzg(jArr38, jArr36);
            zzjy.zzg(jArr36, jArr38);
            zzjy.zza(jArr32, jArr36, jArr31);
            zzjy.zzg(jArr36, jArr32);
            zzjy.zzg(jArr38, jArr36);
            for (int i11 = 2; i11 < 10; i11 += 2) {
                zzjy.zzg(jArr36, jArr38);
                zzjy.zzg(jArr38, jArr36);
            }
            zzjy.zza(jArr33, jArr38, jArr32);
            zzjy.zzg(jArr36, jArr33);
            zzjy.zzg(jArr38, jArr36);
            for (int i12 = 2; i12 < 20; i12 += 2) {
                zzjy.zzg(jArr36, jArr38);
                zzjy.zzg(jArr38, jArr36);
            }
            zzjy.zza(jArr36, jArr38, jArr33);
            zzjy.zzg(jArr38, jArr36);
            zzjy.zzg(jArr36, jArr38);
            for (int i13 = 2; i13 < 10; i13 += 2) {
                zzjy.zzg(jArr38, jArr36);
                zzjy.zzg(jArr36, jArr38);
            }
            zzjy.zza(jArr34, jArr36, jArr32);
            zzjy.zzg(jArr36, jArr34);
            zzjy.zzg(jArr38, jArr36);
            for (int i14 = 2; i14 < 50; i14 += 2) {
                zzjy.zzg(jArr36, jArr38);
                zzjy.zzg(jArr38, jArr36);
            }
            zzjy.zza(jArr35, jArr38, jArr34);
            zzjy.zzg(jArr38, jArr35);
            zzjy.zzg(jArr36, jArr38);
            for (int i15 = 2; i15 < 100; i15 += 2) {
                zzjy.zzg(jArr38, jArr36);
                zzjy.zzg(jArr36, jArr38);
            }
            zzjy.zza(jArr38, jArr36, jArr35);
            zzjy.zzg(jArr36, jArr38);
            zzjy.zzg(jArr38, jArr36);
            for (int i16 = 2; i16 < 50; i16 += 2) {
                zzjy.zzg(jArr36, jArr38);
                zzjy.zzg(jArr38, jArr36);
            }
            zzjy.zza(jArr36, jArr38, jArr34);
            zzjy.zzg(jArr38, jArr36);
            zzjy.zzg(jArr36, jArr38);
            zzjy.zzg(jArr38, jArr36);
            zzjy.zzg(jArr36, jArr38);
            zzjy.zzg(jArr38, jArr36);
            zzjy.zza(jArr27, jArr38, jArr30);
            long[] jArr39 = jArr;
            zzjy.zza(jArr39, jArr5, jArr27);
            long[] jArr40 = new long[10];
            long[] jArr41 = new long[10];
            long[] jArr42 = new long[11];
            long[] jArr43 = new long[11];
            long[] jArr44 = new long[11];
            zzjy.zza(jArr40, zzk, jArr39);
            zzjy.zzi(jArr41, zzk, jArr39);
            long[] jArr45 = new long[10];
            jArr45[0] = 486662;
            zzjy.zzi(jArr43, jArr41, jArr45);
            zzjy.zza(jArr43, jArr43, jArr4);
            long[] jArr46 = jArr37;
            zzjy.zzi(jArr43, jArr43, jArr46);
            zzjy.zza(jArr43, jArr43, jArr40);
            zzjy.zza(jArr43, jArr43, jArr46);
            zzjy.zzf(jArr42, jArr43, 4);
            zzjy.zzd(jArr42);
            zzjy.zza(jArr43, jArr40, jArr4);
            zzjy.zzh(jArr43, jArr43, jArr4);
            zzjy.zza(jArr44, jArr41, jArr46);
            zzjy.zzi(jArr43, jArr43, jArr44);
            zzjy.zzg(jArr43, jArr43);
            if (!MessageDigest.isEqual(zzjy.zzj(jArr42), zzjy.zzj(jArr43))) {
                throw new IllegalStateException("Arithmetic error in curve multiplication with the public key: ".concat(zzvl.zza(bArr2)));
            }
            return;
        }
        throw new InvalidKeyException("Public key length is not 32-byte");
    }

    static void zzb(long[] jArr, long[] jArr2, int i) {
        for (int i2 = 0; i2 < 10; i2++) {
            int i3 = (int) jArr[i2];
            int i4 = (-i) & (((int) jArr2[i2]) ^ i3);
            jArr[i2] = (long) (i3 ^ i4);
            jArr2[i2] = (long) (i4 ^ ((int) jArr2[i2]));
        }
    }
}
