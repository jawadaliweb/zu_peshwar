package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzjf extends zzki {
    final /* synthetic */ zzjg zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjf(zzjg zzjg, Class cls) {
        super(cls);
        this.zza = zzjg;
    }

    public final /* bridge */ /* synthetic */ zzahp zza(zzahp zzahp) throws GeneralSecurityException {
        byte[] bArr;
        byte[] bArr2;
        zzsb zzsb = (zzsb) zzahp;
        int zzf = zzsb.zzd().zzf() - 2;
        if (zzf == 1) {
            bArr2 = zzvs.zza(32);
            bArr2[0] = (byte) (bArr2[0] | 7);
            byte b = bArr2[31] & Utf8.REPLACEMENT_BYTE;
            bArr2[31] = (byte) b;
            bArr2[31] = (byte) (b | ByteCompanionObject.MIN_VALUE);
            bArr = zzvv.zzb(bArr2);
        } else if (zzf == 2 || zzf == 3 || zzf == 4) {
            int zzg = zzjj.zzg(zzsb.zzd().zzf());
            KeyPair zzc = zzut.zzc(zzut.zzi(zzg));
            ECPoint w = ((ECPublicKey) zzc.getPublic()).getW();
            EllipticCurve curve = zzut.zzi(zzg).getCurve();
            zzjx.zzb(w, curve);
            int zza2 = zzut.zza(curve);
            int i = zza2 + zza2 + 1;
            bArr = new byte[i];
            byte[] zza3 = zzjv.zza(w.getAffineX());
            byte[] zza4 = zzjv.zza(w.getAffineY());
            int length = zza4.length;
            System.arraycopy(zza4, 0, bArr, i - length, length);
            int length2 = zza3.length;
            System.arraycopy(zza3, 0, bArr, (zza2 + 1) - length2, length2);
            bArr[0] = 4;
            bArr2 = ((ECPrivateKey) zzc.getPrivate()).getS().toByteArray();
        } else {
            throw new GeneralSecurityException("Invalid KEM");
        }
        zzsj zzc2 = zzsk.zzc();
        zzc2.zzc(0);
        zzc2.zza(zzsb.zzd());
        zzc2.zzb(zzaff.zzn(bArr, 0, bArr.length));
        zzsg zzb = zzsh.zzb();
        zzb.zzc(0);
        zzb.zzb((zzsk) zzc2.zzi());
        zzb.zza(zzaff.zzn(bArr2, 0, bArr2.length));
        return (zzsh) zzb.zzi();
    }

    public final /* synthetic */ zzahp zzb(zzaff zzaff) throws zzags {
        return zzsb.zzc(zzaff, zzafx.zza());
    }

    public final Map zzc() {
        HashMap hashMap = new HashMap();
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzjg.zzh(3, 3, 3, 1));
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzjg.zzh(3, 3, 3, 3));
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzjg.zzh(3, 3, 4, 1));
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzjg.zzh(3, 3, 4, 3));
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", zzjg.zzh(3, 3, 5, 1));
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", zzjg.zzh(3, 3, 5, 3));
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzjg.zzh(4, 3, 3, 1));
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzjg.zzh(4, 3, 3, 3));
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzjg.zzh(4, 3, 4, 1));
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzjg.zzh(4, 3, 4, 3));
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", zzjg.zzh(5, 4, 3, 1));
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", zzjg.zzh(5, 4, 3, 3));
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", zzjg.zzh(5, 4, 4, 1));
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", zzjg.zzh(5, 4, 4, 3));
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", zzjg.zzh(6, 5, 3, 1));
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", zzjg.zzh(6, 5, 3, 3));
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", zzjg.zzh(6, 5, 4, 1));
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", zzjg.zzh(6, 5, 4, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ void zzd(zzahp zzahp) throws GeneralSecurityException {
        zzjj.zza(((zzsb) zzahp).zzd());
    }
}
