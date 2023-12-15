package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzhq extends zzki {
    final /* synthetic */ zzhr zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzhq(zzhr zzhr, Class cls) {
        super(cls);
        this.zza = zzhr;
    }

    public final /* bridge */ /* synthetic */ zzahp zza(zzahp zzahp) throws GeneralSecurityException {
        zzqc zzb = zzqd.zzb();
        byte[] zza2 = zzvs.zza(((zzqg) zzahp).zza());
        zzb.zza(zzaff.zzn(zza2, 0, zza2.length));
        zzb.zzb(0);
        return (zzqd) zzb.zzi();
    }

    public final /* synthetic */ zzahp zzb(zzaff zzaff) throws zzags {
        return zzqg.zzd(zzaff, zzafx.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        zzqf zzb = zzqg.zzb();
        zzb.zza(64);
        hashMap.put("AES256_SIV", new zzkh((zzqg) zzb.zzi(), 1));
        zzqf zzb2 = zzqg.zzb();
        zzb2.zza(64);
        hashMap.put("AES256_SIV_RAW", new zzkh((zzqg) zzb2.zzi(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzahp zzahp) throws GeneralSecurityException {
        zzqg zzqg = (zzqg) zzahp;
        if (zzqg.zza() != 64) {
            int zza2 = zzqg.zza();
            throw new InvalidAlgorithmParameterException("invalid key size: " + zza2 + ". Valid keys must have 64 bytes.");
        }
    }
}
