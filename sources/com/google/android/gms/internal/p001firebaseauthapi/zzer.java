package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzer  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzer extends zzki {
    final /* synthetic */ zzes zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzer(zzes zzes, Class cls) {
        super(cls);
        this.zza = zzes;
    }

    public final /* bridge */ /* synthetic */ zzahp zza(zzahp zzahp) throws GeneralSecurityException {
        zzpq zzb = zzpr.zzb();
        byte[] zza2 = zzvs.zza(((zzpu) zzahp).zza());
        zzb.zza(zzaff.zzn(zza2, 0, zza2.length));
        zzb.zzb(0);
        return (zzpr) zzb.zzi();
    }

    public final /* synthetic */ zzahp zzb(zzaff zzaff) throws zzags {
        return zzpu.zzd(zzaff, zzafx.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM", zzes.zzg(16, 1));
        hashMap.put("AES128_GCM_RAW", zzes.zzg(16, 3));
        hashMap.put("AES256_GCM", zzes.zzg(32, 1));
        hashMap.put("AES256_GCM_RAW", zzes.zzg(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ void zzd(zzahp zzahp) throws GeneralSecurityException {
        zzvu.zzb(((zzpu) zzahp).zza());
    }
}
