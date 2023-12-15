package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzwm {
    private final Status zza;
    private final zze zzb;
    private final String zzc;
    private final String zzd;

    public zzwm(Status status, zze zze, String str, String str2) {
        this.zza = status;
        this.zzb = zze;
        this.zzc = str;
        this.zzd = str2;
    }

    public final Status zza() {
        return this.zza;
    }

    public final zze zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }
}
