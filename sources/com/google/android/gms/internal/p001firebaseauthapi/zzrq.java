package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzrq extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzrq zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzrw zze;
    /* access modifiers changed from: private */
    public zzaff zzf = zzaff.zzb;

    static {
        zzrq zzrq = new zzrq();
        zzb = zzrq;
        zzagk.zzH(zzrq.class, zzrq);
    }

    private zzrq() {
    }

    public static zzrp zzb() {
        return (zzrp) zzb.zzt();
    }

    public static zzrq zzd() {
        return zzb;
    }

    public static zzrq zze(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzrq) zzagk.zzx(zzb, zzaff, zzafx);
    }

    static /* synthetic */ void zzi(zzrq zzrq, zzrw zzrw) {
        zzrw.getClass();
        zzrq.zze = zzrw;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzrw zzf() {
        zzrw zzrw = this.zze;
        return zzrw == null ? zzrw.zzd() : zzrw;
    }

    public final zzaff zzg() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzrq();
        } else {
            if (i2 == 4) {
                return new zzrp((zzro) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
