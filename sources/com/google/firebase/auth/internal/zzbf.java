package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.p001firebaseauthapi.zzam;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.core.ServerValues;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzbf {
    private static final zzam zza = zzam.zzj("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", ServerValues.NAME_OP_TIMESTAMP);
    private static final zzbf zzb = new zzbf();
    private Task zzc;
    private Task zzd;
    private long zze = 0;

    private zzbf() {
    }

    public static zzbf zzc() {
        return zzb;
    }

    private static final void zzf(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        zzam zzam = zza;
        int size = zzam.size();
        for (int i = 0; i < size; i++) {
            edit.remove((String) zzam.get(i));
        }
        edit.commit();
    }

    public final Task zza() {
        if (DefaultClock.getInstance().currentTimeMillis() - this.zze < 3600000) {
            return this.zzc;
        }
        return null;
    }

    public final Task zzb() {
        if (DefaultClock.getInstance().currentTimeMillis() - this.zze < 3600000) {
            return this.zzd;
        }
        return null;
    }

    public final void zzd(Context context) {
        Preconditions.checkNotNull(context);
        zzf(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.zzc = null;
        this.zze = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007f, code lost:
        if (r4.equals("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN") == false) goto L_0x0096;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(com.google.firebase.auth.FirebaseAuth r13) {
        /*
            r12 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            com.google.firebase.FirebaseApp r0 = r13.getApp()
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "com.google.firebase.auth.internal.ProcessDeathHelper"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            java.lang.String r1 = "firebaseAppName"
            java.lang.String r3 = ""
            java.lang.String r1 = r0.getString(r1, r3)
            com.google.firebase.FirebaseApp r4 = r13.getApp()
            java.lang.String r4 = r4.getName()
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L_0x0029
            return
        L_0x0029:
            java.lang.String r1 = "verifyAssertionRequest"
            boolean r4 = r0.contains(r1)
            r5 = -1
            java.lang.String r6 = "operation"
            r7 = 0
            java.lang.String r9 = "timestamp"
            r10 = 0
            if (r4 == 0) goto L_0x00ee
            java.lang.String r1 = r0.getString(r1, r3)
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase-auth-api.zzaec> r4 = com.google.android.gms.internal.p001firebaseauthapi.zzaec.CREATOR
            com.google.android.gms.common.internal.safeparcel.SafeParcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer.deserializeFromString(r1, r4)
            com.google.android.gms.internal.firebase-auth-api.zzaec r1 = (com.google.android.gms.internal.p001firebaseauthapi.zzaec) r1
            java.lang.String r4 = r0.getString(r6, r3)
            java.lang.String r6 = "tenantId"
            java.lang.String r6 = r0.getString(r6, r10)
            java.lang.String r11 = "firebaseUserUid"
            java.lang.String r3 = r0.getString(r11, r3)
            long r7 = r0.getLong(r9, r7)
            r12.zze = r7
            if (r6 == 0) goto L_0x0063
            r13.setTenantId(r6)
            r1.zzf(r6)
        L_0x0063:
            int r6 = r4.hashCode()
            r7 = -98509410(0xfffffffffa20dd9e, float:-2.088156E35)
            r8 = 2
            r9 = 1
            if (r6 == r7) goto L_0x008c
            r7 = 175006864(0xa6e6490, float:1.1478197E-32)
            if (r6 == r7) goto L_0x0082
            r7 = 1450464913(0x56745691, float:6.7163159E13)
            if (r6 == r7) goto L_0x0079
            goto L_0x0096
        L_0x0079:
            java.lang.String r6 = "com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0096
            goto L_0x0097
        L_0x0082:
            java.lang.String r2 = "com.google.firebase.auth.internal.NONGMSCORE_LINK"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0096
            r2 = 1
            goto L_0x0097
        L_0x008c:
            java.lang.String r2 = "com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0096
            r2 = 2
            goto L_0x0097
        L_0x0096:
            r2 = -1
        L_0x0097:
            if (r2 == 0) goto L_0x00e0
            if (r2 == r9) goto L_0x00c0
            if (r2 == r8) goto L_0x00a0
            r12.zzc = r10
            goto L_0x00ea
        L_0x00a0:
            com.google.firebase.auth.FirebaseUser r2 = r13.getCurrentUser()
            java.lang.String r2 = r2.getUid()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00bd
            com.google.firebase.auth.FirebaseUser r2 = r13.getCurrentUser()
            com.google.firebase.auth.zze r1 = com.google.firebase.auth.zze.zzb(r1)
            com.google.android.gms.tasks.Task r13 = r13.zzh(r2, r1)
            r12.zzc = r13
            goto L_0x00ea
        L_0x00bd:
            r12.zzc = r10
            goto L_0x00ea
        L_0x00c0:
            com.google.firebase.auth.FirebaseUser r2 = r13.getCurrentUser()
            java.lang.String r2 = r2.getUid()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00dd
            com.google.firebase.auth.FirebaseUser r2 = r13.getCurrentUser()
            com.google.firebase.auth.zze r1 = com.google.firebase.auth.zze.zzb(r1)
            com.google.android.gms.tasks.Task r13 = r13.zzf(r2, r1)
            r12.zzc = r13
            goto L_0x00ea
        L_0x00dd:
            r12.zzc = r10
            goto L_0x00ea
        L_0x00e0:
            com.google.firebase.auth.zze r1 = com.google.firebase.auth.zze.zzb(r1)
            com.google.android.gms.tasks.Task r13 = r13.signInWithCredential(r1)
            r12.zzc = r13
        L_0x00ea:
            zzf(r0)
            return
        L_0x00ee:
            java.lang.String r13 = "recaptchaToken"
            boolean r1 = r0.contains(r13)
            if (r1 == 0) goto L_0x0127
            java.lang.String r13 = r0.getString(r13, r3)
            java.lang.String r1 = r0.getString(r6, r3)
            long r3 = r0.getLong(r9, r7)
            r12.zze = r3
            int r3 = r1.hashCode()
            r4 = -214796028(0xfffffffff3327904, float:-1.4140065E31)
            if (r3 == r4) goto L_0x010e
            goto L_0x0117
        L_0x010e:
            java.lang.String r3 = "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0117
            goto L_0x0118
        L_0x0117:
            r2 = -1
        L_0x0118:
            if (r2 == 0) goto L_0x011d
            r12.zzd = r10
            goto L_0x0123
        L_0x011d:
            com.google.android.gms.tasks.Task r13 = com.google.android.gms.tasks.Tasks.forResult(r13)
            r12.zzd = r13
        L_0x0123:
            zzf(r0)
            return
        L_0x0127:
            java.lang.String r13 = "statusCode"
            boolean r1 = r0.contains(r13)
            if (r1 == 0) goto L_0x0153
            r1 = 17062(0x42a6, float:2.3909E-41)
            int r13 = r0.getInt(r13, r1)
            java.lang.String r1 = "statusMessage"
            java.lang.String r1 = r0.getString(r1, r3)
            com.google.android.gms.common.api.Status r2 = new com.google.android.gms.common.api.Status
            r2.<init>((int) r13, (java.lang.String) r1)
            long r3 = r0.getLong(r9, r7)
            r12.zze = r3
            zzf(r0)
            com.google.firebase.FirebaseException r13 = com.google.android.gms.internal.p001firebaseauthapi.zzaag.zza(r2)
            com.google.android.gms.tasks.Task r13 = com.google.android.gms.tasks.Tasks.forException(r13)
            r12.zzc = r13
        L_0x0153:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzbf.zze(com.google.firebase.auth.FirebaseAuth):void");
    }
}
