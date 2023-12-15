package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzcq {
    public static final /* synthetic */ int zza = 0;
    private static final Logger zzb = Logger.getLogger(zzcq.class.getName());
    private static final AtomicReference zzc = new AtomicReference(new zzbs());
    private static final ConcurrentMap zzd = new ConcurrentHashMap();
    private static final ConcurrentMap zze = new ConcurrentHashMap();
    private static final ConcurrentMap zzf = new ConcurrentHashMap();
    private static final ConcurrentMap zzg = new ConcurrentHashMap();

    private zzcq() {
    }

    public static zzbm zza(String str) throws GeneralSecurityException {
        return ((zzbs) zzc.get()).zzb(str);
    }

    public static synchronized zzsp zzb(zzsu zzsu) throws GeneralSecurityException {
        zzsp zza2;
        synchronized (zzcq.class) {
            zzbm zza3 = zza(zzsu.zzf());
            if (((Boolean) zze.get(zzsu.zzf())).booleanValue()) {
                zza2 = zza3.zza(zzsu.zze());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type ".concat(String.valueOf(zzsu.zzf())));
            }
        }
        return zza2;
    }

    public static synchronized zzahp zzc(zzsu zzsu) throws GeneralSecurityException {
        zzahp zzb2;
        synchronized (zzcq.class) {
            zzbm zza2 = zza(zzsu.zzf());
            if (((Boolean) zze.get(zzsu.zzf())).booleanValue()) {
                zzb2 = zza2.zzb(zzsu.zze());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type ".concat(String.valueOf(zzsu.zzf())));
            }
        }
        return zzb2;
    }

    @Nullable
    public static Class zzd(Class cls) {
        try {
            return zzks.zza().zzb(cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public static Object zze(String str, zzaff zzaff, Class cls) throws GeneralSecurityException {
        return ((zzbs) zzc.get()).zza(str, cls).zzc(zzaff);
    }

    public static Object zzf(String str, zzahp zzahp, Class cls) throws GeneralSecurityException {
        return ((zzbs) zzc.get()).zza(str, cls).zzd(zzahp);
    }

    static synchronized Map zzg() {
        Map unmodifiableMap;
        synchronized (zzcq.class) {
            unmodifiableMap = Collections.unmodifiableMap(zzg);
        }
        return unmodifiableMap;
    }

    public static synchronized void zzh(zzlm zzlm, zzkj zzkj, boolean z) throws GeneralSecurityException {
        synchronized (zzcq.class) {
            AtomicReference atomicReference = zzc;
            zzbs zzbs = new zzbs((zzbs) atomicReference.get());
            zzbs.zzc(zzlm, zzkj);
            Map zzc2 = zzlm.zza().zzc();
            String zzd2 = zzlm.zzd();
            zzk(zzd2, zzc2, true);
            String zzd3 = zzkj.zzd();
            zzk(zzd3, Collections.emptyMap(), false);
            if (!((zzbs) atomicReference.get()).zze(zzd2)) {
                zzd.put(zzd2, new zzcp(zzlm));
                zzl(zzlm.zzd(), zzlm.zza().zzc());
            }
            ConcurrentMap concurrentMap = zze;
            concurrentMap.put(zzd2, true);
            concurrentMap.put(zzd3, false);
            atomicReference.set(zzbs);
        }
    }

    public static synchronized void zzi(zzkj zzkj, boolean z) throws GeneralSecurityException {
        synchronized (zzcq.class) {
            AtomicReference atomicReference = zzc;
            zzbs zzbs = new zzbs((zzbs) atomicReference.get());
            zzbs.zzd(zzkj);
            Map zzc2 = zzkj.zza().zzc();
            String zzd2 = zzkj.zzd();
            zzk(zzd2, zzc2, true);
            if (!((zzbs) atomicReference.get()).zze(zzd2)) {
                zzd.put(zzd2, new zzcp(zzkj));
                zzl(zzd2, zzkj.zza().zzc());
            }
            zze.put(zzd2, true);
            atomicReference.set(zzbs);
        }
    }

    public static synchronized void zzj(zzcm zzcm) throws GeneralSecurityException {
        synchronized (zzcq.class) {
            zzks.zza().zzf(zzcm);
        }
    }

    private static synchronized void zzk(String str, Map map, boolean z) throws GeneralSecurityException {
        synchronized (zzcq.class) {
            if (z) {
                ConcurrentMap concurrentMap = zze;
                if (concurrentMap.containsKey(str)) {
                    if (!((Boolean) concurrentMap.get(str)).booleanValue()) {
                        throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(str));
                    }
                }
                if (((zzbs) zzc.get()).zze(str)) {
                    for (Map.Entry entry : map.entrySet()) {
                        if (!zzg.containsKey(entry.getKey())) {
                            throw new GeneralSecurityException("Attempted to register a new key template " + ((String) entry.getKey()) + " from an existing key manager of type " + str);
                        }
                    }
                } else {
                    for (Map.Entry entry2 : map.entrySet()) {
                        if (zzg.containsKey(entry2.getKey())) {
                            throw new GeneralSecurityException("Attempted overwrite of a registered key template ".concat(String.valueOf((String) entry2.getKey())));
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [com.google.android.gms.internal.firebase-auth-api.zzahp, java.lang.Object] */
    private static void zzl(String str, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            zzg.put((String) entry.getKey(), zzbu.zze(str, ((zzkh) entry.getValue()).zza.zzq(), ((zzkh) entry.getValue()).zzb));
        }
    }
}
