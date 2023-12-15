package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzahg implements zzahn {
    private final zzahn[] zza;

    zzahg(zzahn... zzahnArr) {
        this.zza = zzahnArr;
    }

    public final zzahm zzb(Class cls) {
        zzahn[] zzahnArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzahn zzahn = zzahnArr[i];
            if (zzahn.zzc(cls)) {
                return zzahn.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    public final boolean zzc(Class cls) {
        zzahn[] zzahnArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzahnArr[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
