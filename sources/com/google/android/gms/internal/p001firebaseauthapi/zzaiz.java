package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaiz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaiz implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzaja zzb;

    zzaiz(zzaja zzaja) {
        this.zzb = zzaja;
        this.zza = zzaja.zza.iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
