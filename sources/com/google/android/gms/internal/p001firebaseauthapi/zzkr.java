package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzkr {
    private static final zzkr zza = new zzkr();
    private static final zzkq zzb = new zzkq((zzkp) null);
    private final AtomicReference zzc = new AtomicReference();

    public static zzkr zza() {
        return zza;
    }

    public final zzob zzb() {
        zzob zzob = (zzob) this.zzc.get();
        return zzob == null ? zzb : zzob;
    }
}
