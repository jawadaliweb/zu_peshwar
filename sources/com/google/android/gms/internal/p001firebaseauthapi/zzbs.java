package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbs  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzbs {
    private static final Logger zza = Logger.getLogger(zzbs.class.getName());
    private final ConcurrentMap zzb;

    zzbs() {
        this.zzb = new ConcurrentHashMap();
    }

    private final synchronized zzbr zzf(String str) throws GeneralSecurityException {
        if (this.zzb.containsKey(str)) {
        } else {
            throw new GeneralSecurityException("No key manager found for key type ".concat(String.valueOf(str)));
        }
        return (zzbr) this.zzb.get(str);
    }

    private final synchronized void zzg(zzbr zzbr, boolean z) throws GeneralSecurityException {
        String zze = zzbr.zzb().zze();
        zzbr zzbr2 = (zzbr) this.zzb.get(zze);
        if (zzbr2 != null) {
            if (!zzbr2.zzc().equals(zzbr.zzc())) {
                zza.logp(Level.WARNING, "com.google.crypto.tink.KeyManagerRegistry", "registerKeyManagerContainer", "Attempted overwrite of a registered key manager for key type ".concat(zze));
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{zze, zzbr2.zzc().getName(), zzbr.zzc().getName()}));
            }
        }
        if (!z) {
            this.zzb.putIfAbsent(zze, zzbr);
        } else {
            this.zzb.put(zze, zzbr);
        }
    }

    /* access modifiers changed from: package-private */
    public final zzbm zza(String str, Class cls) throws GeneralSecurityException {
        zzbr zzf = zzf(str);
        if (zzf.zze().contains(cls)) {
            return zzf.zza(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzf.zzc());
        Set<Class> zze = zzf.zze();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class cls2 : zze) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z = false;
        }
        String sb2 = sb.toString();
        throw new GeneralSecurityException("Primitive type " + name + " not supported by key manager of type " + valueOf + ", supported primitives: " + sb2);
    }

    /* access modifiers changed from: package-private */
    public final zzbm zzb(String str) throws GeneralSecurityException {
        return zzf(str).zzb();
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzc(zzlm zzlm, zzkj zzkj) throws GeneralSecurityException {
        Class zzd;
        if (!zzhj.zza(1)) {
            String valueOf = String.valueOf(zzlm.getClass());
            throw new GeneralSecurityException("failed to register key manager " + valueOf + " as it is not FIPS compatible.");
        } else if (zzhj.zza(zzkj.zzf())) {
            String zzd2 = zzlm.zzd();
            String zzd3 = zzkj.zzd();
            if (!(!this.zzb.containsKey(zzd2) || ((zzbr) this.zzb.get(zzd2)).zzd() == null || (zzd = ((zzbr) this.zzb.get(zzd2)).zzd()) == null)) {
                if (!zzd.getName().equals(zzkj.getClass().getName())) {
                    Logger logger = zza;
                    Level level = Level.WARNING;
                    logger.logp(level, "com.google.crypto.tink.KeyManagerRegistry", "registerAsymmetricKeyManagers", "Attempted overwrite of a registered key manager for key type " + zzd2 + " with inconsistent public key type " + zzd3);
                    throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", new Object[]{zzlm.getClass().getName(), zzd.getName(), zzkj.getClass().getName()}));
                }
            }
            zzg(new zzbq(zzlm, zzkj), true);
            zzg(new zzbp(zzkj), false);
        } else {
            String valueOf2 = String.valueOf(zzkj.getClass());
            throw new GeneralSecurityException("failed to register key manager " + valueOf2 + " as it is not FIPS compatible.");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzd(zzkj zzkj) throws GeneralSecurityException {
        if (zzhj.zza(zzkj.zzf())) {
            zzg(new zzbp(zzkj), false);
        } else {
            String valueOf = String.valueOf(zzkj.getClass());
            throw new GeneralSecurityException("failed to register key manager " + valueOf + " as it is not FIPS compatible.");
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zze(String str) {
        return this.zzb.containsKey(str);
    }

    zzbs(zzbs zzbs) {
        this.zzb = new ConcurrentHashMap(zzbs.zzb);
    }
}
