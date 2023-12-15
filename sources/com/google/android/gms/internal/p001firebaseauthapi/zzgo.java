package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzgo extends zzki {
    final /* synthetic */ zzgp zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgo(zzgp zzgp, Class cls) {
        super(cls);
        this.zza = zzgp;
    }

    public final /* bridge */ /* synthetic */ zzahp zza(zzahp zzahp) throws GeneralSecurityException {
        zzue zzue = (zzue) zzahp;
        zzua zzb = zzub.zzb();
        zzb.zzb(0);
        byte[] zza2 = zzvs.zza(32);
        zzb.zza(zzaff.zzn(zza2, 0, zza2.length));
        return (zzub) zzb.zzi();
    }

    public final /* synthetic */ zzahp zzb(zzaff zzaff) throws zzags {
        return zzue.zzc(zzaff, zzafx.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("XCHACHA20_POLY1305", new zzkh(zzue.zzb(), 1));
        hashMap.put("XCHACHA20_POLY1305_RAW", new zzkh(zzue.zzb(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzahp zzahp) throws GeneralSecurityException {
        zzue zzue = (zzue) zzahp;
    }
}
