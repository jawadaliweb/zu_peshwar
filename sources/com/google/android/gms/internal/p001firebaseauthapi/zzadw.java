package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzadw implements zzaar {
    private static final String zza = "zzadw";
    private String zzb;

    public final /* bridge */ /* synthetic */ zzaar zza(String str) throws zzyi {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("phoneResponseInfo");
            if (optJSONObject != null) {
                this.zzb = Strings.emptyToNull(optJSONObject.optString("sessionInfo"));
            }
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzaen.zza(e, zza, str);
        }
    }

    public final String zzb() {
        return this.zzb;
    }
}
