package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzlj extends zzgo implements zzhz {
    /* access modifiers changed from: private */
    public static final zzlj zzb;
    private String zzd = "";
    private zzkp zze;
    private zzkj zzf;
    private zzks zzg;
    private String zzh = "";
    private String zzi = "";

    static {
        zzlj zzlj = new zzlj();
        zzb = zzlj;
        zzgo.zzC(zzlj.class, zzlj);
    }

    private zzlj() {
    }

    static /* synthetic */ void zzG(zzlj zzlj, zzkj zzkj) {
        zzkj.getClass();
        zzlj.zzf = zzkj;
    }

    public static zzli zzf() {
        return (zzli) zzb.zzp();
    }

    static /* synthetic */ void zzi(zzlj zzlj, String str) {
        str.getClass();
        zzlj.zzd = str;
    }

    static /* synthetic */ void zzj(zzlj zzlj, String str) {
        str.getClass();
        zzlj.zzh = str;
    }

    static /* synthetic */ void zzk(zzlj zzlj, String str) {
        str.getClass();
        zzlj.zzi = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzb, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\t\u0003\t\u0004\t\u0005Ȉ\u0006Ȉ", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzlj();
        } else {
            if (i2 == 4) {
                return new zzli((zzlh) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
