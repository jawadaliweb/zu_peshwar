package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzlq {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;
    /* access modifiers changed from: private */
    public final Map zzc;
    /* access modifiers changed from: private */
    public final Map zzd;

    public zzlq() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public final zzlq zza(zzkc zzkc) throws GeneralSecurityException {
        zzls zzls = new zzls(zzkc.zzd(), zzkc.zzc(), (zzlr) null);
        if (this.zzb.containsKey(zzls)) {
            zzkc zzkc2 = (zzkc) this.zzb.get(zzls);
            if (!zzkc2.equals(zzkc) || !zzkc.equals(zzkc2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzls.toString()));
            }
        } else {
            this.zzb.put(zzls, zzkc);
        }
        return this;
    }

    public final zzlq zzb(zzkg zzkg) throws GeneralSecurityException {
        zzlu zzlu = new zzlu(zzkg.zzb(), zzkg.zzc(), (zzlt) null);
        if (this.zza.containsKey(zzlu)) {
            zzkg zzkg2 = (zzkg) this.zza.get(zzlu);
            if (!zzkg2.equals(zzkg) || !zzkg.equals(zzkg2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzlu.toString()));
            }
        } else {
            this.zza.put(zzlu, zzkg);
        }
        return this;
    }

    public final zzlq zzc(zzkx zzkx) throws GeneralSecurityException {
        zzls zzls = new zzls(zzkx.zzc(), zzkx.zzb(), (zzlr) null);
        if (this.zzd.containsKey(zzls)) {
            zzkx zzkx2 = (zzkx) this.zzd.get(zzls);
            if (!zzkx2.equals(zzkx) || !zzkx.equals(zzkx2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzls.toString()));
            }
        } else {
            this.zzd.put(zzls, zzkx);
        }
        return this;
    }

    public final zzlq zzd(zzlb zzlb) throws GeneralSecurityException {
        zzlu zzlu = new zzlu(zzlb.zzb(), zzlb.zzc(), (zzlt) null);
        if (this.zzc.containsKey(zzlu)) {
            zzlb zzlb2 = (zzlb) this.zzc.get(zzlu);
            if (!zzlb2.equals(zzlb) || !zzlb.equals(zzlb2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzlu.toString()));
            }
        } else {
            this.zzc.put(zzlu, zzlb);
        }
        return this;
    }

    public zzlq(zzlw zzlw) {
        this.zza = new HashMap(zzlw.zza);
        this.zzb = new HashMap(zzlw.zzb);
        this.zzc = new HashMap(zzlw.zzc);
        this.zzd = new HashMap(zzlw.zzd);
    }
}
