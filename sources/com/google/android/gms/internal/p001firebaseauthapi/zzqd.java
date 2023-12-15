package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzqd extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzqd zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public zzaff zze = zzaff.zzb;

    static {
        zzqd zzqd = new zzqd();
        zzb = zzqd;
        zzagk.zzH(zzqd.class, zzqd);
    }

    private zzqd() {
    }

    public static zzqc zzb() {
        return (zzqc) zzb.zzt();
    }

    public static zzqd zzd(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzqd) zzagk.zzx(zzb, zzaff, zzafx);
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
            return new zzqd();
        } else {
            if (i2 == 4) {
                return new zzqc((zzqb) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
