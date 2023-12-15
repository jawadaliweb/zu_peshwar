package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.ActionCodeUrl;
import com.google.firebase.auth.EmailAuthCredential;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzacl implements zzaaq {
    private static final String zza = "zzacl";
    private static final Logger zzb = new Logger(zzacl.class.getSimpleName(), new String[0]);
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;

    public zzacl(EmailAuthCredential emailAuthCredential, String str, String str2) {
        this.zzc = Preconditions.checkNotEmpty(emailAuthCredential.zzd());
        this.zzd = Preconditions.checkNotEmpty(emailAuthCredential.zzf());
        this.zze = str;
        this.zzf = str2;
    }

    public final String zza() throws JSONException {
        ActionCodeUrl parseLink = ActionCodeUrl.parseLink(this.zzd);
        String str = null;
        String code = parseLink != null ? parseLink.getCode() : null;
        if (parseLink != null) {
            str = parseLink.zza();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("email", this.zzc);
        if (code != null) {
            jSONObject.put("oobCode", code);
        }
        if (str != null) {
            jSONObject.put("tenantId", str);
        }
        String str2 = this.zze;
        if (str2 != null) {
            jSONObject.put("idToken", str2);
        }
        String str3 = this.zzf;
        if (str3 != null) {
            zzaen.zzd(jSONObject, "captchaResp", str3);
        } else {
            zzaen.zzc(jSONObject);
        }
        return jSONObject.toString();
    }
}
