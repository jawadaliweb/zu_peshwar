package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzuq implements zzbk {
    private final zzus zza;
    private final String zzb;
    private final byte[] zzc;
    private final zzuo zzd;

    public zzuq(ECPublicKey eCPublicKey, byte[] bArr, String str, int i, zzuo zzuo) throws GeneralSecurityException {
        zzjx.zzb(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.zza = new zzus(eCPublicKey);
        this.zzc = bArr;
        this.zzb = str;
        this.zzd = zzuo;
    }
}
