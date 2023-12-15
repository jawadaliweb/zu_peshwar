package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzo;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzyk extends zzabg {
    private final String zza;
    private final String zzb;

    public zzyk(String str, String str2) {
        super(4);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zza = str;
        this.zzb = str2;
    }

    public final String zza() {
        return "checkActionCode";
    }

    public final void zzb() {
        zzm(new zzo(this.zzq));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzd(this.zza, this.zzb, this.zzf);
    }
}
