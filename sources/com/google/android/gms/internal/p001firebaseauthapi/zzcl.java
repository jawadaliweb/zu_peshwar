package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzcl {
    private final ConcurrentMap zza;
    private final List zzb;
    private final zzch zzc;
    private final Class zzd;
    private final zznz zze;

    /* synthetic */ zzcl(ConcurrentMap concurrentMap, List list, zzch zzch, zznz zznz, Class cls, zzck zzck) {
        this.zza = concurrentMap;
        this.zzb = list;
        this.zzc = zzch;
        this.zzd = cls;
        this.zze = zznz;
    }

    @Nullable
    public final zzch zza() {
        return this.zzc;
    }

    public final zznz zzb() {
        return this.zze;
    }

    public final Class zzc() {
        return this.zzd;
    }

    public final Collection zzd() {
        return this.zza.values();
    }

    public final List zze(byte[] bArr) {
        List list = (List) this.zza.get(new zzcj(bArr, (zzci) null));
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }

    public final boolean zzf() {
        return !this.zze.zza().isEmpty();
    }
}
