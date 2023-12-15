package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
public final class zzfn extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzfn zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";

    static {
        zzfn zzfn = new zzfn();
        zza = zzfn;
        zzlb.zzbO(zzfn.class, zzfn);
    }

    private zzfn() {
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbL(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i2 == 3) {
            return new zzfn();
        } else {
            if (i2 == 4) {
                return new zzfm((zzfk) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
