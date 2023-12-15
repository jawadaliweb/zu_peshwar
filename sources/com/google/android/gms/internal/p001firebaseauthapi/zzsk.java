package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzsk extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzsk zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzse zze;
    /* access modifiers changed from: private */
    public zzaff zzf = zzaff.zzb;

    static {
        zzsk zzsk = new zzsk();
        zzb = zzsk;
        zzagk.zzH(zzsk.class, zzsk);
    }

    private zzsk() {
    }

    public static zzsj zzc() {
        return (zzsj) zzb.zzt();
    }

    public static zzsk zze() {
        return zzb;
    }

    public static zzsk zzf(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzsk) zzagk.zzx(zzb, zzaff, zzafx);
    }

    static /* synthetic */ void zzi(zzsk zzsk, zzse zzse) {
        zzse.getClass();
        zzsk.zze = zzse;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzse zzb() {
        zzse zzse = this.zze;
        return zzse == null ? zzse.zzc() : zzse;
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
            return new zzsk();
        } else {
            if (i2 == 4) {
                return new zzsj((zzsi) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final boolean zzl() {
        return this.zze != null;
    }
}
