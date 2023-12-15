package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzsz extends zzagg implements zzahq {
    private zzsz() {
        super(zztc.zzb);
    }

    public final int zza() {
        return ((zztc) this.zza).zza();
    }

    public final zzsz zzb(zztb zztb) {
        zzm();
        zztc.zzk((zztc) this.zza, zztb);
        return this;
    }

    public final zzsz zzc(int i) {
        zzm();
        ((zztc) this.zza).zzd = i;
        return this;
    }

    public final zztb zzd(int i) {
        return ((zztc) this.zza).zzd(i);
    }

    public final List zze() {
        return Collections.unmodifiableList(((zztc) this.zza).zzh());
    }

    /* synthetic */ zzsz(zzsy zzsy) {
        super(zztc.zzb);
    }
}
