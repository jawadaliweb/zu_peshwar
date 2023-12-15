package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzog  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzog {
    private final zznz zza;
    private final List zzb;
    @Nullable
    private final Integer zzc;

    /* synthetic */ zzog(zznz zznz, List list, Integer num, zzof zzof) {
        this.zza = zznz;
        this.zzb = list;
        this.zzc = num;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzog)) {
            return false;
        }
        zzog zzog = (zzog) obj;
        if (this.zza.equals(zzog.zza) && this.zzb.equals(zzog.zzb)) {
            Integer num = this.zzc;
            Integer num2 = zzog.zzc;
            if (num == num2) {
                return true;
            }
            if (num == null || !num.equals(num2)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", new Object[]{this.zza, this.zzb, this.zzc});
    }
}
