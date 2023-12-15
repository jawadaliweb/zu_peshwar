package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzok  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzok extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzok zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public zzaff zze = zzaff.zzb;
    private zzoq zzf;

    static {
        zzok zzok = new zzok();
        zzb = zzok;
        zzagk.zzH(zzok.class, zzok);
    }

    private zzok() {
    }

    public static zzoj zzb() {
        return (zzoj) zzb.zzt();
    }

    public static zzok zzd(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzok) zzagk.zzx(zzb, zzaff, zzafx);
    }

    static /* synthetic */ void zzi(zzok zzok, zzoq zzoq) {
        zzoq.getClass();
        zzok.zzf = zzoq;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzoq zze() {
        zzoq zzoq = this.zzf;
        return zzoq == null ? zzoq.zzd() : zzoq;
    }

    public final zzaff zzf() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzok();
        } else {
            if (i2 == 4) {
                return new zzoj((zzoi) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
