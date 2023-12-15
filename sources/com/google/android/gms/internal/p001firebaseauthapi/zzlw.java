package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzlw {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;
    /* access modifiers changed from: private */
    public final Map zzc;
    /* access modifiers changed from: private */
    public final Map zzd;

    /* synthetic */ zzlw(zzlq zzlq, zzlv zzlv) {
        this.zza = new HashMap(zzlq.zza);
        this.zzb = new HashMap(zzlq.zzb);
        this.zzc = new HashMap(zzlq.zzc);
        this.zzd = new HashMap(zzlq.zzd);
    }

    public final zzbl zza(zzlp zzlp, @Nullable zzcr zzcr) throws GeneralSecurityException {
        zzls zzls = new zzls(zzlp.getClass(), zzlp.zzd(), (zzlr) null);
        if (this.zzb.containsKey(zzls)) {
            return ((zzkc) this.zzb.get(zzls)).zza(zzlp, zzcr);
        }
        String obj = zzls.toString();
        throw new GeneralSecurityException("No Key Parser for requested key type " + obj + " available");
    }

    public final boolean zzf(zzlp zzlp) {
        return this.zzb.containsKey(new zzls(zzlp.getClass(), zzlp.zzd(), (zzlr) null));
    }
}
