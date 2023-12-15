package com.google.android.gms.internal.p001firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaal  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzaal {
    private static Boolean zza;

    public static boolean zza(Context context) {
        if (zza == null) {
            int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            boolean z = true;
            if (!(isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2)) {
                z = false;
            }
            zza = Boolean.valueOf(z);
        }
        return zza.booleanValue();
    }
}
