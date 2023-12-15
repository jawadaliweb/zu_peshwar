package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;
import kotlin.UByte;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzjy {
    private static final int[] zza = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
    private static final int[] zzb = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
    private static final int[] zzc = {67108863, 33554431};
    private static final int[] zzd = {26, 25};

    static void zza(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[19];
        zzb(jArr4, jArr2, jArr3);
        zzc(jArr4, jArr);
    }

    /* JADX WARNING: type inference failed for: r32v0, types: [long[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void zzb(long[] r32, long[] r33, long[] r34) {
        /*
            r0 = 0
            r1 = r33[r0]
            r3 = r34[r0]
            long r1 = r1 * r3
            r32[r0] = r1
            r1 = r33[r0]
            r3 = 1
            r4 = r34[r3]
            long r1 = r1 * r4
            r4 = r33[r3]
            r6 = r34[r0]
            long r4 = r4 * r6
            long r1 = r1 + r4
            r32[r3] = r1
            r1 = r33[r3]
            long r1 = r1 + r1
            r4 = r34[r3]
            long r1 = r1 * r4
            r4 = r33[r0]
            r6 = 2
            r7 = r34[r6]
            long r4 = r4 * r7
            r7 = r33[r6]
            r9 = r34[r0]
            long r7 = r7 * r9
            long r1 = r1 + r4
            long r1 = r1 + r7
            r32[r6] = r1
            r1 = r33[r3]
            r4 = r34[r6]
            long r1 = r1 * r4
            r4 = r33[r6]
            r7 = r34[r3]
            long r4 = r4 * r7
            r7 = r33[r0]
            r9 = 3
            r10 = r34[r9]
            long r7 = r7 * r10
            r10 = r33[r9]
            r12 = r34[r0]
            long r10 = r10 * r12
            long r1 = r1 + r4
            long r1 = r1 + r7
            long r1 = r1 + r10
            r32[r9] = r1
            r1 = r33[r6]
            r4 = r34[r6]
            long r1 = r1 * r4
            r4 = r33[r3]
            r7 = r34[r9]
            long r4 = r4 * r7
            r7 = r33[r9]
            r10 = r34[r3]
            long r7 = r7 * r10
            r10 = r33[r0]
            r12 = 4
            r13 = r34[r12]
            long r10 = r10 * r13
            r13 = r33[r12]
            r15 = r34[r0]
            long r13 = r13 * r15
            long r4 = r4 + r7
            long r4 = r4 + r4
            long r1 = r1 + r4
            long r1 = r1 + r10
            long r1 = r1 + r13
            r32[r12] = r1
            r1 = r33[r6]
            r4 = r34[r9]
            long r1 = r1 * r4
            r4 = r33[r9]
            r7 = r34[r6]
            long r4 = r4 * r7
            r7 = r33[r3]
            r10 = r34[r12]
            long r7 = r7 * r10
            r10 = r33[r12]
            r13 = r34[r3]
            long r10 = r10 * r13
            r13 = r33[r0]
            r15 = 5
            r16 = r34[r15]
            long r13 = r13 * r16
            r16 = r33[r15]
            r18 = r34[r0]
            long r16 = r16 * r18
            long r1 = r1 + r4
            long r1 = r1 + r7
            long r1 = r1 + r10
            long r1 = r1 + r13
            long r1 = r1 + r16
            r32[r15] = r1
            r1 = r33[r9]
            r4 = r34[r9]
            long r1 = r1 * r4
            r4 = r33[r3]
            r7 = r34[r15]
            long r4 = r4 * r7
            r7 = r33[r15]
            r10 = r34[r3]
            long r7 = r7 * r10
            r10 = r33[r6]
            r13 = r34[r12]
            long r10 = r10 * r13
            r13 = r33[r12]
            r16 = r34[r6]
            long r13 = r13 * r16
            r16 = r33[r0]
            r18 = 6
            r19 = r34[r18]
            long r16 = r16 * r19
            r19 = r33[r18]
            r21 = r34[r0]
            long r19 = r19 * r21
            long r1 = r1 + r4
            long r1 = r1 + r7
            long r1 = r1 + r1
            long r1 = r1 + r10
            long r1 = r1 + r13
            long r1 = r1 + r16
            long r1 = r1 + r19
            r32[r18] = r1
            r1 = r33[r9]
            r4 = r34[r12]
            long r1 = r1 * r4
            r4 = r33[r12]
            r7 = r34[r9]
            long r4 = r4 * r7
            r7 = r33[r6]
            r10 = r34[r15]
            long r7 = r7 * r10
            r10 = r33[r15]
            r13 = r34[r6]
            long r10 = r10 * r13
            r13 = r33[r3]
            r16 = r34[r18]
            long r13 = r13 * r16
            r16 = r33[r18]
            r19 = r34[r3]
            long r16 = r16 * r19
            r19 = r33[r0]
            r21 = 7
            r22 = r34[r21]
            long r19 = r19 * r22
            r22 = r33[r21]
            r24 = r34[r0]
            long r22 = r22 * r24
            long r1 = r1 + r4
            long r1 = r1 + r7
            long r1 = r1 + r10
            long r1 = r1 + r13
            long r1 = r1 + r16
            long r1 = r1 + r19
            long r1 = r1 + r22
            r32[r21] = r1
            r1 = r33[r12]
            r4 = r34[r12]
            long r1 = r1 * r4
            r4 = r33[r9]
            r7 = r34[r15]
            long r4 = r4 * r7
            r7 = r33[r15]
            r10 = r34[r9]
            long r7 = r7 * r10
            r10 = r33[r3]
            r13 = r34[r21]
            long r10 = r10 * r13
            r13 = r33[r21]
            r16 = r34[r3]
            long r13 = r13 * r16
            r16 = r33[r6]
            r19 = r34[r18]
            long r16 = r16 * r19
            r19 = r33[r18]
            r22 = r34[r6]
            long r19 = r19 * r22
            r22 = r33[r0]
            r24 = 8
            r25 = r34[r24]
            long r22 = r22 * r25
            r25 = r33[r24]
            r27 = r34[r0]
            long r25 = r25 * r27
            long r4 = r4 + r7
            long r4 = r4 + r10
            long r4 = r4 + r13
            long r4 = r4 + r4
            long r1 = r1 + r4
            long r1 = r1 + r16
            long r1 = r1 + r19
            long r1 = r1 + r22
            long r1 = r1 + r25
            r32[r24] = r1
            r1 = r33[r12]
            r4 = r34[r15]
            long r1 = r1 * r4
            r4 = r33[r15]
            r7 = r34[r12]
            long r4 = r4 * r7
            r7 = r33[r9]
            r10 = r34[r18]
            long r7 = r7 * r10
            r10 = r33[r18]
            r13 = r34[r9]
            long r10 = r10 * r13
            r13 = r33[r6]
            r16 = r34[r21]
            long r13 = r13 * r16
            r16 = r33[r21]
            r19 = r34[r6]
            long r16 = r16 * r19
            r19 = r33[r3]
            r22 = r34[r24]
            long r19 = r19 * r22
            r22 = r33[r24]
            r25 = r34[r3]
            long r22 = r22 * r25
            r25 = r33[r0]
            r27 = 9
            r28 = r34[r27]
            long r25 = r25 * r28
            r28 = r33[r27]
            r30 = r34[r0]
            long r28 = r28 * r30
            long r1 = r1 + r4
            long r1 = r1 + r7
            long r1 = r1 + r10
            long r1 = r1 + r13
            long r1 = r1 + r16
            long r1 = r1 + r19
            long r1 = r1 + r22
            long r1 = r1 + r25
            long r1 = r1 + r28
            r32[r27] = r1
            r0 = r33[r15]
            r4 = r34[r15]
            long r0 = r0 * r4
            r4 = r33[r9]
            r7 = r34[r21]
            long r4 = r4 * r7
            r7 = r33[r21]
            r10 = r34[r9]
            long r7 = r7 * r10
            r10 = r33[r3]
            r13 = r34[r27]
            long r10 = r10 * r13
            r13 = r33[r27]
            r2 = r34[r3]
            long r13 = r13 * r2
            r2 = r33[r12]
            r16 = r34[r18]
            long r2 = r2 * r16
            r16 = r33[r18]
            r19 = r34[r12]
            long r16 = r16 * r19
            r19 = r33[r6]
            r22 = r34[r24]
            long r19 = r19 * r22
            r22 = r33[r24]
            r25 = r34[r6]
            long r22 = r22 * r25
            long r0 = r0 + r4
            long r0 = r0 + r7
            long r0 = r0 + r10
            long r0 = r0 + r13
            long r0 = r0 + r0
            long r0 = r0 + r2
            long r0 = r0 + r16
            long r0 = r0 + r19
            long r0 = r0 + r22
            r2 = 10
            r32[r2] = r0
            r0 = r33[r15]
            r2 = r34[r18]
            long r0 = r0 * r2
            r2 = r33[r18]
            r4 = r34[r15]
            long r2 = r2 * r4
            r4 = r33[r12]
            r7 = r34[r21]
            long r4 = r4 * r7
            r7 = r33[r21]
            r10 = r34[r12]
            long r7 = r7 * r10
            r10 = r33[r9]
            r13 = r34[r24]
            long r10 = r10 * r13
            r13 = r33[r24]
            r16 = r34[r9]
            long r13 = r13 * r16
            r16 = r33[r6]
            r19 = r34[r27]
            long r16 = r16 * r19
            r19 = r33[r27]
            r22 = r34[r6]
            long r19 = r19 * r22
            long r0 = r0 + r2
            long r0 = r0 + r4
            long r0 = r0 + r7
            long r0 = r0 + r10
            long r0 = r0 + r13
            long r0 = r0 + r16
            long r0 = r0 + r19
            r2 = 11
            r32[r2] = r0
            r0 = r33[r18]
            r2 = r34[r18]
            long r0 = r0 * r2
            r2 = r33[r15]
            r4 = r34[r21]
            long r2 = r2 * r4
            r4 = r33[r21]
            r6 = r34[r15]
            long r4 = r4 * r6
            r6 = r33[r9]
            r10 = r34[r27]
            long r6 = r6 * r10
            r10 = r33[r27]
            r8 = r34[r9]
            long r10 = r10 * r8
            r8 = r33[r12]
            r13 = r34[r24]
            long r8 = r8 * r13
            r13 = r33[r24]
            r16 = r34[r12]
            long r13 = r13 * r16
            long r2 = r2 + r4
            long r2 = r2 + r6
            long r2 = r2 + r10
            long r2 = r2 + r2
            long r0 = r0 + r2
            long r0 = r0 + r8
            long r0 = r0 + r13
            r2 = 12
            r32[r2] = r0
            r0 = r33[r18]
            r2 = r34[r21]
            long r0 = r0 * r2
            r2 = r33[r21]
            r4 = r34[r18]
            long r2 = r2 * r4
            r4 = r33[r15]
            r6 = r34[r24]
            long r4 = r4 * r6
            r6 = r33[r24]
            r8 = r34[r15]
            long r6 = r6 * r8
            r8 = r33[r12]
            r10 = r34[r27]
            long r8 = r8 * r10
            r10 = r33[r27]
            r12 = r34[r12]
            long r10 = r10 * r12
            long r0 = r0 + r2
            long r0 = r0 + r4
            long r0 = r0 + r6
            long r0 = r0 + r8
            long r0 = r0 + r10
            r2 = 13
            r32[r2] = r0
            r0 = r33[r21]
            r2 = r34[r21]
            long r0 = r0 * r2
            r2 = r33[r15]
            r4 = r34[r27]
            long r2 = r2 * r4
            r4 = r33[r27]
            r6 = r34[r15]
            long r4 = r4 * r6
            r6 = r33[r18]
            r8 = r34[r24]
            long r6 = r6 * r8
            r8 = r33[r24]
            r10 = r34[r18]
            long r8 = r8 * r10
            long r0 = r0 + r2
            long r0 = r0 + r4
            long r0 = r0 + r0
            long r0 = r0 + r6
            long r0 = r0 + r8
            r2 = 14
            r32[r2] = r0
            r0 = r33[r21]
            r2 = r34[r24]
            long r0 = r0 * r2
            r2 = r33[r24]
            r4 = r34[r21]
            long r2 = r2 * r4
            r4 = r33[r18]
            r6 = r34[r27]
            long r4 = r4 * r6
            r6 = r33[r27]
            r8 = r34[r18]
            long r6 = r6 * r8
            long r0 = r0 + r2
            long r0 = r0 + r4
            long r0 = r0 + r6
            r2 = 15
            r32[r2] = r0
            r0 = r33[r24]
            r2 = r34[r24]
            long r0 = r0 * r2
            r2 = r33[r21]
            r4 = r34[r27]
            long r2 = r2 * r4
            r4 = r33[r27]
            r6 = r34[r21]
            long r4 = r4 * r6
            long r2 = r2 + r4
            long r2 = r2 + r2
            long r0 = r0 + r2
            r2 = 16
            r32[r2] = r0
            r0 = r33[r24]
            r2 = r34[r27]
            long r0 = r0 * r2
            r2 = r33[r27]
            r4 = r34[r24]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = 17
            r32[r2] = r0
            r0 = r33[r27]
            long r0 = r0 + r0
            r2 = r34[r27]
            long r0 = r0 * r2
            r2 = 18
            r32[r2] = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzjy.zzb(long[], long[], long[]):void");
    }

    static void zzc(long[] jArr, long[] jArr2) {
        zze(jArr);
        zzd(jArr);
        System.arraycopy(jArr, 0, jArr2, 0, 10);
    }

    static void zzd(long[] jArr) {
        jArr[10] = 0;
        int i = 0;
        while (i < 10) {
            long j = jArr[i];
            long j2 = j / 67108864;
            jArr[i] = j - (j2 << 26);
            int i2 = i + 1;
            long j3 = jArr[i2] + j2;
            jArr[i2] = j3;
            long j4 = j3 / 33554432;
            jArr[i2] = j3 - (j4 << 25);
            i += 2;
            jArr[i] = jArr[i] + j4;
        }
        long j5 = jArr[0] + (jArr[10] << 4);
        jArr[0] = j5;
        long j6 = jArr[10];
        long j7 = j5 + j6 + j6;
        jArr[0] = j7;
        jArr[0] = j7 + jArr[10];
        jArr[10] = 0;
        long j8 = jArr[0];
        long j9 = j8 / 67108864;
        jArr[0] = j8 - (j9 << 26);
        jArr[1] = jArr[1] + j9;
    }

    static void zze(long[] jArr) {
        long j = jArr[8] + (jArr[18] << 4);
        jArr[8] = j;
        long j2 = jArr[18];
        long j3 = j + j2 + j2;
        jArr[8] = j3;
        jArr[8] = j3 + jArr[18];
        long j4 = jArr[7] + (jArr[17] << 4);
        jArr[7] = j4;
        long j5 = jArr[17];
        long j6 = j4 + j5 + j5;
        jArr[7] = j6;
        jArr[7] = j6 + jArr[17];
        long j7 = jArr[6] + (jArr[16] << 4);
        jArr[6] = j7;
        long j8 = jArr[16];
        long j9 = j7 + j8 + j8;
        jArr[6] = j9;
        jArr[6] = j9 + jArr[16];
        long j10 = jArr[5] + (jArr[15] << 4);
        jArr[5] = j10;
        long j11 = jArr[15];
        long j12 = j10 + j11 + j11;
        jArr[5] = j12;
        jArr[5] = j12 + jArr[15];
        long j13 = jArr[4] + (jArr[14] << 4);
        jArr[4] = j13;
        long j14 = jArr[14];
        long j15 = j13 + j14 + j14;
        jArr[4] = j15;
        jArr[4] = j15 + jArr[14];
        long j16 = jArr[3] + (jArr[13] << 4);
        jArr[3] = j16;
        long j17 = jArr[13];
        long j18 = j16 + j17 + j17;
        jArr[3] = j18;
        jArr[3] = j18 + jArr[13];
        long j19 = jArr[2] + (jArr[12] << 4);
        jArr[2] = j19;
        long j20 = jArr[12];
        long j21 = j19 + j20 + j20;
        jArr[2] = j21;
        jArr[2] = j21 + jArr[12];
        long j22 = jArr[1] + (jArr[11] << 4);
        jArr[1] = j22;
        long j23 = jArr[11];
        long j24 = j22 + j23 + j23;
        jArr[1] = j24;
        jArr[1] = j24 + jArr[11];
        long j25 = jArr[0] + (jArr[10] << 4);
        jArr[0] = j25;
        long j26 = jArr[10];
        long j27 = j25 + j26 + j26;
        jArr[0] = j27;
        jArr[0] = j27 + jArr[10];
    }

    static void zzf(long[] jArr, long[] jArr2, long j) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] * j;
        }
    }

    static void zzg(long[] jArr, long[] jArr2) {
        long j = jArr2[0];
        long j2 = jArr2[0];
        long j3 = jArr2[1];
        long j4 = (j3 * j3) + (jArr2[0] * jArr2[2]);
        long j5 = (jArr2[1] * jArr2[2]) + (jArr2[0] * jArr2[3]);
        long j6 = jArr2[2];
        long j7 = jArr2[1] * 4 * jArr2[3];
        long j8 = jArr2[0];
        long j9 = (j6 * j6) + j7;
        long j10 = (jArr2[2] * jArr2[3]) + (jArr2[1] * jArr2[4]) + (jArr2[0] * jArr2[5]);
        long j11 = jArr2[3];
        long j12 = jArr2[2] * jArr2[4];
        long j13 = jArr2[0] * jArr2[6];
        long j14 = jArr2[1];
        long j15 = (j11 * j11) + j12 + j13 + ((j14 + j14) * jArr2[5]);
        long j16 = jArr2[3] * jArr2[4];
        long j17 = jArr2[2] * jArr2[5];
        long j18 = j16 + j17 + (jArr2[1] * jArr2[6]) + (jArr2[0] * jArr2[7]);
        long j19 = jArr2[4];
        long j20 = jArr2[2] * jArr2[6];
        long j21 = jArr2[0] * jArr2[8];
        long j22 = (jArr2[1] * jArr2[7]) + (jArr2[3] * jArr2[5]);
        long j23 = j20 + j21 + j22 + j22;
        long j24 = jArr2[4] * jArr2[5];
        long j25 = jArr2[3] * jArr2[6];
        long j26 = jArr2[2] * jArr2[7];
        long j27 = j24 + j25 + j26 + (jArr2[1] * jArr2[8]) + (jArr2[0] * jArr2[9]);
        long j28 = jArr2[5];
        long j29 = jArr2[4] * jArr2[6];
        long j30 = jArr2[2] * jArr2[8];
        long j31 = (jArr2[3] * jArr2[7]) + (jArr2[1] * jArr2[9]);
        long j32 = (j28 * j28) + j29 + j30 + j31 + j31;
        long j33 = jArr2[5] * jArr2[6];
        long j34 = jArr2[4] * jArr2[7];
        long j35 = j33 + j34 + (jArr2[3] * jArr2[8]) + (jArr2[2] * jArr2[9]);
        long j36 = jArr2[6];
        long j37 = jArr2[4] * jArr2[8];
        long j38 = (jArr2[5] * jArr2[7]) + (jArr2[3] * jArr2[9]);
        long j39 = j37 + j38 + j38;
        long j40 = (jArr2[6] * jArr2[7]) + (jArr2[5] * jArr2[8]) + (jArr2[4] * jArr2[9]);
        long j41 = jArr2[7];
        long j42 = jArr2[6] * jArr2[8];
        long j43 = jArr2[5];
        long j44 = (j41 * j41) + j42 + ((j43 + j43) * jArr2[9]);
        long j45 = (jArr2[7] * jArr2[8]) + (jArr2[6] * jArr2[9]);
        long j46 = jArr2[8];
        long j47 = jArr2[8];
        long j48 = jArr2[9];
        zzc(new long[]{j * j, (j2 + j2) * jArr2[1], j4 + j4, j5 + j5, j9 + ((j8 + j8) * jArr2[4]), j10 + j10, j15 + j15, j18 + j18, (j19 * j19) + j23 + j23, j27 + j27, j32 + j32, j35 + j35, (j36 * j36) + j39 + j39, j40 + j40, j44 + j44, j45 + j45, (j46 * j46) + (jArr2[7] * 4 * jArr2[9]), (j47 + j47) * jArr2[9], (j48 + j48) * j48}, jArr);
    }

    static void zzh(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] - jArr3[i];
        }
    }

    static void zzi(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] + jArr3[i];
        }
    }

    public static byte[] zzj(long[] jArr) {
        int i;
        long[] copyOf = Arrays.copyOf(jArr, 10);
        int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                break;
            }
            int i3 = 0;
            while (i3 < 9) {
                long j = copyOf[i3];
                int i4 = zzd[i3 & 1];
                int i5 = -((int) (((j >> 31) & j) >> i4));
                copyOf[i3] = j + ((long) (i5 << i4));
                i3++;
                copyOf[i3] = copyOf[i3] - ((long) i5);
            }
            long j2 = copyOf[9];
            int i6 = -((int) (((j2 >> 31) & j2) >> 25));
            copyOf[9] = j2 + ((long) (i6 << 25));
            copyOf[0] = copyOf[0] - (((long) i6) * 19);
            i2++;
        }
        long j3 = copyOf[0];
        int i7 = -((int) (((j3 >> 31) & j3) >> 26));
        copyOf[0] = j3 + ((long) (i7 << 26));
        copyOf[1] = copyOf[1] - ((long) i7);
        int i8 = 0;
        for (i = 2; i8 < i; i = 2) {
            int i9 = 0;
            while (i9 < 9) {
                long j4 = copyOf[i9];
                int i10 = i9 & 1;
                long j5 = j4 >> zzd[i10];
                copyOf[i9] = j4 & ((long) zzc[i10]);
                i9++;
                copyOf[i9] = copyOf[i9] + ((long) ((int) j5));
            }
            i8++;
        }
        long j6 = copyOf[9];
        copyOf[9] = j6 & 33554431;
        long j7 = copyOf[0] + (((long) ((int) (j6 >> 25))) * 19);
        copyOf[0] = j7;
        int i11 = ~((((int) j7) - 67108845) >> 31);
        for (int i12 = 1; i12 < 10; i12++) {
            int i13 = ~(zzc[i12 & 1] ^ ((int) copyOf[i12]));
            int i14 = i13 & (i13 << 16);
            int i15 = i14 & (i14 << 8);
            int i16 = i15 & (i15 << 4);
            int i17 = i16 & (i16 << 2);
            i11 &= (i17 & (i17 + i17)) >> 31;
        }
        copyOf[0] = copyOf[0] - ((long) (67108845 & i11));
        long j8 = (long) (33554431 & i11);
        copyOf[1] = copyOf[1] - j8;
        for (int i18 = 2; i18 < 10; i18 += 2) {
            copyOf[i18] = copyOf[i18] - ((long) (67108863 & i11));
            int i19 = i18 + 1;
            copyOf[i19] = copyOf[i19] - j8;
        }
        for (int i20 = 0; i20 < 10; i20++) {
            copyOf[i20] = copyOf[i20] << zzb[i20];
        }
        byte[] bArr = new byte[32];
        for (int i21 = 0; i21 < 10; i21++) {
            int[] iArr = zza;
            int i22 = iArr[i21];
            long j9 = copyOf[i21];
            bArr[i22] = (byte) ((int) (((long) bArr[i22]) | (j9 & 255)));
            int i23 = iArr[i21] + 1;
            bArr[i23] = (byte) ((int) (((long) bArr[i23]) | ((j9 >> 8) & 255)));
            int i24 = iArr[i21] + 2;
            bArr[i24] = (byte) ((int) (((long) bArr[i24]) | ((j9 >> 16) & 255)));
            int i25 = iArr[i21] + 3;
            bArr[i25] = (byte) ((int) (((j9 >> 24) & 255) | ((long) bArr[i25])));
        }
        return bArr;
    }

    static long[] zzk(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i = 0; i < 10; i++) {
            int i2 = zza[i];
            byte b = bArr[i2] & UByte.MAX_VALUE;
            byte b2 = bArr[i2 + 1] & UByte.MAX_VALUE;
            long j = ((long) b) | (((long) b2) << 8);
            jArr[i] = (((j | (((long) (bArr[i2 + 2] & UByte.MAX_VALUE)) << 16)) | (((long) (bArr[i2 + 3] & UByte.MAX_VALUE)) << 24)) >> zzb[i]) & ((long) zzc[i & 1]);
        }
        return jArr;
    }
}
