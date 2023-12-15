package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzahb extends zzahd {
    private zzahb() {
        super((zzahc) null);
    }

    /* synthetic */ zzahb(zzaha zzaha) {
        super((zzahc) null);
    }

    /* access modifiers changed from: package-private */
    public final List zza(Object obj, long j) {
        zzagp zzagp = (zzagp) zzajf.zzf(obj, j);
        if (zzagp.zzc()) {
            return zzagp;
        }
        int size = zzagp.size();
        zzagp zzd = zzagp.zzd(size == 0 ? 10 : size + size);
        zzajf.zzs(obj, j, zzd);
        return zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        ((zzagp) zzajf.zzf(obj, j)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Object obj, Object obj2, long j) {
        zzagp zzagp = (zzagp) zzajf.zzf(obj, j);
        zzagp zzagp2 = (zzagp) zzajf.zzf(obj2, j);
        int size = zzagp.size();
        int size2 = zzagp2.size();
        if (size > 0 && size2 > 0) {
            if (!zzagp.zzc()) {
                zzagp = zzagp.zzd(size2 + size);
            }
            zzagp.addAll(zzagp2);
        }
        if (size > 0) {
            zzagp2 = zzagp;
        }
        zzajf.zzs(obj, j, zzagp2);
    }
}
