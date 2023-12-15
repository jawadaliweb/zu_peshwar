package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzlr extends zzgo implements zzhz {
    /* access modifiers changed from: private */
    public static final zzlr zzb;
    private zzlp zzd;
    private zzlp zze;

    static {
        zzlr zzlr = new zzlr();
        zzb = zzlr;
        zzgo.zzC(zzlr.class, zzlr);
    }

    private zzlr() {
    }

    public static zzlr zzj(InputStream inputStream) throws IOException {
        return (zzlr) zzgo.zzt(zzb, inputStream);
    }

    public final zzlp zzf() {
        zzlp zzlp = this.zzd;
        return zzlp == null ? zzlp.zzg() : zzlp;
    }

    public final zzlp zzg() {
        zzlp zzlp = this.zze;
        return zzlp == null ? zzlp.zzg() : zzlp;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzd", "zze"});
        } else if (i2 == 3) {
            return new zzlr();
        } else {
            if (i2 == 4) {
                return new zzlq((zzln) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
