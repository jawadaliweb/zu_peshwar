package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzlj {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzlj(Class cls, Class cls2, zzli zzli) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzlj)) {
            return false;
        }
        zzlj zzlj = (zzlj) obj;
        if (!zzlj.zza.equals(this.zza) || !zzlj.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        String simpleName2 = this.zzb.getSimpleName();
        return simpleName + " with primitive type: " + simpleName2;
    }
}
