package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxe  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzxe implements zzabl {
    final /* synthetic */ zzaej zza;
    final /* synthetic */ zzaae zzb;
    final /* synthetic */ zzyh zzc;

    zzxe(zzyh zzyh, zzaej zzaej, zzaae zzaae) {
        this.zzc = zzyh;
        this.zza = zzaej;
        this.zzb = zzaae;
    }

    public final void zza(String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zza.zzd(((zzade) obj).zze());
        this.zzc.zza.zzs(this.zza, new zzxd(this, this));
    }
}
