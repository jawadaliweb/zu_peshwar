package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.messaging.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzach  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzach implements zzaar {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzach";
    private String zzb;

    public final /* bridge */ /* synthetic */ zzaar zza(String str) throws zzyi {
        zzb(str);
        return this;
    }

    public final zzach zzb(String str) throws zzyi {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).getString(Constants.IPC_BUNDLE_KEY_SEND_ERROR));
            jSONObject.getInt("code");
            this.zzb = jSONObject.getString("message");
            return this;
        } catch (NullPointerException | JSONException e) {
            String str2 = zza;
            String message = e.getMessage();
            Log.e(str2, "Failed to parse error for string [" + str + "] with exception: " + message);
            throw new zzyi("Failed to parse error for string [" + str + "]", e);
        }
    }

    public final String zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        return !TextUtils.isEmpty(this.zzb);
    }
}
