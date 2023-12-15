package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzue  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzue extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzue zzb;
    private int zzd;

    static {
        zzue zzue = new zzue();
        zzb = zzue;
        zzagk.zzH(zzue.class, zzue);
    }

    private zzue() {
    }

    public static zzue zzb() {
        return zzb;
    }

    public static zzue zzc(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzue) zzagk.zzx(zzb, zzaff, zzafx);
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzd"});
        } else if (i2 == 3) {
            return new zzue();
        } else {
            if (i2 == 4) {
                return new zzud((zzuc) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
