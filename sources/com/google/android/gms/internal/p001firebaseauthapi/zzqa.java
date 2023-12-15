package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqa  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzqa extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzqa zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private int zze;

    static {
        zzqa zzqa = new zzqa();
        zzb = zzqa;
        zzagk.zzH(zzqa.class, zzqa);
    }

    private zzqa() {
    }

    public static zzpz zzb() {
        return (zzpz) zzb.zzt();
    }

    public static zzqa zzd(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzqa) zzagk.zzx(zzb, zzaff, zzafx);
    }

    public final int zza() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzd"});
        } else if (i2 == 3) {
            return new zzqa();
        } else {
            if (i2 == 4) {
                return new zzpz((zzpy) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
