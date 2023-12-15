package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzahl {
    private static final zzahk zza;
    private static final zzahk zzb = new zzahk();

    static {
        zzahk zzahk;
        try {
            zzahk = (zzahk) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzahk = null;
        }
        zza = zzahk;
    }

    static zzahk zza() {
        return zza;
    }

    static zzahk zzb() {
        return zzb;
    }
}
