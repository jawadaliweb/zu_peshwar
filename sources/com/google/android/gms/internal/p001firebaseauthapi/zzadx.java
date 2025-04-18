package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzadx implements zzaaq {
    private final String zza;
    private final String zzb = Preconditions.checkNotEmpty("phone");
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private zzacf zzg;

    private zzadx(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
    }

    public static zzadx zzb(String str, String str2, String str3, String str4, String str5, String str6) {
        Preconditions.checkNotEmpty(str2);
        return new zzadx(str, "phone", str2, str3, str4, str5, (String) null);
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", this.zza);
        jSONObject.put("mfaProvider", 1);
        if (this.zzc != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("phoneNumber", this.zzc);
            if (!TextUtils.isEmpty(this.zze)) {
                jSONObject2.put("recaptchaToken", this.zze);
            }
            if (!TextUtils.isEmpty(this.zzf)) {
                jSONObject2.put("playIntegrityToken", this.zzf);
            }
            zzacf zzacf = this.zzg;
            if (zzacf != null) {
                jSONObject2.put("autoRetrievalInfo", zzacf.zza());
            }
            jSONObject.put("phoneEnrollmentInfo", jSONObject2);
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            jSONObject.put("tenantId", (Object) null);
        }
        return jSONObject.toString();
    }

    public final String zzc() {
        return this.zzd;
    }

    public final void zzd(zzacf zzacf) {
        this.zzg = zzacf;
    }
}
