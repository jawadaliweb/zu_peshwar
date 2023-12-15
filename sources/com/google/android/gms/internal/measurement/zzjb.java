package com.google.android.gms.internal.measurement;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.2 */
public abstract class zzjb extends zziw implements Set {
    @CheckForNull
    private transient zzja zza;

    zzjb() {
    }

    static int zzf(int i) {
        int max = Math.max(i, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
            } while (((double) highestOneBit) * 0.7d < ((double) max));
            return highestOneBit;
        } else if (max < 1073741824) {
            return BasicMeasure.EXACTLY;
        } else {
            throw new IllegalArgumentException("collection too large");
        }
    }

    @SafeVarargs
    public static zzjb zzi(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Object[] objArr2 = new Object[15];
        objArr2[0] = "_in";
        objArr2[1] = "_xa";
        objArr2[2] = "_xu";
        objArr2[3] = "_aq";
        objArr2[4] = "_aa";
        objArr2[5] = "_ai";
        System.arraycopy(objArr, 0, objArr2, 6, 9);
        return zzk(15, objArr2);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzjb) && zzj() && ((zzjb) obj).zzj() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() != set.size() || !containsAll(set)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i += next != null ? next.hashCode() : 0;
        }
        return i;
    }

    /* renamed from: zzd */
    public abstract zzjh iterator();

    public final zzja zzg() {
        zzja zzja = this.zza;
        if (zzja != null) {
            return zzja;
        }
        zzja zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    /* access modifiers changed from: package-private */
    public zzja zzh() {
        Object[] array = toArray();
        int i = zzja.zzd;
        return zzja.zzg(array, array.length);
    }

    /* access modifiers changed from: package-private */
    public boolean zzj() {
        return false;
    }

    private static zzjb zzk(int i, Object... objArr) {
        if (i == 0) {
            return zzjf.zza;
        }
        if (i != 1) {
            int zzf = zzf(i);
            Object[] objArr2 = new Object[zzf];
            int i2 = zzf - 1;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                Object obj = objArr[i5];
                zzjd.zza(obj, i5);
                int hashCode = obj.hashCode();
                int zza2 = zzit.zza(hashCode);
                while (true) {
                    int i6 = zza2 & i2;
                    Object obj2 = objArr2[i6];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        zza2++;
                    } else {
                        objArr[i4] = obj;
                        objArr2[i6] = obj;
                        i3 += hashCode;
                        i4++;
                        break;
                    }
                }
            }
            Arrays.fill(objArr, i4, i, (Object) null);
            if (i4 == 1) {
                Object obj3 = objArr[0];
                obj3.getClass();
                return new zzjg(obj3);
            }
            if (zzf(i4) < zzf / 2) {
                return zzk(i4, objArr);
            }
            if (i4 < 10) {
                objArr = Arrays.copyOf(objArr, i4);
            }
            return new zzjf(objArr, i3, objArr2, i2, i4);
        }
        Object obj4 = objArr[0];
        obj4.getClass();
        return new zzjg(obj4);
    }
}
