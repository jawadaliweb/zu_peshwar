package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzbv {
    public static zzbu zza(String str) throws GeneralSecurityException {
        zzbu zzbu = (zzbu) zzcq.zzg().get(str);
        if (zzbu != null) {
            return zzbu;
        }
        throw new GeneralSecurityException("cannot find key template: ".concat(str));
    }
}
