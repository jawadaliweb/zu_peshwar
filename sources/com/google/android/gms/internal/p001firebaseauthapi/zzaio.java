package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaio  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
class zzaio extends AbstractMap {
    private final int zza;
    /* access modifiers changed from: private */
    public List zzb = Collections.emptyList();
    /* access modifiers changed from: private */
    public Map zzc = Collections.emptyMap();
    private boolean zzd;
    private volatile zzaim zze;
    private Map zzf = Collections.emptyMap();

    /* synthetic */ zzaio(int i, zzain zzain) {
        this.zza = i;
    }

    private final int zzk(Comparable comparable) {
        int size = this.zzb.size() - 1;
        int i = 0;
        if (size >= 0) {
            int compareTo = comparable.compareTo(((zzaii) this.zzb.get(size)).zza());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = comparable.compareTo(((zzaii) this.zzb.get(i2)).zza());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    /* access modifiers changed from: private */
    public final Object zzl(int i) {
        zzn();
        Object value = ((zzaii) this.zzb.remove(i)).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator it = zzm().entrySet().iterator();
            List list = this.zzb;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new zzaii(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return value;
    }

    private final SortedMap zzm() {
        zzn();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    /* access modifiers changed from: private */
    public final void zzn() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        zzn();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (!this.zzc.isEmpty()) {
            this.zzc.clear();
        }
    }

    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zzk(comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    public final Set entrySet() {
        if (this.zze == null) {
            this.zze = new zzaim(this, (zzail) null);
        }
        return this.zze;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaio)) {
            return super.equals(obj);
        }
        zzaio zzaio = (zzaio) obj;
        int size = size();
        if (size != zzaio.size()) {
            return false;
        }
        int zzb2 = zzb();
        if (zzb2 != zzaio.zzb()) {
            return entrySet().equals(zzaio.entrySet());
        }
        for (int i = 0; i < zzb2; i++) {
            if (!zzg(i).equals(zzaio.zzg(i))) {
                return false;
            }
        }
        if (zzb2 != size) {
            return this.zzc.equals(zzaio.zzc);
        }
        return true;
    }

    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return ((zzaii) this.zzb.get(zzk)).getValue();
        }
        return this.zzc.get(comparable);
    }

    public final int hashCode() {
        int zzb2 = zzb();
        int i = 0;
        for (int i2 = 0; i2 < zzb2; i2++) {
            i += ((zzaii) this.zzb.get(i2)).hashCode();
        }
        return this.zzc.size() > 0 ? i + this.zzc.hashCode() : i;
    }

    public final Object remove(Object obj) {
        zzn();
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return zzl(zzk);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    public final int size() {
        return this.zzb.size() + this.zzc.size();
    }

    public void zza() {
        Map map;
        Map map2;
        if (!this.zzd) {
            if (this.zzc.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzc);
            }
            this.zzc = map;
            if (this.zzf.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzf);
            }
            this.zzf = map2;
            this.zzd = true;
        }
    }

    public final int zzb() {
        return this.zzb.size();
    }

    public final Iterable zzc() {
        if (this.zzc.isEmpty()) {
            return zzaih.zza();
        }
        return this.zzc.entrySet();
    }

    /* renamed from: zze */
    public final Object put(Comparable comparable, Object obj) {
        zzn();
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return ((zzaii) this.zzb.get(zzk)).setValue(obj);
        }
        zzn();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i = -(zzk + 1);
        if (i >= this.zza) {
            return zzm().put(comparable, obj);
        }
        int size = this.zzb.size();
        int i2 = this.zza;
        if (size == i2) {
            zzaii zzaii = (zzaii) this.zzb.remove(i2 - 1);
            zzm().put(zzaii.zza(), zzaii.getValue());
        }
        this.zzb.add(i, new zzaii(this, comparable, obj));
        return null;
    }

    public final Map.Entry zzg(int i) {
        return (Map.Entry) this.zzb.get(i);
    }

    public final boolean zzj() {
        return this.zzd;
    }
}
