package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzki  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public abstract class zzki {
    private final Class zza;

    public zzki(Class cls) {
        this.zza = cls;
    }

    public abstract zzahp zza(zzahp zzahp) throws GeneralSecurityException;

    public abstract zzahp zzb(zzaff zzaff) throws zzags;

    public Map zzc() throws GeneralSecurityException {
        return Collections.emptyMap();
    }

    public abstract void zzd(zzahp zzahp) throws GeneralSecurityException;

    public final Class zzg() {
        return this.zza;
    }
}
