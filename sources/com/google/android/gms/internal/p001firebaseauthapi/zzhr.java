package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzhr extends zzkj {
    zzhr() {
        super(zzqd.class, new zzhp(zzbi.class));
    }

    public final zzki zza() {
        return new zzhq(this, zzqg.class);
    }

    public final zzso zzb() {
        return zzso.SYMMETRIC;
    }

    public final /* synthetic */ zzahp zzc(zzaff zzaff) throws zzags {
        return zzqd.zzd(zzaff, zzafx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzahp zzahp) throws GeneralSecurityException {
        zzqd zzqd = (zzqd) zzahp;
        zzvu.zzc(zzqd.zza(), 0);
        if (zzqd.zze().zzd() != 64) {
            int zzd = zzqd.zze().zzd();
            throw new InvalidKeyException("invalid key size: " + zzd + ". Valid keys must have 64 bytes.");
        }
    }
}
