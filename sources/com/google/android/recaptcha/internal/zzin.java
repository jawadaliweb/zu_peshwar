package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzin {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzjf zzc = zzZ(false);
    private static final zzjf zzd = zzZ(true);
    private static final zzjf zze = new zzjh();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
    }

    public static zzjf zzA() {
        return zze;
    }

    static Object zzB(Object obj, int i, List list, zzgs zzgs, Object obj2, zzjf zzjf) {
        if (zzgs == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (zzgs.zza()) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj2 = zzC(obj, i, intValue, obj2, zzjf);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj2;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzgs.zza()) {
                    obj2 = zzC(obj, i, intValue2, obj2, zzjf);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    static Object zzC(Object obj, int i, int i2, Object obj2, zzjf zzjf) {
        if (obj2 == null) {
            obj2 = zzjf.zzc(obj);
        }
        zzjf.zzl(obj2, i, (long) i2);
        return obj2;
    }

    static void zzD(zzga zzga, Object obj, Object obj2) {
        zzge zzb2 = zzga.zzb(obj2);
        if (!zzb2.zza.isEmpty()) {
            zzga.zzc(obj).zzh(zzb2);
        }
    }

    static void zzE(zzjf zzjf, Object obj, Object obj2) {
        zzjf.zzo(obj, zzjf.zze(zzjf.zzd(obj), zzjf.zzd(obj2)));
    }

    public static void zzF(Class cls) {
        Class cls2;
        if (!zzgo.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzG(int i, List list, zzjx zzjx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjx.zzc(i, list, z);
        }
    }

    public static void zzH(int i, List list, zzjx zzjx) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjx.zze(i, list);
        }
    }

    public static void zzI(int i, List list, zzjx zzjx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjx.zzg(i, list, z);
        }
    }

    public static void zzJ(int i, List list, zzjx zzjx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjx.zzj(i, list, z);
        }
    }

    public static void zzK(int i, List list, zzjx zzjx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjx.zzl(i, list, z);
        }
    }

    public static void zzL(int i, List list, zzjx zzjx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjx.zzn(i, list, z);
        }
    }

    public static void zzM(int i, List list, zzjx zzjx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjx.zzp(i, list, z);
        }
    }

    public static void zzN(int i, List list, zzjx zzjx, zzil zzil) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((zzfl) zzjx).zzq(i, list.get(i2), zzil);
            }
        }
    }

    public static void zzO(int i, List list, zzjx zzjx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjx.zzs(i, list, z);
        }
    }

    public static void zzP(int i, List list, zzjx zzjx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjx.zzu(i, list, z);
        }
    }

    public static void zzQ(int i, List list, zzjx zzjx, zzil zzil) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((zzfl) zzjx).zzv(i, list.get(i2), zzil);
            }
        }
    }

    public static void zzR(int i, List list, zzjx zzjx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjx.zzy(i, list, z);
        }
    }

    public static void zzS(int i, List list, zzjx zzjx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjx.zzA(i, list, z);
        }
    }

    public static void zzT(int i, List list, zzjx zzjx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjx.zzC(i, list, z);
        }
    }

    public static void zzU(int i, List list, zzjx zzjx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjx.zzE(i, list, z);
        }
    }

    public static void zzV(int i, List list, zzjx zzjx) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjx.zzH(i, list);
        }
    }

    public static void zzW(int i, List list, zzjx zzjx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjx.zzJ(i, list, z);
        }
    }

    public static void zzX(int i, List list, zzjx zzjx, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjx.zzL(i, list, z);
        }
    }

    static boolean zzY(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private static zzjf zzZ(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzjf) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    static int zza(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzfk.zzy(i << 3) + 1);
    }

    static int zzb(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = size * zzfk.zzy(i << 3);
        for (int i2 = 0; i2 < list.size(); i2++) {
            int zzd2 = ((zzez) list.get(i2)).zzd();
            zzy += zzfk.zzy(zzd2) + zzd2;
        }
        return zzy;
    }

    static int zzc(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzfk.zzy(i << 3));
    }

    static int zzd(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgp) {
            zzgp zzgp = (zzgp) list;
            i = 0;
            while (i2 < size) {
                i += zzfk.zzu(zzgp.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfk.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zze(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzfk.zzy(i << 3) + 4);
    }

    static int zzf(List list) {
        return list.size() * 4;
    }

    static int zzg(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzfk.zzy(i << 3) + 8);
    }

    static int zzh(List list) {
        return list.size() * 8;
    }

    static int zzi(int i, List list, zzil zzil) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzfk.zzt(i, (zzhy) list.get(i3), zzil);
        }
        return i2;
    }

    static int zzj(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzk(list) + (size * zzfk.zzy(i << 3));
    }

    static int zzk(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgp) {
            zzgp zzgp = (zzgp) list;
            i = 0;
            while (i2 < size) {
                i += zzfk.zzu(zzgp.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfk.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzl(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzm(list) + (list.size() * zzfk.zzy(i << 3));
    }

    static int zzm(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhn) {
            zzhn zzhn = (zzhn) list;
            i = 0;
            while (i2 < size) {
                i += zzfk.zzz(zzhn.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfk.zzz(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzn(int i, Object obj, zzil zzil) {
        if (obj instanceof zzhe) {
            int i2 = zzfk.zzb;
            int zza2 = ((zzhe) obj).zza();
            return zzfk.zzy(i << 3) + zzfk.zzy(zza2) + zza2;
        }
        return zzfk.zzy(i << 3) + zzfk.zzw((zzhy) obj, zzil);
    }

    static int zzo(int i, List list, zzil zzil) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = zzfk.zzy(i << 3) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzhe) {
                int zza2 = ((zzhe) obj).zza();
                zzy += zzfk.zzy(zza2) + zza2;
            } else {
                zzy += zzfk.zzw((zzhy) obj, zzil);
            }
        }
        return zzy;
    }

    static int zzp(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzq(list) + (size * zzfk.zzy(i << 3));
    }

    static int zzq(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgp) {
            zzgp zzgp = (zzgp) list;
            i = 0;
            while (i2 < size) {
                int zze2 = zzgp.zze(i2);
                i += zzfk.zzy((zze2 >> 31) ^ (zze2 + zze2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i3 = i + zzfk.zzy((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    static int zzr(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzs(list) + (size * zzfk.zzy(i << 3));
    }

    static int zzs(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhn) {
            zzhn zzhn = (zzhn) list;
            i = 0;
            while (i2 < size) {
                long zze2 = zzhn.zze(i2);
                i += zzfk.zzz((zze2 >> 63) ^ (zze2 + zze2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i3 = i + zzfk.zzz((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    static int zzt(int i, List list) {
        int zzx;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int i3 = zzfk.zzb;
        boolean z = list instanceof zzhg;
        int zzy = zzfk.zzy(i << 3) * size;
        if (z) {
            zzhg zzhg = (zzhg) list;
            while (i2 < size) {
                Object zzf = zzhg.zzf(i2);
                if (zzf instanceof zzez) {
                    int zzd2 = ((zzez) zzf).zzd();
                    zzy += zzfk.zzy(zzd2) + zzd2;
                } else {
                    zzy += zzfk.zzx((String) zzf);
                }
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzez) {
                    int zzd3 = ((zzez) obj).zzd();
                    zzx = zzy + zzfk.zzy(zzd3) + zzd3;
                } else {
                    zzx = zzy + zzfk.zzx((String) obj);
                }
                i2++;
            }
        }
        return zzy;
    }

    static int zzu(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzfk.zzy(i << 3));
    }

    static int zzv(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgp) {
            zzgp zzgp = (zzgp) list;
            i = 0;
            while (i2 < size) {
                i += zzfk.zzy(zzgp.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfk.zzy(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzw(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzx(list) + (size * zzfk.zzy(i << 3));
    }

    static int zzx(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhn) {
            zzhn zzhn = (zzhn) list;
            i = 0;
            while (i2 < size) {
                i += zzfk.zzz(zzhn.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfk.zzz(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzjf zzy() {
        return zzc;
    }

    public static zzjf zzz() {
        return zzd;
    }
}
