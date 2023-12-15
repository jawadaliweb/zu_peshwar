package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzdg extends zzkj {
    zzdg() {
        super(zzot.class, new zzde(zzbd.class));
    }

    static /* bridge */ /* synthetic */ zzkh zzg(int i, int i2, int i3, int i4, int i5, int i6) {
        zzpb zzb = zzpc.zzb();
        zzpe zzb2 = zzpf.zzb();
        zzb2.zza(16);
        zzb.zzb((zzpf) zzb2.zzi());
        zzb.zza(i);
        zzrs zzb3 = zzrt.zzb();
        zzrv zzb4 = zzrw.zzb();
        zzb4.zzb(5);
        zzb4.zza(i4);
        zzb3.zzb((zzrw) zzb4.zzi());
        zzb3.zza(32);
        zzov zza = zzow.zza();
        zza.zza((zzpc) zzb.zzi());
        zza.zzb((zzrt) zzb3.zzi());
        return new zzkh((zzow) zza.zzi(), i6);
    }

    public final zzki zza() {
        return new zzdf(this, zzow.class);
    }

    public final zzso zzb() {
        return zzso.SYMMETRIC;
    }

    public final /* synthetic */ zzahp zzc(zzaff zzaff) throws zzags {
        return zzot.zzd(zzaff, zzafx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzahp zzahp) throws GeneralSecurityException {
        zzot zzot = (zzot) zzahp;
        zzvu.zzc(zzot.zza(), 0);
        new zzdu();
        zzdu.zzh(zzot.zze());
        new zznc();
        zznc.zzi(zzot.zzf());
    }

    public final int zzf() {
        return 2;
    }
}
