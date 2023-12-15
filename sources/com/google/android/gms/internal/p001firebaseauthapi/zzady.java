package com.google.android.gms.internal.p001firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzady  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzady extends zzadu {
    private static final String zza = "zzady";
    private String zzb;

    public final /* bridge */ /* synthetic */ zzaar zza(String str) throws zzyi {
        zzd(str);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzadu zzb(String str) throws zzyi {
        zzd(str);
        return this;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final zzady zzd(String str) throws zzyi {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("phoneSessionInfo");
            if (optJSONObject != null) {
                this.zzb = zzac.zza(optJSONObject.optString("sessionInfo"));
            }
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzaen.zza(e, zza, str);
        }
    }
}
