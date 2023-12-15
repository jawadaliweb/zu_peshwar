package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzrl extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzrl zzb;
    /* access modifiers changed from: private */
    public zzaff zzd = zzaff.zzb;
    private zzth zze;

    static {
        zzrl zzrl = new zzrl();
        zzb = zzrl;
        zzagk.zzH(zzrl.class, zzrl);
    }

    private zzrl() {
    }

    public static zzrk zza() {
        return (zzrk) zzb.zzt();
    }

    public static zzrl zzc(InputStream inputStream, zzafx zzafx) throws IOException {
        return (zzrl) zzagk.zzy(zzb, inputStream, zzafx);
    }

    static /* synthetic */ void zzf(zzrl zzrl, zzth zzth) {
        zzth.getClass();
        zzrl.zze = zzth;
    }

    public final zzaff zzd() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003\t", new Object[]{"zzd", "zze"});
        } else if (i2 == 3) {
            return new zzrl();
        } else {
            if (i2 == 4) {
                return new zzrk((zzrj) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
