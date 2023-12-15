package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzkd extends zzgo implements zzhz {
    /* access modifiers changed from: private */
    public static final zzkd zzb;
    private zzgv zzd = zzw();
    private zzfw zze;

    static {
        zzkd zzkd = new zzkd();
        zzb = zzkd;
        zzgo.zzC(zzkd.class, zzkd);
    }

    private zzkd() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzb, "\u0000\u0002\u0000\u0000\f\r\u0002\u0000\u0001\u0000\f\u001b\r\t", new Object[]{"zzd", zzlm.class, "zze"});
        } else if (i2 == 3) {
            return new zzkd();
        } else {
            if (i2 == 4) {
                return new zzkc((zzkb) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
