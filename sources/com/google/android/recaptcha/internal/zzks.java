package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzks extends zzgo implements zzhz {
    /* access modifiers changed from: private */
    public static final zzks zzb;
    private String zzd = "";
    private String zze = "";

    static {
        zzks zzks = new zzks();
        zzb = zzks;
        zzgo.zzC(zzks.class, zzks);
    }

    private zzks() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"zzd", "zze"});
        } else if (i2 == 3) {
            return new zzks();
        } else {
            if (i2 == 4) {
                return new zzkr((zzkq) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
