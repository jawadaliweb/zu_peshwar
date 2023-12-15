package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzwr implements zzabl {
    final /* synthetic */ zzaae zza;
    final /* synthetic */ zzyh zzb;

    zzwr(zzyh zzyh, zzaae zzaae) {
        this.zzb = zzyh;
        this.zza = zzaae;
    }

    public final void zza(String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzacm zzacm = (zzacm) obj;
        if (zzacm.zzg()) {
            this.zza.zzf(new zzwn(zzacm.zzd(), zzacm.zzf(), (zze) null));
            return;
        }
        this.zzb.zzQ(new zzade(zzacm.zze(), zzacm.zzc(), Long.valueOf(zzacm.zzb()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzacm.zzh()), (zze) null, this.zza, this);
    }
}
