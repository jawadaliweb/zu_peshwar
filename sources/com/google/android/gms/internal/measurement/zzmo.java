package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.2 */
final class zzmo {
    private static final zzmn zza;
    private static final zzmn zzb = new zzmn();

    static {
        zzmn zzmn;
        try {
            zzmn = (zzmn) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzmn = null;
        }
        zza = zzmn;
    }

    static zzmn zza() {
        return zza;
    }

    static zzmn zzb() {
        return zzb;
    }
}
