package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzbz {
    private final zzsz zza;

    private zzbz(zzsz zzsz) {
        this.zza = zzsz;
    }

    public static zzbz zze() {
        return new zzbz(zztc.zzc());
    }

    public static zzbz zzf(zzby zzby) {
        return new zzbz((zzsz) zzby.zzc().zzu());
    }

    private final synchronized int zzg() {
        int zza2;
        zza2 = zzly.zza();
        while (zzj(zza2)) {
            zza2 = zzly.zza();
        }
        return zza2;
    }

    private final synchronized zztb zzh(zzsp zzsp, zztv zztv) throws GeneralSecurityException {
        zzta zzc;
        int zzg = zzg();
        if (zztv != zztv.UNKNOWN_PREFIX) {
            zzc = zztb.zzc();
            zzc.zza(zzsp);
            zzc.zzb(zzg);
            zzc.zzd(3);
            zzc.zzc(zztv);
        } else {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return (zztb) zzc.zzi();
    }

    private final synchronized zztb zzi(zzsu zzsu) throws GeneralSecurityException {
        return zzh(zzcq.zzb(zzsu), zzsu.zzd());
    }

    private final synchronized boolean zzj(int i) {
        boolean z;
        Iterator it = this.zza.zze().iterator();
        while (true) {
            if (it.hasNext()) {
                if (((zztb) it.next()).zza() == i) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        return z;
    }

    public final synchronized int zza(zzsu zzsu, boolean z) throws GeneralSecurityException {
        zztb zzi;
        zzi = zzi(zzsu);
        this.zza.zzb(zzi);
        return zzi.zza();
    }

    public final synchronized zzby zzb() throws GeneralSecurityException {
        return zzby.zza((zztc) this.zza.zzi());
    }

    public final synchronized zzbz zzc(zzbu zzbu) throws GeneralSecurityException {
        zza(zzbu.zza(), false);
        return this;
    }

    public final synchronized zzbz zzd(int i) throws GeneralSecurityException {
        int i2 = 0;
        while (i2 < this.zza.zza()) {
            zztb zzd = this.zza.zzd(i2);
            if (zzd.zza() != i) {
                i2++;
            } else if (zzd.zzk() == 3) {
                this.zza.zzc(i);
            } else {
                throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i);
            }
        }
        throw new GeneralSecurityException("key not found: " + i);
        return this;
    }
}
