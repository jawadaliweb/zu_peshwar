package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaga  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaga {
    private static final zzafy zza = new zzafz();
    private static final zzafy zzb;

    static {
        zzafy zzafy;
        try {
            zzafy = (zzafy) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzafy = null;
        }
        zzb = zzafy;
    }

    static zzafy zza() {
        zzafy zzafy = zzb;
        if (zzafy != null) {
            return zzafy;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzafy zzb() {
        return zza;
    }
}
