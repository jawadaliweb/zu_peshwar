package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzhm {
    @Nullable
    private zzhw zza = null;
    @Nullable
    private zzvy zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzhm() {
    }

    /* synthetic */ zzhm(zzhl zzhl) {
    }

    public final zzhm zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzhm zzb(zzvy zzvy) {
        this.zzb = zzvy;
        return this;
    }

    public final zzhm zzc(zzhw zzhw) {
        this.zza = zzhw;
        return this;
    }

    public final zzho zzd() throws GeneralSecurityException {
        zzvy zzvy;
        zzvx zzb2;
        zzhw zzhw = this.zza;
        if (zzhw == null || (zzvy = this.zzb) == null) {
            throw new IllegalArgumentException("Cannot build without parameters and/or key material");
        } else if (zzhw.zza() != zzvy.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzhw.zzc() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zzc() || this.zzc == null) {
            if (this.zza.zzb() == zzhu.zzc) {
                zzb2 = zzvx.zzb(new byte[0]);
            } else if (this.zza.zzb() == zzhu.zzb) {
                zzb2 = zzvx.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzb() == zzhu.zza) {
                zzb2 = zzvx.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesSivParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzb()))));
            }
            return new zzho(this.zza, this.zzb, zzb2, this.zzc, (zzhn) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
