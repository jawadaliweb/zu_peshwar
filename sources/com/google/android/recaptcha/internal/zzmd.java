package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzmd extends zzgo implements zzhz {
    /* access modifiers changed from: private */
    public static final zzmd zzb;
    private int zzd;

    static {
        zzmd zzmd = new zzmd();
        zzb = zzmd;
        zzgo.zzC(zzmd.class, zzmd);
    }

    private zzmd() {
    }

    public static zzmd zzg(byte[] bArr) throws zzgy {
        return (zzmd) zzgo.zzu(zzb, bArr);
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"zzd"});
        } else if (i2 == 3) {
            return new zzmd();
        } else {
            if (i2 == 4) {
                return new zzmc((zzlv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzmf zzi() {
        zzmf zzb2 = zzmf.zzb(this.zzd);
        return zzb2 == null ? zzmf.UNRECOGNIZED : zzb2;
    }
}
