package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzpu extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzpu zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private int zze;

    static {
        zzpu zzpu = new zzpu();
        zzb = zzpu;
        zzagk.zzH(zzpu.class, zzpu);
    }

    private zzpu() {
    }

    public static zzpt zzb() {
        return (zzpt) zzb.zzt();
    }

    public static zzpu zzd(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzpu) zzagk.zzx(zzb, zzaff, zzafx);
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
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzd", "zze"});
        } else if (i2 == 3) {
            return new zzpu();
        } else {
            if (i2 == 4) {
                return new zzpt((zzps) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
