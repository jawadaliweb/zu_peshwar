package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.internal.zzg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzyp extends zzabg {
    private final MultiFactorAssertion zza;
    private final String zzb;
    private final String zzc;

    public zzyp(MultiFactorAssertion multiFactorAssertion, String str, String str2, String str3) {
        super(2);
        this.zza = (MultiFactorAssertion) Preconditions.checkNotNull(multiFactorAssertion);
        this.zzb = Preconditions.checkNotEmpty(str);
        this.zzc = str2;
    }

    public final String zza() {
        return "finalizeMfaEnrollment";
    }

    public final void zzb() {
        ((zzg) this.zzi).zza(this.zzn, zzaac.zzQ(this.zzg, this.zzo));
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzh(this.zza, this.zzb, this.zzc, (String) null, this.zzf);
    }
}
