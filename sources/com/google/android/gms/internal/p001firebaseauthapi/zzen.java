package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzen  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzen {
    @Nullable
    private zzex zza = null;
    @Nullable
    private zzvy zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzen() {
    }

    /* synthetic */ zzen(zzem zzem) {
    }

    public final zzen zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzen zzb(zzvy zzvy) {
        this.zzb = zzvy;
        return this;
    }

    public final zzen zzc(zzex zzex) {
        this.zza = zzex;
        return this;
    }

    public final zzep zzd() throws GeneralSecurityException {
        zzvy zzvy;
        zzvx zzb2;
        zzex zzex = this.zza;
        if (zzex == null || (zzvy = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzex.zza() != zzvy.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzex.zzc() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zzc() || this.zzc == null) {
            if (this.zza.zzb() == zzev.zzc) {
                zzb2 = zzvx.zzb(new byte[0]);
            } else if (this.zza.zzb() == zzev.zzb) {
                zzb2 = zzvx.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzb() == zzev.zza) {
                zzb2 = zzvx.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzb()))));
            }
            return new zzep(this.zza, this.zzb, zzb2, this.zzc, (zzeo) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
