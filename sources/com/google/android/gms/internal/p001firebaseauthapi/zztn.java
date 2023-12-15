package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zztn extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zztn zzb;
    private String zzd = "";

    static {
        zztn zztn = new zztn();
        zzb = zztn;
        zzagk.zzH(zztn.class, zztn);
    }

    private zztn() {
    }

    public static zztn zzb() {
        return zzb;
    }

    public static zztn zzc(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zztn) zzagk.zzx(zzb, zzaff, zzafx);
    }

    public final String zzd() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzd"});
        } else if (i2 == 3) {
            return new zztn();
        } else {
            if (i2 == 4) {
                return new zztm((zztl) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
