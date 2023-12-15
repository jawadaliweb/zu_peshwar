package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzub  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzub extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzub zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public zzaff zze = zzaff.zzb;

    static {
        zzub zzub = new zzub();
        zzb = zzub;
        zzagk.zzH(zzub.class, zzub);
    }

    private zzub() {
    }

    public static zzua zzb() {
        return (zzua) zzb.zzt();
    }

    public static zzub zzd(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzub) zzagk.zzx(zzb, zzaff, zzafx);
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
            return new zzub();
        } else {
            if (i2 == 4) {
                return new zzua((zztz) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
