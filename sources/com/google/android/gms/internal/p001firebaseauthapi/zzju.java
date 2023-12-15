package com.google.android.gms.internal.p001firebaseauthapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzju  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzju implements zzca {
    private final SharedPreferences.Editor zza;
    private final String zzb;

    public zzju(Context context, String str, String str2) {
        if (str != null) {
            this.zzb = str;
            Context applicationContext = context.getApplicationContext();
            if (str2 == null) {
                this.zza = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
            } else {
                this.zza = applicationContext.getSharedPreferences(str2, 0).edit();
            }
        } else {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
    }

    public final void zzb(zzrl zzrl) throws IOException {
        if (!this.zza.putString(this.zzb, zzvl.zza(zzrl.zzq())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }

    public final void zzc(zztc zztc) throws IOException {
        if (!this.zza.putString(this.zzb, zzvl.zza(zztc.zzq())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }
}
