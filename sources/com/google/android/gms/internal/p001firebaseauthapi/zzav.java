package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzav  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzav extends zzaq {
    private final transient zzap zza;
    private final transient zzam zzb;

    zzav(zzap zzap, zzam zzam) {
        this.zza = zzap;
        this.zzb = zzam;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }

    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    public final int size() {
        return this.zza.size();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, 0);
    }

    public final zzaz zzd() {
        return this.zzb.listIterator(0);
    }
}
