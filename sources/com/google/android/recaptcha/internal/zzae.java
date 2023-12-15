package com.google.android.recaptcha.internal;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzae {
    private final String zza;
    private final long zzb;
    private final int zzc;

    public zzae(String str, long j, int i) {
        this.zza = str;
        this.zzb = j;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzae)) {
            return false;
        }
        zzae zzae = (zzae) obj;
        return Intrinsics.areEqual((Object) zzae.zza, (Object) this.zza) && zzae.zzb == this.zzb && zzae.zzc == this.zzc;
    }

    public final int zza() {
        return this.zzc;
    }

    public final long zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zza;
    }
}
