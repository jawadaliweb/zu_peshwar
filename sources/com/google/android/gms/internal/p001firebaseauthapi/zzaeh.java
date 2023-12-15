package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaeh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzaeh implements zzaaq {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;

    public zzaeh(String str, String str2, String str3, String str4) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = str3;
        this.zzd = str4;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("email", this.zza);
        jSONObject.put("password", this.zzb);
        jSONObject.put("returnSecureToken", true);
        String str = this.zzc;
        if (str != null) {
            jSONObject.put("tenantId", str);
        }
        String str2 = this.zzd;
        if (str2 != null) {
            zzaen.zzd(jSONObject, "captchaResponse", str2);
        } else {
            zzaen.zzc(jSONObject);
        }
        return jSONObject.toString();
    }
}
