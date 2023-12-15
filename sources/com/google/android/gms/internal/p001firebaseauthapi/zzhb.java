package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
abstract class zzhb {
    int[] zza;
    private final int zzb;

    public zzhb(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length == 32) {
            this.zza = zzgx.zzd(bArr);
            this.zzb = i;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    /* access modifiers changed from: package-private */
    public abstract int zza();

    /* access modifiers changed from: package-private */
    public abstract int[] zzb(int[] iArr, int i);

    /* access modifiers changed from: package-private */
    public final ByteBuffer zzc(byte[] bArr, int i) {
        int[] zzb2 = zzb(zzgx.zzd(bArr), i);
        int[] iArr = (int[]) zzb2.clone();
        zzgx.zzc(iArr);
        for (int i2 = 0; i2 < 16; i2++) {
            zzb2[i2] = zzb2[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(zzb2, 0, 16);
        return order;
    }

    public final byte[] zzd(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        if (bArr.length == zza()) {
            int remaining = byteBuffer.remaining();
            int i = remaining / 64;
            int i2 = 0;
            while (true) {
                int i3 = i + 1;
                if (i2 >= i3) {
                    return allocate.array();
                }
                ByteBuffer zzc = zzc(bArr, this.zzb + i2);
                if (i2 == i3 - 1) {
                    zzum.zza(allocate, byteBuffer, zzc, remaining % 64);
                } else {
                    zzum.zza(allocate, byteBuffer, zzc, 64);
                }
                i2++;
            }
        } else {
            int zza2 = zza();
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + zza2);
        }
    }
}
