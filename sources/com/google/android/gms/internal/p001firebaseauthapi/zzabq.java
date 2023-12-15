package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.PhoneAuthCredential;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzabq {
    public static zzaej zza(PhoneAuthCredential phoneAuthCredential) {
        if (!TextUtils.isEmpty(phoneAuthCredential.zzh())) {
            return zzaej.zzc(phoneAuthCredential.zzf(), phoneAuthCredential.zzh(), phoneAuthCredential.zzi());
        }
        return zzaej.zzb(phoneAuthCredential.zzg(), phoneAuthCredential.getSmsCode(), phoneAuthCredential.zzi());
    }
}
