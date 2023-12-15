package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaej  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzaej implements zzaaq {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;

    private zzaej() {
    }

    public static zzaej zzb(String str, String str2, boolean z) {
        zzaej zzaej = new zzaej();
        zzaej.zzb = Preconditions.checkNotEmpty(str);
        zzaej.zzc = Preconditions.checkNotEmpty(str2);
        zzaej.zzf = z;
        return zzaej;
    }

    public static zzaej zzc(String str, String str2, boolean z) {
        zzaej zzaej = new zzaej();
        zzaej.zza = Preconditions.checkNotEmpty(str);
        zzaej.zzd = Preconditions.checkNotEmpty(str2);
        zzaej.zzf = z;
        return zzaej;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.zzd)) {
            jSONObject.put("phoneNumber", this.zza);
            jSONObject.put("temporaryProof", this.zzd);
        } else {
            jSONObject.put("sessionInfo", this.zzb);
            jSONObject.put("code", this.zzc);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        if (!this.zzf) {
            jSONObject.put("operation", 2);
        }
        return jSONObject.toString();
    }

    public final void zzd(String str) {
        this.zze = str;
    }
}
