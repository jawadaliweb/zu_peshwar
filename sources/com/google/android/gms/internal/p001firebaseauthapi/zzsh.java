package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzsh extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzsh zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzsk zze;
    /* access modifiers changed from: private */
    public zzaff zzf = zzaff.zzb;

    static {
        zzsh zzsh = new zzsh();
        zzb = zzsh;
        zzagk.zzH(zzsh.class, zzsh);
    }

    private zzsh() {
    }

    public static zzsg zzb() {
        return (zzsg) zzb.zzt();
    }

    public static zzsh zzd(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzsh) zzagk.zzx(zzb, zzaff, zzafx);
    }

    static /* synthetic */ void zzh(zzsh zzsh, zzsk zzsk) {
        zzsk.getClass();
        zzsh.zze = zzsk;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzsk zze() {
        zzsk zzsk = this.zze;
        return zzsk == null ? zzsk.zze() : zzsk;
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
            return new zzsh();
        } else {
            if (i2 == 4) {
                return new zzsg((zzsf) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final boolean zzk() {
        return this.zze != null;
    }
}
