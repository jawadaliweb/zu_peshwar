package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzqu extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzqu zzb;
    private zzqx zzd;

    static {
        zzqu zzqu = new zzqu();
        zzb = zzqu;
        zzagk.zzH(zzqu.class, zzqu);
    }

    private zzqu() {
    }

    public static zzqt zza() {
        return (zzqt) zzb.zzt();
    }

    public static zzqu zzc(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzqu) zzagk.zzx(zzb, zzaff, zzafx);
    }

    static /* synthetic */ void zze(zzqu zzqu, zzqx zzqx) {
        zzqx.getClass();
        zzqu.zzd = zzqx;
    }

    public final zzqx zzd() {
        zzqx zzqx = this.zzd;
        return zzqx == null ? zzqx.zzd() : zzqx;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzd"});
        } else if (i2 == 3) {
            return new zzqu();
        } else {
            if (i2 == 4) {
                return new zzqt((zzqs) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
