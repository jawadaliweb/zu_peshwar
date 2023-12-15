package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzgh implements zzhw {
    private static final zzgh zza = new zzgh();

    private zzgh() {
    }

    public static zzgh zza() {
        return zza;
    }

    public final zzhv zzb(Class cls) {
        if (zzgo.class.isAssignableFrom(cls)) {
            try {
                return (zzhv) zzgo.zzr(cls.asSubclass(zzgo.class)).zzh(3, (Object) null, (Object) null);
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
    }

    public final boolean zzc(Class cls) {
        return zzgo.class.isAssignableFrom(cls);
    }
}
