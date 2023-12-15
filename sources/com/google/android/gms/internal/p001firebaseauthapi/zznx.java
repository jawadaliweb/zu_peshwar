package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zznx {
    private HashMap zza = new HashMap();

    public final zznz zza() {
        if (this.zza != null) {
            zznz zznz = new zznz(Collections.unmodifiableMap(this.zza), (zzny) null);
            this.zza = null;
            return zznz;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
