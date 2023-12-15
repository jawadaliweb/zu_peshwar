package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzaj;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzyo extends zzabg {
    private final String zza;
    private final String zzb;

    public zzyo(String str, String str2) {
        super(3);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        this.zza = str;
        this.zzb = str2;
    }

    public final String zza() {
        return "fetchSignInMethodsForEmail";
    }

    public final void zzb() {
        List list;
        if (this.zzp.zzb() == null) {
            list = zzam.zzi();
        } else {
            list = (List) Preconditions.checkNotNull(this.zzp.zzb());
        }
        zzm(new zzaj(list));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzl(this.zza, this.zzb, this.zzf);
    }
}
