package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzdf extends zzki {
    final /* synthetic */ zzdg zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdf(zzdg zzdg, Class cls) {
        super(cls);
        this.zza = zzdg;
    }

    public final /* bridge */ /* synthetic */ zzahp zza(zzahp zzahp) throws GeneralSecurityException {
        zzow zzow = (zzow) zzahp;
        new zzdu();
        zzoz zzf = zzdt.zzf(zzow.zzd());
        zzahp zza2 = new zznc().zza().zza(zzow.zze());
        zzos zzb = zzot.zzb();
        zzb.zza(zzf);
        zzb.zzb((zzrq) zza2);
        zzb.zzc(0);
        return (zzot) zzb.zzi();
    }

    public final /* synthetic */ zzahp zzb(zzaff zzaff) throws zzags {
        return zzow.zzc(zzaff, zzafx.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_CTR_HMAC_SHA256", zzdg.zzg(16, 16, 32, 16, 5, 1));
        hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zzdg.zzg(16, 16, 32, 16, 5, 3));
        hashMap.put("AES256_CTR_HMAC_SHA256", zzdg.zzg(32, 16, 32, 32, 5, 1));
        hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzdg.zzg(32, 16, 32, 32, 5, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzahp zzahp) throws GeneralSecurityException {
        zzow zzow = (zzow) zzahp;
        ((zzdt) new zzdu().zza()).zzd(zzow.zzd());
        new zznc().zza().zzd(zzow.zze());
        zzvu.zzb(zzow.zzd().zza());
    }
}
