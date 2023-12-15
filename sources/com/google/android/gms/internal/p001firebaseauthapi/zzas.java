package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzas  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzas extends zzam {
    static final zzam zza = new zzas(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzas(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    public final Object get(int i) {
        zzu.zza(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        Object obj = this.zzb[i];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzb;
    }
}
