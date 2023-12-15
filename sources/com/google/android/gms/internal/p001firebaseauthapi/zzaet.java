package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaet  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaet {
    static int zza(byte[] bArr, int i, zzaes zzaes) throws zzags {
        int zzj = zzj(bArr, i, zzaes);
        int i2 = zzaes.zza;
        if (i2 < 0) {
            throw zzags.zzf();
        } else if (i2 > bArr.length - zzj) {
            throw zzags.zzj();
        } else if (i2 == 0) {
            zzaes.zzc = zzaff.zzb;
            return zzj;
        } else {
            zzaes.zzc = zzaff.zzn(bArr, zzj, i2);
            return zzj + i2;
        }
    }

    static int zzb(byte[] bArr, int i) {
        byte b = bArr[i] & UByte.MAX_VALUE;
        byte b2 = bArr[i + 1] & UByte.MAX_VALUE;
        byte b3 = bArr[i + 2] & UByte.MAX_VALUE;
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (b2 << 8) | b | (b3 << 16);
    }

    static int zzc(zzaib zzaib, byte[] bArr, int i, int i2, int i3, zzaes zzaes) throws IOException {
        Object zze = zzaib.zze();
        int zzn = zzn(zze, zzaib, bArr, i, i2, i3, zzaes);
        zzaib.zzf(zze);
        zzaes.zzc = zze;
        return zzn;
    }

    static int zzd(zzaib zzaib, byte[] bArr, int i, int i2, zzaes zzaes) throws IOException {
        Object zze = zzaib.zze();
        int zzo = zzo(zze, zzaib, bArr, i, i2, zzaes);
        zzaib.zzf(zze);
        zzaes.zzc = zze;
        return zzo;
    }

    static int zze(zzaib zzaib, int i, byte[] bArr, int i2, int i3, zzagp zzagp, zzaes zzaes) throws IOException {
        int zzd = zzd(zzaib, bArr, i2, i3, zzaes);
        zzagp.add(zzaes.zzc);
        while (zzd < i3) {
            int zzj = zzj(bArr, zzd, zzaes);
            if (i != zzaes.zza) {
                break;
            }
            zzd = zzd(zzaib, bArr, zzj, i3, zzaes);
            zzagp.add(zzaes.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i, zzagp zzagp, zzaes zzaes) throws IOException {
        zzagl zzagl = (zzagl) zzagp;
        int zzj = zzj(bArr, i, zzaes);
        int i2 = zzaes.zza + zzj;
        while (zzj < i2) {
            zzj = zzj(bArr, zzj, zzaes);
            zzagl.zzf(zzaes.zza);
        }
        if (zzj == i2) {
            return zzj;
        }
        throw zzags.zzj();
    }

    static int zzg(byte[] bArr, int i, zzaes zzaes) throws zzags {
        int zzj = zzj(bArr, i, zzaes);
        int i2 = zzaes.zza;
        if (i2 < 0) {
            throw zzags.zzf();
        } else if (i2 == 0) {
            zzaes.zzc = "";
            return zzj;
        } else {
            zzaes.zzc = new String(bArr, zzj, i2, zzagq.zzb);
            return zzj + i2;
        }
    }

    static int zzh(byte[] bArr, int i, zzaes zzaes) throws zzags {
        int zzj = zzj(bArr, i, zzaes);
        int i2 = zzaes.zza;
        if (i2 < 0) {
            throw zzags.zzf();
        } else if (i2 == 0) {
            zzaes.zzc = "";
            return zzj;
        } else {
            zzaes.zzc = zzajk.zzd(bArr, zzj, i2);
            return zzj + i2;
        }
    }

    static int zzi(int i, byte[] bArr, int i2, int i3, zzaiw zzaiw, zzaes zzaes) throws zzags {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzm = zzm(bArr, i2, zzaes);
                zzaiw.zzj(i, Long.valueOf(zzaes.zzb));
                return zzm;
            } else if (i4 == 1) {
                zzaiw.zzj(i, Long.valueOf(zzp(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzj = zzj(bArr, i2, zzaes);
                int i5 = zzaes.zza;
                if (i5 < 0) {
                    throw zzags.zzf();
                } else if (i5 <= bArr.length - zzj) {
                    if (i5 == 0) {
                        zzaiw.zzj(i, zzaff.zzb);
                    } else {
                        zzaiw.zzj(i, zzaff.zzn(bArr, zzj, i5));
                    }
                    return zzj + i5;
                } else {
                    throw zzags.zzj();
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                zzaiw zzf = zzaiw.zzf();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i2, zzaes);
                    int i8 = zzaes.zza;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zzj2;
                        break;
                    }
                    int zzi = zzi(i7, bArr, zzj2, i3, zzf, zzaes);
                    i7 = i8;
                    i2 = zzi;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzags.zzg();
                }
                zzaiw.zzj(i, zzf);
                return i2;
            } else if (i4 == 5) {
                zzaiw.zzj(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzags.zzc();
            }
        } else {
            throw zzags.zzc();
        }
    }

    static int zzj(byte[] bArr, int i, zzaes zzaes) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzaes);
        }
        zzaes.zza = b;
        return i2;
    }

    static int zzk(int i, byte[] bArr, int i2, zzaes zzaes) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzaes.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i6 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzaes.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & ByteCompanionObject.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzaes.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & ByteCompanionObject.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzaes.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzaes.zza = i11;
                return i12;
            }
        }
    }

    static int zzl(int i, byte[] bArr, int i2, int i3, zzagp zzagp, zzaes zzaes) {
        zzagl zzagl = (zzagl) zzagp;
        int zzj = zzj(bArr, i2, zzaes);
        zzagl.zzf(zzaes.zza);
        while (zzj < i3) {
            int zzj2 = zzj(bArr, zzj, zzaes);
            if (i != zzaes.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzaes);
            zzagl.zzf(zzaes.zza);
        }
        return zzj;
    }

    static int zzm(byte[] bArr, int i, zzaes zzaes) {
        long j = (long) bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzaes.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & ByteCompanionObject.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & ByteCompanionObject.MAX_VALUE)) << i4;
            byte b3 = b2;
            i3 = i5;
            b = b3;
        }
        zzaes.zzb = j2;
        return i3;
    }

    static int zzn(Object obj, zzaib zzaib, byte[] bArr, int i, int i2, int i3, zzaes zzaes) throws IOException {
        int zzc = ((zzahs) zzaib).zzc(obj, bArr, i, i2, i3, zzaes);
        zzaes.zzc = obj;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzo(java.lang.Object r6, com.google.android.gms.internal.p001firebaseauthapi.zzaib r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.p001firebaseauthapi.zzaes r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zzk(r9, r8, r0, r11)
            int r9 = r11.zza
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x001e
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x001e
            int r9 = r9 + r3
            r0 = r7
            r1 = r6
            r2 = r8
            r4 = r9
            r5 = r11
            r0.zzi(r1, r2, r3, r4, r5)
            r11.zzc = r6
            return r9
        L_0x001e:
            com.google.android.gms.internal.firebase-auth-api.zzags r6 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzj()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzo(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzaib, byte[], int, int, com.google.android.gms.internal.firebase-auth-api.zzaes):int");
    }

    static long zzp(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }
}
