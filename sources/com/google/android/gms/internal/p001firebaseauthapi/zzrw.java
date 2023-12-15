package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzrw extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzrw zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzrw zzrw = new zzrw();
        zzb = zzrw;
        zzagk.zzH(zzrw.class, zzrw);
    }

    private zzrw() {
    }

    public static zzrv zzb() {
        return (zzrv) zzb.zzt();
    }

    public static zzrw zzd() {
        return zzb;
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzf() {
        int zzb2 = zzrn.zzb(this.zzd);
        if (zzb2 == 0) {
            return 1;
        }
        return zzb2;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzd", "zze"});
        } else if (i2 == 3) {
            return new zzrw();
        } else {
            if (i2 == 4) {
                return new zzrv((zzru) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
