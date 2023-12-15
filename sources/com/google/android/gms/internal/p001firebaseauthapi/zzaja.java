package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaja  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzaja extends AbstractList implements RandomAccess, zzagx {
    /* access modifiers changed from: private */
    public final zzagx zza;

    public zzaja(zzagx zzagx) {
        this.zza = zzagx;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzagw) this.zza).get(i);
    }

    public final Iterator iterator() {
        return new zzaiz(this);
    }

    public final ListIterator listIterator(int i) {
        return new zzaiy(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzagx zze() {
        return this;
    }

    public final Object zzf(int i) {
        return this.zza.zzf(i);
    }

    public final List zzh() {
        return this.zza.zzh();
    }

    public final void zzi(zzaff zzaff) {
        throw new UnsupportedOperationException();
    }
}
