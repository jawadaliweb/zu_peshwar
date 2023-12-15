package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzko  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzko {
    public static final zzoa zza = new zzkn((zzkm) null);

    public static zzog zza(zzcl zzcl) {
        zzbt zzbt;
        zzoc zzoc = new zzoc();
        zzoc.zzb(zzcl.zzb());
        for (List it : zzcl.zzd()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    zzch zzch = (zzch) it2.next();
                    int zzh = zzch.zzh() - 2;
                    if (zzh == 1) {
                        zzbt = zzbt.zza;
                    } else if (zzh == 2) {
                        zzbt = zzbt.zzb;
                    } else if (zzh == 3) {
                        zzbt = zzbt.zzc;
                    } else {
                        throw new IllegalStateException("Unknown key status");
                    }
                    int zza2 = zzch.zza();
                    String zzf = zzch.zzf();
                    if (zzf.startsWith("type.googleapis.com/google.crypto.")) {
                        zzf = zzf.substring(34);
                    }
                    zzoc.zza(zzbt, zza2, zzf, zzch.zzc().name());
                }
            }
        }
        if (zzcl.zza() != null) {
            zzoc.zzc(zzcl.zza().zza());
        }
        try {
            return zzoc.zzd();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
