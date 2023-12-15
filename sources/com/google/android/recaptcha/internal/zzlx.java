package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzlx extends zzgo implements zzhz {
    /* access modifiers changed from: private */
    public static final zzlx zzb;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";

    static {
        zzlx zzlx = new zzlx();
        zzb = zzlx;
        zzgo.zzC(zzlx.class, zzlx);
    }

    private zzlx() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzlx();
        } else {
            if (i2 == 4) {
                return new zzlw((zzlv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
