package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzmm extends zzgo implements zzhz {
    /* access modifiers changed from: private */
    public static final zzmm zzb;
    private int zzd = 0;
    private Object zze;
    private int zzf;

    static {
        zzmm zzmm = new zzmm();
        zzb = zzmm;
        zzgo.zzC(zzmm.class, zzmm);
    }

    private zzmm() {
    }

    static /* synthetic */ void zzG(zzmm zzmm, String str) {
        str.getClass();
        zzmm.zzd = 11;
        zzmm.zze = str;
    }

    static /* synthetic */ void zzH(zzmm zzmm, boolean z) {
        zzmm.zzd = 1;
        zzmm.zze = Boolean.valueOf(z);
    }

    static /* synthetic */ void zzI(zzmm zzmm, zzez zzez) {
        zzmm.zzd = 2;
        zzmm.zze = zzez;
    }

    static /* synthetic */ void zzJ(zzmm zzmm, String str) {
        str.getClass();
        zzmm.zzd = 3;
        zzmm.zze = str;
    }

    static /* synthetic */ void zzK(zzmm zzmm, int i) {
        zzmm.zzd = 4;
        zzmm.zze = Integer.valueOf(i);
    }

    static /* synthetic */ void zzL(zzmm zzmm, int i) {
        zzmm.zzd = 5;
        zzmm.zze = Integer.valueOf(i);
    }

    public static zzml zzf() {
        return (zzml) zzb.zzp();
    }

    static /* synthetic */ void zzi(zzmm zzmm, long j) {
        zzmm.zzd = 7;
        zzmm.zze = Long.valueOf(j);
    }

    static /* synthetic */ void zzj(zzmm zzmm, float f) {
        zzmm.zzd = 9;
        zzmm.zze = Float.valueOf(f);
    }

    static /* synthetic */ void zzk(zzmm zzmm, double d) {
        zzmm.zzd = 10;
        zzmm.zze = Double.valueOf(d);
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzb, "\u0000\f\u0001\u0000\u0001\f\f\u0000\u0000\u0000\u0001:\u0000\u0002=\u0000\u0003Ȼ\u0000\u0004B\u0000\u0005B\u0000\u0006>\u0000\u0007C\u0000\b6\u0000\t4\u0000\n3\u0000\u000bȻ\u0000\f\u000b", new Object[]{"zze", "zzd", "zzf"});
        } else if (i2 == 3) {
            return new zzmm();
        } else {
            if (i2 == 4) {
                return new zzml((zzlv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
