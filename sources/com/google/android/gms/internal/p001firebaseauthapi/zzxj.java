package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzxj implements zzabl {
    final /* synthetic */ String zza;
    final /* synthetic */ zzaae zzb;
    final /* synthetic */ zzyh zzc;

    zzxj(zzyh zzyh, String str, zzaae zzaae) {
        this.zzc = zzyh;
        this.zza = str;
        this.zzb = zzaae;
    }

    public final void zza(String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzade zzade = (zzade) obj;
        this.zzc.zza.zze(new zzact(zzade.zze()), new zzxi(this, this, zzade));
    }
}
