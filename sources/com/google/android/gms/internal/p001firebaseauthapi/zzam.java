package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.core.ServerValues;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzam  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public abstract class zzam extends zzai implements List, RandomAccess {
    private static final zzba zza = new zzak(zzas.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    zzam() {
    }

    static zzam zzg(Object[] objArr, int i) {
        if (i == 0) {
            return zzas.zza;
        }
        return new zzas(objArr, i);
    }

    public static zzam zzh(Collection collection) {
        Object[] array = collection.toArray();
        int length = array.length;
        zzar.zza(array, length);
        return zzg(array, length);
    }

    public static zzam zzi() {
        return zzas.zza;
    }

    public static zzam zzj(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        Object[] objArr = {"firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", ServerValues.NAME_OP_TIMESTAMP};
        zzar.zza(objArr, 8);
        return zzg(objArr, 8);
    }

    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i = 0;
                    while (i < size) {
                        if (zzq.zza(get(i), list.get(i))) {
                            i++;
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it2.hasNext()) {
                            if (!zzq.zza(it.next(), it2.next())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public final int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public final int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    public final zzaz zzd() {
        return listIterator(0);
    }

    /* renamed from: zzf */
    public zzam subList(int i, int i2) {
        zzu.zzc(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return zzas.zza;
        }
        return new zzal(this, i, i3);
    }

    /* renamed from: zzk */
    public final zzba listIterator(int i) {
        zzu.zzb(i, size(), FirebaseAnalytics.Param.INDEX);
        if (isEmpty()) {
            return zza;
        }
        return new zzak(this, i);
    }
}
