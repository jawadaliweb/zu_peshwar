package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzacm implements zzaar {
    private static final String zza = "zzacm";
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;
    private long zzg;
    private List zzh;
    private String zzi;

    public final /* bridge */ /* synthetic */ zzaar zza(String str) throws zzyi {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optString("localId", (String) null);
            this.zzc = jSONObject.optString("email", (String) null);
            this.zzd = jSONObject.optString("idToken", (String) null);
            this.zze = jSONObject.optString("refreshToken", (String) null);
            this.zzf = jSONObject.optBoolean("isNewUser", false);
            this.zzg = jSONObject.optLong("expiresIn", 0);
            this.zzh = zzadi.zzg(jSONObject.optJSONArray("mfaInfo"));
            this.zzi = jSONObject.optString("mfaPendingCredential", (String) null);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzaen.zza(e, zza, str);
        }
    }

    public final long zzb() {
        return this.zzg;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zzi;
    }

    public final String zze() {
        return this.zze;
    }

    public final List zzf() {
        return this.zzh;
    }

    public final boolean zzg() {
        return !TextUtils.isEmpty(this.zzi);
    }

    public final boolean zzh() {
        return this.zzf;
    }
}
