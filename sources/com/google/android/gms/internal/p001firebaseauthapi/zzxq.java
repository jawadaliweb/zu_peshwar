package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzxq implements zzabl {
    final /* synthetic */ zzaae zza;
    final /* synthetic */ zzyh zzb;

    zzxq(zzyh zzyh, zzaae zzaae) {
        this.zzb = zzyh;
        this.zza = zzaae;
    }

    public final void zza(String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaco zzaco = (zzaco) obj;
        this.zzb.zzQ(new zzade(zzaco.zzc(), zzaco.zzb(), Long.valueOf(zzadg.zza(zzaco.zzb())), "Bearer"), (String) null, (String) null, false, (zze) null, this.zza, this);
    }
}
