package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzet;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
final class zzz extends zzy {
    final /* synthetic */ zzaa zza;
    private final zzet zzh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzz(zzaa zzaa, String str, int i, zzet zzet) {
        super(str, i);
        this.zza = zzaa;
        this.zzh = zzet;
    }

    /* access modifiers changed from: package-private */
    public final int zza() {
        return this.zzh.zza();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc() {
        return true;
    }

    /* JADX WARNING: type inference failed for: r2v18, types: [java.lang.Integer] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzd(java.lang.Long r11, java.lang.Long r12, com.google.android.gms.internal.measurement.zzgm r13, boolean r14) {
        /*
            r10 = this;
            com.google.android.gms.internal.measurement.zzov.zzc()
            com.google.android.gms.measurement.internal.zzaa r0 = r10.zza
            com.google.android.gms.measurement.internal.zzge r0 = r0.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            java.lang.String r1 = r10.zzb
            com.google.android.gms.measurement.internal.zzeg r2 = com.google.android.gms.measurement.internal.zzeh.zzW
            boolean r0 = r0.zzs(r1, r2)
            com.google.android.gms.internal.measurement.zzet r1 = r10.zzh
            boolean r1 = r1.zzg()
            com.google.android.gms.internal.measurement.zzet r2 = r10.zzh
            boolean r2 = r2.zzh()
            com.google.android.gms.internal.measurement.zzet r3 = r10.zzh
            boolean r3 = r3.zzi()
            r4 = 0
            r5 = 1
            if (r1 != 0) goto L_0x0030
            if (r2 != 0) goto L_0x0030
            if (r3 == 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r1 = 0
            goto L_0x0031
        L_0x0030:
            r1 = 1
        L_0x0031:
            r2 = 0
            if (r14 == 0) goto L_0x0060
            if (r1 != 0) goto L_0x0060
            com.google.android.gms.measurement.internal.zzaa r11 = r10.zza
            com.google.android.gms.measurement.internal.zzge r11 = r11.zzt
            com.google.android.gms.measurement.internal.zzeu r11 = r11.zzaA()
            com.google.android.gms.measurement.internal.zzes r11 = r11.zzj()
            int r12 = r10.zzc
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            com.google.android.gms.internal.measurement.zzet r13 = r10.zzh
            boolean r13 = r13.zzj()
            if (r13 == 0) goto L_0x005a
            com.google.android.gms.internal.measurement.zzet r13 = r10.zzh
            int r13 = r13.zza()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
        L_0x005a:
            java.lang.String r13 = "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r11.zzc(r13, r12, r2)
            return r5
        L_0x0060:
            com.google.android.gms.internal.measurement.zzet r6 = r10.zzh
            com.google.android.gms.internal.measurement.zzem r6 = r6.zzb()
            boolean r7 = r6.zzg()
            boolean r8 = r13.zzr()
            if (r8 == 0) goto L_0x00ab
            boolean r8 = r6.zzi()
            if (r8 != 0) goto L_0x0099
            com.google.android.gms.measurement.internal.zzaa r6 = r10.zza
            com.google.android.gms.measurement.internal.zzge r6 = r6.zzt
            com.google.android.gms.measurement.internal.zzeu r6 = r6.zzaA()
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzk()
            com.google.android.gms.measurement.internal.zzaa r7 = r10.zza
            com.google.android.gms.measurement.internal.zzge r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzep r7 = r7.zzj()
            java.lang.String r8 = r13.zzf()
            java.lang.String r7 = r7.zzf(r8)
            java.lang.String r8 = "No number filter for long property. property"
            r6.zzb(r8, r7)
            goto L_0x019c
        L_0x0099:
            long r8 = r13.zzb()
            com.google.android.gms.internal.measurement.zzer r2 = r6.zzc()
            java.lang.Boolean r2 = zzh(r8, r2)
            java.lang.Boolean r2 = zzj(r2, r7)
            goto L_0x019c
        L_0x00ab:
            boolean r8 = r13.zzq()
            if (r8 == 0) goto L_0x00ec
            boolean r8 = r6.zzi()
            if (r8 != 0) goto L_0x00da
            com.google.android.gms.measurement.internal.zzaa r6 = r10.zza
            com.google.android.gms.measurement.internal.zzge r6 = r6.zzt
            com.google.android.gms.measurement.internal.zzeu r6 = r6.zzaA()
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzk()
            com.google.android.gms.measurement.internal.zzaa r7 = r10.zza
            com.google.android.gms.measurement.internal.zzge r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzep r7 = r7.zzj()
            java.lang.String r8 = r13.zzf()
            java.lang.String r7 = r7.zzf(r8)
            java.lang.String r8 = "No number filter for double property. property"
            r6.zzb(r8, r7)
            goto L_0x019c
        L_0x00da:
            double r8 = r13.zza()
            com.google.android.gms.internal.measurement.zzer r2 = r6.zzc()
            java.lang.Boolean r2 = zzg(r8, r2)
            java.lang.Boolean r2 = zzj(r2, r7)
            goto L_0x019c
        L_0x00ec:
            boolean r8 = r13.zzt()
            if (r8 == 0) goto L_0x017b
            boolean r8 = r6.zzk()
            if (r8 != 0) goto L_0x0162
            boolean r8 = r6.zzi()
            if (r8 != 0) goto L_0x0121
            com.google.android.gms.measurement.internal.zzaa r6 = r10.zza
            com.google.android.gms.measurement.internal.zzge r6 = r6.zzt
            com.google.android.gms.measurement.internal.zzeu r6 = r6.zzaA()
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzk()
            com.google.android.gms.measurement.internal.zzaa r7 = r10.zza
            com.google.android.gms.measurement.internal.zzge r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzep r7 = r7.zzj()
            java.lang.String r8 = r13.zzf()
            java.lang.String r7 = r7.zzf(r8)
            java.lang.String r8 = "No string or number filter defined. property"
            r6.zzb(r8, r7)
            goto L_0x019c
        L_0x0121:
            java.lang.String r8 = r13.zzg()
            boolean r8 = com.google.android.gms.measurement.internal.zzli.zzx(r8)
            if (r8 == 0) goto L_0x013c
            java.lang.String r2 = r13.zzg()
            com.google.android.gms.internal.measurement.zzer r6 = r6.zzc()
            java.lang.Boolean r2 = zzi(r2, r6)
            java.lang.Boolean r2 = zzj(r2, r7)
            goto L_0x019c
        L_0x013c:
            com.google.android.gms.measurement.internal.zzaa r6 = r10.zza
            com.google.android.gms.measurement.internal.zzge r6 = r6.zzt
            com.google.android.gms.measurement.internal.zzeu r6 = r6.zzaA()
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzk()
            com.google.android.gms.measurement.internal.zzaa r7 = r10.zza
            com.google.android.gms.measurement.internal.zzge r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzep r7 = r7.zzj()
            java.lang.String r8 = r13.zzf()
            java.lang.String r7 = r7.zzf(r8)
            java.lang.String r8 = r13.zzg()
            java.lang.String r9 = "Invalid user property value for Numeric number filter. property, value"
            r6.zzc(r9, r7, r8)
            goto L_0x019c
        L_0x0162:
            java.lang.String r2 = r13.zzg()
            com.google.android.gms.internal.measurement.zzey r6 = r6.zzd()
            com.google.android.gms.measurement.internal.zzaa r8 = r10.zza
            com.google.android.gms.measurement.internal.zzge r8 = r8.zzt
            com.google.android.gms.measurement.internal.zzeu r8 = r8.zzaA()
            java.lang.Boolean r2 = zzf(r2, r6, r8)
            java.lang.Boolean r2 = zzj(r2, r7)
            goto L_0x019c
        L_0x017b:
            com.google.android.gms.measurement.internal.zzaa r6 = r10.zza
            com.google.android.gms.measurement.internal.zzge r6 = r6.zzt
            com.google.android.gms.measurement.internal.zzeu r6 = r6.zzaA()
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzk()
            com.google.android.gms.measurement.internal.zzaa r7 = r10.zza
            com.google.android.gms.measurement.internal.zzge r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzep r7 = r7.zzj()
            java.lang.String r8 = r13.zzf()
            java.lang.String r7 = r7.zzf(r8)
            java.lang.String r8 = "User property has no value, property"
            r6.zzb(r8, r7)
        L_0x019c:
            com.google.android.gms.measurement.internal.zzaa r6 = r10.zza
            com.google.android.gms.measurement.internal.zzge r6 = r6.zzt
            com.google.android.gms.measurement.internal.zzeu r6 = r6.zzaA()
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzj()
            if (r2 != 0) goto L_0x01ad
            java.lang.String r7 = "null"
            goto L_0x01ae
        L_0x01ad:
            r7 = r2
        L_0x01ae:
            java.lang.String r8 = "Property filter result"
            r6.zzb(r8, r7)
            if (r2 != 0) goto L_0x01b6
            return r4
        L_0x01b6:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r5)
            r10.zzd = r4
            if (r3 == 0) goto L_0x01c6
            boolean r3 = r2.booleanValue()
            if (r3 == 0) goto L_0x01c5
            goto L_0x01c6
        L_0x01c5:
            return r5
        L_0x01c6:
            if (r14 == 0) goto L_0x01d0
            com.google.android.gms.internal.measurement.zzet r14 = r10.zzh
            boolean r14 = r14.zzg()
            if (r14 == 0) goto L_0x01d2
        L_0x01d0:
            r10.zze = r2
        L_0x01d2:
            boolean r14 = r2.booleanValue()
            if (r14 == 0) goto L_0x0217
            if (r1 == 0) goto L_0x0217
            boolean r14 = r13.zzs()
            if (r14 == 0) goto L_0x0217
            long r13 = r13.zzc()
            if (r11 == 0) goto L_0x01ea
            long r13 = r11.longValue()
        L_0x01ea:
            if (r0 == 0) goto L_0x0202
            com.google.android.gms.internal.measurement.zzet r11 = r10.zzh
            boolean r11 = r11.zzg()
            if (r11 == 0) goto L_0x0202
            com.google.android.gms.internal.measurement.zzet r11 = r10.zzh
            boolean r11 = r11.zzh()
            if (r11 != 0) goto L_0x0202
            if (r12 == 0) goto L_0x0202
            long r13 = r12.longValue()
        L_0x0202:
            com.google.android.gms.internal.measurement.zzet r11 = r10.zzh
            boolean r11 = r11.zzh()
            if (r11 == 0) goto L_0x0211
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r10.zzg = r11
            goto L_0x0217
        L_0x0211:
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r10.zzf = r11
        L_0x0217:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzz.zzd(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.zzgm, boolean):boolean");
    }
}
