package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzll  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzll {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;

    /* synthetic */ zzll(zzlh zzlh, zzlk zzlk) {
        this.zza = new HashMap(zzlh.zza);
        this.zzb = new HashMap(zzlh.zzb);
    }

    public final Class zza(Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            return ((zzcm) this.zzb.get(cls)).zza();
        }
        String obj = cls.toString();
        throw new GeneralSecurityException("No input primitive class for " + obj + " available");
    }

    public final Object zzb(zzbl zzbl, Class cls) throws GeneralSecurityException {
        zzlj zzlj = new zzlj(zzbl.getClass(), cls, (zzli) null);
        if (this.zza.containsKey(zzlj)) {
            return ((zzlf) this.zza.get(zzlj)).zza(zzbl);
        }
        String obj = zzlj.toString();
        throw new GeneralSecurityException("No PrimitiveConstructor for " + obj + " available");
    }

    public final Object zzc(zzcl zzcl, Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            zzcm zzcm = (zzcm) this.zzb.get(cls);
            if (zzcl.zzc().equals(zzcm.zza()) && zzcm.zza().equals(zzcl.zzc())) {
                return zzcm.zzc(zzcl);
            }
            throw new GeneralSecurityException("Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet");
        }
        throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
    }
}
