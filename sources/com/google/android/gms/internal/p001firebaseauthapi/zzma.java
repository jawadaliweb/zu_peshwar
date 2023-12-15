package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzma  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzma {
    @Nullable
    private zzml zza = null;
    @Nullable
    private zzvy zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzma() {
    }

    /* synthetic */ zzma(zzlz zzlz) {
    }

    public final zzma zza(zzvy zzvy) throws GeneralSecurityException {
        this.zzb = zzvy;
        return this;
    }

    public final zzma zzb(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzma zzc(zzml zzml) {
        this.zza = zzml;
        return this;
    }

    public final zzmc zzd() throws GeneralSecurityException {
        zzvy zzvy;
        zzvx zzb2;
        zzml zzml = this.zza;
        if (zzml == null || (zzvy = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzml.zza() != zzvy.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzml.zzd() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zzd() || this.zzc == null) {
            if (this.zza.zzc() == zzmj.zzd) {
                zzb2 = zzvx.zzb(new byte[0]);
            } else if (this.zza.zzc() == zzmj.zzc || this.zza.zzc() == zzmj.zzb) {
                zzb2 = zzvx.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzc() == zzmj.zza) {
                zzb2 = zzvx.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzc()))));
            }
            return new zzmc(this.zza, this.zzb, zzb2, this.zzc, (zzmb) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
