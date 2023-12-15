package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zztc extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zztc zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzagp zze = zzA();

    static {
        zztc zztc = new zztc();
        zzb = zztc;
        zzagk.zzH(zztc.class, zztc);
    }

    private zztc() {
    }

    public static zzsz zzc() {
        return (zzsz) zzb.zzt();
    }

    public static zztc zzf(InputStream inputStream, zzafx zzafx) throws IOException {
        return (zztc) zzagk.zzy(zzb, inputStream, zzafx);
    }

    public static zztc zzg(byte[] bArr, zzafx zzafx) throws zzags {
        return (zztc) zzagk.zzz(zzb, bArr, zzafx);
    }

    static /* synthetic */ void zzk(zztc zztc, zztb zztb) {
        zztb.getClass();
        zzagp zzagp = zztc.zze;
        if (!zzagp.zzc()) {
            zztc.zze = zzagk.zzB(zzagp);
        }
        zztc.zze.add(zztb);
    }

    public final int zza() {
        return this.zze.size();
    }

    public final int zzb() {
        return this.zzd;
    }

    public final zztb zzd(int i) {
        return (zztb) this.zze.get(i);
    }

    public final List zzh() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzd", "zze", zztb.class});
        } else if (i2 == 3) {
            return new zztc();
        } else {
            if (i2 == 4) {
                return new zzsz((zzsy) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
