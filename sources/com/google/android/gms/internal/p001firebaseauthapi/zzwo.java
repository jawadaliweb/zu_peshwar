package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzwo implements zzabl {
    final /* synthetic */ zzaae zza;
    final /* synthetic */ zzyh zzb;

    zzwo(zzyh zzyh, zzaae zzaae) {
        this.zzb = zzyh;
        this.zza = zzaae;
    }

    public final void zza(String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzadt zzadt = (zzadt) obj;
        this.zzb.zzQ(new zzade(zzadt.zzd(), zzadt.zzc(), Long.valueOf(zzadt.zzb()), "Bearer"), (String) null, (String) null, true, (zze) null, this.zza, this);
    }
}
