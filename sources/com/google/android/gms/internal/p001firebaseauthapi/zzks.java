package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzks  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzks {
    private static final zzks zza = new zzks();
    private final AtomicReference zzb = new AtomicReference(new zzll(new zzlh(), (zzlk) null));

    zzks() {
    }

    public static zzks zza() {
        return zza;
    }

    public final Class zzb(Class cls) throws GeneralSecurityException {
        return ((zzll) this.zzb.get()).zza(cls);
    }

    public final Object zzc(zzbl zzbl, Class cls) throws GeneralSecurityException {
        return ((zzll) this.zzb.get()).zzb(zzbl, cls);
    }

    public final Object zzd(zzcl zzcl, Class cls) throws GeneralSecurityException {
        return ((zzll) this.zzb.get()).zzc(zzcl, cls);
    }

    public final synchronized void zze(zzlf zzlf) throws GeneralSecurityException {
        zzlh zzlh = new zzlh((zzll) this.zzb.get());
        zzlh.zza(zzlf);
        this.zzb.set(new zzll(zzlh, (zzlk) null));
    }

    public final synchronized void zzf(zzcm zzcm) throws GeneralSecurityException {
        zzlh zzlh = new zzlh((zzll) this.zzb.get());
        zzlh.zzb(zzcm);
        this.zzb.set(new zzll(zzlh, (zzlk) null));
    }
}
