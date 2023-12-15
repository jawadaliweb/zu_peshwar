package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzlg extends zzgo implements zzhz {
    /* access modifiers changed from: private */
    public static final zzlg zzb;
    private zzfw zzd;
    private zzjd zze;
    private zzfw zzf;
    private zzjd zzg;

    static {
        zzlg zzlg = new zzlg();
        zzb = zzlg;
        zzgo.zzC(zzlg.class, zzlg);
    }

    private zzlg() {
    }

    static /* synthetic */ void zzG(zzlg zzlg, zzfw zzfw) {
        zzfw.getClass();
        zzlg.zzf = zzfw;
    }

    public static zzlf zzf() {
        return (zzlf) zzb.zzp();
    }

    static /* synthetic */ void zzi(zzlg zzlg, zzfw zzfw) {
        zzfw.getClass();
        zzlg.zzd = zzfw;
    }

    static /* synthetic */ void zzj(zzlg zzlg, zzjd zzjd) {
        zzjd.getClass();
        zzlg.zzg = zzjd;
    }

    static /* synthetic */ void zzk(zzlg zzlg, zzjd zzjd) {
        zzjd.getClass();
        zzlg.zze = zzjd;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\t\u0003\t\u0004\t", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzlg();
        } else {
            if (i2 == 4) {
                return new zzlf((zzle) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
