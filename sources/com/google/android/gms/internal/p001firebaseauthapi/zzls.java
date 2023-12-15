package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzls  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzls {
    private final Class zza;
    private final zzvx zzb;

    /* synthetic */ zzls(Class cls, zzvx zzvx, zzlr zzlr) {
        this.zza = cls;
        this.zzb = zzvx;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzls)) {
            return false;
        }
        zzls zzls = (zzls) obj;
        if (!zzls.zza.equals(this.zza) || !zzls.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        String valueOf = String.valueOf(this.zzb);
        return simpleName + ", object identifier: " + valueOf;
    }
}
