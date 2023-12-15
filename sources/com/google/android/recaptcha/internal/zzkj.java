package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzkj extends zzgo implements zzhz {
    private static final zzgu zzb = new zzkh();
    /* access modifiers changed from: private */
    public static final zzkj zzd;
    /* access modifiers changed from: private */
    public int zze;
    private String zzf = "";
    /* access modifiers changed from: private */
    public String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private zzgt zzk = zzv();

    static {
        zzkj zzkj = new zzkj();
        zzd = zzkj;
        zzgo.zzC(zzkj.class, zzkj);
    }

    private zzkj() {
    }

    static /* synthetic */ void zzG(zzkj zzkj, String str) {
        str.getClass();
        zzkj.zzf = str;
    }

    static /* synthetic */ void zzI(zzkj zzkj, String str) {
        str.getClass();
        zzkj.zzh = str;
    }

    public static zzki zzf() {
        return (zzki) zzd.zzp();
    }

    static /* synthetic */ void zzj(zzkj zzkj, String str) {
        str.getClass();
        zzkj.zzi = str;
    }

    static /* synthetic */ void zzk(zzkj zzkj, String str) {
        str.getClass();
        zzkj.zzj = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzd, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007,", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i2 == 3) {
            return new zzkj();
        } else {
            if (i2 == 4) {
                return new zzki((zzkh) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzd;
        }
    }
}
