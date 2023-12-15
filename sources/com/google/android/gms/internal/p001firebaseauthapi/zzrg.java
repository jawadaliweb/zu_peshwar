package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzrg extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzrg zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public zzaff zzf = zzaff.zzb;

    static {
        zzrg zzrg = new zzrg();
        zzb = zzrg;
        zzagk.zzH(zzrg.class, zzrg);
    }

    private zzrg() {
    }

    public static zzrf zza() {
        return (zzrf) zzb.zzt();
    }

    public static zzrg zzc() {
        return zzb;
    }

    public final zzaff zzd() {
        return this.zzf;
    }

    public final int zzf() {
        int i = this.zzd;
        int i2 = 5;
        if (i == 0) {
            i2 = 2;
        } else if (i == 2) {
            i2 = 4;
        } else if (i != 3) {
            i2 = i != 4 ? i != 5 ? 0 : 7 : 6;
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    public final int zzg() {
        int zzb2 = zzrn.zzb(this.zze);
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
            return zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzrg();
        } else {
            if (i2 == 4) {
                return new zzrf((zzre) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
