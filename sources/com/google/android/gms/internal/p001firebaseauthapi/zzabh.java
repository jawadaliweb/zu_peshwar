package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final /* synthetic */ class zzabh implements Runnable {
    public final /* synthetic */ zzabj zza;
    public final /* synthetic */ zzabi zzb;
    public final /* synthetic */ TaskCompletionSource zzc;

    public /* synthetic */ zzabh(zzabj zzabj, zzabi zzabi, TaskCompletionSource taskCompletionSource) {
        this.zza = zzabj;
        this.zzb = zzabi;
        this.zzc = taskCompletionSource;
    }

    public final void run() {
        this.zzb.zzc(this.zzc, this.zza.zza);
    }
}
