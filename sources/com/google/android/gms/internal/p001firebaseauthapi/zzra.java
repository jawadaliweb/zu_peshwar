package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzra  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzra extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzra zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzrd zze;
    /* access modifiers changed from: private */
    public zzaff zzf = zzaff.zzb;

    static {
        zzra zzra = new zzra();
        zzb = zzra;
        zzagk.zzH(zzra.class, zzra);
    }

    private zzra() {
    }

    public static zzqz zzb() {
        return (zzqz) zzb.zzt();
    }

    public static zzra zzd(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzra) zzagk.zzx(zzb, zzaff, zzafx);
    }

    static /* synthetic */ void zzh(zzra zzra, zzrd zzrd) {
        zzrd.getClass();
        zzra.zze = zzrd;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzrd zze() {
        zzrd zzrd = this.zze;
        return zzrd == null ? zzrd.zze() : zzrd;
    }

    public final zzaff zzf() {
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
            return new zzra();
        } else {
            if (i2 == 4) {
                return new zzqz((zzqy) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
