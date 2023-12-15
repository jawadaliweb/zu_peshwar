package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzja  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzja implements zzbk {
    private final zzsk zza;
    private final zzjb zzb;
    private final zzix zzc;
    private final zziw zzd;

    private zzja(zzsk zzsk, zzjb zzjb, zziw zziw, zzix zzix) {
        this.zza = zzsk;
        this.zzb = zzjb;
        this.zzd = zziw;
        this.zzc = zzix;
    }

    static zzja zza(zzsk zzsk) throws GeneralSecurityException {
        if (!zzsk.zzg().zzp()) {
            zzse zzb2 = zzsk.zzb();
            return new zzja(zzsk, zzjd.zzb(zzb2), zzjd.zzc(zzb2), zzjd.zza(zzb2));
        }
        throw new IllegalArgumentException("HpkePublicKey.public_key is empty.");
    }
}
