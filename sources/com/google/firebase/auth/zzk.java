package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zze;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzk implements OnCompleteListener {
    final /* synthetic */ PhoneAuthOptions zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ FirebaseAuth zzc;

    zzk(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, String str) {
        this.zzc = firebaseAuth;
        this.zza = phoneAuthOptions;
        this.zzb = str;
    }

    public final void onComplete(Task task) {
        String str;
        String str2;
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            String str3 = "Error while validating application identity: ";
            if (exception != null) {
                str3 = str3.concat(String.valueOf(exception.getMessage()));
            }
            Log.e("FirebaseAuth", str3);
            if (exception instanceof FirebaseAuthMissingActivityForRecaptchaException) {
                FirebaseAuth.zzW((FirebaseAuthMissingActivityForRecaptchaException) exception, this.zza, this.zzb);
                return;
            }
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
            str2 = null;
            str = null;
        } else {
            String zzb2 = ((zze) task.getResult()).zzb();
            str = ((zze) task.getResult()).zza();
            str2 = zzb2;
        }
        long longValue = this.zza.zzg().longValue();
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zzw = this.zzc.zzaa(this.zza.zzh(), this.zza.zze());
        if (TextUtils.isEmpty(str2)) {
            zzw = this.zzc.zzx(this.zza, zzw);
        }
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks = zzw;
        zzag zzag = (zzag) Preconditions.checkNotNull(this.zza.zzc());
        if (zzag.zze()) {
            this.zzc.zzf.zzG(zzag, (String) Preconditions.checkNotNull(this.zza.zzh()), this.zzc.zzj, longValue, this.zza.zzd() != null, this.zza.zzl(), str2, str, this.zzc.zzV(), onVerificationStateChangedCallbacks, this.zza.zzi(), this.zza.zza());
        } else {
            this.zzc.zzf.zzH(zzag, (PhoneMultiFactorInfo) Preconditions.checkNotNull(this.zza.zzf()), this.zzc.zzj, longValue, this.zza.zzd() != null, this.zza.zzl(), str2, str, this.zzc.zzV(), onVerificationStateChangedCallbacks, this.zza.zzi(), this.zza.zza());
        }
    }
}
