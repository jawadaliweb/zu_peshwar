package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzfl {
    @Nullable
    private Integer zza;
    private zzfm zzb;

    private zzfl() {
        this.zza = null;
        throw null;
    }

    /* synthetic */ zzfl(zzfk zzfk) {
        this.zza = null;
        this.zzb = zzfm.zzc;
    }

    public final zzfl zzb(zzfm zzfm) {
        this.zzb = zzfm;
        return this;
    }

    public final zzfo zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        } else if (this.zzb != null) {
            return new zzfo(num.intValue(), this.zzb, (zzfn) null);
        } else {
            throw new GeneralSecurityException("Variant is not set");
        }
    }

    public final zzfl zza(int i) throws GeneralSecurityException {
        if (i == 16 || i == 32) {
            this.zza = Integer.valueOf(i);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i)}));
    }
}
