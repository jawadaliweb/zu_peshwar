package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzmb extends zzgo implements zzhz {
    /* access modifiers changed from: private */
    public static final zzmb zzb;
    private String zzd = "";
    private String zze = "";

    static {
        zzmb zzmb = new zzmb();
        zzb = zzmb;
        zzgo.zzC(zzmb.class, zzmb);
    }

    private zzmb() {
    }

    public static zzma zzf() {
        return (zzma) zzb.zzp();
    }

    static /* synthetic */ void zzi(zzmb zzmb, String str) {
        str.getClass();
        zzmb.zzd = str;
    }

    static /* synthetic */ void zzj(zzmb zzmb, String str) {
        str.getClass();
        zzmb.zze = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"zzd", "zze"});
        } else if (i2 == 3) {
            return new zzmb();
        } else {
            if (i2 == 4) {
                return new zzma((zzlv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
