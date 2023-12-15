package com.google.android.recaptcha.internal;

import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzmh extends zzgo implements zzhz {
    /* access modifiers changed from: private */
    public static final zzmh zzb;
    private zzgv zzd = zzw();

    static {
        zzmh zzmh = new zzmh();
        zzb = zzmh;
        zzgo.zzC(zzmh.class, zzmh);
    }

    private zzmh() {
    }

    public static zzmh zzg(byte[] bArr) throws zzgy {
        return (zzmh) zzgo.zzu(zzb, bArr);
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzmv.class});
        } else if (i2 == 3) {
            return new zzmh();
        } else {
            if (i2 == 4) {
                return new zzmg((zzlv) null);
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
