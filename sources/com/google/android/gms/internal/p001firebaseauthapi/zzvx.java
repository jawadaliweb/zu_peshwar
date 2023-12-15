package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzvx {
    private final byte[] zza;

    private zzvx(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.zza = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i2);
    }

    public static zzvx zzb(byte[] bArr) {
        Objects.requireNonNull(bArr, "data must be non-null");
        return new zzvx(bArr, 0, bArr.length);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzvx)) {
            return false;
        }
        return Arrays.equals(((zzvx) obj).zza, this.zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        String zza2 = zzvl.zza(this.zza);
        return "Bytes(" + zza2 + ")";
    }

    public final int zza() {
        return this.zza.length;
    }

    public final byte[] zzc() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
