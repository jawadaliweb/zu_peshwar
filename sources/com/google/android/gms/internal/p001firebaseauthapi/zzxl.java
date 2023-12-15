package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzxl implements zzabl {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzaae zzc;
    final /* synthetic */ zzyh zzd;

    zzxl(zzyh zzyh, String str, String str2, zzaae zzaae) {
        this.zzd = zzyh;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzaae;
    }

    public final void zza(String str) {
        this.zzc.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzd.zza.zzt(new zzael(((zzade) obj).zze(), this.zza, this.zzb), new zzxk(this));
    }
}
