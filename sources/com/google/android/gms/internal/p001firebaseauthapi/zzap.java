package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzap  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public abstract class zzap implements Map, Serializable {
    @CheckForNull
    private transient zzaq zza;
    @CheckForNull
    private transient zzaq zzb;
    @CheckForNull
    private transient zzai zzc;

    zzap() {
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.p001firebaseauthapi.zzap zzc(java.lang.Iterable r2) {
        /*
            boolean r0 = r2 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0009
            int r0 = r2.size()
            goto L_0x000a
        L_0x0009:
            r0 = 4
        L_0x000a:
            com.google.android.gms.internal.firebase-auth-api.zzao r1 = new com.google.android.gms.internal.firebase-auth-api.zzao
            r1.<init>(r0)
            r1.zza(r2)
            com.google.android.gms.internal.firebase-auth-api.zzan r2 = r1.zzc
            if (r2 != 0) goto L_0x0028
            int r2 = r1.zzb
            java.lang.Object[] r0 = r1.zza
            com.google.android.gms.internal.firebase-auth-api.zzax r2 = com.google.android.gms.internal.p001firebaseauthapi.zzax.zzg(r2, r0, r1)
            com.google.android.gms.internal.firebase-auth-api.zzan r0 = r1.zzc
            if (r0 != 0) goto L_0x0023
            return r2
        L_0x0023:
            java.lang.IllegalArgumentException r2 = r0.zza()
            throw r2
        L_0x0028:
            java.lang.IllegalArgumentException r2 = r2.zza()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzap.zzc(java.lang.Iterable):com.google.android.gms.internal.firebase-auth-api.zzap");
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return entrySet().equals(((Map) obj).entrySet());
    }

    @CheckForNull
    public abstract Object get(@CheckForNull Object obj);

    @CheckForNull
    public final Object getOrDefault(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public final int hashCode() {
        return zzay.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        zzaq zzaq = this.zzb;
        if (zzaq != null) {
            return zzaq;
        }
        zzaq zze = zze();
        this.zzb = zze;
        return zze;
    }

    @CheckForNull
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    @Deprecated
    public final Object remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824));
            sb.append('{');
            boolean z = true;
            for (Map.Entry entry : entrySet()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
                z = false;
            }
            sb.append('}');
            return sb.toString();
        }
        throw new IllegalArgumentException("size cannot be negative but was: " + size);
    }

    /* access modifiers changed from: package-private */
    public abstract zzai zza();

    /* renamed from: zzb */
    public final zzai values() {
        zzai zzai = this.zzc;
        if (zzai != null) {
            return zzai;
        }
        zzai zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public abstract zzaq zzd();

    /* access modifiers changed from: package-private */
    public abstract zzaq zze();

    /* renamed from: zzf */
    public final zzaq entrySet() {
        zzaq zzaq = this.zza;
        if (zzaq != null) {
            return zzaq;
        }
        zzaq zzd = zzd();
        this.zza = zzd;
        return zzd;
    }
}
