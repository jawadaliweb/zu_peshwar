package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzmf extends zzki {
    zzmf(zzmg zzmg, Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ zzahp zza(zzahp zzahp) throws GeneralSecurityException {
        zzon zzon = (zzon) zzahp;
        zzoj zzb = zzok.zzb();
        zzb.zzc(0);
        byte[] zza = zzvs.zza(zzon.zza());
        zzb.zza(zzaff.zzn(zza, 0, zza.length));
        zzb.zzb(zzon.zze());
        return (zzok) zzb.zzi();
    }

    public final /* synthetic */ zzahp zzb(zzaff zzaff) throws zzags {
        return zzon.zzd(zzaff, zzafx.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        zzom zzb = zzon.zzb();
        zzb.zza(32);
        zzop zzb2 = zzoq.zzb();
        zzb2.zza(16);
        zzb.zzb((zzoq) zzb2.zzi());
        hashMap.put("AES_CMAC", new zzkh((zzon) zzb.zzi(), 1));
        zzom zzb3 = zzon.zzb();
        zzb3.zza(32);
        zzop zzb4 = zzoq.zzb();
        zzb4.zza(16);
        zzb3.zzb((zzoq) zzb4.zzi());
        hashMap.put("AES256_CMAC", new zzkh((zzon) zzb3.zzi(), 1));
        zzom zzb5 = zzon.zzb();
        zzb5.zza(32);
        zzop zzb6 = zzoq.zzb();
        zzb6.zza(16);
        zzb5.zzb((zzoq) zzb6.zzi());
        hashMap.put("AES256_CMAC_RAW", new zzkh((zzon) zzb5.zzi(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzahp zzahp) throws GeneralSecurityException {
        zzon zzon = (zzon) zzahp;
        zzmg.zzn(zzon.zze());
        zzmg.zzo(zzon.zza());
    }
}
