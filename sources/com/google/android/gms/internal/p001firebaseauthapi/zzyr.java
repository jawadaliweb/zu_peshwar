package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzba;
import com.google.firebase.auth.internal.zzg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzyr extends zzabg {
    private final String zza;

    public zzyr(String str) {
        super(1);
        Preconditions.checkNotEmpty(str, "refresh token cannot be null");
        this.zza = str;
    }

    public final String zza() {
        return "getAccessToken";
    }

    public final void zzb() {
        if (TextUtils.isEmpty(this.zzn.zzf())) {
            this.zzn.zzi(this.zza);
        }
        ((zzg) this.zzi).zza(this.zzn, this.zzh);
        zzm(zzba.zza(this.zzn.zze()));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzj(this.zza, this.zzf);
    }
}
