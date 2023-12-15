package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zzbl;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaa extends zzbl {
    final /* synthetic */ boolean zza;
    final /* synthetic */ FirebaseUser zzb;
    final /* synthetic */ EmailAuthCredential zzc;
    final /* synthetic */ FirebaseAuth zzd;

    zzaa(FirebaseAuth firebaseAuth, boolean z, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential) {
        this.zzd = firebaseAuth;
        this.zza = z;
        this.zzb = firebaseUser;
        this.zzc = emailAuthCredential;
    }

    public final Task zza(String str) {
        if (this.zza) {
            if (TextUtils.isEmpty(str)) {
                Log.i("FirebaseAuth", " Email link reauth with empty reCAPTCHA token");
            } else {
                Log.i("FirebaseAuth", "Got reCAPTCHA token for reauth with email link");
            }
            FirebaseAuth firebaseAuth = this.zzd;
            return firebaseAuth.zzf.zzp(firebaseAuth.zzb, this.zzb, this.zzc, str, new zzac(firebaseAuth));
        }
        EmailAuthCredential emailAuthCredential = this.zzc;
        String zzd2 = emailAuthCredential.zzd();
        String zze = emailAuthCredential.zze();
        if (TextUtils.isEmpty(str)) {
            Log.i("FirebaseAuth", "Reauthenticating " + zzd2 + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for reauth with ".concat(String.valueOf(zzd2)));
        }
        FirebaseAuth firebaseAuth2 = this.zzd;
        return firebaseAuth2.zzf.zzr(firebaseAuth2.zzb, this.zzb, zzd2, Preconditions.checkNotEmpty(zze), this.zzb.getTenantId(), str, new zzac(this.zzd));
    }
}
