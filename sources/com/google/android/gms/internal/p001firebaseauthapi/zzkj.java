package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public abstract class zzkj {
    private final Class zza;
    private final Map zzb;
    private final Class zzc;

    @SafeVarargs
    protected zzkj(Class cls, zzlg... zzlgArr) {
        this.zza = cls;
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i <= 0) {
            zzlg zzlg = zzlgArr[i];
            if (!hashMap.containsKey(zzlg.zzb())) {
                hashMap.put(zzlg.zzb(), zzlg);
                i++;
            } else {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive ".concat(String.valueOf(zzlg.zzb().getCanonicalName())));
            }
        }
        this.zzc = zzlgArr[0].zzb();
        this.zzb = Collections.unmodifiableMap(hashMap);
    }

    public zzki zza() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract zzso zzb();

    public abstract zzahp zzc(zzaff zzaff) throws zzags;

    public abstract String zzd();

    public abstract void zze(zzahp zzahp) throws GeneralSecurityException;

    public int zzf() {
        return 1;
    }

    public final Class zzj() {
        return this.zzc;
    }

    public final Class zzk() {
        return this.zza;
    }

    public final Object zzl(zzahp zzahp, Class cls) throws GeneralSecurityException {
        zzlg zzlg = (zzlg) this.zzb.get(cls);
        if (zzlg != null) {
            return zzlg.zza(zzahp);
        }
        String canonicalName = cls.getCanonicalName();
        throw new IllegalArgumentException("Requested primitive class " + canonicalName + " not supported.");
    }

    public final Set zzm() {
        return this.zzb.keySet();
    }
}
