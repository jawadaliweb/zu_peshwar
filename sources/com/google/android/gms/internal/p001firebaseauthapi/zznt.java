package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zznt implements zzcm {
    /* access modifiers changed from: private */
    public static final Logger zza = Logger.getLogger(zznt.class.getName());
    /* access modifiers changed from: private */
    public static final byte[] zzb = {0};
    private static final zznt zzc = new zznt();

    zznt() {
    }

    public static void zze() throws GeneralSecurityException {
        zzcq.zzj(zzc);
    }

    public final Class zza() {
        return zzcd.class;
    }

    public final Class zzb() {
        return zzcd.class;
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzcl zzcl) throws GeneralSecurityException {
        for (List it : zzcl.zzd()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    zzch zzch = (zzch) it2.next();
                    if (zzch.zzb() instanceof zznp) {
                        zznp zznp = (zznp) zzch.zzb();
                        zzvx zzb2 = zzvx.zzb(zzch.zzg());
                        if (!zzb2.equals(zznp.zzb())) {
                            String valueOf = String.valueOf(zznp.zza());
                            String obj = zznp.zzb().toString();
                            String obj2 = zzb2.toString();
                            throw new GeneralSecurityException("Mac Key with parameters " + valueOf + " has wrong output prefix (" + obj + ") instead of (" + obj2 + ")");
                        }
                    }
                }
            }
        }
        return new zzns(zzcl, (zznr) null);
    }
}
