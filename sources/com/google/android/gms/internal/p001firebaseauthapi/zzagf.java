package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzagf implements zzahn {
    private static final zzagf zza = new zzagf();

    private zzagf() {
    }

    public static zzagf zza() {
        return zza;
    }

    public final zzahm zzb(Class cls) {
        if (zzagk.class.isAssignableFrom(cls)) {
            try {
                return (zzahm) zzagk.zzv(cls.asSubclass(zzagk.class)).zzj(3, (Object) null, (Object) null);
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
    }

    public final boolean zzc(Class cls) {
        return zzagk.class.isAssignableFrom(cls);
    }
}
