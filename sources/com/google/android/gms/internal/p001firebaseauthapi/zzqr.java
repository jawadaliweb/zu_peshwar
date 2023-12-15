package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzqr extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzqr zzb;
    private zzsu zzd;

    static {
        zzqr zzqr = new zzqr();
        zzb = zzqr;
        zzagk.zzH(zzqr.class, zzqr);
    }

    private zzqr() {
    }

    public static zzqq zza() {
        return (zzqq) zzb.zzt();
    }

    public static zzqr zzc() {
        return zzb;
    }

    static /* synthetic */ void zze(zzqr zzqr, zzsu zzsu) {
        zzsu.getClass();
        zzqr.zzd = zzsu;
    }

    public final zzsu zzd() {
        zzsu zzsu = this.zzd;
        return zzsu == null ? zzsu.zzc() : zzsu;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zzd"});
        } else if (i2 == 3) {
            return new zzqr();
        } else {
            if (i2 == 4) {
                return new zzqq((zzqp) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
