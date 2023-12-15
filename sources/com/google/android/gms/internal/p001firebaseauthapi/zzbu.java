package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzbu {
    private final zzsu zza;

    private zzbu(zzsu zzsu) {
        this.zza = zzsu;
    }

    public static zzbu zze(String str, byte[] bArr, int i) {
        zzst zza2 = zzsu.zza();
        zza2.zzb(str);
        zzaff zzaff = zzaff.zzb;
        zza2.zzc(zzaff.zzn(bArr, 0, bArr.length));
        int i2 = i - 1;
        zza2.zza(i2 != 0 ? i2 != 1 ? i2 != 2 ? zztv.CRUNCHY : zztv.RAW : zztv.LEGACY : zztv.TINK);
        return new zzbu((zzsu) zza2.zzi());
    }

    /* access modifiers changed from: package-private */
    public final zzsu zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zza.zzf();
    }

    public final byte[] zzc() {
        return this.zza.zze().zzq();
    }

    public final int zzd() {
        zztv zzd = this.zza.zzd();
        zztv zztv = zztv.UNKNOWN_PREFIX;
        int ordinal = zzd.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                i = 3;
                if (ordinal != 3) {
                    if (ordinal == 4) {
                        return 4;
                    }
                    throw new IllegalArgumentException("Unknown output prefix type");
                }
            }
        }
        return i;
    }
}
