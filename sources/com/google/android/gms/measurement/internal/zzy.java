package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzer;
import com.google.android.gms.internal.measurement.zzey;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
abstract class zzy {
    final String zzb;
    final int zzc;
    Boolean zzd;
    Boolean zze;
    Long zzf;
    Long zzg;

    zzy(String str, int i) {
        this.zzb = str;
        this.zzc = i;
    }

    private static Boolean zzd(String str, int i, boolean z, String str2, List list, String str3, zzeu zzeu) {
        if (i == 7) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && i != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i - 1) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, true != z ? 66 : 0).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzeu != null) {
                        zzeu.zzk().zzb("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                if (list == null) {
                    return null;
                }
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    static Boolean zze(BigDecimal bigDecimal, zzer zzer, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzer);
        if (zzer.zzg()) {
            boolean z = true;
            if (zzer.zzm() != 1) {
                if (zzer.zzm() == 5) {
                    if (!zzer.zzk() || !zzer.zzj()) {
                        return null;
                    }
                } else if (!zzer.zzh()) {
                    return null;
                }
                int zzm = zzer.zzm();
                if (zzer.zzm() == 5) {
                    if (zzli.zzx(zzer.zze()) && zzli.zzx(zzer.zzd())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(zzer.zze());
                            bigDecimal3 = new BigDecimal(zzer.zzd());
                            bigDecimal2 = bigDecimal5;
                            bigDecimal4 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                } else if (!zzli.zzx(zzer.zzc())) {
                    return null;
                } else {
                    try {
                        bigDecimal4 = new BigDecimal(zzer.zzc());
                        bigDecimal2 = null;
                        bigDecimal3 = null;
                    } catch (NumberFormatException unused2) {
                    }
                }
                if (zzm == 5) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                } else if (bigDecimal4 == null) {
                    return null;
                }
                int i = zzm - 1;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4 || bigDecimal2 == null) {
                                return null;
                            }
                            if (bigDecimal.compareTo(bigDecimal2) < 0 || bigDecimal.compareTo(bigDecimal3) > 0) {
                                z = false;
                            }
                            return Boolean.valueOf(z);
                        } else if (bigDecimal4 == null) {
                            return null;
                        } else {
                            if (d != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                                if (bigDecimal.compareTo(bigDecimal4.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) <= 0 || bigDecimal.compareTo(bigDecimal4.add(new BigDecimal(d).multiply(new BigDecimal(2)))) >= 0) {
                                    z = false;
                                }
                                return Boolean.valueOf(z);
                            }
                            if (bigDecimal.compareTo(bigDecimal4) != 0) {
                                z = false;
                            }
                            return Boolean.valueOf(z);
                        }
                    } else if (bigDecimal4 == null) {
                        return null;
                    } else {
                        if (bigDecimal.compareTo(bigDecimal4) <= 0) {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                } else if (bigDecimal4 == null) {
                    return null;
                } else {
                    if (bigDecimal.compareTo(bigDecimal4) >= 0) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
            }
        }
        return null;
    }

    static Boolean zzf(String str, zzey zzey, zzeu zzeu) {
        String str2;
        List list;
        Preconditions.checkNotNull(zzey);
        if (str == null || !zzey.zzi() || zzey.zzj() == 1) {
            return null;
        }
        if (zzey.zzj() == 7) {
            if (zzey.zza() == 0) {
                return null;
            }
        } else if (!zzey.zzh()) {
            return null;
        }
        int zzj = zzey.zzj();
        boolean zzf2 = zzey.zzf();
        if (zzf2 || zzj == 2 || zzj == 7) {
            str2 = zzey.zzd();
        } else {
            str2 = zzey.zzd().toUpperCase(Locale.ENGLISH);
        }
        String str3 = str2;
        if (zzey.zza() == 0) {
            list = null;
        } else {
            List<String> zze2 = zzey.zze();
            if (!zzf2) {
                ArrayList arrayList = new ArrayList(zze2.size());
                for (String upperCase : zze2) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                zze2 = Collections.unmodifiableList(arrayList);
            }
            list = zze2;
        }
        return zzd(str, zzj, zzf2, str3, list, zzj == 2 ? str3 : null, zzeu);
    }

    static Boolean zzg(double d, zzer zzer) {
        try {
            return zze(new BigDecimal(d), zzer, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zzh(long j, zzer zzer) {
        try {
            return zze(new BigDecimal(j), zzer, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zzi(String str, zzer zzer) {
        if (!zzli.zzx(str)) {
            return null;
        }
        try {
            return zze(new BigDecimal(str), zzer, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zzj(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    /* access modifiers changed from: package-private */
    public abstract int zza();

    /* access modifiers changed from: package-private */
    public abstract boolean zzb();

    /* access modifiers changed from: package-private */
    public abstract boolean zzc();
}
