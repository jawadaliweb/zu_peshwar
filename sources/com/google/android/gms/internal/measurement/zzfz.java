package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
public final class zzfz extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzfz zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private zzfn zzg;

    static {
        zzfz zzfz = new zzfz();
        zza = zzfz;
        zzlb.zzbO(zzfz.class, zzfz);
    }

    private zzfz() {
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbL(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzfz();
        } else {
            if (i2 == 4) {
                return new zzfy((zzfk) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
