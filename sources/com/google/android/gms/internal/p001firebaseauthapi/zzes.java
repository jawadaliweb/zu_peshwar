package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzes  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzes extends zzkj {
    zzes() {
        super(zzpr.class, new zzeq(zzbd.class));
    }

    static /* bridge */ /* synthetic */ zzkh zzg(int i, int i2) {
        zzpt zzb = zzpu.zzb();
        zzb.zza(i);
        return new zzkh((zzpu) zzb.zzi(), i2);
    }

    public final zzki zza() {
        return new zzer(this, zzpu.class);
    }

    public final zzso zzb() {
        return zzso.SYMMETRIC;
    }

    public final /* synthetic */ zzahp zzc(zzaff zzaff) throws zzags {
        return zzpr.zzd(zzaff, zzafx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzahp zzahp) throws GeneralSecurityException {
        zzpr zzpr = (zzpr) zzahp;
        zzvu.zzc(zzpr.zza(), 0);
        zzvu.zzb(zzpr.zze().zzd());
    }

    public final int zzf() {
        return 2;
    }
}
