package com.google.android.recaptcha.internal;

import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzen {
    static int zza(byte[] bArr, int i, zzem zzem) throws zzgy {
        int zzj = zzj(bArr, i, zzem);
        int i2 = zzem.zza;
        if (i2 < 0) {
            throw zzgy.zzf();
        } else if (i2 > bArr.length - zzj) {
            throw zzgy.zzj();
        } else if (i2 == 0) {
            zzem.zzc = zzez.zzb;
            return zzj;
        } else {
            zzem.zzc = zzez.zzm(bArr, zzj, i2);
            return zzj + i2;
        }
    }

    static int zzb(byte[] bArr, int i) {
        byte b = bArr[i] & UByte.MAX_VALUE;
        byte b2 = bArr[i + 1] & UByte.MAX_VALUE;
        byte b3 = bArr[i + 2] & UByte.MAX_VALUE;
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (b2 << 8) | b | (b3 << 16);
    }

    static int zzc(zzil zzil, byte[] bArr, int i, int i2, int i3, zzem zzem) throws IOException {
        Object zze = zzil.zze();
        int zzn = zzn(zze, zzil, bArr, i, i2, i3, zzem);
        zzil.zzf(zze);
        zzem.zzc = zze;
        return zzn;
    }

    static int zzd(zzil zzil, byte[] bArr, int i, int i2, zzem zzem) throws IOException {
        Object zze = zzil.zze();
        int zzo = zzo(zze, zzil, bArr, i, i2, zzem);
        zzil.zzf(zze);
        zzem.zzc = zze;
        return zzo;
    }

    static int zze(zzil zzil, int i, byte[] bArr, int i2, int i3, zzgv zzgv, zzem zzem) throws IOException {
        int zzd = zzd(zzil, bArr, i2, i3, zzem);
        zzgv.add(zzem.zzc);
        while (zzd < i3) {
            int zzj = zzj(bArr, zzd, zzem);
            if (i != zzem.zza) {
                break;
            }
            zzd = zzd(zzil, bArr, zzj, i3, zzem);
            zzgv.add(zzem.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i, zzgv zzgv, zzem zzem) throws IOException {
        zzgp zzgp = (zzgp) zzgv;
        int zzj = zzj(bArr, i, zzem);
        int i2 = zzem.zza + zzj;
        while (zzj < i2) {
            zzj = zzj(bArr, zzj, zzem);
            zzgp.zzg(zzem.zza);
        }
        if (zzj == i2) {
            return zzj;
        }
        throw zzgy.zzj();
    }

    static int zzg(byte[] bArr, int i, zzem zzem) throws zzgy {
        int zzj = zzj(bArr, i, zzem);
        int i2 = zzem.zza;
        if (i2 < 0) {
            throw zzgy.zzf();
        } else if (i2 == 0) {
            zzem.zzc = "";
            return zzj;
        } else {
            zzem.zzc = new String(bArr, zzj, i2, zzgw.zzb);
            return zzj + i2;
        }
    }

    static int zzh(byte[] bArr, int i, zzem zzem) throws zzgy {
        int zzj = zzj(bArr, i, zzem);
        int i2 = zzem.zza;
        if (i2 < 0) {
            throw zzgy.zzf();
        } else if (i2 == 0) {
            zzem.zzc = "";
            return zzj;
        } else {
            zzem.zzc = zzju.zzd(bArr, zzj, i2);
            return zzj + i2;
        }
    }

    static int zzi(int i, byte[] bArr, int i2, int i3, zzjg zzjg, zzem zzem) throws zzgy {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzm = zzm(bArr, i2, zzem);
                zzjg.zzj(i, Long.valueOf(zzem.zzb));
                return zzm;
            } else if (i4 == 1) {
                zzjg.zzj(i, Long.valueOf(zzq(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzj = zzj(bArr, i2, zzem);
                int i5 = zzem.zza;
                if (i5 < 0) {
                    throw zzgy.zzf();
                } else if (i5 <= bArr.length - zzj) {
                    if (i5 == 0) {
                        zzjg.zzj(i, zzez.zzb);
                    } else {
                        zzjg.zzj(i, zzez.zzm(bArr, zzj, i5));
                    }
                    return zzj + i5;
                } else {
                    throw zzgy.zzj();
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                zzjg zzf = zzjg.zzf();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i2, zzem);
                    int i8 = zzem.zza;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zzj2;
                        break;
                    }
                    int zzi = zzi(i7, bArr, zzj2, i3, zzf, zzem);
                    i7 = i8;
                    i2 = zzi;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzgy.zzg();
                }
                zzjg.zzj(i, zzf);
                return i2;
            } else if (i4 == 5) {
                zzjg.zzj(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzgy.zzc();
            }
        } else {
            throw zzgy.zzc();
        }
    }

    static int zzj(byte[] bArr, int i, zzem zzem) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzem);
        }
        zzem.zza = b;
        return i2;
    }

    static int zzk(int i, byte[] bArr, int i2, zzem zzem) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzem.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i6 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzem.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & ByteCompanionObject.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzem.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & ByteCompanionObject.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzem.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzem.zza = i11;
                return i12;
            }
        }
    }

    static int zzl(int i, byte[] bArr, int i2, int i3, zzgv zzgv, zzem zzem) {
        zzgp zzgp = (zzgp) zzgv;
        int zzj = zzj(bArr, i2, zzem);
        zzgp.zzg(zzem.zza);
        while (zzj < i3) {
            int zzj2 = zzj(bArr, zzj, zzem);
            if (i != zzem.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzem);
            zzgp.zzg(zzem.zza);
        }
        return zzj;
    }

    static int zzm(byte[] bArr, int i, zzem zzem) {
        long j = (long) bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzem.zzb = j;
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
        zzem.zzb = j2;
        return i3;
    }

    static int zzn(Object obj, zzil zzil, byte[] bArr, int i, int i2, int i3, zzem zzem) throws IOException {
        int zzc = ((zzib) zzil).zzc(obj, bArr, i, i2, i3, zzem);
        zzem.zzc = obj;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzo(java.lang.Object r6, com.google.android.recaptcha.internal.zzil r7, byte[] r8, int r9, int r10, com.google.android.recaptcha.internal.zzem r11) throws java.io.IOException {
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
            com.google.android.recaptcha.internal.zzgy r6 = com.google.android.recaptcha.internal.zzgy.zzj()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzen.zzo(java.lang.Object, com.google.android.recaptcha.internal.zzil, byte[], int, int, com.google.android.recaptcha.internal.zzem):int");
    }

    static long zzq(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    static int zzp(int i, byte[] bArr, int i2, int i3, zzem zzem) throws zzgy {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzm(bArr, i2, zzem);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zzj(bArr, i2, zzem) + zzem.zza;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zzj(bArr, i2, zzem);
                    i6 = zzem.zza;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zzp(i6, bArr, i2, i3, zzem);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzgy.zzg();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzgy.zzc();
            }
        } else {
            throw zzgy.zzc();
        }
    }
}
