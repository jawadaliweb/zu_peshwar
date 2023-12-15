package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zzbl;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzo extends zzbl {
    final /* synthetic */ String zza;
    final /* synthetic */ ActionCodeSettings zzb;
    final /* synthetic */ FirebaseAuth zzc;

    zzo(FirebaseAuth firebaseAuth, String str, ActionCodeSettings actionCodeSettings) {
        this.zzc = firebaseAuth;
        this.zza = str;
        this.zzb = actionCodeSettings;
    }

    public final Task zza(String str) {
        if (TextUtils.isEmpty(str)) {
            String str2 = this.zza;
            Log.i("FirebaseAuth", "Password reset request " + str2 + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for password reset of email ".concat(String.valueOf(this.zza)));
        }
        FirebaseAuth firebaseAuth = this.zzc;
        return firebaseAuth.zzf.zzx(firebaseAuth.zzb, this.zza, this.zzb, firebaseAuth.zzl, str);
    }
}
