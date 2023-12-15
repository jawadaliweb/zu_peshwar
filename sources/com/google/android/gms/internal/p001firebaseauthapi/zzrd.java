package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzrd extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzrd zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzqx zze;
    /* access modifiers changed from: private */
    public zzaff zzf = zzaff.zzb;
    /* access modifiers changed from: private */
    public zzaff zzg = zzaff.zzb;

    static {
        zzrd zzrd = new zzrd();
        zzb = zzrd;
        zzagk.zzH(zzrd.class, zzrd);
    }

    private zzrd() {
    }

    public static zzrc zzc() {
        return (zzrc) zzb.zzt();
    }

    public static zzrd zze() {
        return zzb;
    }

    public static zzrd zzf(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzrd) zzagk.zzx(zzb, zzaff, zzafx);
    }

    static /* synthetic */ void zzk(zzrd zzrd, zzqx zzqx) {
        zzqx.getClass();
        zzrd.zze = zzqx;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzqx zzb() {
        zzqx zzqx = this.zze;
        return zzqx == null ? zzqx.zzd() : zzqx;
    }

    public final zzaff zzg() {
        return this.zzf;
    }

    public final zzaff zzh() {
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzrd();
        } else {
            if (i2 == 4) {
                return new zzrc((zzrb) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
