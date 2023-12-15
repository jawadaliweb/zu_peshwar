package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzna  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzna extends zzlg {
    zzna(Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ Object zza(zzahp zzahp) throws GeneralSecurityException {
        zzrq zzrq = (zzrq) zzahp;
        int zzf = zzrq.zzf().zzf();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzrq.zzg().zzq(), "HMAC");
        int zza = zzrq.zzf().zza();
        int i = zzf - 2;
        if (i == 1) {
            return new zzvq(new zzvp("HMACSHA1", secretKeySpec), zza);
        }
        if (i == 2) {
            return new zzvq(new zzvp("HMACSHA384", secretKeySpec), zza);
        }
        if (i == 3) {
            return new zzvq(new zzvp("HMACSHA256", secretKeySpec), zza);
        }
        if (i == 4) {
            return new zzvq(new zzvp("HMACSHA512", secretKeySpec), zza);
        }
        if (i == 5) {
            return new zzvq(new zzvp("HMACSHA224", secretKeySpec), zza);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
