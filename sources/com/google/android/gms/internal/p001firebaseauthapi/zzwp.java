package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzwp implements zzabl {
    final /* synthetic */ zzaae zza;
    final /* synthetic */ zzyh zzb;

    zzwp(zzyh zzyh, zzaae zzaae) {
        this.zzb = zzyh;
        this.zza = zzaae;
    }

    public final void zza(String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaei zzaei = (zzaei) obj;
        if (zzaei.zzg()) {
            this.zza.zzf(new zzwn(zzaei.zzd(), zzaei.zzf(), (zze) null));
            return;
        }
        this.zzb.zzQ(new zzade(zzaei.zze(), zzaei.zzc(), Long.valueOf(zzaei.zzb()), "Bearer"), (String) null, (String) null, false, (zze) null, this.zza, this);
    }
}
