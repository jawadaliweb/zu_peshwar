package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
public final class zzgk extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzgk zza;
    private int zzd;
    private int zze;
    private zzlh zzf = zzbF();

    static {
        zzgk zzgk = new zzgk();
        zza = zzgk;
        zzlb.zzbO(zzgk.class, zzgk);
    }

    private zzgk() {
    }

    public static zzgj zzd() {
        return (zzgj) zza.zzbA();
    }

    static /* synthetic */ void zzg(zzgk zzgk, int i) {
        zzgk.zzd |= 1;
        zzgk.zze = i;
    }

    static /* synthetic */ void zzh(zzgk zzgk, Iterable iterable) {
        zzlh zzlh = zzgk.zzf;
        if (!zzlh.zzc()) {
            zzgk.zzf = zzlb.zzbG(zzlh);
        }
        zzjk.zzbw(iterable, zzgk.zzf);
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final int zzb() {
        return this.zze;
    }

    public final long zzc(int i) {
        return this.zzf.zza(i);
    }

    public final List zzf() {
        return this.zzf;
    }

    public final boolean zzi() {
        return (this.zzd & 1) != 0;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzgk();
        } else {
            if (i2 == 4) {
                return new zzgj((zzfk) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
