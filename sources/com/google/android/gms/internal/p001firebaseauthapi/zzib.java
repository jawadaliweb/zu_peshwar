package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzib  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzib {
    public static final /* synthetic */ int zza = 0;
    private static final zzvx zzb;
    private static final zzlb zzc = zzlb.zza(zzhx.zza, zzhw.class, zzlo.class);
    private static final zzkx zzd;
    private static final zzkg zze = zzkg.zza(zzhz.zza, zzho.class, zzln.class);
    private static final zzkc zzf;
    private static final Map zzg;
    private static final Map zzh;

    static {
        zzvx zzb2 = zzly.zzb("type.googleapis.com/google.crypto.tink.AesSivKey");
        zzb = zzb2;
        zzd = zzkx.zza(zzhy.zza, zzb2, zzlo.class);
        zzf = zzkc.zzb(zzia.zza, zzb2, zzln.class);
        HashMap hashMap = new HashMap();
        hashMap.put(zzhu.zzc, zztv.RAW);
        hashMap.put(zzhu.zza, zztv.TINK);
        hashMap.put(zzhu.zzb, zztv.CRUNCHY);
        zzg = Collections.unmodifiableMap(hashMap);
        EnumMap enumMap = new EnumMap(zztv.class);
        enumMap.put(zztv.RAW, zzhu.zzc);
        enumMap.put(zztv.TINK, zzhu.zza);
        enumMap.put(zztv.CRUNCHY, zzhu.zzb);
        enumMap.put(zztv.LEGACY, zzhu.zzb);
        zzh = Collections.unmodifiableMap(enumMap);
    }

    public static /* synthetic */ zzho zza(zzln zzln, zzcr zzcr) {
        if (zzln.zzg().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            try {
                zzqd zzd2 = zzqd.zzd(zzln.zze(), zzafx.zza());
                if (zzd2.zza() == 0) {
                    zzht zzht = new zzht((zzhs) null);
                    zzht.zza(zzd2.zze().zzd());
                    zztv zzc2 = zzln.zzc();
                    Map map = zzh;
                    if (map.containsKey(zzc2)) {
                        zzht.zzb((zzhu) map.get(zzc2));
                        zzhw zzc3 = zzht.zzc();
                        zzhm zzhm = new zzhm((zzhl) null);
                        zzhm.zzc(zzc3);
                        zzhm.zzb(zzvy.zzb(zzd2.zze().zzq(), zzcr));
                        zzhm.zza(zzln.zzf());
                        return zzhm.zzd();
                    }
                    int zza2 = zzc2.zza();
                    throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzags unused) {
                throw new GeneralSecurityException("Parsing AesSivKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters");
        }
    }

    public static void zzb(zzkt zzkt) throws GeneralSecurityException {
        zzkt.zzf(zzc);
        zzkt.zze(zzd);
        zzkt.zzd(zze);
        zzkt.zzc(zzf);
    }
}
