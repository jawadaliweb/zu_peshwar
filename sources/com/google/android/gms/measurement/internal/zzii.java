package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.2 */
final class zzii implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzij zza;

    zzii(zzij zzij) {
        this.zza = zzij;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0065 A[Catch:{ RuntimeException -> 0x00c5, all -> 0x00c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a0 A[Catch:{ RuntimeException -> 0x00c5, all -> 0x00c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a3 A[Catch:{ RuntimeException -> 0x00c5, all -> 0x00c3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityCreated(android.app.Activity r9, android.os.Bundle r10) {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zzij r0 = r8.zza     // Catch:{ RuntimeException -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzge r0 = r0.zzt     // Catch:{ RuntimeException -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()     // Catch:{ RuntimeException -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzj()     // Catch:{ RuntimeException -> 0x00c5 }
            java.lang.String r1 = "onActivityCreated"
            r0.zza(r1)     // Catch:{ RuntimeException -> 0x00c5 }
            android.content.Intent r0 = r9.getIntent()     // Catch:{ RuntimeException -> 0x00c5 }
            if (r0 != 0) goto L_0x0023
            com.google.android.gms.measurement.internal.zzij r0 = r8.zza
            com.google.android.gms.measurement.internal.zzge r0 = r0.zzt
        L_0x001b:
            com.google.android.gms.measurement.internal.zziy r0 = r0.zzs()
            r0.zzr(r9, r10)
            return
        L_0x0023:
            com.google.android.gms.internal.measurement.zzoy.zzc()     // Catch:{ RuntimeException -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzij r1 = r8.zza     // Catch:{ RuntimeException -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzge r1 = r1.zzt     // Catch:{ RuntimeException -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzag r1 = r1.zzf()     // Catch:{ RuntimeException -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzeg r2 = com.google.android.gms.measurement.internal.zzeh.zzaF     // Catch:{ RuntimeException -> 0x00c5 }
            r3 = 0
            boolean r1 = r1.zzs(r3, r2)     // Catch:{ RuntimeException -> 0x00c5 }
            if (r1 != 0) goto L_0x003d
            android.net.Uri r3 = r0.getData()     // Catch:{ RuntimeException -> 0x00c5 }
        L_0x003b:
            r4 = r3
            goto L_0x0063
        L_0x003d:
            android.net.Uri r1 = r0.getData()     // Catch:{ RuntimeException -> 0x00c5 }
            if (r1 == 0) goto L_0x004c
            boolean r2 = r1.isHierarchical()     // Catch:{ RuntimeException -> 0x00c5 }
            if (r2 != 0) goto L_0x004a
            goto L_0x004c
        L_0x004a:
            r4 = r1
            goto L_0x0063
        L_0x004c:
            android.os.Bundle r1 = r0.getExtras()     // Catch:{ RuntimeException -> 0x00c5 }
            if (r1 == 0) goto L_0x003b
            java.lang.String r2 = "com.android.vending.referral_url"
            java.lang.String r1 = r1.getString(r2)     // Catch:{ RuntimeException -> 0x00c5 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ RuntimeException -> 0x00c5 }
            if (r2 != 0) goto L_0x003b
            android.net.Uri r3 = android.net.Uri.parse(r1)     // Catch:{ RuntimeException -> 0x00c5 }
            goto L_0x003b
        L_0x0063:
            if (r4 == 0) goto L_0x00bd
            boolean r1 = r4.isHierarchical()     // Catch:{ RuntimeException -> 0x00c5 }
            if (r1 != 0) goto L_0x006c
            goto L_0x00bd
        L_0x006c:
            com.google.android.gms.measurement.internal.zzij r1 = r8.zza     // Catch:{ RuntimeException -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzge r1 = r1.zzt     // Catch:{ RuntimeException -> 0x00c5 }
            r1.zzv()     // Catch:{ RuntimeException -> 0x00c5 }
            java.lang.String r1 = "android.intent.extra.REFERRER_NAME"
            java.lang.String r0 = r0.getStringExtra(r1)     // Catch:{ RuntimeException -> 0x00c5 }
            java.lang.String r1 = "android-app://com.google.android.googlequicksearchbox/https/www.google.com"
            boolean r1 = r1.equals(r0)     // Catch:{ RuntimeException -> 0x00c5 }
            if (r1 != 0) goto L_0x0095
            java.lang.String r1 = "https://www.google.com"
            boolean r1 = r1.equals(r0)     // Catch:{ RuntimeException -> 0x00c5 }
            if (r1 != 0) goto L_0x0095
            java.lang.String r1 = "android-app://com.google.appcrawler"
            boolean r0 = r1.equals(r0)     // Catch:{ RuntimeException -> 0x00c5 }
            if (r0 == 0) goto L_0x0092
            goto L_0x0095
        L_0x0092:
            java.lang.String r0 = "auto"
            goto L_0x0097
        L_0x0095:
            java.lang.String r0 = "gs"
        L_0x0097:
            r5 = r0
            java.lang.String r0 = "referrer"
            java.lang.String r6 = r4.getQueryParameter(r0)     // Catch:{ RuntimeException -> 0x00c5 }
            if (r10 != 0) goto L_0x00a3
            r0 = 1
            r3 = 1
            goto L_0x00a5
        L_0x00a3:
            r0 = 0
            r3 = 0
        L_0x00a5:
            com.google.android.gms.measurement.internal.zzij r0 = r8.zza     // Catch:{ RuntimeException -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzge r0 = r0.zzt     // Catch:{ RuntimeException -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzgb r0 = r0.zzaB()     // Catch:{ RuntimeException -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzih r7 = new com.google.android.gms.measurement.internal.zzih     // Catch:{ RuntimeException -> 0x00c5 }
            r1 = r7
            r2 = r8
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ RuntimeException -> 0x00c5 }
            r0.zzp(r7)     // Catch:{ RuntimeException -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzij r0 = r8.zza
            com.google.android.gms.measurement.internal.zzge r0 = r0.zzt
            goto L_0x001b
        L_0x00bd:
            com.google.android.gms.measurement.internal.zzij r0 = r8.zza
            com.google.android.gms.measurement.internal.zzge r0 = r0.zzt
            goto L_0x001b
        L_0x00c3:
            r0 = move-exception
            goto L_0x00dd
        L_0x00c5:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzij r1 = r8.zza     // Catch:{ all -> 0x00c3 }
            com.google.android.gms.measurement.internal.zzge r1 = r1.zzt     // Catch:{ all -> 0x00c3 }
            com.google.android.gms.measurement.internal.zzeu r1 = r1.zzaA()     // Catch:{ all -> 0x00c3 }
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzd()     // Catch:{ all -> 0x00c3 }
            java.lang.String r2 = "Throwable caught in onActivityCreated"
            r1.zzb(r2, r0)     // Catch:{ all -> 0x00c3 }
            com.google.android.gms.measurement.internal.zzij r0 = r8.zza
            com.google.android.gms.measurement.internal.zzge r0 = r0.zzt
            goto L_0x001b
        L_0x00dd:
            com.google.android.gms.measurement.internal.zzij r1 = r8.zza
            com.google.android.gms.measurement.internal.zzge r1 = r1.zzt
            com.google.android.gms.measurement.internal.zziy r1 = r1.zzs()
            r1.zzr(r9, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzii.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzt.zzs().zzs(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzt.zzs().zzt(activity);
        zzko zzu = this.zza.zzt.zzu();
        zzu.zzt.zzaB().zzp(new zzkh(zzu, zzu.zzt.zzax().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        zzko zzu = this.zza.zzt.zzu();
        zzu.zzt.zzaB().zzp(new zzkg(zzu, zzu.zzt.zzax().elapsedRealtime()));
        this.zza.zzt.zzs().zzu(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzt.zzs().zzv(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
