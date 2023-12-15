package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.messaging.ServiceStarter;
import java.lang.reflect.InvocationTargetException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.2 */
public final class zzag extends zzgx {
    private Boolean zza;
    private zzaf zzb = zzae.zza;
    private Boolean zzc;

    zzag(zzge zzge) {
        super(zzge);
    }

    public static final long zzA() {
        return ((Long) zzeh.zzD.zza((Object) null)).longValue();
    }

    private final String zzB(String str, String str2) {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{str, ""});
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e) {
            this.zzt.zzaA().zzd().zzb("Could not find SystemProperties class", e);
            return "";
        } catch (NoSuchMethodException e2) {
            this.zzt.zzaA().zzd().zzb("Could not find SystemProperties.get() method", e2);
            return "";
        } catch (IllegalAccessException e3) {
            this.zzt.zzaA().zzd().zzb("Could not access SystemProperties.get()", e3);
            return "";
        } catch (InvocationTargetException e4) {
            this.zzt.zzaA().zzd().zzb("SystemProperties.get() threw an exception", e4);
            return "";
        }
    }

    public static final long zzz() {
        return ((Long) zzeh.zzd.zza((Object) null)).longValue();
    }

    public final double zza(String str, zzeg zzeg) {
        if (str == null) {
            return ((Double) zzeg.zza((Object) null)).doubleValue();
        }
        String zza2 = this.zzb.zza(str, zzeg.zzb());
        if (TextUtils.isEmpty(zza2)) {
            return ((Double) zzeg.zza((Object) null)).doubleValue();
        }
        try {
            return ((Double) zzeg.zza(Double.valueOf(Double.parseDouble(zza2)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) zzeg.zza((Object) null)).doubleValue();
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzb(String str) {
        return zzf(str, zzeh.zzH, ServiceStarter.ERROR_UNKNOWN, 2000);
    }

    public final int zzc() {
        return this.zzt.zzv().zzai(201500000, true) ? 100 : 25;
    }

    public final int zzd(String str) {
        return zzf(str, zzeh.zzI, 25, 100);
    }

    public final int zze(String str, zzeg zzeg) {
        if (str == null) {
            return ((Integer) zzeg.zza((Object) null)).intValue();
        }
        String zza2 = this.zzb.zza(str, zzeg.zzb());
        if (TextUtils.isEmpty(zza2)) {
            return ((Integer) zzeg.zza((Object) null)).intValue();
        }
        try {
            return ((Integer) zzeg.zza(Integer.valueOf(Integer.parseInt(zza2)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) zzeg.zza((Object) null)).intValue();
        }
    }

    public final int zzf(String str, zzeg zzeg, int i, int i2) {
        return Math.max(Math.min(zze(str, zzeg), i2), i);
    }

    public final long zzh() {
        this.zzt.zzay();
        return 77000;
    }

    public final long zzi(String str, zzeg zzeg) {
        if (str == null) {
            return ((Long) zzeg.zza((Object) null)).longValue();
        }
        String zza2 = this.zzb.zza(str, zzeg.zzb());
        if (TextUtils.isEmpty(zza2)) {
            return ((Long) zzeg.zza((Object) null)).longValue();
        }
        try {
            return ((Long) zzeg.zza(Long.valueOf(Long.parseLong(zza2)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) zzeg.zza((Object) null)).longValue();
        }
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzj() {
        try {
            if (this.zzt.zzaw().getPackageManager() == null) {
                this.zzt.zzaA().zzd().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(this.zzt.zzaw()).getApplicationInfo(this.zzt.zzaw().getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            this.zzt.zzaA().zzd().zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            this.zzt.zzaA().zzd().zzb("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzk(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzj = zzj();
        if (zzj == null) {
            this.zzt.zzaA().zzd().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!zzj.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(zzj.getBoolean(str));
        }
    }

    public final String zzl() {
        return zzB("debug.firebase.analytics.app", "");
    }

    public final String zzm() {
        return zzB("debug.deferred.deeplink", "");
    }

    /* access modifiers changed from: package-private */
    public final String zzn() {
        this.zzt.zzay();
        return "FA";
    }

    public final String zzo(String str, zzeg zzeg) {
        if (str == null) {
            return (String) zzeg.zza((Object) null);
        }
        return (String) zzeg.zza(this.zzb.zza(str, zzeg.zzb()));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e A[SYNTHETIC, Splitter:B:8:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zzp(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = "analytics.safelisted_events"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzj()
            r1 = 0
            if (r0 != 0) goto L_0x001d
            com.google.android.gms.measurement.internal.zzge r4 = r3.zzt
            com.google.android.gms.measurement.internal.zzeu r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzd()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L_0x001b:
            r4 = r1
            goto L_0x002c
        L_0x001d:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L_0x0024
            goto L_0x001b
        L_0x0024:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x002c:
            if (r4 == 0) goto L_0x0058
            com.google.android.gms.measurement.internal.zzge r0 = r3.zzt     // Catch:{ NotFoundException -> 0x0048 }
            android.content.Context r0 = r0.zzaw()     // Catch:{ NotFoundException -> 0x0048 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ NotFoundException -> 0x0048 }
            int r4 = r4.intValue()     // Catch:{ NotFoundException -> 0x0048 }
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch:{ NotFoundException -> 0x0048 }
            if (r4 != 0) goto L_0x0043
            return r1
        L_0x0043:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ NotFoundException -> 0x0048 }
            return r4
        L_0x0048:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzge r0 = r3.zzt
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzd()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zzb(r2, r4)
        L_0x0058:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzag.zzp(java.lang.String):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final void zzq(zzaf zzaf) {
        this.zzb = zzaf;
    }

    public final boolean zzr() {
        Boolean zzk = zzk("google_analytics_adid_collection_enabled");
        return zzk == null || zzk.booleanValue();
    }

    public final boolean zzs(String str, zzeg zzeg) {
        if (str == null) {
            return ((Boolean) zzeg.zza((Object) null)).booleanValue();
        }
        String zza2 = this.zzb.zza(str, zzeg.zzb());
        if (TextUtils.isEmpty(zza2)) {
            return ((Boolean) zzeg.zza((Object) null)).booleanValue();
        }
        return ((Boolean) zzeg.zza(Boolean.valueOf("1".equals(zza2)))).booleanValue();
    }

    public final boolean zzt(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzu() {
        Boolean zzk = zzk("google_analytics_automatic_screen_reporting_enabled");
        return zzk == null || zzk.booleanValue();
    }

    public final boolean zzv() {
        this.zzt.zzay();
        Boolean zzk = zzk("firebase_analytics_collection_deactivated");
        return zzk != null && zzk.booleanValue();
    }

    public final boolean zzw(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzx() {
        if (this.zza == null) {
            Boolean zzk = zzk("app_measurement_lite");
            this.zza = zzk;
            if (zzk == null) {
                this.zza = false;
            }
        }
        if (this.zza.booleanValue() || !this.zzt.zzN()) {
            return true;
        }
        return false;
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean zzy() {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    ApplicationInfo applicationInfo = this.zzt.zzaw().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = false;
                        if (str != null && str.equals(myProcessName)) {
                            z = true;
                        }
                        this.zzc = Boolean.valueOf(z);
                    }
                    if (this.zzc == null) {
                        this.zzc = Boolean.TRUE;
                        this.zzt.zzaA().zzd().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzc.booleanValue();
    }
}
