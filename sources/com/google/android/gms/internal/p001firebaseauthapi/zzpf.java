package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzpf extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzpf zzb;
    /* access modifiers changed from: private */
    public int zzd;

    static {
        zzpf zzpf = new zzpf();
        zzb = zzpf;
        zzagk.zzH(zzpf.class, zzpf);
    }

    private zzpf() {
    }

    public static zzpe zzb() {
        return (zzpe) zzb.zzt();
    }

    public static zzpf zzd() {
        return zzb;
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
            return zzE(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzd"});
        } else if (i2 == 3) {
            return new zzpf();
        } else {
            if (i2 == 4) {
                return new zzpe((zzpd) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
