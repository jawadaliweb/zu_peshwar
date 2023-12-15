package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzii  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzii extends zzki {
    final /* synthetic */ zzij zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzii(zzij zzij, Class cls) {
        super(cls);
        this.zza = zzij;
    }

    public final /* bridge */ /* synthetic */ zzahp zza(zzahp zzahp) throws GeneralSecurityException {
        zzqu zzqu = (zzqu) zzahp;
        KeyPair zzc = zzut.zzc(zzut.zzi(zzis.zzc(zzqu.zzd().zze().zzf())));
        ECPoint w = ((ECPublicKey) zzc.getPublic()).getW();
        zzrc zzc2 = zzrd.zzc();
        zzc2.zzb(0);
        zzc2.zza(zzqu.zzd());
        byte[] byteArray = w.getAffineX().toByteArray();
        zzaff zzaff = zzaff.zzb;
        zzc2.zzc(zzaff.zzn(byteArray, 0, byteArray.length));
        byte[] byteArray2 = w.getAffineY().toByteArray();
        zzc2.zzd(zzaff.zzn(byteArray2, 0, byteArray2.length));
        zzqz zzb = zzra.zzb();
        zzb.zzc(0);
        zzb.zzb((zzrd) zzc2.zzi());
        byte[] byteArray3 = ((ECPrivateKey) zzc.getPrivate()).getS().toByteArray();
        zzb.zza(zzaff.zzn(byteArray3, 0, byteArray3.length));
        return (zzra) zzb.zzi();
    }

    public final /* synthetic */ zzahp zzb(zzaff zzaff) throws zzags {
        return zzqu.zzc(zzaff, zzafx.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", zzij.zzi(4, 5, 3, zzbv.zza("AES128_GCM"), zzij.zza, 1));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzij.zzi(4, 5, 3, zzbv.zza("AES128_GCM"), zzij.zza, 3));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", zzij.zzi(4, 5, 4, zzbv.zza("AES128_GCM"), zzij.zza, 1));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzij.zzi(4, 5, 4, zzbv.zza("AES128_GCM"), zzij.zza, 3));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", zzij.zzi(4, 5, 4, zzbv.zza("AES128_GCM"), zzij.zza, 3));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzij.zzi(4, 5, 3, zzbv.zza("AES128_CTR_HMAC_SHA256"), zzij.zza, 1));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzij.zzi(4, 5, 3, zzbv.zza("AES128_CTR_HMAC_SHA256"), zzij.zza, 3));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzij.zzi(4, 5, 4, zzbv.zza("AES128_CTR_HMAC_SHA256"), zzij.zza, 1));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzij.zzi(4, 5, 4, zzbv.zza("AES128_CTR_HMAC_SHA256"), zzij.zza, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ void zzd(zzahp zzahp) throws GeneralSecurityException {
        zzis.zza(((zzqu) zzahp).zzd());
    }
}
