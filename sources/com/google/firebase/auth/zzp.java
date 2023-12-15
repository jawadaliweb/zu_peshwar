package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zzbl;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzp extends zzbl {
    final /* synthetic */ String zza;
    final /* synthetic */ ActionCodeSettings zzb;
    final /* synthetic */ FirebaseAuth zzc;

    zzp(FirebaseAuth firebaseAuth, String str, ActionCodeSettings actionCodeSettings) {
        this.zzc = firebaseAuth;
        this.zza = str;
        this.zzb = actionCodeSettings;
    }

    public final Task zza(String str) {
        if (TextUtils.isEmpty(str)) {
            String str2 = this.zza;
            Log.i("FirebaseAuth", "Email link sign in for " + str2 + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for email link sign in for ".concat(String.valueOf(this.zza)));
        }
        FirebaseAuth firebaseAuth = this.zzc;
        return firebaseAuth.zzf.zzy(firebaseAuth.zzb, this.zza, this.zzb, firebaseAuth.zzl, str);
    }
}
