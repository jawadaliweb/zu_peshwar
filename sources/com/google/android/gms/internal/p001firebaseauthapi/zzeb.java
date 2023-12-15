package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzeb extends zzkj {
    zzeb() {
        super(zzpi.class, new zzdz(zzbd.class));
    }

    static /* bridge */ /* synthetic */ zzkh zzg(int i, int i2, int i3) {
        zzpk zzb = zzpl.zzb();
        zzb.zza(i);
        zzpn zzb2 = zzpo.zzb();
        zzb2.zza(16);
        zzb.zzb((zzpo) zzb2.zzi());
        return new zzkh((zzpl) zzb.zzi(), i3);
    }

    public final zzki zza() {
        return new zzea(this, zzpl.class);
    }

    public final zzso zzb() {
        return zzso.SYMMETRIC;
    }

    public final /* synthetic */ zzahp zzc(zzaff zzaff) throws zzags {
        return zzpi.zzd(zzaff, zzafx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzahp zzahp) throws GeneralSecurityException {
        zzpi zzpi = (zzpi) zzahp;
        zzvu.zzc(zzpi.zza(), 0);
        zzvu.zzb(zzpi.zzf().zzd());
        if (zzpi.zze().zza() != 12 && zzpi.zze().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
