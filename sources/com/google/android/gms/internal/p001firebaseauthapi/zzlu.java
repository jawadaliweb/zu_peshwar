package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzlu {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzlu(Class cls, Class cls2, zzlt zzlt) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzlu)) {
            return false;
        }
        zzlu zzlu = (zzlu) obj;
        if (!zzlu.zza.equals(this.zza) || !zzlu.zzb.equals(this.zzb)) {
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
        return simpleName + " with serialization type: " + simpleName2;
    }
}
