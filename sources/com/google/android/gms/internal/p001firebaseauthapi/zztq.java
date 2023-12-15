package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zztq extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zztq zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zztt zze;

    static {
        zztq zztq = new zztq();
        zzb = zztq;
        zzagk.zzH(zztq.class, zztq);
    }

    private zztq() {
    }

    public static zztp zzb() {
        return (zztp) zzb.zzt();
    }

    public static zztq zzd(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zztq) zzagk.zzx(zzb, zzaff, zzafx);
    }

    static /* synthetic */ void zzg(zztq zztq, zztt zztt) {
        zztt.getClass();
        zztq.zze = zztt;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zztt zze() {
        zztt zztt = this.zze;
        return zztt == null ? zztt.zzc() : zztt;
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
            return new zztq();
        } else {
            if (i2 == 4) {
                return new zztp((zzto) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
