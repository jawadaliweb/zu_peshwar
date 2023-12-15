package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzmn extends zzgo implements zzhz {
    /* access modifiers changed from: private */
    public static final zzmn zzb;
    private zzgv zzd = zzw();
    private int zze;

    static {
        zzmn zzmn = new zzmn();
        zzb = zzmn;
        zzgo.zzC(zzmn.class, zzmn);
    }

    private zzmn() {
    }

    public static zzmk zzf() {
        return (zzmk) zzb.zzp();
    }

    static /* synthetic */ void zzi(zzmn zzmn, zzmm zzmm) {
        zzmm.getClass();
        zzmn.zzk();
        zzmn.zzd.add(zzmm);
    }

    static /* synthetic */ void zzj(zzmn zzmn, Iterable iterable) {
        zzmn.zzk();
        zzei.zzc(iterable, zzmn.zzd);
    }

    private final void zzk() {
        zzgv zzgv = this.zzd;
        if (!zzgv.zzc()) {
            this.zzd = zzgo.zzx(zzgv);
        }
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u000b", new Object[]{"zzd", zzmm.class, "zze"});
        } else if (i2 == 3) {
            return new zzmn();
        } else {
            if (i2 == 4) {
                return new zzmk((zzlv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
