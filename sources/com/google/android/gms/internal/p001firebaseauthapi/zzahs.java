package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahs  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzahs<T> implements zzaib<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzajf.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzahp zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzahd zzn;
    private final zzaiv zzo;
    private final zzafy zzp;
    private final zzahu zzq;
    private final zzahk zzr;

    private zzahs(int[] iArr, Object[] objArr, int i, int i2, zzahp zzahp, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzahu zzahu, zzahd zzahd, zzaiv zzaiv, zzafy zzafy, zzahk zzahk) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzahp instanceof zzagk;
        this.zzj = z;
        boolean z3 = false;
        if (zzafy != null && zzafy.zzh(zzahp)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzk = iArr2;
        this.zzl = i3;
        this.zzm = i4;
        this.zzq = zzahu;
        this.zzn = zzahd;
        this.zzo = zzaiv;
        this.zzp = zzafy;
        this.zzg = zzahp;
        this.zzr = zzahk;
    }

    private static long zzA(Object obj, long j) {
        return ((Long) zzajf.zzf(obj, j)).longValue();
    }

    private final zzago zzB(int i) {
        int i2 = i / 3;
        return (zzago) this.zzd[i2 + i2 + 1];
    }

    private final zzaib zzC(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzaib zzaib = (zzaib) this.zzd[i3];
        if (zzaib != null) {
            return zzaib;
        }
        zzaib zzb2 = zzahx.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzD(Object obj, int i, Object obj2, zzaiv zzaiv, Object obj3) {
        int i2 = this.zzc[i];
        Object zzf2 = zzajf.zzf(obj, (long) (zzz(i) & 1048575));
        if (zzf2 == null || zzB(i) == null) {
            return obj2;
        }
        zzahj zzahj = (zzahj) zzf2;
        zzahi zzahi = (zzahi) zzE(i);
        throw null;
    }

    private final Object zzE(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzF(Object obj, int i) {
        zzaib zzC = zzC(i);
        int zzz = zzz(i) & 1048575;
        if (!zzS(obj, i)) {
            return zzC.zze();
        }
        Object object = zzb.getObject(obj, (long) zzz);
        if (zzV(object)) {
            return object;
        }
        Object zze2 = zzC.zze();
        if (object != null) {
            zzC.zzg(zze2, object);
        }
        return zze2;
    }

    private final Object zzG(Object obj, int i, int i2) {
        zzaib zzC = zzC(i2);
        if (!zzW(obj, i, i2)) {
            return zzC.zze();
        }
        Object object = zzb.getObject(obj, (long) (zzz(i2) & 1048575));
        if (zzV(object)) {
            return object;
        }
        Object zze2 = zzC.zze();
        if (object != null) {
            zzC.zzg(zze2, object);
        }
        return zze2;
    }

    private static Field zzH(Class cls, String str) {
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

    private static void zzI(Object obj) {
        if (!zzV(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzJ(Object obj, Object obj2, int i) {
        if (zzS(obj2, i)) {
            Unsafe unsafe = zzb;
            long zzz = (long) (zzz(i) & 1048575);
            Object object = unsafe.getObject(obj2, zzz);
            if (object != null) {
                zzaib zzC = zzC(i);
                if (!zzS(obj, i)) {
                    if (!zzV(object)) {
                        unsafe.putObject(obj, zzz, object);
                    } else {
                        Object zze2 = zzC.zze();
                        zzC.zzg(zze2, object);
                        unsafe.putObject(obj, zzz, zze2);
                    }
                    zzM(obj, i);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzz);
                if (!zzV(object2)) {
                    Object zze3 = zzC.zze();
                    zzC.zzg(zze3, object2);
                    unsafe.putObject(obj, zzz, zze3);
                    object2 = zze3;
                }
                zzC.zzg(object2, object);
                return;
            }
            int i2 = this.zzc[i];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i2 + " is present but null: " + obj3);
        }
    }

    private final void zzK(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzW(obj2, i2, i)) {
            Unsafe unsafe = zzb;
            long zzz = (long) (zzz(i) & 1048575);
            Object object = unsafe.getObject(obj2, zzz);
            if (object != null) {
                zzaib zzC = zzC(i);
                if (!zzW(obj, i2, i)) {
                    if (!zzV(object)) {
                        unsafe.putObject(obj, zzz, object);
                    } else {
                        Object zze2 = zzC.zze();
                        zzC.zzg(zze2, object);
                        unsafe.putObject(obj, zzz, zze2);
                    }
                    zzN(obj, i2, i);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzz);
                if (!zzV(object2)) {
                    Object zze3 = zzC.zze();
                    zzC.zzg(zze3, object2);
                    unsafe.putObject(obj, zzz, zze3);
                    object2 = zze3;
                }
                zzC.zzg(object2, object);
                return;
            }
            int i3 = this.zzc[i];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i3 + " is present but null: " + obj3);
        }
    }

    private final void zzL(Object obj, int i, zzaia zzaia) throws IOException {
        if (zzR(i)) {
            zzajf.zzs(obj, (long) (i & 1048575), zzaia.zzs());
        } else if (this.zzi) {
            zzajf.zzs(obj, (long) (i & 1048575), zzaia.zzr());
        } else {
            zzajf.zzs(obj, (long) (i & 1048575), zzaia.zzp());
        }
    }

    private final void zzM(Object obj, int i) {
        int zzw = zzw(i);
        long j = (long) (1048575 & zzw);
        if (j != 1048575) {
            zzajf.zzq(obj, j, (1 << (zzw >>> 20)) | zzajf.zzc(obj, j));
        }
    }

    private final void zzN(Object obj, int i, int i2) {
        zzajf.zzq(obj, (long) (zzw(i2) & 1048575), i);
    }

    private final void zzO(Object obj, int i, Object obj2) {
        zzb.putObject(obj, (long) (zzz(i) & 1048575), obj2);
        zzM(obj, i);
    }

    private final void zzP(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, (long) (zzz(i2) & 1048575), obj2);
        zzN(obj, i, i2);
    }

    private final boolean zzQ(Object obj, Object obj2, int i) {
        return zzS(obj, i) == zzS(obj2, i);
    }

    private static boolean zzR(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean zzS(Object obj, int i) {
        int zzw = zzw(i);
        long j = (long) (zzw & 1048575);
        if (j == 1048575) {
            int zzz = zzz(i);
            long j2 = (long) (zzz & 1048575);
            switch (zzy(zzz)) {
                case 0:
                    return Double.doubleToRawLongBits(zzajf.zza(obj, j2)) != 0;
                case 1:
                    return Float.floatToRawIntBits(zzajf.zzb(obj, j2)) != 0;
                case 2:
                    return zzajf.zzd(obj, j2) != 0;
                case 3:
                    return zzajf.zzd(obj, j2) != 0;
                case 4:
                    return zzajf.zzc(obj, j2) != 0;
                case 5:
                    return zzajf.zzd(obj, j2) != 0;
                case 6:
                    return zzajf.zzc(obj, j2) != 0;
                case 7:
                    return zzajf.zzw(obj, j2);
                case 8:
                    Object zzf2 = zzajf.zzf(obj, j2);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzaff) {
                        return !zzaff.zzb.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzajf.zzf(obj, j2) != null;
                case 10:
                    return !zzaff.zzb.equals(zzajf.zzf(obj, j2));
                case 11:
                    return zzajf.zzc(obj, j2) != 0;
                case 12:
                    return zzajf.zzc(obj, j2) != 0;
                case 13:
                    return zzajf.zzc(obj, j2) != 0;
                case 14:
                    return zzajf.zzd(obj, j2) != 0;
                case 15:
                    return zzajf.zzc(obj, j2) != 0;
                case 16:
                    return zzajf.zzd(obj, j2) != 0;
                case 17:
                    return zzajf.zzf(obj, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzajf.zzc(obj, j) & (1 << (zzw >>> 20))) != 0;
        }
    }

    private final boolean zzT(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzS(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzU(Object obj, int i, zzaib zzaib) {
        return zzaib.zzk(zzajf.zzf(obj, (long) (i & 1048575)));
    }

    private static boolean zzV(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzagk) {
            return ((zzagk) obj).zzL();
        }
        return true;
    }

    private final boolean zzW(Object obj, int i, int i2) {
        return zzajf.zzc(obj, (long) (zzw(i2) & 1048575)) == i;
    }

    private static boolean zzX(Object obj, long j) {
        return ((Boolean) zzajf.zzf(obj, j)).booleanValue();
    }

    private final void zzY(zzaft zzaft, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzahi zzahi = (zzahi) zzE(i2);
            throw null;
        }
    }

    private static final void zzZ(int i, Object obj, zzaft zzaft) throws IOException {
        if (obj instanceof String) {
            zzaft.zzF(i, (String) obj);
        } else {
            zzaft.zzd(i, (zzaff) obj);
        }
    }

    static zzaiw zzd(Object obj) {
        zzagk zzagk = (zzagk) obj;
        zzaiw zzaiw = zzagk.zzc;
        if (zzaiw != zzaiw.zzc()) {
            return zzaiw;
        }
        zzaiw zzf2 = zzaiw.zzf();
        zzagk.zzc = zzf2;
        return zzf2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x032a  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x036e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.p001firebaseauthapi.zzahs zzl(java.lang.Class r31, com.google.android.gms.internal.p001firebaseauthapi.zzahm r32, com.google.android.gms.internal.p001firebaseauthapi.zzahu r33, com.google.android.gms.internal.p001firebaseauthapi.zzahd r34, com.google.android.gms.internal.p001firebaseauthapi.zzaiv r35, com.google.android.gms.internal.p001firebaseauthapi.zzafy r36, com.google.android.gms.internal.p001firebaseauthapi.zzahk r37) {
        /*
            r0 = r32
            boolean r1 = r0 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzahz
            if (r1 == 0) goto L_0x03d8
            com.google.android.gms.internal.firebase-auth-api.zzahz r0 = (com.google.android.gms.internal.p001firebaseauthapi.zzahz) r0
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
            com.google.android.gms.internal.firebase-auth-api.zzahp r16 = r0.zza()
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
            java.lang.reflect.Field r7 = zzH(r9, r7)
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
            java.lang.reflect.Field r7 = zzH(r9, r7)
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
            java.lang.reflect.Field r10 = zzH(r9, r10)
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
            java.lang.reflect.Field r14 = zzH(r9, r14)
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
            com.google.android.gms.internal.firebase-auth-api.zzahs r1 = new com.google.android.gms.internal.firebase-auth-api.zzahs
            com.google.android.gms.internal.firebase-auth-api.zzahp r15 = r0.zza()
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
            com.google.android.gms.internal.firebase-auth-api.zzaip r0 = (com.google.android.gms.internal.p001firebaseauthapi.zzaip) r0
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzahs.zzl(java.lang.Class, com.google.android.gms.internal.firebase-auth-api.zzahm, com.google.android.gms.internal.firebase-auth-api.zzahu, com.google.android.gms.internal.firebase-auth-api.zzahd, com.google.android.gms.internal.firebase-auth-api.zzaiv, com.google.android.gms.internal.firebase-auth-api.zzafy, com.google.android.gms.internal.firebase-auth-api.zzahk):com.google.android.gms.internal.firebase-auth-api.zzahs");
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzajf.zzf(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzajf.zzf(obj, j)).floatValue();
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
    private final int zzp(java.lang.Object r17) {
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
            int r9 = r0.zzz(r5)
            int[] r10 = r0.zzc
            r11 = r10[r5]
            int r12 = zzy(r9)
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
            boolean r9 = r0.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.firebase-auth-api.zzahp r3 = (com.google.android.gms.internal.p001firebaseauthapi.zzahp) r3
            com.google.android.gms.internal.firebase-auth-api.zzaib r4 = r0.zzC(r5)
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzw(r11, r3, r4)
            goto L_0x03a0
        L_0x0058:
            boolean r10 = r0.zzW(r1, r11, r5)
            if (r10 == 0) goto L_0x03a1
            long r3 = zzA(r1, r3)
            int r10 = r11 << 3
            long r11 = r3 + r3
            long r3 = r3 >> r9
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r10)
            long r3 = r3 ^ r11
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzB(r3)
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x03a1
        L_0x0074:
            boolean r9 = r0.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            int r3 = zzq(r1, r3)
            int r4 = r11 << 3
            int r9 = r3 + r3
            int r3 = r3 >> 31
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            goto L_0x0330
        L_0x008f:
            boolean r3 = r0.zzW(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            goto L_0x01c2
        L_0x009d:
            boolean r3 = r0.zzW(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            goto L_0x01b2
        L_0x00ab:
            boolean r9 = r0.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            int r3 = zzq(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzx(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x0330
        L_0x00c1:
            boolean r9 = r0.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            int r3 = zzq(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x0330
        L_0x00d7:
            boolean r9 = r0.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.firebase-auth-api.zzaff r3 = (com.google.android.gms.internal.p001firebaseauthapi.zzaff) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzf
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
        L_0x00f4:
            int r3 = r3 + r9
            goto L_0x03a0
        L_0x00f7:
            boolean r9 = r0.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.firebase-auth-api.zzaib r4 = r0.zzC(r5)
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzn(r11, r3, r4)
            goto L_0x03a0
        L_0x010b:
            boolean r9 = r0.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzaff
            if (r4 == 0) goto L_0x012d
            com.google.android.gms.internal.firebase-auth-api.zzaff r3 = (com.google.android.gms.internal.p001firebaseauthapi.zzaff) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzf
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x00f4
        L_0x012d:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzz(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x0330
        L_0x013b:
            boolean r3 = r0.zzW(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r3 = r3 + r14
            goto L_0x03a0
        L_0x014a:
            boolean r3 = r0.zzW(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            goto L_0x01b2
        L_0x0157:
            boolean r3 = r0.zzW(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            goto L_0x01c2
        L_0x0164:
            boolean r9 = r0.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            int r3 = zzq(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzx(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x0330
        L_0x017a:
            boolean r9 = r0.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            long r3 = zzA(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzB(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r9)
            goto L_0x0330
        L_0x0190:
            boolean r9 = r0.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            long r3 = zzA(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzB(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r9)
            goto L_0x0330
        L_0x01a6:
            boolean r3 = r0.zzW(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
        L_0x01b2:
            int r3 = r3 + 4
            goto L_0x03a0
        L_0x01b6:
            boolean r3 = r0.zzW(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
        L_0x01c2:
            int r3 = r3 + 8
            goto L_0x03a0
        L_0x01c6:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.lang.Object r4 = r0.zzE(r5)
            com.google.android.gms.internal.p001firebaseauthapi.zzahk.zza(r11, r3, r4)
            goto L_0x03a1
        L_0x01d3:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.firebase-auth-api.zzaib r4 = r0.zzC(r5)
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzi(r11, r3, r4)
            goto L_0x03a0
        L_0x01e3:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzs(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x032f
        L_0x01fb:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzq(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x032f
        L_0x0213:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzh(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x032f
        L_0x022b:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzf(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x032f
        L_0x0243:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzd(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x032f
        L_0x025b:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzv(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x032f
        L_0x0273:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zza
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x032f
        L_0x028d:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzf(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x032f
        L_0x02a5:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzh(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x032f
        L_0x02bd:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzk(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x032f
        L_0x02d4:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzx(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x032f
        L_0x02eb:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzm(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x032f
        L_0x0302:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzf(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x032f
        L_0x0319:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzh(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
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
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzr(r11, r3, r9)
            goto L_0x03a0
        L_0x0340:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzp(r11, r3, r9)
            goto L_0x03a0
        L_0x034c:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzg(r11, r3, r9)
            goto L_0x03a0
        L_0x0358:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zze(r11, r3, r9)
            goto L_0x03a0
        L_0x0364:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzc(r11, r3, r9)
            goto L_0x03a0
        L_0x0370:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzu(r11, r3, r9)
            goto L_0x03a0
        L_0x037c:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzb(r11, r3)
            goto L_0x03a0
        L_0x0387:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.firebase-auth-api.zzaib r4 = r0.zzC(r5)
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzo(r11, r3, r4)
            goto L_0x03a0
        L_0x0396:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzt(r11, r3)
        L_0x03a0:
            int r6 = r6 + r3
        L_0x03a1:
            r12 = 0
            goto L_0x0574
        L_0x03a4:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r12 = 0
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zza(r11, r3, r12)
            goto L_0x0403
        L_0x03b0:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zze(r11, r3, r12)
            goto L_0x0403
        L_0x03bc:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzg(r11, r3, r12)
            goto L_0x0403
        L_0x03c8:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzj(r11, r3, r12)
            goto L_0x0403
        L_0x03d4:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzw(r11, r3, r12)
            goto L_0x0403
        L_0x03e0:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzl(r11, r3, r12)
            goto L_0x0403
        L_0x03ec:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zze(r11, r3, r12)
            goto L_0x0403
        L_0x03f8:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzg(r11, r3, r12)
        L_0x0403:
            int r6 = r6 + r3
            goto L_0x0574
        L_0x0406:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.firebase-auth-api.zzahp r3 = (com.google.android.gms.internal.p001firebaseauthapi.zzahp) r3
            com.google.android.gms.internal.firebase-auth-api.zzaib r4 = r0.zzC(r5)
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzw(r11, r3, r4)
            goto L_0x0403
        L_0x041a:
            r12 = 0
            r10 = r10 & r8
            if (r10 == 0) goto L_0x0574
            long r3 = r2.getLong(r1, r3)
            int r10 = r11 << 3
            long r14 = r3 + r3
            long r3 = r3 >> r9
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r10)
            long r3 = r3 ^ r14
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzB(r3)
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
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            goto L_0x0553
        L_0x044e:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            goto L_0x0570
        L_0x045b:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            goto L_0x0561
        L_0x0468:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzx(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x0553
        L_0x047d:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x0553
        L_0x0492:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.firebase-auth-api.zzaff r3 = (com.google.android.gms.internal.p001firebaseauthapi.zzaff) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzf
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
        L_0x04ae:
            int r3 = r3 + r9
            goto L_0x0403
        L_0x04b1:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.firebase-auth-api.zzaib r4 = r0.zzC(r5)
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzn(r11, r3, r4)
            goto L_0x0403
        L_0x04c4:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzaff
            if (r4 == 0) goto L_0x04e5
            com.google.android.gms.internal.firebase-auth-api.zzaff r3 = (com.google.android.gms.internal.p001firebaseauthapi.zzaff) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzf
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x04ae
        L_0x04e5:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzz(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x0553
        L_0x04f2:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            int r3 = r3 + r14
            goto L_0x0403
        L_0x0500:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            goto L_0x0561
        L_0x050c:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
            goto L_0x0570
        L_0x0518:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzx(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x0553
        L_0x052c:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzB(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r9)
            goto L_0x0553
        L_0x0540:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzB(r3)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r9)
        L_0x0553:
            int r4 = r4 + r3
            int r6 = r6 + r4
            goto L_0x0574
        L_0x0556:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
        L_0x0561:
            int r3 = r3 + 4
            goto L_0x0403
        L_0x0565:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r3)
        L_0x0570:
            int r3 = r3 + 8
            goto L_0x0403
        L_0x0574:
            int r5 = r5 + 3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000f
        L_0x057b:
            com.google.android.gms.internal.firebase-auth-api.zzaiv r2 = r0.zzo
            java.lang.Object r3 = r2.zzd(r1)
            int r2 = r2.zza(r3)
            int r6 = r6 + r2
            boolean r2 = r0.zzh
            if (r2 != 0) goto L_0x058b
            return r6
        L_0x058b:
            com.google.android.gms.internal.firebase-auth-api.zzafy r2 = r0.zzp
            r2.zza(r1)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzahs.zzp(java.lang.Object):int");
    }

    private static int zzq(Object obj, long j) {
        return ((Integer) zzajf.zzf(obj, j)).intValue();
    }

    private final int zzr(Object obj, byte[] bArr, int i, int i2, int i3, long j, zzaes zzaes) throws IOException {
        Unsafe unsafe = zzb;
        Object zzE = zzE(i3);
        Object object = unsafe.getObject(obj, j);
        if (zzahk.zzb(object)) {
            zzahj zzb2 = zzahj.zza().zzb();
            zzahk.zzc(zzb2, object);
            unsafe.putObject(obj, j, zzb2);
        }
        zzahi zzahi = (zzahi) zzE;
        throw null;
    }

    private final int zzs(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzaes zzaes) throws IOException {
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i9 = i;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        long j2 = j;
        int i13 = i8;
        zzaes zzaes2 = zzaes;
        Unsafe unsafe = zzb;
        long j3 = (long) (this.zzc[i13 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i12 == 1) {
                    unsafe.putObject(obj2, j2, Double.valueOf(Double.longBitsToDouble(zzaet.zzp(bArr, i))));
                    int i14 = i9 + 8;
                    unsafe.putInt(obj2, j3, i11);
                    return i14;
                }
                break;
            case 52:
                if (i12 == 5) {
                    unsafe.putObject(obj2, j2, Float.valueOf(Float.intBitsToFloat(zzaet.zzb(bArr, i))));
                    int i15 = i9 + 4;
                    unsafe.putInt(obj2, j3, i11);
                    return i15;
                }
                break;
            case 53:
            case 54:
                if (i12 == 0) {
                    int zzm2 = zzaet.zzm(bArr2, i9, zzaes2);
                    unsafe.putObject(obj2, j2, Long.valueOf(zzaes2.zzb));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm2;
                }
                break;
            case 55:
            case 62:
                if (i12 == 0) {
                    int zzj2 = zzaet.zzj(bArr2, i9, zzaes2);
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzaes2.zza));
                    unsafe.putInt(obj2, j3, i11);
                    return zzj2;
                }
                break;
            case 56:
            case 65:
                if (i12 == 1) {
                    unsafe.putObject(obj2, j2, Long.valueOf(zzaet.zzp(bArr, i)));
                    int i16 = i9 + 8;
                    unsafe.putInt(obj2, j3, i11);
                    return i16;
                }
                break;
            case 57:
            case 64:
                if (i12 == 5) {
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzaet.zzb(bArr, i)));
                    int i17 = i9 + 4;
                    unsafe.putInt(obj2, j3, i11);
                    return i17;
                }
                break;
            case 58:
                if (i12 == 0) {
                    int zzm3 = zzaet.zzm(bArr2, i9, zzaes2);
                    unsafe.putObject(obj2, j2, Boolean.valueOf(zzaes2.zzb != 0));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm3;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int zzj3 = zzaet.zzj(bArr2, i9, zzaes2);
                    int i18 = zzaes2.zza;
                    if (i18 == 0) {
                        unsafe.putObject(obj2, j2, "");
                    } else if ((i6 & 536870912) == 0 || zzajk.zzf(bArr2, zzj3, zzj3 + i18)) {
                        unsafe.putObject(obj2, j2, new String(bArr2, zzj3, i18, zzagq.zzb));
                        zzj3 += i18;
                    } else {
                        throw zzags.zzd();
                    }
                    unsafe.putInt(obj2, j3, i11);
                    return zzj3;
                }
                break;
            case 60:
                if (i12 == 2) {
                    Object zzG = zzG(obj2, i11, i13);
                    int zzo2 = zzaet.zzo(zzG, zzC(i13), bArr, i, i2, zzaes);
                    zzP(obj2, i11, i13, zzG);
                    return zzo2;
                }
                break;
            case 61:
                if (i12 == 2) {
                    int zza2 = zzaet.zza(bArr2, i9, zzaes2);
                    unsafe.putObject(obj2, j2, zzaes2.zzc);
                    unsafe.putInt(obj2, j3, i11);
                    return zza2;
                }
                break;
            case 63:
                if (i12 == 0) {
                    int zzj4 = zzaet.zzj(bArr2, i9, zzaes2);
                    int i19 = zzaes2.zza;
                    zzago zzB = zzB(i13);
                    if (zzB == null || zzB.zza()) {
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
                    int zzj5 = zzaet.zzj(bArr2, i9, zzaes2);
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzafl.zzF(zzaes2.zza)));
                    unsafe.putInt(obj2, j3, i11);
                    return zzj5;
                }
                break;
            case 67:
                if (i12 == 0) {
                    int zzm4 = zzaet.zzm(bArr2, i9, zzaes2);
                    unsafe.putObject(obj2, j2, Long.valueOf(zzafl.zzG(zzaes2.zzb)));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm4;
                }
                break;
            case 68:
                if (i12 == 3) {
                    Object zzG2 = zzG(obj2, i11, i13);
                    int zzn2 = zzaet.zzn(zzG2, zzC(i13), bArr, i, i2, (i10 & -8) | 4, zzaes);
                    zzP(obj2, i11, i13, zzG2);
                    return zzn2;
                }
                break;
        }
        return i9;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:282:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:?, code lost:
        return r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x017a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0443 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0443 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzt(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.p001firebaseauthapi.zzaes r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r12 = r11.getObject(r1, r9)
            com.google.android.gms.internal.firebase-auth-api.zzagp r12 = (com.google.android.gms.internal.p001firebaseauthapi.zzagp) r12
            boolean r13 = r12.zzc()
            if (r13 != 0) goto L_0x0032
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002a
            r13 = 10
            goto L_0x002b
        L_0x002a:
            int r13 = r13 + r13
        L_0x002b:
            com.google.android.gms.internal.firebase-auth-api.zzagp r12 = r12.zzd(r13)
            r11.putObject(r1, r9, r12)
        L_0x0032:
            r9 = 5
            r10 = 0
            r13 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x03d5;
                case 19: goto L_0x0388;
                case 20: goto L_0x0345;
                case 21: goto L_0x0345;
                case 22: goto L_0x032c;
                case 23: goto L_0x02eb;
                case 24: goto L_0x02aa;
                case 25: goto L_0x0251;
                case 26: goto L_0x019e;
                case 27: goto L_0x0185;
                case 28: goto L_0x012b;
                case 29: goto L_0x032c;
                case 30: goto L_0x00fa;
                case 31: goto L_0x02aa;
                case 32: goto L_0x02eb;
                case 33: goto L_0x00ab;
                case 34: goto L_0x005c;
                case 35: goto L_0x03d5;
                case 36: goto L_0x0388;
                case 37: goto L_0x0345;
                case 38: goto L_0x0345;
                case 39: goto L_0x032c;
                case 40: goto L_0x02eb;
                case 41: goto L_0x02aa;
                case 42: goto L_0x0251;
                case 43: goto L_0x032c;
                case 44: goto L_0x00fa;
                case 45: goto L_0x02aa;
                case 46: goto L_0x02eb;
                case 47: goto L_0x00ab;
                case 48: goto L_0x005c;
                default: goto L_0x003a;
            }
        L_0x003a:
            r1 = 3
            if (r6 != r1) goto L_0x0443
            com.google.android.gms.internal.firebase-auth-api.zzaib r1 = r15.zzC(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x0421
        L_0x005c:
            if (r6 != r14) goto L_0x0080
            com.google.android.gms.internal.firebase-auth-api.zzahe r12 = (com.google.android.gms.internal.p001firebaseauthapi.zzahe) r12
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0067:
            if (r1 >= r2) goto L_0x0077
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzm(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafl.zzG(r4)
            r12.zzf(r4)
            goto L_0x0067
        L_0x0077:
            if (r1 != r2) goto L_0x007b
            goto L_0x0444
        L_0x007b:
            com.google.android.gms.internal.firebase-auth-api.zzags r1 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzj()
            throw r1
        L_0x0080:
            if (r6 != 0) goto L_0x0443
            com.google.android.gms.internal.firebase-auth-api.zzahe r12 = (com.google.android.gms.internal.p001firebaseauthapi.zzahe) r12
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.p001firebaseauthapi.zzafl.zzG(r8)
            r12.zzf(r8)
        L_0x0091:
            if (r1 >= r5) goto L_0x00aa
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009c
            goto L_0x00aa
        L_0x009c:
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.p001firebaseauthapi.zzafl.zzG(r8)
            r12.zzf(r8)
            goto L_0x0091
        L_0x00aa:
            return r1
        L_0x00ab:
            if (r6 != r14) goto L_0x00cf
            com.google.android.gms.internal.firebase-auth-api.zzagl r12 = (com.google.android.gms.internal.p001firebaseauthapi.zzagl) r12
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b6:
            if (r1 >= r2) goto L_0x00c6
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafl.zzF(r4)
            r12.zzf(r4)
            goto L_0x00b6
        L_0x00c6:
            if (r1 != r2) goto L_0x00ca
            goto L_0x0444
        L_0x00ca:
            com.google.android.gms.internal.firebase-auth-api.zzags r1 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzj()
            throw r1
        L_0x00cf:
            if (r6 != 0) goto L_0x0443
            com.google.android.gms.internal.firebase-auth-api.zzagl r12 = (com.google.android.gms.internal.p001firebaseauthapi.zzagl) r12
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafl.zzF(r4)
            r12.zzf(r4)
        L_0x00e0:
            if (r1 >= r5) goto L_0x00f9
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00eb
            goto L_0x00f9
        L_0x00eb:
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafl.zzF(r4)
            r12.zzf(r4)
            goto L_0x00e0
        L_0x00f9:
            return r1
        L_0x00fa:
            if (r6 != r14) goto L_0x0101
            int r2 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzf(r3, r4, r12, r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x0443
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzl(r2, r3, r4, r5, r6, r7)
        L_0x0112:
            com.google.android.gms.internal.firebase-auth-api.zzago r3 = r15.zzB(r8)
            r4 = 0
            com.google.android.gms.internal.firebase-auth-api.zzaiv r5 = r0.zzo
            r22 = r16
            r23 = r21
            r24 = r12
            r25 = r3
            r26 = r4
            r27 = r5
            com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzA(r22, r23, r24, r25, r26, r27)
        L_0x0128:
            r1 = r2
            goto L_0x0444
        L_0x012b:
            if (r6 != r14) goto L_0x0443
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0180
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x017b
            if (r4 != 0) goto L_0x0141
            com.google.android.gms.internal.firebase-auth-api.zzaff r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaff.zzb
            r12.add(r4)
            goto L_0x0149
        L_0x0141:
            com.google.android.gms.internal.firebase-auth-api.zzaff r6 = com.google.android.gms.internal.p001firebaseauthapi.zzaff.zzn(r3, r1, r4)
            r12.add(r6)
        L_0x0148:
            int r1 = r1 + r4
        L_0x0149:
            if (r1 >= r5) goto L_0x017a
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0154
            goto L_0x017a
        L_0x0154:
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0175
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0170
            if (r4 != 0) goto L_0x0168
            com.google.android.gms.internal.firebase-auth-api.zzaff r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaff.zzb
            r12.add(r4)
            goto L_0x0149
        L_0x0168:
            com.google.android.gms.internal.firebase-auth-api.zzaff r6 = com.google.android.gms.internal.p001firebaseauthapi.zzaff.zzn(r3, r1, r4)
            r12.add(r6)
            goto L_0x0148
        L_0x0170:
            com.google.android.gms.internal.firebase-auth-api.zzags r1 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzj()
            throw r1
        L_0x0175:
            com.google.android.gms.internal.firebase-auth-api.zzags r1 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzf()
            throw r1
        L_0x017a:
            return r1
        L_0x017b:
            com.google.android.gms.internal.firebase-auth-api.zzags r1 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzj()
            throw r1
        L_0x0180:
            com.google.android.gms.internal.firebase-auth-api.zzags r1 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzf()
            throw r1
        L_0x0185:
            if (r6 != r14) goto L_0x0443
            com.google.android.gms.internal.firebase-auth-api.zzaib r1 = r15.zzC(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zze(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x019e:
            if (r6 != r14) goto L_0x0443
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 != 0) goto L_0x01f1
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01ec
            if (r6 != 0) goto L_0x01b9
            r12.add(r1)
            goto L_0x01c4
        L_0x01b9:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.p001firebaseauthapi.zzagq.zzb
            r8.<init>(r3, r4, r6, r9)
            r12.add(r8)
        L_0x01c3:
            int r4 = r4 + r6
        L_0x01c4:
            if (r4 >= r5) goto L_0x0443
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0443
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01e7
            if (r6 != 0) goto L_0x01dc
            r12.add(r1)
            goto L_0x01c4
        L_0x01dc:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.p001firebaseauthapi.zzagq.zzb
            r8.<init>(r3, r4, r6, r9)
            r12.add(r8)
            goto L_0x01c3
        L_0x01e7:
            com.google.android.gms.internal.firebase-auth-api.zzags r1 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzf()
            throw r1
        L_0x01ec:
            com.google.android.gms.internal.firebase-auth-api.zzags r1 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzf()
            throw r1
        L_0x01f1:
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x024c
            if (r6 != 0) goto L_0x01ff
            r12.add(r1)
            goto L_0x0212
        L_0x01ff:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.p001firebaseauthapi.zzajk.zzf(r3, r4, r8)
            if (r9 == 0) goto L_0x0247
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.p001firebaseauthapi.zzagq.zzb
            r9.<init>(r3, r4, r6, r10)
            r12.add(r9)
        L_0x0211:
            r4 = r8
        L_0x0212:
            if (r4 >= r5) goto L_0x0443
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0443
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0242
            if (r6 != 0) goto L_0x022a
            r12.add(r1)
            goto L_0x0212
        L_0x022a:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.p001firebaseauthapi.zzajk.zzf(r3, r4, r8)
            if (r9 == 0) goto L_0x023d
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.p001firebaseauthapi.zzagq.zzb
            r9.<init>(r3, r4, r6, r10)
            r12.add(r9)
            goto L_0x0211
        L_0x023d:
            com.google.android.gms.internal.firebase-auth-api.zzags r1 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzd()
            throw r1
        L_0x0242:
            com.google.android.gms.internal.firebase-auth-api.zzags r1 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzf()
            throw r1
        L_0x0247:
            com.google.android.gms.internal.firebase-auth-api.zzags r1 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzd()
            throw r1
        L_0x024c:
            com.google.android.gms.internal.firebase-auth-api.zzags r1 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzf()
            throw r1
        L_0x0251:
            r1 = 0
            if (r6 != r14) goto L_0x0279
            com.google.android.gms.internal.firebase-auth-api.zzaeu r12 = (com.google.android.gms.internal.p001firebaseauthapi.zzaeu) r12
            int r2 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x025d:
            if (r2 >= r4) goto L_0x0270
            int r2 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzm(r3, r2, r7)
            long r5 = r7.zzb
            int r8 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x026b
            r5 = 1
            goto L_0x026c
        L_0x026b:
            r5 = 0
        L_0x026c:
            r12.zze(r5)
            goto L_0x025d
        L_0x0270:
            if (r2 != r4) goto L_0x0274
            goto L_0x0128
        L_0x0274:
            com.google.android.gms.internal.firebase-auth-api.zzags r1 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzj()
            throw r1
        L_0x0279:
            if (r6 != 0) goto L_0x0443
            com.google.android.gms.internal.firebase-auth-api.zzaeu r12 = (com.google.android.gms.internal.p001firebaseauthapi.zzaeu) r12
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0289
            r6 = 1
            goto L_0x028a
        L_0x0289:
            r6 = 0
        L_0x028a:
            r12.zze(r6)
        L_0x028d:
            if (r4 >= r5) goto L_0x02a9
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x0298
            goto L_0x02a9
        L_0x0298:
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzm(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x02a4
            r6 = 1
            goto L_0x02a5
        L_0x02a4:
            r6 = 0
        L_0x02a5:
            r12.zze(r6)
            goto L_0x028d
        L_0x02a9:
            return r4
        L_0x02aa:
            if (r6 != r14) goto L_0x02ca
            com.google.android.gms.internal.firebase-auth-api.zzagl r12 = (com.google.android.gms.internal.p001firebaseauthapi.zzagl) r12
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02b5:
            if (r1 >= r2) goto L_0x02c1
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzb(r3, r1)
            r12.zzf(r4)
            int r1 = r1 + 4
            goto L_0x02b5
        L_0x02c1:
            if (r1 != r2) goto L_0x02c5
            goto L_0x0444
        L_0x02c5:
            com.google.android.gms.internal.firebase-auth-api.zzags r1 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzj()
            throw r1
        L_0x02ca:
            if (r6 != r9) goto L_0x0443
            com.google.android.gms.internal.firebase-auth-api.zzagl r12 = (com.google.android.gms.internal.p001firebaseauthapi.zzagl) r12
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzb(r17, r18)
            r12.zzf(r1)
        L_0x02d5:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02ea
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02e2
            goto L_0x02ea
        L_0x02e2:
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzb(r3, r4)
            r12.zzf(r1)
            goto L_0x02d5
        L_0x02ea:
            return r1
        L_0x02eb:
            if (r6 != r14) goto L_0x030b
            com.google.android.gms.internal.firebase-auth-api.zzahe r12 = (com.google.android.gms.internal.p001firebaseauthapi.zzahe) r12
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02f6:
            if (r1 >= r2) goto L_0x0302
            long r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzp(r3, r1)
            r12.zzf(r4)
            int r1 = r1 + 8
            goto L_0x02f6
        L_0x0302:
            if (r1 != r2) goto L_0x0306
            goto L_0x0444
        L_0x0306:
            com.google.android.gms.internal.firebase-auth-api.zzags r1 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzj()
            throw r1
        L_0x030b:
            if (r6 != r13) goto L_0x0443
            com.google.android.gms.internal.firebase-auth-api.zzahe r12 = (com.google.android.gms.internal.p001firebaseauthapi.zzahe) r12
            long r8 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzp(r17, r18)
            r12.zzf(r8)
        L_0x0316:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x032b
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0323
            goto L_0x032b
        L_0x0323:
            long r8 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzp(r3, r4)
            r12.zzf(r8)
            goto L_0x0316
        L_0x032b:
            return r1
        L_0x032c:
            if (r6 != r14) goto L_0x0334
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzf(r3, r4, r12, r7)
            goto L_0x0444
        L_0x0334:
            if (r6 != 0) goto L_0x0443
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzl(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x0345:
            if (r6 != r14) goto L_0x0365
            com.google.android.gms.internal.firebase-auth-api.zzahe r12 = (com.google.android.gms.internal.p001firebaseauthapi.zzahe) r12
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0350:
            if (r1 >= r2) goto L_0x035c
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzm(r3, r1, r7)
            long r4 = r7.zzb
            r12.zzf(r4)
            goto L_0x0350
        L_0x035c:
            if (r1 != r2) goto L_0x0360
            goto L_0x0444
        L_0x0360:
            com.google.android.gms.internal.firebase-auth-api.zzags r1 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzj()
            throw r1
        L_0x0365:
            if (r6 != 0) goto L_0x0443
            com.google.android.gms.internal.firebase-auth-api.zzahe r12 = (com.google.android.gms.internal.p001firebaseauthapi.zzahe) r12
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzf(r8)
        L_0x0372:
            if (r1 >= r5) goto L_0x0387
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x037d
            goto L_0x0387
        L_0x037d:
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzf(r8)
            goto L_0x0372
        L_0x0387:
            return r1
        L_0x0388:
            if (r6 != r14) goto L_0x03ac
            com.google.android.gms.internal.firebase-auth-api.zzage r12 = (com.google.android.gms.internal.p001firebaseauthapi.zzage) r12
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0393:
            if (r1 >= r2) goto L_0x03a3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzb(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r12.zze(r4)
            int r1 = r1 + 4
            goto L_0x0393
        L_0x03a3:
            if (r1 != r2) goto L_0x03a7
            goto L_0x0444
        L_0x03a7:
            com.google.android.gms.internal.firebase-auth-api.zzags r1 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzj()
            throw r1
        L_0x03ac:
            if (r6 != r9) goto L_0x0443
            com.google.android.gms.internal.firebase-auth-api.zzage r12 = (com.google.android.gms.internal.p001firebaseauthapi.zzage) r12
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzb(r17, r18)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
        L_0x03bb:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03d4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03c8
            goto L_0x03d4
        L_0x03c8:
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzb(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
            goto L_0x03bb
        L_0x03d4:
            return r1
        L_0x03d5:
            if (r6 != r14) goto L_0x03f8
            com.google.android.gms.internal.firebase-auth-api.zzafu r12 = (com.google.android.gms.internal.p001firebaseauthapi.zzafu) r12
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03e0:
            if (r1 >= r2) goto L_0x03f0
            long r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzp(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r12.zze(r4)
            int r1 = r1 + 8
            goto L_0x03e0
        L_0x03f0:
            if (r1 != r2) goto L_0x03f3
            goto L_0x0444
        L_0x03f3:
            com.google.android.gms.internal.firebase-auth-api.zzags r1 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzj()
            throw r1
        L_0x03f8:
            if (r6 != r13) goto L_0x0443
            com.google.android.gms.internal.firebase-auth-api.zzafu r12 = (com.google.android.gms.internal.p001firebaseauthapi.zzafu) r12
            long r8 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzp(r17, r18)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
        L_0x0407:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0414
            goto L_0x0420
        L_0x0414:
            long r8 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzp(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
            goto L_0x0407
        L_0x0420:
            return r1
        L_0x0421:
            if (r4 >= r5) goto L_0x0442
            int r8 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x042c
            goto L_0x0442
        L_0x042c:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x0421
        L_0x0442:
            return r4
        L_0x0443:
            r1 = r4
        L_0x0444:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzahs.zzt(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.firebase-auth-api.zzaes):int");
    }

    private final int zzu(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzx(i, 0);
    }

    private final int zzv(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzx(i, i2);
    }

    private final int zzw(int i) {
        return this.zzc[i + 2];
    }

    private final int zzx(int i, int i2) {
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

    private static int zzy(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzz(int i) {
        return this.zzc[i + 1];
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
            boolean r0 = r11.zzj
            if (r0 == 0) goto L_0x0583
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x0009:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0577
            int r4 = r11.zzz(r2)
            int r5 = zzy(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            com.google.android.gms.internal.firebase-auth-api.zzagd r7 = com.google.android.gms.internal.p001firebaseauthapi.zzagd.DOUBLE_LIST_PACKED
            int r7 = r7.zza()
            if (r5 < r7) goto L_0x0034
            com.google.android.gms.internal.firebase-auth-api.zzagd r7 = com.google.android.gms.internal.p001firebaseauthapi.zzagd.SINT64_LIST_PACKED
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
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            com.google.android.gms.internal.firebase-auth-api.zzahp r4 = (com.google.android.gms.internal.p001firebaseauthapi.zzahp) r4
            com.google.android.gms.internal.firebase-auth-api.zzaib r5 = r11.zzC(r2)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzw(r6, r4, r5)
            goto L_0x03ee
        L_0x0052:
            boolean r5 = r11.zzW(r12, r6, r2)
            if (r5 == 0) goto L_0x0573
            long r7 = zzA(r12, r7)
            int r5 = r6 << 3
            long r9 = r7 + r7
            long r6 = r7 >> r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            long r5 = r9 ^ r6
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzB(r5)
            goto L_0x0420
        L_0x006e:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = zzq(r12, r7)
            int r5 = r6 << 3
            int r6 = r4 + r4
            int r4 = r4 >> 31
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x0550
        L_0x0089:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x056f
        L_0x0097:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x055f
        L_0x00a5:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = zzq(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzx(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0550
        L_0x00bb:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = zzq(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0550
        L_0x00d1:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            com.google.android.gms.internal.firebase-auth-api.zzaff r4 = (com.google.android.gms.internal.p001firebaseauthapi.zzaff) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzf
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x04a2
        L_0x00f0:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            com.google.android.gms.internal.firebase-auth-api.zzaib r5 = r11.zzC(r2)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzn(r6, r4, r5)
            goto L_0x03ee
        L_0x0104:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzaff
            if (r5 == 0) goto L_0x0127
            com.google.android.gms.internal.firebase-auth-api.zzaff r4 = (com.google.android.gms.internal.p001firebaseauthapi.zzaff) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzf
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x04a2
        L_0x0127:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzz(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0550
        L_0x0135:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x04f4
        L_0x0143:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x055f
        L_0x0151:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x056f
        L_0x015f:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = zzq(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzx(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0550
        L_0x0175:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            long r4 = zzA(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzB(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r6)
            goto L_0x0550
        L_0x018b:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            long r4 = zzA(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzB(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r6)
            goto L_0x0550
        L_0x01a1:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x055f
        L_0x01af:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x056f
        L_0x01bd:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            java.lang.Object r5 = r11.zzE(r2)
            com.google.android.gms.internal.p001firebaseauthapi.zzahk.zza(r6, r4, r5)
            goto L_0x0573
        L_0x01ca:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase-auth-api.zzaib r5 = r11.zzC(r2)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzi(r6, r4, r5)
            goto L_0x03ee
        L_0x01da:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzs(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0326
        L_0x01f2:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzq(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0326
        L_0x020a:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzh(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0326
        L_0x0222:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzf(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0326
        L_0x023a:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzd(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0326
        L_0x0252:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzv(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0326
        L_0x026a:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zza
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0326
        L_0x0284:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzf(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0326
        L_0x029c:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzh(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0326
        L_0x02b4:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzk(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0326
        L_0x02cb:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzx(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0326
        L_0x02e2:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzm(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0326
        L_0x02f9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzf(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0326
        L_0x0310:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzh(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
        L_0x0326:
            int r5 = r5 + r6
            goto L_0x0550
        L_0x0329:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzr(r6, r4, r1)
            goto L_0x03ee
        L_0x0335:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzp(r6, r4, r1)
            goto L_0x03ee
        L_0x0341:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzg(r6, r4, r1)
            goto L_0x03ee
        L_0x034d:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zze(r6, r4, r1)
            goto L_0x03ee
        L_0x0359:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzc(r6, r4, r1)
            goto L_0x03ee
        L_0x0365:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzu(r6, r4, r1)
            goto L_0x03ee
        L_0x0371:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzb(r6, r4)
            goto L_0x03ee
        L_0x037d:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase-auth-api.zzaib r5 = r11.zzC(r2)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzo(r6, r4, r5)
            goto L_0x03ee
        L_0x038c:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzt(r6, r4)
            goto L_0x03ee
        L_0x0397:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zza(r6, r4, r1)
            goto L_0x03ee
        L_0x03a2:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zze(r6, r4, r1)
            goto L_0x03ee
        L_0x03ad:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzg(r6, r4, r1)
            goto L_0x03ee
        L_0x03b8:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzj(r6, r4, r1)
            goto L_0x03ee
        L_0x03c3:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzw(r6, r4, r1)
            goto L_0x03ee
        L_0x03ce:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzl(r6, r4, r1)
            goto L_0x03ee
        L_0x03d9:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zze(r6, r4, r1)
            goto L_0x03ee
        L_0x03e4:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzg(r6, r4, r1)
        L_0x03ee:
            int r3 = r3 + r4
            goto L_0x0573
        L_0x03f1:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            com.google.android.gms.internal.firebase-auth-api.zzahp r4 = (com.google.android.gms.internal.p001firebaseauthapi.zzahp) r4
            com.google.android.gms.internal.firebase-auth-api.zzaib r5 = r11.zzC(r2)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzw(r6, r4, r5)
            goto L_0x03ee
        L_0x0406:
            boolean r5 = r11.zzS(r12, r2)
            if (r5 == 0) goto L_0x0573
            long r7 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzd(r12, r7)
            int r5 = r6 << 3
            long r9 = r7 + r7
            long r6 = r7 >> r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            long r5 = r9 ^ r6
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzB(r5)
        L_0x0420:
            int r4 = r4 + r5
            goto L_0x03ee
        L_0x0422:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzc(r12, r7)
            int r5 = r6 << 3
            int r6 = r4 + r4
            int r4 = r4 >> 31
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x0550
        L_0x043d:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x056f
        L_0x044b:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x055f
        L_0x0459:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzc(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzx(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0550
        L_0x046f:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzc(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0550
        L_0x0485:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            com.google.android.gms.internal.firebase-auth-api.zzaff r4 = (com.google.android.gms.internal.p001firebaseauthapi.zzaff) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzf
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
        L_0x04a2:
            int r4 = r4 + r6
            goto L_0x03ee
        L_0x04a5:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            com.google.android.gms.internal.firebase-auth-api.zzaib r5 = r11.zzC(r2)
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzn(r6, r4, r5)
            goto L_0x03ee
        L_0x04b9:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzaff
            if (r5 == 0) goto L_0x04db
            com.google.android.gms.internal.firebase-auth-api.zzaff r4 = (com.google.android.gms.internal.p001firebaseauthapi.zzaff) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzf
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x04a2
        L_0x04db:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzz(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0550
        L_0x04e8:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
        L_0x04f4:
            int r4 = r4 + 1
            goto L_0x03ee
        L_0x04f8:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x055f
        L_0x0505:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
            goto L_0x056f
        L_0x0512:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzc(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzx(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r5)
            goto L_0x0550
        L_0x0527:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0573
            long r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzd(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzB(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r6)
            goto L_0x0550
        L_0x053c:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0573
            long r4 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzd(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzB(r4)
            int r5 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r6)
        L_0x0550:
            int r5 = r5 + r4
            int r3 = r3 + r5
            goto L_0x0573
        L_0x0553:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
        L_0x055f:
            int r4 = r4 + 4
            goto L_0x03ee
        L_0x0563:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafs.zzA(r4)
        L_0x056f:
            int r4 = r4 + 8
            goto L_0x03ee
        L_0x0573:
            int r2 = r2 + 3
            goto L_0x0009
        L_0x0577:
            com.google.android.gms.internal.firebase-auth-api.zzaiv r0 = r11.zzo
            java.lang.Object r12 = r0.zzd(r12)
            int r12 = r0.zza(r12)
            int r3 = r3 + r12
            goto L_0x0587
        L_0x0583:
            int r3 = r11.zzp(r12)
        L_0x0587:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzahs.zza(java.lang.Object):int");
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
            int r3 = r9.zzz(r1)
            int[] r4 = r9.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            int r3 = zzy(r3)
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
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            java.lang.Object r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r10, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x0033:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzA(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p001firebaseauthapi.zzagq.zzd
            goto L_0x020f
        L_0x0043:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzq(r10, r5)
            goto L_0x0201
        L_0x0051:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzA(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p001firebaseauthapi.zzagq.zzd
            goto L_0x020f
        L_0x0061:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzq(r10, r5)
            goto L_0x0201
        L_0x006f:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzq(r10, r5)
            goto L_0x0201
        L_0x007d:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzq(r10, r5)
            goto L_0x0201
        L_0x008b:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x009d:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            java.lang.Object r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r10, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x00af:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r10, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x00c3:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            boolean r3 = zzX(r10, r5)
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzagq.zza(r3)
            goto L_0x0201
        L_0x00d5:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzq(r10, r5)
            goto L_0x0201
        L_0x00e3:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzA(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p001firebaseauthapi.zzagq.zzd
            goto L_0x020f
        L_0x00f3:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzq(r10, r5)
            goto L_0x0201
        L_0x0101:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzA(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p001firebaseauthapi.zzagq.zzd
            goto L_0x020f
        L_0x0111:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzA(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p001firebaseauthapi.zzagq.zzd
            goto L_0x020f
        L_0x0121:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            float r3 = zzo(r10, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0201
        L_0x0133:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            double r3 = zzn(r10, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            byte[] r5 = com.google.android.gms.internal.p001firebaseauthapi.zzagq.zzd
            goto L_0x020f
        L_0x0147:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x0153:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x015f:
            java.lang.Object r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r10, r5)
            if (r3 == 0) goto L_0x01b2
            int r7 = r3.hashCode()
            goto L_0x01b2
        L_0x016a:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p001firebaseauthapi.zzagq.zzd
            goto L_0x020f
        L_0x0174:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzc(r10, r5)
            goto L_0x0201
        L_0x017c:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p001firebaseauthapi.zzagq.zzd
            goto L_0x020f
        L_0x0186:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzc(r10, r5)
            goto L_0x0201
        L_0x018e:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzc(r10, r5)
            goto L_0x0201
        L_0x0196:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzc(r10, r5)
            goto L_0x0201
        L_0x019d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x01a8:
            java.lang.Object r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r10, r5)
            if (r3 == 0) goto L_0x01b2
            int r7 = r3.hashCode()
        L_0x01b2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0214
        L_0x01b6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r10, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x01c3:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzw(r10, r5)
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzagq.zza(r3)
            goto L_0x0201
        L_0x01ce:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzc(r10, r5)
            goto L_0x0201
        L_0x01d5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p001firebaseauthapi.zzagq.zzd
            goto L_0x020f
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzc(r10, r5)
            goto L_0x0201
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p001firebaseauthapi.zzagq.zzd
            goto L_0x020f
        L_0x01ee:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p001firebaseauthapi.zzagq.zzd
            goto L_0x020f
        L_0x01f7:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzb(r10, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
        L_0x0201:
            int r2 = r2 + r3
            goto L_0x0214
        L_0x0203:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zza(r10, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            byte[] r5 = com.google.android.gms.internal.p001firebaseauthapi.zzagq.zzd
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
            com.google.android.gms.internal.firebase-auth-api.zzaiv r0 = r9.zzo
            java.lang.Object r0 = r0.zzd(r10)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r9.zzh
            if (r0 != 0) goto L_0x022a
            return r2
        L_0x022a:
            com.google.android.gms.internal.firebase-auth-api.zzafy r0 = r9.zzp
            r0.zza(r10)
            r10 = 0
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzahs.zzb(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v56, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v97, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x030a, code lost:
        if (r0 != r15) goto L_0x030c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0327, code lost:
        r2 = r0;
        r7 = r20;
        r6 = r23;
        r0 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x035b, code lost:
        if (r0 != r15) goto L_0x030c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0383, code lost:
        if (r0 != r15) goto L_0x030c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0151, code lost:
        r5 = r7 | r8;
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0154, code lost:
        r1 = r11;
        r3 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0158, code lost:
        r12 = r6;
        r20 = r13;
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01ec, code lost:
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x021f, code lost:
        r6 = r23;
        r8 = -1;
        r13 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x024d, code lost:
        r0 = r13 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x024f, code lost:
        r5 = r7 | r8;
        r13 = r31;
        r2 = r6;
        r1 = r11;
        r3 = r20;
        r6 = r23;
        r8 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x025a, code lost:
        r11 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x025e, code lost:
        r12 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x025f, code lost:
        r0 = r32;
        r19 = r7;
        r26 = r10;
        r30 = r11;
        r21 = r12;
        r2 = r13;
        r7 = r20;
        r6 = r23;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(java.lang.Object r28, byte[] r29, int r30, int r31, int r32, com.google.android.gms.internal.p001firebaseauthapi.zzaes r33) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r33
            zzI(r28)
            sun.misc.Unsafe r10 = zzb
            r8 = -1
            r16 = 0
            r0 = r30
            r1 = -1
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001d:
            if (r0 >= r13) goto L_0x03f7
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002e
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzk(r0, r12, r3, r9)
            int r3 = r9.zza
            r4 = r3
            r3 = r0
            goto L_0x002f
        L_0x002e:
            r4 = r0
        L_0x002f:
            int r0 = r4 >>> 3
            r7 = 3
            if (r0 <= r1) goto L_0x003a
            int r2 = r2 / r7
            int r1 = r15.zzv(r0, r2)
            goto L_0x003e
        L_0x003a:
            int r1 = r15.zzu(r0)
        L_0x003e:
            r2 = r1
            if (r2 != r8) goto L_0x0050
            r30 = r0
            r2 = r3
            r7 = r4
            r19 = r5
            r26 = r10
            r0 = r11
            r18 = -1
            r21 = 0
            goto L_0x0386
        L_0x0050:
            r1 = r4 & 7
            int[] r8 = r15.zzc
            int r19 = r2 + 1
            r7 = r8[r19]
            int r11 = zzy(r7)
            r19 = r0
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r7 & r17
            r21 = r3
            r20 = r4
            long r3 = (long) r0
            r0 = 17
            if (r11 > r0) goto L_0x0272
            int r0 = r2 + 2
            r0 = r8[r0]
            int r8 = r0 >>> 20
            r13 = 1
            int r8 = r13 << r8
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r13
            r17 = r7
            if (r0 == r6) goto L_0x008c
            if (r6 == r13) goto L_0x0083
            long r6 = (long) r6
            r10.putInt(r14, r6, r5)
        L_0x0083:
            long r5 = (long) r0
            int r5 = r10.getInt(r14, r5)
            r23 = r0
            r7 = r5
            goto L_0x008f
        L_0x008c:
            r7 = r5
            r23 = r6
        L_0x008f:
            r0 = 5
            switch(r11) {
                case 0: goto L_0x023a;
                case 1: goto L_0x0225;
                case 2: goto L_0x0200;
                case 3: goto L_0x0200;
                case 4: goto L_0x01ef;
                case 5: goto L_0x01d4;
                case 6: goto L_0x01c2;
                case 7: goto L_0x01a7;
                case 8: goto L_0x0189;
                case 9: goto L_0x015e;
                case 10: goto L_0x013e;
                case 11: goto L_0x01ef;
                case 12: goto L_0x010f;
                case 13: goto L_0x01c2;
                case 14: goto L_0x01d4;
                case 15: goto L_0x00f8;
                case 16: goto L_0x00c9;
                default: goto L_0x0093;
            }
        L_0x0093:
            r6 = r2
            r11 = r19
            r13 = r21
            r0 = 3
            if (r1 != r0) goto L_0x025e
            java.lang.Object r5 = r15.zzF(r14, r6)
            int r0 = r11 << 3
            r17 = r0 | 4
            com.google.android.gms.internal.firebase-auth-api.zzaib r1 = r15.zzC(r6)
            r0 = r5
            r2 = r29
            r3 = r13
            r4 = r31
            r13 = r5
            r5 = r17
            r12 = r6
            r6 = r33
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzn(r0, r1, r2, r3, r4, r5, r6)
            r15.zzO(r14, r12, r13)
            r5 = r7 | r8
            r13 = r31
            r1 = r11
            r2 = r12
            r3 = r20
            r6 = r23
            r8 = -1
            r12 = r29
            goto L_0x025a
        L_0x00c9:
            if (r1 != 0) goto L_0x00f1
            r5 = r21
            int r6 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzm(r12, r5, r9)
            long r0 = r9.zzb
            long r21 = com.google.android.gms.internal.p001firebaseauthapi.zzafl.zzG(r0)
            r11 = r19
            r0 = r10
            r1 = r28
            r5 = r2
            r2 = r3
            r17 = r6
            r13 = r20
            r6 = r5
            r4 = r21
            r0.putLong(r1, r2, r4)
            r5 = r7 | r8
            r2 = r6
            r1 = r11
            r3 = r13
            r0 = r17
            goto L_0x021f
        L_0x00f1:
            r11 = r19
            r12 = r2
            r13 = r21
            goto L_0x025f
        L_0x00f8:
            r6 = r2
            r11 = r19
            r13 = r20
            r5 = r21
            if (r1 != 0) goto L_0x0158
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r12, r5, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzafl.zzF(r1)
            r10.putInt(r14, r3, r1)
            goto L_0x0151
        L_0x010f:
            r6 = r2
            r11 = r19
            r13 = r20
            r5 = r21
            if (r1 != 0) goto L_0x0158
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r12, r5, r9)
            int r1 = r9.zza
            com.google.android.gms.internal.firebase-auth-api.zzago r2 = r15.zzB(r6)
            if (r2 == 0) goto L_0x013a
            boolean r2 = r2.zza()
            if (r2 == 0) goto L_0x012b
            goto L_0x013a
        L_0x012b:
            com.google.android.gms.internal.firebase-auth-api.zzaiw r2 = zzd(r28)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzj(r13, r1)
            r2 = r6
            r5 = r7
            goto L_0x0154
        L_0x013a:
            r10.putInt(r14, r3, r1)
            goto L_0x0151
        L_0x013e:
            r6 = r2
            r11 = r19
            r13 = r20
            r5 = r21
            r0 = 2
            if (r1 != r0) goto L_0x0158
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zza(r12, r5, r9)
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
        L_0x0151:
            r5 = r7 | r8
            r2 = r6
        L_0x0154:
            r1 = r11
            r3 = r13
            goto L_0x021f
        L_0x0158:
            r12 = r6
            r20 = r13
            r13 = r5
            goto L_0x025f
        L_0x015e:
            r6 = r2
            r11 = r19
            r13 = r20
            r5 = r21
            r0 = 2
            if (r1 != r0) goto L_0x0185
            java.lang.Object r4 = r15.zzF(r14, r6)
            com.google.android.gms.internal.firebase-auth-api.zzaib r1 = r15.zzC(r6)
            r0 = r4
            r2 = r29
            r3 = r5
            r5 = r4
            r4 = r31
            r20 = r13
            r13 = r5
            r5 = r33
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzo(r0, r1, r2, r3, r4, r5)
            r15.zzO(r14, r6, r13)
            goto L_0x024f
        L_0x0185:
            r20 = r13
            goto L_0x01ec
        L_0x0189:
            r6 = r2
            r11 = r19
            r5 = r21
            r0 = 2
            if (r1 != r0) goto L_0x01ec
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r17 & r0
            if (r0 != 0) goto L_0x019c
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzg(r12, r5, r9)
            goto L_0x01a0
        L_0x019c:
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzh(r12, r5, r9)
        L_0x01a0:
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
            goto L_0x024f
        L_0x01a7:
            r6 = r2
            r11 = r19
            r5 = r21
            if (r1 != 0) goto L_0x01ec
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzm(r12, r5, r9)
            long r1 = r9.zzb
            r21 = 0
            int r5 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r5 == 0) goto L_0x01bc
            r13 = 1
            goto L_0x01bd
        L_0x01bc:
            r13 = 0
        L_0x01bd:
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzm(r14, r3, r13)
            goto L_0x024f
        L_0x01c2:
            r6 = r2
            r11 = r19
            r5 = r21
            if (r1 != r0) goto L_0x01ec
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzb(r12, r5)
            r10.putInt(r14, r3, r0)
            int r0 = r5 + 4
            goto L_0x024f
        L_0x01d4:
            r6 = r2
            r11 = r19
            r5 = r21
            r0 = 1
            if (r1 != r0) goto L_0x01ec
            long r21 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzp(r12, r5)
            r0 = r10
            r1 = r28
            r13 = r5
            r2 = r3
            r4 = r21
            r0.putLong(r1, r2, r4)
            goto L_0x024d
        L_0x01ec:
            r13 = r5
            goto L_0x025e
        L_0x01ef:
            r6 = r2
            r11 = r19
            r13 = r21
            if (r1 != 0) goto L_0x025e
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r12, r13, r9)
            int r1 = r9.zza
            r10.putInt(r14, r3, r1)
            goto L_0x024f
        L_0x0200:
            r6 = r2
            r11 = r19
            r13 = r21
            if (r1 != 0) goto L_0x025e
            int r13 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzm(r12, r13, r9)
            long r1 = r9.zzb
            r0 = r10
            r21 = r1
            r1 = r28
            r2 = r3
            r4 = r21
            r0.putLong(r1, r2, r4)
            r5 = r7 | r8
            r2 = r6
            r1 = r11
            r0 = r13
            r3 = r20
        L_0x021f:
            r6 = r23
            r8 = -1
            r13 = r31
            goto L_0x025a
        L_0x0225:
            r6 = r2
            r11 = r19
            r13 = r21
            if (r1 != r0) goto L_0x025e
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzb(r12, r13)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzp(r14, r3, r0)
            int r0 = r13 + 4
            goto L_0x024f
        L_0x023a:
            r6 = r2
            r11 = r19
            r13 = r21
            r0 = 1
            if (r1 != r0) goto L_0x025e
            long r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzp(r12, r13)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzo(r14, r3, r0)
        L_0x024d:
            int r0 = r13 + 8
        L_0x024f:
            r5 = r7 | r8
            r13 = r31
            r2 = r6
            r1 = r11
            r3 = r20
            r6 = r23
            r8 = -1
        L_0x025a:
            r11 = r32
            goto L_0x001d
        L_0x025e:
            r12 = r6
        L_0x025f:
            r0 = r32
            r19 = r7
            r26 = r10
            r30 = r11
            r21 = r12
            r2 = r13
            r7 = r20
            r6 = r23
            r18 = -1
            goto L_0x0386
        L_0x0272:
            r12 = r2
            r17 = r7
            r8 = r19
            r13 = r21
            r0 = 27
            if (r11 != r0) goto L_0x02d4
            r0 = 2
            if (r1 != r0) goto L_0x02c5
            java.lang.Object r0 = r10.getObject(r14, r3)
            com.google.android.gms.internal.firebase-auth-api.zzagp r0 = (com.google.android.gms.internal.p001firebaseauthapi.zzagp) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x029d
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0295
            r1 = 10
            goto L_0x0296
        L_0x0295:
            int r1 = r1 + r1
        L_0x0296:
            com.google.android.gms.internal.firebase-auth-api.zzagp r0 = r0.zzd(r1)
            r10.putObject(r14, r3, r0)
        L_0x029d:
            r7 = r0
            com.google.android.gms.internal.firebase-auth-api.zzaib r0 = r15.zzC(r12)
            r1 = r20
            r2 = r29
            r3 = r13
            r4 = r31
            r19 = r5
            r5 = r7
            r23 = r6
            r6 = r33
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zze(r0, r1, r2, r3, r4, r5, r6)
            r13 = r31
            r11 = r32
            r1 = r8
            r2 = r12
            r5 = r19
            r3 = r20
            r6 = r23
            r8 = -1
            r12 = r29
            goto L_0x001d
        L_0x02c5:
            r19 = r5
            r23 = r6
            r30 = r8
            r26 = r10
            r21 = r12
            r15 = r13
            r18 = -1
            goto L_0x035e
        L_0x02d4:
            r19 = r5
            r23 = r6
            r0 = 49
            if (r11 > r0) goto L_0x0330
            r7 = r17
            long r6 = (long) r7
            r0 = r27
            r5 = r1
            r1 = r28
            r2 = r29
            r24 = r3
            r3 = r13
            r4 = r31
            r17 = r5
            r5 = r20
            r21 = r6
            r6 = r8
            r7 = r17
            r30 = r8
            r18 = -1
            r8 = r12
            r26 = r10
            r9 = r21
            r15 = r32
            r21 = r12
            r15 = r13
            r12 = r24
            r14 = r33
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x0327
        L_0x030c:
            r15 = r27
            r14 = r28
            r12 = r29
            r1 = r30
            r13 = r31
            r11 = r32
            r9 = r33
            r5 = r19
            r3 = r20
            r2 = r21
            r6 = r23
            r10 = r26
            r8 = -1
            goto L_0x001d
        L_0x0327:
            r2 = r0
            r7 = r20
            r6 = r23
            r0 = r32
            goto L_0x0386
        L_0x0330:
            r24 = r3
            r30 = r8
            r26 = r10
            r21 = r12
            r15 = r13
            r7 = r17
            r18 = -1
            r17 = r1
            r0 = 50
            if (r11 != r0) goto L_0x0366
            r8 = r17
            r0 = 2
            if (r8 != r0) goto L_0x035e
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r21
            r6 = r24
            r8 = r33
            int r0 = r0.zzr(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x0327
            goto L_0x030c
        L_0x035e:
            r0 = r32
            r2 = r15
            r7 = r20
            r6 = r23
            goto L_0x0386
        L_0x0366:
            r8 = r17
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r20
            r6 = r30
            r9 = r7
            r7 = r8
            r8 = r9
            r9 = r11
            r10 = r24
            r12 = r21
            r13 = r33
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x0327
            goto L_0x030c
        L_0x0386:
            if (r7 != r0) goto L_0x0398
            if (r0 == 0) goto L_0x0398
            r8 = r27
            r12 = r28
            r9 = r0
            r0 = r6
            r5 = r19
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r2
            goto L_0x0407
        L_0x0398:
            r8 = r27
            r9 = r0
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x03cf
            r10 = r33
            com.google.android.gms.internal.firebase-auth-api.zzafx r0 = r10.zzd
            com.google.android.gms.internal.firebase-auth-api.zzafx r1 = com.google.android.gms.internal.p001firebaseauthapi.zzafx.zza
            if (r0 == r1) goto L_0x03ca
            com.google.android.gms.internal.firebase-auth-api.zzahp r1 = r8.zzg
            r11 = r30
            com.google.android.gms.internal.firebase-auth-api.zzagi r0 = r0.zzb(r1, r11)
            if (r0 != 0) goto L_0x03c3
            com.google.android.gms.internal.firebase-auth-api.zzaiw r4 = zzd(r28)
            r0 = r7
            r1 = r29
            r3 = r31
            r5 = r33
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzi(r0, r1, r2, r3, r4, r5)
            r12 = r28
            goto L_0x03e4
        L_0x03c3:
            r12 = r28
            r0 = r12
            com.google.android.gms.internal.firebase-auth-api.zzagh r0 = (com.google.android.gms.internal.p001firebaseauthapi.zzagh) r0
            r0 = 0
            throw r0
        L_0x03ca:
            r12 = r28
            r11 = r30
            goto L_0x03d5
        L_0x03cf:
            r12 = r28
            r11 = r30
            r10 = r33
        L_0x03d5:
            com.google.android.gms.internal.firebase-auth-api.zzaiw r4 = zzd(r28)
            r0 = r7
            r1 = r29
            r3 = r31
            r5 = r33
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzi(r0, r1, r2, r3, r4, r5)
        L_0x03e4:
            r13 = r31
            r3 = r7
            r15 = r8
            r1 = r11
            r14 = r12
            r5 = r19
            r2 = r21
            r8 = -1
            r12 = r29
            r11 = r9
            r9 = r10
            r10 = r26
            goto L_0x001d
        L_0x03f7:
            r19 = r5
            r23 = r6
            r26 = r10
            r9 = r11
            r12 = r14
            r8 = r15
            r6 = r0
            r7 = r3
            r0 = r23
            r1 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0407:
            if (r0 == r1) goto L_0x040f
            long r0 = (long) r0
            r2 = r26
            r2.putInt(r12, r0, r5)
        L_0x040f:
            int r0 = r8.zzl
            r10 = r0
        L_0x0412:
            int r0 = r8.zzm
            if (r10 >= r0) goto L_0x0429
            int[] r0 = r8.zzk
            r2 = r0[r10]
            r3 = 0
            com.google.android.gms.internal.firebase-auth-api.zzaiv r4 = r8.zzo
            r0 = r27
            r1 = r28
            r5 = r28
            r0.zzD(r1, r2, r3, r4, r5)
            int r10 = r10 + 1
            goto L_0x0412
        L_0x0429:
            if (r9 != 0) goto L_0x0435
            r0 = r31
            if (r6 != r0) goto L_0x0430
            goto L_0x043b
        L_0x0430:
            com.google.android.gms.internal.firebase-auth-api.zzags r0 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzg()
            throw r0
        L_0x0435:
            r0 = r31
            if (r6 > r0) goto L_0x043c
            if (r7 != r9) goto L_0x043c
        L_0x043b:
            return r6
        L_0x043c:
            com.google.android.gms.internal.firebase-auth-api.zzags r0 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzahs.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.firebase-auth-api.zzaes):int");
    }

    public final Object zze() {
        return ((zzagk) this.zzg).zzw();
    }

    public final void zzf(Object obj) {
        if (zzV(obj)) {
            if (obj instanceof zzagk) {
                zzagk zzagk = (zzagk) obj;
                zzagk.zzI(Integer.MAX_VALUE);
                zzagk.zza = 0;
                zzagk.zzG();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzz = zzz(i);
                int i2 = 1048575 & zzz;
                int zzy = zzy(zzz);
                long j = (long) i2;
                if (zzy != 9) {
                    if (zzy == 60 || zzy == 68) {
                        if (zzW(obj, this.zzc[i], i)) {
                            zzC(i).zzf(zzb.getObject(obj, j));
                        }
                    } else {
                        switch (zzy) {
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
                                this.zzn.zzb(obj, j);
                                continue;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzahj) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (zzS(obj, i)) {
                    zzC(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzo.zzm(obj);
            if (this.zzh) {
                this.zzp.zze(obj);
            }
        }
    }

    public final void zzg(Object obj, Object obj2) {
        zzI(obj);
        Objects.requireNonNull(obj2);
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzz = zzz(i);
            int i2 = this.zzc[i];
            long j = (long) (1048575 & zzz);
            switch (zzy(zzz)) {
                case 0:
                    if (!zzS(obj2, i)) {
                        break;
                    } else {
                        zzajf.zzo(obj, j, zzajf.zza(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 1:
                    if (!zzS(obj2, i)) {
                        break;
                    } else {
                        zzajf.zzp(obj, j, zzajf.zzb(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 2:
                    if (!zzS(obj2, i)) {
                        break;
                    } else {
                        zzajf.zzr(obj, j, zzajf.zzd(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 3:
                    if (!zzS(obj2, i)) {
                        break;
                    } else {
                        zzajf.zzr(obj, j, zzajf.zzd(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 4:
                    if (!zzS(obj2, i)) {
                        break;
                    } else {
                        zzajf.zzq(obj, j, zzajf.zzc(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 5:
                    if (!zzS(obj2, i)) {
                        break;
                    } else {
                        zzajf.zzr(obj, j, zzajf.zzd(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 6:
                    if (!zzS(obj2, i)) {
                        break;
                    } else {
                        zzajf.zzq(obj, j, zzajf.zzc(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 7:
                    if (!zzS(obj2, i)) {
                        break;
                    } else {
                        zzajf.zzm(obj, j, zzajf.zzw(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 8:
                    if (!zzS(obj2, i)) {
                        break;
                    } else {
                        zzajf.zzs(obj, j, zzajf.zzf(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 9:
                    zzJ(obj, obj2, i);
                    break;
                case 10:
                    if (!zzS(obj2, i)) {
                        break;
                    } else {
                        zzajf.zzs(obj, j, zzajf.zzf(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 11:
                    if (!zzS(obj2, i)) {
                        break;
                    } else {
                        zzajf.zzq(obj, j, zzajf.zzc(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 12:
                    if (!zzS(obj2, i)) {
                        break;
                    } else {
                        zzajf.zzq(obj, j, zzajf.zzc(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 13:
                    if (!zzS(obj2, i)) {
                        break;
                    } else {
                        zzajf.zzq(obj, j, zzajf.zzc(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 14:
                    if (!zzS(obj2, i)) {
                        break;
                    } else {
                        zzajf.zzr(obj, j, zzajf.zzd(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 15:
                    if (!zzS(obj2, i)) {
                        break;
                    } else {
                        zzajf.zzq(obj, j, zzajf.zzc(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 16:
                    if (!zzS(obj2, i)) {
                        break;
                    } else {
                        zzajf.zzr(obj, j, zzajf.zzd(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 17:
                    zzJ(obj, obj2, i);
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
                    this.zzn.zzc(obj, obj2, j);
                    break;
                case 50:
                    int i3 = zzaid.zza;
                    zzajf.zzs(obj, j, zzahk.zzc(zzajf.zzf(obj, j), zzajf.zzf(obj2, j)));
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
                    if (!zzW(obj2, i2, i)) {
                        break;
                    } else {
                        zzajf.zzs(obj, j, zzajf.zzf(obj2, j));
                        zzN(obj, i2, i);
                        break;
                    }
                case 60:
                    zzK(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzW(obj2, i2, i)) {
                        break;
                    } else {
                        zzajf.zzs(obj, j, zzajf.zzf(obj2, j));
                        zzN(obj, i2, i);
                        break;
                    }
                case 68:
                    zzK(obj, obj2, i);
                    break;
            }
        }
        zzaid.zzC(this.zzo, obj, obj2);
        if (this.zzh) {
            this.zzp.zza(obj2);
            throw null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:175|174|176|177|(0)|180|(0)|170|157|158|207|200) */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x05e3, code lost:
        r15 = r9;
        r5 = r11;
        r4 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0612, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0655, code lost:
        r4 = zzD(r18, r7.zzk[r8], r4, r10, r18);
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0669, code lost:
        r10.zzn(r9, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0181, code lost:
        r13 = r4;
        r11 = r5;
        r14 = r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:176:0x0618 */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x061d A[Catch:{ all -> 0x0612 }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0655 A[LOOP:5: B:194:0x0651->B:196:0x0655, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0669  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0628 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(java.lang.Object r18, com.google.android.gms.internal.p001firebaseauthapi.zzaia r19, com.google.android.gms.internal.p001firebaseauthapi.zzafx r20) throws java.io.IOException {
        /*
            r17 = this;
            r7 = r17
            r15 = r18
            r0 = r19
            r6 = r20
            java.util.Objects.requireNonNull(r20)
            zzI(r18)
            com.google.android.gms.internal.firebase-auth-api.zzaiv r14 = r7.zzo
            com.google.android.gms.internal.firebase-auth-api.zzafy r5 = r7.zzp
            r16 = 0
            r4 = r16
            r8 = r4
        L_0x0017:
            int r2 = r19.zzc()     // Catch:{ all -> 0x0649 }
            int r1 = r7.zzu(r2)     // Catch:{ all -> 0x0649 }
            if (r1 >= 0) goto L_0x00b4
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r1) goto L_0x0044
            int r0 = r7.zzl
        L_0x0028:
            int r1 = r7.zzm
            if (r0 >= r1) goto L_0x003e
            int[] r1 = r7.zzk
            r3 = r1[r0]
            r1 = r17
            r2 = r18
            r5 = r14
            r6 = r18
            java.lang.Object r4 = r1.zzD(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x0028
        L_0x003e:
            if (r4 == 0) goto L_0x0645
            r14.zzn(r15, r4)
            return
        L_0x0044:
            boolean r1 = r7.zzh     // Catch:{ all -> 0x00af }
            if (r1 != 0) goto L_0x004b
            r11 = r16
            goto L_0x0052
        L_0x004b:
            com.google.android.gms.internal.firebase-auth-api.zzahp r1 = r7.zzg     // Catch:{ all -> 0x00af }
            java.lang.Object r1 = r5.zzc(r6, r1, r2)     // Catch:{ all -> 0x00af }
            r11 = r1
        L_0x0052:
            if (r11 == 0) goto L_0x006f
            if (r8 != 0) goto L_0x005a
            com.google.android.gms.internal.firebase-auth-api.zzagc r8 = r5.zzb(r15)     // Catch:{ all -> 0x0649 }
        L_0x005a:
            r1 = r8
            r8 = r5
            r9 = r18
            r10 = r19
            r12 = r20
            r13 = r1
            r3 = r14
            r14 = r4
            r2 = r15
            r15 = r3
            java.lang.Object r4 = r8.zzd(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x00aa }
            r8 = r1
        L_0x006c:
            r15 = r2
            r14 = r3
            goto L_0x0017
        L_0x006f:
            r3 = r14
            r2 = r15
            r3.zzq(r0)     // Catch:{ all -> 0x00aa }
            if (r4 != 0) goto L_0x007a
            java.lang.Object r4 = r3.zzc(r2)     // Catch:{ all -> 0x00aa }
        L_0x007a:
            boolean r1 = r3.zzp(r4, r0)     // Catch:{ all -> 0x00a5 }
            if (r1 != 0) goto L_0x006c
            int r0 = r7.zzl
        L_0x0082:
            int r1 = r7.zzm
            if (r0 >= r1) goto L_0x009d
            int[] r1 = r7.zzk
            r5 = r1[r0]
            r1 = r17
            r9 = r2
            r2 = r18
            r10 = r3
            r3 = r5
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zzD(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            r2 = r9
            r3 = r10
            goto L_0x0082
        L_0x009d:
            r9 = r2
            r10 = r3
            if (r4 == 0) goto L_0x0645
            r10.zzn(r9, r4)
            return
        L_0x00a5:
            r0 = move-exception
            r9 = r2
            r10 = r3
            goto L_0x064e
        L_0x00aa:
            r0 = move-exception
            r9 = r2
            r10 = r3
            goto L_0x0647
        L_0x00af:
            r0 = move-exception
            r10 = r14
            r9 = r15
            goto L_0x0647
        L_0x00b4:
            r10 = r14
            r9 = r15
            int r3 = r7.zzz(r1)     // Catch:{ all -> 0x0646 }
            int r11 = zzy(r3)     // Catch:{ zzagr -> 0x0614 }
            r12 = 1048575(0xfffff, float:1.469367E-39)
            switch(r11) {
                case 0: goto L_0x05d3;
                case 1: goto L_0x05c2;
                case 2: goto L_0x05b1;
                case 3: goto L_0x05a0;
                case 4: goto L_0x058f;
                case 5: goto L_0x057e;
                case 6: goto L_0x056c;
                case 7: goto L_0x055a;
                case 8: goto L_0x054c;
                case 9: goto L_0x0537;
                case 10: goto L_0x0525;
                case 11: goto L_0x0513;
                case 12: goto L_0x04ee;
                case 13: goto L_0x04dc;
                case 14: goto L_0x04ca;
                case 15: goto L_0x04b8;
                case 16: goto L_0x04a6;
                case 17: goto L_0x0491;
                case 18: goto L_0x0480;
                case 19: goto L_0x046f;
                case 20: goto L_0x045e;
                case 21: goto L_0x044d;
                case 22: goto L_0x043c;
                case 23: goto L_0x042b;
                case 24: goto L_0x041a;
                case 25: goto L_0x0409;
                case 26: goto L_0x03dc;
                case 27: goto L_0x03c7;
                case 28: goto L_0x03b6;
                case 29: goto L_0x03a5;
                case 30: goto L_0x0389;
                case 31: goto L_0x0378;
                case 32: goto L_0x0367;
                case 33: goto L_0x0356;
                case 34: goto L_0x0345;
                case 35: goto L_0x0334;
                case 36: goto L_0x0323;
                case 37: goto L_0x0312;
                case 38: goto L_0x0301;
                case 39: goto L_0x02f0;
                case 40: goto L_0x02df;
                case 41: goto L_0x02ce;
                case 42: goto L_0x02bd;
                case 43: goto L_0x02ac;
                case 44: goto L_0x028f;
                case 45: goto L_0x0281;
                case 46: goto L_0x0273;
                case 47: goto L_0x0265;
                case 48: goto L_0x0257;
                case 49: goto L_0x0245;
                case 50: goto L_0x020f;
                case 51: goto L_0x01fd;
                case 52: goto L_0x01ec;
                case 53: goto L_0x01db;
                case 54: goto L_0x01ca;
                case 55: goto L_0x01b9;
                case 56: goto L_0x01a8;
                case 57: goto L_0x0197;
                case 58: goto L_0x0186;
                case 59: goto L_0x017b;
                case 60: goto L_0x016a;
                case 61: goto L_0x015d;
                case 62: goto L_0x014c;
                case 63: goto L_0x0127;
                case 64: goto L_0x0116;
                case 65: goto L_0x0105;
                case 66: goto L_0x00f3;
                case 67: goto L_0x00e1;
                case 68: goto L_0x00cf;
                default: goto L_0x00c4;
            }
        L_0x00c4:
            r13 = r4
            r11 = r5
            r14 = r6
            if (r13 != 0) goto L_0x05ea
            java.lang.Object r4 = r10.zzc(r9)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05eb
        L_0x00cf:
            java.lang.Object r3 = r7.zzG(r9, r2, r1)     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.firebase-auth-api.zzahp r3 = (com.google.android.gms.internal.p001firebaseauthapi.zzahp) r3     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.firebase-auth-api.zzaib r11 = r7.zzC(r1)     // Catch:{ zzagr -> 0x0614 }
            r0.zzt(r3, r11, r6)     // Catch:{ zzagr -> 0x0614 }
            r7.zzP(r9, r2, r1, r3)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x00e1:
            r3 = r3 & r12
            long r11 = r19.zzn()     // Catch:{ zzagr -> 0x0614 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzagr -> 0x0614 }
            long r12 = (long) r3     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r9, r12, r11)     // Catch:{ zzagr -> 0x0614 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x00f3:
            r3 = r3 & r12
            int r11 = r19.zzi()     // Catch:{ zzagr -> 0x0614 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzagr -> 0x0614 }
            long r12 = (long) r3     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r9, r12, r11)     // Catch:{ zzagr -> 0x0614 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x0105:
            r3 = r3 & r12
            long r11 = r19.zzm()     // Catch:{ zzagr -> 0x0614 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzagr -> 0x0614 }
            long r12 = (long) r3     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r9, r12, r11)     // Catch:{ zzagr -> 0x0614 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x0116:
            r3 = r3 & r12
            int r11 = r19.zzh()     // Catch:{ zzagr -> 0x0614 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzagr -> 0x0614 }
            long r12 = (long) r3     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r9, r12, r11)     // Catch:{ zzagr -> 0x0614 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x0127:
            int r11 = r19.zze()     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.firebase-auth-api.zzago r13 = r7.zzB(r1)     // Catch:{ zzagr -> 0x0614 }
            if (r13 == 0) goto L_0x013f
            boolean r13 = r13.zza()     // Catch:{ zzagr -> 0x0614 }
            if (r13 == 0) goto L_0x0138
            goto L_0x013f
        L_0x0138:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzB(r9, r2, r11, r4, r10)     // Catch:{ zzagr -> 0x0614 }
            r15 = r9
            goto L_0x05e7
        L_0x013f:
            r3 = r3 & r12
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzagr -> 0x0614 }
            long r12 = (long) r3     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r9, r12, r11)     // Catch:{ zzagr -> 0x0614 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x014c:
            r3 = r3 & r12
            int r11 = r19.zzj()     // Catch:{ zzagr -> 0x0614 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzagr -> 0x0614 }
            long r12 = (long) r3     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r9, r12, r11)     // Catch:{ zzagr -> 0x0614 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x015d:
            r3 = r3 & r12
            com.google.android.gms.internal.firebase-auth-api.zzaff r11 = r19.zzp()     // Catch:{ zzagr -> 0x0614 }
            long r12 = (long) r3     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r9, r12, r11)     // Catch:{ zzagr -> 0x0614 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x016a:
            java.lang.Object r3 = r7.zzG(r9, r2, r1)     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.firebase-auth-api.zzahp r3 = (com.google.android.gms.internal.p001firebaseauthapi.zzahp) r3     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.firebase-auth-api.zzaib r11 = r7.zzC(r1)     // Catch:{ zzagr -> 0x0614 }
            r0.zzu(r3, r11, r6)     // Catch:{ zzagr -> 0x0614 }
            r7.zzP(r9, r2, r1, r3)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x017b:
            r7.zzL(r9, r3, r0)     // Catch:{ zzagr -> 0x0614 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzagr -> 0x0614 }
        L_0x0181:
            r13 = r4
            r11 = r5
            r14 = r6
            goto L_0x05e3
        L_0x0186:
            r3 = r3 & r12
            boolean r11 = r19.zzN()     // Catch:{ zzagr -> 0x0614 }
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)     // Catch:{ zzagr -> 0x0614 }
            long r12 = (long) r3     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r9, r12, r11)     // Catch:{ zzagr -> 0x0614 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x0197:
            r3 = r3 & r12
            int r11 = r19.zzf()     // Catch:{ zzagr -> 0x0614 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzagr -> 0x0614 }
            long r12 = (long) r3     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r9, r12, r11)     // Catch:{ zzagr -> 0x0614 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x01a8:
            r3 = r3 & r12
            long r11 = r19.zzk()     // Catch:{ zzagr -> 0x0614 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzagr -> 0x0614 }
            long r12 = (long) r3     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r9, r12, r11)     // Catch:{ zzagr -> 0x0614 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x01b9:
            r3 = r3 & r12
            int r11 = r19.zzg()     // Catch:{ zzagr -> 0x0614 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzagr -> 0x0614 }
            long r12 = (long) r3     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r9, r12, r11)     // Catch:{ zzagr -> 0x0614 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x01ca:
            r3 = r3 & r12
            long r11 = r19.zzo()     // Catch:{ zzagr -> 0x0614 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzagr -> 0x0614 }
            long r12 = (long) r3     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r9, r12, r11)     // Catch:{ zzagr -> 0x0614 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x01db:
            r3 = r3 & r12
            long r11 = r19.zzl()     // Catch:{ zzagr -> 0x0614 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzagr -> 0x0614 }
            long r12 = (long) r3     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r9, r12, r11)     // Catch:{ zzagr -> 0x0614 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x01ec:
            r3 = r3 & r12
            float r11 = r19.zzb()     // Catch:{ zzagr -> 0x0614 }
            java.lang.Float r11 = java.lang.Float.valueOf(r11)     // Catch:{ zzagr -> 0x0614 }
            long r12 = (long) r3     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r9, r12, r11)     // Catch:{ zzagr -> 0x0614 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x01fd:
            r3 = r3 & r12
            double r11 = r19.zza()     // Catch:{ zzagr -> 0x0614 }
            java.lang.Double r11 = java.lang.Double.valueOf(r11)     // Catch:{ zzagr -> 0x0614 }
            long r12 = (long) r3     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r9, r12, r11)     // Catch:{ zzagr -> 0x0614 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x020f:
            java.lang.Object r2 = r7.zzE(r1)     // Catch:{ zzagr -> 0x0614 }
            int r1 = r7.zzz(r1)     // Catch:{ zzagr -> 0x0614 }
            r1 = r1 & r12
            long r11 = (long) r1     // Catch:{ zzagr -> 0x0614 }
            java.lang.Object r1 = com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzf(r9, r11)     // Catch:{ zzagr -> 0x0614 }
            if (r1 == 0) goto L_0x0235
            boolean r3 = com.google.android.gms.internal.p001firebaseauthapi.zzahk.zzb(r1)     // Catch:{ zzagr -> 0x0614 }
            if (r3 == 0) goto L_0x0240
            com.google.android.gms.internal.firebase-auth-api.zzahj r3 = com.google.android.gms.internal.p001firebaseauthapi.zzahj.zza()     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.firebase-auth-api.zzahj r3 = r3.zzb()     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.p001firebaseauthapi.zzahk.zzc(r3, r1)     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r9, r11, r3)     // Catch:{ zzagr -> 0x0614 }
            r1 = r3
            goto L_0x0240
        L_0x0235:
            com.google.android.gms.internal.firebase-auth-api.zzahj r1 = com.google.android.gms.internal.p001firebaseauthapi.zzahj.zza()     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.firebase-auth-api.zzahj r1 = r1.zzb()     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r9, r11, r1)     // Catch:{ zzagr -> 0x0614 }
        L_0x0240:
            com.google.android.gms.internal.firebase-auth-api.zzahj r1 = (com.google.android.gms.internal.p001firebaseauthapi.zzahj) r1     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.firebase-auth-api.zzahi r2 = (com.google.android.gms.internal.p001firebaseauthapi.zzahi) r2     // Catch:{ zzagr -> 0x0614 }
            throw r16     // Catch:{ zzagr -> 0x0614 }
        L_0x0245:
            r2 = r3 & r12
            com.google.android.gms.internal.firebase-auth-api.zzaib r1 = r7.zzC(r1)     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.firebase-auth-api.zzahd r3 = r7.zzn     // Catch:{ zzagr -> 0x0614 }
            long r11 = (long) r2     // Catch:{ zzagr -> 0x0614 }
            java.util.List r2 = r3.zza(r9, r11)     // Catch:{ zzagr -> 0x0614 }
            r0.zzC(r2, r1, r6)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x0257:
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0614 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0614 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0614 }
            r0.zzJ(r1)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x0265:
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0614 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0614 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0614 }
            r0.zzI(r1)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x0273:
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0614 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0614 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0614 }
            r0.zzH(r1)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x0281:
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0614 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0614 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0614 }
            r0.zzG(r1)     // Catch:{ zzagr -> 0x0614 }
            goto L_0x0181
        L_0x028f:
            com.google.android.gms.internal.firebase-auth-api.zzahd r11 = r7.zzn     // Catch:{ zzagr -> 0x0614 }
            r3 = r3 & r12
            long r12 = (long) r3     // Catch:{ zzagr -> 0x0614 }
            java.util.List r3 = r11.zza(r9, r12)     // Catch:{ zzagr -> 0x0614 }
            r0.zzy(r3)     // Catch:{ zzagr -> 0x0614 }
            com.google.android.gms.internal.firebase-auth-api.zzago r11 = r7.zzB(r1)     // Catch:{ zzagr -> 0x0614 }
            r1 = r18
            r13 = r4
            r4 = r11
            r11 = r5
            r5 = r13
            r14 = r6
            r6 = r10
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzA(r1, r2, r3, r4, r5, r6)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x060f
        L_0x02ac:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzL(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x02bd:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzv(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x02ce:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzz(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x02df:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzA(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x02f0:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzD(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x0301:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzM(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x0312:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzE(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x0323:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzB(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x0334:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzx(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x0345:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzJ(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x0356:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzI(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x0367:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzH(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x0378:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzG(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x0389:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r4 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r3 = r3 & r12
            long r5 = (long) r3     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r3 = r4.zza(r9, r5)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzy(r3)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.firebase-auth-api.zzago r4 = r7.zzB(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r1 = r18
            r5 = r13
            r6 = r10
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzA(r1, r2, r3, r4, r5, r6)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x060f
        L_0x03a5:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzL(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x03b6:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzw(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x03c7:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaib r1 = r7.zzC(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            com.google.android.gms.internal.firebase-auth-api.zzahd r3 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            long r4 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r2 = r3.zza(r9, r4)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzF(r2, r1, r14)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x03dc:
            r13 = r4
            r11 = r5
            r14 = r6
            boolean r1 = zzR(r3)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            if (r1 == 0) goto L_0x03f7
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r0
            com.google.android.gms.internal.firebase-auth-api.zzafm r2 = (com.google.android.gms.internal.p001firebaseauthapi.zzafm) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r3 = 1
            r2.zzK(r1, r3)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x03f7:
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r0
            com.google.android.gms.internal.firebase-auth-api.zzafm r2 = (com.google.android.gms.internal.p001firebaseauthapi.zzafm) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r3 = 0
            r2.zzK(r1, r3)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x0409:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzv(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x041a:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzz(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x042b:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzA(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x043c:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzD(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x044d:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzM(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x045e:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzE(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x046f:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzB(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x0480:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzahd r1 = r7.zzn     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzx(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x0491:
            r13 = r4
            r11 = r5
            r14 = r6
            java.lang.Object r2 = r7.zzF(r9, r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.firebase-auth-api.zzahp r2 = (com.google.android.gms.internal.p001firebaseauthapi.zzahp) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.firebase-auth-api.zzaib r3 = r7.zzC(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzt(r2, r3, r14)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r7.zzO(r9, r1, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x04a6:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzn()     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            long r5 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzr(r9, r5, r3)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r7.zzM(r9, r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x04b8:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzi()     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            long r4 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzq(r9, r4, r3)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r7.zzM(r9, r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x04ca:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzm()     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            long r5 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzr(r9, r5, r3)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r7.zzM(r9, r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x04dc:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzh()     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            long r4 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzq(r9, r4, r3)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r7.zzM(r9, r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x04ee:
            r13 = r4
            r11 = r5
            r14 = r6
            int r4 = r19.zze()     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.firebase-auth-api.zzago r5 = r7.zzB(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            if (r5 == 0) goto L_0x0508
            boolean r5 = r5.zza()     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            if (r5 == 0) goto L_0x0502
            goto L_0x0508
        L_0x0502:
            java.lang.Object r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaid.zzB(r9, r2, r4, r13, r10)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x060f
        L_0x0508:
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzq(r9, r2, r4)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r7.zzM(r9, r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x0513:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzj()     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            long r4 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzq(r9, r4, r3)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r7.zzM(r9, r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x0525:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            com.google.android.gms.internal.firebase-auth-api.zzaff r3 = r19.zzp()     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            long r4 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzs(r9, r4, r3)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r7.zzM(r9, r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x0537:
            r13 = r4
            r11 = r5
            r14 = r6
            java.lang.Object r2 = r7.zzF(r9, r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.firebase-auth-api.zzahp r2 = (com.google.android.gms.internal.p001firebaseauthapi.zzahp) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.firebase-auth-api.zzaib r3 = r7.zzC(r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r0.zzu(r2, r3, r14)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r7.zzO(r9, r1, r2)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x054c:
            r13 = r4
            r11 = r5
            r14 = r6
            r7.zzL(r9, r3, r0)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r7.zzM(r9, r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x0557:
            r0 = move-exception
            goto L_0x064d
        L_0x055a:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            boolean r3 = r19.zzN()     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            long r4 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzm(r9, r4, r3)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r7.zzM(r9, r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x056c:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzf()     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            long r4 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzq(r9, r4, r3)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r7.zzM(r9, r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x057e:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzk()     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            long r5 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzr(r9, r5, r3)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r7.zzM(r9, r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x058f:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzg()     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            long r4 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzq(r9, r4, r3)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r7.zzM(r9, r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x05a0:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzo()     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            long r5 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzr(r9, r5, r3)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r7.zzM(r9, r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x05b1:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzl()     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            long r5 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzr(r9, r5, r3)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r7.zzM(r9, r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x05c2:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            float r3 = r19.zzb()     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            long r4 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzp(r9, r4, r3)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r7.zzM(r9, r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            goto L_0x05e3
        L_0x05d3:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            double r3 = r19.zza()     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            long r5 = (long) r2     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzo(r9, r5, r3)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
            r7.zzM(r9, r1)     // Catch:{ zzagr -> 0x0617, all -> 0x0557 }
        L_0x05e3:
            r15 = r9
            r5 = r11
            r4 = r13
        L_0x05e6:
            r6 = r14
        L_0x05e7:
            r14 = r10
            goto L_0x0017
        L_0x05ea:
            r4 = r13
        L_0x05eb:
            boolean r1 = r10.zzp(r4, r0)     // Catch:{ zzagr -> 0x0618 }
            if (r1 != 0) goto L_0x060f
            int r0 = r7.zzl
        L_0x05f3:
            int r1 = r7.zzm
            if (r0 >= r1) goto L_0x0609
            int[] r1 = r7.zzk
            r3 = r1[r0]
            r1 = r17
            r2 = r18
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zzD(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x05f3
        L_0x0609:
            if (r4 == 0) goto L_0x0645
            r10.zzn(r9, r4)
            return
        L_0x060f:
            r15 = r9
            r5 = r11
            goto L_0x05e6
        L_0x0612:
            r0 = move-exception
            goto L_0x064e
        L_0x0614:
            r13 = r4
            r11 = r5
            r14 = r6
        L_0x0617:
            r4 = r13
        L_0x0618:
            r10.zzq(r0)     // Catch:{ all -> 0x0612 }
            if (r4 != 0) goto L_0x0622
            java.lang.Object r1 = r10.zzc(r9)     // Catch:{ all -> 0x0612 }
            r4 = r1
        L_0x0622:
            boolean r1 = r10.zzp(r4, r0)     // Catch:{ all -> 0x0612 }
            if (r1 != 0) goto L_0x060f
            int r0 = r7.zzl
        L_0x062a:
            int r1 = r7.zzm
            if (r0 >= r1) goto L_0x0640
            int[] r1 = r7.zzk
            r3 = r1[r0]
            r1 = r17
            r2 = r18
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zzD(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x062a
        L_0x0640:
            if (r4 == 0) goto L_0x0645
            r10.zzn(r9, r4)
        L_0x0645:
            return
        L_0x0646:
            r0 = move-exception
        L_0x0647:
            r13 = r4
            goto L_0x064d
        L_0x0649:
            r0 = move-exception
            r13 = r4
            r10 = r14
            r9 = r15
        L_0x064d:
            r4 = r13
        L_0x064e:
            int r1 = r7.zzl
            r8 = r1
        L_0x0651:
            int r1 = r7.zzm
            if (r8 >= r1) goto L_0x0667
            int[] r1 = r7.zzk
            r3 = r1[r8]
            r1 = r17
            r2 = r18
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zzD(r2, r3, r4, r5, r6)
            int r8 = r8 + 1
            goto L_0x0651
        L_0x0667:
            if (r4 == 0) goto L_0x066c
            r10.zzn(r9, r4)
        L_0x066c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzahs.zzh(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzaia, com.google.android.gms.internal.firebase-auth-api.zzafx):void");
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
    public final void zzi(java.lang.Object r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.p001firebaseauthapi.zzaes r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            boolean r0 = r15.zzj
            if (r0 == 0) goto L_0x0394
            zzI(r31)
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
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzk(r0, r12, r3, r11)
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
            int r0 = r15.zzv(r5, r2)
            goto L_0x0045
        L_0x0041:
            int r0 = r15.zzu(r5)
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
            int r13 = zzy(r1)
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
            int r13 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzm(r12, r4, r11)
            long r0 = r11.zzb
            long r4 = com.google.android.gms.internal.p001firebaseauthapi.zzafl.zzG(r0)
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
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzafl.zzF(r1)
            r7.putInt(r14, r8, r1)
            goto L_0x0116
        L_0x00f0:
            r23 = r33
            r15 = r20
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x0149
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r12, r4, r11)
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
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zza(r12, r4, r11)
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
            java.lang.Object r8 = r13.zzF(r14, r15)
            com.google.android.gms.internal.firebase-auth-api.zzaib r1 = r13.zzC(r15)
            r0 = r8
            r2 = r32
            r3 = r4
            r4 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzo(r0, r1, r2, r3, r4, r5)
            r13.zzO(r14, r15, r8)
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
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzg(r12, r4, r11)
            goto L_0x016e
        L_0x016a:
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzh(r12, r4, r11)
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
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzm(r12, r4, r11)
            long r1 = r11.zzb
            r3 = 0
            int r17 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r17 == 0) goto L_0x0190
            goto L_0x0191
        L_0x0190:
            r5 = 0
        L_0x0191:
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzm(r14, r8, r5)
            goto L_0x023d
        L_0x0196:
            r13 = r30
            r23 = r33
            r15 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x024d
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzb(r12, r4)
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
            long r21 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzp(r12, r4)
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
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzj(r12, r4, r11)
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
            int r17 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzm(r12, r4, r11)
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
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzb(r12, r4)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzp(r14, r8, r0)
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
            long r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzp(r12, r4)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.p001firebaseauthapi.zzajf.zzo(r14, r8, r0)
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
            com.google.android.gms.internal.firebase-auth-api.zzagp r0 = (com.google.android.gms.internal.p001firebaseauthapi.zzagp) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0285
            int r1 = r0.size()
            if (r1 != 0) goto L_0x027d
            r1 = 10
            goto L_0x027e
        L_0x027d:
            int r1 = r1 + r1
        L_0x027e:
            com.google.android.gms.internal.firebase-auth-api.zzagp r0 = r0.zzd(r1)
            r7.putObject(r14, r8, r0)
        L_0x0285:
            r5 = r0
            com.google.android.gms.internal.firebase-auth-api.zzaib r0 = r10.zzC(r15)
            r1 = r17
            r2 = r32
            r3 = r4
            r4 = r34
            r8 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zze(r0, r1, r2, r3, r4, r5, r6)
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
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
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
            int r0 = r0.zzr(r1, r2, r3, r4, r5, r6, r8)
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
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r14) goto L_0x0300
            goto L_0x02ef
        L_0x0352:
            com.google.android.gms.internal.firebase-auth-api.zzaiw r4 = zzd(r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaet.zzi(r0, r1, r2, r3, r4, r5)
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
            com.google.android.gms.internal.firebase-auth-api.zzags r0 = com.google.android.gms.internal.p001firebaseauthapi.zzags.zzg()
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzahs.zzi(java.lang.Object, byte[], int, int, com.google.android.gms.internal.firebase-auth-api.zzaes):void");
    }

    public final boolean zzj(Object obj, Object obj2) {
        boolean z;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzz = zzz(i);
            long j = (long) (zzz & 1048575);
            switch (zzy(zzz)) {
                case 0:
                    if (zzQ(obj, obj2, i) && Double.doubleToLongBits(zzajf.zza(obj, j)) == Double.doubleToLongBits(zzajf.zza(obj2, j))) {
                        continue;
                    }
                case 1:
                    if (zzQ(obj, obj2, i) && Float.floatToIntBits(zzajf.zzb(obj, j)) == Float.floatToIntBits(zzajf.zzb(obj2, j))) {
                        continue;
                    }
                case 2:
                    if (zzQ(obj, obj2, i) && zzajf.zzd(obj, j) == zzajf.zzd(obj2, j)) {
                        continue;
                    }
                case 3:
                    if (zzQ(obj, obj2, i) && zzajf.zzd(obj, j) == zzajf.zzd(obj2, j)) {
                        continue;
                    }
                case 4:
                    if (zzQ(obj, obj2, i) && zzajf.zzc(obj, j) == zzajf.zzc(obj2, j)) {
                        continue;
                    }
                case 5:
                    if (zzQ(obj, obj2, i) && zzajf.zzd(obj, j) == zzajf.zzd(obj2, j)) {
                        continue;
                    }
                case 6:
                    if (zzQ(obj, obj2, i) && zzajf.zzc(obj, j) == zzajf.zzc(obj2, j)) {
                        continue;
                    }
                case 7:
                    if (zzQ(obj, obj2, i) && zzajf.zzw(obj, j) == zzajf.zzw(obj2, j)) {
                        continue;
                    }
                case 8:
                    if (zzQ(obj, obj2, i) && zzaid.zzE(zzajf.zzf(obj, j), zzajf.zzf(obj2, j))) {
                        continue;
                    }
                case 9:
                    if (zzQ(obj, obj2, i) && zzaid.zzE(zzajf.zzf(obj, j), zzajf.zzf(obj2, j))) {
                        continue;
                    }
                case 10:
                    if (zzQ(obj, obj2, i) && zzaid.zzE(zzajf.zzf(obj, j), zzajf.zzf(obj2, j))) {
                        continue;
                    }
                case 11:
                    if (zzQ(obj, obj2, i) && zzajf.zzc(obj, j) == zzajf.zzc(obj2, j)) {
                        continue;
                    }
                case 12:
                    if (zzQ(obj, obj2, i) && zzajf.zzc(obj, j) == zzajf.zzc(obj2, j)) {
                        continue;
                    }
                case 13:
                    if (zzQ(obj, obj2, i) && zzajf.zzc(obj, j) == zzajf.zzc(obj2, j)) {
                        continue;
                    }
                case 14:
                    if (zzQ(obj, obj2, i) && zzajf.zzd(obj, j) == zzajf.zzd(obj2, j)) {
                        continue;
                    }
                case 15:
                    if (zzQ(obj, obj2, i) && zzajf.zzc(obj, j) == zzajf.zzc(obj2, j)) {
                        continue;
                    }
                case 16:
                    if (zzQ(obj, obj2, i) && zzajf.zzd(obj, j) == zzajf.zzd(obj2, j)) {
                        continue;
                    }
                case 17:
                    if (zzQ(obj, obj2, i) && zzaid.zzE(zzajf.zzf(obj, j), zzajf.zzf(obj2, j))) {
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
                    z = zzaid.zzE(zzajf.zzf(obj, j), zzajf.zzf(obj2, j));
                    break;
                case 50:
                    z = zzaid.zzE(zzajf.zzf(obj, j), zzajf.zzf(obj2, j));
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
                    long zzw = (long) (zzw(i) & 1048575);
                    if (zzajf.zzc(obj, zzw) == zzajf.zzc(obj2, zzw) && zzaid.zzE(zzajf.zzf(obj, j), zzajf.zzf(obj2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzo.zzd(obj).equals(this.zzo.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzp.zza(obj);
        this.zzp.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        int i;
        int i2;
        Object obj2 = obj;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzl) {
            int i6 = this.zzk[i5];
            int i7 = this.zzc[i6];
            int zzz = zzz(i6);
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
            if ((268435456 & zzz) != 0 && !zzT(obj, i6, i2, i, i10)) {
                return false;
            }
            int zzy = zzy(zzz);
            if (zzy != 9 && zzy != 17) {
                if (zzy != 27) {
                    if (zzy == 60 || zzy == 68) {
                        if (zzW(obj2, i7, i6) && !zzU(obj2, zzz, zzC(i6))) {
                            return false;
                        }
                    } else if (zzy != 49) {
                        if (zzy == 50 && !((zzahj) zzajf.zzf(obj2, (long) (zzz & 1048575))).isEmpty()) {
                            zzahi zzahi = (zzahi) zzE(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzajf.zzf(obj2, (long) (zzz & 1048575));
                if (!list.isEmpty()) {
                    zzaib zzC = zzC(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzC.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzT(obj, i6, i2, i, i10) && !zzU(obj2, zzz, zzC(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzp.zza(obj2);
        throw null;
    }

    public final void zzm(Object obj, zzaft zzaft) throws IOException {
        int i;
        Object obj2 = obj;
        zzaft zzaft2 = zzaft;
        int i2 = 1048575;
        if (this.zzj) {
            if (!this.zzh) {
                int length = this.zzc.length;
                for (int i3 = 0; i3 < length; i3 += 3) {
                    int zzz = zzz(i3);
                    int i4 = this.zzc[i3];
                    switch (zzy(zzz)) {
                        case 0:
                            if (!zzS(obj2, i3)) {
                                break;
                            } else {
                                zzaft2.zzf(i4, zzajf.zza(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 1:
                            if (!zzS(obj2, i3)) {
                                break;
                            } else {
                                zzaft2.zzo(i4, zzajf.zzb(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 2:
                            if (!zzS(obj2, i3)) {
                                break;
                            } else {
                                zzaft2.zzt(i4, zzajf.zzd(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 3:
                            if (!zzS(obj2, i3)) {
                                break;
                            } else {
                                zzaft2.zzJ(i4, zzajf.zzd(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 4:
                            if (!zzS(obj2, i3)) {
                                break;
                            } else {
                                zzaft2.zzr(i4, zzajf.zzc(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 5:
                            if (!zzS(obj2, i3)) {
                                break;
                            } else {
                                zzaft2.zzm(i4, zzajf.zzd(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 6:
                            if (!zzS(obj2, i3)) {
                                break;
                            } else {
                                zzaft2.zzk(i4, zzajf.zzc(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 7:
                            if (!zzS(obj2, i3)) {
                                break;
                            } else {
                                zzaft2.zzb(i4, zzajf.zzw(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 8:
                            if (!zzS(obj2, i3)) {
                                break;
                            } else {
                                zzZ(i4, zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2);
                                break;
                            }
                        case 9:
                            if (!zzS(obj2, i3)) {
                                break;
                            } else {
                                zzaft2.zzv(i4, zzajf.zzf(obj2, (long) (zzz & 1048575)), zzC(i3));
                                break;
                            }
                        case 10:
                            if (!zzS(obj2, i3)) {
                                break;
                            } else {
                                zzaft2.zzd(i4, (zzaff) zzajf.zzf(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 11:
                            if (!zzS(obj2, i3)) {
                                break;
                            } else {
                                zzaft2.zzH(i4, zzajf.zzc(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 12:
                            if (!zzS(obj2, i3)) {
                                break;
                            } else {
                                zzaft2.zzi(i4, zzajf.zzc(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 13:
                            if (!zzS(obj2, i3)) {
                                break;
                            } else {
                                zzaft2.zzw(i4, zzajf.zzc(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 14:
                            if (!zzS(obj2, i3)) {
                                break;
                            } else {
                                zzaft2.zzy(i4, zzajf.zzd(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 15:
                            if (!zzS(obj2, i3)) {
                                break;
                            } else {
                                zzaft2.zzA(i4, zzajf.zzc(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 16:
                            if (!zzS(obj2, i3)) {
                                break;
                            } else {
                                zzaft2.zzC(i4, zzajf.zzd(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 17:
                            if (!zzS(obj2, i3)) {
                                break;
                            } else {
                                zzaft2.zzq(i4, zzajf.zzf(obj2, (long) (zzz & 1048575)), zzC(i3));
                                break;
                            }
                        case 18:
                            zzaid.zzH(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, false);
                            break;
                        case 19:
                            zzaid.zzL(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, false);
                            break;
                        case 20:
                            zzaid.zzO(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, false);
                            break;
                        case 21:
                            zzaid.zzW(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, false);
                            break;
                        case 22:
                            zzaid.zzN(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, false);
                            break;
                        case 23:
                            zzaid.zzK(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, false);
                            break;
                        case 24:
                            zzaid.zzJ(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, false);
                            break;
                        case 25:
                            zzaid.zzF(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, false);
                            break;
                        case 26:
                            zzaid.zzU(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2);
                            break;
                        case 27:
                            zzaid.zzP(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, zzC(i3));
                            break;
                        case 28:
                            zzaid.zzG(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2);
                            break;
                        case 29:
                            zzaid.zzV(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, false);
                            break;
                        case 30:
                            zzaid.zzI(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, false);
                            break;
                        case 31:
                            zzaid.zzQ(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, false);
                            break;
                        case 32:
                            zzaid.zzR(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, false);
                            break;
                        case 33:
                            zzaid.zzS(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, false);
                            break;
                        case 34:
                            zzaid.zzT(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, false);
                            break;
                        case 35:
                            zzaid.zzH(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, true);
                            break;
                        case 36:
                            zzaid.zzL(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, true);
                            break;
                        case 37:
                            zzaid.zzO(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, true);
                            break;
                        case 38:
                            zzaid.zzW(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, true);
                            break;
                        case 39:
                            zzaid.zzN(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, true);
                            break;
                        case 40:
                            zzaid.zzK(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, true);
                            break;
                        case 41:
                            zzaid.zzJ(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, true);
                            break;
                        case 42:
                            zzaid.zzF(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, true);
                            break;
                        case 43:
                            zzaid.zzV(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, true);
                            break;
                        case 44:
                            zzaid.zzI(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, true);
                            break;
                        case 45:
                            zzaid.zzQ(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, true);
                            break;
                        case 46:
                            zzaid.zzR(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, true);
                            break;
                        case 47:
                            zzaid.zzS(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, true);
                            break;
                        case 48:
                            zzaid.zzT(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, true);
                            break;
                        case 49:
                            zzaid.zzM(i4, (List) zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2, zzC(i3));
                            break;
                        case 50:
                            zzY(zzaft2, i4, zzajf.zzf(obj2, (long) (zzz & 1048575)), i3);
                            break;
                        case 51:
                            if (!zzW(obj2, i4, i3)) {
                                break;
                            } else {
                                zzaft2.zzf(i4, zzn(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 52:
                            if (!zzW(obj2, i4, i3)) {
                                break;
                            } else {
                                zzaft2.zzo(i4, zzo(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 53:
                            if (!zzW(obj2, i4, i3)) {
                                break;
                            } else {
                                zzaft2.zzt(i4, zzA(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 54:
                            if (!zzW(obj2, i4, i3)) {
                                break;
                            } else {
                                zzaft2.zzJ(i4, zzA(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 55:
                            if (!zzW(obj2, i4, i3)) {
                                break;
                            } else {
                                zzaft2.zzr(i4, zzq(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 56:
                            if (!zzW(obj2, i4, i3)) {
                                break;
                            } else {
                                zzaft2.zzm(i4, zzA(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 57:
                            if (!zzW(obj2, i4, i3)) {
                                break;
                            } else {
                                zzaft2.zzk(i4, zzq(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 58:
                            if (!zzW(obj2, i4, i3)) {
                                break;
                            } else {
                                zzaft2.zzb(i4, zzX(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 59:
                            if (!zzW(obj2, i4, i3)) {
                                break;
                            } else {
                                zzZ(i4, zzajf.zzf(obj2, (long) (zzz & 1048575)), zzaft2);
                                break;
                            }
                        case 60:
                            if (!zzW(obj2, i4, i3)) {
                                break;
                            } else {
                                zzaft2.zzv(i4, zzajf.zzf(obj2, (long) (zzz & 1048575)), zzC(i3));
                                break;
                            }
                        case 61:
                            if (!zzW(obj2, i4, i3)) {
                                break;
                            } else {
                                zzaft2.zzd(i4, (zzaff) zzajf.zzf(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 62:
                            if (!zzW(obj2, i4, i3)) {
                                break;
                            } else {
                                zzaft2.zzH(i4, zzq(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 63:
                            if (!zzW(obj2, i4, i3)) {
                                break;
                            } else {
                                zzaft2.zzi(i4, zzq(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 64:
                            if (!zzW(obj2, i4, i3)) {
                                break;
                            } else {
                                zzaft2.zzw(i4, zzq(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 65:
                            if (!zzW(obj2, i4, i3)) {
                                break;
                            } else {
                                zzaft2.zzy(i4, zzA(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 66:
                            if (!zzW(obj2, i4, i3)) {
                                break;
                            } else {
                                zzaft2.zzA(i4, zzq(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 67:
                            if (!zzW(obj2, i4, i3)) {
                                break;
                            } else {
                                zzaft2.zzC(i4, zzA(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 68:
                            if (!zzW(obj2, i4, i3)) {
                                break;
                            } else {
                                zzaft2.zzq(i4, zzajf.zzf(obj2, (long) (zzz & 1048575)), zzC(i3));
                                break;
                            }
                    }
                }
                zzaiv zzaiv = this.zzo;
                zzaiv.zzr(zzaiv.zzd(obj2), zzaft2);
                return;
            }
            this.zzp.zza(obj2);
            throw null;
        } else if (!this.zzh) {
            int length2 = this.zzc.length;
            Unsafe unsafe = zzb;
            int i5 = 0;
            int i6 = 1048575;
            int i7 = 0;
            while (i5 < length2) {
                int zzz2 = zzz(i5);
                int[] iArr = this.zzc;
                int i8 = iArr[i5];
                int zzy = zzy(zzz2);
                if (zzy <= 17) {
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
                long j = (long) (zzz2 & i2);
                switch (zzy) {
                    case 0:
                        if ((i7 & i) == 0) {
                            break;
                        } else {
                            zzaft2.zzf(i8, zzajf.zza(obj2, j));
                            continue;
                        }
                    case 1:
                        if ((i7 & i) != 0) {
                            zzaft2.zzo(i8, zzajf.zzb(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 2:
                        if ((i7 & i) != 0) {
                            zzaft2.zzt(i8, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 3:
                        if ((i7 & i) != 0) {
                            zzaft2.zzJ(i8, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 4:
                        if ((i7 & i) != 0) {
                            zzaft2.zzr(i8, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 5:
                        if ((i7 & i) != 0) {
                            zzaft2.zzm(i8, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 6:
                        if ((i7 & i) != 0) {
                            zzaft2.zzk(i8, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 7:
                        if ((i7 & i) != 0) {
                            zzaft2.zzb(i8, zzajf.zzw(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 8:
                        if ((i7 & i) != 0) {
                            zzZ(i8, unsafe.getObject(obj2, j), zzaft2);
                            break;
                        } else {
                            continue;
                        }
                    case 9:
                        if ((i7 & i) != 0) {
                            zzaft2.zzv(i8, unsafe.getObject(obj2, j), zzC(i5));
                            break;
                        } else {
                            continue;
                        }
                    case 10:
                        if ((i7 & i) != 0) {
                            zzaft2.zzd(i8, (zzaff) unsafe.getObject(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 11:
                        if ((i7 & i) != 0) {
                            zzaft2.zzH(i8, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 12:
                        if ((i7 & i) != 0) {
                            zzaft2.zzi(i8, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 13:
                        if ((i7 & i) != 0) {
                            zzaft2.zzw(i8, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 14:
                        if ((i7 & i) != 0) {
                            zzaft2.zzy(i8, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 15:
                        if ((i7 & i) != 0) {
                            zzaft2.zzA(i8, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 16:
                        if ((i7 & i) != 0) {
                            zzaft2.zzC(i8, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 17:
                        if ((i7 & i) != 0) {
                            zzaft2.zzq(i8, unsafe.getObject(obj2, j), zzC(i5));
                            break;
                        } else {
                            continue;
                        }
                    case 18:
                        zzaid.zzH(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, false);
                        continue;
                    case 19:
                        zzaid.zzL(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, false);
                        continue;
                    case 20:
                        zzaid.zzO(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, false);
                        continue;
                    case 21:
                        zzaid.zzW(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, false);
                        continue;
                    case 22:
                        zzaid.zzN(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, false);
                        continue;
                    case 23:
                        zzaid.zzK(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, false);
                        continue;
                    case 24:
                        zzaid.zzJ(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, false);
                        continue;
                    case 25:
                        zzaid.zzF(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, false);
                        continue;
                    case 26:
                        zzaid.zzU(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2);
                        break;
                    case 27:
                        zzaid.zzP(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, zzC(i5));
                        break;
                    case 28:
                        zzaid.zzG(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2);
                        break;
                    case 29:
                        zzaid.zzV(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, false);
                        break;
                    case 30:
                        zzaid.zzI(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, false);
                        break;
                    case 31:
                        zzaid.zzQ(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, false);
                        break;
                    case 32:
                        zzaid.zzR(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, false);
                        break;
                    case 33:
                        zzaid.zzS(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, false);
                        break;
                    case 34:
                        zzaid.zzT(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, false);
                        break;
                    case 35:
                        zzaid.zzH(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, true);
                        break;
                    case 36:
                        zzaid.zzL(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, true);
                        break;
                    case 37:
                        zzaid.zzO(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, true);
                        break;
                    case 38:
                        zzaid.zzW(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, true);
                        break;
                    case 39:
                        zzaid.zzN(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, true);
                        break;
                    case 40:
                        zzaid.zzK(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, true);
                        break;
                    case 41:
                        zzaid.zzJ(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, true);
                        break;
                    case 42:
                        zzaid.zzF(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, true);
                        break;
                    case 43:
                        zzaid.zzV(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, true);
                        break;
                    case 44:
                        zzaid.zzI(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, true);
                        break;
                    case 45:
                        zzaid.zzQ(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, true);
                        break;
                    case 46:
                        zzaid.zzR(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, true);
                        break;
                    case 47:
                        zzaid.zzS(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, true);
                        break;
                    case 48:
                        zzaid.zzT(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, true);
                        break;
                    case 49:
                        zzaid.zzM(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzaft2, zzC(i5));
                        break;
                    case 50:
                        zzY(zzaft2, i8, unsafe.getObject(obj2, j), i5);
                        break;
                    case 51:
                        if (zzW(obj2, i8, i5)) {
                            zzaft2.zzf(i8, zzn(obj2, j));
                            break;
                        }
                        break;
                    case 52:
                        if (zzW(obj2, i8, i5)) {
                            zzaft2.zzo(i8, zzo(obj2, j));
                            break;
                        }
                        break;
                    case 53:
                        if (zzW(obj2, i8, i5)) {
                            zzaft2.zzt(i8, zzA(obj2, j));
                            break;
                        }
                        break;
                    case 54:
                        if (zzW(obj2, i8, i5)) {
                            zzaft2.zzJ(i8, zzA(obj2, j));
                            break;
                        }
                        break;
                    case 55:
                        if (zzW(obj2, i8, i5)) {
                            zzaft2.zzr(i8, zzq(obj2, j));
                            break;
                        }
                        break;
                    case 56:
                        if (zzW(obj2, i8, i5)) {
                            zzaft2.zzm(i8, zzA(obj2, j));
                            break;
                        }
                        break;
                    case 57:
                        if (zzW(obj2, i8, i5)) {
                            zzaft2.zzk(i8, zzq(obj2, j));
                            break;
                        }
                        break;
                    case 58:
                        if (zzW(obj2, i8, i5)) {
                            zzaft2.zzb(i8, zzX(obj2, j));
                            break;
                        }
                        break;
                    case 59:
                        if (zzW(obj2, i8, i5)) {
                            zzZ(i8, unsafe.getObject(obj2, j), zzaft2);
                            break;
                        }
                        break;
                    case 60:
                        if (zzW(obj2, i8, i5)) {
                            zzaft2.zzv(i8, unsafe.getObject(obj2, j), zzC(i5));
                            break;
                        }
                        break;
                    case 61:
                        if (zzW(obj2, i8, i5)) {
                            zzaft2.zzd(i8, (zzaff) unsafe.getObject(obj2, j));
                            break;
                        }
                        break;
                    case 62:
                        if (zzW(obj2, i8, i5)) {
                            zzaft2.zzH(i8, zzq(obj2, j));
                            break;
                        }
                        break;
                    case 63:
                        if (zzW(obj2, i8, i5)) {
                            zzaft2.zzi(i8, zzq(obj2, j));
                            break;
                        }
                        break;
                    case 64:
                        if (zzW(obj2, i8, i5)) {
                            zzaft2.zzw(i8, zzq(obj2, j));
                            break;
                        }
                        break;
                    case 65:
                        if (zzW(obj2, i8, i5)) {
                            zzaft2.zzy(i8, zzA(obj2, j));
                            break;
                        }
                        break;
                    case 66:
                        if (zzW(obj2, i8, i5)) {
                            zzaft2.zzA(i8, zzq(obj2, j));
                            break;
                        }
                        break;
                    case 67:
                        if (zzW(obj2, i8, i5)) {
                            zzaft2.zzC(i8, zzA(obj2, j));
                            break;
                        }
                        break;
                    case 68:
                        if (zzW(obj2, i8, i5)) {
                            zzaft2.zzq(i8, unsafe.getObject(obj2, j), zzC(i5));
                            break;
                        }
                        break;
                }
                i5 += 3;
                i2 = 1048575;
            }
            zzaiv zzaiv2 = this.zzo;
            zzaiv2.zzr(zzaiv2.zzd(obj2), zzaft2);
        } else {
            this.zzp.zza(obj2);
            throw null;
        }
    }
}
