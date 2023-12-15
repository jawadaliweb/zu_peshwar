package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
public final class zzfr extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzfr zza;
    private int zzd;
    private int zze;
    private long zzf;

    static {
        zzfr zzfr = new zzfr();
        zza = zzfr;
        zzlb.zzbO(zzfr.class, zzfr);
    }

    private zzfr() {
    }

    public static zzfq zzc() {
        return (zzfq) zza.zzbA();
    }

    static /* synthetic */ void zze(zzfr zzfr, int i) {
        zzfr.zzd |= 1;
        zzfr.zze = i;
    }

    static /* synthetic */ void zzf(zzfr zzfr, long j) {
        zzfr.zzd |= 2;
        zzfr.zzf = j;
    }

    public final int zza() {
        return this.zze;
    }

    public final long zzb() {
        return this.zzf;
    }

    public final boolean zzg() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzh() {
        return (this.zzd & 1) != 0;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzfr();
        } else {
            if (i2 == 4) {
                return new zzfq((zzfk) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
