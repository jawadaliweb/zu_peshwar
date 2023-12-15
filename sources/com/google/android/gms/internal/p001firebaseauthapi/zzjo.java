package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzjo {
    private final zzbd zza;
    private final zzbi zzb;

    public zzjo(zzbd zzbd) {
        this.zza = zzbd;
        this.zzb = null;
    }

    public zzjo(zzbi zzbi) {
        this.zza = null;
        this.zzb = zzbi;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzbd zzbd = this.zza;
        if (zzbd != null) {
            return zzbd.zza(bArr, bArr2);
        }
        return this.zzb.zza(bArr, bArr2);
    }
}
