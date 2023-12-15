package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzjg {
    private static final zzjg zza = new zzjg(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzjg() {
        this(0, new int[8], new Object[8], true);
    }

    private zzjg(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzjg zzc() {
        return zza;
    }

    static zzjg zze(zzjg zzjg, zzjg zzjg2) {
        int i = zzjg.zzb + zzjg2.zzb;
        int[] copyOf = Arrays.copyOf(zzjg.zzc, i);
        System.arraycopy(zzjg2.zzc, 0, copyOf, zzjg.zzb, zzjg2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzjg.zzd, i);
        System.arraycopy(zzjg2.zzd, 0, copyOf2, zzjg.zzb, zzjg2.zzb);
        return new zzjg(i, copyOf, copyOf2, true);
    }

    static zzjg zzf() {
        return new zzjg(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i) {
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
        if (obj == null || !(obj instanceof zzjg)) {
            return false;
        }
        zzjg zzjg = (zzjg) obj;
        int i = this.zzb;
        if (i == zzjg.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzjg.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzjg.zzd;
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
                    i = zzfk.zzy(i8 << 3) + 8;
                } else if (i9 == 2) {
                    int i10 = zzfk.zzb;
                    int zzd2 = ((zzez) this.zzd[i6]).zzd();
                    i = zzfk.zzy(i8 << 3) + zzfk.zzy(zzd2) + zzd2;
                } else if (i9 == 3) {
                    int i11 = i8 << 3;
                    int i12 = zzfk.zzb;
                    i2 = ((zzjg) this.zzd[i6]).zza();
                    int zzy = zzfk.zzy(i11);
                    i3 = zzy + zzy;
                } else if (i9 == 5) {
                    ((Integer) this.zzd[i6]).intValue();
                    i = zzfk.zzy(i8 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzgy.zza());
                }
                i5 += i;
            } else {
                int i13 = i8 << 3;
                i2 = zzfk.zzz(((Long) this.zzd[i6]).longValue());
                i3 = zzfk.zzy(i13);
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
            int i4 = zzfk.zzb;
            int zzd2 = ((zzez) this.zzd[i3]).zzd();
            int zzy = zzfk.zzy(zzd2) + zzd2;
            int zzy2 = zzfk.zzy(16);
            int zzy3 = zzfk.zzy(this.zzc[i3] >>> 3);
            int zzy4 = zzfk.zzy(8);
            i2 += zzy4 + zzy4 + zzy2 + zzy3 + zzfk.zzy(24) + zzy;
        }
        this.zze = i2;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final zzjg zzd(zzjg zzjg) {
        if (zzjg.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzjg.zzb;
        zzm(i);
        System.arraycopy(zzjg.zzc, 0, this.zzc, this.zzb, zzjg.zzb);
        System.arraycopy(zzjg.zzd, 0, this.zzd, this.zzb, zzjg.zzb);
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
            zzia.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzj(int i, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    /* access modifiers changed from: package-private */
    public final void zzk(zzjx zzjx) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzjx.zzw(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzjx zzjx) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzjx.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzjx.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzjx.zzd(i4, (zzez) obj);
                } else if (i3 == 3) {
                    zzjx.zzF(i4);
                    ((zzjg) obj).zzl(zzjx);
                    zzjx.zzh(i4);
                } else if (i3 == 5) {
                    zzjx.zzk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzgy.zza());
                }
            }
        }
    }
}
