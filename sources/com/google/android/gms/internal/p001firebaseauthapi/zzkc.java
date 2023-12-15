package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public abstract class zzkc {
    private final zzvx zza;
    private final Class zzb;

    /* synthetic */ zzkc(zzvx zzvx, Class cls, zzkb zzkb) {
        this.zza = zzvx;
        this.zzb = cls;
    }

    public static zzkc zzb(zzka zzka, zzvx zzvx, Class cls) {
        return new zzjz(zzvx, cls, zzka);
    }

    public abstract zzbl zza(zzlp zzlp, @Nullable zzcr zzcr) throws GeneralSecurityException;

    public final zzvx zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
