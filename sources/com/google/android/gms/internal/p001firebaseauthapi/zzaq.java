package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Set;
import javax.annotation.CheckForNull;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public abstract class zzaq extends zzai implements Set {
    @CheckForNull
    private transient zzam zza;

    zzaq() {
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() != set.size() || !containsAll(set)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public final int hashCode() {
        return zzay.zza(this);
    }

    /* renamed from: zzd */
    public abstract zzaz iterator();

    public final zzam zzf() {
        zzam zzam = this.zza;
        if (zzam != null) {
            return zzam;
        }
        zzam zzg = zzg();
        this.zza = zzg;
        return zzg;
    }

    /* access modifiers changed from: package-private */
    public zzam zzg() {
        Object[] array = toArray();
        int i = zzam.zzd;
        return zzam.zzg(array, array.length);
    }
}
