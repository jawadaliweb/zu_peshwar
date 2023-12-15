package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzdb {
    @Nullable
    private zzdm zza = null;
    @Nullable
    private zzvy zzb = null;
    @Nullable
    private zzvy zzc = null;
    @Nullable
    private Integer zzd = null;

    private zzdb() {
    }

    /* synthetic */ zzdb(zzda zzda) {
    }

    public final zzdb zza(zzvy zzvy) {
        this.zzb = zzvy;
        return this;
    }

    public final zzdb zzb(zzvy zzvy) {
        this.zzc = zzvy;
        return this;
    }

    public final zzdb zzc(@Nullable Integer num) {
        this.zzd = num;
        return this;
    }

    public final zzdb zzd(zzdm zzdm) {
        this.zza = zzdm;
        return this;
    }

    public final zzdd zze() throws GeneralSecurityException {
        zzvx zzb2;
        zzdm zzdm = this.zza;
        if (zzdm != null) {
            zzvy zzvy = this.zzb;
            if (zzvy == null || this.zzc == null) {
                throw new GeneralSecurityException("Cannot build without key material");
            } else if (zzdm.zza() != zzvy.zza()) {
                throw new GeneralSecurityException("AES key size mismatch");
            } else if (zzdm.zzb() != this.zzc.zza()) {
                throw new GeneralSecurityException("HMAC key size mismatch");
            } else if (this.zza.zzd() && this.zzd == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zzd() || this.zzd == null) {
                if (this.zza.zzc() == zzdk.zzc) {
                    zzb2 = zzvx.zzb(new byte[0]);
                } else if (this.zza.zzc() == zzdk.zzb) {
                    zzb2 = zzvx.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzd.intValue()).array());
                } else if (this.zza.zzc() == zzdk.zza) {
                    zzb2 = zzvx.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzd.intValue()).array());
                } else {
                    throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzc()))));
                }
                return new zzdd(this.zza, this.zzb, this.zzc, zzb2, this.zzd, (zzdc) null);
            } else {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
        } else {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
    }
}
