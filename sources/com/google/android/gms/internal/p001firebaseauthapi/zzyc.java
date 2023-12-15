package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzyc implements zzabl {
    final /* synthetic */ UserProfileChangeRequest zza;
    final /* synthetic */ zzaae zzb;
    final /* synthetic */ zzyh zzc;

    zzyc(zzyh zzyh, UserProfileChangeRequest userProfileChangeRequest, zzaae zzaae) {
        this.zzc = zzyh;
        this.zza = userProfileChangeRequest;
        this.zzb = zzaae;
    }

    public final void zza(String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzade zzade = (zzade) obj;
        zzadq zzadq = new zzadq();
        zzadq.zze(zzade.zze());
        if (this.zza.zzb() || this.zza.getDisplayName() != null) {
            zzadq.zzc(this.zza.getDisplayName());
        }
        if (this.zza.zzc() || this.zza.getPhotoUri() != null) {
            zzadq.zzh(this.zza.zza());
        }
        zzyh.zze(this.zzc, this.zzb, zzade, zzadq, this);
    }
}
