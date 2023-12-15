package org.apache.commons.codec.digest;

import kotlin.UByte;

public final class MurmurHash2 {
    private MurmurHash2() {
    }

    public static int hash32(byte[] bArr, int i, int i2) {
        int i3 = i2 ^ i;
        int i4 = i / 4;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i5 * 4;
            int i7 = ((bArr[i6 + 0] & UByte.MAX_VALUE) + ((bArr[i6 + 1] & UByte.MAX_VALUE) << 8) + ((bArr[i6 + 2] & UByte.MAX_VALUE) << 16) + ((bArr[i6 + 3] & UByte.MAX_VALUE) << 24)) * 1540483477;
            i3 = (i3 * 1540483477) ^ (((i7 >>> 24) ^ i7) * 1540483477);
        }
        int i8 = i % 4;
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    i3 ^= (bArr[(i & -4) + 2] & UByte.MAX_VALUE) << 16;
                }
                int i9 = ((i3 >>> 13) ^ i3) * 1540483477;
                return i9 ^ (i9 >>> 15);
            }
            i3 ^= (bArr[(i & -4) + 1] & UByte.MAX_VALUE) << 8;
        }
        i3 = ((bArr[i & -4] & UByte.MAX_VALUE) ^ i3) * 1540483477;
        int i92 = ((i3 >>> 13) ^ i3) * 1540483477;
        return i92 ^ (i92 >>> 15);
    }

    public static int hash32(byte[] bArr, int i) {
        return hash32(bArr, i, -1756908916);
    }

    public static int hash32(String str) {
        byte[] bytes = str.getBytes();
        return hash32(bytes, bytes.length);
    }

    public static int hash32(String str, int i, int i2) {
        return hash32(str.substring(i, i2 + i));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x00ba, code lost:
        r1 = r1 ^ (((long) (r18[(r0 & -8) + 3] & kotlin.UByte.MAX_VALUE)) << 24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x00c5, code lost:
        r1 = r1 ^ (((long) (r18[(r0 & -8) + 2] & kotlin.UByte.MAX_VALUE)) << 16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00d0, code lost:
        r1 = r1 ^ (((long) (r18[(r0 & -8) + 1] & kotlin.UByte.MAX_VALUE)) << 8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00db, code lost:
        r3 = -4132994306676758123L;
        r1 = (r1 ^ ((long) (r18[r0 & -8] & kotlin.UByte.MAX_VALUE))) * -4132994306676758123L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00eb, code lost:
        r0 = (r1 ^ (r1 >>> 47)) * r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00f4, code lost:
        return r0 ^ (r0 >>> 47);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x00a2, code lost:
        r1 = r1 ^ (((long) (r18[(r0 & -8) + 5] & kotlin.UByte.MAX_VALUE)) << 40);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x00af, code lost:
        r1 = r1 ^ (((long) (r18[(r0 & -8) + 4] & kotlin.UByte.MAX_VALUE)) << 32);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long hash64(byte[] r18, int r19, int r20) {
        /*
            r0 = r19
            r1 = r20
            long r1 = (long) r1
            r3 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r1 = r1 & r3
            long r3 = (long) r0
            r5 = -4132994306676758123(0xc6a4a7935bd1e995, double:-2.0946245025644615E32)
            long r3 = r3 * r5
            long r1 = r1 ^ r3
            int r3 = r0 / 8
            r4 = 0
        L_0x0017:
            r9 = 32
            r10 = 24
            r11 = 16
            r12 = 47
            r13 = 8
            if (r4 >= r3) goto L_0x008a
            int r14 = r4 * 8
            int r15 = r14 + 0
            byte r15 = r18[r15]
            long r5 = (long) r15
            r16 = 255(0xff, double:1.26E-321)
            long r5 = r5 & r16
            int r15 = r14 + 1
            byte r15 = r18[r15]
            long r7 = (long) r15
            long r7 = r7 & r16
            long r7 = r7 << r13
            long r5 = r5 + r7
            int r7 = r14 + 2
            byte r7 = r18[r7]
            long r7 = (long) r7
            long r7 = r7 & r16
            long r7 = r7 << r11
            long r5 = r5 + r7
            int r7 = r14 + 3
            byte r7 = r18[r7]
            long r7 = (long) r7
            long r7 = r7 & r16
            long r7 = r7 << r10
            long r5 = r5 + r7
            int r7 = r14 + 4
            byte r7 = r18[r7]
            long r7 = (long) r7
            long r7 = r7 & r16
            long r7 = r7 << r9
            long r5 = r5 + r7
            int r7 = r14 + 5
            byte r7 = r18[r7]
            long r7 = (long) r7
            long r7 = r7 & r16
            r9 = 40
            long r7 = r7 << r9
            long r5 = r5 + r7
            int r7 = r14 + 6
            byte r7 = r18[r7]
            long r7 = (long) r7
            long r7 = r7 & r16
            r9 = 48
            long r7 = r7 << r9
            long r5 = r5 + r7
            int r14 = r14 + 7
            byte r7 = r18[r14]
            long r7 = (long) r7
            long r7 = r7 & r16
            r9 = 56
            long r7 = r7 << r9
            long r5 = r5 + r7
            r7 = -4132994306676758123(0xc6a4a7935bd1e995, double:-2.0946245025644615E32)
            long r5 = r5 * r7
            long r9 = r5 >>> r12
            long r5 = r5 ^ r9
            long r5 = r5 * r7
            long r1 = r1 ^ r5
            long r1 = r1 * r7
            int r4 = r4 + 1
            r5 = -4132994306676758123(0xc6a4a7935bd1e995, double:-2.0946245025644615E32)
            goto L_0x0017
        L_0x008a:
            int r3 = r0 % 8
            switch(r3) {
                case 1: goto L_0x00db;
                case 2: goto L_0x00d0;
                case 3: goto L_0x00c5;
                case 4: goto L_0x00ba;
                case 5: goto L_0x00af;
                case 6: goto L_0x00a2;
                case 7: goto L_0x0095;
                default: goto L_0x008f;
            }
        L_0x008f:
            r3 = -4132994306676758123(0xc6a4a7935bd1e995, double:-2.0946245025644615E32)
            goto L_0x00eb
        L_0x0095:
            r3 = r0 & -8
            int r3 = r3 + 6
            byte r3 = r18[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            long r3 = (long) r3
            r5 = 48
            long r3 = r3 << r5
            long r1 = r1 ^ r3
        L_0x00a2:
            r3 = r0 & -8
            int r3 = r3 + 5
            byte r3 = r18[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            long r3 = (long) r3
            r5 = 40
            long r3 = r3 << r5
            long r1 = r1 ^ r3
        L_0x00af:
            r3 = r0 & -8
            int r3 = r3 + 4
            byte r3 = r18[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            long r3 = (long) r3
            long r3 = r3 << r9
            long r1 = r1 ^ r3
        L_0x00ba:
            r3 = r0 & -8
            int r3 = r3 + 3
            byte r3 = r18[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            long r3 = (long) r3
            long r3 = r3 << r10
            long r1 = r1 ^ r3
        L_0x00c5:
            r3 = r0 & -8
            int r3 = r3 + 2
            byte r3 = r18[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            long r3 = (long) r3
            long r3 = r3 << r11
            long r1 = r1 ^ r3
        L_0x00d0:
            r3 = r0 & -8
            int r3 = r3 + 1
            byte r3 = r18[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            long r3 = (long) r3
            long r3 = r3 << r13
            long r1 = r1 ^ r3
        L_0x00db:
            r0 = r0 & -8
            byte r0 = r18[r0]
            r0 = r0 & 255(0xff, float:3.57E-43)
            long r3 = (long) r0
            long r0 = r1 ^ r3
            r3 = -4132994306676758123(0xc6a4a7935bd1e995, double:-2.0946245025644615E32)
            long r1 = r0 * r3
        L_0x00eb:
            long r5 = r1 >>> r12
            long r0 = r1 ^ r5
            long r0 = r0 * r3
            long r2 = r0 >>> r12
            long r0 = r0 ^ r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.digest.MurmurHash2.hash64(byte[], int, int):long");
    }

    public static long hash64(byte[] bArr, int i) {
        return hash64(bArr, i, -512093083);
    }

    public static long hash64(String str) {
        byte[] bytes = str.getBytes();
        return hash64(bytes, bytes.length);
    }

    public static long hash64(String str, int i, int i2) {
        return hash64(str.substring(i, i2 + i));
    }
}
