package org.apache.commons.codec.digest;

import kotlin.UByte;

public final class MurmurHash3 {
    private static final long C1 = -8663945395140668459L;
    private static final int C1_32 = -862048943;
    private static final long C2 = 5545529020109919103L;
    private static final int C2_32 = 461845907;
    public static final int DEFAULT_SEED = 104729;
    static final int INTEGER_BYTES = 4;
    static final int LONG_BYTES = 8;
    private static final int M = 5;
    private static final int M_32 = 5;
    private static final int N1 = 1390208809;
    private static final int N2 = 944331445;
    public static final long NULL_HASHCODE = 2862933555777941757L;
    private static final int N_32 = -430675100;
    private static final int R1 = 31;
    private static final int R1_32 = 15;
    private static final int R2 = 27;
    private static final int R2_32 = 13;
    private static final int R3 = 33;
    static final int SHORT_BYTES = 2;

    private static int fmix32(int i, int i2) {
        int i3 = i ^ i2;
        int i4 = (i3 ^ (i3 >>> 16)) * -2048144789;
        int i5 = (i4 ^ (i4 >>> 13)) * -1028477387;
        return i5 ^ (i5 >>> 16);
    }

    private static long fmix64(long j) {
        long j2 = (j ^ (j >>> 33)) * -49064778989728563L;
        long j3 = (j2 ^ (j2 >>> 33)) * -4265267296055464877L;
        return j3 ^ (j3 >>> 33);
    }

    /* access modifiers changed from: private */
    public static int orBytes(byte b, byte b2, byte b3, byte b4) {
        return (b & UByte.MAX_VALUE) | ((b2 & UByte.MAX_VALUE) << 8) | ((b3 & UByte.MAX_VALUE) << 16) | ((b4 & UByte.MAX_VALUE) << 24);
    }

    private MurmurHash3() {
    }

    public static int hash32(long j, long j2) {
        return hash32(j, j2, (int) DEFAULT_SEED);
    }

    public static int hash32(long j) {
        return hash32(j, (int) DEFAULT_SEED);
    }

    public static int hash32(long j, int i) {
        long reverseBytes = Long.reverseBytes(j);
        return fmix32(8, mix32((int) (reverseBytes >>> 32), mix32((int) reverseBytes, i)));
    }

    public static int hash32(long j, long j2, int i) {
        long reverseBytes = Long.reverseBytes(j);
        long reverseBytes2 = Long.reverseBytes(j2);
        return fmix32(16, mix32((int) (reverseBytes2 >>> 32), mix32((int) reverseBytes2, mix32((int) (reverseBytes >>> 32), mix32((int) reverseBytes, i)))));
    }

    public static int hash32(byte[] bArr) {
        return hash32(bArr, 0, bArr.length, DEFAULT_SEED);
    }

    public static int hash32(String str) {
        byte[] bytes = str.getBytes();
        return hash32(bytes, 0, bytes.length, DEFAULT_SEED);
    }

    public static int hash32(byte[] bArr, int i) {
        return hash32(bArr, i, (int) DEFAULT_SEED);
    }

    public static int hash32(byte[] bArr, int i, int i2) {
        return hash32(bArr, 0, i, i2);
    }

