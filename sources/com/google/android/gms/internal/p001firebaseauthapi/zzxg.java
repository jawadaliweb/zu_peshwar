package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzxg implements zzabl {
    final /* synthetic */ zzaec zza;
    final /* synthetic */ zzaae zzb;
    final /* synthetic */ zzyh zzc;

    zzxg(zzyh zzyh, zzaec zzaec, zzaae zzaae) {
        this.zzc = zzyh;
        this.zza = zzaec;
        this.zzb = zzaae;
    }

    public final void zza(String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zza.zzd(true);
        this.zza.zzc(((zzade) obj).zze());
        this.zzc.zza.zzp(this.zza, new zzxf(this, this));
    }
}
