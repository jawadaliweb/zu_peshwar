package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
final class zzgi implements Callable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzgw zzd;

    zzgi(zzgw zzgw, String str, String str2, String str3) {
        this.zzd = zzgw;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        this.zzd.zza.zzA();
        return this.zzd.zza.zzi().zzv(this.zza, this.zzb, this.zzc);
    }
}
