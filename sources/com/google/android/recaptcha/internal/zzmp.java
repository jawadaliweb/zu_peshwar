package com.google.android.recaptcha.internal;

import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzmp extends zzgo implements zzhz {
    /* access modifiers changed from: private */
    public static final zzmp zzb;
    private String zzd = "";
    private zzgt zze = zzv();

    static {
        zzmp zzmp = new zzmp();
        zzb = zzmp;
        zzgo.zzC(zzmp.class, zzmp);
    }

    private zzmp() {
    }

    public static zzmp zzg(byte[] bArr) throws zzgy {
        return (zzmp) zzgo.zzu(zzb, bArr);
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002'", new Object[]{"zzd", "zze"});
        } else if (i2 == 3) {
            return new zzmp();
        } else {
            if (i2 == 4) {
                return new zzmo((zzlv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final String zzi() {
        return this.zzd;
    }

    public final List zzj() {
        return this.zze;
    }
}
