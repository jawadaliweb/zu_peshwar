package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzxu implements zzabl {
    final /* synthetic */ zzabl zza;
    final /* synthetic */ zzade zzb;
    final /* synthetic */ zzxv zzc;

    zzxu(zzxv zzxv, zzabl zzabl, zzade zzade) {
        this.zzc = zzxv;
        this.zza = zzabl;
        this.zzb = zzade;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List zzb2 = ((zzacu) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users");
        } else {
            this.zzc.zza.zzk(this.zzb, (zzacv) zzb2.get(0));
        }
    }
}
