package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zznb extends zzki {
    final /* synthetic */ zznc zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zznb(zznc zznc, Class cls) {
        super(cls);
        this.zza = zznc;
    }

    public final /* bridge */ /* synthetic */ zzahp zza(zzahp zzahp) throws GeneralSecurityException {
        zzrt zzrt = (zzrt) zzahp;
        zzrp zzb = zzrq.zzb();
        zzb.zzc(0);
        zzb.zzb(zzrt.zzf());
        byte[] zza2 = zzvs.zza(zzrt.zza());
        zzb.zza(zzaff.zzn(zza2, 0, zza2.length));
        return (zzrq) zzb.zzi();
    }

    public final /* synthetic */ zzahp zzb(zzaff zzaff) throws zzags {
        return zzrt.zze(zzaff, zzafx.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("HMAC_SHA256_128BITTAG", zznc.zzn(32, 16, 5, 1));
        hashMap.put("HMAC_SHA256_128BITTAG_RAW", zznc.zzn(32, 16, 5, 3));
        hashMap.put("HMAC_SHA256_256BITTAG", zznc.zzn(32, 32, 5, 1));
        hashMap.put("HMAC_SHA256_256BITTAG_RAW", zznc.zzn(32, 32, 5, 3));
        hashMap.put("HMAC_SHA512_128BITTAG", zznc.zzn(64, 16, 6, 1));
        hashMap.put("HMAC_SHA512_128BITTAG_RAW", zznc.zzn(64, 16, 6, 3));
        hashMap.put("HMAC_SHA512_256BITTAG", zznc.zzn(64, 32, 6, 1));
        hashMap.put("HMAC_SHA512_256BITTAG_RAW", zznc.zzn(64, 32, 6, 3));
        hashMap.put("HMAC_SHA512_512BITTAG", zznc.zzn(64, 64, 6, 1));
        hashMap.put("HMAC_SHA512_512BITTAG_RAW", zznc.zzn(64, 64, 6, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzahp zzahp) throws GeneralSecurityException {
        zzrt zzrt = (zzrt) zzahp;
        if (zzrt.zza() >= 16) {
            zznc.zzo(zzrt.zzf());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
