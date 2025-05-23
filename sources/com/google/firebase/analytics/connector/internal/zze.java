package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.2.2 */
public final class zze implements zza {
    final Set zza = new HashSet();
    /* access modifiers changed from: private */
    public final AnalyticsConnector.AnalyticsConnectorListener zzb;
    private final AppMeasurementSdk zzc;
    private final zzd zzd;

    public zze(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zzb = analyticsConnectorListener;
        this.zzc = appMeasurementSdk;
        zzd zzd2 = new zzd(this);
        this.zzd = zzd2;
        appMeasurementSdk.registerOnMeasurementEventListener(zzd2);
    }

    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zzb;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0010 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.util.Set r10) {
        /*
            r9 = this;
            java.util.Set r0 = r9.zza
            r0.clear()
            java.util.Set r0 = r9.zza
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x0010:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L_0x00a1
            java.lang.Object r2 = r10.next()
            java.lang.String r2 = (java.lang.String) r2
            int r3 = r1.size()
            r4 = 50
            if (r3 < r4) goto L_0x0026
            goto L_0x00a1
        L_0x0026:
            int r3 = com.google.firebase.analytics.connector.internal.zzc.zza
            r3 = 95
            r4 = 0
            if (r2 != 0) goto L_0x002f
        L_0x002d:
            r5 = 0
            goto L_0x0063
        L_0x002f:
            int r5 = r2.length()
            if (r5 != 0) goto L_0x0036
            goto L_0x002d
        L_0x0036:
            int r5 = r2.codePointAt(r4)
            boolean r6 = java.lang.Character.isLetter(r5)
            if (r6 != 0) goto L_0x0045
            if (r5 == r3) goto L_0x0043
            goto L_0x002d
        L_0x0043:
            r5 = 95
        L_0x0045:
            int r6 = r2.length()
            int r5 = java.lang.Character.charCount(r5)
        L_0x004d:
            if (r5 >= r6) goto L_0x0062
            int r7 = r2.codePointAt(r5)
            if (r7 == r3) goto L_0x005c
            boolean r8 = java.lang.Character.isLetterOrDigit(r7)
            if (r8 != 0) goto L_0x005c
            goto L_0x002d
        L_0x005c:
            int r7 = java.lang.Character.charCount(r7)
            int r5 = r5 + r7
            goto L_0x004d
        L_0x0062:
            r5 = 1
        L_0x0063:
            if (r5 == 0) goto L_0x0010
            int r5 = r2.length()
            if (r5 == 0) goto L_0x0010
            int r4 = r2.codePointAt(r4)
            boolean r5 = java.lang.Character.isLetter(r4)
            if (r5 == 0) goto L_0x0010
            int r5 = r2.length()
            int r4 = java.lang.Character.charCount(r4)
        L_0x007d:
            if (r4 >= r5) goto L_0x0091
            int r6 = r2.codePointAt(r4)
            if (r6 == r3) goto L_0x008b
            boolean r7 = java.lang.Character.isLetterOrDigit(r6)
            if (r7 == 0) goto L_0x0010
        L_0x008b:
            int r6 = java.lang.Character.charCount(r6)
            int r4 = r4 + r6
            goto L_0x007d
        L_0x0091:
            java.lang.String r3 = com.google.android.gms.measurement.internal.zzhb.zzb(r2)
            if (r3 != 0) goto L_0x0098
            goto L_0x0099
        L_0x0098:
            r2 = r3
        L_0x0099:
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)
            r1.add(r2)
            goto L_0x0010
        L_0x00a1:
            r0.addAll(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.analytics.connector.internal.zze.zzb(java.util.Set):void");
    }

    public final void zzc() {
        this.zza.clear();
    }
}
