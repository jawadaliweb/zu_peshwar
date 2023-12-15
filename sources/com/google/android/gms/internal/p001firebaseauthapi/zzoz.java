package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzoz extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzoz zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzpf zze;
    /* access modifiers changed from: private */
    public zzaff zzf = zzaff.zzb;

    static {
        zzoz zzoz = new zzoz();
        zzb = zzoz;
        zzagk.zzH(zzoz.class, zzoz);
    }

    private zzoz() {
    }

    public static zzoy zzb() {
        return (zzoy) zzb.zzt();
    }

    public static zzoz zzd() {
        return zzb;
    }

    public static zzoz zze(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzoz) zzagk.zzx(zzb, zzaff, zzafx);
    }

    static /* synthetic */ void zzi(zzoz zzoz, zzpf zzpf) {
        zzpf.getClass();
        zzoz.zze = zzpf;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzpf zzf() {
        zzpf zzpf = this.zze;
        return zzpf == null ? zzpf.zzd() : zzpf;
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
            return new zzoz();
        } else {
            if (i2 == 4) {
                return new zzoy((zzox) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
