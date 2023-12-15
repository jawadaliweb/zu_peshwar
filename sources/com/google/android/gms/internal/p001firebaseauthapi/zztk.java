package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zztk extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zztk zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zztn zze;

    static {
        zztk zztk = new zztk();
        zzb = zztk;
        zzagk.zzH(zztk.class, zztk);
    }

    private zztk() {
    }

    public static zztj zzb() {
        return (zztj) zzb.zzt();
    }

    public static zztk zzd(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zztk) zzagk.zzx(zzb, zzaff, zzafx);
    }

    static /* synthetic */ void zzg(zztk zztk, zztn zztn) {
        zztn.getClass();
        zztk.zze = zztn;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zztn zze() {
        zztn zztn = this.zze;
        return zztn == null ? zztn.zzb() : zztn;
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
            return new zztk();
        } else {
            if (i2 == 4) {
                return new zztj((zzti) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
