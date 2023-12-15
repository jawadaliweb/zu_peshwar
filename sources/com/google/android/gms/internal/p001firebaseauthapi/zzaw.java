package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaw extends zzam {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzaw(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    public final Object get(int i) {
        zzu.zza(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        Object obj = this.zza[i + i + this.zzb];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.zzc;
    }
}
