package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzfo extends zzgk implements zzhz {
    /* access modifiers changed from: private */
    public static final zzfo zzd;
    private int zze;
    private boolean zzf;
    private zzgv zzg = zzii.zze();
    private byte zzh = 2;

    static {
        zzfo zzfo = new zzfo();
        zzd = zzfo;
        zzgo.zzC(zzfo.class, zzfo);
    }

    private zzfo() {
    }

    public static zzfo zzg() {
        return zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        byte b = 1;
        if (i2 == 2) {
            return new zzij(zzd, "\u0001\u0002\u0000\u0001\u0001ϧ\u0002\u0000\u0001\u0001\u0001ဇ\u0000ϧЛ", new Object[]{"zze", "zzf", "zzg", zzfs.class});
        } else if (i2 == 3) {
            return new zzfo();
        } else {
            if (i2 == 4) {
                return new zzfn((zzfm) null);
            }
            if (i2 == 5) {
                return zzd;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzh = b;
            return null;
        }
    }
}
