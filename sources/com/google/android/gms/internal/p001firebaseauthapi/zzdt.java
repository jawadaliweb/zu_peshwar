package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzdt extends zzki {
    final /* synthetic */ zzdu zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdt(zzdu zzdu, Class cls) {
        super(cls);
        this.zza = zzdu;
    }

    public static final zzoz zzf(zzpc zzpc) throws GeneralSecurityException {
        zzoy zzb = zzoz.zzb();
        zzb.zzb(zzpc.zzf());
        byte[] zza2 = zzvs.zza(zzpc.zza());
        zzb.zza(zzaff.zzn(zza2, 0, zza2.length));
        zzb.zzc(0);
        return (zzoz) zzb.zzi();
    }

    public final /* bridge */ /* synthetic */ zzahp zza(zzahp zzahp) throws GeneralSecurityException {
        return zzf((zzpc) zzahp);
    }

    public final /* synthetic */ zzahp zzb(zzaff zzaff) throws zzags {
        return zzpc.zze(zzaff, zzafx.zza());
    }

    /* renamed from: zze */
    public final void zzd(zzpc zzpc) throws GeneralSecurityException {
        zzvu.zzb(zzpc.zza());
        zzdu.zzi(zzpc.zzf());
    }
}
