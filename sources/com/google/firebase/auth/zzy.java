package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zzbl;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzy extends zzbl {
    final /* synthetic */ String zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ FirebaseUser zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ String zze;
    final /* synthetic */ FirebaseAuth zzf;

    zzy(FirebaseAuth firebaseAuth, String str, boolean z, FirebaseUser firebaseUser, String str2, String str3) {
        this.zzf = firebaseAuth;
        this.zza = str;
        this.zzb = z;
        this.zzc = firebaseUser;
        this.zzd = str2;
        this.zze = str3;
    }

    public final Task zza(String str) {
        if (TextUtils.isEmpty(str)) {
            String str2 = this.zza;
            Log.i("FirebaseAuth", "Logging in as " + str2 + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for login with email ".concat(String.valueOf(this.zza)));
        }
        if (this.zzb) {
            FirebaseAuth firebaseAuth = this.zzf;
            return firebaseAuth.zzf.zzs(firebaseAuth.zzb, (FirebaseUser) Preconditions.checkNotNull(this.zzc), this.zza, this.zzd, this.zze, str, new zzac(this.zzf));
        }
        FirebaseAuth firebaseAuth2 = this.zzf;
        return firebaseAuth2.zzf.zzD(firebaseAuth2.zzb, this.zza, this.zzd, this.zze, str, new zzab(firebaseAuth2));
    }
}
