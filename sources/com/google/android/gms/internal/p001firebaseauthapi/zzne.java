package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzne  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzne {
    @Nullable
    private Integer zza;
    @Nullable
    private Integer zzb;
    private zznf zzc;
    private zzng zzd;

    private zzne() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }

    /* synthetic */ zzne(zznd zznd) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzng.zzd;
    }

    public final zzne zza(zznf zznf) {
        this.zzc = zznf;
        return this;
    }

    public final zzne zzb(int i) throws GeneralSecurityException {
        this.zza = Integer.valueOf(i);
        return this;
    }

    public final zzne zzc(int i) throws GeneralSecurityException {
        this.zzb = Integer.valueOf(i);
        return this;
    }

    public final zzne zzd(zzng zzng) {
        this.zzd = zzng;
        return this;
    }

    public final zzni zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size is not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("tag size is not set");
        } else if (this.zzc == null) {
            throw new GeneralSecurityException("hash type is not set");
        } else if (this.zzd == null) {
            throw new GeneralSecurityException("variant is not set");
        } else if (num.intValue() >= 16) {
            int intValue = this.zzb.intValue();
            zznf zznf = this.zzc;
            if (intValue >= 10) {
                if (zznf == zznf.zza) {
                    if (intValue > 20) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zznf == zznf.zzb) {
                    if (intValue > 28) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zznf == zznf.zzc) {
                    if (intValue > 32) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zznf == zznf.zzd) {
                    if (intValue > 48) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zznf != zznf.zze) {
                    throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
                } else if (intValue > 64) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", new Object[]{Integer.valueOf(intValue)}));
                }
                return new zzni(this.zza.intValue(), this.zzb.intValue(), this.zzd, this.zzc, (zznh) null);
            }
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", new Object[]{Integer.valueOf(intValue)}));
        } else {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", new Object[]{this.zza}));
        }
    }
}
