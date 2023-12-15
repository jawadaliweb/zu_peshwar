package com.google.android.gms.internal.p001firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public class zzadu implements zzaar {
    private static final String zza = "zzadu";

    /* renamed from: zzb */
    public zzadu zza(String str) throws zzyi {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optJSONObject("phoneSessionInfo") != null) {
                zzady zzady = new zzady();
                zzady.zzd(str);
                return zzady;
            } else if (jSONObject.optJSONObject("totpSessionInfo") != null) {
                throw new IllegalArgumentException("Not Implemented.");
            } else {
                throw new IllegalArgumentException("Missing phoneSessionInfo or totpSessionInfo.");
            }
        } catch (NullPointerException | JSONException e) {
            throw zzaen.zza(e, zza, str);
        }
    }

    public String zzc() {
        return null;
    }
}
