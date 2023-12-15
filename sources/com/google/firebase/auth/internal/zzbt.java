package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.p001firebaseauthapi.zzade;
import com.google.android.gms.internal.p001firebaseauthapi.zzvz;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorInfo;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzbt {
    private final Context zza;
    private final String zzb;
    private final SharedPreferences zzc;
    private final Logger zzd = new Logger("StorageHelpers", new String[0]);

    public zzbt(Context context, String str) {
        Preconditions.checkNotNull(context);
        String checkNotEmpty = Preconditions.checkNotEmpty(str);
        this.zzb = checkNotEmpty;
        Context applicationContext = context.getApplicationContext();
        this.zza = applicationContext;
        this.zzc = applicationContext.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", new Object[]{checkNotEmpty}), 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r15v6, types: [com.google.firebase.auth.zzau] */
    /* JADX WARNING: type inference failed for: r15v7, types: [com.google.firebase.auth.PhoneMultiFactorInfo] */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x017b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cd A[SYNTHETIC, Splitter:B:33:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x017b A[ExcHandler: zzvz | ArrayIndexOutOfBoundsException | IllegalArgumentException (e java.lang.Throwable), Splitter:B:1:0x0009] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.firebase.auth.internal.zzx zzf(org.json.JSONObject r27) {
        /*
            r26 = this;
            r0 = r27
            java.lang.String r1 = "userMultiFactorInfo"
            java.lang.String r2 = "userMetadata"
            r3 = 0
            java.lang.String r4 = "cachedTokenState"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r5 = "applicationName"
            java.lang.String r5 = r0.getString(r5)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r6 = "anonymous"
            boolean r6 = r0.getBoolean(r6)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r7 = "2"
            java.lang.String r8 = "version"
            java.lang.String r8 = r0.getString(r8)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            if (r8 == 0) goto L_0x0024
            r7 = r8
        L_0x0024:
            java.lang.String r8 = "userInfos"
            org.json.JSONArray r8 = r0.getJSONArray(r8)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            int r9 = r8.length()     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            r10.<init>(r9)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            r12 = 0
        L_0x0034:
            java.lang.String r13 = "phoneNumber"
            java.lang.String r14 = "displayName"
            if (r12 >= r9) goto L_0x008c
            java.lang.String r15 = r8.getString(r12)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            android.os.Parcelable$Creator<com.google.firebase.auth.internal.zzt> r16 = com.google.firebase.auth.internal.zzt.CREATOR     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            r11.<init>(r15)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r15 = "userId"
            java.lang.String r18 = r11.optString(r15)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r15 = "providerId"
            java.lang.String r19 = r11.optString(r15)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r15 = "email"
            java.lang.String r20 = r11.optString(r15)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r21 = r11.optString(r13)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r22 = r11.optString(r14)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r13 = "photoUrl"
            java.lang.String r23 = r11.optString(r13)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r13 = "isEmailVerified"
            boolean r24 = r11.optBoolean(r13)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r13 = "rawUserInfo"
            java.lang.String r25 = r11.optString(r13)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            com.google.firebase.auth.internal.zzt r11 = new com.google.firebase.auth.internal.zzt     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            r17 = r11
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            r10.add(r11)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            int r12 = r12 + 1
            goto L_0x0034
        L_0x007e:
            r0 = move-exception
            java.lang.String r1 = "DefaultAuthUserInfo"
            java.lang.String r2 = "Failed to unpack UserInfo from JSON"
            android.util.Log.d(r1, r2)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            com.google.android.gms.internal.firebase-auth-api.zzvz r1 = new com.google.android.gms.internal.firebase-auth-api.zzvz     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            throw r1     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
        L_0x008c:
            com.google.firebase.FirebaseApp r5 = com.google.firebase.FirebaseApp.getInstance(r5)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            com.google.firebase.auth.internal.zzx r8 = new com.google.firebase.auth.internal.zzx     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            r8.<init>(r5, r10)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            if (r5 != 0) goto L_0x00a2
            com.google.android.gms.internal.firebase-auth-api.zzade r4 = com.google.android.gms.internal.p001firebaseauthapi.zzade.zzd(r4)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            r8.zzh(r4)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
        L_0x00a2:
            if (r6 != 0) goto L_0x00a7
            r8.zzm()     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
        L_0x00a7:
            r8.zzl(r7)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            boolean r4 = r0.has(r2)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            if (r4 == 0) goto L_0x00d0
            org.json.JSONObject r2 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            android.os.Parcelable$Creator<com.google.firebase.auth.internal.zzz> r4 = com.google.firebase.auth.internal.zzz.CREATOR     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            if (r2 != 0) goto L_0x00ba
        L_0x00b8:
            r2 = r3
            goto L_0x00cb
        L_0x00ba:
            java.lang.String r4 = "lastSignInTimestamp"
            long r4 = r2.getLong(r4)     // Catch:{ JSONException -> 0x00b8, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r6 = "creationTimestamp"
            long r6 = r2.getLong(r6)     // Catch:{ JSONException -> 0x00b8, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            com.google.firebase.auth.internal.zzz r2 = new com.google.firebase.auth.internal.zzz     // Catch:{ JSONException -> 0x00b8, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            r2.<init>(r4, r6)     // Catch:{ JSONException -> 0x00b8, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
        L_0x00cb:
            if (r2 == 0) goto L_0x00d0
            r8.zzr(r2)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
        L_0x00d0:
            boolean r2 = r0.has(r1)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            if (r2 == 0) goto L_0x017a
            org.json.JSONArray r0 = r0.getJSONArray(r1)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            if (r0 == 0) goto L_0x017a
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            r1.<init>()     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            r11 = 0
        L_0x00e2:
            int r2 = r0.length()     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            if (r11 >= r2) goto L_0x0177
            java.lang.String r2 = r0.getString(r11)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            r4.<init>(r2)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r2 = "factorIdKey"
            java.lang.String r2 = r4.optString(r2)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r5 = "phone"
            boolean r5 = r5.equals(r2)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r6 = "uid"
            java.lang.String r7 = "enrollmentTimestamp"
            if (r5 == 0) goto L_0x012a
            android.os.Parcelable$Creator<com.google.firebase.auth.PhoneMultiFactorInfo> r2 = com.google.firebase.auth.PhoneMultiFactorInfo.CREATOR     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            boolean r2 = r4.has(r7)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            if (r2 == 0) goto L_0x0122
            java.lang.String r16 = r4.optString(r6)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r17 = r4.optString(r14)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            long r18 = r4.optLong(r7)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r20 = r4.optString(r13)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            com.google.firebase.auth.PhoneMultiFactorInfo r2 = new com.google.firebase.auth.PhoneMultiFactorInfo     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            r15 = r2
            r15.<init>(r16, r17, r18, r20)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            goto L_0x0160
        L_0x0122:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r1 = "An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a PhoneMultiFactorInfo instance."
            r0.<init>(r1)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            throw r0     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
        L_0x012a:
            java.lang.String r5 = "totp"
            if (r2 == r5) goto L_0x0139
            if (r2 == 0) goto L_0x0137
            boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            if (r2 == 0) goto L_0x0137
            goto L_0x0139
        L_0x0137:
            r2 = r3
            goto L_0x0160
        L_0x0139:
            android.os.Parcelable$Creator<com.google.firebase.auth.zzau> r2 = com.google.firebase.auth.zzau.CREATOR     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            boolean r2 = r4.has(r7)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            if (r2 == 0) goto L_0x016f
            long r18 = r4.optLong(r7)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r2 = "totpInfo"
            java.lang.Object r2 = r4.opt(r2)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            if (r2 == 0) goto L_0x0167
            com.google.android.gms.internal.firebase-auth-api.zzaea r20 = new com.google.android.gms.internal.firebase-auth-api.zzaea     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            r20.<init>()     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r16 = r4.optString(r6)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r17 = r4.optString(r14)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            com.google.firebase.auth.zzau r2 = new com.google.firebase.auth.zzau     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            r15 = r2
            r15.<init>(r16, r17, r18, r20)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
        L_0x0160:
            r1.add(r2)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            int r11 = r11 + 1
            goto L_0x00e2
        L_0x0167:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r1 = "A totpInfo is required to build a TotpMultiFactorInfo instance."
            r0.<init>(r1)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            throw r0     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
        L_0x016f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            java.lang.String r1 = "An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a TotpMultiFactorInfo instance."
            r0.<init>(r1)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
            throw r0     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
        L_0x0177:
            r8.zzi(r1)     // Catch:{ JSONException -> 0x0181, ArrayIndexOutOfBoundsException -> 0x017f, IllegalArgumentException -> 0x017d, zzvz -> 0x017b }
        L_0x017a:
            return r8
        L_0x017b:
            r0 = move-exception
            goto L_0x0182
        L_0x017d:
            r0 = move-exception
            goto L_0x0182
        L_0x017f:
            r0 = move-exception
            goto L_0x0182
        L_0x0181:
            r0 = move-exception
        L_0x0182:
            r1 = r26
            com.google.android.gms.common.logging.Logger r2 = r1.zzd
            r2.wtf(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzbt.zzf(org.json.JSONObject):com.google.firebase.auth.internal.zzx");
    }

    public final FirebaseUser zza() {
        String string = this.zzc.getString("com.google.firebase.auth.FIREBASE_USER", (String) null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has(CommonProperties.TYPE) && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString(CommonProperties.TYPE))) {
                return zzf(jSONObject);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final zzade zzb(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String string = this.zzc.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), (String) null);
        if (string != null) {
            return zzade.zzd(string);
        }
        return null;
    }

    public final void zzc(String str) {
        this.zzc.edit().remove(str).apply();
    }

    public final void zzd(FirebaseUser firebaseUser) {
        String str;
        Preconditions.checkNotNull(firebaseUser);
        JSONObject jSONObject = new JSONObject();
        if (zzx.class.isAssignableFrom(firebaseUser.getClass())) {
            zzx zzx = (zzx) firebaseUser;
            try {
                jSONObject.put("cachedTokenState", zzx.zzf());
                jSONObject.put("applicationName", zzx.zza().getName());
                jSONObject.put(CommonProperties.TYPE, "com.google.firebase.auth.internal.DefaultFirebaseUser");
                if (zzx.zzo() != null) {
                    JSONArray jSONArray = new JSONArray();
                    List zzo = zzx.zzo();
                    int size = zzo.size();
                    if (zzo.size() > 30) {
                        this.zzd.w("Provider user info list size larger than max size, truncating list to %d. Actual list size: %d", 30, Integer.valueOf(zzo.size()));
                        size = 30;
                    }
                    for (int i = 0; i < size; i++) {
                        jSONArray.put(((zzt) zzo.get(i)).zzb());
                    }
                    jSONObject.put("userInfos", jSONArray);
                }
                jSONObject.put("anonymous", zzx.isAnonymous());
                jSONObject.put("version", ExifInterface.GPS_MEASUREMENT_2D);
                if (zzx.getMetadata() != null) {
                    jSONObject.put("userMetadata", ((zzz) zzx.getMetadata()).zza());
                }
                List<MultiFactorInfo> enrolledFactors = new zzac(zzx).getEnrolledFactors();
                if (!enrolledFactors.isEmpty()) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i2 = 0; i2 < enrolledFactors.size(); i2++) {
                        jSONArray2.put(enrolledFactors.get(i2).toJson());
                    }
                    jSONObject.put("userMultiFactorInfo", jSONArray2);
                }
                str = jSONObject.toString();
            } catch (Exception e) {
                this.zzd.wtf("Failed to turn object into JSON", e, new Object[0]);
                throw new zzvz(e);
            }
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            this.zzc.edit().putString("com.google.firebase.auth.FIREBASE_USER", str).apply();
        }
    }

    public final void zze(FirebaseUser firebaseUser, zzade zzade) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzade);
        this.zzc.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), zzade.zzh()).apply();
    }
}
