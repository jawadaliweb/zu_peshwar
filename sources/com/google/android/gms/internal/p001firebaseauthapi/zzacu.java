package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import com.google.firebase.auth.zze;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzacu implements zzaar {
    private static final String zza = "zzacu";
    private zzacw zzb;

    public final /* bridge */ /* synthetic */ zzaar zza(String str) throws zzyi {
        zzacw zzacw;
        int i;
        zzacv zzacv;
        String str2 = str;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (!jSONObject.has("users")) {
                this.zzb = new zzacw();
            } else {
                JSONArray optJSONArray = jSONObject.optJSONArray("users");
                if (optJSONArray != null) {
                    if (optJSONArray.length() != 0) {
                        ArrayList arrayList = new ArrayList(optJSONArray.length());
                        boolean z = false;
                        int i2 = 0;
                        while (i2 < optJSONArray.length()) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                            if (jSONObject2 == null) {
                                zzacv = new zzacv();
                                i = i2;
                            } else {
                                String emptyToNull = Strings.emptyToNull(jSONObject2.optString("localId", (String) null));
                                String emptyToNull2 = Strings.emptyToNull(jSONObject2.optString("email", (String) null));
                                boolean optBoolean = jSONObject2.optBoolean("emailVerified", z);
                                String emptyToNull3 = Strings.emptyToNull(jSONObject2.optString("displayName", (String) null));
                                String emptyToNull4 = Strings.emptyToNull(jSONObject2.optString("photoUrl", (String) null));
                                zzadk zza2 = zzadk.zza(jSONObject2.optJSONArray("providerUserInfo"));
                                String emptyToNull5 = Strings.emptyToNull(jSONObject2.optString("rawPassword", (String) null));
                                String emptyToNull6 = Strings.emptyToNull(jSONObject2.optString("phoneNumber", (String) null));
                                i = i2;
                                long optLong = jSONObject2.optLong("createdAt", 0);
                                zzacv = new zzacv(emptyToNull, emptyToNull2, optBoolean, emptyToNull3, emptyToNull4, zza2, emptyToNull5, emptyToNull6, optLong, jSONObject2.optLong("lastLoginAt", 0), false, (zze) null, zzadi.zzg(jSONObject2.optJSONArray("mfaInfo")));
                            }
                            arrayList.add(zzacv);
                            i2 = i + 1;
                            z = false;
                        }
                        zzacw = new zzacw(arrayList);
                        this.zzb = zzacw;
                    }
                }
                zzacw = new zzacw(new ArrayList());
                this.zzb = zzacw;
            }
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzaen.zza(e, zza, str2);
        }
    }

    public final List zzb() {
        return this.zzb.zza();
    }
}
