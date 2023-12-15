package com.google.android.recaptcha.internal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.time.DurationKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class zzka {
    public static final zzjd zza;
    public static final zzjd zzb;
    public static final zzjd zzc;
    private static final ThreadLocal zzd = new zzjz();

    static {
        zzjc zzi = zzjd.zzi();
        zzi.zze(-62135596800L);
        zzi.zzd(0);
        zza = (zzjd) zzi.zzj();
        zzjc zzi2 = zzjd.zzi();
        zzi2.zze(253402300799L);
        zzi2.zzd(999999999);
        zzb = (zzjd) zzi2.zzj();
        zzjc zzi3 = zzjd.zzi();
        zzi3.zze(0);
        zzi3.zzd(0);
        zzc = (zzjd) zzi3.zzj();
    }

    public static zzjd zza(zzjd zzjd) {
        long zzg = zzjd.zzg();
        int i = (zzg > -62135596800L ? 1 : (zzg == -62135596800L ? 0 : -1));
        int zzf = zzjd.zzf();
        if (i >= 0 && zzg <= 253402300799L && zzf >= 0 && zzf < 1000000000) {
            return zzjd;
        }
        throw new IllegalArgumentException(String.format("Timestamp is not valid. See proto definition for valid values. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. Nanos (%s) must be in range [0, +999,999,999].", new Object[]{Long.valueOf(zzg), Integer.valueOf(zzf)}));
    }

    public static zzjd zzb(long j) {
        int i = (int) ((j % 1000) * 1000000);
        long j2 = j / 1000;
        if (i <= -1000000000 || i >= 1000000000) {
            j2 = zzee.zza(j2, (long) (i / 1000000000));
            i %= 1000000000;
        }
        if (i < 0) {
            i += 1000000000;
            j2 = zzee.zzb(j2, 1);
        }
        zzjc zzi = zzjd.zzi();
        zzi.zze(j2);
        zzi.zzd(i);
        zzjd zzjd = (zzjd) zzi.zzj();
        zza(zzjd);
        return zzjd;
    }

    public static String zzc(zzjd zzjd) {
        String str;
        zza(zzjd);
        long zzg = zzjd.zzg();
        int zzf = zzjd.zzf();
        StringBuilder sb = new StringBuilder();
        sb.append(((SimpleDateFormat) zzd.get()).format(new Date(zzg * 1000)));
        if (zzf != 0) {
            sb.append(".");
            if (zzf % DurationKt.NANOS_IN_MILLIS == 0) {
                str = String.format(Locale.ENGLISH, "%1$03d", new Object[]{Integer.valueOf(zzf / DurationKt.NANOS_IN_MILLIS)});
            } else if (zzf % 1000 == 0) {
                str = String.format(Locale.ENGLISH, "%1$06d", new Object[]{Integer.valueOf(zzf / 1000)});
            } else {
                str = String.format(Locale.ENGLISH, "%1$09d", new Object[]{Integer.valueOf(zzf)});
            }
            sb.append(str);
        }
        sb.append("Z");
        return sb.toString();
    }
}
