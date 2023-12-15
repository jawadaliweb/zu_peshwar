package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
abstract class zzd implements Iterator {
    @CheckForNull
    private Object zza;
    private int zzb = 2;

    protected zzd() {
    }

    public final Object next() {
        if (hasNext()) {
            this.zzb = 2;
            Object obj = this.zza;
            this.zza = null;
            return obj;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public abstract Object zza();

    /* access modifiers changed from: protected */
    @CheckForNull
    public final Object zzb() {
        this.zzb = 3;
        return null;
    }

    public final boolean hasNext() {
        int i = this.zzb;
        if (i != 4) {
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            } else if (i2 == 0) {
                return true;
            } else {
                if (i2 != 2) {
                    this.zzb = 4;
                    this.zza = zza();
                    if (this.zzb != 3) {
                        this.zzb = 1;
                        return true;
                    }
                }
                return false;
            }
        } else {
            throw new IllegalStateException();
        }
    }
}
