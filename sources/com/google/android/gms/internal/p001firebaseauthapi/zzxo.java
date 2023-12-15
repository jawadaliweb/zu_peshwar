package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzxo implements zzabl {
    final /* synthetic */ zzxp zza;

    zzxo(zzxp zzxp) {
        this.zza = zzxp;
    }

    public final void zza(String str) {
        this.zza.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzacn zzacn = (zzacn) obj;
        this.zza.zzb.zzQ(new zzade(zzacn.zzc(), zzacn.zzb(), Long.valueOf(zzadg.zza(zzacn.zzb())), "Bearer"), (String) null, (String) null, false, (zze) null, this.zza.zza, this);
    }
}
