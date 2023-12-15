package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzth  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzth extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzth zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzagp zze = zzA();

    static {
        zzth zzth = new zzth();
        zzb = zzth;
        zzagk.zzH(zzth.class, zzth);
    }

    private zzth() {
    }

    public static zzte zza() {
        return (zzte) zzb.zzt();
    }

    static /* synthetic */ void zze(zzth zzth, zztg zztg) {
        zztg.getClass();
        zzagp zzagp = zzth.zze;
        if (!zzagp.zzc()) {
            zzth.zze = zzagk.zzB(zzagp);
        }
        zzth.zze.add(zztg);
    }

    public final zztg zzb(int i) {
        return (zztg) this.zze.get(0);
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzd", "zze", zztg.class});
        } else if (i2 == 3) {
            return new zzth();
        } else {
            if (i2 == 4) {
                return new zzte((zztd) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
