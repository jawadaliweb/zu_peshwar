package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
final class zzla implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb = "_err";
    final /* synthetic */ Bundle zzc;
    final /* synthetic */ zzlb zzd;

    zzla(zzlb zzlb, String str, String str2, Bundle bundle) {
        this.zzd = zzlb;
        this.zza = str;
        this.zzc = bundle;
    }

    public final void run() {
        this.zzd.zza.zzF((zzaw) Preconditions.checkNotNull(this.zzd.zza.zzv().zzz(this.zza, this.zzb, this.zzc, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, this.zzd.zza.zzax().currentTimeMillis(), false, true)), this.zza);
    }
}
