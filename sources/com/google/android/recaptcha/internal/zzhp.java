package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzhp implements zzhw {
    private final zzhw[] zza;

    zzhp(zzhw... zzhwArr) {
        this.zza = zzhwArr;
    }

    public final zzhv zzb(Class cls) {
        zzhw[] zzhwArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzhw zzhw = zzhwArr[i];
            if (zzhw.zzc(cls)) {
                return zzhw.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    public final boolean zzc(Class cls) {
        zzhw[] zzhwArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzhwArr[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
