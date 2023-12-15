package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzow  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzow extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzow zzb;
    private zzpc zzd;
    private zzrt zze;

    static {
        zzow zzow = new zzow();
        zzb = zzow;
        zzagk.zzH(zzow.class, zzow);
    }

    private zzow() {
    }

    public static zzov zza() {
        return (zzov) zzb.zzt();
    }

    public static zzow zzc(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzow) zzagk.zzx(zzb, zzaff, zzafx);
    }

    static /* synthetic */ void zzf(zzow zzow, zzpc zzpc) {
        zzpc.getClass();
        zzow.zzd = zzpc;
    }

    static /* synthetic */ void zzg(zzow zzow, zzrt zzrt) {
        zzrt.getClass();
        zzow.zze = zzrt;
    }

    public final zzpc zzd() {
        zzpc zzpc = this.zzd;
        return zzpc == null ? zzpc.zzd() : zzpc;
    }

    public final zzrt zze() {
        zzrt zzrt = this.zze;
        return zzrt == null ? zzrt.zzd() : zzrt;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzd", "zze"});
        } else if (i2 == 3) {
            return new zzow();
        } else {
            if (i2 == 4) {
                return new zzov((zzou) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
