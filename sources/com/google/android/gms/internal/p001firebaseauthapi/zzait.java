package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzait  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzait extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzait zzb;
    /* access modifiers changed from: private */
    public long zzd;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzait zzait = new zzait();
        zzb = zzait;
        zzagk.zzH(zzait.class, zzait);
    }

    private zzait() {
    }

    public static zzais zzc() {
        return (zzais) zzb.zzt();
    }

    public final int zza() {
        return this.zze;
    }

    public final long zzb() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzahz(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzd", "zze"});
        } else if (i2 == 3) {
            return new zzait();
        } else {
            if (i2 == 4) {
                return new zzais((zzair) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
