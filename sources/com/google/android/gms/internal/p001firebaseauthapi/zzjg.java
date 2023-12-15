package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzjg extends zzlm {
    public zzjg() {
        super(zzsh.class, zzsk.class, new zzje(zzbj.class));
    }

    static /* bridge */ /* synthetic */ zzkh zzh(int i, int i2, int i3, int i4) {
        zzsd zza = zzse.zza();
        zza.zzc(i);
        zza.zzb(i2);
        zza.zza(i3);
        zzsa zza2 = zzsb.zza();
        zza2.zza((zzse) zza.zzi());
        return new zzkh((zzsb) zza2.zzi(), i4);
    }

    public final zzki zza() {
        return new zzjf(this, zzsb.class);
    }

    public final zzso zzb() {
        return zzso.ASYMMETRIC_PRIVATE;
    }

    public final /* synthetic */ zzahp zzc(zzaff zzaff) throws zzags {
        return zzsh.zzd(zzaff, zzafx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HpkePrivateKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzahp zzahp) throws GeneralSecurityException {
        zzsh zzsh = (zzsh) zzahp;
        if (zzsh.zzf().zzp()) {
            throw new GeneralSecurityException("Private key is empty.");
        } else if (zzsh.zzk()) {
            zzvu.zzc(zzsh.zza(), 0);
            zzjj.zza(zzsh.zze().zzb());
        } else {
            throw new GeneralSecurityException("Missing public key.");
        }
    }

    public final /* synthetic */ zzahp zzg(zzahp zzahp) throws GeneralSecurityException {
        return ((zzsh) zzahp).zze();
    }
}
