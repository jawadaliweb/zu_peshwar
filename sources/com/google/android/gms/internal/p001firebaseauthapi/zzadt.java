package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzadt implements zzaar {
    private static final String zza = "zzadt";
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private long zzf;

    public final /* bridge */ /* synthetic */ zzaar zza(String str) throws zzyi {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("idToken", (String) null));
            this.zzc = Strings.emptyToNull(jSONObject.optString("displayName", (String) null));
            this.zzd = Strings.emptyToNull(jSONObject.optString("email", (String) null));
            this.zze = Strings.emptyToNull(jSONObject.optString("refreshToken", (String) null));
            this.zzf = jSONObject.optLong("expiresIn", 0);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzaen.zza(e, zza, str);
        }
    }

    public final long zzb() {
        return this.zzf;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zze;
    }
}
