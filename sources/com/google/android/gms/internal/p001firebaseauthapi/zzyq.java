package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzyq extends zzabg {
    private final MultiFactorAssertion zza;
    private final String zzb;
    private final String zzc;

    public zzyq(MultiFactorAssertion multiFactorAssertion, String str, String str2) {
        super(2);
        this.zza = (MultiFactorAssertion) Preconditions.checkNotNull(multiFactorAssertion);
        this.zzb = Preconditions.checkNotEmpty(str);
        this.zzc = str2;
    }

    public final String zza() {
        return "finalizeMfaSignIn";
    }

    public final void zzb() {
        zzx zzQ = zzaac.zzQ(this.zzg, this.zzo);
        FirebaseUser firebaseUser = this.zzh;
        if (firebaseUser == null || firebaseUser.getUid().equalsIgnoreCase(zzQ.getUid())) {
            ((zzg) this.zzi).zza(this.zzn, zzQ);
            zzm(new zzr(zzQ));
            return;
        }
        zzl(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzi(this.zzb, this.zza, this.zzc, this.zzf);
    }
}
