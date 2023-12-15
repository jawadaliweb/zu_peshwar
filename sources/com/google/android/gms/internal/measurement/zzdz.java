package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.2.2 */
final class zzdz extends zzdu {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzee zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdz(zzee zzee, Activity activity) {
        super(zzee.zza, true);
        this.zzb = zzee;
        this.zza = activity;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zzb.zza.zzj)).onActivityResumed(ObjectWrapper.wrap(this.zza), this.zzi);
    }
}
