package com.google.android.gms.internal.p001firebaseauthapi;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzajo {
    public static final zzait zza;
    public static final zzait zzb;
    public static final zzait zzc;
    private static final ThreadLocal zzd = new zzajn();
    @Nullable
    private static final Method zze = zzc("now");
    @Nullable
    private static final Method zzf = zzc("getEpochSecond");
    @Nullable
    private static final Method zzg = zzc("getNano");

    static {
        zzais zzc2 = zzait.zzc();
        zzc2.zzb(-62135596800L);
        zzc2.zza(0);
        zza = (zzait) zzc2.zzi();
        zzais zzc3 = zzait.zzc();
        zzc3.zzb(253402300799L);
        zzc3.zza(999999999);
        zzb = (zzait) zzc3.zzi();
        zzais zzc4 = zzait.zzc();
        zzc4.zzb(0);
        zzc4.zza(0);
        zzc = (zzait) zzc4.zzi();
    }

    public static zzait zza(zzait zzait) {
        long zzb2 = zzait.zzb();
        int i = (zzb2 > -62135596800L ? 1 : (zzb2 == -62135596800L ? 0 : -1));
        int zza2 = zzait.zza();
        if (i >= 0 && zzb2 <= 253402300799L && zza2 >= 0 && zza2 < 1000000000) {
            return zzait;
        }
        throw new IllegalArgumentException(String.format("Timestamp is not valid. See proto definition for valid values. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. Nanos (%s) must be in range [0, +999,999,999].", new Object[]{Long.valueOf(zzb2), Integer.valueOf(zza2)}));
    }

    public static zzait zzb(String str) throws ParseException {
        String str2;
        int i;
        int indexOf = str.indexOf(84);
        if (indexOf != -1) {
            int indexOf2 = str.indexOf(90, indexOf);
            if (indexOf2 == -1) {
                indexOf2 = str.indexOf(43, indexOf);
            }
            if (indexOf2 == -1) {
                indexOf2 = str.indexOf(45, indexOf);
            }
            if (indexOf2 != -1) {
                String substring = str.substring(0, indexOf2);
                int indexOf3 = substring.indexOf(46);
                if (indexOf3 != -1) {
                    String substring2 = substring.substring(0, indexOf3);
                    str2 = substring.substring(indexOf3 + 1);
                    substring = substring2;
                } else {
                    str2 = "";
                }
                long time = ((SimpleDateFormat) zzd.get()).parse(substring).getTime() / 1000;
                if (str2.isEmpty()) {
                    i = 0;
                } else {
                    i = 0;
                    for (int i2 = 0; i2 < 9; i2++) {
                        i *= 10;
                        if (i2 < str2.length()) {
                            if (str2.charAt(i2) < '0' || str2.charAt(i2) > '9') {
                                throw new ParseException("Invalid nanoseconds.", 0);
                            }
                            i += str2.charAt(i2) - '0';
                        }
                    }
                }
                if (str.charAt(indexOf2) != 'Z') {
                    String substring3 = str.substring(indexOf2 + 1);
                    int indexOf4 = substring3.indexOf(58);
                    if (indexOf4 != -1) {
                        String substring4 = substring3.substring(0, indexOf4);
                        String substring5 = substring3.substring(indexOf4 + 1);
                        char charAt = str.charAt(indexOf2);
                        long parseLong = ((Long.parseLong(substring4) * 60) + Long.parseLong(substring5)) * 60;
                        time = charAt == '+' ? time - parseLong : time + parseLong;
                    } else {
                        throw new ParseException("Invalid offset value: ".concat(String.valueOf(substring3)), 0);
                    }
                } else if (str.length() != indexOf2 + 1) {
                    String substring6 = str.substring(indexOf2);
                    throw new ParseException("Failed to parse timestamp: invalid trailing data \"" + substring6 + "\"", 0);
                }
                if (i <= -1000000000 || i >= 1000000000) {
                    try {
                        time = zzbb.zza(time, (long) (i / 1000000000));
                        i %= 1000000000;
                    } catch (IllegalArgumentException e) {
                        ParseException parseException = new ParseException("Failed to parse timestamp " + str + " Timestamp is out of range.", 0);
                        parseException.initCause(e);
                        throw parseException;
                    }
                }
                if (i < 0) {
                    i += 1000000000;
                    time = zzbb.zzb(time, 1);
                }
                zzais zzc2 = zzait.zzc();
                zzc2.zzb(time);
                zzc2.zza(i);
                zzait zzait = (zzait) zzc2.zzi();
                zza(zzait);
                return zzait;
            }
            throw new ParseException("Failed to parse timestamp: missing valid timezone offset.", 0);
        }
        throw new ParseException("Failed to parse timestamp: invalid timestamp \"" + str + "\"", 0);
    }

    @Nullable
    private static Method zzc(String str) {
        try {
            return Class.forName("java.time.Instant").getMethod(str, new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
