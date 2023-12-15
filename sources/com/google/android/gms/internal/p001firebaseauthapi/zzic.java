package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzic  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzic {
    public static final String zza = "type.googleapis.com/google.crypto.tink.AesSivKey";
    @Deprecated
    static final zzty zzb = zzty.zzb();
    @Deprecated
    static final zzty zzc = zzty.zzb();

    static {
        new zzhr();
        try {
            zzig.zze();
            if (!zzhk.zzb()) {
                zzcq.zzi(new zzhr(), true);
                int i = zzib.zza;
                zzib.zzb(zzkt.zzb());
            }
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
