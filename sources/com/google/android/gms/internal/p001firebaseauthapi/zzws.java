package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzws  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzws implements zzabl {
    final /* synthetic */ zzabk zza;
    final /* synthetic */ zzaae zzb;
    final /* synthetic */ zzade zzc;
    final /* synthetic */ zzadq zzd;
    final /* synthetic */ zzyh zze;

    zzws(zzyh zzyh, zzabk zzabk, zzaae zzaae, zzade zzade, zzadq zzadq) {
        this.zze = zzyh;
        this.zza = zzabk;
        this.zzb = zzaae;
        this.zzc = zzade;
        this.zzd = zzadq;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List zzb2 = ((zzacu) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users");
        } else {
            zzyh.zzf(this.zze, this.zzb, this.zzc, (zzacv) zzb2.get(0), this.zzd, this.zza);
        }
    }
}
