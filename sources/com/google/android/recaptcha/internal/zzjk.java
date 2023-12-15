package com.google.android.recaptcha.internal;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzjk extends AbstractList implements RandomAccess, zzhg {
    /* access modifiers changed from: private */
    public final zzhg zza;

    public zzjk(zzhg zzhg) {
        this.zza = zzhg;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzhf) this.zza).get(i);
    }

    public final Iterator iterator() {
        return new zzjj(this);
    }

    public final ListIterator listIterator(int i) {
        return new zzji(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzhg zze() {
        return this;
    }

    public final Object zzf(int i) {
        return this.zza.zzf(i);
    }

    public final List zzh() {
        return this.zza.zzh();
    }

    public final void zzi(zzez zzez) {
        throw new UnsupportedOperationException();
    }
}
