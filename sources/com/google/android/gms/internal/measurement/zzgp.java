package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
public final class zzgp extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzgp zza;
    private zzli zzd = zzbH();

    static {
        zzgp zzgp = new zzgp();
        zza = zzgp;
        zzlb.zzbO(zzgp.class, zzgp);
    }

    private zzgp() {
    }

    public static zzgp zzc() {
        return zza;
    }

    public final int zza() {
        return this.zzd.size();
    }

    public final List zzd() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbL(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzgr.class});
        } else if (i2 == 3) {
            return new zzgp();
        } else {
            if (i2 == 4) {
                return new zzgo((zzgn) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
