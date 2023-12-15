package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzlh {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;

    public zzlh() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zzlh zza(zzlf zzlf) throws GeneralSecurityException {
        zzlj zzlj = new zzlj(zzlf.zzc(), zzlf.zzd(), (zzli) null);
        if (this.zza.containsKey(zzlj)) {
            zzlf zzlf2 = (zzlf) this.zza.get(zzlj);
            if (!zzlf2.equals(zzlf) || !zzlf.equals(zzlf2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ".concat(zzlj.toString()));
            }
        } else {
            this.zza.put(zzlj, zzlf);
        }
        return this;
    }

    public final zzlh zzb(zzcm zzcm) throws GeneralSecurityException {
        Objects.requireNonNull(zzcm, "wrapper must be non-null");
        Map map = this.zzb;
        Class zzb2 = zzcm.zzb();
        if (map.containsKey(zzb2)) {
            zzcm zzcm2 = (zzcm) this.zzb.get(zzb2);
            if (!zzcm2.equals(zzcm) || !zzcm.equals(zzcm2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type".concat(zzb2.toString()));
            }
        } else {
            this.zzb.put(zzb2, zzcm);
        }
        return this;
    }

    public zzlh(zzll zzll) {
        this.zza = new HashMap(zzll.zza);
        this.zzb = new HashMap(zzll.zzb);
    }
}
