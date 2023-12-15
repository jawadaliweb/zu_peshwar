package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzkm extends zzgo implements zzhz {
    /* access modifiers changed from: private */
    public static final zzkm zzb;
    private String zzd = "";
    private String zze = "";
    /* access modifiers changed from: private */
    public int zzf;
    private String zzg = "";
    /* access modifiers changed from: private */
    public String zzh = "";
    private int zzi;

    static {
        zzkm zzkm = new zzkm();
        zzb = zzkm;
        zzgo.zzC(zzkm.class, zzkm);
    }

    private zzkm() {
    }

    static /* synthetic */ void zzG(zzkm zzkm, String str) {
        str.getClass();
        zzkm.zzd = str;
    }

    public static zzkl zzg() {
        return (zzkl) zzb.zzp();
    }

    public static zzkm zzj() {
        return zzb;
    }

    public final int zzf() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzb, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003Ȉ\u0004\u0004\u0005Ȉ\u0006Ȉ", new Object[]{"zzd", "zzf", "zzh", "zzi", "zze", "zzg"});
        } else if (i2 == 3) {
            return new zzkm();
        } else {
            if (i2 == 4) {
                return new zzkl((zzkk) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final String zzk() {
        return this.zzd;
    }
}
