package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.internal.zzo;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaa  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaaa extends zzabg {
    private final String zza;
    private final String zzb;

    public zzaaa(String str, String str2) {
        super(4);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zza = str;
        this.zzb = str2;
    }

    public final String zza() {
        return "verifyPasswordResetCode";
    }

    public final void zzb() {
        if (new zzo(this.zzq).getOperation() != 0) {
            zzl(new Status(FirebaseError.ERROR_INTERNAL_ERROR));
        } else {
            zzm(this.zzq.zzc());
        }
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzd(this.zza, this.zzb, this.zzf);
    }
}
