package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzpc extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzpc zzb;
    private zzpf zzd;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzpc zzpc = new zzpc();
        zzb = zzpc;
        zzagk.zzH(zzpc.class, zzpc);
    }

    private zzpc() {
    }

    public static zzpb zzb() {
        return (zzpb) zzb.zzt();
    }

    public static zzpc zzd() {
        return zzb;
    }

    public static zzpc zze(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzpc) zzagk.zzx(zzb, zzaff, zzafx);
    }

    static /* synthetic */ void zzg(zzpc zzpc, zzpf zzpf) {
        zzpf.getClass();
        zzpc.zzd = zzpf;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzpf zzf() {
        zzpf zzpf = this.zzd;
        return zzpf == null ? zzpf.zzd() : zzpf;
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
            return new zzpc();
        } else {
            if (i2 == 4) {
                return new zzpb((zzpa) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
