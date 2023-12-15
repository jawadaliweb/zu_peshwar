package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzmu implements zzcm {
    private static final zzmu zza = new zzmu();

    private zzmu() {
    }

    static void zzd() throws GeneralSecurityException {
        zzcq.zzj(zza);
    }

    public final Class zza() {
        return zzmr.class;
    }

    public final Class zzb() {
        return zzmr.class;
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzcl zzcl) throws GeneralSecurityException {
        if (zzcl.zza() != null) {
            for (List<zzch> it : zzcl.zzd()) {
                for (zzch zzd : it) {
                    zzd.zzd();
                }
            }
            return new zzmt(zzcl, (zzms) null);
        }
        throw new GeneralSecurityException("no primary in primitive set");
    }
}
