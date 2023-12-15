package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzco  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzco extends zzbo implements zzcn {
    private final zzlm zza;
    private final zzkj zzb;

    public zzco(zzlm zzlm, zzkj zzkj, Class cls) {
        super(zzlm, cls);
        this.zza = zzlm;
        this.zzb = zzkj;
    }

    public final zzsp zzf(zzaff zzaff) throws GeneralSecurityException {
        try {
            zzahp zzc = this.zza.zzc(zzaff);
            this.zza.zze(zzc);
            zzahp zzg = this.zza.zzg(zzc);
            this.zzb.zze(zzg);
            zzsm zza2 = zzsp.zza();
            zza2.zzb(this.zzb.zzd());
            zza2.zzc(zzg.zzo());
            zza2.zza(this.zzb.zzb());
            return (zzsp) zza2.zzi();
        } catch (zzags e) {
            throw new GeneralSecurityException("expected serialized proto of type ", e);
        }
    }
}
