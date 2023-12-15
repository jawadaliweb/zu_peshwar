package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzsu extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzsu zzb;
    private String zzd = "";
    /* access modifiers changed from: private */
    public zzaff zze = zzaff.zzb;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzsu zzsu = new zzsu();
        zzb = zzsu;
        zzagk.zzH(zzsu.class, zzsu);
    }

    private zzsu() {
    }

    public static zzst zza() {
        return (zzst) zzb.zzt();
    }

    public static zzsu zzc() {
        return zzb;
    }

    static /* synthetic */ void zzg(zzsu zzsu, String str) {
        str.getClass();
        zzsu.zzd = str;
    }

    public final zztv zzd() {
        zztv zzb2 = zztv.zzb(this.zzf);
        return zzb2 == null ? zztv.UNRECOGNIZED : zzb2;
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
            return new zzsu();
        } else {
            if (i2 == 4) {
                return new zzst((zzss) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
