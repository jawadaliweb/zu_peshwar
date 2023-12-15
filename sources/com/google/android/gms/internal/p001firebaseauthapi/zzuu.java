package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzuu implements zzbd {
    private final zzvm zza;
    private final zzcd zzb;
    private final int zzc;

    public zzuu(zzvm zzvm, zzcd zzcd, int i) {
        this.zza = zzvm;
        this.zzb = zzcd;
        this.zzc = i;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzc;
        if (length >= i) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, length - i);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, length - this.zzc, length);
            byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(0).array(), 8);
            this.zzb.zza(copyOfRange2, zzum.zzb(bArr2, copyOfRange, copyOf));
            return this.zza.zza(copyOfRange);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
