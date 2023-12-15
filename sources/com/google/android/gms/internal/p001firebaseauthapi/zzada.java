package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzada  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzada implements zzaar {
    private static final String zza = "zzada";
    private String zzb;

    public zzada() {
    }

    public zzada(String str) {
        this.zzb = str;
    }

    public final /* bridge */ /* synthetic */ zzaar zza(String str) throws zzyi {
        try {
            this.zzb = Strings.emptyToNull(new JSONObject(str).optString("producerProjectNumber"));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzaen.zza(e, zza, str);
        }
    }

    public final String zzb() {
        return this.zzb;
    }
}
