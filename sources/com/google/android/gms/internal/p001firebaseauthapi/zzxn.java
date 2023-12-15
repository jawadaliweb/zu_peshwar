package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzxn implements zzabl {
    final /* synthetic */ zzaae zza;
    final /* synthetic */ zzyh zzb;

    zzxn(zzyh zzyh, zzaae zzaae) {
        this.zzb = zzyh;
        this.zza = zzaae;
    }

    public final void zza(String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaeg zzaeg = (zzaeg) obj;
        this.zzb.zzQ(new zzade(zzaeg.zzd(), zzaeg.zzc(), Long.valueOf(zzaeg.zzb()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzaeg.zze()), (zze) null, this.zza, this);
    }
}
