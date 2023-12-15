package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzacj implements zzaar {
    private static final String zza = "zzacj";
    private String zzb;
    private String zzc;
    private zzadz zzd = new zzadz((List) null);
    private List zze;

    public final /* bridge */ /* synthetic */ zzaar zza(String str) throws zzyi {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optString("authUri", (String) null);
            jSONObject.optBoolean("registered", false);
            this.zzc = jSONObject.optString("providerId", (String) null);
            jSONObject.optBoolean("forExistingProvider", false);
            if (jSONObject.has("allProviders")) {
                this.zzd = new zzadz(1, zzaen.zzb(jSONObject.optJSONArray("allProviders")));
            } else {
                this.zzd = new zzadz((List) null);
            }
            this.zze = zzaen.zzb(jSONObject.optJSONArray("signinMethods"));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzaen.zza(e, zza, str);
        }
    }

    public final List zzb() {
        return this.zze;
    }
}
