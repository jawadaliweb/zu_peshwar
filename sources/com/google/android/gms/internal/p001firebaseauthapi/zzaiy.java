package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.ListIterator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaiy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaiy implements ListIterator {
    final ListIterator zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzaja zzc;

    zzaiy(zzaja zzaja, int i) {
        this.zzc = zzaja;
        this.zzb = i;
        this.zza = zzaja.zza.listIterator(i);
    }

    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zza.hasPrevious();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final int nextIndex() {
        return this.zza.nextIndex();
    }

    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.zza.previous();
    }

    public final int previousIndex() {
        return this.zza.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }
}
