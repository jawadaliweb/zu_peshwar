package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzpr extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzpr zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public zzaff zze = zzaff.zzb;

    static {
        zzpr zzpr = new zzpr();
        zzb = zzpr;
        zzagk.zzH(zzpr.class, zzpr);
    }

    private zzpr() {
    }

    public static zzpq zzb() {
        return (zzpq) zzb.zzt();
    }

    public static zzpr zzd(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzpr) zzagk.zzx(zzb, zzaff, zzafx);
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzaff zze() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzd", "zze"});
        } else if (i2 == 3) {
            return new zzpr();
        } else {
            if (i2 == 4) {
                return new zzpq((zzpp) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
