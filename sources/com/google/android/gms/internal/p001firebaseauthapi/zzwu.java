package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.zze;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzwu implements zzabl {
    final /* synthetic */ zzabk zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ Boolean zzd;
    final /* synthetic */ zze zze;
    final /* synthetic */ zzaae zzf;
    final /* synthetic */ zzade zzg;

    zzwu(zzyh zzyh, zzabk zzabk, String str, String str2, Boolean bool, zze zze2, zzaae zzaae, zzade zzade) {
        this.zza = zzabk;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bool;
        this.zze = zze2;
        this.zzf = zzaae;
        this.zzg = zzade;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List zzb2 = ((zzacu) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        int i = 0;
        zzacv zzacv = (zzacv) zzb2.get(0);
        zzadk zzl = zzacv.zzl();
        List zzc2 = zzl != null ? zzl.zzc() : null;
        if (zzc2 != null && !zzc2.isEmpty()) {
            if (!TextUtils.isEmpty(this.zzb)) {
                while (true) {
                    if (i >= zzc2.size()) {
                        break;
                    } else if (((zzadj) zzc2.get(i)).zzf().equals(this.zzb)) {
                        ((zzadj) zzc2.get(i)).zzh(this.zzc);
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                ((zzadj) zzc2.get(0)).zzh(this.zzc);
            }
        }
        zzacv.zzh(this.zzd.booleanValue());
        zzacv.zze(this.zze);
        this.zzf.zzk(this.zzg, zzacv);
    }
}
