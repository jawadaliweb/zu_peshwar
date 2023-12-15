package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
class zzbo implements zzbm {
    private final zzkj zza;
    private final Class zzb;

    public zzbo(zzkj zzkj, Class cls) {
        if (zzkj.zzm().contains(cls) || Void.class.equals(cls)) {
            this.zza = zzkj;
            this.zzb = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{zzkj.toString(), cls.getName()}));
    }

    private final zzbn zzf() {
        return new zzbn(this.zza.zza());
    }

    private final Object zzg(zzahp zzahp) throws GeneralSecurityException {
        if (!Void.class.equals(this.zzb)) {
            this.zza.zze(zzahp);
            return this.zza.zzl(zzahp, this.zzb);
        }
        throw new GeneralSecurityException("Cannot create a primitive for Void");
    }

    public final zzsp zza(zzaff zzaff) throws GeneralSecurityException {
        try {
            zzahp zza2 = zzf().zza(zzaff);
            zzsm zza3 = zzsp.zza();
            zza3.zzb(this.zza.zzd());
            zza3.zzc(zza2.zzo());
            zza3.zza(this.zza.zzb());
            return (zzsp) zza3.zzi();
        } catch (zzags e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    public final zzahp zzb(zzaff zzaff) throws GeneralSecurityException {
        try {
            return zzf().zza(zzaff);
        } catch (zzags e) {
            throw new GeneralSecurityException("Failures parsing proto of type ".concat(String.valueOf(this.zza.zza().zzg().getName())), e);
        }
    }

    public final Object zzc(zzaff zzaff) throws GeneralSecurityException {
        try {
            return zzg(this.zza.zzc(zzaff));
        } catch (zzags e) {
            throw new GeneralSecurityException("Failures parsing proto of type ".concat(String.valueOf(this.zza.zzk().getName())), e);
        }
    }

    public final Object zzd(zzahp zzahp) throws GeneralSecurityException {
        String valueOf = String.valueOf(this.zza.zzk().getName());
        if (this.zza.zzk().isInstance(zzahp)) {
            return zzg(zzahp);
        }
        throw new GeneralSecurityException("Expected proto of type ".concat(valueOf));
    }

    public final String zze() {
        return this.zza.zzd();
    }
}
