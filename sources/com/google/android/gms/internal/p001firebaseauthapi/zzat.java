package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzat  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzat extends zzam {
    final /* synthetic */ zzau zza;

    zzat(zzau zzau) {
        this.zza = zzau;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzu.zza(i, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        zzau zzau = this.zza;
        int i2 = i + i;
        Object obj = zzau.zzb[i2];
        obj.getClass();
        Object obj2 = zzau.zzb[i2 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }
}
