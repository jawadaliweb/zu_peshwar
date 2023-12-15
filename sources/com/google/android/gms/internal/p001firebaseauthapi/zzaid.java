package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaid  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzaid {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzaiv zzc;
    private static final zzaiv zzd = new zzaix();

    static {
        Class<?> cls;
        Class<?> cls2;
        zzaiv zzaiv = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzaiv = (zzaiv) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzaiv;
    }

    static Object zzA(Object obj, int i, List list, zzago zzago, Object obj2, zzaiv zzaiv) {
        if (zzago == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (zzago.zza()) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj2 = zzB(obj, i, intValue, obj2, zzaiv);
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
                if (!zzago.zza()) {
                    obj2 = zzB(obj, i, intValue2, obj2, zzaiv);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    static Object zzB(Object obj, int i, int i2, Object obj2, zzaiv zzaiv) {
        if (obj2 == null) {
            obj2 = zzaiv.zzc(obj);
        }
        zzaiv.zzl(obj2, i, (long) i2);
        return obj2;
    }

    static void zzC(zzaiv zzaiv, Object obj, Object obj2) {
        zzaiv.zzo(obj, zzaiv.zze(zzaiv.zzd(obj), zzaiv.zzd(obj2)));
    }

    public static void zzD(Class cls) {
        Class cls2;
        if (!zzagk.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean zzE(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void zzF(int i, List list, zzaft zzaft, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaft.zzc(i, list, z);
        }
    }

    public static void zzG(int i, List list, zzaft zzaft) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaft.zze(i, list);
        }
    }

    public static void zzH(int i, List list, zzaft zzaft, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaft.zzg(i, list, z);
        }
    }

    public static void zzI(int i, List list, zzaft zzaft, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaft.zzj(i, list, z);
        }
    }

    public static void zzJ(int i, List list, zzaft zzaft, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaft.zzl(i, list, z);
        }
    }

    public static void zzK(int i, List list, zzaft zzaft, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaft.zzn(i, list, z);
        }
    }

    public static void zzL(int i, List list, zzaft zzaft, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaft.zzp(i, list, z);
        }
    }

    public static void zzM(int i, List list, zzaft zzaft, zzaib zzaib) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzaft.zzq(i, list.get(i2), zzaib);
            }
        }
    }

    public static void zzN(int i, List list, zzaft zzaft, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaft.zzs(i, list, z);
        }
    }

    public static void zzO(int i, List list, zzaft zzaft, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaft.zzu(i, list, z);
        }
    }

    public static void zzP(int i, List list, zzaft zzaft, zzaib zzaib) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzaft.zzv(i, list.get(i2), zzaib);
            }
        }
    }

    public static void zzQ(int i, List list, zzaft zzaft, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaft.zzx(i, list, z);
        }
    }

    public static void zzR(int i, List list, zzaft zzaft, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaft.zzz(i, list, z);
        }
    }

    public static void zzS(int i, List list, zzaft zzaft, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaft.zzB(i, list, z);
        }
    }

    public static void zzT(int i, List list, zzaft zzaft, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaft.zzD(i, list, z);
        }
    }

    public static void zzU(int i, List list, zzaft zzaft) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaft.zzG(i, list);
        }
    }

    public static void zzV(int i, List list, zzaft zzaft, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaft.zzI(i, list, z);
        }
    }

    public static void zzW(int i, List list, zzaft zzaft, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaft.zzK(i, list, z);
        }
    }

    static int zza(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzafs.zzA(i << 3) + 1);
    }

    static int zzb(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzA = size * zzafs.zzA(i << 3);
        for (int i2 = 0; i2 < list.size(); i2++) {
            int zzd2 = ((zzaff) list.get(i2)).zzd();
            zzA += zzafs.zzA(zzd2) + zzd2;
        }
        return zzA;
    }

    static int zzc(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzafs.zzA(i << 3));
    }

    static int zzd(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzagl) {
            zzagl zzagl = (zzagl) list;
            i = 0;
            while (i2 < size) {
                i += zzafs.zzx(zzagl.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzafs.zzx(((Integer) list.get(i2)).intValue());
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
        return size * (zzafs.zzA(i << 3) + 4);
    }

    static int zzf(List list) {
        return list.size() * 4;
    }

    static int zzg(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzafs.zzA(i << 3) + 8);
    }

    static int zzh(List list) {
        return list.size() * 8;
    }

    static int zzi(int i, List list, zzaib zzaib) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzafs.zzw(i, (zzahp) list.get(i3), zzaib);
        }
        return i2;
    }

    static int zzj(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzk(list) + (size * zzafs.zzA(i << 3));
    }

    static int zzk(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzagl) {
            zzagl zzagl = (zzagl) list;
            i = 0;
            while (i2 < size) {
                i += zzafs.zzx(zzagl.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzafs.zzx(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzl(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzm(list) + (list.size() * zzafs.zzA(i << 3));
    }

    static int zzm(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzahe) {
            zzahe zzahe = (zzahe) list;
            i = 0;
            while (i2 < size) {
                i += zzafs.zzB(zzahe.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzafs.zzB(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzn(int i, Object obj, zzaib zzaib) {
        if (obj instanceof zzagv) {
            int i2 = zzafs.zzf;
            int zza2 = ((zzagv) obj).zza();
            return zzafs.zzA(i << 3) + zzafs.zzA(zza2) + zza2;
        }
        return zzafs.zzA(i << 3) + zzafs.zzy((zzahp) obj, zzaib);
    }

    static int zzo(int i, List list, zzaib zzaib) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzA = zzafs.zzA(i << 3) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzagv) {
                int zza2 = ((zzagv) obj).zza();
                zzA += zzafs.zzA(zza2) + zza2;
            } else {
                zzA += zzafs.zzy((zzahp) obj, zzaib);
            }
        }
        return zzA;
    }

    static int zzp(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzq(list) + (size * zzafs.zzA(i << 3));
    }

    static int zzq(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzagl) {
            zzagl zzagl = (zzagl) list;
            i = 0;
            while (i2 < size) {
                int zze = zzagl.zze(i2);
                i += zzafs.zzA((zze >> 31) ^ (zze + zze));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i3 = i + zzafs.zzA((intValue >> 31) ^ (intValue + intValue));
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
        return zzs(list) + (size * zzafs.zzA(i << 3));
    }

    static int zzs(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzahe) {
            zzahe zzahe = (zzahe) list;
            i = 0;
            while (i2 < size) {
                long zze = zzahe.zze(i2);
                i += zzafs.zzB((zze >> 63) ^ (zze + zze));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i3 = i + zzafs.zzB((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    static int zzt(int i, List list) {
        int zzz;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        boolean z = list instanceof zzagx;
        int zzA = zzafs.zzA(i << 3) * size;
        if (z) {
            zzagx zzagx = (zzagx) list;
            while (i2 < size) {
                Object zzf = zzagx.zzf(i2);
                if (zzf instanceof zzaff) {
                    int zzd2 = ((zzaff) zzf).zzd();
                    zzA += zzafs.zzA(zzd2) + zzd2;
                } else {
                    zzA += zzafs.zzz((String) zzf);
                }
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzaff) {
                    int zzd3 = ((zzaff) obj).zzd();
                    zzz = zzA + zzafs.zzA(zzd3) + zzd3;
                } else {
                    zzz = zzA + zzafs.zzz((String) obj);
                }
                i2++;
            }
        }
        return zzA;
    }

    static int zzu(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzafs.zzA(i << 3));
    }

    static int zzv(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzagl) {
            zzagl zzagl = (zzagl) list;
            i = 0;
            while (i2 < size) {
                i += zzafs.zzA(zzagl.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzafs.zzA(((Integer) list.get(i2)).intValue());
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
        return zzx(list) + (size * zzafs.zzA(i << 3));
    }

    static int zzx(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzahe) {
            zzahe zzahe = (zzahe) list;
            i = 0;
            while (i2 < size) {
                i += zzafs.zzB(zzahe.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzafs.zzB(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzaiv zzy() {
        return zzc;
    }

    public static zzaiv zzz() {
        return zzd;
    }
}
