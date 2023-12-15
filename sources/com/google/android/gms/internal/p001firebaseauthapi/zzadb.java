package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzadb implements zzaar {
    private static final String zza = "zzadb";
    private List zzb;

    public final /* bridge */ /* synthetic */ zzaar zza(String str) throws zzyi {
        zzb(str);
        return this;
    }

    public final zzadb zzb(String str) throws zzyi {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("authorizedDomains");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.zzb.add(optJSONArray.getString(i));
                }
            }
            return this;
        } catch (JSONException e) {
            throw zzaen.zza(e, zza, str);
        }
    }

    public final List zzc() {
        return this.zzb;
    }
}
