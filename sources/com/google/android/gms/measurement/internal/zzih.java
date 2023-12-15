package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.2 */
final class zzih implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Uri zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzii zze;

    zzih(zzii zzii, boolean z, Uri uri, String str, String str2) {
        this.zze = zzii;
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a7 A[SYNTHETIC, Splitter:B:32:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0101 A[Catch:{ RuntimeException -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0103 A[Catch:{ RuntimeException -> 0x0196 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r16 = this;
            r1 = r16
            com.google.android.gms.measurement.internal.zzii r2 = r1.zze
            boolean r0 = r1.zza
            android.net.Uri r3 = r1.zzb
            java.lang.String r4 = r1.zzc
            java.lang.String r5 = r1.zzd
            com.google.android.gms.measurement.internal.zzij r6 = r2.zza
            r6.zzg()
            com.google.android.gms.measurement.internal.zzij r6 = r2.zza     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzge r6 = r6.zzt     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzlo r6 = r6.zzv()     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.internal.measurement.zzqx.zzc()     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzij r7 = r2.zza     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzge r7 = r7.zzt     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzag r7 = r7.zzf()     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzeg r8 = com.google.android.gms.measurement.internal.zzeh.zzav     // Catch:{ RuntimeException -> 0x0196 }
            r9 = 0
            boolean r7 = r7.zzs(r9, r8)     // Catch:{ RuntimeException -> 0x0196 }
            boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0196 }
            java.lang.String r10 = "Activity created with data 'referrer' without required params"
            java.lang.String r11 = "utm_medium"
            java.lang.String r12 = "_cis"
            java.lang.String r13 = "utm_source"
            java.lang.String r14 = "utm_campaign"
            java.lang.String r15 = "gclid"
            if (r8 == 0) goto L_0x003f
        L_0x003d:
            r6 = r9
            goto L_0x00a3
        L_0x003f:
            boolean r8 = r5.contains(r15)     // Catch:{ RuntimeException -> 0x0196 }
            if (r8 != 0) goto L_0x008a
            boolean r8 = r5.contains(r14)     // Catch:{ RuntimeException -> 0x0196 }
            if (r8 != 0) goto L_0x008a
            boolean r8 = r5.contains(r13)     // Catch:{ RuntimeException -> 0x0196 }
            if (r8 != 0) goto L_0x008a
            boolean r8 = r5.contains(r11)     // Catch:{ RuntimeException -> 0x0196 }
            if (r8 != 0) goto L_0x008a
            java.lang.String r8 = "utm_id"
            boolean r8 = r5.contains(r8)     // Catch:{ RuntimeException -> 0x0196 }
            if (r8 != 0) goto L_0x008a
            java.lang.String r8 = "dclid"
            boolean r8 = r5.contains(r8)     // Catch:{ RuntimeException -> 0x0196 }
            if (r8 != 0) goto L_0x008a
            java.lang.String r8 = "srsltid"
            boolean r8 = r5.contains(r8)     // Catch:{ RuntimeException -> 0x0196 }
            if (r8 != 0) goto L_0x008a
            if (r7 == 0) goto L_0x007c
            java.lang.String r7 = "sfmc_id"
            boolean r7 = r5.contains(r7)     // Catch:{ RuntimeException -> 0x0196 }
            if (r7 != 0) goto L_0x007a
            goto L_0x007c
        L_0x007a:
            r7 = 1
            goto L_0x008a
        L_0x007c:
            com.google.android.gms.measurement.internal.zzge r6 = r6.zzt     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzeu r6 = r6.zzaA()     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzc()     // Catch:{ RuntimeException -> 0x0196 }
            r6.zza(r10)     // Catch:{ RuntimeException -> 0x0196 }
            goto L_0x003d
        L_0x008a:
            java.lang.String r8 = "https://google.com/search?"
            java.lang.String r9 = java.lang.String.valueOf(r5)     // Catch:{ RuntimeException -> 0x0196 }
            java.lang.String r8 = r8.concat(r9)     // Catch:{ RuntimeException -> 0x0196 }
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ RuntimeException -> 0x0196 }
            android.os.Bundle r6 = r6.zzs(r8, r7)     // Catch:{ RuntimeException -> 0x0196 }
            if (r6 == 0) goto L_0x00a3
            java.lang.String r7 = "referrer"
            r6.putString(r12, r7)     // Catch:{ RuntimeException -> 0x0196 }
        L_0x00a3:
            java.lang.String r7 = "_cmp"
            if (r0 == 0) goto L_0x00fb
            com.google.android.gms.measurement.internal.zzij r0 = r2.zza     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzge r0 = r0.zzt     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzlo r0 = r0.zzv()     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.internal.measurement.zzqx.zzc()     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzij r8 = r2.zza     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzge r8 = r8.zzt     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzag r8 = r8.zzf()     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzeg r9 = com.google.android.gms.measurement.internal.zzeh.zzav     // Catch:{ RuntimeException -> 0x0196 }
            r1 = 0
            boolean r8 = r8.zzs(r1, r9)     // Catch:{ RuntimeException -> 0x0196 }
            android.os.Bundle r0 = r0.zzs(r3, r8)     // Catch:{ RuntimeException -> 0x0196 }
            if (r0 == 0) goto L_0x00fb
            java.lang.String r1 = "intent"
            r0.putString(r12, r1)     // Catch:{ RuntimeException -> 0x0196 }
            boolean r1 = r0.containsKey(r15)     // Catch:{ RuntimeException -> 0x0196 }
            if (r1 != 0) goto L_0x00ef
            if (r6 == 0) goto L_0x00ef
            boolean r1 = r6.containsKey(r15)     // Catch:{ RuntimeException -> 0x0196 }
            if (r1 == 0) goto L_0x00ef
            java.lang.String r1 = "_cer"
            java.lang.String r3 = "gclid=%s"
            r8 = 1
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ RuntimeException -> 0x0196 }
            r8 = 0
            java.lang.String r12 = r6.getString(r15)     // Catch:{ RuntimeException -> 0x0196 }
            r9[r8] = r12     // Catch:{ RuntimeException -> 0x0196 }
            java.lang.String r3 = java.lang.String.format(r3, r9)     // Catch:{ RuntimeException -> 0x0196 }
            r0.putString(r1, r3)     // Catch:{ RuntimeException -> 0x0196 }
        L_0x00ef:
            com.google.android.gms.measurement.internal.zzij r1 = r2.zza     // Catch:{ RuntimeException -> 0x0196 }
            r1.zzG(r4, r7, r0)     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzij r1 = r2.zza     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzs r1 = r1.zzb     // Catch:{ RuntimeException -> 0x0196 }
            r1.zza(r4, r0)     // Catch:{ RuntimeException -> 0x0196 }
        L_0x00fb:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0196 }
            if (r0 == 0) goto L_0x0103
            goto L_0x0185
        L_0x0103:
            com.google.android.gms.measurement.internal.zzij r0 = r2.zza     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzge r0 = r0.zzt     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0196 }
            java.lang.String r1 = "Activity created with referrer"
            r0.zzb(r1, r5)     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzij r0 = r2.zza     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzge r0 = r0.zzt     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzeg r1 = com.google.android.gms.measurement.internal.zzeh.zzaa     // Catch:{ RuntimeException -> 0x0196 }
            r3 = 0
            boolean r0 = r0.zzs(r3, r1)     // Catch:{ RuntimeException -> 0x0196 }
            java.lang.String r1 = "_ldl"
            java.lang.String r3 = "auto"
            if (r0 == 0) goto L_0x0151
            if (r6 == 0) goto L_0x0138
            com.google.android.gms.measurement.internal.zzij r0 = r2.zza     // Catch:{ RuntimeException -> 0x0196 }
            r0.zzG(r4, r7, r6)     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzij r0 = r2.zza     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzs r0 = r0.zzb     // Catch:{ RuntimeException -> 0x0196 }
            r0.zza(r4, r6)     // Catch:{ RuntimeException -> 0x0196 }
            goto L_0x0149
        L_0x0138:
            com.google.android.gms.measurement.internal.zzij r0 = r2.zza     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzge r0 = r0.zzt     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0196 }
            java.lang.String r4 = "Referrer does not contain valid parameters"
            r0.zzb(r4, r5)     // Catch:{ RuntimeException -> 0x0196 }
        L_0x0149:
            com.google.android.gms.measurement.internal.zzij r0 = r2.zza     // Catch:{ RuntimeException -> 0x0196 }
            r4 = 1
            r5 = 0
            r0.zzW(r3, r1, r5, r4)     // Catch:{ RuntimeException -> 0x0196 }
            return
        L_0x0151:
            boolean r0 = r5.contains(r15)     // Catch:{ RuntimeException -> 0x0196 }
            if (r0 == 0) goto L_0x0186
            boolean r0 = r5.contains(r14)     // Catch:{ RuntimeException -> 0x0196 }
            if (r0 != 0) goto L_0x0179
            boolean r0 = r5.contains(r13)     // Catch:{ RuntimeException -> 0x0196 }
            if (r0 != 0) goto L_0x0179
            boolean r0 = r5.contains(r11)     // Catch:{ RuntimeException -> 0x0196 }
            if (r0 != 0) goto L_0x0179
            java.lang.String r0 = "utm_term"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x0196 }
            if (r0 != 0) goto L_0x0179
            java.lang.String r0 = "utm_content"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x0196 }
            if (r0 == 0) goto L_0x0186
        L_0x0179:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0196 }
            if (r0 != 0) goto L_0x0185
            com.google.android.gms.measurement.internal.zzij r0 = r2.zza     // Catch:{ RuntimeException -> 0x0196 }
            r4 = 1
            r0.zzW(r3, r1, r5, r4)     // Catch:{ RuntimeException -> 0x0196 }
        L_0x0185:
            return
        L_0x0186:
            com.google.android.gms.measurement.internal.zzij r0 = r2.zza     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzge r0 = r0.zzt     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()     // Catch:{ RuntimeException -> 0x0196 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0196 }
            r0.zza(r10)     // Catch:{ RuntimeException -> 0x0196 }
            return
        L_0x0196:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzij r1 = r2.zza
            com.google.android.gms.measurement.internal.zzge r1 = r1.zzt
            com.google.android.gms.measurement.internal.zzeu r1 = r1.zzaA()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzd()
            java.lang.String r2 = "Throwable caught in handleReferrerForOnActivityCreated"
            r1.zzb(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzih.run():void");
    }
}
