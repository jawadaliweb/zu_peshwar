package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzwq implements zzabl {
    final /* synthetic */ EmailAuthCredential zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzaae zzc;
    final /* synthetic */ zzyh zzd;

    zzwq(zzyh zzyh, EmailAuthCredential emailAuthCredential, String str, zzaae zzaae) {
        this.zzd = zzyh;
        this.zza = emailAuthCredential;
        this.zzb = str;
        this.zzc = zzaae;
    }

    public final void zza(String str) {
        this.zzc.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzd.zzP(new zzacl(this.zza, ((zzade) obj).zze(), this.zzb), this.zzc);
    }
}
