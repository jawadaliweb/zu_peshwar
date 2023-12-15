package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.CheckForNull;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzal  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzal extends zzam {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzam zzc;

    zzal(zzam zzam, int i, int i2) {
        this.zzc = zzam;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzu.zza(i, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final Object[] zze() {
        return this.zzc.zze();
    }

    public final zzam zzf(int i, int i2) {
        zzu.zzc(i, i2, this.zzb);
        zzam zzam = this.zzc;
        int i3 = this.zza;
        return zzam.subList(i + i3, i2 + i3);
    }
}