    public static int hash32(byte[] bArr, int i, int i2, int i3) {
        int i4 = i2 >> 2;
        byte b = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 << 2) + i;
            i3 = mix32(((bArr[i6 + 3] & UByte.MAX_VALUE) << 24) | (bArr[i6] & UByte.MAX_VALUE) | ((bArr[i6 + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i6 + 2] & UByte.MAX_VALUE) << 16), i3);
        }
        int i7 = i4 << 2;
        int i8 = i2 - i7;
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    b = 0 ^ (bArr[(i + i7) + 2] << 16);
                }
                return fmix32(i2, i3);
            }
            b ^= bArr[(i + i7) + 1] << 8;
        }
        i3 ^= Integer.rotateLeft((bArr[i + i7] ^ b) * C1_32, 15) * C2_32;
        return fmix32(i2, i3);
    }

    public static long hash64(byte[] bArr) {
        return hash64(bArr, 0, bArr.length, DEFAULT_SEED);
    }

    public static long hash64(long j) {
        return fmix64(((Long.rotateLeft((Long.rotateLeft(Long.reverseBytes(j) * C1, 31) * C2) ^ 104729, 27) * 5) + 1390208809) ^ 8);
    }

    public static long hash64(int i) {
        return fmix64(((Long.rotateLeft((((long) Integer.reverseBytes(i)) & 4294967295L) * C1, 31) * C2) ^ 104729) ^ 4);
    }

    public static long hash64(short s) {
        return fmix64(((Long.rotateLeft(((((((long) s) & 255) << 8) ^ 0) ^ (255 & ((long) ((s & 65280) >> 8)))) * C1, 31) * C2) ^ 104729) ^ 2);
    }

    public static long hash64(byte[] bArr, int i, int i2) {
        return hash64(bArr, i, i2, DEFAULT_SEED);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x00be, code lost:
        r4 = r4 ^ ((((long) r20[(r21 + r3) + 2]) & 255) << 16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x00c9, code lost:
        r4 = r4 ^ ((((long) r20[(r21 + r3) + 1]) & 255) << 8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00d4, code lost:
        r1 = r1 ^ (java.lang.Long.rotateLeft((r4 ^ (((long) r20[r21 + r3]) & 255)) * C1, 31) * C2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00f9, code lost:
        return fmix64(r1 ^ ((long) r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x009d, code lost:
        r4 = r4 ^ ((((long) r20[(r21 + r3) + 5]) & 255) << 40);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x00a8, code lost:
        r4 = r4 ^ ((((long) r20[(r21 + r3) + 4]) & 255) << 32);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x00b3, code lost:
        r4 = r4 ^ ((((long) r20[(r21 + r3) + 3]) & 255) << 24);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long hash64(byte[] r20, int r21, int r22, int r23) {
        /*
            r0 = r22
            r1 = r23
            long r1 = (long) r1
            int r3 = r0 >> 3
            r4 = 0
        L_0x0008:
            r10 = 48
            r11 = 40
            r12 = 32
            r13 = 24
            r14 = 16
            r15 = 8
            r16 = 255(0xff, double:1.26E-321)
            if (r4 >= r3) goto L_0x0088
            int r18 = r4 << 3
            int r18 = r21 + r18
            byte r5 = r20[r18]
            long r5 = (long) r5
            long r5 = r5 & r16
            int r19 = r18 + 1
            byte r7 = r20[r19]
            long r8 = (long) r7
            long r7 = r8 & r16
            long r7 = r7 << r15
            long r5 = r5 | r7
            int r7 = r18 + 2
            byte r7 = r20[r7]
            long r7 = (long) r7
            long r7 = r7 & r16
            long r7 = r7 << r14
            long r5 = r5 | r7
            int r7 = r18 + 3
            byte r7 = r20[r7]
            long r7 = (long) r7
            long r7 = r7 & r16
            long r7 = r7 << r13
            long r5 = r5 | r7
            int r7 = r18 + 4
            byte r7 = r20[r7]
            long r7 = (long) r7
            long r7 = r7 & r16
            long r7 = r7 << r12
            long r5 = r5 | r7
            int r7 = r18 + 5
            byte r7 = r20[r7]
            long r7 = (long) r7
            long r7 = r7 & r16
            long r7 = r7 << r11
            long r5 = r5 | r7
            int r7 = r18 + 6
            byte r7 = r20[r7]
            long r7 = (long) r7
            long r7 = r7 & r16
            long r7 = r7 << r10
            long r5 = r5 | r7
            int r18 = r18 + 7
            byte r7 = r20[r18]
            long r7 = (long) r7
            long r7 = r7 & r16
            r9 = 56
            long r7 = r7 << r9
            long r5 = r5 | r7
            r7 = -8663945395140668459(0x87c37b91114253d5, double:-2.8811287363897357E-271)
            long r5 = r5 * r7
            r7 = 31
            long r5 = java.lang.Long.rotateLeft(r5, r7)
            r7 = 5545529020109919103(0x4cf5ad432745937f, double:5.573325460219186E62)
            long r5 = r5 * r7
            long r1 = r1 ^ r5
            r5 = 27
            long r1 = java.lang.Long.rotateLeft(r1, r5)
            r5 = 5
            long r1 = r1 * r5
            r5 = 1390208809(0x52dce729, double:6.86854413E-315)
            long r1 = r1 + r5
            int r4 = r4 + 1
            goto L_0x0008
        L_0x0088:
            r4 = 0
            int r3 = r3 << 3
            int r6 = r0 - r3
            switch(r6) {
                case 1: goto L_0x00d4;
                case 2: goto L_0x00c9;
                case 3: goto L_0x00be;
                case 4: goto L_0x00b3;
                case 5: goto L_0x00a8;
                case 6: goto L_0x009d;
                case 7: goto L_0x0092;
                default: goto L_0x0091;
            }
        L_0x0091:
            goto L_0x00f2
        L_0x0092:
            int r6 = r21 + r3
            int r6 = r6 + 6
            byte r6 = r20[r6]
            long r6 = (long) r6
            long r6 = r6 & r16
            long r6 = r6 << r10
            long r4 = r4 ^ r6
        L_0x009d:
            int r6 = r21 + r3
            int r6 = r6 + 5
            byte r6 = r20[r6]
            long r6 = (long) r6
            long r6 = r6 & r16
            long r6 = r6 << r11
            long r4 = r4 ^ r6
        L_0x00a8:
            int r6 = r21 + r3
            int r6 = r6 + 4
            byte r6 = r20[r6]
            long r6 = (long) r6
            long r6 = r6 & r16
            long r6 = r6 << r12
            long r4 = r4 ^ r6
        L_0x00b3:
            int r6 = r21 + r3
            int r6 = r6 + 3
            byte r6 = r20[r6]
            long r6 = (long) r6
            long r6 = r6 & r16
            long r6 = r6 << r13
            long r4 = r4 ^ r6
        L_0x00be:
            int r6 = r21 + r3
            int r6 = r6 + 2
            byte r6 = r20[r6]
            long r6 = (long) r6
            long r6 = r6 & r16
            long r6 = r6 << r14
            long r4 = r4 ^ r6
        L_0x00c9:
            int r6 = r21 + r3
            int r6 = r6 + 1
            byte r6 = r20[r6]
            long r6 = (long) r6
            long r6 = r6 & r16
            long r6 = r6 << r15
            long r4 = r4 ^ r6
        L_0x00d4:
            int r3 = r21 + r3
            byte r3 = r20[r3]
            long r6 = (long) r3
            long r6 = r6 & r16
            long r3 = r4 ^ r6
            r5 = -8663945395140668459(0x87c37b91114253d5, double:-2.8811287363897357E-271)
            long r3 = r3 * r5
            r5 = 31
            long r3 = java.lang.Long.rotateLeft(r3, r5)
            r5 = 5545529020109919103(0x4cf5ad432745937f, double:5.573325460219186E62)
            long r3 = r3 * r5
            long r1 = r1 ^ r3
        L_0x00f2:
            long r3 = (long) r0
            long r0 = r1 ^ r3
            long r0 = fmix64(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.digest.MurmurHash3.hash64(byte[], int, int, int):long");
    }

    public static long[] hash128(byte[] bArr) {
        return hash128(bArr, 0, bArr.length, DEFAULT_SEED);
    }

    public static long[] hash128(String str) {
        byte[] bytes = str.getBytes();
        return hash128(bytes, 0, bytes.length, DEFAULT_SEED);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0121, code lost:
        r9 = r9 ^ (((long) (r23[(r24 + r3) + 12] & kotlin.UByte.MAX_VALUE)) << 32);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x012f, code lost:
        r9 = r9 ^ (((long) (r23[(r24 + r3) + 11] & kotlin.UByte.MAX_VALUE)) << 24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x013d, code lost:
        r9 = r9 ^ (((long) (r23[(r24 + r3) + 10] & kotlin.UByte.MAX_VALUE)) << 16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x014b, code lost:
        r9 = r9 ^ (((long) (r23[(r24 + r3) + 9] & kotlin.UByte.MAX_VALUE)) << 8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0159, code lost:
        r5 = r5 ^ (java.lang.Long.rotateLeft((r9 ^ ((long) (r23[(r24 + r3) + 8] & kotlin.UByte.MAX_VALUE))) * C2, 33) * C1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0185, code lost:
        r7 = r7 ^ (((long) (r23[(r24 + r3) + 6] & kotlin.UByte.MAX_VALUE)) << 48);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0190, code lost:
        r7 = r7 ^ (((long) (r23[(r24 + r3) + 5] & kotlin.UByte.MAX_VALUE)) << 40);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x019b, code lost:
        r7 = r7 ^ (((long) (r23[(r24 + r3) + 4] & kotlin.UByte.MAX_VALUE)) << 32);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x01a7, code lost:
        r7 = r7 ^ (((long) (r23[(r24 + r3) + 3] & kotlin.UByte.MAX_VALUE)) << 24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x01b3, code lost:
        r7 = r7 ^ (((long) (r23[(r24 + r3) + 2] & kotlin.UByte.MAX_VALUE)) << 16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x01bf, code lost:
        r7 = r7 ^ (((long) (r23[(r24 + r3) + 1] & kotlin.UByte.MAX_VALUE)) << 8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x01cb, code lost:
        r1 = r1 ^ (java.lang.Long.rotateLeft((((long) (r23[r24 + r3] & kotlin.UByte.MAX_VALUE)) ^ r7) * C1, 31) * C2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x01e8, code lost:
        r3 = (long) r0;
        r2 = r5 ^ r3;
        r0 = (r1 ^ r3) + r2;
        r2 = r2 + r0;
        r0 = fmix64(r0);
        r2 = fmix64(r2);
        r0 = r0 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0202, code lost:
        return new long[]{r0, r2 + r0};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0114, code lost:
        r9 = (((long) (r23[(r24 + r3) + 13] & kotlin.UByte.MAX_VALUE)) << 40) ^ r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long[] hash128(byte[] r23, int r24, int r25, int r26) {
        /*
            r0 = r25
            r1 = r26
            long r1 = (long) r1
            int r3 = r0 >> 4
            r5 = r1
            r7 = 0
        L_0x0009:
            r9 = 56
            r14 = 48
            r15 = 40
            r16 = 32
            r17 = 24
            r18 = 16
            r19 = 8
            if (r7 >= r3) goto L_0x00fc
            int r20 = r7 << 4
            int r20 = r24 + r20
            byte r4 = r23[r20]
            long r10 = (long) r4
            r21 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r21
            int r4 = r20 + 1
            byte r4 = r23[r4]
            long r12 = (long) r4
            long r12 = r12 & r21
            long r12 = r12 << r19
            long r10 = r10 | r12
            int r4 = r20 + 2
            byte r4 = r23[r4]
            long r12 = (long) r4
            long r12 = r12 & r21
            long r12 = r12 << r18
            long r10 = r10 | r12
            int r4 = r20 + 3
            byte r4 = r23[r4]
            long r12 = (long) r4
            long r12 = r12 & r21
            long r12 = r12 << r17
            long r10 = r10 | r12
            int r4 = r20 + 4
            byte r4 = r23[r4]
            long r12 = (long) r4
            long r12 = r12 & r21
            long r12 = r12 << r16
            long r10 = r10 | r12
            int r4 = r20 + 5
            byte r4 = r23[r4]
            long r12 = (long) r4
            long r12 = r12 & r21
            long r12 = r12 << r15
            long r10 = r10 | r12
            int r4 = r20 + 6
            byte r4 = r23[r4]
            long r12 = (long) r4
            long r12 = r12 & r21
            long r12 = r12 << r14
            long r10 = r10 | r12
            int r4 = r20 + 7
            byte r4 = r23[r4]
            long r12 = (long) r4
            long r12 = r12 & r21
            long r12 = r12 << r9
            long r10 = r10 | r12
            int r4 = r20 + 8
            byte r4 = r23[r4]
            long r12 = (long) r4
            long r12 = r12 & r21
            int r4 = r20 + 9
            byte r4 = r23[r4]
            long r8 = (long) r4
            long r8 = r8 & r21
            long r8 = r8 << r19
            long r8 = r8 | r12
            int r4 = r20 + 10
            byte r4 = r23[r4]
            long r12 = (long) r4
            long r12 = r12 & r21
            long r12 = r12 << r18
            long r8 = r8 | r12
            int r4 = r20 + 11
            byte r4 = r23[r4]
            long r12 = (long) r4
            long r12 = r12 & r21
            long r12 = r12 << r17
            long r8 = r8 | r12
            int r4 = r20 + 12
            byte r4 = r23[r4]
            long r12 = (long) r4
            long r12 = r12 & r21
            long r12 = r12 << r16
            long r8 = r8 | r12
            int r4 = r20 + 13
            byte r4 = r23[r4]
            long r12 = (long) r4
            long r12 = r12 & r21
            long r12 = r12 << r15
            long r8 = r8 | r12
            int r4 = r20 + 14
            byte r4 = r23[r4]
            long r12 = (long) r4
            long r12 = r12 & r21
            long r12 = r12 << r14
            long r8 = r8 | r12
            int r20 = r20 + 15
            byte r4 = r23[r20]
            long r12 = (long) r4
            long r12 = r12 & r21
            r4 = 56
            long r12 = r12 << r4
            long r8 = r8 | r12
            r12 = -8663945395140668459(0x87c37b91114253d5, double:-2.8811287363897357E-271)
            long r10 = r10 * r12
            r4 = 31
            long r10 = java.lang.Long.rotateLeft(r10, r4)
            r12 = 5545529020109919103(0x4cf5ad432745937f, double:5.573325460219186E62)
            long r10 = r10 * r12
            long r1 = r1 ^ r10
            r4 = 27
            long r1 = java.lang.Long.rotateLeft(r1, r4)
            long r1 = r1 + r5
            r10 = 5
            long r1 = r1 * r10
            r10 = 1390208809(0x52dce729, double:6.86854413E-315)
            long r1 = r1 + r10
            long r8 = r8 * r12
            r4 = 33
            long r8 = java.lang.Long.rotateLeft(r8, r4)
            r10 = -8663945395140668459(0x87c37b91114253d5, double:-2.8811287363897357E-271)
            long r8 = r8 * r10
            long r4 = r5 ^ r8
            r6 = 31
            long r4 = java.lang.Long.rotateLeft(r4, r6)
            long r4 = r4 + r1
            r8 = 5
            long r4 = r4 * r8
            r8 = 944331445(0x38495ab5, double:4.665617253E-315)
            long r5 = r4 + r8
            int r7 = r7 + 1
            goto L_0x0009
        L_0x00fc:
            int r3 = r3 << 4
            int r4 = r0 - r3
            r7 = 0
            switch(r4) {
                case 1: goto L_0x01cb;
                case 2: goto L_0x01bf;
                case 3: goto L_0x01b3;
                case 4: goto L_0x01a7;
                case 5: goto L_0x019b;
                case 6: goto L_0x0190;
                case 7: goto L_0x0185;
                case 8: goto L_0x0178;
                case 9: goto L_0x0158;
                case 10: goto L_0x014a;
                case 11: goto L_0x013c;
                case 12: goto L_0x012e;
                case 13: goto L_0x0120;
                case 14: goto L_0x0113;
                case 15: goto L_0x0107;
                default: goto L_0x0105;
            }
        L_0x0105:
            goto L_0x01e8
        L_0x0107:
            int r4 = r24 + r3
            int r4 = r4 + 14
            byte r4 = r23[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r11 = (long) r4
            long r11 = r11 << r14
            long r11 = r11 ^ r7
            goto L_0x0114
        L_0x0113:
            r11 = r7
        L_0x0114:
            int r4 = r24 + r3
            int r4 = r4 + 13
            byte r4 = r23[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r9 = (long) r4
            long r9 = r9 << r15
            long r9 = r9 ^ r11
            goto L_0x0121
        L_0x0120:
            r9 = r7
        L_0x0121:
            int r4 = r24 + r3
            int r4 = r4 + 12
            byte r4 = r23[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r11 = (long) r4
            long r11 = r11 << r16
            long r9 = r9 ^ r11
            goto L_0x012f
        L_0x012e:
            r9 = r7
        L_0x012f:
            int r4 = r24 + r3
            int r4 = r4 + 11
            byte r4 = r23[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r11 = (long) r4
            long r11 = r11 << r17
            long r9 = r9 ^ r11
            goto L_0x013d
        L_0x013c:
            r9 = r7
        L_0x013d:
            int r4 = r24 + r3
            int r4 = r4 + 10
            byte r4 = r23[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r11 = (long) r4
            long r11 = r11 << r18
            long r9 = r9 ^ r11
            goto L_0x014b
        L_0x014a:
            r9 = r7
        L_0x014b:
            int r4 = r24 + r3
            int r4 = r4 + 9
            byte r4 = r23[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r11 = (long) r4
            long r11 = r11 << r19
            long r9 = r9 ^ r11
            goto L_0x0159
        L_0x0158:
            r9 = r7
        L_0x0159:
            int r4 = r24 + r3
            int r4 = r4 + 8
            byte r4 = r23[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r11 = (long) r4
            long r9 = r9 ^ r11
            r11 = 5545529020109919103(0x4cf5ad432745937f, double:5.573325460219186E62)
            long r9 = r9 * r11
            r4 = 33
            long r9 = java.lang.Long.rotateLeft(r9, r4)
            r11 = -8663945395140668459(0x87c37b91114253d5, double:-2.8811287363897357E-271)
            long r9 = r9 * r11
            long r5 = r5 ^ r9
        L_0x0178:
            int r4 = r24 + r3
            int r4 = r4 + 7
            byte r4 = r23[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r9 = (long) r4
            r4 = 56
            long r9 = r9 << r4
            long r7 = r7 ^ r9
        L_0x0185:
            int r4 = r24 + r3
            int r4 = r4 + 6
            byte r4 = r23[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r9 = (long) r4
            long r9 = r9 << r14
            long r7 = r7 ^ r9
        L_0x0190:
            int r4 = r24 + r3
            int r4 = r4 + 5
            byte r4 = r23[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r9 = (long) r4
            long r9 = r9 << r15
            long r7 = r7 ^ r9
        L_0x019b:
            int r4 = r24 + r3
            int r4 = r4 + 4
            byte r4 = r23[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r9 = (long) r4
            long r9 = r9 << r16
            long r7 = r7 ^ r9
        L_0x01a7:
            int r4 = r24 + r3
            int r4 = r4 + 3
            byte r4 = r23[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r9 = (long) r4
            long r9 = r9 << r17
            long r7 = r7 ^ r9
        L_0x01b3:
            int r4 = r24 + r3
            r9 = 2
            int r4 = r4 + r9
            byte r4 = r23[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r9 = (long) r4
            long r9 = r9 << r18
            long r7 = r7 ^ r9
        L_0x01bf:
            int r4 = r24 + r3
            r9 = 1
            int r4 = r4 + r9
            byte r4 = r23[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r9 = (long) r4
            long r9 = r9 << r19
            long r7 = r7 ^ r9
        L_0x01cb:
            int r3 = r24 + r3
            byte r3 = r23[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            long r3 = (long) r3
            long r3 = r3 ^ r7
            r7 = -8663945395140668459(0x87c37b91114253d5, double:-2.8811287363897357E-271)
            long r3 = r3 * r7
            r7 = 31
            long r3 = java.lang.Long.rotateLeft(r3, r7)
            r7 = 5545529020109919103(0x4cf5ad432745937f, double:5.573325460219186E62)
            long r3 = r3 * r7
            long r1 = r1 ^ r3
        L_0x01e8:
            long r3 = (long) r0
            long r0 = r1 ^ r3
            long r2 = r5 ^ r3
            long r0 = r0 + r2
            long r2 = r2 + r0
            long r0 = fmix64(r0)
            long r2 = fmix64(r2)
            long r0 = r0 + r2
            long r2 = r2 + r0
            r4 = 2
            long[] r4 = new long[r4]
            r5 = 0
            r4[r5] = r0
            r0 = 1
            r4[r0] = r2
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.digest.MurmurHash3.hash128(byte[], int, int, int):long[]");
    }

    private static int mix32(int i, int i2) {
        return (Integer.rotateLeft((Integer.rotateLeft(i * C1_32, 15) * C2_32) ^ i2, 13) * 5) + N_32;
    }

    public static class IncrementalHash32 {
        int hash;
        byte[] tail = new byte[3];
        int tailLen;
        int totalLen;

        public final void start(int i) {
            this.totalLen = 0;
            this.tailLen = 0;
            this.hash = i;
        }

        public final void add(byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            byte[] bArr2 = bArr;
            int i5 = i;
            int i6 = i2;
            if (i6 != 0) {
                this.totalLen += i6;
                int i7 = this.tailLen;
                if (i7 + i6 < 4) {
                    System.arraycopy(bArr2, i5, this.tail, i7, i6);
                    this.tailLen += i6;
                    return;
                }
                if (i7 > 0) {
                    i3 = 4 - i7;
                    if (i7 == 1) {
                        i4 = MurmurHash3.orBytes(this.tail[0], bArr2[i5], bArr2[i5 + 1], bArr2[i5 + 2]);
                    } else if (i7 == 2) {
                        byte[] bArr3 = this.tail;
                        i4 = MurmurHash3.orBytes(bArr3[0], bArr3[1], bArr2[i5], bArr2[i5 + 1]);
                    } else if (i7 == 3) {
                        byte[] bArr4 = this.tail;
                        i4 = MurmurHash3.orBytes(bArr4[0], bArr4[1], bArr4[2], bArr2[i5]);
                    } else {
                        throw new AssertionError(this.tailLen);
                    }
                    int rotateLeft = (Integer.rotateLeft(i4 * MurmurHash3.C1_32, 15) * MurmurHash3.C2_32) ^ this.hash;
                    this.hash = rotateLeft;
                    this.hash = (Integer.rotateLeft(rotateLeft, 13) * 5) + MurmurHash3.N_32;
                } else {
                    i3 = 0;
                }
                int i8 = i6 - i3;
                int i9 = i5 + i3;
                int i10 = i8 >> 2;
                for (int i11 = 0; i11 < i10; i11++) {
                    int i12 = (i11 << 2) + i9;
                    int rotateLeft2 = (Integer.rotateLeft(MurmurHash3.orBytes(bArr2[i12], bArr2[i12 + 1], bArr2[i12 + 2], bArr2[i12 + 3]) * MurmurHash3.C1_32, 15) * MurmurHash3.C2_32) ^ this.hash;
                    this.hash = rotateLeft2;
                    this.hash = (Integer.rotateLeft(rotateLeft2, 13) * 5) + MurmurHash3.N_32;
                }
                int i13 = i10 << 2;
                int i14 = i8 - i13;
                this.tailLen = i14;
                if (i13 != i8) {
                    System.arraycopy(bArr2, i9 + i13, this.tail, 0, i14);
                }
            }
        }

        public final int end() {
            byte b;
            byte b2;
            int i = this.tailLen;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        b2 = (this.tail[2] << 16) ^ 0;
                    }
                    int i2 = this.hash ^ this.totalLen;
                    this.hash = i2;
                    int i3 = i2 ^ (i2 >>> 16);
                    this.hash = i3;
                    int i4 = i3 * -2048144789;
                    this.hash = i4;
                    int i5 = i4 ^ (i4 >>> 13);
                    this.hash = i5;
                    int i6 = i5 * -1028477387;
                    this.hash = i6;
                    int i7 = i6 ^ (i6 >>> 16);
                    this.hash = i7;
                    return i7;
                }
                b2 = 0;
                b = b2 ^ (this.tail[1] << 8);
            } else {
                b = 0;
            }
            this.hash = (Integer.rotateLeft((b ^ this.tail[0]) * MurmurHash3.C1_32, 15) * MurmurHash3.C2_32) ^ this.hash;
            int i22 = this.hash ^ this.totalLen;
            this.hash = i22;
            int i32 = i22 ^ (i22 >>> 16);
            this.hash = i32;
            int i42 = i32 * -2048144789;
            this.hash = i42;
            int i52 = i42 ^ (i42 >>> 13);
            this.hash = i52;
            int i62 = i52 * -1028477387;
            this.hash = i62;
            int i72 = i62 ^ (i62 >>> 16);
            this.hash = i72;
            return i72;
        }
    }
}
