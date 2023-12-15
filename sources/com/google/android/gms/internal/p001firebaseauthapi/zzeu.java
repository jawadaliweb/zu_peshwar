package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzeu {
    @Nullable
    private Integer zza;
    @Nullable
    private Integer zzb;
    @Nullable
    private Integer zzc;
    private zzev zzd;

    private zzeu() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }

    /* synthetic */ zzeu(zzet zzet) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzev.zzc;
    }

    public final zzeu zza(int i) throws GeneralSecurityException {
        this.zzb = 12;
        return this;
    }

    public final zzeu zzc(int i) throws GeneralSecurityException {
        this.zzc = 16;
        return this;
    }

    public final zzeu zzd(zzev zzev) {
        this.zzd = zzev;
        return this;
    }

    public final zzex zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        } else if (this.zzd == null) {
            throw new GeneralSecurityException("Variant is not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("IV size is not set");
        } else if (this.zzc != null) {
            int intValue = num.intValue();
            this.zzb.intValue();
            this.zzc.intValue();
            return new zzex(intValue, 12, 16, this.zzd, (zzew) null);
        } else {
            throw new GeneralSecurityException("Tag size is not set");
        }
    }

    public final zzeu zzb(int i) throws GeneralSecurityException {
        if (i == 16 || i == 24 || i == 32) {
            this.zza = Integer.valueOf(i);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i)}));
    }
}
