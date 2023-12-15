package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
public final class zzfh extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzfh zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzfh zzfh = new zzfh();
        zza = zzfh;
        zzlb.zzbO(zzfh.class, zzfh);
    }

    private zzfh() {
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzfh();
        } else {
            if (i2 == 4) {
                return new zzfg((zzez) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
