package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzya  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzya implements zzabl {
    final /* synthetic */ zzaae zza;
    final /* synthetic */ zzyh zzb;

    zzya(zzyh zzyh, zzaae zzaae) {
        this.zzb = zzyh;
        this.zza = zzaae;
    }

    public final void zza(String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaee zzaee = (zzaee) obj;
        if (!zzaee.zzm()) {
            zzyh.zzd(this.zzb, zzaee, this.zza, this);
        } else {
            this.zza.zzf(new zzwn(zzaee.zzg(), zzaee.zzl(), zzaee.zzc()));
        }
    }
}
