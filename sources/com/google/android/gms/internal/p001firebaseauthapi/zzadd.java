package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzadd implements zzaar {
    private static final String zza = "zzadd";
    private String zzb;
    private zzam zzc;
    private boolean zzd = false;

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0074 A[Catch:{ NullPointerException | JSONException -> 0x00ae }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ com.google.android.gms.internal.p001firebaseauthapi.zzaar zza(java.lang.String r8) throws com.google.android.gms.internal.p001firebaseauthapi.zzyi {
        /*
            r7 = this;
            java.lang.String r0 = "recaptchaEnforcementState"
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            r1.<init>(r8)     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            java.lang.String r2 = "recaptchaKey"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            java.lang.String r2 = com.google.android.gms.common.util.Strings.emptyToNull(r2)     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            r7.zzb = r2     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            boolean r2 = r1.has(r0)     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            if (r2 == 0) goto L_0x00ad
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            r1 = 0
            if (r0 == 0) goto L_0x0065
            int r2 = r0.length()     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            if (r2 != 0) goto L_0x0027
            goto L_0x0065
        L_0x0027:
            com.google.android.gms.internal.firebase-auth-api.zzaj r2 = new com.google.android.gms.internal.firebase-auth-api.zzaj     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            r2.<init>()     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            r3 = 0
        L_0x002d:
            int r4 = r0.length()     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            if (r3 >= r4) goto L_0x0060
            org.json.JSONObject r4 = r0.getJSONObject(r3)     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            if (r4 != 0) goto L_0x0040
            com.google.android.gms.internal.firebase-auth-api.zzacg r4 = new com.google.android.gms.internal.firebase-auth-api.zzacg     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            r5 = 0
            r4.<init>(r5, r5)     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            goto L_0x005a
        L_0x0040:
            java.lang.String r5 = "provider"
            java.lang.String r5 = r4.optString(r5)     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            java.lang.String r5 = com.google.android.gms.common.util.Strings.emptyToNull(r5)     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            java.lang.String r6 = "enforcementState"
            java.lang.String r4 = r4.optString(r6)     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            java.lang.String r4 = com.google.android.gms.common.util.Strings.emptyToNull(r4)     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            com.google.android.gms.internal.firebase-auth-api.zzacg r6 = new com.google.android.gms.internal.firebase-auth-api.zzacg     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            r6.<init>(r5, r4)     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            r4 = r6
        L_0x005a:
            r2.zzb(r4)     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            int r3 = r3 + 1
            goto L_0x002d
        L_0x0060:
            com.google.android.gms.internal.firebase-auth-api.zzam r0 = r2.zzc()     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            goto L_0x006e
        L_0x0065:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            r0.<init>()     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            com.google.android.gms.internal.firebase-auth-api.zzam r0 = com.google.android.gms.internal.p001firebaseauthapi.zzam.zzh(r0)     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
        L_0x006e:
            r7.zzc = r0     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            java.lang.String r2 = "EMAIL_PASSWORD_PROVIDER"
            if (r0 == 0) goto L_0x00ab
            boolean r3 = r0.isEmpty()     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            if (r3 == 0) goto L_0x007b
            goto L_0x00ab
        L_0x007b:
            java.lang.Object r3 = r0.get(r1)     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            com.google.android.gms.internal.firebase-auth-api.zzadl r3 = (com.google.android.gms.internal.p001firebaseauthapi.zzadl) r3     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            java.lang.String r3 = r3.zza()     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            com.google.android.gms.internal.firebase-auth-api.zzadl r0 = (com.google.android.gms.internal.p001firebaseauthapi.zzadl) r0     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            java.lang.String r0 = r0.zzb()     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            if (r3 == 0) goto L_0x00ab
            if (r0 != 0) goto L_0x0094
            goto L_0x00ab
        L_0x0094:
            java.lang.String r4 = "ENFORCE"
            boolean r4 = r3.equals(r4)     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            if (r4 != 0) goto L_0x00a4
            java.lang.String r4 = "AUDIT"
            boolean r3 = r3.equals(r4)     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            if (r3 == 0) goto L_0x00ab
        L_0x00a4:
            boolean r0 = r0.equals(r2)     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
            if (r0 == 0) goto L_0x00ab
            r1 = 1
        L_0x00ab:
            r7.zzd = r1     // Catch:{ JSONException -> 0x00b0, NullPointerException -> 0x00ae }
        L_0x00ad:
            return r7
        L_0x00ae:
            r0 = move-exception
            goto L_0x00b1
        L_0x00b0:
            r0 = move-exception
        L_0x00b1:
            java.lang.String r1 = zza
            com.google.android.gms.internal.firebase-auth-api.zzyi r8 = com.google.android.gms.internal.p001firebaseauthapi.zzaen.zza(r0, r1, r8)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzadd.zza(java.lang.String):com.google.android.gms.internal.firebase-auth-api.zzaar");
    }

    public final String zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zzd;
    }
}
