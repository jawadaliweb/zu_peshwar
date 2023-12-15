package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzfj extends zzkj {
    zzfj() {
        super(zzpx.class, new zzfh(zzbd.class));
    }

    public static void zzg(boolean z) throws GeneralSecurityException {
        if (zzi()) {
            zzcq.zzi(new zzfj(), true);
            int i = zzft.zza;
            zzft.zza(zzkt.zzb());
        }
    }

    static /* bridge */ /* synthetic */ zzkh zzh(int i, int i2) {
        zzpz zzb = zzqa.zzb();
        zzb.zza(i);
        return new zzkh((zzqa) zzb.zzi(), i2);
    }

    private static boolean zzi() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public final zzki zza() {
        return new zzfi(this, zzqa.class);
    }

    public final zzso zzb() {
        return zzso.SYMMETRIC;
    }

    public final /* synthetic */ zzahp zzc(zzaff zzaff) throws zzags {
        return zzpx.zzd(zzaff, zzafx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzahp zzahp) throws GeneralSecurityException {
        zzpx zzpx = (zzpx) zzahp;
        zzvu.zzc(zzpx.zza(), 0);
        zzvu.zzb(zzpx.zze().zzd());
    }
}
