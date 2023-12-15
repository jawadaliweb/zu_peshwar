package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzahj extends LinkedHashMap {
    private static final zzahj zza;
    private boolean zzb = true;

    static {
        zzahj zzahj = new zzahj();
        zza = zzahj;
        zzahj.zzb = false;
    }

    private zzahj() {
    }

    public static zzahj zza() {
        return zza;
    }

    private static int zzf(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = zzagq.zzd;
            int length = bArr.length;
            int zzb2 = zzagq.zzb(length, bArr, 0, length);
            if (zzb2 == 0) {
                return 1;
            }
            return zzb2;
        } else if (!(obj instanceof zzagm)) {
            return obj.hashCode();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private final void zzg() {
        if (!this.zzb) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        zzg();
        super.clear();
    }

    public final Set entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        for (Map.Entry entry : entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(value instanceof byte[]) || !(obj2 instanceof byte[])) {
                z = value.equals(obj2);
                continue;
            } else {
                z = Arrays.equals((byte[]) value, (byte[]) obj2);
                continue;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        for (Map.Entry entry : entrySet()) {
            i += zzf(entry.getValue()) ^ zzf(entry.getKey());
        }
        return i;
    }

    public final Object put(Object obj, Object obj2) {
        zzg();
        byte[] bArr = zzagq.zzd;
        Objects.requireNonNull(obj);
        Objects.requireNonNull(obj2);
        return super.put(obj, obj2);
    }

    public final void putAll(Map map) {
        zzg();
        for (Object next : map.keySet()) {
            byte[] bArr = zzagq.zzd;
            Objects.requireNonNull(next);
            Objects.requireNonNull(map.get(next));
        }
        super.putAll(map);
    }

    public final Object remove(Object obj) {
        zzg();
        return super.remove(obj);
    }

    public final zzahj zzb() {
        return isEmpty() ? new zzahj() : new zzahj(this);
    }

    public final void zzc() {
        this.zzb = false;
    }

    public final void zzd(zzahj zzahj) {
        zzg();
        if (!zzahj.isEmpty()) {
            putAll(zzahj);
        }
    }

    public final boolean zze() {
        return this.zzb;
    }

    private zzahj(Map map) {
        super(map);
    }
}
