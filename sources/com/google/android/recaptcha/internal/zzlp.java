package com.google.android.recaptcha.internal;

import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzlp extends zzgo implements zzhz {
    /* access modifiers changed from: private */
    public static final zzlp zzb;
    private zzgv zzd = zzgo.zzw();

    static {
        zzlp zzlp = new zzlp();
        zzb = zzlp;
        zzgo.zzC(zzlp.class, zzlp);
    }

    private zzlp() {
    }

    public static zzlp zzg() {
        return zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"zzd"});
        } else if (i2 == 3) {
            return new zzlp();
        } else {
            if (i2 == 4) {
                return new zzlo((zzln) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final List zzi() {
        return this.zzd;
    }
}
