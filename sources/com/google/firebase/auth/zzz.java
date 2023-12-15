package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zzbl;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzz extends zzbl {
    final /* synthetic */ boolean zza;
    final /* synthetic */ FirebaseUser zzb;
    final /* synthetic */ EmailAuthCredential zzc;
    final /* synthetic */ FirebaseAuth zzd;

    zzz(FirebaseAuth firebaseAuth, boolean z, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential) {
        this.zzd = firebaseAuth;
        this.zza = z;
        this.zzb = firebaseUser;
        this.zzc = emailAuthCredential;
    }

    public final Task zza(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.i("FirebaseAuth", "Email link login/reauth with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for login/reauth with email link");
        }
        if (this.zza) {
            FirebaseAuth firebaseAuth = this.zzd;
            return firebaseAuth.zzf.zzq(firebaseAuth.zzb, (FirebaseUser) Preconditions.checkNotNull(this.zzb), this.zzc, str, new zzac(this.zzd));
        }
        FirebaseAuth firebaseAuth2 = this.zzd;
        return firebaseAuth2.zzf.zzE(firebaseAuth2.zzb, this.zzc, str, new zzab(firebaseAuth2));
    }
}
