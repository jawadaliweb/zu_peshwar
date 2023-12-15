package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzpi extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzpi zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzpo zze;
    /* access modifiers changed from: private */
    public zzaff zzf = zzaff.zzb;

    static {
        zzpi zzpi = new zzpi();
        zzb = zzpi;
        zzagk.zzH(zzpi.class, zzpi);
    }

    private zzpi() {
    }

    public static zzph zzb() {
        return (zzph) zzb.zzt();
    }

    public static zzpi zzd(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzpi) zzagk.zzx(zzb, zzaff, zzafx);
    }

    static /* synthetic */ void zzh(zzpi zzpi, zzpo zzpo) {
        zzpo.getClass();
        zzpi.zze = zzpo;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzpo zze() {
        zzpo zzpo = this.zze;
        return zzpo == null ? zzpo.zzd() : zzpo;
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
            return new zzpi();
        } else {
            if (i2 == 4) {
                return new zzph((zzpg) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
