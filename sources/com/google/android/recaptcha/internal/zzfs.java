package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzfs extends zzgo implements zzhz {
    /* access modifiers changed from: private */
    public static final zzfs zzb;
    private int zzd;
    private zzgv zze = zzii.zze();
    private String zzf = "";
    private long zzg;
    private long zzh;
    private double zzi;
    private zzez zzj = zzez.zzb;
    private String zzk = "";
    private byte zzl = 2;

    static {
        zzfs zzfs = new zzfs();
        zzb = zzfs;
        zzgo.zzC(zzfs.class, zzfs);
    }

    private zzfs() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        byte b = 1;
        if (i2 == 2) {
            return new zzij(zzb, "\u0001\u0007\u0000\u0001\u0002\b\u0007\u0000\u0001\u0001\u0002Л\u0003ဈ\u0000\u0004ဃ\u0001\u0005ဂ\u0002\u0006က\u0003\u0007ည\u0004\bဈ\u0005", new Object[]{"zzd", "zze", zzfr.class, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i2 == 3) {
            return new zzfs();
        } else {
            if (i2 == 4) {
                return new zzfp((zzfm) null);
            }
            if (i2 == 5) {
                return zzb;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzl = b;
            return null;
        }
    }
}
