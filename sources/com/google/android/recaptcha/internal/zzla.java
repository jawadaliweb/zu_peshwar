package com.google.android.recaptcha.internal;

import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzla extends zzgo implements zzhz {
    /* access modifiers changed from: private */
    public static final zzla zzb;
    private zzgv zzd = zzw();

    static {
        zzla zzla = new zzla();
        zzb = zzla;
        zzgo.zzC(zzla.class, zzla);
    }

    private zzla() {
    }

    public static zzkz zzf() {
        return (zzkz) zzb.zzp();
    }

    public static zzla zzi(byte[] bArr) throws zzgy {
        return (zzla) zzgo.zzu(zzb, bArr);
    }

    static /* synthetic */ void zzk(zzla zzla, zzkx zzkx) {
        zzkx.getClass();
        zzgv zzgv = zzla.zzd;
        if (!zzgv.zzc()) {
            zzla.zzd = zzgo.zzx(zzgv);
        }
        zzla.zzd.add(zzkx);
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzkx.class});
        } else if (i2 == 3) {
            return new zzla();
        } else {
            if (i2 == 4) {
                return new zzkz((zzky) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final List zzj() {
        return this.zzd;
    }
}
