package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzjn implements zzjc {
    private final zzvx zza;
    private final zzvx zzb;

    private zzjn(byte[] bArr, byte[] bArr2) {
        this.zza = zzvx.zzb(bArr);
        this.zzb = zzvx.zzb(bArr2);
    }

    static zzjn zzc(byte[] bArr) throws GeneralSecurityException {
        return new zzjn(bArr, zzvv.zzb(bArr));
    }

    public final zzvx zza() {
        return this.zza;
    }

    public final zzvx zzb() {
        return this.zzb;
    }
}
