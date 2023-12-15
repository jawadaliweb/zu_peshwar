package com.google.android.gms.internal.p001firebaseauthapi;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzadh {
    private String zza;
    private String zzb;
    private String zzc;
    private Long zzd;
    private Long zze;

    public static zzadh zza(String str) throws UnsupportedEncodingException {
        try {
            zzadh zzadh = new zzadh();
            JSONObject jSONObject = new JSONObject(str);
            zzadh.zza = jSONObject.optString("iss");
            zzadh.zzb = jSONObject.optString("aud");
            zzadh.zzc = jSONObject.optString("sub");
            zzadh.zzd = Long.valueOf(jSONObject.optLong("iat"));
            zzadh.zze = Long.valueOf(jSONObject.optLong("exp"));
            jSONObject.optBoolean("is_anonymous");
            return zzadh;
        } catch (JSONException e) {
            if (Log.isLoggable("JwtToken", 3)) {
                Log.d("JwtToken", "Failed to read JwtToken from JSONObject. ".concat(e.toString()));
            }
            throw new UnsupportedEncodingException("Failed to read JwtToken from JSONObject. ".concat(e.toString()));
        }
    }

    public final Long zzb() {
        return this.zze;
    }

    public final Long zzc() {
        return this.zzd;
    }
}
