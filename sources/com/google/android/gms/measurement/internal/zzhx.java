package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.2 */
final class zzhx implements Runnable {
    final /* synthetic */ zzcf zza;
    final /* synthetic */ zzij zzb;

    zzhx(zzij zzij, zzcf zzcf) {
        this.zzb = zzij;
        this.zza = zzcf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x009a A[SYNTHETIC, Splitter:B:15:0x009a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.zzij r0 = r7.zzb
            com.google.android.gms.measurement.internal.zzge r0 = r0.zzt
            com.google.android.gms.measurement.internal.zzko r0 = r0.zzu()
            com.google.android.gms.internal.measurement.zzqo.zzc()
            com.google.android.gms.measurement.internal.zzge r1 = r0.zzt
            com.google.android.gms.measurement.internal.zzag r1 = r1.zzf()
            com.google.android.gms.measurement.internal.zzeg r2 = com.google.android.gms.measurement.internal.zzeh.zzau
            r3 = 0
            boolean r1 = r1.zzs(r3, r2)
            if (r1 == 0) goto L_0x0076
            com.google.android.gms.measurement.internal.zzge r1 = r0.zzt
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzai r1 = r1.zzc()
            com.google.android.gms.measurement.internal.zzah r2 = com.google.android.gms.measurement.internal.zzah.ANALYTICS_STORAGE
            boolean r1 = r1.zzi(r2)
            if (r1 != 0) goto L_0x003c
            com.google.android.gms.measurement.internal.zzge r0 = r0.zzt
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzl()
            java.lang.String r1 = "Analytics storage consent denied; will not get session id"
            r0.zza(r1)
            goto L_0x0085
        L_0x003c:
            com.google.android.gms.measurement.internal.zzge r1 = r0.zzt
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzge r2 = r0.zzt
            com.google.android.gms.common.util.Clock r2 = r2.zzax()
            long r4 = r2.currentTimeMillis()
            boolean r1 = r1.zzk(r4)
            if (r1 != 0) goto L_0x0085
            com.google.android.gms.measurement.internal.zzge r1 = r0.zzt
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzff r1 = r1.zzk
            long r1 = r1.zza()
            r4 = 0
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0065
            goto L_0x0085
        L_0x0065:
            com.google.android.gms.measurement.internal.zzge r0 = r0.zzt
            com.google.android.gms.measurement.internal.zzfj r0 = r0.zzm()
            com.google.android.gms.measurement.internal.zzff r0 = r0.zzk
            long r0 = r0.zza()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            goto L_0x0086
        L_0x0076:
            com.google.android.gms.measurement.internal.zzge r0 = r0.zzt
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzl()
            java.lang.String r1 = "getSessionId has been disabled."
            r0.zza(r1)
        L_0x0085:
            r0 = r3
        L_0x0086:
            if (r0 == 0) goto L_0x009a
            com.google.android.gms.measurement.internal.zzij r1 = r7.zzb
            com.google.android.gms.measurement.internal.zzge r1 = r1.zzt
            com.google.android.gms.measurement.internal.zzlo r1 = r1.zzv()
            com.google.android.gms.internal.measurement.zzcf r2 = r7.zza
            long r3 = r0.longValue()
            r1.zzV(r2, r3)
            return
        L_0x009a:
            com.google.android.gms.internal.measurement.zzcf r0 = r7.zza     // Catch:{ RemoteException -> 0x00a0 }
            r0.zze(r3)     // Catch:{ RemoteException -> 0x00a0 }
            return
        L_0x00a0:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzij r1 = r7.zzb
            com.google.android.gms.measurement.internal.zzge r1 = r1.zzt
            com.google.android.gms.measurement.internal.zzeu r1 = r1.zzaA()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzd()
            java.lang.String r2 = "getSessionId failed with exception"
            r1.zzb(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhx.run():void");
    }
}
