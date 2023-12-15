package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzoq extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzoq zzb;
    /* access modifiers changed from: private */
    public int zzd;

    static {
        zzoq zzoq = new zzoq();
        zzb = zzoq;
        zzagk.zzH(zzoq.class, zzoq);
    }

    private zzoq() {
    }

    public static zzop zzb() {
        return (zzop) zzb.zzt();
    }

    public static zzoq zzd() {
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
            return new zzoq();
        } else {
            if (i2 == 4) {
                return new zzop((zzoo) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
