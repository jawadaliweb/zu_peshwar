package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzahx {
    private static final zzahx zza = new zzahx();
    private final zzaic zzb = new zzahh();
    private final ConcurrentMap zzc = new ConcurrentHashMap();

    private zzahx() {
    }

    public static zzahx zza() {
        return zza;
    }

    public final zzaib zzb(Class cls) {
        zzagq.zzc(cls, "messageType");
        zzaib zzaib = (zzaib) this.zzc.get(cls);
        if (zzaib == null) {
            zzaib = this.zzb.zza(cls);
            zzagq.zzc(cls, "messageType");
            zzagq.zzc(zzaib, "schema");
            zzaib zzaib2 = (zzaib) this.zzc.putIfAbsent(cls, zzaib);
            return zzaib2 == null ? zzaib : zzaib2;
        }
    }
}
