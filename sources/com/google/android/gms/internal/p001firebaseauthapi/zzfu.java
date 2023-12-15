package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzfu extends zzcu {
    private final zzfz zza;
    private final zzvy zzb;
    private final zzvx zzc;
    @Nullable
    private final Integer zzd;

    private zzfu(zzfz zzfz, zzvy zzvy, zzvx zzvx, @Nullable Integer num) {
        this.zza = zzfz;
        this.zzb = zzvy;
        this.zzc = zzvx;
        this.zzd = num;
    }

    public static zzfu zza(zzfy zzfy, zzvy zzvy, @Nullable Integer num) throws GeneralSecurityException {
        zzvx zzvx;
        zzfy zzfy2 = zzfy.zzc;
        if (zzfy != zzfy2 && num == null) {
            String obj = zzfy.toString();
            throw new GeneralSecurityException("For given Variant " + obj + " the value of idRequirement must be non-null");
        } else if (zzfy == zzfy2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (zzvy.zza() == 32) {
            zzfz zzb2 = zzfz.zzb(zzfy);
            if (zzb2.zza() == zzfy2) {
                zzvx = zzvx.zzb(new byte[0]);
            } else if (zzb2.zza() == zzfy.zzb) {
                zzvx = zzvx.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
            } else if (zzb2.zza() == zzfy.zza) {
                zzvx = zzvx.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown Variant: ".concat(zzb2.zza().toString()));
            }
            return new zzfu(zzb2, zzvy, zzvx, num);
        } else {
            int zza2 = zzvy.zza();
            throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zza2);
        }
    }
}
