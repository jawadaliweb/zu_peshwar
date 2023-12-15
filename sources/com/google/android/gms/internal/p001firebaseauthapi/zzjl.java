package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzjl implements zzjc {
    private final zzvx zza;
    private final zzvx zzb;

    private zzjl(byte[] bArr, byte[] bArr2) {
        this.zza = zzvx.zzb(bArr);
        this.zzb = zzvx.zzb(bArr2);
    }

    static zzjl zzc(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        zzut.zzd(zzut.zzh(zzut.zzi(i), 1, bArr2), zzut.zzg(i, bArr));
        return new zzjl(bArr, bArr2);
    }

    public final zzvx zza() {
        return this.zza;
    }

    public final zzvx zzb() {
        return this.zzb;
    }
}
