package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzea  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzea extends zzki {
    final /* synthetic */ zzeb zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzea(zzeb zzeb, Class cls) {
        super(cls);
        this.zza = zzeb;
    }

    public final /* bridge */ /* synthetic */ zzahp zza(zzahp zzahp) throws GeneralSecurityException {
        zzpl zzpl = (zzpl) zzahp;
        zzph zzb = zzpi.zzb();
        byte[] zza2 = zzvs.zza(zzpl.zza());
        zzb.zza(zzaff.zzn(zza2, 0, zza2.length));
        zzb.zzb(zzpl.zze());
        zzb.zzc(0);
        return (zzpi) zzb.zzi();
    }

    public final /* synthetic */ zzahp zzb(zzaff zzaff) throws zzags {
        return zzpl.zzd(zzaff, zzafx.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_EAX", zzeb.zzg(16, 16, 1));
        hashMap.put("AES128_EAX_RAW", zzeb.zzg(16, 16, 3));
        hashMap.put("AES256_EAX", zzeb.zzg(32, 16, 1));
        hashMap.put("AES256_EAX_RAW", zzeb.zzg(32, 16, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzahp zzahp) throws GeneralSecurityException {
        zzpl zzpl = (zzpl) zzahp;
        zzvu.zzb(zzpl.zza());
        if (zzpl.zze().zza() != 12 && zzpl.zze().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
