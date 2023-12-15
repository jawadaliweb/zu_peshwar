package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
public final class zzfb extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzfb zza;
    private int zzd;
    private String zze = "";
    private zzli zzf = zzbH();
    private boolean zzg;

    static {
        zzfb zzfb = new zzfb();
        zza = zzfb;
        zzlb.zzbO(zzfb.class, zzfb);
    }

    private zzfb() {
    }

    public final String zzb() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbL(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zzd", "zze", "zzf", zzfh.class, "zzg"});
        } else if (i2 == 3) {
            return new zzfb();
        } else {
            if (i2 == 4) {
                return new zzfa((zzez) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
