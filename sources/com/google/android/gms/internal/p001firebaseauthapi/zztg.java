package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zztg extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zztg zzb;
    private String zzd = "";
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public int zzg;

    static {
        zztg zztg = new zztg();
        zzb = zztg;
        zzagk.zzH(zztg.class, zztg);
    }

    private zztg() {
    }

    public static zztf zzb() {
        return (zztf) zzb.zzt();
    }

    static /* synthetic */ void zzd(zztg zztg, String str) {
        str.getClass();
        zztg.zzd = str;
    }

    public final int zza() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zztg();
        } else {
            if (i2 == 4) {
                return new zztf((zztd) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
