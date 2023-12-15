package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzns  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzns implements zzcd {
    private final zzcl zza;
    private final zzoa zzb;
    private final zzoa zzc;

    /* synthetic */ zzns(zzcl zzcl, zznr zznr) {
        zzoa zzoa;
        this.zza = zzcl;
        if (zzcl.zzf()) {
            zzob zzb2 = zzkr.zza().zzb();
            zzog zza2 = zzko.zza(zzcl);
            this.zzb = zzb2.zza(zza2, "mac", "compute");
            zzoa = zzb2.zza(zza2, "mac", "verify");
        } else {
            zzoa = zzko.zza;
            this.zzb = zzoa;
        }
        this.zzc = zzoa;
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, length);
            for (zzch zzch : this.zza.zze(copyOf)) {
                if (zzch.zzc().equals(zztv.LEGACY)) {
                    bArr3 = zzum.zzb(bArr2, zznt.zzb);
                } else {
                    bArr3 = bArr2;
                }
                try {
                    ((zzcd) zzch.zze()).zza(copyOfRange, bArr3);
                    zzch.zza();
                    return;
                } catch (GeneralSecurityException e) {
                    zznt.zza.logp(Level.INFO, "com.google.crypto.tink.mac.MacWrapper$WrappedMac", "verifyMac", "tag prefix matches a key, but cannot verify: ".concat(e.toString()));
                }
            }
            for (zzch zzch2 : this.zza.zze(zzbh.zza)) {
                try {
                    ((zzcd) zzch2.zze()).zza(bArr, bArr2);
                    zzch2.zza();
                    return;
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("invalid MAC");
        }
        throw new GeneralSecurityException("tag too short");
    }
}
