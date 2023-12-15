package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneMultiFactorInfo;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzzr extends zzabg {
    private final zzwk zza;

    public zzzr(PhoneMultiFactorInfo phoneMultiFactorInfo, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, boolean z3) {
        super(8);
        Preconditions.checkNotNull(phoneMultiFactorInfo);
        Preconditions.checkNotEmpty(str);
        this.zza = new zzwk(phoneMultiFactorInfo, str, str2, j, z, z2, str3, str4, z3);
    }

    public final String zza() {
        return "startMfaSignInWithPhoneNumber";
    }

    public final void zzb() {
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzC(this.zza, this.zzf);
    }
}
