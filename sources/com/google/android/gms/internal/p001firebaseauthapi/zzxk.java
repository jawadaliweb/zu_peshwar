package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzxk implements zzabl {
    final /* synthetic */ zzxl zza;

    zzxk(zzxl zzxl) {
        this.zza = zzxl;
    }

    public final void zza(String str) {
        this.zza.zzc.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaem zzaem = (zzaem) obj;
        if (TextUtils.isEmpty(zzaem.zzb()) || TextUtils.isEmpty(zzaem.zzc())) {
            this.zza.zzc.zzh(zzai.zza("INTERNAL_SUCCESS_SIGN_OUT"));
            return;
        }
        this.zza.zzd.zzQ(new zzade(zzaem.zzc(), zzaem.zzb(), Long.valueOf(zzadg.zza(zzaem.zzb())), "Bearer"), (String) null, (String) null, false, (zze) null, this.zza.zzc, this);
    }
}
