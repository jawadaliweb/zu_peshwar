package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.2 */
final class zzml<T> implements zzmt<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zznu.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzmi zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzlw zzm;
    private final zznk zzn;
    private final zzko zzo;
    private final zzmn zzp;
    private final zzmd zzq;

    private zzml(int[] iArr, Object[] objArr, int i, int i2, zzmi zzmi, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzmn zzmn, zzlw zzlw, zznk zznk, zzko zzko, zzmd zzmd) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = z;
        boolean z3 = false;
        if (zzko != null && zzko.zzc(zzmi)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzp = zzmn;
        this.zzm = zzlw;
        this.zzn = zznk;
        this.zzo = zzko;
        this.zzg = zzmi;
        this.zzq = zzmd;
    }

    private final zzlf zzA(int i) {
        int i2 = i / 3;
        return (zzlf) this.zzd[i2 + i2 + 1];
    }

    private final zzmt zzB(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzmt zzmt = (zzmt) this.zzd[i3];
        if (zzmt != null) {
            return zzmt;
        }
        zzmt zzb2 = zzmq.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzC(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzD(Object obj, int i) {
        zzmt zzB = zzB(i);
        int zzy = zzy(i) & 1048575;
        if (!zzP(obj, i)) {
            return zzB.zze();
        }
        Object object = zzb.getObject(obj, (long) zzy);
        if (zzS(object)) {
            return object;
        }
        Object zze2 = zzB.zze();
        if (object != null) {
            zzB.zzg(zze2, object);
        }
        return zze2;
    }

    private final Object zzE(Object obj, int i, int i2) {
        zzmt zzB = zzB(i2);
        if (!zzT(obj, i, i2)) {
            return zzB.zze();
        }
        Object object = zzb.getObject(obj, (long) (zzy(i2) & 1048575));
        if (zzS(object)) {
            return object;
        }
        Object zze2 = zzB.zze();
        if (object != null) {
            zzB.zzg(zze2, object);
        }
        return zze2;
    }

    private static Field zzF(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzG(Object obj) {
        if (!zzS(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzH(Object obj, Object obj2, int i) {
        if (zzP(obj2, i)) {
            Unsafe unsafe = zzb;
            long zzy = (long) (zzy(i) & 1048575);
            Object object = unsafe.getObject(obj2, zzy);
            if (object != null) {
                zzmt zzB = zzB(i);
                if (!zzP(obj, i)) {
                    if (!zzS(object)) {
                        unsafe.putObject(obj, zzy, object);
                    } else {
                        Object zze2 = zzB.zze();
                        zzB.zzg(zze2, object);
                        unsafe.putObject(obj, zzy, zze2);
                    }
                    zzJ(obj, i);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzy);
                if (!zzS(object2)) {
                    Object zze3 = zzB.zze();
                    zzB.zzg(zze3, object2);
                    unsafe.putObject(obj, zzy, zze3);
                    object2 = zze3;
                }
                zzB.zzg(object2, object);
                return;
            }
            int i2 = this.zzc[i];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i2 + " is present but null: " + obj3);
        }
    }

    private final void zzI(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzT(obj2, i2, i)) {
            Unsafe unsafe = zzb;
            long zzy = (long) (zzy(i) & 1048575);
            Object object = unsafe.getObject(obj2, zzy);
            if (object != null) {
                zzmt zzB = zzB(i);
                if (!zzT(obj, i2, i)) {
                    if (!zzS(object)) {
                        unsafe.putObject(obj, zzy, object);
                    } else {
                        Object zze2 = zzB.zze();
                        zzB.zzg(zze2, object);
                        unsafe.putObject(obj, zzy, zze2);
                    }
                    zzK(obj, i2, i);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzy);
                if (!zzS(object2)) {
                    Object zze3 = zzB.zze();
                    zzB.zzg(zze3, object2);
                    unsafe.putObject(obj, zzy, zze3);
                    object2 = zze3;
                }
                zzB.zzg(object2, object);
                return;
            }
            int i3 = this.zzc[i];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i3 + " is present but null: " + obj3);
        }
    }

    private final void zzJ(Object obj, int i) {
        int zzv = zzv(i);
        long j = (long) (1048575 & zzv);
        if (j != 1048575) {
            zznu.zzq(obj, j, (1 << (zzv >>> 20)) | zznu.zzc(obj, j));
        }
    }

    private final void zzK(Object obj, int i, int i2) {
        zznu.zzq(obj, (long) (zzv(i2) & 1048575), i);
    }

    private final void zzL(Object obj, int i, Object obj2) {
        zzb.putObject(obj, (long) (zzy(i) & 1048575), obj2);
        zzJ(obj, i);
    }

    private final void zzM(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, (long) (zzy(i2) & 1048575), obj2);
        zzK(obj, i, i2);
    }

    private final void zzN(zzoc zzoc, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzmb zzmb = (zzmb) zzC(i2);
            throw null;
        }
    }

    private final boolean zzO(Object obj, Object obj2, int i) {
        return zzP(obj, i) == zzP(obj2, i);
    }

    private final boolean zzP(Object obj, int i) {
        int zzv = zzv(i);
        long j = (long) (zzv & 1048575);
        if (j == 1048575) {
            int zzy = zzy(i);
            long j2 = (long) (zzy & 1048575);
            switch (zzx(zzy)) {
                case 0:
                    return Double.doubleToRawLongBits(zznu.zza(obj, j2)) != 0;
                case 1:
                    return Float.floatToRawIntBits(zznu.zzb(obj, j2)) != 0;
                case 2:
                    return zznu.zzd(obj, j2) != 0;
                case 3:
                    return zznu.zzd(obj, j2) != 0;
                case 4:
                    return zznu.zzc(obj, j2) != 0;
                case 5:
                    return zznu.zzd(obj, j2) != 0;
                case 6:
                    return zznu.zzc(obj, j2) != 0;
                case 7:
                    return zznu.zzw(obj, j2);
                case 8:
                    Object zzf2 = zznu.zzf(obj, j2);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzka) {
                        return !zzka.zzb.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zznu.zzf(obj, j2) != null;
                case 10:
                    return !zzka.zzb.equals(zznu.zzf(obj, j2));
                case 11:
                    return zznu.zzc(obj, j2) != 0;
                case 12:
                    return zznu.zzc(obj, j2) != 0;
                case 13:
                    return zznu.zzc(obj, j2) != 0;
                case 14:
                    return zznu.zzd(obj, j2) != 0;
                case 15:
                    return zznu.zzc(obj, j2) != 0;
                case 16:
                    return zznu.zzd(obj, j2) != 0;
                case 17:
                    return zznu.zzf(obj, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zznu.zzc(obj, j) & (1 << (zzv >>> 20))) != 0;
        }
    }

    private final boolean zzQ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzP(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzR(Object obj, int i, zzmt zzmt) {
        return zzmt.zzk(zznu.zzf(obj, (long) (i & 1048575)));
    }

    private static boolean zzS(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzlb) {
            return ((zzlb) obj).zzbR();
        }
        return true;
    }

    private final boolean zzT(Object obj, int i, int i2) {
        return zznu.zzc(obj, (long) (zzv(i2) & 1048575)) == i;
    }

    private static boolean zzU(Object obj, long j) {
        return ((Boolean) zznu.zzf(obj, j)).booleanValue();
    }

    private static final void zzV(int i, Object obj, zzoc zzoc) throws IOException {
        if (obj instanceof String) {
            zzoc.zzF(i, (String) obj);
        } else {
            zzoc.zzd(i, (zzka) obj);
        }
    }

    static zznl zzd(Object obj) {
        zzlb zzlb = (zzlb) obj;
        zznl zznl = zzlb.zzc;
        if (zznl != zznl.zzc()) {
            return zznl;
        }
        zznl zzf2 = zznl.zzf();
        zzlb.zzc = zzf2;
        return zzf2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x032a  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x036e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.measurement.zzml zzl(java.lang.Class r31, com.google.android.gms.internal.measurement.zzmf r32, com.google.android.gms.internal.measurement.zzmn r33, com.google.android.gms.internal.measurement.zzlw r34, com.google.android.gms.internal.measurement.zznk r35, com.google.android.gms.internal.measurement.zzko r36, com.google.android.gms.internal.measurement.zzmd r37) {
        /*
            r0 = r32
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzms
            if (r1 == 0) goto L_0x03d8
            com.google.android.gms.internal.measurement.zzms r0 = (com.google.android.gms.internal.measurement.zzms) r0
            int r1 = r0.zzc()
            java.lang.String r2 = r0.zzd()
            int r3 = r2.length()
            r4 = 0
            char r5 = r2.charAt(r4)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r6) goto L_0x0029
            r5 = 1
        L_0x001f:
            int r8 = r5 + 1
            char r5 = r2.charAt(r5)
            if (r5 < r6) goto L_0x002a
            r5 = r8
            goto L_0x001f
        L_0x0029:
            r8 = 1
        L_0x002a:
            int r5 = r8 + 1
            char r8 = r2.charAt(r8)
            if (r8 < r6) goto L_0x0049
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0036:
            int r11 = r5 + 1
            char r5 = r2.charAt(r5)
            if (r5 < r6) goto L_0x0046
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r10
            r8 = r8 | r5
            int r10 = r10 + 13
            r5 = r11
            goto L_0x0036
        L_0x0046:
            int r5 = r5 << r10
            r8 = r8 | r5
            r5 = r11
        L_0x0049:
            if (r8 != 0) goto L_0x0058
            int[] r8 = zza
            r18 = r8
            r8 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r19 = 0
            goto L_0x016e
        L_0x0058:
            int r8 = r5 + 1
            char r5 = r2.charAt(r5)
            if (r5 < r6) goto L_0x0077
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0064:
            int r11 = r8 + 1
            char r8 = r2.charAt(r8)
            if (r8 < r6) goto L_0x0074
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r10
            r5 = r5 | r8
            int r10 = r10 + 13
            r8 = r11
            goto L_0x0064
        L_0x0074:
            int r8 = r8 << r10
            r5 = r5 | r8
            r8 = r11
        L_0x0077:
            int r10 = r8 + 1
            char r8 = r2.charAt(r8)
            if (r8 < r6) goto L_0x0096
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x0083:
            int r12 = r10 + 1
            char r10 = r2.charAt(r10)
            if (r10 < r6) goto L_0x0093
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r11
            r8 = r8 | r10
            int r11 = r11 + 13
            r10 = r12
            goto L_0x0083
        L_0x0093:
            int r10 = r10 << r11
            r8 = r8 | r10
            r10 = r12
        L_0x0096:
            int r11 = r10 + 1
            char r10 = r2.charAt(r10)
            if (r10 < r6) goto L_0x00b5
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00a2:
            int r13 = r11 + 1
            char r11 = r2.charAt(r11)
            if (r11 < r6) goto L_0x00b2
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r10 = r10 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00a2
        L_0x00b2:
            int r11 = r11 << r12
            r10 = r10 | r11
            r11 = r13
        L_0x00b5:
            int r12 = r11 + 1
            char r11 = r2.charAt(r11)
            if (r11 < r6) goto L_0x00d4
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00c1:
            int r14 = r12 + 1
            char r12 = r2.charAt(r12)
            if (r12 < r6) goto L_0x00d1
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00c1
        L_0x00d1:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00d4:
            int r13 = r12 + 1
            char r12 = r2.charAt(r12)
            if (r12 < r6) goto L_0x00f3
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00e0:
            int r15 = r13 + 1
            char r13 = r2.charAt(r13)
            if (r13 < r6) goto L_0x00f0
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00e0
        L_0x00f0:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x00f3:
            int r14 = r13 + 1
            char r13 = r2.charAt(r13)
            if (r13 < r6) goto L_0x0114
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x00ff:
            int r16 = r14 + 1
            char r14 = r2.charAt(r14)
            if (r14 < r6) goto L_0x0110
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x00ff
        L_0x0110:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0114:
            int r15 = r14 + 1
            char r14 = r2.charAt(r14)
            if (r14 < r6) goto L_0x0137
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0120:
            int r17 = r15 + 1
            char r15 = r2.charAt(r15)
            if (r15 < r6) goto L_0x0132
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x0120
        L_0x0132:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0137:
            int r16 = r15 + 1
            char r15 = r2.charAt(r15)
            if (r15 < r6) goto L_0x015c
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r4 = r16
            r16 = 13
        L_0x0145:
            int r17 = r4 + 1
            char r4 = r2.charAt(r4)
            if (r4 < r6) goto L_0x0157
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r16
            r15 = r15 | r4
            int r16 = r16 + 13
            r4 = r17
            goto L_0x0145
        L_0x0157:
            int r4 = r4 << r16
            r15 = r15 | r4
            r16 = r17
        L_0x015c:
            int r4 = r15 + r13
            int r4 = r4 + r14
            int r14 = r5 + r5
            int r14 = r14 + r8
            int[] r8 = new int[r4]
            r4 = r5
            r18 = r8
            r8 = r10
            r10 = r14
            r19 = r15
            r5 = r16
            r14 = r11
        L_0x016e:
            sun.misc.Unsafe r11 = zzb
            java.lang.Object[] r15 = r0.zze()
            com.google.android.gms.internal.measurement.zzmi r16 = r0.zza()
            java.lang.Class r9 = r16.getClass()
            int r20 = r19 + r13
            int r13 = r12 + r12
            int r12 = r12 * 3
            int[] r12 = new int[r12]
            java.lang.Object[] r13 = new java.lang.Object[r13]
            r21 = r19
            r22 = r20
            r16 = 0
            r17 = 0
        L_0x018e:
            r7 = 2
            if (r1 != r7) goto L_0x0193
            r7 = 1
            goto L_0x0194
        L_0x0193:
            r7 = 0
        L_0x0194:
            if (r5 >= r3) goto L_0x03b7
            int r24 = r5 + 1
            char r5 = r2.charAt(r5)
            if (r5 < r6) goto L_0x01c3
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            r6 = r24
            r24 = 13
        L_0x01a4:
            int r26 = r6 + 1
            char r6 = r2.charAt(r6)
            r27 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r6 < r1) goto L_0x01bd
            r1 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r24
            r5 = r5 | r1
            int r24 = r24 + 13
            r6 = r26
            r1 = r27
            goto L_0x01a4
        L_0x01bd:
            int r1 = r6 << r24
            r5 = r5 | r1
            r1 = r26
            goto L_0x01c7
        L_0x01c3:
            r27 = r1
            r1 = r24
        L_0x01c7:
            int r6 = r1 + 1
            char r1 = r2.charAt(r1)
            r24 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r3) goto L_0x01f2
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x01d8:
            int r28 = r6 + 1
            char r6 = r2.charAt(r6)
            if (r6 < r3) goto L_0x01ed
            r3 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r26
            r1 = r1 | r3
            int r26 = r26 + 13
            r6 = r28
            r3 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01d8
        L_0x01ed:
            int r3 = r6 << r26
            r1 = r1 | r3
            r6 = r28
        L_0x01f2:
            r3 = r1 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x01fc
            int r3 = r16 + 1
            r18[r16] = r17
            r16 = r3
        L_0x01fc:
            r3 = r1 & 255(0xff, float:3.57E-43)
            r26 = r14
            r14 = 51
            if (r3 < r14) goto L_0x029b
            int r14 = r6 + 1
            char r6 = r2.charAt(r6)
            r28 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r6 < r14) goto L_0x0236
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r14 = r28
            r28 = 13
        L_0x0217:
            int r29 = r14 + 1
            char r14 = r2.charAt(r14)
            r30 = r8
            r8 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r8) goto L_0x0230
            r8 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r28
            r6 = r6 | r8
            int r28 = r28 + 13
            r14 = r29
            r8 = r30
            goto L_0x0217
        L_0x0230:
            int r8 = r14 << r28
            r6 = r6 | r8
            r14 = r29
            goto L_0x023a
        L_0x0236:
            r30 = r8
            r14 = r28
        L_0x023a:
            int r8 = r3 + -51
            r28 = r14
            r14 = 9
            if (r8 == r14) goto L_0x0259
            r14 = 17
            if (r8 != r14) goto L_0x0247
            goto L_0x0259
        L_0x0247:
            r14 = 12
            if (r8 != r14) goto L_0x0265
            if (r7 != 0) goto L_0x0265
            int r7 = r17 / 3
            int r7 = r7 + r7
            r8 = 1
            int r7 = r7 + r8
            int r8 = r10 + 1
            r10 = r15[r10]
            r13[r7] = r10
            goto L_0x0264
        L_0x0259:
            int r7 = r17 / 3
            int r7 = r7 + r7
            r8 = 1
            int r7 = r7 + r8
            int r8 = r10 + 1
            r10 = r15[r10]
            r13[r7] = r10
        L_0x0264:
            r10 = r8
        L_0x0265:
            int r6 = r6 + r6
            r7 = r15[r6]
            boolean r8 = r7 instanceof java.lang.reflect.Field
            if (r8 == 0) goto L_0x026f
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x0277
        L_0x026f:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = zzF(r9, r7)
            r15[r6] = r7
        L_0x0277:
            long r7 = r11.objectFieldOffset(r7)
            int r8 = (int) r7
            int r6 = r6 + 1
            r7 = r15[r6]
            boolean r14 = r7 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0287
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x028f
        L_0x0287:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = zzF(r9, r7)
            r15[r6] = r7
        L_0x028f:
            long r6 = r11.objectFieldOffset(r7)
            int r7 = (int) r6
            r23 = r15
            r25 = r28
            r6 = 0
            goto L_0x0382
        L_0x029b:
            r30 = r8
            int r8 = r10 + 1
            r10 = r15[r10]
            java.lang.String r10 = (java.lang.String) r10
            java.lang.reflect.Field r10 = zzF(r9, r10)
            r14 = 9
            if (r3 == r14) goto L_0x030b
            r14 = 17
            if (r3 != r14) goto L_0x02b0
            goto L_0x030b
        L_0x02b0:
            r14 = 27
            if (r3 == r14) goto L_0x02fd
            r14 = 49
            if (r3 != r14) goto L_0x02b9
            goto L_0x02fd
        L_0x02b9:
            r14 = 12
            if (r3 == r14) goto L_0x02ed
            r14 = 30
            if (r3 == r14) goto L_0x02ed
            r14 = 44
            if (r3 != r14) goto L_0x02c6
            goto L_0x02ed
        L_0x02c6:
            r7 = 50
            if (r3 != r7) goto L_0x02fb
            int r7 = r21 + 1
            r18[r21] = r17
            int r14 = r17 / 3
            int r21 = r8 + 1
            r8 = r15[r8]
            int r14 = r14 + r14
            r13[r14] = r8
            r8 = r1 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x02e6
            int r14 = r14 + 1
            int r8 = r21 + 1
            r21 = r15[r21]
            r13[r14] = r21
            r21 = r7
            goto L_0x0316
        L_0x02e6:
            r23 = r15
            r8 = r21
            r21 = r7
            goto L_0x0318
        L_0x02ed:
            if (r7 != 0) goto L_0x02fb
            int r7 = r17 / 3
            int r7 = r7 + r7
            r14 = 1
            int r7 = r7 + r14
            int r23 = r8 + 1
            r8 = r15[r8]
            r13[r7] = r8
            goto L_0x0308
        L_0x02fb:
            r14 = 1
            goto L_0x0316
        L_0x02fd:
            r14 = 1
            int r7 = r17 / 3
            int r7 = r7 + r7
            int r7 = r7 + r14
            int r23 = r8 + 1
            r8 = r15[r8]
            r13[r7] = r8
        L_0x0308:
            r8 = r23
            goto L_0x0316
        L_0x030b:
            r14 = 1
            int r7 = r17 / 3
            int r7 = r7 + r7
            int r7 = r7 + r14
            java.lang.Class r23 = r10.getType()
            r13[r7] = r23
        L_0x0316:
            r23 = r15
        L_0x0318:
            long r14 = r11.objectFieldOffset(r10)
            int r7 = (int) r14
            r10 = r1 & 4096(0x1000, float:5.74E-42)
            r14 = 1048575(0xfffff, float:1.469367E-39)
            r15 = 4096(0x1000, float:5.74E-42)
            if (r10 != r15) goto L_0x036e
            r10 = 17
            if (r3 > r10) goto L_0x036e
            int r10 = r6 + 1
            char r6 = r2.charAt(r6)
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r6 < r15) goto L_0x034d
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x0339:
            int r25 = r10 + 1
            char r10 = r2.charAt(r10)
            if (r10 < r15) goto L_0x034a
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r14
            r6 = r6 | r10
            int r14 = r14 + 13
            r10 = r25
            goto L_0x0339
        L_0x034a:
            int r10 = r10 << r14
            r6 = r6 | r10
            goto L_0x034f
        L_0x034d:
            r25 = r10
        L_0x034f:
            int r10 = r4 + r4
            int r14 = r6 / 32
            int r10 = r10 + r14
            r14 = r23[r10]
            boolean r15 = r14 instanceof java.lang.reflect.Field
            if (r15 == 0) goto L_0x035d
            java.lang.reflect.Field r14 = (java.lang.reflect.Field) r14
            goto L_0x0365
        L_0x035d:
            java.lang.String r14 = (java.lang.String) r14
            java.lang.reflect.Field r14 = zzF(r9, r14)
            r23[r10] = r14
        L_0x0365:
            long r14 = r11.objectFieldOffset(r14)
            int r10 = (int) r14
            int r6 = r6 % 32
            r14 = r10
            goto L_0x0371
        L_0x036e:
            r25 = r6
            r6 = 0
        L_0x0371:
            r10 = 18
            if (r3 < r10) goto L_0x037f
            r10 = 49
            if (r3 > r10) goto L_0x037f
            int r10 = r22 + 1
            r18[r22] = r7
            r22 = r10
        L_0x037f:
            r10 = r8
            r8 = r7
            r7 = r14
        L_0x0382:
            int r14 = r17 + 1
            r12[r17] = r5
            int r5 = r14 + 1
            r15 = r1 & 512(0x200, float:7.175E-43)
            if (r15 == 0) goto L_0x038f
            r15 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0390
        L_0x038f:
            r15 = 0
        L_0x0390:
            r1 = r1 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0397
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0398
        L_0x0397:
            r1 = 0
        L_0x0398:
            int r3 = r3 << 20
            r1 = r1 | r15
            r1 = r1 | r3
            r1 = r1 | r8
            r12[r14] = r1
            int r17 = r5 + 1
            int r1 = r6 << 20
            r1 = r1 | r7
            r12[r5] = r1
            r15 = r23
            r3 = r24
            r5 = r25
            r14 = r26
            r1 = r27
            r8 = r30
            r6 = 55296(0xd800, float:7.7486E-41)
            goto L_0x018e
        L_0x03b7:
            r30 = r8
            r26 = r14
            com.google.android.gms.internal.measurement.zzml r1 = new com.google.android.gms.internal.measurement.zzml
            com.google.android.gms.internal.measurement.zzmi r15 = r0.zza()
            r17 = 0
            r10 = r1
            r11 = r12
            r12 = r13
            r13 = r30
            r16 = r7
            r21 = r33
            r22 = r34
            r23 = r35
            r24 = r36
            r25 = r37
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return r1
        L_0x03d8:
            com.google.android.gms.internal.measurement.zznh r0 = (com.google.android.gms.internal.measurement.zznh) r0
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzml.zzl(java.lang.Class, com.google.android.gms.internal.measurement.zzmf, com.google.android.gms.internal.measurement.zzmn, com.google.android.gms.internal.measurement.zzlw, com.google.android.gms.internal.measurement.zznk, com.google.android.gms.internal.measurement.zzko, com.google.android.gms.internal.measurement.zzmd):com.google.android.gms.internal.measurement.zzml");
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zznu.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zznu.zzf(obj, j)).floatValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x032f, code lost:
        r4 = r4 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x03a0, code lost:
        r6 = r6 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x04ae, code lost:
        r3 = r3 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0561, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0570, code lost:
        r3 = r3 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0574, code lost:
        r5 = r5 + 3;
        r3 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f4, code lost:
        r3 = r3 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01b2, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01c2, code lost:
        r3 = r3 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzo(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            sun.misc.Unsafe r2 = zzb
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r5 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 0
        L_0x000f:
            int[] r9 = r0.zzc
            int r9 = r9.length
            if (r5 >= r9) goto L_0x057b
            int r9 = r0.zzy(r5)
            int[] r10 = r0.zzc
            r11 = r10[r5]
            int r12 = zzx(r9)
            r13 = 17
            r14 = 1
            if (r12 > r13) goto L_0x0038
            int r13 = r5 + 2
            r10 = r10[r13]
            r13 = r10 & r3
            int r10 = r10 >>> 20
            if (r13 == r7) goto L_0x0035
            long r7 = (long) r13
            int r8 = r2.getInt(r1, r7)
            r7 = r13
        L_0x0035:
            int r10 = r14 << r10
            goto L_0x0039
        L_0x0038:
            r10 = 0
        L_0x0039:
            r9 = r9 & r3
            long r3 = (long) r9
            r9 = 63
            switch(r12) {
                case 0: goto L_0x0565;
                case 1: goto L_0x0556;
                case 2: goto L_0x0540;
                case 3: goto L_0x052c;
                case 4: goto L_0x0518;
                case 5: goto L_0x050c;
                case 6: goto L_0x0500;
                case 7: goto L_0x04f2;
                case 8: goto L_0x04c4;
                case 9: goto L_0x04b1;
                case 10: goto L_0x0492;
                case 11: goto L_0x047d;
                case 12: goto L_0x0468;
                case 13: goto L_0x045b;
                case 14: goto L_0x044e;
                case 15: goto L_0x0434;
                case 16: goto L_0x041a;
                case 17: goto L_0x0406;
                case 18: goto L_0x03f8;
                case 19: goto L_0x03ec;
                case 20: goto L_0x03e0;
                case 21: goto L_0x03d4;
                case 22: goto L_0x03c8;
                case 23: goto L_0x03bc;
                case 24: goto L_0x03b0;
                case 25: goto L_0x03a4;
                case 26: goto L_0x0396;
                case 27: goto L_0x0387;
                case 28: goto L_0x037c;
                case 29: goto L_0x0370;
                case 30: goto L_0x0364;
                case 31: goto L_0x0358;
                case 32: goto L_0x034c;
                case 33: goto L_0x0340;
                case 34: goto L_0x0334;
                case 35: goto L_0x0319;
                case 36: goto L_0x0302;
                case 37: goto L_0x02eb;
                case 38: goto L_0x02d4;
                case 39: goto L_0x02bd;
                case 40: goto L_0x02a5;
                case 41: goto L_0x028d;
                case 42: goto L_0x0273;
                case 43: goto L_0x025b;
                case 44: goto L_0x0243;
                case 45: goto L_0x022b;
                case 46: goto L_0x0213;
                case 47: goto L_0x01fb;
                case 48: goto L_0x01e3;
                case 49: goto L_0x01d3;
                case 50: goto L_0x01c6;
                case 51: goto L_0x01b6;
                case 52: goto L_0x01a6;
                case 53: goto L_0x0190;
                case 54: goto L_0x017a;
                case 55: goto L_0x0164;
                case 56: goto L_0x0157;
                case 57: goto L_0x014a;
                case 58: goto L_0x013b;
                case 59: goto L_0x010b;
                case 60: goto L_0x00f7;
                case 61: goto L_0x00d7;
                case 62: goto L_0x00c1;
                case 63: goto L_0x00ab;
                case 64: goto L_0x009d;
                case 65: goto L_0x008f;
                case 66: goto L_0x0074;
                case 67: goto L_0x0058;
                case 68: goto L_0x0042;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x03a1
        L_0x0042:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzmi r3 = (com.google.android.gms.internal.measurement.zzmi) r3
            com.google.android.gms.internal.measurement.zzmt r4 = r0.zzB(r5)
            int r3 = com.google.android.gms.internal.measurement.zzki.zzt(r11, r3, r4)
            goto L_0x03a0
        L_0x0058:
            boolean r10 = r0.zzT(r1, r11, r5)
            if (r10 == 0) goto L_0x03a1
            long r3 = zzz(r1, r3)
            int r10 = r11 << 3
            long r11 = r3 + r3
            long r3 = r3 >> r9
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r10)
            long r3 = r3 ^ r11
            int r3 = com.google.android.gms.internal.measurement.zzki.zzy(r3)
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x03a1
        L_0x0074:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            int r3 = zzp(r1, r3)
            int r4 = r11 << 3
            int r9 = r3 + r3
            int r3 = r3 >> 31
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x0330
        L_0x008f:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x01c2
        L_0x009d:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x01b2
        L_0x00ab:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            int r3 = zzp(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzu(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x0330
        L_0x00c1:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            int r3 = zzp(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x0330
        L_0x00d7:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzka r3 = (com.google.android.gms.internal.measurement.zzka) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzb
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
        L_0x00f4:
            int r3 = r3 + r9
            goto L_0x03a0
        L_0x00f7:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzmt r4 = r0.zzB(r5)
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzn(r11, r3, r4)
            goto L_0x03a0
        L_0x010b:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzka
            if (r4 == 0) goto L_0x012d
            com.google.android.gms.internal.measurement.zzka r3 = (com.google.android.gms.internal.measurement.zzka) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzb
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x00f4
        L_0x012d:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzw(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x0330
        L_0x013b:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r3 = r3 + r14
            goto L_0x03a0
        L_0x014a:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x01b2
        L_0x0157:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x01c2
        L_0x0164:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            int r3 = zzp(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzu(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x0330
        L_0x017a:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            long r3 = zzz(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzy(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r9)
            goto L_0x0330
        L_0x0190:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            long r3 = zzz(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzy(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r9)
            goto L_0x0330
        L_0x01a6:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
        L_0x01b2:
            int r3 = r3 + 4
            goto L_0x03a0
        L_0x01b6:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
        L_0x01c2:
            int r3 = r3 + 8
            goto L_0x03a0
        L_0x01c6:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.lang.Object r4 = r0.zzC(r5)
            com.google.android.gms.internal.measurement.zzmd.zza(r11, r3, r4)
            goto L_0x03a1
        L_0x01d3:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.measurement.zzmt r4 = r0.zzB(r5)
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzi(r11, r3, r4)
            goto L_0x03a0
        L_0x01e3:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzs(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032f
        L_0x01fb:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzq(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032f
        L_0x0213:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzh(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032f
        L_0x022b:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032f
        L_0x0243:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzd(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032f
        L_0x025b:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzv(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032f
        L_0x0273:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r4 = com.google.android.gms.internal.measurement.zzmv.zza
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032f
        L_0x028d:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032f
        L_0x02a5:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzh(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032f
        L_0x02bd:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzk(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032f
        L_0x02d4:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzx(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032f
        L_0x02eb:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzm(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032f
        L_0x0302:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032f
        L_0x0319:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzh(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
        L_0x032f:
            int r4 = r4 + r9
        L_0x0330:
            int r4 = r4 + r3
            int r6 = r6 + r4
            goto L_0x03a1
        L_0x0334:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r9 = 0
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzr(r11, r3, r9)
            goto L_0x03a0
        L_0x0340:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzp(r11, r3, r9)
            goto L_0x03a0
        L_0x034c:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzg(r11, r3, r9)
            goto L_0x03a0
        L_0x0358:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zze(r11, r3, r9)
            goto L_0x03a0
        L_0x0364:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzc(r11, r3, r9)
            goto L_0x03a0
        L_0x0370:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzu(r11, r3, r9)
            goto L_0x03a0
        L_0x037c:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzb(r11, r3)
            goto L_0x03a0
        L_0x0387:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.measurement.zzmt r4 = r0.zzB(r5)
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzo(r11, r3, r4)
            goto L_0x03a0
        L_0x0396:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzt(r11, r3)
        L_0x03a0:
            int r6 = r6 + r3
        L_0x03a1:
            r12 = 0
            goto L_0x0574
        L_0x03a4:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r12 = 0
            int r3 = com.google.android.gms.internal.measurement.zzmv.zza(r11, r3, r12)
            goto L_0x0403
        L_0x03b0:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zze(r11, r3, r12)
            goto L_0x0403
        L_0x03bc:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzg(r11, r3, r12)
            goto L_0x0403
        L_0x03c8:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzj(r11, r3, r12)
            goto L_0x0403
        L_0x03d4:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzw(r11, r3, r12)
            goto L_0x0403
        L_0x03e0:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzl(r11, r3, r12)
            goto L_0x0403
        L_0x03ec:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zze(r11, r3, r12)
            goto L_0x0403
        L_0x03f8:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzg(r11, r3, r12)
        L_0x0403:
            int r6 = r6 + r3
            goto L_0x0574
        L_0x0406:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzmi r3 = (com.google.android.gms.internal.measurement.zzmi) r3
            com.google.android.gms.internal.measurement.zzmt r4 = r0.zzB(r5)
            int r3 = com.google.android.gms.internal.measurement.zzki.zzt(r11, r3, r4)
            goto L_0x0403
        L_0x041a:
            r12 = 0
            r10 = r10 & r8
            if (r10 == 0) goto L_0x0574
            long r3 = r2.getLong(r1, r3)
            int r10 = r11 << 3
            long r14 = r3 + r3
            long r3 = r3 >> r9
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r10)
            long r3 = r3 ^ r14
            int r3 = com.google.android.gms.internal.measurement.zzki.zzy(r3)
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x0574
        L_0x0434:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r9 = r3 + r3
            int r3 = r3 >> 31
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x0553
        L_0x044e:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x0570
        L_0x045b:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x0561
        L_0x0468:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzu(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x0553
        L_0x047d:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x0553
        L_0x0492:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzka r3 = (com.google.android.gms.internal.measurement.zzka) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzb
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
        L_0x04ae:
            int r3 = r3 + r9
            goto L_0x0403
        L_0x04b1:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzmt r4 = r0.zzB(r5)
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzn(r11, r3, r4)
            goto L_0x0403
        L_0x04c4:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzka
            if (r4 == 0) goto L_0x04e5
            com.google.android.gms.internal.measurement.zzka r3 = (com.google.android.gms.internal.measurement.zzka) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzb
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x04ae
        L_0x04e5:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzw(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x0553
        L_0x04f2:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r3 = r3 + r14
            goto L_0x0403
        L_0x0500:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x0561
        L_0x050c:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x0570
        L_0x0518:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzu(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x0553
        L_0x052c:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzy(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r9)
            goto L_0x0553
        L_0x0540:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzy(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r9)
        L_0x0553:
            int r4 = r4 + r3
            int r6 = r6 + r4
            goto L_0x0574
        L_0x0556:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
        L_0x0561:
            int r3 = r3 + 4
            goto L_0x0403
        L_0x0565:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
        L_0x0570:
            int r3 = r3 + 8
            goto L_0x0403
        L_0x0574:
            int r5 = r5 + 3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000f
        L_0x057b:
            com.google.android.gms.internal.measurement.zznk r2 = r0.zzn
            java.lang.Object r3 = r2.zzd(r1)
            int r2 = r2.zza(r3)
            int r6 = r6 + r2
            boolean r2 = r0.zzh
            if (r2 != 0) goto L_0x058b
            return r6
        L_0x058b:
            com.google.android.gms.internal.measurement.zzko r2 = r0.zzo
            r2.zza(r1)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzml.zzo(java.lang.Object):int");
    }

    private static int zzp(Object obj, long j) {
        return ((Integer) zznu.zzf(obj, j)).intValue();
    }

    private final int zzq(Object obj, byte[] bArr, int i, int i2, int i3, long j, zzjn zzjn) throws IOException {
        Unsafe unsafe = zzb;
        Object zzC = zzC(i3);
        Object object = unsafe.getObject(obj, j);
        if (!((zzmc) object).zze()) {
            zzmc zzb2 = zzmc.zza().zzb();
            zzmd.zzb(zzb2, object);
            unsafe.putObject(obj, j, zzb2);
        }
        zzmb zzmb = (zzmb) zzC;
        throw null;
    }

    private final int zzr(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzjn zzjn) throws IOException {
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i9 = i;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        long j2 = j;
        int i13 = i8;
        zzjn zzjn2 = zzjn;
        Unsafe unsafe = zzb;
        long j3 = (long) (this.zzc[i13 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i12 == 1) {
                    unsafe.putObject(obj2, j2, Double.valueOf(Double.longBitsToDouble(zzjo.zzp(bArr, i))));
                    int i14 = i9 + 8;
                    unsafe.putInt(obj2, j3, i11);
                    return i14;
                }
                break;
            case 52:
                if (i12 == 5) {
                    unsafe.putObject(obj2, j2, Float.valueOf(Float.intBitsToFloat(zzjo.zzb(bArr, i))));
                    int i15 = i9 + 4;
                    unsafe.putInt(obj2, j3, i11);
                    return i15;
                }
                break;
            case 53:
            case 54:
                if (i12 == 0) {
                    int zzm2 = zzjo.zzm(bArr2, i9, zzjn2);
                    unsafe.putObject(obj2, j2, Long.valueOf(zzjn2.zzb));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm2;
                }
                break;
            case 55:
            case 62:
                if (i12 == 0) {
                    int zzj2 = zzjo.zzj(bArr2, i9, zzjn2);
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzjn2.zza));
                    unsafe.putInt(obj2, j3, i11);
                    return zzj2;
                }
                break;
            case 56:
            case 65:
                if (i12 == 1) {
                    unsafe.putObject(obj2, j2, Long.valueOf(zzjo.zzp(bArr, i)));
                    int i16 = i9 + 8;
                    unsafe.putInt(obj2, j3, i11);
                    return i16;
                }
                break;
            case 57:
            case 64:
                if (i12 == 5) {
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzjo.zzb(bArr, i)));
                    int i17 = i9 + 4;
                    unsafe.putInt(obj2, j3, i11);
                    return i17;
                }
                break;
            case 58:
                if (i12 == 0) {
                    int zzm3 = zzjo.zzm(bArr2, i9, zzjn2);
                    unsafe.putObject(obj2, j2, Boolean.valueOf(zzjn2.zzb != 0));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm3;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int zzj3 = zzjo.zzj(bArr2, i9, zzjn2);
                    int i18 = zzjn2.zza;
                    if (i18 == 0) {
                        unsafe.putObject(obj2, j2, "");
                    } else if ((i6 & 536870912) == 0 || zznz.zze(bArr2, zzj3, zzj3 + i18)) {
                        unsafe.putObject(obj2, j2, new String(bArr2, zzj3, i18, zzlj.zzb));
                        zzj3 += i18;
                    } else {
                        throw zzll.zzc();
                    }
                    unsafe.putInt(obj2, j3, i11);
                    return zzj3;
                }
                break;
            case 60:
                if (i12 == 2) {
                    Object zzE = zzE(obj2, i11, i13);
                    int zzo2 = zzjo.zzo(zzE, zzB(i13), bArr, i, i2, zzjn);
                    zzM(obj2, i11, i13, zzE);
                    return zzo2;
                }
                break;
            case 61:
                if (i12 == 2) {
                    int zza2 = zzjo.zza(bArr2, i9, zzjn2);
                    unsafe.putObject(obj2, j2, zzjn2.zzc);
                    unsafe.putInt(obj2, j3, i11);
                    return zza2;
                }
                break;
            case 63:
                if (i12 == 0) {
                    int zzj4 = zzjo.zzj(bArr2, i9, zzjn2);
                    int i19 = zzjn2.zza;
                    zzlf zzA = zzA(i13);
                    if (zzA == null || zzA.zza(i19)) {
                        unsafe.putObject(obj2, j2, Integer.valueOf(i19));
                        unsafe.putInt(obj2, j3, i11);
                    } else {
                        zzd(obj).zzj(i10, Long.valueOf((long) i19));
                    }
                    return zzj4;
                }
                break;
            case 66:
                if (i12 == 0) {
                    int zzj5 = zzjo.zzj(bArr2, i9, zzjn2);
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzke.zzb(zzjn2.zza)));
                    unsafe.putInt(obj2, j3, i11);
                    return zzj5;
                }
                break;
            case 67:
                if (i12 == 0) {
                    int zzm4 = zzjo.zzm(bArr2, i9, zzjn2);
                    unsafe.putObject(obj2, j2, Long.valueOf(zzke.zzc(zzjn2.zzb)));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm4;
                }
                break;
            case 68:
                if (i12 == 3) {
                    Object zzE2 = zzE(obj2, i11, i13);
                    int zzn2 = zzjo.zzn(zzE2, zzB(i13), bArr, i, i2, (i10 & -8) | 4, zzjn);
                    zzM(obj2, i11, i13, zzE2);
                    return zzn2;
                }
                break;
        }
        return i9;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x01cd A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x0495 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x0495 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x019e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzs(java.lang.Object r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.measurement.zzjn r30) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r2 = r21
            r8 = r22
            r6 = r23
            r9 = r24
            r10 = r28
            r7 = r30
            sun.misc.Unsafe r12 = zzb
            java.lang.Object r13 = r12.getObject(r1, r10)
            com.google.android.gms.internal.measurement.zzli r13 = (com.google.android.gms.internal.measurement.zzli) r13
            boolean r14 = r13.zzc()
            if (r14 != 0) goto L_0x0035
            int r14 = r13.size()
            if (r14 != 0) goto L_0x002d
            r14 = 10
            goto L_0x002e
        L_0x002d:
            int r14 = r14 + r14
        L_0x002e:
            com.google.android.gms.internal.measurement.zzli r13 = r13.zzd(r14)
            r12.putObject(r1, r10, r13)
        L_0x0035:
            r10 = 5
            r11 = 0
            r15 = 1
            r14 = 2
            switch(r27) {
                case 18: goto L_0x0427;
                case 19: goto L_0x03da;
                case 20: goto L_0x0397;
                case 21: goto L_0x0397;
                case 22: goto L_0x037e;
                case 23: goto L_0x033d;
                case 24: goto L_0x02fc;
                case 25: goto L_0x02a4;
                case 26: goto L_0x01f1;
                case 27: goto L_0x01d8;
                case 28: goto L_0x017e;
                case 29: goto L_0x037e;
                case 30: goto L_0x00fd;
                case 31: goto L_0x02fc;
                case 32: goto L_0x033d;
                case 33: goto L_0x00ae;
                case 34: goto L_0x005f;
                case 35: goto L_0x0427;
                case 36: goto L_0x03da;
                case 37: goto L_0x0397;
                case 38: goto L_0x0397;
                case 39: goto L_0x037e;
                case 40: goto L_0x033d;
                case 41: goto L_0x02fc;
                case 42: goto L_0x02a4;
                case 43: goto L_0x037e;
                case 44: goto L_0x00fd;
                case 45: goto L_0x02fc;
                case 46: goto L_0x033d;
                case 47: goto L_0x00ae;
                case 48: goto L_0x005f;
                default: goto L_0x003d;
            }
        L_0x003d:
            r1 = 3
            if (r6 != r1) goto L_0x0495
            com.google.android.gms.internal.measurement.zzmt r1 = r0.zzB(r9)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzc(r22, r23, r24, r25, r26, r27)
            java.lang.Object r8 = r7.zzc
            r13.add(r8)
            goto L_0x0473
        L_0x005f:
            if (r6 != r14) goto L_0x0083
            com.google.android.gms.internal.measurement.zzlx r13 = (com.google.android.gms.internal.measurement.zzlx) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x006a:
            if (r1 >= r2) goto L_0x007a
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzm(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.measurement.zzke.zzc(r4)
            r13.zzg(r4)
            goto L_0x006a
        L_0x007a:
            if (r1 != r2) goto L_0x007e
            goto L_0x0496
        L_0x007e:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x0083:
            if (r6 != 0) goto L_0x0495
            com.google.android.gms.internal.measurement.zzlx r13 = (com.google.android.gms.internal.measurement.zzlx) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzke.zzc(r8)
            r13.zzg(r8)
        L_0x0094:
            if (r1 >= r5) goto L_0x00ad
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009f
            goto L_0x00ad
        L_0x009f:
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzke.zzc(r8)
            r13.zzg(r8)
            goto L_0x0094
        L_0x00ad:
            return r1
        L_0x00ae:
            if (r6 != r14) goto L_0x00d2
            com.google.android.gms.internal.measurement.zzlc r13 = (com.google.android.gms.internal.measurement.zzlc) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b9:
            if (r1 >= r2) goto L_0x00c9
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzke.zzb(r4)
            r13.zzh(r4)
            goto L_0x00b9
        L_0x00c9:
            if (r1 != r2) goto L_0x00cd
            goto L_0x0496
        L_0x00cd:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x00d2:
            if (r6 != 0) goto L_0x0495
            com.google.android.gms.internal.measurement.zzlc r13 = (com.google.android.gms.internal.measurement.zzlc) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzke.zzb(r4)
            r13.zzh(r4)
        L_0x00e3:
            if (r1 >= r5) goto L_0x00fc
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00ee
            goto L_0x00fc
        L_0x00ee:
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzke.zzb(r4)
            r13.zzh(r4)
            goto L_0x00e3
        L_0x00fc:
            return r1
        L_0x00fd:
            if (r6 != r14) goto L_0x0104
            int r2 = com.google.android.gms.internal.measurement.zzjo.zzf(r3, r4, r13, r7)
            goto L_0x0115
        L_0x0104:
            if (r6 != 0) goto L_0x0495
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r13
            r7 = r30
            int r2 = com.google.android.gms.internal.measurement.zzjo.zzl(r2, r3, r4, r5, r6, r7)
        L_0x0115:
            com.google.android.gms.internal.measurement.zzlf r3 = r0.zzA(r9)
            com.google.android.gms.internal.measurement.zznk r4 = r0.zzn
            int r5 = com.google.android.gms.internal.measurement.zzmv.zza
            if (r3 == 0) goto L_0x017b
            boolean r5 = r13 instanceof java.util.RandomAccess
            r6 = 0
            if (r5 == 0) goto L_0x0159
            int r5 = r13.size()
            r7 = 0
            r14 = 0
        L_0x012a:
            if (r14 >= r5) goto L_0x014f
            java.lang.Object r9 = r13.get(r14)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            boolean r10 = r3.zza(r9)
            if (r10 == 0) goto L_0x0148
            if (r14 == r7) goto L_0x0145
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r13.set(r7, r9)
        L_0x0145:
            int r7 = r7 + 1
            goto L_0x014c
        L_0x0148:
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzmv.zzB(r1, r8, r9, r6, r4)
        L_0x014c:
            int r14 = r14 + 1
            goto L_0x012a
        L_0x014f:
            if (r7 == r5) goto L_0x017b
            java.util.List r1 = r13.subList(r7, r5)
            r1.clear()
            return r2
        L_0x0159:
            java.util.Iterator r5 = r13.iterator()
        L_0x015d:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x017b
            java.lang.Object r7 = r5.next()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            boolean r9 = r3.zza(r7)
            if (r9 != 0) goto L_0x015d
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzmv.zzB(r1, r8, r7, r6, r4)
            r5.remove()
            goto L_0x015d
        L_0x017b:
            r1 = r2
            goto L_0x0496
        L_0x017e:
            if (r6 != r14) goto L_0x0495
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01d3
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x01ce
            if (r4 != 0) goto L_0x0194
            com.google.android.gms.internal.measurement.zzka r4 = com.google.android.gms.internal.measurement.zzka.zzb
            r13.add(r4)
            goto L_0x019c
        L_0x0194:
            com.google.android.gms.internal.measurement.zzka r6 = com.google.android.gms.internal.measurement.zzka.zzl(r3, r1, r4)
            r13.add(r6)
        L_0x019b:
            int r1 = r1 + r4
        L_0x019c:
            if (r1 >= r5) goto L_0x01cd
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x01a7
            goto L_0x01cd
        L_0x01a7:
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01c8
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x01c3
            if (r4 != 0) goto L_0x01bb
            com.google.android.gms.internal.measurement.zzka r4 = com.google.android.gms.internal.measurement.zzka.zzb
            r13.add(r4)
            goto L_0x019c
        L_0x01bb:
            com.google.android.gms.internal.measurement.zzka r6 = com.google.android.gms.internal.measurement.zzka.zzl(r3, r1, r4)
            r13.add(r6)
            goto L_0x019b
        L_0x01c3:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x01c8:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzd()
            throw r1
        L_0x01cd:
            return r1
        L_0x01ce:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x01d3:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzd()
            throw r1
        L_0x01d8:
            if (r6 != r14) goto L_0x0495
            com.google.android.gms.internal.measurement.zzmt r1 = r0.zzB(r9)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r13
            r28 = r30
            int r1 = com.google.android.gms.internal.measurement.zzjo.zze(r22, r23, r24, r25, r26, r27, r28)
            return r1
        L_0x01f1:
            if (r6 != r14) goto L_0x0495
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r6 != 0) goto L_0x0244
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x023f
            if (r6 != 0) goto L_0x020c
            r13.add(r1)
            goto L_0x0217
        L_0x020c:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzlj.zzb
            r8.<init>(r3, r4, r6, r9)
            r13.add(r8)
        L_0x0216:
            int r4 = r4 + r6
        L_0x0217:
            if (r4 >= r5) goto L_0x0495
            int r6 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0495
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x023a
            if (r6 != 0) goto L_0x022f
            r13.add(r1)
            goto L_0x0217
        L_0x022f:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzlj.zzb
            r8.<init>(r3, r4, r6, r9)
            r13.add(r8)
            goto L_0x0216
        L_0x023a:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzd()
            throw r1
        L_0x023f:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzd()
            throw r1
        L_0x0244:
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x029f
            if (r6 != 0) goto L_0x0252
            r13.add(r1)
            goto L_0x0265
        L_0x0252:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.measurement.zznz.zze(r3, r4, r8)
            if (r9 == 0) goto L_0x029a
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzlj.zzb
            r9.<init>(r3, r4, r6, r10)
            r13.add(r9)
        L_0x0264:
            r4 = r8
        L_0x0265:
            if (r4 >= r5) goto L_0x0495
            int r6 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0495
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0295
            if (r6 != 0) goto L_0x027d
            r13.add(r1)
            goto L_0x0265
        L_0x027d:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.measurement.zznz.zze(r3, r4, r8)
            if (r9 == 0) goto L_0x0290
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzlj.zzb
            r9.<init>(r3, r4, r6, r10)
            r13.add(r9)
            goto L_0x0264
        L_0x0290:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzc()
            throw r1
        L_0x0295:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzd()
            throw r1
        L_0x029a:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzc()
            throw r1
        L_0x029f:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzd()
            throw r1
        L_0x02a4:
            if (r6 != r14) goto L_0x02cb
            com.google.android.gms.internal.measurement.zzjp r13 = (com.google.android.gms.internal.measurement.zzjp) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02af:
            if (r1 >= r2) goto L_0x02c2
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzm(r3, r1, r7)
            long r4 = r7.zzb
            int r6 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r6 == 0) goto L_0x02bd
            r4 = 1
            goto L_0x02be
        L_0x02bd:
            r4 = 0
        L_0x02be:
            r13.zze(r4)
            goto L_0x02af
        L_0x02c2:
            if (r1 != r2) goto L_0x02c6
            goto L_0x0496
        L_0x02c6:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x02cb:
            if (r6 != 0) goto L_0x0495
            com.google.android.gms.internal.measurement.zzjp r13 = (com.google.android.gms.internal.measurement.zzjp) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r4 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r4 == 0) goto L_0x02db
            r4 = 1
            goto L_0x02dc
        L_0x02db:
            r4 = 0
        L_0x02dc:
            r13.zze(r4)
        L_0x02df:
            if (r1 >= r5) goto L_0x02fb
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02ea
            goto L_0x02fb
        L_0x02ea:
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r4 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r4 == 0) goto L_0x02f6
            r4 = 1
            goto L_0x02f7
        L_0x02f6:
            r4 = 0
        L_0x02f7:
            r13.zze(r4)
            goto L_0x02df
        L_0x02fb:
            return r1
        L_0x02fc:
            if (r6 != r14) goto L_0x031c
            com.google.android.gms.internal.measurement.zzlc r13 = (com.google.android.gms.internal.measurement.zzlc) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0307:
            if (r1 >= r2) goto L_0x0313
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzb(r3, r1)
            r13.zzh(r4)
            int r1 = r1 + 4
            goto L_0x0307
        L_0x0313:
            if (r1 != r2) goto L_0x0317
            goto L_0x0496
        L_0x0317:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x031c:
            if (r6 != r10) goto L_0x0495
            com.google.android.gms.internal.measurement.zzlc r13 = (com.google.android.gms.internal.measurement.zzlc) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzb(r18, r19)
            r13.zzh(r1)
        L_0x0327:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x033c
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0334
            goto L_0x033c
        L_0x0334:
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzb(r3, r4)
            r13.zzh(r1)
            goto L_0x0327
        L_0x033c:
            return r1
        L_0x033d:
            if (r6 != r14) goto L_0x035d
            com.google.android.gms.internal.measurement.zzlx r13 = (com.google.android.gms.internal.measurement.zzlx) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0348:
            if (r1 >= r2) goto L_0x0354
            long r4 = com.google.android.gms.internal.measurement.zzjo.zzp(r3, r1)
            r13.zzg(r4)
            int r1 = r1 + 8
            goto L_0x0348
        L_0x0354:
            if (r1 != r2) goto L_0x0358
            goto L_0x0496
        L_0x0358:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x035d:
            if (r6 != r15) goto L_0x0495
            com.google.android.gms.internal.measurement.zzlx r13 = (com.google.android.gms.internal.measurement.zzlx) r13
            long r8 = com.google.android.gms.internal.measurement.zzjo.zzp(r18, r19)
            r13.zzg(r8)
        L_0x0368:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x037d
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0375
            goto L_0x037d
        L_0x0375:
            long r8 = com.google.android.gms.internal.measurement.zzjo.zzp(r3, r4)
            r13.zzg(r8)
            goto L_0x0368
        L_0x037d:
            return r1
        L_0x037e:
            if (r6 != r14) goto L_0x0386
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzf(r3, r4, r13, r7)
            goto L_0x0496
        L_0x0386:
            if (r6 != 0) goto L_0x0495
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r13
            r26 = r30
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzl(r21, r22, r23, r24, r25, r26)
            return r1
        L_0x0397:
            if (r6 != r14) goto L_0x03b7
            com.google.android.gms.internal.measurement.zzlx r13 = (com.google.android.gms.internal.measurement.zzlx) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03a2:
            if (r1 >= r2) goto L_0x03ae
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzm(r3, r1, r7)
            long r4 = r7.zzb
            r13.zzg(r4)
            goto L_0x03a2
        L_0x03ae:
            if (r1 != r2) goto L_0x03b2
            goto L_0x0496
        L_0x03b2:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x03b7:
            if (r6 != 0) goto L_0x0495
            com.google.android.gms.internal.measurement.zzlx r13 = (com.google.android.gms.internal.measurement.zzlx) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r13.zzg(r8)
        L_0x03c4:
            if (r1 >= r5) goto L_0x03d9
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03cf
            goto L_0x03d9
        L_0x03cf:
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r13.zzg(r8)
            goto L_0x03c4
        L_0x03d9:
            return r1
        L_0x03da:
            if (r6 != r14) goto L_0x03fe
            com.google.android.gms.internal.measurement.zzku r13 = (com.google.android.gms.internal.measurement.zzku) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03e5:
            if (r1 >= r2) goto L_0x03f5
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzb(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r13.zze(r4)
            int r1 = r1 + 4
            goto L_0x03e5
        L_0x03f5:
            if (r1 != r2) goto L_0x03f9
            goto L_0x0496
        L_0x03f9:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x03fe:
            if (r6 != r10) goto L_0x0495
            com.google.android.gms.internal.measurement.zzku r13 = (com.google.android.gms.internal.measurement.zzku) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzb(r18, r19)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r13.zze(r1)
        L_0x040d:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0426
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x041a
            goto L_0x0426
        L_0x041a:
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzb(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r13.zze(r1)
            goto L_0x040d
        L_0x0426:
            return r1
        L_0x0427:
            if (r6 != r14) goto L_0x044a
            com.google.android.gms.internal.measurement.zzkk r13 = (com.google.android.gms.internal.measurement.zzkk) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0432:
            if (r1 >= r2) goto L_0x0442
            long r4 = com.google.android.gms.internal.measurement.zzjo.zzp(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r13.zze(r4)
            int r1 = r1 + 8
            goto L_0x0432
        L_0x0442:
            if (r1 != r2) goto L_0x0445
            goto L_0x0496
        L_0x0445:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x044a:
            if (r6 != r15) goto L_0x0495
            com.google.android.gms.internal.measurement.zzkk r13 = (com.google.android.gms.internal.measurement.zzkk) r13
            long r8 = com.google.android.gms.internal.measurement.zzjo.zzp(r18, r19)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r13.zze(r8)
        L_0x0459:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0472
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0466
            goto L_0x0472
        L_0x0466:
            long r8 = com.google.android.gms.internal.measurement.zzjo.zzp(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r13.zze(r8)
            goto L_0x0459
        L_0x0472:
            return r1
        L_0x0473:
            if (r4 >= r5) goto L_0x0494
            int r8 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x047e
            goto L_0x0494
        L_0x047e:
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzc(r22, r23, r24, r25, r26, r27)
            java.lang.Object r8 = r7.zzc
            r13.add(r8)
            goto L_0x0473
        L_0x0494:
            return r4
        L_0x0495:
            r1 = r4
        L_0x0496:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzml.zzs(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzjn):int");
    }

    private final int zzt(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzw(i, 0);
    }

    private final int zzu(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzw(i, i2);
    }

    private final int zzv(int i) {
        return this.zzc[i + 2];
    }

    private final int zzw(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzx(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzy(int i) {
        return this.zzc[i + 1];
    }

    private static long zzz(Object obj, long j) {
        return ((Long) zznu.zzf(obj, j)).longValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0326, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0420, code lost:
        r4 = r4 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x04a2, code lost:
        r4 = r4 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x04f4, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x055f, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x056f, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0573, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.Object r12) {
        /*
            r11 = this;
            boolean r0 = r11.zzi
            if (r0 == 0) goto L_0x0583
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x0009:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0577
            int r4 = r11.zzy(r2)
            int r5 = zzx(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            com.google.android.gms.internal.measurement.zzkt r7 = com.google.android.gms.internal.measurement.zzkt.DOUBLE_LIST_PACKED
            int r7 = r7.zza()
            if (r5 < r7) goto L_0x0034
            com.google.android.gms.internal.measurement.zzkt r7 = com.google.android.gms.internal.measurement.zzkt.SINT64_LIST_PACKED
            int r7 = r7.zza()
            if (r5 > r7) goto L_0x0034
            int[] r7 = r11.zzc
            int r8 = r2 + 2
            r7 = r7[r8]
        L_0x0034:
            long r7 = (long) r4
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0563;
                case 1: goto L_0x0553;
                case 2: goto L_0x053c;
                case 3: goto L_0x0527;
                case 4: goto L_0x0512;
                case 5: goto L_0x0505;
                case 6: goto L_0x04f8;
                case 7: goto L_0x04e8;
                case 8: goto L_0x04b9;
                case 9: goto L_0x04a5;
                case 10: goto L_0x0485;
                case 11: goto L_0x046f;
                case 12: goto L_0x0459;
                case 13: goto L_0x044b;
                case 14: goto L_0x043d;
                case 15: goto L_0x0422;
                case 16: goto L_0x0406;
                case 17: goto L_0x03f1;
                case 18: goto L_0x03e4;
                case 19: goto L_0x03d9;
                case 20: goto L_0x03ce;
                case 21: goto L_0x03c3;
                case 22: goto L_0x03b8;
                case 23: goto L_0x03ad;
                case 24: goto L_0x03a2;
                case 25: goto L_0x0397;
                case 26: goto L_0x038c;
                case 27: goto L_0x037d;
                case 28: goto L_0x0371;
                case 29: goto L_0x0365;
                case 30: goto L_0x0359;
                case 31: goto L_0x034d;
                case 32: goto L_0x0341;
                case 33: goto L_0x0335;
                case 34: goto L_0x0329;
                case 35: goto L_0x0310;
                case 36: goto L_0x02f9;
                case 37: goto L_0x02e2;
                case 38: goto L_0x02cb;
                case 39: goto L_0x02b4;
                case 40: goto L_0x029c;
                case 41: goto L_0x0284;
                case 42: goto L_0x026a;
                case 43: goto L_0x0252;
                case 44: goto L_0x023a;
                case 45: goto L_0x0222;
                case 46: goto L_0x020a;
                case 47: goto L_0x01f2;
                case 48: goto L_0x01da;
                case 49: goto L_0x01ca;
                case 50: goto L_0x01bd;
                case 51: goto L_0x01af;
                case 52: goto L_0x01a1;
                case 53: goto L_0x018b;
                case 54: goto L_0x0175;
                case 55: goto L_0x015f;
                case 56: goto L_0x0151;
                case 57: goto L_0x0143;
                case 58: goto L_0x0135;
                case 59: goto L_0x0104;
                case 60: goto L_0x00f0;
                case 61: goto L_0x00d1;
                case 62: goto L_0x00bb;
                case 63: goto L_0x00a5;
                case 64: goto L_0x0097;
                case 65: goto L_0x0089;
                case 66: goto L_0x006e;
                case 67: goto L_0x0052;
                case 68: goto L_0x003c;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x0573
        L_0x003c:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzmi r4 = (com.google.android.gms.internal.measurement.zzmi) r4
            com.google.android.gms.internal.measurement.zzmt r5 = r11.zzB(r2)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzt(r6, r4, r5)
            goto L_0x03ee
        L_0x0052:
            boolean r5 = r11.zzT(r12, r6, r2)
            if (r5 == 0) goto L_0x0573
            long r7 = zzz(r12, r7)
            int r5 = r6 << 3
            long r9 = r7 + r7
            long r6 = r7 >> r4
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            long r5 = r9 ^ r6
            int r5 = com.google.android.gms.internal.measurement.zzki.zzy(r5)
            goto L_0x0420
        L_0x006e:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = zzp(r12, r7)
            int r5 = r6 << 3
            int r6 = r4 + r4
            int r4 = r4 >> 31
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x0550
        L_0x0089:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x056f
        L_0x0097:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x055f
        L_0x00a5:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = zzp(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzu(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0550
        L_0x00bb:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = zzp(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0550
        L_0x00d1:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzka r4 = (com.google.android.gms.internal.measurement.zzka) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzb
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x04a2
        L_0x00f0:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzmt r5 = r11.zzB(r2)
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzn(r6, r4, r5)
            goto L_0x03ee
        L_0x0104:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzka
            if (r5 == 0) goto L_0x0127
            com.google.android.gms.internal.measurement.zzka r4 = (com.google.android.gms.internal.measurement.zzka) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzb
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x04a2
        L_0x0127:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzw(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0550
        L_0x0135:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x04f4
        L_0x0143:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x055f
        L_0x0151:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x056f
        L_0x015f:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = zzp(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzu(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0550
        L_0x0175:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            long r4 = zzz(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzy(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r6)
            goto L_0x0550
        L_0x018b:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            long r4 = zzz(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzy(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r6)
            goto L_0x0550
        L_0x01a1:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x055f
        L_0x01af:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x056f
        L_0x01bd:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.lang.Object r5 = r11.zzC(r2)
            com.google.android.gms.internal.measurement.zzmd.zza(r6, r4, r5)
            goto L_0x0573
        L_0x01ca:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzmt r5 = r11.zzB(r2)
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzi(r6, r4, r5)
            goto L_0x03ee
        L_0x01da:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzs(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x01f2:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzq(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x020a:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzh(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x0222:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x023a:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzd(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x0252:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzv(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x026a:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r5 = com.google.android.gms.internal.measurement.zzmv.zza
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x0284:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x029c:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzh(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x02b4:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzk(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x02cb:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzx(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x02e2:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzm(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x02f9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x0310:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzh(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
        L_0x0326:
            int r5 = r5 + r6
            goto L_0x0550
        L_0x0329:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzr(r6, r4, r1)
            goto L_0x03ee
        L_0x0335:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzp(r6, r4, r1)
            goto L_0x03ee
        L_0x0341:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzg(r6, r4, r1)
            goto L_0x03ee
        L_0x034d:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zze(r6, r4, r1)
            goto L_0x03ee
        L_0x0359:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzc(r6, r4, r1)
            goto L_0x03ee
        L_0x0365:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzu(r6, r4, r1)
            goto L_0x03ee
        L_0x0371:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzb(r6, r4)
            goto L_0x03ee
        L_0x037d:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzmt r5 = r11.zzB(r2)
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzo(r6, r4, r5)
            goto L_0x03ee
        L_0x038c:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzt(r6, r4)
            goto L_0x03ee
        L_0x0397:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zza(r6, r4, r1)
            goto L_0x03ee
        L_0x03a2:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zze(r6, r4, r1)
            goto L_0x03ee
        L_0x03ad:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzg(r6, r4, r1)
            goto L_0x03ee
        L_0x03b8:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzj(r6, r4, r1)
            goto L_0x03ee
        L_0x03c3:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzw(r6, r4, r1)
            goto L_0x03ee
        L_0x03ce:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzl(r6, r4, r1)
            goto L_0x03ee
        L_0x03d9:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zze(r6, r4, r1)
            goto L_0x03ee
        L_0x03e4:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzg(r6, r4, r1)
        L_0x03ee:
            int r3 = r3 + r4
            goto L_0x0573
        L_0x03f1:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzmi r4 = (com.google.android.gms.internal.measurement.zzmi) r4
            com.google.android.gms.internal.measurement.zzmt r5 = r11.zzB(r2)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzt(r6, r4, r5)
            goto L_0x03ee
        L_0x0406:
            boolean r5 = r11.zzP(r12, r2)
            if (r5 == 0) goto L_0x0573
            long r7 = com.google.android.gms.internal.measurement.zznu.zzd(r12, r7)
            int r5 = r6 << 3
            long r9 = r7 + r7
            long r6 = r7 >> r4
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            long r5 = r9 ^ r6
            int r5 = com.google.android.gms.internal.measurement.zzki.zzy(r5)
        L_0x0420:
            int r4 = r4 + r5
            goto L_0x03ee
        L_0x0422:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = com.google.android.gms.internal.measurement.zznu.zzc(r12, r7)
            int r5 = r6 << 3
            int r6 = r4 + r4
            int r4 = r4 >> 31
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x0550
        L_0x043d:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x056f
        L_0x044b:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x055f
        L_0x0459:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = com.google.android.gms.internal.measurement.zznu.zzc(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzu(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0550
        L_0x046f:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = com.google.android.gms.internal.measurement.zznu.zzc(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0550
        L_0x0485:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzka r4 = (com.google.android.gms.internal.measurement.zzka) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzb
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
        L_0x04a2:
            int r4 = r4 + r6
            goto L_0x03ee
        L_0x04a5:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzmt r5 = r11.zzB(r2)
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzn(r6, r4, r5)
            goto L_0x03ee
        L_0x04b9:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzka
            if (r5 == 0) goto L_0x04db
            com.google.android.gms.internal.measurement.zzka r4 = (com.google.android.gms.internal.measurement.zzka) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzb
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x04a2
        L_0x04db:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzw(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0550
        L_0x04e8:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
        L_0x04f4:
            int r4 = r4 + 1
            goto L_0x03ee
        L_0x04f8:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x055f
        L_0x0505:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x056f
        L_0x0512:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = com.google.android.gms.internal.measurement.zznu.zzc(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzu(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0550
        L_0x0527:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            long r4 = com.google.android.gms.internal.measurement.zznu.zzd(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzy(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r6)
            goto L_0x0550
        L_0x053c:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            long r4 = com.google.android.gms.internal.measurement.zznu.zzd(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzy(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r6)
        L_0x0550:
            int r5 = r5 + r4
            int r3 = r3 + r5
            goto L_0x0573
        L_0x0553:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
        L_0x055f:
            int r4 = r4 + 4
            goto L_0x03ee
        L_0x0563:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
        L_0x056f:
            int r4 = r4 + 8
            goto L_0x03ee
        L_0x0573:
            int r2 = r2 + 3
            goto L_0x0009
        L_0x0577:
            com.google.android.gms.internal.measurement.zznk r0 = r11.zzn
            java.lang.Object r12 = r0.zzd(r12)
            int r12 = r0.zza(r12)
            int r3 = r3 + r12
            goto L_0x0587
        L_0x0583:
            int r3 = r11.zzo(r12)
        L_0x0587:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzml.zza(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01b2, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0201, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x020f, code lost:
        r2 = r2 + ((int) (r3 ^ (r3 >>> 32)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0214, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.Object r10) {
        /*
            r9 = this;
            int[] r0 = r9.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x0218
            int r3 = r9.zzy(r1)
            int[] r4 = r9.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            int r3 = zzx(r3)
            long r5 = (long) r5
            r7 = 37
            r8 = 32
            switch(r3) {
                case 0: goto L_0x0203;
                case 1: goto L_0x01f7;
                case 2: goto L_0x01ee;
                case 3: goto L_0x01e5;
                case 4: goto L_0x01de;
                case 5: goto L_0x01d5;
                case 6: goto L_0x01ce;
                case 7: goto L_0x01c3;
                case 8: goto L_0x01b6;
                case 9: goto L_0x01a8;
                case 10: goto L_0x019d;
                case 11: goto L_0x0196;
                case 12: goto L_0x018e;
                case 13: goto L_0x0186;
                case 14: goto L_0x017c;
                case 15: goto L_0x0174;
                case 16: goto L_0x016a;
                case 17: goto L_0x015f;
                case 18: goto L_0x0153;
                case 19: goto L_0x0153;
                case 20: goto L_0x0153;
                case 21: goto L_0x0153;
                case 22: goto L_0x0153;
                case 23: goto L_0x0153;
                case 24: goto L_0x0153;
                case 25: goto L_0x0153;
                case 26: goto L_0x0153;
                case 27: goto L_0x0153;
                case 28: goto L_0x0153;
                case 29: goto L_0x0153;
                case 30: goto L_0x0153;
                case 31: goto L_0x0153;
                case 32: goto L_0x0153;
                case 33: goto L_0x0153;
                case 34: goto L_0x0153;
                case 35: goto L_0x0153;
                case 36: goto L_0x0153;
                case 37: goto L_0x0153;
                case 38: goto L_0x0153;
                case 39: goto L_0x0153;
                case 40: goto L_0x0153;
                case 41: goto L_0x0153;
                case 42: goto L_0x0153;
                case 43: goto L_0x0153;
                case 44: goto L_0x0153;
                case 45: goto L_0x0153;
                case 46: goto L_0x0153;
                case 47: goto L_0x0153;
                case 48: goto L_0x0153;
                case 49: goto L_0x0153;
                case 50: goto L_0x0147;
                case 51: goto L_0x0133;
                case 52: goto L_0x0121;
                case 53: goto L_0x0111;
                case 54: goto L_0x0101;
                case 55: goto L_0x00f3;
                case 56: goto L_0x00e3;
                case 57: goto L_0x00d5;
                case 58: goto L_0x00c3;
                case 59: goto L_0x00af;
                case 60: goto L_0x009d;
                case 61: goto L_0x008b;
                case 62: goto L_0x007d;
                case 63: goto L_0x006f;
                case 64: goto L_0x0061;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0033;
                case 68: goto L_0x0021;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x0214
        L_0x0021:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x0033:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzz(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x020f
        L_0x0043:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzp(r10, r5)
            goto L_0x0201
        L_0x0051:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzz(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x020f
        L_0x0061:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzp(r10, r5)
            goto L_0x0201
        L_0x006f:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzp(r10, r5)
            goto L_0x0201
        L_0x007d:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzp(r10, r5)
            goto L_0x0201
        L_0x008b:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x009d:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x00af:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x00c3:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            boolean r3 = zzU(r10, r5)
            int r3 = com.google.android.gms.internal.measurement.zzlj.zza(r3)
            goto L_0x0201
        L_0x00d5:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzp(r10, r5)
            goto L_0x0201
        L_0x00e3:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzz(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x020f
        L_0x00f3:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzp(r10, r5)
            goto L_0x0201
        L_0x0101:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzz(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x020f
        L_0x0111:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzz(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x020f
        L_0x0121:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            float r3 = zzn(r10, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0201
        L_0x0133:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            double r3 = zzm(r10, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x020f
        L_0x0147:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x0153:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x015f:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            if (r3 == 0) goto L_0x01b2
            int r7 = r3.hashCode()
            goto L_0x01b2
        L_0x016a:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zznu.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x020f
        L_0x0174:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zznu.zzc(r10, r5)
            goto L_0x0201
        L_0x017c:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zznu.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x020f
        L_0x0186:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zznu.zzc(r10, r5)
            goto L_0x0201
        L_0x018e:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zznu.zzc(r10, r5)
            goto L_0x0201
        L_0x0196:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zznu.zzc(r10, r5)
            goto L_0x0201
        L_0x019d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x01a8:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            if (r3 == 0) goto L_0x01b2
            int r7 = r3.hashCode()
        L_0x01b2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0214
        L_0x01b6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x01c3:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.measurement.zznu.zzw(r10, r5)
            int r3 = com.google.android.gms.internal.measurement.zzlj.zza(r3)
            goto L_0x0201
        L_0x01ce:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zznu.zzc(r10, r5)
            goto L_0x0201
        L_0x01d5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zznu.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x020f
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zznu.zzc(r10, r5)
            goto L_0x0201
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zznu.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x020f
        L_0x01ee:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zznu.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x020f
        L_0x01f7:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.measurement.zznu.zzb(r10, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
        L_0x0201:
            int r2 = r2 + r3
            goto L_0x0214
        L_0x0203:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.measurement.zznu.zza(r10, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
        L_0x020f:
            long r5 = r3 >>> r8
            long r3 = r3 ^ r5
            int r4 = (int) r3
            int r2 = r2 + r4
        L_0x0214:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x0218:
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.zznk r0 = r9.zzn
            java.lang.Object r0 = r0.zzd(r10)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r9.zzh
            if (r0 != 0) goto L_0x022a
            return r2
        L_0x022a:
            com.google.android.gms.internal.measurement.zzko r0 = r9.zzo
            r0.zza(r10)
            r10 = 0
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzml.zzb(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v49, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v90, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x030c, code lost:
        if (r0 != r15) goto L_0x030e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0329, code lost:
        r2 = r0;
        r7 = r21;
        r6 = r24;
        r0 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x035d, code lost:
        if (r0 != r15) goto L_0x030e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0385, code lost:
        if (r0 != r15) goto L_0x030e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0153, code lost:
        r5 = r7 | r8;
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0156, code lost:
        r1 = r11;
        r3 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x015a, code lost:
        r12 = r6;
        r21 = r13;
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01ee, code lost:
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0221, code lost:
        r6 = r24;
        r8 = -1;
        r13 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x024f, code lost:
        r0 = r13 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0251, code lost:
        r5 = r7 | r8;
        r13 = r32;
        r2 = r6;
        r1 = r11;
        r3 = r21;
        r6 = r24;
        r8 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x025c, code lost:
        r11 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0260, code lost:
        r12 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0261, code lost:
        r0 = r33;
        r20 = r7;
        r27 = r10;
        r31 = r11;
        r22 = r12;
        r2 = r13;
        r7 = r21;
        r6 = r24;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(java.lang.Object r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.measurement.zzjn r34) throws java.io.IOException {
        /*
            r28 = this;
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            zzG(r29)
            sun.misc.Unsafe r10 = zzb
            r8 = -1
            r16 = 0
            r0 = r31
            r1 = -1
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001d:
            r17 = 0
            if (r0 >= r13) goto L_0x03f5
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0030
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzk(r0, r12, r3, r9)
            int r3 = r9.zza
            r4 = r3
            r3 = r0
            goto L_0x0031
        L_0x0030:
            r4 = r0
        L_0x0031:
            int r0 = r4 >>> 3
            r7 = 3
            if (r0 <= r1) goto L_0x003c
            int r2 = r2 / r7
            int r1 = r15.zzu(r0, r2)
            goto L_0x0040
        L_0x003c:
            int r1 = r15.zzt(r0)
        L_0x0040:
            r2 = r1
            if (r2 != r8) goto L_0x0052
            r31 = r0
            r2 = r3
            r7 = r4
            r20 = r5
            r27 = r10
            r0 = r11
            r19 = -1
            r22 = 0
            goto L_0x0388
        L_0x0052:
            r1 = r4 & 7
            int[] r8 = r15.zzc
            int r20 = r2 + 1
            r7 = r8[r20]
            int r11 = zzx(r7)
            r20 = r0
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r7 & r18
            r22 = r3
            r21 = r4
            long r3 = (long) r0
            r0 = 17
            if (r11 > r0) goto L_0x0274
            int r0 = r2 + 2
            r0 = r8[r0]
            int r8 = r0 >>> 20
            r13 = 1
            int r8 = r13 << r8
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r13
            r18 = r7
            if (r0 == r6) goto L_0x008e
            if (r6 == r13) goto L_0x0085
            long r6 = (long) r6
            r10.putInt(r14, r6, r5)
        L_0x0085:
            long r5 = (long) r0
            int r5 = r10.getInt(r14, r5)
            r24 = r0
            r7 = r5
            goto L_0x0091
        L_0x008e:
            r7 = r5
            r24 = r6
        L_0x0091:
            r0 = 5
            switch(r11) {
                case 0: goto L_0x023c;
                case 1: goto L_0x0227;
                case 2: goto L_0x0202;
                case 3: goto L_0x0202;
                case 4: goto L_0x01f1;
                case 5: goto L_0x01d6;
                case 6: goto L_0x01c4;
                case 7: goto L_0x01a9;
                case 8: goto L_0x018b;
                case 9: goto L_0x0160;
                case 10: goto L_0x0140;
                case 11: goto L_0x01f1;
                case 12: goto L_0x0111;
                case 13: goto L_0x01c4;
                case 14: goto L_0x01d6;
                case 15: goto L_0x00fa;
                case 16: goto L_0x00cb;
                default: goto L_0x0095;
            }
        L_0x0095:
            r6 = r2
            r11 = r20
            r13 = r22
            r0 = 3
            if (r1 != r0) goto L_0x0260
            java.lang.Object r5 = r15.zzD(r14, r6)
            int r0 = r11 << 3
            r17 = r0 | 4
            com.google.android.gms.internal.measurement.zzmt r1 = r15.zzB(r6)
            r0 = r5
            r2 = r30
            r3 = r13
            r4 = r32
            r13 = r5
            r5 = r17
            r12 = r6
            r6 = r34
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzn(r0, r1, r2, r3, r4, r5, r6)
            r15.zzL(r14, r12, r13)
            r5 = r7 | r8
            r13 = r32
            r1 = r11
            r2 = r12
            r3 = r21
            r6 = r24
            r8 = -1
            r12 = r30
            goto L_0x025c
        L_0x00cb:
            if (r1 != 0) goto L_0x00f3
            r5 = r22
            int r6 = com.google.android.gms.internal.measurement.zzjo.zzm(r12, r5, r9)
            long r0 = r9.zzb
            long r17 = com.google.android.gms.internal.measurement.zzke.zzc(r0)
            r11 = r20
            r0 = r10
            r1 = r29
            r5 = r2
            r2 = r3
            r20 = r6
            r13 = r21
            r6 = r5
            r4 = r17
            r0.putLong(r1, r2, r4)
            r5 = r7 | r8
            r2 = r6
            r1 = r11
            r3 = r13
            r0 = r20
            goto L_0x0221
        L_0x00f3:
            r11 = r20
            r12 = r2
            r13 = r22
            goto L_0x0261
        L_0x00fa:
            r6 = r2
            r11 = r20
            r13 = r21
            r5 = r22
            if (r1 != 0) goto L_0x015a
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzj(r12, r5, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.measurement.zzke.zzb(r1)
            r10.putInt(r14, r3, r1)
            goto L_0x0153
        L_0x0111:
            r6 = r2
            r11 = r20
            r13 = r21
            r5 = r22
            if (r1 != 0) goto L_0x015a
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzj(r12, r5, r9)
            int r1 = r9.zza
            com.google.android.gms.internal.measurement.zzlf r2 = r15.zzA(r6)
            if (r2 == 0) goto L_0x013c
            boolean r2 = r2.zza(r1)
            if (r2 == 0) goto L_0x012d
            goto L_0x013c
        L_0x012d:
            com.google.android.gms.internal.measurement.zznl r2 = zzd(r29)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzj(r13, r1)
            r2 = r6
            r5 = r7
            goto L_0x0156
        L_0x013c:
            r10.putInt(r14, r3, r1)
            goto L_0x0153
        L_0x0140:
            r6 = r2
            r11 = r20
            r13 = r21
            r5 = r22
            r0 = 2
            if (r1 != r0) goto L_0x015a
            int r0 = com.google.android.gms.internal.measurement.zzjo.zza(r12, r5, r9)
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
        L_0x0153:
            r5 = r7 | r8
            r2 = r6
        L_0x0156:
            r1 = r11
            r3 = r13
            goto L_0x0221
        L_0x015a:
            r12 = r6
            r21 = r13
            r13 = r5
            goto L_0x0261
        L_0x0160:
            r6 = r2
            r11 = r20
            r13 = r21
            r5 = r22
            r0 = 2
            if (r1 != r0) goto L_0x0187
            java.lang.Object r4 = r15.zzD(r14, r6)
            com.google.android.gms.internal.measurement.zzmt r1 = r15.zzB(r6)
            r0 = r4
            r2 = r30
            r3 = r5
            r5 = r4
            r4 = r32
            r21 = r13
            r13 = r5
            r5 = r34
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzo(r0, r1, r2, r3, r4, r5)
            r15.zzL(r14, r6, r13)
            goto L_0x0251
        L_0x0187:
            r21 = r13
            goto L_0x01ee
        L_0x018b:
            r6 = r2
            r11 = r20
            r5 = r22
            r0 = 2
            if (r1 != r0) goto L_0x01ee
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r18 & r0
            if (r0 != 0) goto L_0x019e
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzg(r12, r5, r9)
            goto L_0x01a2
        L_0x019e:
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzh(r12, r5, r9)
        L_0x01a2:
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
            goto L_0x0251
        L_0x01a9:
            r6 = r2
            r11 = r20
            r5 = r22
            if (r1 != 0) goto L_0x01ee
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzm(r12, r5, r9)
            long r1 = r9.zzb
            r17 = 0
            int r5 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r5 == 0) goto L_0x01be
            r13 = 1
            goto L_0x01bf
        L_0x01be:
            r13 = 0
        L_0x01bf:
            com.google.android.gms.internal.measurement.zznu.zzm(r14, r3, r13)
            goto L_0x0251
        L_0x01c4:
            r6 = r2
            r11 = r20
            r5 = r22
            if (r1 != r0) goto L_0x01ee
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzb(r12, r5)
            r10.putInt(r14, r3, r0)
            int r0 = r5 + 4
            goto L_0x0251
        L_0x01d6:
            r6 = r2
            r11 = r20
            r5 = r22
            r0 = 1
            if (r1 != r0) goto L_0x01ee
            long r17 = com.google.android.gms.internal.measurement.zzjo.zzp(r12, r5)
            r0 = r10
            r1 = r29
            r13 = r5
            r2 = r3
            r4 = r17
            r0.putLong(r1, r2, r4)
            goto L_0x024f
        L_0x01ee:
            r13 = r5
            goto L_0x0260
        L_0x01f1:
            r6 = r2
            r11 = r20
            r13 = r22
            if (r1 != 0) goto L_0x0260
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzj(r12, r13, r9)
            int r1 = r9.zza
            r10.putInt(r14, r3, r1)
            goto L_0x0251
        L_0x0202:
            r6 = r2
            r11 = r20
            r13 = r22
            if (r1 != 0) goto L_0x0260
            int r13 = com.google.android.gms.internal.measurement.zzjo.zzm(r12, r13, r9)
            long r1 = r9.zzb
            r0 = r10
            r17 = r1
            r1 = r29
            r2 = r3
            r4 = r17
            r0.putLong(r1, r2, r4)
            r5 = r7 | r8
            r2 = r6
            r1 = r11
            r0 = r13
            r3 = r21
        L_0x0221:
            r6 = r24
            r8 = -1
            r13 = r32
            goto L_0x025c
        L_0x0227:
            r6 = r2
            r11 = r20
            r13 = r22
            if (r1 != r0) goto L_0x0260
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzb(r12, r13)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.zznu.zzp(r14, r3, r0)
            int r0 = r13 + 4
            goto L_0x0251
        L_0x023c:
            r6 = r2
            r11 = r20
            r13 = r22
            r0 = 1
            if (r1 != r0) goto L_0x0260
            long r0 = com.google.android.gms.internal.measurement.zzjo.zzp(r12, r13)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.zznu.zzo(r14, r3, r0)
        L_0x024f:
            int r0 = r13 + 8
        L_0x0251:
            r5 = r7 | r8
            r13 = r32
            r2 = r6
            r1 = r11
            r3 = r21
            r6 = r24
            r8 = -1
        L_0x025c:
            r11 = r33
            goto L_0x001d
        L_0x0260:
            r12 = r6
        L_0x0261:
            r0 = r33
            r20 = r7
            r27 = r10
            r31 = r11
            r22 = r12
            r2 = r13
            r7 = r21
            r6 = r24
            r19 = -1
            goto L_0x0388
        L_0x0274:
            r12 = r2
            r18 = r7
            r8 = r20
            r13 = r22
            r0 = 27
            if (r11 != r0) goto L_0x02d6
            r0 = 2
            if (r1 != r0) goto L_0x02c7
            java.lang.Object r0 = r10.getObject(r14, r3)
            com.google.android.gms.internal.measurement.zzli r0 = (com.google.android.gms.internal.measurement.zzli) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x029f
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0297
            r1 = 10
            goto L_0x0298
        L_0x0297:
            int r1 = r1 + r1
        L_0x0298:
            com.google.android.gms.internal.measurement.zzli r0 = r0.zzd(r1)
            r10.putObject(r14, r3, r0)
        L_0x029f:
            r7 = r0
            com.google.android.gms.internal.measurement.zzmt r0 = r15.zzB(r12)
            r1 = r21
            r2 = r30
            r3 = r13
            r4 = r32
            r20 = r5
            r5 = r7
            r24 = r6
            r6 = r34
            int r0 = com.google.android.gms.internal.measurement.zzjo.zze(r0, r1, r2, r3, r4, r5, r6)
            r13 = r32
            r11 = r33
            r1 = r8
            r2 = r12
            r5 = r20
            r3 = r21
            r6 = r24
            r8 = -1
            r12 = r30
            goto L_0x001d
        L_0x02c7:
            r20 = r5
            r24 = r6
            r31 = r8
            r27 = r10
            r22 = r12
            r15 = r13
            r19 = -1
            goto L_0x0360
        L_0x02d6:
            r20 = r5
            r24 = r6
            r0 = 49
            if (r11 > r0) goto L_0x0332
            r7 = r18
            long r6 = (long) r7
            r0 = r28
            r5 = r1
            r1 = r29
            r2 = r30
            r25 = r3
            r3 = r13
            r4 = r32
            r18 = r5
            r5 = r21
            r22 = r6
            r6 = r8
            r7 = r18
            r31 = r8
            r19 = -1
            r8 = r12
            r27 = r10
            r9 = r22
            r15 = r33
            r22 = r12
            r15 = r13
            r12 = r25
            r14 = r34
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x0329
        L_0x030e:
            r15 = r28
            r14 = r29
            r12 = r30
            r1 = r31
            r13 = r32
            r11 = r33
            r9 = r34
            r5 = r20
            r3 = r21
            r2 = r22
            r6 = r24
            r10 = r27
            r8 = -1
            goto L_0x001d
        L_0x0329:
            r2 = r0
            r7 = r21
            r6 = r24
            r0 = r33
            goto L_0x0388
        L_0x0332:
            r25 = r3
            r31 = r8
            r27 = r10
            r22 = r12
            r15 = r13
            r7 = r18
            r19 = -1
            r18 = r1
            r0 = 50
            if (r11 != r0) goto L_0x0368
            r8 = r18
            r0 = 2
            if (r8 != r0) goto L_0x0360
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r22
            r6 = r25
            r8 = r34
            int r0 = r0.zzq(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x0329
            goto L_0x030e
        L_0x0360:
            r0 = r33
            r2 = r15
            r7 = r21
            r6 = r24
            goto L_0x0388
        L_0x0368:
            r8 = r18
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r21
            r6 = r31
            r9 = r7
            r7 = r8
            r8 = r9
            r9 = r11
            r10 = r25
            r12 = r22
            r13 = r34
            int r0 = r0.zzr(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x0329
            goto L_0x030e
        L_0x0388:
            if (r7 != r0) goto L_0x0397
            if (r0 == 0) goto L_0x0397
            r8 = r28
            r12 = r29
            r9 = r0
            r0 = r2
            r3 = r7
            r5 = r20
            goto L_0x03fe
        L_0x0397:
            r8 = r28
            r9 = r0
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x03cd
            r10 = r34
            com.google.android.gms.internal.measurement.zzkn r0 = r10.zzd
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zza
            if (r0 == r1) goto L_0x03c8
            com.google.android.gms.internal.measurement.zzmi r1 = r8.zzg
            r11 = r31
            com.google.android.gms.internal.measurement.zzkz r0 = r0.zzb(r1, r11)
            if (r0 != 0) goto L_0x03c2
            com.google.android.gms.internal.measurement.zznl r4 = zzd(r29)
            r0 = r7
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzi(r0, r1, r2, r3, r4, r5)
            r12 = r29
            goto L_0x03e2
        L_0x03c2:
            r12 = r29
            r0 = r12
            com.google.android.gms.internal.measurement.zzky r0 = (com.google.android.gms.internal.measurement.zzky) r0
            throw r17
        L_0x03c8:
            r12 = r29
            r11 = r31
            goto L_0x03d3
        L_0x03cd:
            r12 = r29
            r11 = r31
            r10 = r34
        L_0x03d3:
            com.google.android.gms.internal.measurement.zznl r4 = zzd(r29)
            r0 = r7
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzi(r0, r1, r2, r3, r4, r5)
        L_0x03e2:
            r13 = r32
            r3 = r7
            r15 = r8
            r1 = r11
            r14 = r12
            r5 = r20
            r2 = r22
            r8 = -1
            r12 = r30
            r11 = r9
            r9 = r10
            r10 = r27
            goto L_0x001d
        L_0x03f5:
            r20 = r5
            r24 = r6
            r27 = r10
            r9 = r11
            r12 = r14
            r8 = r15
        L_0x03fe:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r6 == r1) goto L_0x0409
            long r6 = (long) r6
            r2 = r27
            r2.putInt(r12, r6, r5)
        L_0x0409:
            int r2 = r8.zzk
        L_0x040b:
            int r4 = r8.zzl
            if (r2 >= r4) goto L_0x0436
            int[] r4 = r8.zzj
            r4 = r4[r2]
            int[] r5 = r8.zzc
            r5 = r5[r4]
            int r5 = r8.zzy(r4)
            r5 = r5 & r1
            long r5 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r5)
            if (r5 != 0) goto L_0x0424
            goto L_0x042a
        L_0x0424:
            com.google.android.gms.internal.measurement.zzlf r6 = r8.zzA(r4)
            if (r6 != 0) goto L_0x042d
        L_0x042a:
            int r2 = r2 + 1
            goto L_0x040b
        L_0x042d:
            com.google.android.gms.internal.measurement.zzmc r5 = (com.google.android.gms.internal.measurement.zzmc) r5
            java.lang.Object r0 = r8.zzC(r4)
            com.google.android.gms.internal.measurement.zzmb r0 = (com.google.android.gms.internal.measurement.zzmb) r0
            throw r17
        L_0x0436:
            if (r9 != 0) goto L_0x0442
            r1 = r32
            if (r0 != r1) goto L_0x043d
            goto L_0x0448
        L_0x043d:
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.internal.measurement.zzll.zze()
            throw r0
        L_0x0442:
            r1 = r32
            if (r0 > r1) goto L_0x0449
            if (r3 != r9) goto L_0x0449
        L_0x0448:
            return r0
        L_0x0449:
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.internal.measurement.zzll.zze()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzml.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzjn):int");
    }

    public final Object zze() {
        return ((zzlb) this.zzg).zzbD();
    }

    public final void zzf(Object obj) {
        if (zzS(obj)) {
            if (obj instanceof zzlb) {
                zzlb zzlb = (zzlb) obj;
                zzlb.zzbP(Integer.MAX_VALUE);
                zzlb.zzb = 0;
                zzlb.zzbN();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzy = zzy(i);
                int i2 = 1048575 & zzy;
                int zzx = zzx(zzy);
                long j = (long) i2;
                if (zzx != 9) {
                    if (zzx == 60 || zzx == 68) {
                        if (zzT(obj, this.zzc[i], i)) {
                            zzB(i).zzf(zzb.getObject(obj, j));
                        }
                    } else {
                        switch (zzx) {
                            case 17:
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.zzm.zza(obj, j);
                                continue;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzmc) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (zzP(obj, i)) {
                    zzB(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzn.zzg(obj);
            if (this.zzh) {
                this.zzo.zzb(obj);
            }
        }
    }

    public final void zzg(Object obj, Object obj2) {
        zzG(obj);
        Objects.requireNonNull(obj2);
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzy = zzy(i);
            int i2 = this.zzc[i];
            long j = (long) (1048575 & zzy);
            switch (zzx(zzy)) {
                case 0:
                    if (!zzP(obj2, i)) {
                        break;
                    } else {
                        zznu.zzo(obj, j, zznu.zza(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 1:
                    if (!zzP(obj2, i)) {
                        break;
                    } else {
                        zznu.zzp(obj, j, zznu.zzb(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 2:
                    if (!zzP(obj2, i)) {
                        break;
                    } else {
                        zznu.zzr(obj, j, zznu.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 3:
                    if (!zzP(obj2, i)) {
                        break;
                    } else {
                        zznu.zzr(obj, j, zznu.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 4:
                    if (!zzP(obj2, i)) {
                        break;
                    } else {
                        zznu.zzq(obj, j, zznu.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 5:
                    if (!zzP(obj2, i)) {
                        break;
                    } else {
                        zznu.zzr(obj, j, zznu.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 6:
                    if (!zzP(obj2, i)) {
                        break;
                    } else {
                        zznu.zzq(obj, j, zznu.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 7:
                    if (!zzP(obj2, i)) {
                        break;
                    } else {
                        zznu.zzm(obj, j, zznu.zzw(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 8:
                    if (!zzP(obj2, i)) {
                        break;
                    } else {
                        zznu.zzs(obj, j, zznu.zzf(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 9:
                    zzH(obj, obj2, i);
                    break;
                case 10:
                    if (!zzP(obj2, i)) {
                        break;
                    } else {
                        zznu.zzs(obj, j, zznu.zzf(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 11:
                    if (!zzP(obj2, i)) {
                        break;
                    } else {
                        zznu.zzq(obj, j, zznu.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 12:
                    if (!zzP(obj2, i)) {
                        break;
                    } else {
                        zznu.zzq(obj, j, zznu.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 13:
                    if (!zzP(obj2, i)) {
                        break;
                    } else {
                        zznu.zzq(obj, j, zznu.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 14:
                    if (!zzP(obj2, i)) {
                        break;
                    } else {
                        zznu.zzr(obj, j, zznu.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 15:
                    if (!zzP(obj2, i)) {
                        break;
                    } else {
                        zznu.zzq(obj, j, zznu.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 16:
                    if (!zzP(obj2, i)) {
                        break;
                    } else {
                        zznu.zzr(obj, j, zznu.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 17:
                    zzH(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzm.zzb(obj, obj2, j);
                    break;
                case 50:
                    int i3 = zzmv.zza;
                    zznu.zzs(obj, j, zzmd.zzb(zznu.zzf(obj, j), zznu.zzf(obj2, j)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzT(obj2, i2, i)) {
                        break;
                    } else {
                        zznu.zzs(obj, j, zznu.zzf(obj2, j));
                        zzK(obj, i2, i);
                        break;
                    }
                case 60:
                    zzI(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzT(obj2, i2, i)) {
                        break;
                    } else {
                        zznu.zzs(obj, j, zznu.zzf(obj2, j));
                        zzK(obj, i2, i);
                        break;
                    }
                case 68:
                    zzI(obj, obj2, i);
                    break;
            }
        }
        zzmv.zzC(this.zzn, obj, obj2);
        if (this.zzh) {
            this.zzo.zza(obj2);
            throw null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0300, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x032c, code lost:
        if (r0 != r14) goto L_0x02ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x034f, code lost:
        if (r0 != r14) goto L_0x02ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0116, code lost:
        r6 = r6 | r10;
        r13 = r34;
        r9 = r7;
        r2 = r15;
        r7 = r20;
        r1 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0149, code lost:
        r13 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x021f, code lost:
        r0 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x023d, code lost:
        r6 = r6 | r10;
        r9 = r7;
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0240, code lost:
        r7 = r20;
        r1 = r23;
        r8 = 1048575;
        r10 = -1;
        r15 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0249, code lost:
        r13 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x024d, code lost:
        r2 = r4;
        r29 = r7;
        r7 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02ed, code lost:
        if (r0 != r24) goto L_0x02ef;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(java.lang.Object r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.measurement.zzjn r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            boolean r0 = r15.zzi
            if (r0 == 0) goto L_0x0394
            zzG(r31)
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r33
            r1 = -1
            r2 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0021:
            if (r0 >= r13) goto L_0x0377
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0033
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzk(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x0036
        L_0x0033:
            r17 = r0
            r4 = r3
        L_0x0036:
            int r5 = r17 >>> 3
            if (r5 <= r1) goto L_0x0041
            int r2 = r2 / 3
            int r0 = r15.zzu(r5, r2)
            goto L_0x0045
        L_0x0041:
            int r0 = r15.zzt(r5)
        L_0x0045:
            r2 = r0
            if (r2 != r10) goto L_0x0052
            r2 = r4
            r23 = r5
            r29 = r9
            r15 = 0
        L_0x004e:
            r18 = -1
            goto L_0x0352
        L_0x0052:
            r3 = r17 & 7
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r13 = zzx(r1)
            r10 = r1 & r8
            r19 = r9
            long r8 = (long) r10
            r10 = 17
            r33 = r5
            if (r13 > r10) goto L_0x0254
            int r10 = r2 + 2
            r0 = r0[r10]
            int r10 = r0 >>> 20
            r5 = 1
            int r10 = r5 << r10
            r15 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r15
            r22 = r1
            r20 = r2
            if (r0 == r7) goto L_0x0092
            if (r7 == r15) goto L_0x0085
            long r1 = (long) r7
            r7 = r19
            r7.putInt(r14, r1, r6)
            goto L_0x0087
        L_0x0085:
            r7 = r19
        L_0x0087:
            if (r0 == r15) goto L_0x008f
            long r1 = (long) r0
            int r1 = r7.getInt(r14, r1)
            r6 = r1
        L_0x008f:
            r2 = r7
            r7 = r0
            goto L_0x0094
        L_0x0092:
            r2 = r19
        L_0x0094:
            r0 = 5
            switch(r13) {
                case 0: goto L_0x0222;
                case 1: goto L_0x0206;
                case 2: goto L_0x01e5;
                case 3: goto L_0x01e5;
                case 4: goto L_0x01cd;
                case 5: goto L_0x01ad;
                case 6: goto L_0x0196;
                case 7: goto L_0x0175;
                case 8: goto L_0x0150;
                case 9: goto L_0x0121;
                case 10: goto L_0x0103;
                case 11: goto L_0x01cd;
                case 12: goto L_0x00f0;
                case 13: goto L_0x0196;
                case 14: goto L_0x01ad;
                case 15: goto L_0x00d9;
                case 16: goto L_0x00a6;
                default: goto L_0x0098;
            }
        L_0x0098:
            r13 = r30
            r23 = r33
            r15 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            goto L_0x024d
        L_0x00a6:
            if (r3 != 0) goto L_0x00d0
            int r13 = com.google.android.gms.internal.measurement.zzjo.zzm(r12, r4, r11)
            long r0 = r11.zzb
            long r4 = com.google.android.gms.internal.measurement.zzke.zzc(r0)
            r0 = r2
            r1 = r31
            r15 = r20
            r20 = r7
            r7 = r2
            r2 = r8
            r23 = r33
            r0.putLong(r1, r2, r4)
            r6 = r6 | r10
            r9 = r7
            r0 = r13
            r2 = r15
            r7 = r20
            r1 = r23
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r15 = r30
            goto L_0x0249
        L_0x00d0:
            r23 = r33
            r15 = r20
            r20 = r7
            r7 = r2
            goto L_0x0149
        L_0x00d9:
            r23 = r33
            r15 = r20
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x0149
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzj(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.measurement.zzke.zzb(r1)
            r7.putInt(r14, r8, r1)
            goto L_0x0116
        L_0x00f0:
            r23 = r33
            r15 = r20
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x0149
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzj(r12, r4, r11)
            int r1 = r11.zza
            r7.putInt(r14, r8, r1)
            goto L_0x0116
        L_0x0103:
            r23 = r33
            r15 = r20
            r0 = 2
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x0149
            int r0 = com.google.android.gms.internal.measurement.zzjo.zza(r12, r4, r11)
            java.lang.Object r1 = r11.zzc
            r7.putObject(r14, r8, r1)
        L_0x0116:
            r6 = r6 | r10
            r13 = r34
            r9 = r7
            r2 = r15
            r7 = r20
            r1 = r23
            goto L_0x036f
        L_0x0121:
            r23 = r33
            r15 = r20
            r0 = 2
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x0149
            r13 = r30
            r19 = 1048575(0xfffff, float:1.469367E-39)
            java.lang.Object r8 = r13.zzD(r14, r15)
            com.google.android.gms.internal.measurement.zzmt r1 = r13.zzB(r15)
            r0 = r8
            r2 = r32
            r3 = r4
            r4 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzo(r0, r1, r2, r3, r4, r5)
            r13.zzL(r14, r15, r8)
            goto L_0x023d
        L_0x0149:
            r13 = r30
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x024d
        L_0x0150:
            r13 = r30
            r23 = r33
            r15 = r20
            r0 = 2
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x024d
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r22 & r0
            if (r0 != 0) goto L_0x016a
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzg(r12, r4, r11)
            goto L_0x016e
        L_0x016a:
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzh(r12, r4, r11)
        L_0x016e:
            java.lang.Object r1 = r11.zzc
            r7.putObject(r14, r8, r1)
            goto L_0x023d
        L_0x0175:
            r13 = r30
            r23 = r33
            r15 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x024d
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzm(r12, r4, r11)
            long r1 = r11.zzb
            r3 = 0
            int r17 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r17 == 0) goto L_0x0190
            goto L_0x0191
        L_0x0190:
            r5 = 0
        L_0x0191:
            com.google.android.gms.internal.measurement.zznu.zzm(r14, r8, r5)
            goto L_0x023d
        L_0x0196:
            r13 = r30
            r23 = r33
            r15 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x024d
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzb(r12, r4)
            r7.putInt(r14, r8, r0)
            goto L_0x021f
        L_0x01ad:
            r13 = r30
            r23 = r33
            r15 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r5) goto L_0x024d
            long r21 = com.google.android.gms.internal.measurement.zzjo.zzp(r12, r4)
            r0 = r7
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x023d
        L_0x01cd:
            r13 = r30
            r23 = r33
            r15 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x024d
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzj(r12, r4, r11)
            int r1 = r11.zza
            r7.putInt(r14, r8, r1)
            goto L_0x023d
        L_0x01e5:
            r13 = r30
            r23 = r33
            r15 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x024d
            int r17 = com.google.android.gms.internal.measurement.zzjo.zzm(r12, r4, r11)
            long r4 = r11.zzb
            r0 = r7
            r1 = r31
            r2 = r8
            r0.putLong(r1, r2, r4)
            r6 = r6 | r10
            r9 = r7
            r2 = r15
            r0 = r17
            goto L_0x0240
        L_0x0206:
            r13 = r30
            r23 = r33
            r15 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x024d
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzb(r12, r4)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.zznu.zzp(r14, r8, r0)
        L_0x021f:
            int r0 = r4 + 4
            goto L_0x023d
        L_0x0222:
            r13 = r30
            r23 = r33
            r15 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r5) goto L_0x024d
            long r0 = com.google.android.gms.internal.measurement.zzjo.zzp(r12, r4)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.zznu.zzo(r14, r8, r0)
            int r0 = r4 + 8
        L_0x023d:
            r6 = r6 | r10
            r9 = r7
            r2 = r15
        L_0x0240:
            r7 = r20
            r1 = r23
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r15 = r13
        L_0x0249:
            r13 = r34
            goto L_0x0021
        L_0x024d:
            r2 = r4
            r29 = r7
            r7 = r20
            goto L_0x004e
        L_0x0254:
            r23 = r33
            r22 = r1
            r20 = r7
            r10 = r15
            r7 = r19
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r15 = r2
            r0 = 27
            if (r13 != r0) goto L_0x02b3
            r0 = 2
            if (r3 != r0) goto L_0x02a8
            java.lang.Object r0 = r7.getObject(r14, r8)
            com.google.android.gms.internal.measurement.zzli r0 = (com.google.android.gms.internal.measurement.zzli) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0285
            int r1 = r0.size()
            if (r1 != 0) goto L_0x027d
            r1 = 10
            goto L_0x027e
        L_0x027d:
            int r1 = r1 + r1
        L_0x027e:
            com.google.android.gms.internal.measurement.zzli r0 = r0.zzd(r1)
            r7.putObject(r14, r8, r0)
        L_0x0285:
            r5 = r0
            com.google.android.gms.internal.measurement.zzmt r0 = r10.zzB(r15)
            r1 = r17
            r2 = r32
            r3 = r4
            r4 = r34
            r8 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.measurement.zzjo.zze(r0, r1, r2, r3, r4, r5, r6)
            r13 = r34
            r9 = r7
            r6 = r8
            r2 = r15
            r7 = r20
            r1 = r23
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r15 = r10
            r10 = -1
            goto L_0x0021
        L_0x02a8:
            r14 = r4
            r25 = r6
            r29 = r7
            r26 = r20
            r18 = -1
            goto L_0x032f
        L_0x02b3:
            r0 = 49
            if (r13 > r0) goto L_0x0302
            r1 = r22
            long r1 = (long) r1
            r0 = r30
            r21 = r1
            r1 = r31
            r2 = r32
            r5 = r3
            r3 = r4
            r24 = r4
            r4 = r34
            r33 = r5
            r5 = r17
            r25 = r6
            r6 = r23
            r26 = r20
            r20 = r7
            r7 = r33
            r27 = r8
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r15
            r29 = r20
            r18 = -1
            r9 = r21
            r11 = r13
            r12 = r27
            r14 = r35
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            r14 = r24
            if (r0 == r14) goto L_0x0300
        L_0x02ef:
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r15
            r1 = r23
            r6 = r25
            r7 = r26
            goto L_0x036d
        L_0x0300:
            r2 = r0
            goto L_0x0330
        L_0x0302:
            r33 = r3
            r14 = r4
            r25 = r6
            r29 = r7
            r27 = r8
            r26 = r20
            r1 = r22
            r18 = -1
            r0 = 50
            if (r13 != r0) goto L_0x0335
            r7 = r33
            r0 = 2
            if (r7 != r0) goto L_0x032f
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r14
            r4 = r34
            r5 = r15
            r6 = r27
            r8 = r35
            int r0 = r0.zzq(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r14) goto L_0x0300
            goto L_0x02ef
        L_0x032f:
            r2 = r14
        L_0x0330:
            r6 = r25
            r7 = r26
            goto L_0x0352
        L_0x0335:
            r7 = r33
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r14
            r4 = r34
            r5 = r17
            r6 = r23
            r9 = r13
            r10 = r27
            r12 = r15
            r13 = r35
            int r0 = r0.zzr(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r14) goto L_0x0300
            goto L_0x02ef
        L_0x0352:
            com.google.android.gms.internal.measurement.zznl r4 = zzd(r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzi(r0, r1, r2, r3, r4, r5)
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r15
            r1 = r23
        L_0x036d:
            r9 = r29
        L_0x036f:
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r15 = r30
            goto L_0x0021
        L_0x0377:
            r25 = r6
            r29 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x038a
            long r1 = (long) r7
            r3 = r31
            r6 = r25
            r4 = r29
            r4.putInt(r3, r1, r6)
        L_0x038a:
            r4 = r34
            if (r0 != r4) goto L_0x038f
            return
        L_0x038f:
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.internal.measurement.zzll.zze()
            throw r0
        L_0x0394:
            r4 = r13
            r3 = r14
            r5 = 0
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r33
            r4 = r34
            r6 = r35
            r0.zzc(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzml.zzh(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzjn):void");
    }

    public final boolean zzj(Object obj, Object obj2) {
        boolean z;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzy = zzy(i);
            long j = (long) (zzy & 1048575);
            switch (zzx(zzy)) {
                case 0:
                    if (zzO(obj, obj2, i) && Double.doubleToLongBits(zznu.zza(obj, j)) == Double.doubleToLongBits(zznu.zza(obj2, j))) {
                        continue;
                    }
                case 1:
                    if (zzO(obj, obj2, i) && Float.floatToIntBits(zznu.zzb(obj, j)) == Float.floatToIntBits(zznu.zzb(obj2, j))) {
                        continue;
                    }
                case 2:
                    if (zzO(obj, obj2, i) && zznu.zzd(obj, j) == zznu.zzd(obj2, j)) {
                        continue;
                    }
                case 3:
                    if (zzO(obj, obj2, i) && zznu.zzd(obj, j) == zznu.zzd(obj2, j)) {
                        continue;
                    }
                case 4:
                    if (zzO(obj, obj2, i) && zznu.zzc(obj, j) == zznu.zzc(obj2, j)) {
                        continue;
                    }
                case 5:
                    if (zzO(obj, obj2, i) && zznu.zzd(obj, j) == zznu.zzd(obj2, j)) {
                        continue;
                    }
                case 6:
                    if (zzO(obj, obj2, i) && zznu.zzc(obj, j) == zznu.zzc(obj2, j)) {
                        continue;
                    }
                case 7:
                    if (zzO(obj, obj2, i) && zznu.zzw(obj, j) == zznu.zzw(obj2, j)) {
                        continue;
                    }
                case 8:
                    if (zzO(obj, obj2, i) && zzmv.zzW(zznu.zzf(obj, j), zznu.zzf(obj2, j))) {
                        continue;
                    }
                case 9:
                    if (zzO(obj, obj2, i) && zzmv.zzW(zznu.zzf(obj, j), zznu.zzf(obj2, j))) {
                        continue;
                    }
                case 10:
                    if (zzO(obj, obj2, i) && zzmv.zzW(zznu.zzf(obj, j), zznu.zzf(obj2, j))) {
                        continue;
                    }
                case 11:
                    if (zzO(obj, obj2, i) && zznu.zzc(obj, j) == zznu.zzc(obj2, j)) {
                        continue;
                    }
                case 12:
                    if (zzO(obj, obj2, i) && zznu.zzc(obj, j) == zznu.zzc(obj2, j)) {
                        continue;
                    }
                case 13:
                    if (zzO(obj, obj2, i) && zznu.zzc(obj, j) == zznu.zzc(obj2, j)) {
                        continue;
                    }
                case 14:
                    if (zzO(obj, obj2, i) && zznu.zzd(obj, j) == zznu.zzd(obj2, j)) {
                        continue;
                    }
                case 15:
                    if (zzO(obj, obj2, i) && zznu.zzc(obj, j) == zznu.zzc(obj2, j)) {
                        continue;
                    }
                case 16:
                    if (zzO(obj, obj2, i) && zznu.zzd(obj, j) == zznu.zzd(obj2, j)) {
                        continue;
                    }
                case 17:
                    if (zzO(obj, obj2, i) && zzmv.zzW(zznu.zzf(obj, j), zznu.zzf(obj2, j))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z = zzmv.zzW(zznu.zzf(obj, j), zznu.zzf(obj2, j));
                    break;
                case 50:
                    z = zzmv.zzW(zznu.zzf(obj, j), zznu.zzf(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzv = (long) (zzv(i) & 1048575);
                    if (zznu.zzc(obj, zzv) == zznu.zzc(obj2, zzv) && zzmv.zzW(zznu.zzf(obj, j), zznu.zzf(obj2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzn.zzd(obj).equals(this.zzn.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        int i;
        int i2;
        Object obj2 = obj;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzk) {
            int i6 = this.zzj[i5];
            int i7 = this.zzc[i6];
            int zzy = zzy(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(obj2, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if ((268435456 & zzy) != 0 && !zzQ(obj, i6, i2, i, i10)) {
                return false;
            }
            int zzx = zzx(zzy);
            if (zzx != 9 && zzx != 17) {
                if (zzx != 27) {
                    if (zzx == 60 || zzx == 68) {
                        if (zzT(obj2, i7, i6) && !zzR(obj2, zzy, zzB(i6))) {
                            return false;
                        }
                    } else if (zzx != 49) {
                        if (zzx == 50 && !((zzmc) zznu.zzf(obj2, (long) (zzy & 1048575))).isEmpty()) {
                            zzmb zzmb = (zzmb) zzC(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zznu.zzf(obj2, (long) (zzy & 1048575));
                if (!list.isEmpty()) {
                    zzmt zzB = zzB(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzB.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzQ(obj, i6, i2, i, i10) && !zzR(obj2, zzy, zzB(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj2);
        throw null;
    }

    public final void zzi(Object obj, zzoc zzoc) throws IOException {
        int i;
        Object obj2 = obj;
        zzoc zzoc2 = zzoc;
        int i2 = 1048575;
        if (this.zzi) {
            if (!this.zzh) {
                int length = this.zzc.length;
                for (int i3 = 0; i3 < length; i3 += 3) {
                    int zzy = zzy(i3);
                    int i4 = this.zzc[i3];
                    switch (zzx(zzy)) {
                        case 0:
                            if (!zzP(obj2, i3)) {
                                break;
                            } else {
                                zzoc2.zzf(i4, zznu.zza(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 1:
                            if (!zzP(obj2, i3)) {
                                break;
                            } else {
                                zzoc2.zzo(i4, zznu.zzb(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 2:
                            if (!zzP(obj2, i3)) {
                                break;
                            } else {
                                zzoc2.zzt(i4, zznu.zzd(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 3:
                            if (!zzP(obj2, i3)) {
                                break;
                            } else {
                                zzoc2.zzJ(i4, zznu.zzd(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 4:
                            if (!zzP(obj2, i3)) {
                                break;
                            } else {
                                zzoc2.zzr(i4, zznu.zzc(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 5:
                            if (!zzP(obj2, i3)) {
                                break;
                            } else {
                                zzoc2.zzm(i4, zznu.zzd(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 6:
                            if (!zzP(obj2, i3)) {
                                break;
                            } else {
                                zzoc2.zzk(i4, zznu.zzc(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 7:
                            if (!zzP(obj2, i3)) {
                                break;
                            } else {
                                zzoc2.zzb(i4, zznu.zzw(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 8:
                            if (!zzP(obj2, i3)) {
                                break;
                            } else {
                                zzV(i4, zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2);
                                break;
                            }
                        case 9:
                            if (!zzP(obj2, i3)) {
                                break;
                            } else {
                                zzoc2.zzv(i4, zznu.zzf(obj2, (long) (zzy & 1048575)), zzB(i3));
                                break;
                            }
                        case 10:
                            if (!zzP(obj2, i3)) {
                                break;
                            } else {
                                zzoc2.zzd(i4, (zzka) zznu.zzf(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 11:
                            if (!zzP(obj2, i3)) {
                                break;
                            } else {
                                zzoc2.zzH(i4, zznu.zzc(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 12:
                            if (!zzP(obj2, i3)) {
                                break;
                            } else {
                                zzoc2.zzi(i4, zznu.zzc(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 13:
                            if (!zzP(obj2, i3)) {
                                break;
                            } else {
                                zzoc2.zzw(i4, zznu.zzc(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 14:
                            if (!zzP(obj2, i3)) {
                                break;
                            } else {
                                zzoc2.zzy(i4, zznu.zzd(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 15:
                            if (!zzP(obj2, i3)) {
                                break;
                            } else {
                                zzoc2.zzA(i4, zznu.zzc(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 16:
                            if (!zzP(obj2, i3)) {
                                break;
                            } else {
                                zzoc2.zzC(i4, zznu.zzd(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 17:
                            if (!zzP(obj2, i3)) {
                                break;
                            } else {
                                zzoc2.zzq(i4, zznu.zzf(obj2, (long) (zzy & 1048575)), zzB(i3));
                                break;
                            }
                        case 18:
                            zzmv.zzG(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, false);
                            break;
                        case 19:
                            zzmv.zzK(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, false);
                            break;
                        case 20:
                            zzmv.zzN(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, false);
                            break;
                        case 21:
                            zzmv.zzV(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, false);
                            break;
                        case 22:
                            zzmv.zzM(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, false);
                            break;
                        case 23:
                            zzmv.zzJ(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, false);
                            break;
                        case 24:
                            zzmv.zzI(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, false);
                            break;
                        case 25:
                            zzmv.zzE(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, false);
                            break;
                        case 26:
                            zzmv.zzT(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2);
                            break;
                        case 27:
                            zzmv.zzO(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, zzB(i3));
                            break;
                        case 28:
                            zzmv.zzF(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2);
                            break;
                        case 29:
                            zzmv.zzU(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, false);
                            break;
                        case 30:
                            zzmv.zzH(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, false);
                            break;
                        case 31:
                            zzmv.zzP(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, false);
                            break;
                        case 32:
                            zzmv.zzQ(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, false);
                            break;
                        case 33:
                            zzmv.zzR(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, false);
                            break;
                        case 34:
                            zzmv.zzS(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, false);
                            break;
                        case 35:
                            zzmv.zzG(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, true);
                            break;
                        case 36:
                            zzmv.zzK(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, true);
                            break;
                        case 37:
                            zzmv.zzN(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, true);
                            break;
                        case 38:
                            zzmv.zzV(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, true);
                            break;
                        case 39:
                            zzmv.zzM(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, true);
                            break;
                        case 40:
                            zzmv.zzJ(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, true);
                            break;
                        case 41:
                            zzmv.zzI(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, true);
                            break;
                        case 42:
                            zzmv.zzE(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, true);
                            break;
                        case 43:
                            zzmv.zzU(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, true);
                            break;
                        case 44:
                            zzmv.zzH(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, true);
                            break;
                        case 45:
                            zzmv.zzP(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, true);
                            break;
                        case 46:
                            zzmv.zzQ(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, true);
                            break;
                        case 47:
                            zzmv.zzR(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, true);
                            break;
                        case 48:
                            zzmv.zzS(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, true);
                            break;
                        case 49:
                            zzmv.zzL(i4, (List) zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2, zzB(i3));
                            break;
                        case 50:
                            zzN(zzoc2, i4, zznu.zzf(obj2, (long) (zzy & 1048575)), i3);
                            break;
                        case 51:
                            if (!zzT(obj2, i4, i3)) {
                                break;
                            } else {
                                zzoc2.zzf(i4, zzm(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 52:
                            if (!zzT(obj2, i4, i3)) {
                                break;
                            } else {
                                zzoc2.zzo(i4, zzn(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 53:
                            if (!zzT(obj2, i4, i3)) {
                                break;
                            } else {
                                zzoc2.zzt(i4, zzz(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 54:
                            if (!zzT(obj2, i4, i3)) {
                                break;
                            } else {
                                zzoc2.zzJ(i4, zzz(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 55:
                            if (!zzT(obj2, i4, i3)) {
                                break;
                            } else {
                                zzoc2.zzr(i4, zzp(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 56:
                            if (!zzT(obj2, i4, i3)) {
                                break;
                            } else {
                                zzoc2.zzm(i4, zzz(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 57:
                            if (!zzT(obj2, i4, i3)) {
                                break;
                            } else {
                                zzoc2.zzk(i4, zzp(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 58:
                            if (!zzT(obj2, i4, i3)) {
                                break;
                            } else {
                                zzoc2.zzb(i4, zzU(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 59:
                            if (!zzT(obj2, i4, i3)) {
                                break;
                            } else {
                                zzV(i4, zznu.zzf(obj2, (long) (zzy & 1048575)), zzoc2);
                                break;
                            }
                        case 60:
                            if (!zzT(obj2, i4, i3)) {
                                break;
                            } else {
                                zzoc2.zzv(i4, zznu.zzf(obj2, (long) (zzy & 1048575)), zzB(i3));
                                break;
                            }
                        case 61:
                            if (!zzT(obj2, i4, i3)) {
                                break;
                            } else {
                                zzoc2.zzd(i4, (zzka) zznu.zzf(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 62:
                            if (!zzT(obj2, i4, i3)) {
                                break;
                            } else {
                                zzoc2.zzH(i4, zzp(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 63:
                            if (!zzT(obj2, i4, i3)) {
                                break;
                            } else {
                                zzoc2.zzi(i4, zzp(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 64:
                            if (!zzT(obj2, i4, i3)) {
                                break;
                            } else {
                                zzoc2.zzw(i4, zzp(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 65:
                            if (!zzT(obj2, i4, i3)) {
                                break;
                            } else {
                                zzoc2.zzy(i4, zzz(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 66:
                            if (!zzT(obj2, i4, i3)) {
                                break;
                            } else {
                                zzoc2.zzA(i4, zzp(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 67:
                            if (!zzT(obj2, i4, i3)) {
                                break;
                            } else {
                                zzoc2.zzC(i4, zzz(obj2, (long) (zzy & 1048575)));
                                break;
                            }
                        case 68:
                            if (!zzT(obj2, i4, i3)) {
                                break;
                            } else {
                                zzoc2.zzq(i4, zznu.zzf(obj2, (long) (zzy & 1048575)), zzB(i3));
                                break;
                            }
                    }
                }
                zznk zznk = this.zzn;
                zznk.zzi(zznk.zzd(obj2), zzoc2);
                return;
            }
            this.zzo.zza(obj2);
            throw null;
        } else if (!this.zzh) {
            int length2 = this.zzc.length;
            Unsafe unsafe = zzb;
            int i5 = 0;
            int i6 = 1048575;
            int i7 = 0;
            while (i5 < length2) {
                int zzy2 = zzy(i5);
                int[] iArr = this.zzc;
                int i8 = iArr[i5];
                int zzx = zzx(zzy2);
                if (zzx <= 17) {
                    int i9 = iArr[i5 + 2];
                    int i10 = i9 & i2;
                    if (i10 != i6) {
                        i7 = unsafe.getInt(obj2, (long) i10);
                        i6 = i10;
                    }
                    i = 1 << (i9 >>> 20);
                } else {
                    i = 0;
                }
                long j = (long) (zzy2 & i2);
                switch (zzx) {
                    case 0:
                        if ((i7 & i) == 0) {
                            break;
                        } else {
                            zzoc2.zzf(i8, zznu.zza(obj2, j));
                            continue;
                        }
                    case 1:
                        if ((i7 & i) != 0) {
                            zzoc2.zzo(i8, zznu.zzb(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 2:
                        if ((i7 & i) != 0) {
                            zzoc2.zzt(i8, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 3:
                        if ((i7 & i) != 0) {
                            zzoc2.zzJ(i8, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 4:
                        if ((i7 & i) != 0) {
                            zzoc2.zzr(i8, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 5:
                        if ((i7 & i) != 0) {
                            zzoc2.zzm(i8, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 6:
                        if ((i7 & i) != 0) {
                            zzoc2.zzk(i8, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 7:
                        if ((i7 & i) != 0) {
                            zzoc2.zzb(i8, zznu.zzw(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 8:
                        if ((i7 & i) != 0) {
                            zzV(i8, unsafe.getObject(obj2, j), zzoc2);
                            break;
                        } else {
                            continue;
                        }
                    case 9:
                        if ((i7 & i) != 0) {
                            zzoc2.zzv(i8, unsafe.getObject(obj2, j), zzB(i5));
                            break;
                        } else {
                            continue;
                        }
                    case 10:
                        if ((i7 & i) != 0) {
                            zzoc2.zzd(i8, (zzka) unsafe.getObject(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 11:
                        if ((i7 & i) != 0) {
                            zzoc2.zzH(i8, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 12:
                        if ((i7 & i) != 0) {
                            zzoc2.zzi(i8, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 13:
                        if ((i7 & i) != 0) {
                            zzoc2.zzw(i8, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 14:
                        if ((i7 & i) != 0) {
                            zzoc2.zzy(i8, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 15:
                        if ((i7 & i) != 0) {
                            zzoc2.zzA(i8, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 16:
                        if ((i7 & i) != 0) {
                            zzoc2.zzC(i8, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 17:
                        if ((i7 & i) != 0) {
                            zzoc2.zzq(i8, unsafe.getObject(obj2, j), zzB(i5));
                            break;
                        } else {
                            continue;
                        }
                    case 18:
                        zzmv.zzG(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, false);
                        continue;
                    case 19:
                        zzmv.zzK(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, false);
                        continue;
                    case 20:
                        zzmv.zzN(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, false);
                        continue;
                    case 21:
                        zzmv.zzV(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, false);
                        continue;
                    case 22:
                        zzmv.zzM(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, false);
                        continue;
                    case 23:
                        zzmv.zzJ(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, false);
                        continue;
                    case 24:
                        zzmv.zzI(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, false);
                        continue;
                    case 25:
                        zzmv.zzE(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, false);
                        continue;
                    case 26:
                        zzmv.zzT(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2);
                        break;
                    case 27:
                        zzmv.zzO(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, zzB(i5));
                        break;
                    case 28:
                        zzmv.zzF(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2);
                        break;
                    case 29:
                        zzmv.zzU(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, false);
                        break;
                    case 30:
                        zzmv.zzH(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, false);
                        break;
                    case 31:
                        zzmv.zzP(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, false);
                        break;
                    case 32:
                        zzmv.zzQ(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, false);
                        break;
                    case 33:
                        zzmv.zzR(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, false);
                        break;
                    case 34:
                        zzmv.zzS(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, false);
                        break;
                    case 35:
                        zzmv.zzG(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, true);
                        break;
                    case 36:
                        zzmv.zzK(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, true);
                        break;
                    case 37:
                        zzmv.zzN(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, true);
                        break;
                    case 38:
                        zzmv.zzV(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, true);
                        break;
                    case 39:
                        zzmv.zzM(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, true);
                        break;
                    case 40:
                        zzmv.zzJ(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, true);
                        break;
                    case 41:
                        zzmv.zzI(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, true);
                        break;
                    case 42:
                        zzmv.zzE(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, true);
                        break;
                    case 43:
                        zzmv.zzU(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, true);
                        break;
                    case 44:
                        zzmv.zzH(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, true);
                        break;
                    case 45:
                        zzmv.zzP(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, true);
                        break;
                    case 46:
                        zzmv.zzQ(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, true);
                        break;
                    case 47:
                        zzmv.zzR(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, true);
                        break;
                    case 48:
                        zzmv.zzS(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, true);
                        break;
                    case 49:
                        zzmv.zzL(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzoc2, zzB(i5));
                        break;
                    case 50:
                        zzN(zzoc2, i8, unsafe.getObject(obj2, j), i5);
                        break;
                    case 51:
                        if (zzT(obj2, i8, i5)) {
                            zzoc2.zzf(i8, zzm(obj2, j));
                            break;
                        }
                        break;
                    case 52:
                        if (zzT(obj2, i8, i5)) {
                            zzoc2.zzo(i8, zzn(obj2, j));
                            break;
                        }
                        break;
                    case 53:
                        if (zzT(obj2, i8, i5)) {
                            zzoc2.zzt(i8, zzz(obj2, j));
                            break;
                        }
                        break;
                    case 54:
                        if (zzT(obj2, i8, i5)) {
                            zzoc2.zzJ(i8, zzz(obj2, j));
                            break;
                        }
                        break;
                    case 55:
                        if (zzT(obj2, i8, i5)) {
                            zzoc2.zzr(i8, zzp(obj2, j));
                            break;
                        }
                        break;
                    case 56:
                        if (zzT(obj2, i8, i5)) {
                            zzoc2.zzm(i8, zzz(obj2, j));
                            break;
                        }
                        break;
                    case 57:
                        if (zzT(obj2, i8, i5)) {
                            zzoc2.zzk(i8, zzp(obj2, j));
                            break;
                        }
                        break;
                    case 58:
                        if (zzT(obj2, i8, i5)) {
                            zzoc2.zzb(i8, zzU(obj2, j));
                            break;
                        }
                        break;
                    case 59:
                        if (zzT(obj2, i8, i5)) {
                            zzV(i8, unsafe.getObject(obj2, j), zzoc2);
                            break;
                        }
                        break;
                    case 60:
                        if (zzT(obj2, i8, i5)) {
                            zzoc2.zzv(i8, unsafe.getObject(obj2, j), zzB(i5));
                            break;
                        }
                        break;
                    case 61:
                        if (zzT(obj2, i8, i5)) {
                            zzoc2.zzd(i8, (zzka) unsafe.getObject(obj2, j));
                            break;
                        }
                        break;
                    case 62:
                        if (zzT(obj2, i8, i5)) {
                            zzoc2.zzH(i8, zzp(obj2, j));
                            break;
                        }
                        break;
                    case 63:
                        if (zzT(obj2, i8, i5)) {
                            zzoc2.zzi(i8, zzp(obj2, j));
                            break;
                        }
                        break;
                    case 64:
                        if (zzT(obj2, i8, i5)) {
                            zzoc2.zzw(i8, zzp(obj2, j));
                            break;
                        }
                        break;
                    case 65:
                        if (zzT(obj2, i8, i5)) {
                            zzoc2.zzy(i8, zzz(obj2, j));
                            break;
                        }
                        break;
                    case 66:
                        if (zzT(obj2, i8, i5)) {
                            zzoc2.zzA(i8, zzp(obj2, j));
                            break;
                        }
                        break;
                    case 67:
                        if (zzT(obj2, i8, i5)) {
                            zzoc2.zzC(i8, zzz(obj2, j));
                            break;
                        }
                        break;
                    case 68:
                        if (zzT(obj2, i8, i5)) {
                            zzoc2.zzq(i8, unsafe.getObject(obj2, j), zzB(i5));
                            break;
                        }
                        break;
                }
                i5 += 3;
                i2 = 1048575;
            }
            zznk zznk2 = this.zzn;
            zznk2.zzi(zznk2.zzd(obj2), zzoc2);
        } else {
            this.zzo.zza(obj2);
            throw null;
        }
    }
}
