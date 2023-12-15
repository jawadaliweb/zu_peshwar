package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzmw {
    @Nullable
    private zzni zza = null;
    @Nullable
    private zzvy zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzmw() {
    }

    /* synthetic */ zzmw(zzmv zzmv) {
    }

    public final zzmw zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzmw zzb(zzvy zzvy) {
        this.zzb = zzvy;
        return this;
    }

    public final zzmw zzc(zzni zzni) {
        this.zza = zzni;
        return this;
    }

    public final zzmy zzd() throws GeneralSecurityException {
        zzvy zzvy;
        zzvx zzb2;
        zzni zzni = this.zza;
        if (zzni == null || (zzvy = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzni.zza() != zzvy.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzni.zzd() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zzd() || this.zzc == null) {
            if (this.zza.zzc() == zzng.zzd) {
                zzb2 = zzvx.zzb(new byte[0]);
            } else if (this.zza.zzc() == zzng.zzc || this.zza.zzc() == zzng.zzb) {
                zzb2 = zzvx.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzc() == zzng.zza) {
                zzb2 = zzvx.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown HmacParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzc()))));
            }
            return new zzmy(this.zza, this.zzb, zzb2, this.zzc, (zzmx) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
