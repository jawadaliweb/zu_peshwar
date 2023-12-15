package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzht  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzht {
    @Nullable
    private Integer zza;
    private zzhu zzb;

    private zzht() {
        this.zza = null;
        throw null;
    }

    /* synthetic */ zzht(zzhs zzhs) {
        this.zza = null;
        this.zzb = zzhu.zzc;
    }

    public final zzht zzb(zzhu zzhu) {
        this.zzb = zzhu;
        return this;
    }

    public final zzhw zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        } else if (this.zzb != null) {
            return new zzhw(num.intValue(), this.zzb, (zzhv) null);
        } else {
            throw new GeneralSecurityException("Variant is not set");
        }
    }

    public final zzht zza(int i) throws GeneralSecurityException {
        if (i == 32 || i == 48 || i == 64) {
            this.zza = Integer.valueOf(i);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 32-byte, 48-byte and 64-byte AES-SIV keys are supported", new Object[]{Integer.valueOf(i)}));
    }
}
