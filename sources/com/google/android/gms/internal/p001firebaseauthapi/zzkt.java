package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzkt {
    private static final zzkt zza = new zzkt();
    private final AtomicReference zzb = new AtomicReference(new zzlw(new zzlq(), (zzlv) null));

    public static zzkt zzb() {
        return zza;
    }

    public final zzbl zza(zzln zzln, zzcr zzcr) throws GeneralSecurityException {
        if (((zzlw) this.zzb.get()).zzf(zzln)) {
            return ((zzlw) this.zzb.get()).zza(zzln, zzcr);
        }
        try {
            return new zzkl(zzln, zzcr);
        } catch (GeneralSecurityException e) {
            throw new zzlx("Creating a LegacyProtoKey failed", e);
        }
    }

    public final synchronized void zzc(zzkc zzkc) throws GeneralSecurityException {
        zzlq zzlq = new zzlq((zzlw) this.zzb.get());
        zzlq.zza(zzkc);
        this.zzb.set(new zzlw(zzlq, (zzlv) null));
    }

    public final synchronized void zzd(zzkg zzkg) throws GeneralSecurityException {
        zzlq zzlq = new zzlq((zzlw) this.zzb.get());
        zzlq.zzb(zzkg);
        this.zzb.set(new zzlw(zzlq, (zzlv) null));
    }

    public final synchronized void zze(zzkx zzkx) throws GeneralSecurityException {
        zzlq zzlq = new zzlq((zzlw) this.zzb.get());
        zzlq.zzc(zzkx);
        this.zzb.set(new zzlw(zzlq, (zzlv) null));
    }

    public final synchronized void zzf(zzlb zzlb) throws GeneralSecurityException {
        zzlq zzlq = new zzlq((zzlw) this.zzb.get());
        zzlq.zzd(zzlb);
        this.zzb.set(new zzlw(zzlq, (zzlv) null));
    }
}
