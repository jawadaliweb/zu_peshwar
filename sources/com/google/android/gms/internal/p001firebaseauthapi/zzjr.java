package com.google.android.gms.internal.p001firebaseauthapi;

import android.os.Build;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzjr {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public static final Object zzb = new Object();
    /* access modifiers changed from: private */
    public static final String zzc = "zzjr";
    private final zzca zzd;
    private final zzbd zze;
    private final zzbz zzf;

    /* synthetic */ zzjr(zzjp zzjp, zzjq zzjq) {
        this.zzd = new zzju(zzjp.zza, zzjp.zzb, zzjp.zzc);
        this.zze = zzjp.zze;
        this.zzf = zzjp.zzg;
    }

    static /* bridge */ /* synthetic */ boolean zzd() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public final synchronized zzby zza() throws GeneralSecurityException {
        return this.zzf.zzb();
    }
}
