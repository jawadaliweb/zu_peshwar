package com.google.android.gms.internal.p001firebaseauthapi;

import org.apache.commons.compress.archivers.tar.TarConstants;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzqm extends zzagk implements zzahq {
    /* access modifiers changed from: private */
    public static final zzqm zzb;

    static {
        zzqm zzqm = new zzqm();
        zzb = zzqm;
        zzagk.zzH(zzqm.class, zzqm);
    }

    private zzqm() {
    }

    public static zzqm zzb() {
        return zzb;
    }

    public static zzqm zzc(zzaff zzaff, zzafx zzafx) throws zzags {
        return (zzqm) zzagk.zzx(zzb, zzaff, zzafx);
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, TarConstants.VERSION_ANT, (Object[]) null);
        }
        if (i2 == 3) {
            return new zzqm();
        }
        if (i2 == 4) {
            return new zzql((zzqk) null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
