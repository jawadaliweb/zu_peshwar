package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzs  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzzs extends zzabg {
    private final String zza;
    private final String zzb;
    private final String zzc;

    public zzzs(String str, String str2, String str3) {
        super(2);
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = str3;
    }

    public final String zza() {
        return "unenrollMfa";
    }

    public final void zzb() {
        ((zzg) this.zzi).zza(this.zzn, zzaac.zzQ(this.zzg, this.zzo));
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzD(this.zza, this.zzb, this.zzc, this.zzf);
    }
}
