package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzadi {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final zzaea zze;
    private String zzf;

    public zzadi(String str, String str2, String str3, long j, zzaea zzaea) {
        if (TextUtils.isEmpty(str) || zzaea == null) {
            this.zza = str;
            this.zzb = Preconditions.checkNotEmpty(str2);
            this.zzc = str3;
            this.zzd = j;
            this.zze = zzaea;
            return;
        }
        Log.e("MfaInfo", "Cannot have both MFA phone_info and totp_info");
        throw new IllegalArgumentException("Cannot have both MFA phone_info and totp_info");
    }

    public static zzadi zzb(JSONObject jSONObject) {
        zzadi zzadi = new zzadi(jSONObject.optString("phoneInfo", (String) null), jSONObject.optString("mfaEnrollmentId", (String) null), jSONObject.optString("displayName", (String) null), zzh(jSONObject.optString("enrolledAt", "")), jSONObject.opt("totpInfo") != null ? new zzaea() : null);
        zzadi.zzf = jSONObject.optString("unobfuscatedPhoneInfo");
        return zzadi;
    }

    public static List zzg(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(zzb(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    private static long zzh(String str) {
        try {
            zzait zzb2 = zzajo.zzb(str);
            zzajo.zza(zzb2);
            return zzb2.zzb();
        } catch (ParseException e) {
            Log.w("MfaInfo", "Could not parse timestamp as ISOString. Invalid ISOString \"" + str + "\"", e);
            return 0;
        }
    }

    public final long zza() {
        return this.zzd;
    }

    public final zzaea zzc() {
        return this.zze;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzb;
    }

    public final String zzf() {
        return this.zza;
    }
}
