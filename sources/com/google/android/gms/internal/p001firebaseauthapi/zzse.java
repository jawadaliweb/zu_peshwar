package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzse  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzse extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzse zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzse zzse = new zzse();
        zzb = zzse;
        zzagk.zzH(zzse.class, zzse);
    }

    private zzse() {
    }

    public static zzsd zza() {
        return (zzsd) zzb.zzt();
    }

    public static zzse zzc() {
        return zzb;
    }

    public final int zzd() {
        int i = this.zzf;
        int i2 = 3;
        if (i == 0) {
            i2 = 2;
        } else if (i != 1) {
            i2 = i != 2 ? i != 3 ? 0 : 5 : 4;
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    public final int zze() {
        int i = this.zze;
        int i2 = 3;
        if (i == 0) {
            i2 = 2;
        } else if (i != 1) {
            i2 = i != 2 ? i != 3 ? 0 : 5 : 4;
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    public final int zzf() {
        int i = this.zzd;
        int i2 = 4;
        if (i == 0) {
            i2 = 2;
        } else if (i == 1) {
            i2 = 3;
        } else if (i != 2) {
            i2 = i != 3 ? i != 4 ? 0 : 6 : 5;
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzse();
        } else {
            if (i2 == 4) {
                return new zzsd((zzsc) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
