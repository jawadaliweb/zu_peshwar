package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzoc {
    @Nullable
    private ArrayList zza = new ArrayList();
    private zznz zzb = zznz.zza;
    @Nullable
    private Integer zzc = null;

    public final zzoc zza(zzbt zzbt, int i, String str, String str2) {
        ArrayList arrayList = this.zza;
        if (arrayList != null) {
            arrayList.add(new zzoe(zzbt, i, str, str2, (zzod) null));
            return this;
        }
        throw new IllegalStateException("addEntry cannot be called after build()");
    }

    public final zzoc zzb(zznz zznz) {
        if (this.zza != null) {
            this.zzb = zznz;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build()");
    }

    public final zzoc zzc(int i) {
        if (this.zza != null) {
            this.zzc = Integer.valueOf(i);
            return this;
        }
        throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
    }

    public final zzog zzd() throws GeneralSecurityException {
        if (this.zza != null) {
            Integer num = this.zzc;
            if (num != null) {
                int intValue = num.intValue();
                ArrayList arrayList = this.zza;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    int zza2 = ((zzoe) arrayList.get(i)).zza();
                    i++;
                    if (zza2 == intValue) {
                    }
                }
                throw new GeneralSecurityException("primary key ID is not present in entries");
            }
            zzog zzog = new zzog(this.zzb, Collections.unmodifiableList(this.zza), this.zzc, (zzof) null);
            this.zza = null;
            return zzog;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
