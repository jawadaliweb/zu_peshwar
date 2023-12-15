package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zztt extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zztt zzb;
    private String zzd = "";
    private zzsu zze;

    static {
        zztt zztt = new zztt();
        zzb = zztt;
        zzagk.zzH(zztt.class, zztt);
    }

    private zztt() {
    }

    public static zztt zzc() {
        return zzb;
    }

    public static zztt zzd(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zztt) zzagk.zzx(zzb, zzaff, zzafx);
    }

    public final zzsu zza() {
        zzsu zzsu = this.zze;
        return zzsu == null ? zzsu.zzc() : zzsu;
    }

    public final String zze() {
        return this.zzd;
    }

    public final boolean zzf() {
        return this.zze != null;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzd", "zze"});
        } else if (i2 == 3) {
            return new zztt();
        } else {
            if (i2 == 4) {
                return new zzts((zztr) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
