package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaew  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaew extends zzaey {
    final /* synthetic */ zzaff zza;
    private int zzb = 0;
    private final int zzc;

    zzaew(zzaff zzaff) {
        this.zza = zzaff;
        this.zzc = zzaff.zzd();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i = this.zzb;
        if (i < this.zzc) {
            this.zzb = i + 1;
            return this.zza.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
