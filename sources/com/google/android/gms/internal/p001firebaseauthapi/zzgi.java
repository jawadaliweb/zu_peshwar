package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzgi implements zzbd {
    private static final byte[] zza = new byte[0];
    private final zzsu zzb;
    private final zzbd zzc;

    public zzgi(zzsu zzsu, zzbd zzbd) {
        this.zzb = zzsu;
        this.zzc = zzbd;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i = wrap.getInt();
            if (i <= 0 || i > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i];
            wrap.get(bArr3, 0, i);
            byte[] bArr4 = new byte[wrap.remaining()];
            wrap.get(bArr4, 0, wrap.remaining());
            byte[] zza2 = this.zzc.zza(bArr3, zza);
            int i2 = zzcq.zza;
            zzaff zzaff = zzaff.zzb;
            return ((zzbd) zzcq.zze(this.zzb.zzf(), zzaff.zzn(zza2, 0, zza2.length), zzbd.class)).zza(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e) {
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
