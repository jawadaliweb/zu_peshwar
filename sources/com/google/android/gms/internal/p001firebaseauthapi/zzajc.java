package com.google.android.gms.internal.p001firebaseauthapi;

import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzajc extends zzaje {
    zzajc(Unsafe unsafe) {
        super(unsafe);
    }

    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    public final void zzc(Object obj, long j, boolean z) {
        if (zzajf.zzb) {
            zzajf.zzD(obj, j, r3 ? (byte) 1 : 0);
        } else {
            zzajf.zzE(obj, j, r3 ? (byte) 1 : 0);
        }
    }

    public final void zzd(Object obj, long j, byte b) {
        if (zzajf.zzb) {
            zzajf.zzD(obj, j, b);
        } else {
            zzajf.zzE(obj, j, b);
        }
    }

    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    public final boolean zzg(Object obj, long j) {
        if (zzajf.zzb) {
            return zzajf.zzt(obj, j);
        }
        return zzajf.zzu(obj, j);
    }
}
