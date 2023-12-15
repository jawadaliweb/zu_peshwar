package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzln  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzln implements zzlp {
    private final String zza;
    private final zzvx zzb;
    private final zzaff zzc;
    private final zzso zzd;
    private final zztv zze;
    @Nullable
    private final Integer zzf;

    private zzln(String str, zzaff zzaff, zzso zzso, zztv zztv, @Nullable Integer num) {
        this.zza = str;
        this.zzb = zzly.zzb(str);
        this.zzc = zzaff;
        this.zzd = zzso;
        this.zze = zztv;
        this.zzf = num;
    }

    public static zzln zza(String str, zzaff zzaff, zzso zzso, zztv zztv, @Nullable Integer num) throws GeneralSecurityException {
        if (zztv == zztv.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzln(str, zzaff, zzso, zztv, num);
    }

    public final zzso zzb() {
        return this.zzd;
    }

    public final zztv zzc() {
        return this.zze;
    }

    public final zzvx zzd() {
        return this.zzb;
    }

    public final zzaff zze() {
        return this.zzc;
    }

    @Nullable
    public final Integer zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zza;
    }
}
