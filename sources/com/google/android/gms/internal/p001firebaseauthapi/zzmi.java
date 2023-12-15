package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzmi {
    @Nullable
    private Integer zza;
    @Nullable
    private Integer zzb;
    private zzmj zzc;

    private zzmi() {
        this.zza = null;
        this.zzb = null;
        throw null;
    }

    /* synthetic */ zzmi(zzmh zzmh) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzmj.zzd;
    }

    public final zzmi zzc(zzmj zzmj) {
        this.zzc = zzmj;
        return this;
    }

    public final zzml zzd() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("tag size not set");
        } else if (this.zzc != null) {
            return new zzml(num.intValue(), this.zzb.intValue(), this.zzc, (zzmk) null);
        } else {
            throw new GeneralSecurityException("variant not set");
        }
    }

    public final zzmi zza(int i) throws GeneralSecurityException {
        if (i == 16 || i == 32) {
            this.zza = Integer.valueOf(i);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", new Object[]{Integer.valueOf(i * 8)}));
    }

    public final zzmi zzb(int i) throws GeneralSecurityException {
        if (i < 10 || i > 16) {
            throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i);
        }
        this.zzb = Integer.valueOf(i);
        return this;
    }
}
