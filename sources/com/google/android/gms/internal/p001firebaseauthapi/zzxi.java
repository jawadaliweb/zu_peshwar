package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzxi implements zzabl {
    final /* synthetic */ zzabl zza;
    final /* synthetic */ zzade zzb;
    final /* synthetic */ zzxj zzc;

    zzxi(zzxj zzxj, zzabl zzabl, zzade zzade) {
        this.zzc = zzxj;
        this.zza = zzabl;
        this.zzb = zzade;
    }

    public final void zza(String str) {
        this.zzc.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List zzb2 = ((zzacu) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        zzadq zzadq = new zzadq();
        zzadq.zze(this.zzb.zze());
        zzadq.zzb(this.zzc.zza);
        zzxj zzxj = this.zzc;
        zzyh.zzf(zzxj.zzc, zzxj.zzb, this.zzb, (zzacv) zzb2.get(0), zzadq, this.zza);
    }
}
