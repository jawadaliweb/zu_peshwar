package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzrt extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzrt zzb;
    private zzrw zzd;
    /* access modifiers changed from: private */
    public int zze;
    private int zzf;

    static {
        zzrt zzrt = new zzrt();
        zzb = zzrt;
        zzagk.zzH(zzrt.class, zzrt);
    }

    private zzrt() {
    }

    public static zzrs zzb() {
        return (zzrs) zzb.zzt();
    }

    public static zzrt zzd() {
        return zzb;
    }

    public static zzrt zze(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzrt) zzagk.zzx(zzb, zzaff, zzafx);
    }

    static /* synthetic */ void zzg(zzrt zzrt, zzrw zzrw) {
        zzrw.getClass();
        zzrt.zzd = zzrw;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzrw zzf() {
        zzrw zzrw = this.zzd;
        return zzrw == null ? zzrw.zzd() : zzrw;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzrt();
        } else {
            if (i2 == 4) {
                return new zzrs((zzrr) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
