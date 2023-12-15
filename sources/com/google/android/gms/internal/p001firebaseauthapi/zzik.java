package com.google.android.gms.internal.p001firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzik  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzik extends zzlg {
    zzik(Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ Object zza(zzahp zzahp) throws GeneralSecurityException {
        zzrd zzrd = (zzrd) zzahp;
        zzqx zzb = zzrd.zzb();
        zzrg zze = zzb.zze();
        int zzc = zzis.zzc(zze.zzf());
        byte[] zzq = zzrd.zzg().zzq();
        byte[] zzq2 = zzrd.zzh().zzq();
        ECParameterSpec zzi = zzut.zzi(zzc);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, zzq), new BigInteger(1, zzq2));
        zzjx.zzb(eCPoint, zzi.getCurve());
        ECPublicKeySpec eCPublicKeySpec = new ECPublicKeySpec(eCPoint, zzi);
        return new zzuq((ECPublicKey) ((KeyFactory) zzvc.zzg.zza("EC")).generatePublic(eCPublicKeySpec), zze.zzd().zzq(), zzis.zzb(zze.zzg()), zzis.zzd(zzb.zzh()), new zzit(zzb.zza().zzd()));
    }
}
