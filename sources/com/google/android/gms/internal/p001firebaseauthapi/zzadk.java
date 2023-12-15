package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzadk {
    private final List zza;

    public zzadk() {
        this.zza = new ArrayList();
    }

    public static zzadk zza(JSONArray jSONArray) throws JSONException {
        zzadj zzadj;
        if (jSONArray == null || jSONArray.length() == 0) {
            return new zzadk(new ArrayList());
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject == null) {
                zzadj = new zzadj();
            } else {
                zzadj = new zzadj(Strings.emptyToNull(jSONObject.optString("federatedId", (String) null)), Strings.emptyToNull(jSONObject.optString("displayName", (String) null)), Strings.emptyToNull(jSONObject.optString("photoUrl", (String) null)), Strings.emptyToNull(jSONObject.optString("providerId", (String) null)), (String) null, Strings.emptyToNull(jSONObject.optString("phoneNumber", (String) null)), Strings.emptyToNull(jSONObject.optString("email", (String) null)));
            }
            arrayList.add(zzadj);
        }
        return new zzadk(arrayList);
    }

    public static zzadk zzb(zzadk zzadk) {
        List list = zzadk.zza;
        zzadk zzadk2 = new zzadk();
        if (list != null) {
            zzadk2.zza.addAll(list);
        }
        return zzadk2;
    }

    public final List zzc() {
        return this.zza;
    }

    public zzadk(List list) {
        if (!list.isEmpty()) {
            this.zza = Collections.unmodifiableList(list);
        } else {
            this.zza = Collections.emptyList();
        }
    }
}
