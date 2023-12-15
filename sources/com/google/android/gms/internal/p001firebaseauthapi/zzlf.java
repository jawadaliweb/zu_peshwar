package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public abstract class zzlf {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzlf(Class cls, Class cls2, zzle zzle) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzlf zzb(zzld zzld, Class cls, Class cls2) {
        return new zzlc(cls, cls2, zzld);
    }

    public abstract Object zza(zzbl zzbl) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
