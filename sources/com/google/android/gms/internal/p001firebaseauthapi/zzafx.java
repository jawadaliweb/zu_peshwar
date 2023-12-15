package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzafx {
    static final zzafx zza = new zzafx(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private final Map zzd;

    zzafx() {
        this.zzd = new HashMap();
    }

    public static zzafx zza() {
        return zza;
    }

    public final zzagi zzb(zzahp zzahp, int i) {
        return (zzagi) this.zzd.get(new zzafw(zzahp, i));
    }

    zzafx(boolean z) {
        this.zzd = Collections.emptyMap();
    }
}
