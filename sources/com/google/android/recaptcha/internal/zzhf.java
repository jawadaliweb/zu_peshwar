package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzhf extends zzek implements RandomAccess, zzhg {
    @Deprecated
    public static final zzhg zza;
    private static final zzhf zzb;
    private final List zzc;

    static {
        zzhf zzhf = new zzhf(false);
        zzb = zzhf;
        zza = zzhf;
    }

    public zzhf() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzez) {
            return ((zzez) obj).zzn(zzgw.zzb);
        }
        return zzgw.zzd((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zza();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i, Collection collection) {
        zza();
        if (collection instanceof zzhg) {
            collection = ((zzhg) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zza();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zzj(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zza();
        return zzj(this.zzc.set(i, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* bridge */ /* synthetic */ zzgv zzd(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzc);
            return new zzhf(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final zzhg zze() {
        return zzc() ? new zzjk(this) : this;
    }

    public final Object zzf(int i) {
        return this.zzc.get(i);
    }

    /* renamed from: zzg */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzez) {
            zzez zzez = (zzez) obj;
            String zzn = zzez.zzn(zzgw.zzb);
            if (zzez.zzj()) {
                this.zzc.set(i, zzn);
            }
            return zzn;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzgw.zzd(bArr);
        if (zzju.zze(bArr)) {
            this.zzc.set(i, zzd);
        }
        return zzd;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final void zzi(zzez zzez) {
        zza();
        this.zzc.add(zzez);
        this.modCount++;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzhf(int i) {
        super(true);
        ArrayList arrayList = new ArrayList(i);
        this.zzc = arrayList;
    }

    private zzhf(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzhf(boolean z) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
