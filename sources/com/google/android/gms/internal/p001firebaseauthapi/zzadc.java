package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzadc implements zzaaq {
    private final String zza;
    private final String zzb = "CLIENT_TYPE_ANDROID";
    private final String zzc = "RECAPTCHA_ENTERPRISE";

    private zzadc(String str, String str2) {
        this.zza = str;
    }

    public static zzadc zzb(String str, String str2) {
        return new zzadc(str, "RECAPTCHA_ENTERPRISE");
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.zza)) {
            jSONObject.put("tenantId", this.zza);
        }
        if (!TextUtils.isEmpty(this.zzb)) {
            jSONObject.put("clientType", this.zzb);
        }
        if (!TextUtils.isEmpty(this.zzc)) {
            jSONObject.put("recaptchaVersion", this.zzc);
        }
        return jSONObject.toString();
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }
}
