package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaiw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzaiw {
    private static final zzaiw zza = new zzaiw(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzaiw() {
        this(0, new int[8], new Object[8], true);
    }

    private zzaiw(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzaiw zzc() {
        return zza;
    }

    static zzaiw zze(zzaiw zzaiw, zzaiw zzaiw2) {
        int i = zzaiw.zzb + zzaiw2.zzb;
        int[] copyOf = Arrays.copyOf(zzaiw.zzc, i);
        System.arraycopy(zzaiw2.zzc, 0, copyOf, zzaiw.zzb, zzaiw2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzaiw.zzd, i);
        System.arraycopy(zzaiw2.zzd, 0, copyOf2, zzaiw.zzb, zzaiw2.zzb);
        return new zzaiw(i, copyOf, copyOf2, true);
    }

    static zzaiw zzf() {
        return new zzaiw(0, new int[8], new Object[8], true);
    }

    private final void zzl(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzaiw)) {
            return false;
        }
        zzaiw zzaiw = (zzaiw) obj;
        int i = this.zzb;
        if (i == zzaiw.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzaiw.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzaiw.zzd;
                    int i3 = this.zzb;
                    int i4 = 0;
                    while (i4 < i3) {
                        if (objArr[i4].equals(objArr2[i4])) {
                            i4++;
                        }
                    }
                    return true;
                } else if (iArr[i2] != iArr2[i2]) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 * 31) + i4;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return (i6 * 31) + i3;
    }

    public final int zza() {
        int i;
        int i2;
        int i3;
        int i4 = this.zze;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 == 1) {
                    ((Long) this.zzd[i6]).longValue();
                    i = zzafs.zzA(i8 << 3) + 8;
                } else if (i9 == 2) {
                    int i10 = zzafs.zzf;
                    int zzd2 = ((zzaff) this.zzd[i6]).zzd();
                    i = zzafs.zzA(i8 << 3) + zzafs.zzA(zzd2) + zzd2;
                } else if (i9 == 3) {
                    int i11 = i8 << 3;
                    int i12 = zzafs.zzf;
                    i2 = ((zzaiw) this.zzd[i6]).zza();
                    int zzA = zzafs.zzA(i11);
                    i3 = zzA + zzA;
                } else if (i9 == 5) {
                    ((Integer) this.zzd[i6]).intValue();
                    i = zzafs.zzA(i8 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzags.zza());
                }
                i5 += i;
            } else {
                int i13 = i8 << 3;
                i2 = zzafs.zzB(((Long) this.zzd[i6]).longValue());
                i3 = zzafs.zzA(i13);
            }
            i = i3 + i2;
            i5 += i;
        }
        this.zze = i5;
        return i5;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = zzafs.zzf;
            int zzd2 = ((zzaff) this.zzd[i3]).zzd();
            int zzA = zzafs.zzA(zzd2) + zzd2;
            int zzA2 = zzafs.zzA(16);
            int zzA3 = zzafs.zzA(this.zzc[i3] >>> 3);
            int zzA4 = zzafs.zzA(8);
            i2 += zzA4 + zzA4 + zzA2 + zzA3 + zzafs.zzA(24) + zzA;
        }
        this.zze = i2;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final zzaiw zzd(zzaiw zzaiw) {
        if (zzaiw.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzaiw.zzb;
        zzl(i);
        System.arraycopy(zzaiw.zzc, 0, this.zzc, this.zzb, zzaiw.zzb);
        System.arraycopy(zzaiw.zzd, 0, this.zzd, this.zzb, zzaiw.zzb);
        this.zzb = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzahr.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzj(int i, Object obj) {
        zzg();
        zzl(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final void zzk(zzaft zzaft) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzaft.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzaft.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzaft.zzd(i4, (zzaff) obj);
                } else if (i3 == 3) {
                    zzaft.zzE(i4);
                    ((zzaiw) obj).zzk(zzaft);
                    zzaft.zzh(i4);
                } else if (i3 == 5) {
                    zzaft.zzk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzags.zza());
                }
            }
        }
    }
}
