package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
final class zzad implements Iterator {
    final /* synthetic */ zzae zza;
    private int zzb = 0;

    zzad(zzae zzae) {
        this.zza = zzae;
    }

    public final boolean hasNext() {
        return this.zzb < this.zza.zzc();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        if (this.zzb < this.zza.zzc()) {
            zzae zzae = this.zza;
            int i = this.zzb;
            this.zzb = i + 1;
            return zzae.zze(i);
        }
        int i2 = this.zzb;
        throw new NoSuchElementException("Out of bounds index: " + i2);
    }
}
