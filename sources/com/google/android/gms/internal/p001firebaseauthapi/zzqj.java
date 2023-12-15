package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzqj extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzqj zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public zzaff zze = zzaff.zzb;

    static {
        zzqj zzqj = new zzqj();
        zzb = zzqj;
        zzagk.zzH(zzqj.class, zzqj);
    }

    private zzqj() {
    }

    public static zzqi zzb() {
        return (zzqi) zzb.zzt();
    }

    public static zzqj zzd(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzqj) zzagk.zzx(zzb, zzaff, zzafx);
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
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzd", "zze"});
        } else if (i2 == 3) {
            return new zzqj();
        } else {
            if (i2 == 4) {
                return new zzqi((zzqh) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
