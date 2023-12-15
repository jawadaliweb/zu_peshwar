package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzby  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzby {
    private final zztc zza;
    private final List zzb;
    private final zznz zzc = zznz.zza;

    private zzby(zztc zztc, List list) {
        this.zza = zztc;
        this.zzb = list;
    }

    static final zzby zza(zztc zztc) throws GeneralSecurityException {
        zzl(zztc);
        return new zzby(zztc, zzk(zztc));
    }

    public static final zzby zzh(zzbe zzbe, zzbd zzbd) throws GeneralSecurityException, IOException {
        byte[] bArr = new byte[0];
        zzrl zza2 = zzbe.zza();
        if (zza2 == null || zza2.zzd().zzd() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        try {
            zztc zzg = zztc.zzg(zzbd.zza(zza2.zzd().zzq(), bArr), zzafx.zza());
            zzl(zzg);
            return zza(zzg);
        } catch (zzags unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private static zzln zzi(zztb zztb) {
        try {
            return zzln.zza(zztb.zzb().zzf(), zztb.zzb().zze(), zztb.zzb().zzb(), zztb.zze(), zztb.zze() == zztv.RAW ? null : Integer.valueOf(zztb.zza()));
        } catch (GeneralSecurityException e) {
            throw new zzlx("Creating a protokey serialization failed", e);
        }
    }

    @Nullable
    private static Object zzj(zztb zztb, Class cls) throws GeneralSecurityException {
        try {
            zzsp zzb2 = zztb.zzb();
            int i = zzcq.zza;
            return zzcq.zze(zzb2.zzf(), zzb2.zze(), cls);
        } catch (GeneralSecurityException e) {
            if (e.getMessage().contains("No key manager found for key type ") || e.getMessage().contains(" not supported by key manager of type ")) {
                return null;
            }
            throw e;
        }
    }

    private static List zzk(zztc zztc) {
        zzbt zzbt;
        ArrayList arrayList = new ArrayList(zztc.zza());
        for (zztb zztb : zztc.zzh()) {
            int zza2 = zztb.zza();
            try {
                zzbl zza3 = zzkt.zzb().zza(zzi(zztb), zzcr.zza());
                int zzk = zztb.zzk() - 2;
                if (zzk == 1) {
                    zzbt = zzbt.zza;
                } else if (zzk == 2) {
                    zzbt = zzbt.zzb;
                } else if (zzk == 3) {
                    zzbt = zzbt.zzc;
                } else {
                    throw new GeneralSecurityException("Unknown key status");
                }
                arrayList.add(new zzbx(zza3, zzbt, zza2, zza2 == zztc.zzb(), (zzbw) null));
            } catch (GeneralSecurityException unused) {
                arrayList.add((Object) null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static void zzl(zztc zztc) throws GeneralSecurityException {
        if (zztc == null || zztc.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    @Nullable
    private static final Object zzm(zzbl zzbl, Class cls) throws GeneralSecurityException {
        try {
            int i = zzcq.zza;
            return zzks.zza().zzc(zzbl, cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public final String toString() {
        return zzcs.zza(this.zza).toString();
    }

    public final zzby zzb() throws GeneralSecurityException {
        if (this.zza != null) {
            zzsz zzc2 = zztc.zzc();
            for (zztb zztb : this.zza.zzh()) {
                zzsp zzb2 = zztb.zzb();
                if (zzb2.zzb() == zzso.ASYMMETRIC_PRIVATE) {
                    String zzf = zzb2.zzf();
                    zzaff zze = zzb2.zze();
                    zzbm zza2 = zzcq.zza(zzf);
                    if (zza2 instanceof zzcn) {
                        zzsp zzf2 = ((zzcn) zza2).zzf(zze);
                        String zzf3 = zzf2.zzf();
                        zzcq.zza(zzf3).zzc(zzf2.zze());
                        zzta zzta = (zzta) zztb.zzu();
                        zzta.zza(zzf2);
                        zzc2.zzb((zztb) zzta.zzi());
                    } else {
                        throw new GeneralSecurityException("manager for key type " + zzf + " is not a PrivateKeyManager");
                    }
                } else {
                    throw new GeneralSecurityException("The keyset contains a non-private key");
                }
            }
            zzc2.zzc(this.zza.zzb());
            return zza((zztc) zzc2.zzi());
        }
        throw new GeneralSecurityException("cleartext keyset is not available");
    }

    /* access modifiers changed from: package-private */
    public final zztc zzc() {
        return this.zza;
    }

    public final zzth zzd() {
        return zzcs.zza(this.zza);
    }

    public final Object zze(Class cls) throws GeneralSecurityException {
        Class zzd = zzcq.zzd(cls);
        if (zzd != null) {
            zztc zztc = this.zza;
            Charset charset = zzcs.zza;
            int zzb2 = zztc.zzb();
            int i = 0;
            boolean z = false;
            boolean z2 = true;
            for (zztb zztb : zztc.zzh()) {
                if (zztb.zzk() == 3) {
                    if (!zztb.zzi()) {
                        throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(zztb.zza())}));
                    } else if (zztb.zze() == zztv.UNKNOWN_PREFIX) {
                        throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(zztb.zza())}));
                    } else if (zztb.zzk() != 2) {
                        if (zztb.zza() == zzb2) {
                            if (!z) {
                                z = true;
                            } else {
                                throw new GeneralSecurityException("keyset contains multiple primary keys");
                            }
                        }
                        z2 &= zztb.zzb().zzb() == zzso.ASYMMETRIC_PUBLIC;
                        i++;
                    } else {
                        throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(zztb.zza())}));
                    }
                }
            }
            if (i == 0) {
                throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
            } else if (z || z2) {
                zzcg zzcg = new zzcg(zzd, (zzcf) null);
                zzcg.zzc(this.zzc);
                for (int i2 = 0; i2 < this.zza.zza(); i2++) {
                    zztb zzd2 = this.zza.zzd(i2);
                    if (zzd2.zzk() == 3) {
                        Object zzj = zzj(zzd2, zzd);
                        Object zzm = this.zzb.get(i2) != null ? zzm(((zzbx) this.zzb.get(i2)).zza(), zzd) : null;
                        if (zzm == null && zzj == null) {
                            String obj = zzd.toString();
                            String zzf = zzd2.zzb().zzf();
                            throw new GeneralSecurityException("Unable to get primitive " + obj + " for key of type " + zzf);
                        } else if (zzd2.zza() == this.zza.zzb()) {
                            zzcg.zzb(zzm, zzj, zzd2);
                        } else {
                            zzcg.zza(zzm, zzj, zzd2);
                        }
                    }
                }
                return zzks.zza().zzd(zzcg.zzd(), cls);
            } else {
                throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
            }
        } else {
            throw new GeneralSecurityException("No wrapper found for ".concat(String.valueOf(cls.getName())));
        }
    }

    public final void zzf(zzca zzca, zzbd zzbd) throws GeneralSecurityException, IOException {
        byte[] bArr = new byte[0];
        zztc zztc = this.zza;
        byte[] zzb2 = zzbd.zzb(zztc.zzq(), bArr);
        try {
            if (zztc.zzg(zzbd.zza(zzb2, bArr), zzafx.zza()).equals(zztc)) {
                int length = zzb2.length;
                zzrk zza2 = zzrl.zza();
                zza2.zza(zzaff.zzn(zzb2, 0, length));
                zza2.zzb(zzcs.zza(zztc));
                zzca.zzb((zzrl) zza2.zzi());
                return;
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (zzags unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(com.google.android.gms.internal.p001firebaseauthapi.zzca r5) throws java.security.GeneralSecurityException, java.io.IOException {
        /*
            r4 = this;
            com.google.android.gms.internal.firebase-auth-api.zztc r0 = r4.zza
            java.util.List r0 = r0.zzh()
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0064
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.firebase-auth-api.zztb r1 = (com.google.android.gms.internal.p001firebaseauthapi.zztb) r1
            com.google.android.gms.internal.firebase-auth-api.zzsp r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzso r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzso r3 = com.google.android.gms.internal.p001firebaseauthapi.zzso.UNKNOWN_KEYMATERIAL
            if (r2 == r3) goto L_0x003b
            com.google.android.gms.internal.firebase-auth-api.zzsp r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzso r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzso r3 = com.google.android.gms.internal.p001firebaseauthapi.zzso.SYMMETRIC
            if (r2 == r3) goto L_0x003b
            com.google.android.gms.internal.firebase-auth-api.zzsp r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzso r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzso r3 = com.google.android.gms.internal.p001firebaseauthapi.zzso.ASYMMETRIC_PRIVATE
            if (r2 == r3) goto L_0x003b
            goto L_0x000a
        L_0x003b:
            java.security.GeneralSecurityException r5 = new java.security.GeneralSecurityException
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r2 = 0
            com.google.android.gms.internal.firebase-auth-api.zzsp r3 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzso r3 = r3.zzb()
            java.lang.String r3 = r3.name()
            r0[r2] = r3
            r2 = 1
            com.google.android.gms.internal.firebase-auth-api.zzsp r1 = r1.zzb()
            java.lang.String r1 = r1.zzf()
            r0[r2] = r1
            java.lang.String r1 = "keyset contains key material of type %s for type url %s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r5.<init>(r0)
            throw r5
        L_0x0064:
            com.google.android.gms.internal.firebase-auth-api.zztc r0 = r4.zza
            r5.zzc(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzby.zzg(com.google.android.gms.internal.firebase-auth-api.zzca):void");
    }
}
