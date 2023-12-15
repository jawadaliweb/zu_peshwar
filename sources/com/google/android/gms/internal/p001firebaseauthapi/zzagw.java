package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzagw extends zzaeq implements RandomAccess, zzagx {
    @Deprecated
    public static final zzagx zza;
    private static final zzagw zzb;
    private final List zzc;

    static {
        zzagw zzagw = new zzagw(false);
        zzb = zzagw;
        zza = zzagw;
    }

    public zzagw() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzaff) {
            return ((zzaff) obj).zzo(zzagq.zzb);
        }
        return zzagq.zzd((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zza();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i, Collection collection) {
        zza();
        if (collection instanceof zzagx) {
            collection = ((zzagx) collection).zzh();
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

    public final /* bridge */ /* synthetic */ zzagp zzd(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzc);
            return new zzagw(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final zzagx zze() {
        return zzc() ? new zzaja(this) : this;
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
        if (obj instanceof zzaff) {
            zzaff zzaff = (zzaff) obj;
            String zzo = zzaff.zzo(zzagq.zzb);
            if (zzaff.zzk()) {
                this.zzc.set(i, zzo);
            }
            return zzo;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzagq.zzd(bArr);
        if (zzajk.zze(bArr)) {
            this.zzc.set(i, zzd);
        }
        return zzd;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final void zzi(zzaff zzaff) {
        zza();
        this.zzc.add(zzaff);
        this.modCount++;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzagw(int i) {
        super(true);
        ArrayList arrayList = new ArrayList(i);
        this.zzc = arrayList;
    }

    private zzagw(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzagw(boolean z) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
