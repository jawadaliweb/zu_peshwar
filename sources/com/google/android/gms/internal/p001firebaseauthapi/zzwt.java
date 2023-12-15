package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzwt implements zzabl {
    final /* synthetic */ zzadq zza;
    final /* synthetic */ zzacv zzb;
    final /* synthetic */ zzaae zzc;
    final /* synthetic */ zzade zzd;
    final /* synthetic */ zzabk zze;
    final /* synthetic */ zzyh zzf;

    zzwt(zzyh zzyh, zzadq zzadq, zzacv zzacv, zzaae zzaae, zzade zzade, zzabk zzabk) {
        this.zzf = zzyh;
        this.zza = zzadq;
        this.zzb = zzacv;
        this.zzc = zzaae;
        this.zzd = zzade;
        this.zze = zzabk;
    }

    public final void zza(String str) {
        this.zze.zza(str);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzadr zzadr = (zzadr) obj;
        if (this.zza.zzn("EMAIL")) {
            this.zzb.zzg((String) null);
        } else {
            zzadq zzadq = this.zza;
            if (zzadq.zzk() != null) {
                this.zzb.zzg(zzadq.zzk());
            }
        }
        if (this.zza.zzn("DISPLAY_NAME")) {
            this.zzb.zzf((String) null);
        } else {
            zzadq zzadq2 = this.zza;
            if (zzadq2.zzj() != null) {
                this.zzb.zzf(zzadq2.zzj());
            }
        }
        if (this.zza.zzn("PHOTO_URL")) {
            this.zzb.zzj((String) null);
        } else {
            zzadq zzadq3 = this.zza;
            if (zzadq3.zzm() != null) {
                this.zzb.zzj(zzadq3.zzm());
            }
        }
        if (!TextUtils.isEmpty(this.zza.zzl())) {
            this.zzb.zzi(Base64Utils.encode("redacted".getBytes()));
        }
        List zzf2 = zzadr.zzf();
        if (zzf2 == null) {
            zzf2 = new ArrayList();
        }
        this.zzb.zzk(zzf2);
        zzaae zzaae = this.zzc;
        zzade zzade = this.zzd;
        Preconditions.checkNotNull(zzade);
        Preconditions.checkNotNull(zzadr);
        String zzd2 = zzadr.zzd();
        String zze2 = zzadr.zze();
        if (!TextUtils.isEmpty(zzd2) && !TextUtils.isEmpty(zze2)) {
            zzade = new zzade(zze2, zzd2, Long.valueOf(zzadr.zzb()), zzade.zzg());
        }
        zzaae.zzk(zzade, this.zzb);
    }
}
