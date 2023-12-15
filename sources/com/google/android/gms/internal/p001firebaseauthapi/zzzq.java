package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzag;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzzq extends zzabg {
    private final boolean zzB;
    private final boolean zzC;
    private final String zzD;
    private final String zzE;
    private final boolean zzF;
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;

    public zzzq(zzag zzag, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, boolean z3) {
        super(8);
        Preconditions.checkNotNull(zzag);
        Preconditions.checkNotEmpty(str);
        this.zza = Preconditions.checkNotEmpty(zzag.zzc());
        this.zzb = str;
        this.zzc = str2;
        this.zzd = j;
        this.zzB = z;
        this.zzC = z2;
        this.zzD = str3;
        this.zzE = str4;
        this.zzF = z3;
    }

    public final String zza() {
        return "startMfaEnrollmentWithPhoneNumber";
    }

    public final void zzb() {
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaaf zzaaf) {
        this.zzk = new zzabf(this, taskCompletionSource);
        zzaaf.zzB(this.zza, this.zzb, this.zzc, this.zzd, this.zzB, this.zzC, this.zzD, this.zzE, this.zzF, this.zzf);
    }
}
