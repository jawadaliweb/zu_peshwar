package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzot  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzot extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzot zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzoz zze;
    private zzrq zzf;

    static {
        zzot zzot = new zzot();
        zzb = zzot;
        zzagk.zzH(zzot.class, zzot);
    }

    private zzot() {
    }

    public static zzos zzb() {
        return (zzos) zzb.zzt();
    }

    public static zzot zzd(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzot) zzagk.zzx(zzb, zzaff, zzafx);
    }

    static /* synthetic */ void zzh(zzot zzot, zzoz zzoz) {
        zzoz.getClass();
        zzot.zze = zzoz;
    }

    static /* synthetic */ void zzi(zzot zzot, zzrq zzrq) {
        zzrq.getClass();
        zzot.zzf = zzrq;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzoz zze() {
        zzoz zzoz = this.zze;
        return zzoz == null ? zzoz.zzd() : zzoz;
    }

    public final zzrq zzf() {
        zzrq zzrq = this.zzf;
        return zzrq == null ? zzrq.zzd() : zzrq;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzot();
        } else {
            if (i2 == 4) {
                return new zzos((zzor) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
