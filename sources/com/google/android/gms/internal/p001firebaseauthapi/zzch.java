package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzch  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzch {
    @Nullable
    private final Object zza;
    @Nullable
    private final Object zzb;
    private final byte[] zzc;
    private final zztv zzd;
    private final int zze;
    private final String zzf;
    private final zzbl zzg;
    private final int zzh;

    zzch(@Nullable Object obj, @Nullable Object obj2, byte[] bArr, int i, zztv zztv, int i2, String str, zzbl zzbl) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = Arrays.copyOf(bArr, bArr.length);
        this.zzh = i;
        this.zzd = zztv;
        this.zze = i2;
        this.zzf = str;
        this.zzg = zzbl;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzbl zzb() {
        return this.zzg;
    }

    public final zztv zzc() {
        return this.zzd;
    }

    @Nullable
    public final Object zzd() {
        return this.zza;
    }

    @Nullable
    public final Object zze() {
        return this.zzb;
    }

    public final String zzf() {
        return this.zzf;
    }

    @Nullable
    public final byte[] zzg() {
        byte[] bArr = this.zzc;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final int zzh() {
        return this.zzh;
    }
}
