package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzsp extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzsp zzb;
    /* access modifiers changed from: private */
    public String zzd = "";
    /* access modifiers changed from: private */
    public zzaff zze = zzaff.zzb;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzsp zzsp = new zzsp();
        zzb = zzsp;
        zzagk.zzH(zzsp.class, zzsp);
    }

    private zzsp() {
    }

    public static zzsm zza() {
        return (zzsm) zzb.zzt();
    }

    public static zzsp zzd() {
        return zzb;
    }

    public final zzso zzb() {
        int i = this.zzf;
        zzso zzso = zzso.UNKNOWN_KEYMATERIAL;
        zzso zzso2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : zzso.REMOTE : zzso.ASYMMETRIC_PUBLIC : zzso.ASYMMETRIC_PRIVATE : zzso.SYMMETRIC : zzso.UNKNOWN_KEYMATERIAL;
        return zzso2 == null ? zzso.UNRECOGNIZED : zzso2;
    }

    public final zzaff zze() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzsp();
        } else {
            if (i2 == 4) {
                return new zzsm((zzsl) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
