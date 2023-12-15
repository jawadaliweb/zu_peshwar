package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzlm extends zzgo implements zzhz {
    /* access modifiers changed from: private */
    public static final zzlm zzb;
    private int zzd;
    private boolean zze;
    private zzfw zzf;
    private zzjd zzg;
    private int zzh;
    private zzkm zzi;
    private zzgv zzj = zzw();

    static {
        zzlm zzlm = new zzlm();
        zzb = zzlm;
        zzgo.zzC(zzlm.class, zzlm);
    }

    private zzlm() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzb, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u0004\u0002\u0007\u0003\t\u0004\t\u0005\f\u0006\t\u0007\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzld.class});
        } else if (i2 == 3) {
            return new zzlm();
        } else {
            if (i2 == 4) {
                return new zzll((zzlk) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
