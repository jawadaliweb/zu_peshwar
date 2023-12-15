package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.ActionCodeSettings;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzacx implements zzaaq {
    private final String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private ActionCodeSettings zze;
    private String zzf;
    private String zzg;

    public zzacx(int i) {
        this.zza = i != 1 ? i != 4 ? i != 6 ? i != 7 ? "REQUEST_TYPE_UNSET_ENUM_VALUE" : "VERIFY_AND_CHANGE_EMAIL" : "EMAIL_SIGNIN" : "VERIFY_EMAIL" : "PASSWORD_RESET";
    }

    private zzacx(int i, ActionCodeSettings actionCodeSettings, String str, String str2, String str3, String str4, String str5) {
        this.zza = "VERIFY_AND_CHANGE_EMAIL";
        this.zze = (ActionCodeSettings) Preconditions.checkNotNull(actionCodeSettings);
        this.zzb = null;
        this.zzc = str2;
        this.zzd = str3;
        this.zzf = null;
        this.zzg = null;
    }

    public static zzacx zzc(ActionCodeSettings actionCodeSettings, String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(actionCodeSettings);
        return new zzacx(7, actionCodeSettings, (String) null, str2, str, (String) null, (String) null);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza() throws org.json.JSONException {
        /*
            r7 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = r7.zza
            int r2 = r1.hashCode()
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r2) {
                case -1452371317: goto L_0x0031;
                case -1341836234: goto L_0x0027;
                case -1099157829: goto L_0x001d;
                case 870738373: goto L_0x0013;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x003b
        L_0x0013:
            java.lang.String r2 = "EMAIL_SIGNIN"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x003b
            r1 = 2
            goto L_0x003c
        L_0x001d:
            java.lang.String r2 = "VERIFY_AND_CHANGE_EMAIL"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x003b
            r1 = 3
            goto L_0x003c
        L_0x0027:
            java.lang.String r2 = "VERIFY_EMAIL"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x003b
            r1 = 1
            goto L_0x003c
        L_0x0031:
            java.lang.String r2 = "PASSWORD_RESET"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x003b
            r1 = 0
            goto L_0x003c
        L_0x003b:
            r1 = -1
        L_0x003c:
            if (r1 == 0) goto L_0x004b
            if (r1 == r6) goto L_0x0049
            if (r1 == r5) goto L_0x0047
            if (r1 == r4) goto L_0x0045
            goto L_0x004c
        L_0x0045:
            r3 = 7
            goto L_0x004c
        L_0x0047:
            r3 = 6
            goto L_0x004c
        L_0x0049:
            r3 = 4
            goto L_0x004c
        L_0x004b:
            r3 = 1
        L_0x004c:
            java.lang.String r1 = "requestType"
            r0.put(r1, r3)
            java.lang.String r1 = r7.zzb
            if (r1 == 0) goto L_0x005a
            java.lang.String r2 = "email"
            r0.put(r2, r1)
        L_0x005a:
            java.lang.String r1 = r7.zzc
            if (r1 == 0) goto L_0x0063
            java.lang.String r2 = "newEmail"
            r0.put(r2, r1)
        L_0x0063:
            java.lang.String r1 = r7.zzd
            if (r1 == 0) goto L_0x006c
            java.lang.String r2 = "idToken"
            r0.put(r2, r1)
        L_0x006c:
            com.google.firebase.auth.ActionCodeSettings r1 = r7.zze
            if (r1 == 0) goto L_0x00f6
            boolean r1 = r1.getAndroidInstallApp()
            java.lang.String r2 = "androidInstallApp"
            r0.put(r2, r1)
            com.google.firebase.auth.ActionCodeSettings r1 = r7.zze
            boolean r1 = r1.canHandleCodeInApp()
            java.lang.String r2 = "canHandleCodeInApp"
            r0.put(r2, r1)
            com.google.firebase.auth.ActionCodeSettings r1 = r7.zze
            java.lang.String r1 = r1.getUrl()
            if (r1 == 0) goto L_0x0097
            com.google.firebase.auth.ActionCodeSettings r1 = r7.zze
            java.lang.String r1 = r1.getUrl()
            java.lang.String r2 = "continueUrl"
            r0.put(r2, r1)
        L_0x0097:
            com.google.firebase.auth.ActionCodeSettings r1 = r7.zze
            java.lang.String r1 = r1.getIOSBundle()
            if (r1 == 0) goto L_0x00aa
            com.google.firebase.auth.ActionCodeSettings r1 = r7.zze
            java.lang.String r1 = r1.getIOSBundle()
            java.lang.String r2 = "iosBundleId"
            r0.put(r2, r1)
        L_0x00aa:
            com.google.firebase.auth.ActionCodeSettings r1 = r7.zze
            java.lang.String r1 = r1.zzd()
            if (r1 == 0) goto L_0x00bd
            com.google.firebase.auth.ActionCodeSettings r1 = r7.zze
            java.lang.String r1 = r1.zzd()
            java.lang.String r2 = "iosAppStoreId"
            r0.put(r2, r1)
        L_0x00bd:
            com.google.firebase.auth.ActionCodeSettings r1 = r7.zze
            java.lang.String r1 = r1.getAndroidPackageName()
            if (r1 == 0) goto L_0x00d0
            com.google.firebase.auth.ActionCodeSettings r1 = r7.zze
            java.lang.String r1 = r1.getAndroidPackageName()
            java.lang.String r2 = "androidPackageName"
            r0.put(r2, r1)
        L_0x00d0:
            com.google.firebase.auth.ActionCodeSettings r1 = r7.zze
            java.lang.String r1 = r1.getAndroidMinimumVersion()
            if (r1 == 0) goto L_0x00e3
            com.google.firebase.auth.ActionCodeSettings r1 = r7.zze
            java.lang.String r1 = r1.getAndroidMinimumVersion()
            java.lang.String r2 = "androidMinimumVersion"
            r0.put(r2, r1)
        L_0x00e3:
            com.google.firebase.auth.ActionCodeSettings r1 = r7.zze
            java.lang.String r1 = r1.zzc()
            if (r1 == 0) goto L_0x00f6
            com.google.firebase.auth.ActionCodeSettings r1 = r7.zze
            java.lang.String r1 = r1.zzc()
            java.lang.String r2 = "dynamicLinkDomain"
            r0.put(r2, r1)
        L_0x00f6:
            java.lang.String r1 = r7.zzf
            if (r1 == 0) goto L_0x00ff
            java.lang.String r2 = "tenantId"
            r0.put(r2, r1)
        L_0x00ff:
            java.lang.String r1 = r7.zzg
            if (r1 == 0) goto L_0x0109
            java.lang.String r2 = "captchaResp"
            com.google.android.gms.internal.p001firebaseauthapi.zzaen.zzd(r0, r2, r1)
            goto L_0x010c
        L_0x0109:
            com.google.android.gms.internal.p001firebaseauthapi.zzaen.zzc(r0)
        L_0x010c:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzacx.zza():java.lang.String");
    }

    public final ActionCodeSettings zzb() {
        return this.zze;
    }

    public final zzacx zzd(ActionCodeSettings actionCodeSettings) {
        this.zze = (ActionCodeSettings) Preconditions.checkNotNull(actionCodeSettings);
        return this;
    }

    public final zzacx zze(String str) {
        this.zzg = str;
        return this;
    }

    public final zzacx zzf(String str) {
        this.zzb = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzacx zzg(String str) {
        this.zzf = str;
        return this;
    }

    public final zzacx zzh(String str) {
        this.zzd = Preconditions.checkNotEmpty(str);
        return this;
    }
}
