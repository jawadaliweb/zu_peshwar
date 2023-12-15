package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public abstract class zzlm extends zzkj {
    private final Class zza;

    @SafeVarargs
    protected zzlm(Class cls, Class cls2, zzlg... zzlgArr) {
        super(cls, zzlgArr);
        this.zza = cls2;
    }

    public abstract zzahp zzg(zzahp zzahp) throws GeneralSecurityException;
}
