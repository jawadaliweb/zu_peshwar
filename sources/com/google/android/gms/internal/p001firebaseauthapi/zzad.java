package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzad  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
abstract class zzad extends zzba {
    private final int zza;
    private int zzb;

    protected zzad(int i, int i2) {
        zzu.zzb(i2, i, FirebaseAnalytics.Param.INDEX);
        this.zza = i;
        this.zzb = i2;
    }

    public final boolean hasNext() {
        return this.zzb < this.zza;
    }

    public final boolean hasPrevious() {
        return this.zzb > 0;
    }

    public final Object next() {
        if (hasNext()) {
            int i = this.zzb;
            this.zzb = i + 1;
            return zza(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.zzb;
    }

    public final Object previous() {
        if (hasPrevious()) {
            int i = this.zzb - 1;
            this.zzb = i;
            return zza(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.zzb - 1;
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i);
}
