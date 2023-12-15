package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzpl extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzpl zzb;
    private zzpo zzd;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzpl zzpl = new zzpl();
        zzb = zzpl;
        zzagk.zzH(zzpl.class, zzpl);
    }

    private zzpl() {
    }

    public static zzpk zzb() {
        return (zzpk) zzb.zzt();
    }

    public static zzpl zzd(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzpl) zzagk.zzx(zzb, zzaff, zzafx);
    }

    static /* synthetic */ void zzf(zzpl zzpl, zzpo zzpo) {
        zzpo.getClass();
        zzpl.zzd = zzpo;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzpo zze() {
        zzpo zzpo = this.zzd;
        return zzpo == null ? zzpo.zzd() : zzpo;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzd", "zze"});
        } else if (i2 == 3) {
            return new zzpl();
        } else {
            if (i2 == 4) {
                return new zzpk((zzpj) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
