package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
final class zzfl implements zzjx {
    private final zzfk zza;

    private zzfl(zzfk zzfk) {
        byte[] bArr = zzgw.zzd;
        this.zza = zzfk;
        zzfk.zza = this;
    }

    public static zzfl zza(zzfk zzfk) {
        zzfl zzfl = zzfk.zza;
        return zzfl != null ? zzfl : new zzfl(zzfk);
    }

    public final void zzB(int i, int i2) throws IOException {
        this.zza.zzp(i, (i2 >> 31) ^ (i2 + i2));
    }

    public final void zzD(int i, long j) throws IOException {
        this.zza.zzr(i, (j >> 63) ^ (j + j));
    }

    @Deprecated
    public final void zzF(int i) throws IOException {
        this.zza.zzo(i, 3);
    }

    public final void zzG(int i, String str) throws IOException {
        this.zza.zzm(i, str);
    }

    public final void zzH(int i, List list) throws IOException {
        int i2 = 0;
        if (list instanceof zzhg) {
            zzhg zzhg = (zzhg) list;
            while (i2 < list.size()) {
                Object zzf = zzhg.zzf(i2);
                if (zzf instanceof String) {
                    this.zza.zzm(i, (String) zzf);
                } else {
                    this.zza.zze(i, (zzez) zzf);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzm(i, (String) list.get(i2));
            i2++;
        }
    }

    public final void zzI(int i, int i2) throws IOException {
        this.zza.zzp(i, i2);
    }

    public final void zzK(int i, long j) throws IOException {
        this.zza.zzr(i, j);
    }

    public final void zzb(int i, boolean z) throws IOException {
        this.zza.zzd(i, z);
    }

    public final void zzd(int i, zzez zzez) throws IOException {
        this.zza.zze(i, zzez);
    }

    public final void zze(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zze(i, (zzez) list.get(i2));
        }
    }

    public final void zzf(int i, double d) throws IOException {
        this.zza.zzh(i, Double.doubleToRawLongBits(d));
    }

    @Deprecated
    public final void zzh(int i) throws IOException {
        this.zza.zzo(i, 4);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    public final void zzm(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zzo(int i, float f) throws IOException {
        this.zza.zzf(i, Float.floatToRawIntBits(f));
    }

    public final void zzq(int i, Object obj, zzil zzil) throws IOException {
        zzfk zzfk = this.zza;
        zzfk.zzo(i, 3);
        zzil.zzj((zzhy) obj, zzfk.zza);
        zzfk.zzo(i, 4);
    }

    public final void zzr(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    public final void zzt(int i, long j) throws IOException {
        this.zza.zzr(i, j);
    }

    public final void zzv(int i, Object obj, zzil zzil) throws IOException {
        zzhy zzhy = (zzhy) obj;
        zzfh zzfh = (zzfh) this.zza;
        zzfh.zzq((i << 3) | 2);
        zzfh.zzq(((zzei) zzhy).zza(zzil));
        zzil.zzj(zzhy, zzfh.zza);
    }

    public final void zzw(int i, Object obj) throws IOException {
        if (obj instanceof zzez) {
            zzfh zzfh = (zzfh) this.zza;
            zzfh.zzq(11);
            zzfh.zzp(2, i);
            zzfh.zze(3, (zzez) obj);
            zzfh.zzq(12);
            return;
        }
        zzfk zzfk = this.zza;
        zzhy zzhy = (zzhy) obj;
        zzfh zzfh2 = (zzfh) zzfk;
        zzfh2.zzq(11);
        zzfh2.zzp(2, i);
        zzfh2.zzq(26);
        zzfh2.zzq(zzhy.zzn());
        zzhy.zze(zzfk);
        zzfh2.zzq(12);
    }

    public final void zzx(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    public final void zzz(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzi(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzh(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                int intValue = ((Integer) list.get(i4)).intValue();
                i3 += zzfk.zzy((intValue >> 31) ^ (intValue + intValue));
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                zzfk zzfk = this.zza;
                int intValue2 = ((Integer) list.get(i2)).intValue();
                zzfk.zzq((intValue2 >> 31) ^ (intValue2 + intValue2));
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            zzfk zzfk2 = this.zza;
            int intValue3 = ((Integer) list.get(i2)).intValue();
            zzfk2.zzp(i, (intValue3 >> 31) ^ (intValue3 + intValue3));
            i2++;
        }
    }

    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                long longValue = ((Long) list.get(i4)).longValue();
                i3 += zzfk.zzz((longValue >> 63) ^ (longValue + longValue));
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                zzfk zzfk = this.zza;
                long longValue2 = ((Long) list.get(i2)).longValue();
                zzfk.zzs((longValue2 >> 63) ^ (longValue2 + longValue2));
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            zzfk zzfk2 = this.zza;
            long longValue3 = ((Long) list.get(i2)).longValue();
            zzfk2.zzr(i, (longValue3 >> 63) ^ (longValue3 + longValue3));
            i2++;
        }
    }

    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfk.zzy(((Integer) list.get(i4)).intValue());
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzq(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzp(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfk.zzz(((Long) list.get(i4)).longValue());
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzs(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzr(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).booleanValue();
                i3++;
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzb(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : 0);
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzd(i, ((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    public final void zzj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfk.zzu(((Integer) list.get(i4)).intValue());
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzg(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzf(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzi(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzh(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfk.zzu(((Integer) list.get(i4)).intValue());
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfk.zzz(((Long) list.get(i4)).longValue());
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzs(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzr(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzg(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzf(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).doubleValue();
                i3 += 8;
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzh(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    public final void zzp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).floatValue();
                i3 += 4;
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzf(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }
}
