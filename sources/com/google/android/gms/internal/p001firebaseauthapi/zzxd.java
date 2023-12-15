package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzxd implements zzabl {
    final /* synthetic */ zzabl zza;
    final /* synthetic */ zzxe zzb;

    zzxd(zzxe zzxe, zzabl zzabl) {
        this.zzb = zzxe;
        this.zza = zzabl;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaek zzaek = (zzaek) obj;
        if (!TextUtils.isEmpty(zzaek.zzf())) {
            this.zzb.zzb.zzg(new Status(FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE), PhoneAuthCredential.zzd(zzaek.zzd(), zzaek.zzf()));
            return;
        }
        this.zzb.zzc.zzQ(new zzade(zzaek.zze(), zzaek.zzc(), Long.valueOf(zzaek.zzb()), "Bearer"), (String) null, "phone", Boolean.valueOf(zzaek.zzg()), (zze) null, this.zzb.zzb, this.zza);
    }
}
