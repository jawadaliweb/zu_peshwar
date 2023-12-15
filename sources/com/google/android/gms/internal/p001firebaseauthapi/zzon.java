package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzon  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzon extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzon zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzoq zze;

    static {
        zzon zzon = new zzon();
        zzb = zzon;
        zzagk.zzH(zzon.class, zzon);
    }

    private zzon() {
    }

    public static zzom zzb() {
        return (zzom) zzb.zzt();
    }

    public static zzon zzd(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzon) zzagk.zzx(zzb, zzaff, zzafx);
    }

    static /* synthetic */ void zzg(zzon zzon, zzoq zzoq) {
        zzoq.getClass();
        zzon.zze = zzoq;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzoq zze() {
        zzoq zzoq = this.zze;
        return zzoq == null ? zzoq.zzd() : zzoq;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzd", "zze"});
        } else if (i2 == 3) {
            return new zzon();
        } else {
            if (i2 == 4) {
                return new zzom((zzol) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
