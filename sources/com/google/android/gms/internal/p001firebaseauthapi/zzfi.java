package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzfi extends zzki {
    final /* synthetic */ zzfj zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfi(zzfj zzfj, Class cls) {
        super(cls);
        this.zza = zzfj;
    }

    public final /* bridge */ /* synthetic */ zzahp zza(zzahp zzahp) throws GeneralSecurityException {
        zzpw zzb = zzpx.zzb();
        byte[] zza2 = zzvs.zza(((zzqa) zzahp).zza());
        zzb.zza(zzaff.zzn(zza2, 0, zza2.length));
        zzb.zzb(0);
        return (zzpx) zzb.zzi();
    }

    public final /* synthetic */ zzahp zzb(zzaff zzaff) throws zzags {
        return zzqa.zzd(zzaff, zzafx.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM_SIV", zzfj.zzh(16, 1));
        hashMap.put("AES128_GCM_SIV_RAW", zzfj.zzh(16, 3));
        hashMap.put("AES256_GCM_SIV", zzfj.zzh(32, 1));
        hashMap.put("AES256_GCM_SIV_RAW", zzfj.zzh(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ void zzd(zzahp zzahp) throws GeneralSecurityException {
        zzvu.zzb(((zzqa) zzahp).zza());
    }
}
