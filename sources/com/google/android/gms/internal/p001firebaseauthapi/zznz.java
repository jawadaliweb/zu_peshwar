package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zznz {
    public static final zznz zza = new zznx().zza();
    private final Map zzb;

    /* synthetic */ zznz(Map map, zzny zzny) {
        this.zzb = map;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zznz)) {
            return false;
        }
        return this.zzb.equals(((zznz) obj).zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        return this.zzb.toString();
    }

    public final Map zza() {
        return this.zzb;
    }
}
