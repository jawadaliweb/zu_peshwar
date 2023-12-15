package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzyd implements zzabl {
    final /* synthetic */ String zza;
    final /* synthetic */ zzaae zzb;
    final /* synthetic */ zzyh zzc;

    zzyd(zzyh zzyh, String str, zzaae zzaae) {
        this.zzc = zzyh;
        this.zza = str;
        this.zzb = zzaae;
    }

    public final void zza(String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzade zzade = (zzade) obj;
        zzadq zzadq = new zzadq();
        zzadq.zze(zzade.zze());
        zzadq.zzd(this.zza);
        zzyh.zze(this.zzc, this.zzb, zzade, zzadq, this);
    }
}
