package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzdw {
    @Nullable
    private zzeg zza = null;
    @Nullable
    private zzvy zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzdw() {
    }

    /* synthetic */ zzdw(zzdv zzdv) {
    }

    public final zzdw zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzdw zzb(zzvy zzvy) {
        this.zzb = zzvy;
        return this;
    }

    public final zzdw zzc(zzeg zzeg) {
        this.zza = zzeg;
        return this;
    }

    public final zzdy zzd() throws GeneralSecurityException {
        zzvy zzvy;
        zzvx zzb2;
        zzeg zzeg = this.zza;
        if (zzeg == null || (zzvy = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzeg.zza() != zzvy.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzeg.zzc() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zzc() || this.zzc == null) {
            if (this.zza.zzb() == zzee.zzc) {
                zzb2 = zzvx.zzb(new byte[0]);
            } else if (this.zza.zzb() == zzee.zzb) {
                zzb2 = zzvx.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzb() == zzee.zza) {
                zzb2 = zzvx.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzb()))));
            }
            return new zzdy(this.zza, this.zzb, zzb2, this.zzc, (zzdx) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
