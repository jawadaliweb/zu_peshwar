package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzsb extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzsb zzb;
    private zzse zzd;

    static {
        zzsb zzsb = new zzsb();
        zzb = zzsb;
        zzagk.zzH(zzsb.class, zzsb);
    }

    private zzsb() {
    }

    public static zzsa zza() {
        return (zzsa) zzb.zzt();
    }

    public static zzsb zzc(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzsb) zzagk.zzx(zzb, zzaff, zzafx);
    }

    static /* synthetic */ void zze(zzsb zzsb, zzse zzse) {
        zzse.getClass();
        zzsb.zzd = zzse;
    }

    public final zzse zzd() {
        zzse zzse = this.zzd;
        return zzse == null ? zzse.zzc() : zzse;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzd"});
        } else if (i2 == 3) {
            return new zzsb();
        } else {
            if (i2 == 4) {
                return new zzsa((zzrz) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
