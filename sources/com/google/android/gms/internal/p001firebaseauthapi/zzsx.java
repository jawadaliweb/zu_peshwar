package com.google.android.gms.internal.p001firebaseauthapi;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzsx extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzsx zzb;
    private String zzd = "";
    private String zze = "";
    private int zzf;
    private boolean zzg;
    private String zzh = "";

    static {
        zzsx zzsx = new zzsx();
        zzb = zzsx;
        zzagk.zzH(zzsx.class, zzsx);
    }

    private zzsx() {
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzsx();
        } else {
            if (i2 == 4) {
                return new zzsw((zzsv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
