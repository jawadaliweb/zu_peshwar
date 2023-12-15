package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzvc {
    public static final zzvc zza = new zzvc(new zzvd());
    public static final zzvc zzb = new zzvc(new zzvh());
    public static final zzvc zzc = new zzvc(new zzvj());
    public static final zzvc zzd = new zzvc(new zzvi());
    public static final zzvc zze = new zzvc(new zzve());
    public static final zzvc zzf = new zzvc(new zzvg());
    public static final zzvc zzg = new zzvc(new zzvf());
    private final zzvb zzh;

    public zzvc(zzvk zzvk) {
        if (zzhk.zzb()) {
            this.zzh = new zzva(zzvk, (zzuz) null);
        } else if (zzvt.zza()) {
            this.zzh = new zzuw(zzvk, (zzuv) null);
        } else {
            this.zzh = new zzuy(zzvk, (zzux) null);
        }
    }

    public static List zzb(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String provider : strArr) {
            Provider provider2 = Security.getProvider(provider);
            if (provider2 != null) {
                arrayList.add(provider2);
            }
        }
        return arrayList;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        return this.zzh.zza(str);
    }
}
