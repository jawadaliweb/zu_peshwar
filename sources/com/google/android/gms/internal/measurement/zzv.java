package com.google.android.gms.internal.measurement;

import com.microsoft.appcenter.ingestion.models.CommonProperties;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
public final class zzv extends zzai {
    private final zzz zza;

    public zzv(zzz zzz) {
        super("internal.registerCallback");
        this.zza = zzz;
    }

    public final zzap zza(zzg zzg, List list) {
        zzh.zzh(this.zzd, 3, list);
        String zzi = zzg.zzb((zzap) list.get(0)).zzi();
        zzap zzb = zzg.zzb((zzap) list.get(1));
        if (zzb instanceof zzao) {
            zzap zzb2 = zzg.zzb((zzap) list.get(2));
            if (zzb2 instanceof zzam) {
                zzam zzam = (zzam) zzb2;
                if (zzam.zzt(CommonProperties.TYPE)) {
                    this.zza.zza(zzi, zzam.zzt("priority") ? zzh.zzb(zzam.zzf("priority").zzh().doubleValue()) : 1000, (zzao) zzb, zzam.zzf(CommonProperties.TYPE).zzi());
                    return zzap.zzf;
                }
                throw new IllegalArgumentException("Undefined rule type");
            }
            throw new IllegalArgumentException("Invalid callback params");
        }
        throw new IllegalArgumentException("Invalid callback type");
    }
}
