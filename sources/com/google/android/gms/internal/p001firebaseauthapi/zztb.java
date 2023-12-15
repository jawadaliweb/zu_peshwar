package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zztb extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zztb zzb;
    private zzsp zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public int zzg;

    static {
        zztb zztb = new zztb();
        zzb = zztb;
        zzagk.zzH(zztb.class, zztb);
    }

    private zztb() {
    }

    public static zzta zzc() {
        return (zzta) zzb.zzt();
    }

    static /* synthetic */ void zzf(zztb zztb, zzsp zzsp) {
        zzsp.getClass();
        zztb.zzd = zzsp;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzsp zzb() {
        zzsp zzsp = this.zzd;
        return zzsp == null ? zzsp.zzd() : zzsp;
    }

    public final zztv zze() {
        zztv zzb2 = zztv.zzb(this.zzg);
        return zzb2 == null ? zztv.UNRECOGNIZED : zzb2;
    }

    public final boolean zzi() {
        return this.zzd != null;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zztb();
        } else {
            if (i2 == 4) {
                return new zzta((zzsy) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final int zzk() {
        int i = this.zze;
        int i2 = 3;
        if (i == 0) {
            i2 = 2;
        } else if (i != 1) {
            i2 = i != 2 ? i != 3 ? 0 : 5 : 4;
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }
}
