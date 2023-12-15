package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzqx extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzqx zzb;
    private zzrg zzd;
    private zzqr zze;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzqx zzqx = new zzqx();
        zzb = zzqx;
        zzagk.zzH(zzqx.class, zzqx);
    }

    private zzqx() {
    }

    public static zzqw zzb() {
        return (zzqw) zzb.zzt();
    }

    public static zzqx zzd() {
        return zzb;
    }

    static /* synthetic */ void zzf(zzqx zzqx, zzrg zzrg) {
        zzrg.getClass();
        zzqx.zzd = zzrg;
    }

    static /* synthetic */ void zzg(zzqx zzqx, zzqr zzqr) {
        zzqr.getClass();
        zzqx.zze = zzqr;
    }

    public final zzqr zza() {
        zzqr zzqr = this.zze;
        return zzqr == null ? zzqr.zzc() : zzqr;
    }

    public final zzrg zze() {
        zzrg zzrg = this.zzd;
        return zzrg == null ? zzrg.zzc() : zzrg;
    }

    public final int zzh() {
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

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzqx();
        } else {
            if (i2 == 4) {
                return new zzqw((zzqv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
