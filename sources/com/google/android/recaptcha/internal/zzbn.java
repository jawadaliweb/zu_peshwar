package com.google.android.recaptcha.internal;

import java.util.HashMap;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzbn {
    private final zzbm zza;
    private byte zzb = ((byte) RangesKt.random(new IntRange(1, 127), (Random) Random.Default));
    private final HashMap zzc;

    public zzbn() {
        zzbm zzbm = new zzbm();
        this.zza = zzbm;
        HashMap hashMap = new HashMap();
        this.zzc = hashMap;
        zzbm.zze(173, hashMap);
    }

    public final byte zza() {
        return this.zzb;
    }

    public final zzbm zzb() {
        return this.zza;
    }

    public final void zzc() {
        this.zza.zzd();
        this.zza.zze(173, this.zzc);
    }

    public final void zzd(byte b) {
        this.zzb = b;
    }

    public final void zze(int i, Object obj) {
        this.zzc.put(1, obj);
    }
}
