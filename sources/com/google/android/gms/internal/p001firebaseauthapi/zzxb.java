package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzxb implements zzabl {
    final /* synthetic */ zzaae zza;
    final /* synthetic */ zzyh zzb;

    zzxb(zzyh zzyh, zzaae zzaae) {
        this.zzb = zzyh;
        this.zza = zzaae;
    }

    public final void zza(String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaek zzaek = (zzaek) obj;
        this.zzb.zzQ(new zzade(zzaek.zze(), zzaek.zzc(), Long.valueOf(zzaek.zzb()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzaek.zzg()), (zze) null, this.zza, this);
    }
}
