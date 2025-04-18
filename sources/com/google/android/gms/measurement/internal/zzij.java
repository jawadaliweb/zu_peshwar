package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpe;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.2 */
public final class zzij extends zzf {
    protected zzii zza;
    final zzs zzb;
    protected boolean zzc = true;
    private zzhe zzd;
    private final Set zze = new CopyOnWriteArraySet();
    private boolean zzf;
    private final AtomicReference zzg = new AtomicReference();
    private final Object zzh = new Object();
    private zzai zzi = new zzai((Boolean) null, (Boolean) null);
    private int zzj = 100;
    private final AtomicLong zzk = new AtomicLong(0);
    private long zzl = -1;
    private int zzm = 100;
    private final zzln zzn = new zzhy(this);

    protected zzij(zzge zzge) {
        super(zzge);
        this.zzb = new zzs(zzge);
    }

    /* access modifiers changed from: private */
    public final void zzaa(Boolean bool, boolean z) {
        zzg();
        zza();
        this.zzt.zzaA().zzc().zzb("Setting app measurement enabled (FE)", bool);
        this.zzt.zzm().zzh(bool);
        if (z) {
            zzfj zzm2 = this.zzt.zzm();
            zzge zzge = zzm2.zzt;
            zzm2.zzg();
            SharedPreferences.Editor edit = zzm2.zza().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
        if (this.zzt.zzK() || (bool != null && !bool.booleanValue())) {
            zzab();
        }
    }

    /* access modifiers changed from: private */
    public final void zzab() {
        zzg();
        String zza2 = this.zzt.zzm().zzh.zza();
        if (zza2 != null) {
            if ("unset".equals(zza2)) {
                zzY("app", "_npa", (Object) null, this.zzt.zzax().currentTimeMillis());
            } else {
                zzY("app", "_npa", Long.valueOf(true != "true".equals(zza2) ? 0 : 1), this.zzt.zzax().currentTimeMillis());
            }
        }
        if (!this.zzt.zzJ() || !this.zzc) {
            this.zzt.zzaA().zzc().zza("Updating Scion state (FE)");
            this.zzt.zzt().zzI();
            return;
        }
        this.zzt.zzaA().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzz();
        zzpe.zzc();
        if (this.zzt.zzf().zzs((String) null, zzeh.zzaf)) {
            this.zzt.zzu().zza.zza();
        }
        this.zzt.zzaB().zzp(new zzhm(this));
    }

    static /* bridge */ /* synthetic */ void zzv(zzij zzij, zzai zzai, zzai zzai2) {
        boolean z;
        zzah[] zzahArr = {zzah.ANALYTICS_STORAGE, zzah.AD_STORAGE};
        int i = 0;
        while (true) {
            if (i >= 2) {
                z = false;
                break;
            }
            zzah zzah = zzahArr[i];
            if (!zzai2.zzi(zzah) && zzai.zzi(zzah)) {
                z = true;
                break;
            }
            i++;
        }
        boolean zzl2 = zzai.zzl(zzai2, zzah.ANALYTICS_STORAGE, zzah.AD_STORAGE);
        if (z || zzl2) {
            zzij.zzt.zzh().zzo();
        }
    }

    static /* synthetic */ void zzw(zzij zzij, zzai zzai, int i, long j, boolean z, boolean z2) {
        zzij.zzg();
        zzij.zza();
        if (j > zzij.zzl || !zzai.zzj(zzij.zzm, i)) {
            zzfj zzm2 = zzij.zzt.zzm();
            zzge zzge = zzm2.zzt;
            zzm2.zzg();
            if (zzm2.zzl(i)) {
                SharedPreferences.Editor edit = zzm2.zza().edit();
                edit.putString("consent_settings", zzai.zzh());
                edit.putInt("consent_source", i);
                edit.apply();
                zzij.zzl = j;
                zzij.zzm = i;
                zzij.zzt.zzt().zzF(z);
                if (z2) {
                    zzij.zzt.zzt().zzu(new AtomicReference());
                    return;
                }
                return;
            }
            zzij.zzt.zzaA().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(i));
            return;
        }
        zzij.zzt.zzaA().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzai);
    }

    public final void zzA(String str, String str2, Bundle bundle) {
        long currentTimeMillis = this.zzt.zzax().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        this.zzt.zzaB().zzp(new zzht(this, bundle2));
    }

    public final void zzB() {
        if ((this.zzt.zzaw().getApplicationContext() instanceof Application) && this.zza != null) {
            ((Application) this.zzt.zzaw().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzC(Bundle bundle) {
        if (bundle == null) {
            this.zzt.zzm().zzs.zzb(new Bundle());
            return;
        }
        Bundle zza2 = this.zzt.zzm().zzs.zza();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                if (this.zzt.zzv().zzag(obj)) {
                    this.zzt.zzv().zzO(this.zzn, (String) null, 27, (String) null, (String) null, 0);
                }
                this.zzt.zzaA().zzl().zzc("Invalid default event parameter type. Name, value", str, obj);
            } else if (zzlo.zzaj(str)) {
                this.zzt.zzaA().zzl().zzb("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                zza2.remove(str);
            } else {
                zzlo zzv = this.zzt.zzv();
                this.zzt.zzf();
                if (zzv.zzab("param", str, 100, obj)) {
                    this.zzt.zzv().zzP(zza2, str, obj);
                }
            }
        }
        this.zzt.zzv();
        int zzc2 = this.zzt.zzf().zzc();
        if (zza2.size() > zzc2) {
            int i = 0;
            for (String str2 : new TreeSet(zza2.keySet())) {
                i++;
                if (i > zzc2) {
                    zza2.remove(str2);
                }
            }
            this.zzt.zzv().zzO(this.zzn, (String) null, 26, (String) null, (String) null, 0);
            this.zzt.zzaA().zzl().zza("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        this.zzt.zzm().zzs.zzb(zza2);
        this.zzt.zzt().zzH(zza2);
    }

    public final void zzD(String str, String str2, Bundle bundle) {
        zzE(str, str2, bundle, true, true, this.zzt.zzax().currentTimeMillis());
    }

    public final void zzE(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        String str3 = str2;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (str3 == FirebaseAnalytics.Event.SCREEN_VIEW || (str3 != null && str2.equals(FirebaseAnalytics.Event.SCREEN_VIEW))) {
            this.zzt.zzs().zzx(bundle2, j);
            return;
        }
        zzM(str == null ? "app" : str, str2, j, bundle2, z2, !z2 || this.zzd == null || zzlo.zzaj(str2), z, (String) null);
    }

    public final void zzF(String str, String str2, Bundle bundle, String str3) {
        zzge.zzO();
        zzM(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str2, this.zzt.zzax().currentTimeMillis(), bundle, false, true, true, str3);
    }

    /* access modifiers changed from: package-private */
    public final void zzG(String str, String str2, Bundle bundle) {
        zzg();
        zzH(str, str2, this.zzt.zzax().currentTimeMillis(), bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zzH(String str, String str2, long j, Bundle bundle) {
        zzg();
        zzI(str, str2, j, bundle, true, this.zzd == null || zzlo.zzaj(str2), true, (String) null);
    }

    /* JADX WARNING: type inference failed for: r5v11, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r5v13, types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzI(java.lang.String r20, java.lang.String r21, long r22, android.os.Bundle r24, boolean r25, boolean r26, boolean r27, java.lang.String r28) {
        /*
            r19 = this;
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r12 = r24
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r24)
            r19.zzg()
            r19.zza()
            com.google.android.gms.measurement.internal.zzge r0 = r7.zzt
            boolean r0 = r0.zzJ()
            if (r0 == 0) goto L_0x04f1
            com.google.android.gms.measurement.internal.zzge r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzh()
            java.util.List r0 = r0.zzn()
            if (r0 == 0) goto L_0x0041
            boolean r0 = r0.contains(r9)
            if (r0 == 0) goto L_0x0031
            goto L_0x0041
        L_0x0031:
            com.google.android.gms.measurement.internal.zzge r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzc()
            java.lang.String r1 = "Dropping non-safelisted event. event name, origin"
            r0.zzc(r1, r9, r8)
            return
        L_0x0041:
            boolean r0 = r7.zzf
            r13 = 0
            r14 = 0
            r15 = 1
            if (r0 != 0) goto L_0x00a1
            r7.zzf = r15
            com.google.android.gms.measurement.internal.zzge r0 = r7.zzt     // Catch:{ ClassNotFoundException -> 0x0092 }
            boolean r0 = r0.zzN()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.String r1 = "com.google.android.gms.tagmanager.TagManagerService"
            if (r0 != 0) goto L_0x0063
            com.google.android.gms.measurement.internal.zzge r0 = r7.zzt     // Catch:{ ClassNotFoundException -> 0x0092 }
            android.content.Context r0 = r0.zzaw()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.Class r0 = java.lang.Class.forName(r1, r15, r0)     // Catch:{ ClassNotFoundException -> 0x0092 }
            goto L_0x0067
        L_0x0063:
            java.lang.Class r0 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0092 }
        L_0x0067:
            java.lang.String r1 = "initialize"
            java.lang.Class[] r2 = new java.lang.Class[r15]     // Catch:{ Exception -> 0x0081 }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r14] = r3     // Catch:{ Exception -> 0x0081 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x0081 }
            java.lang.Object[] r1 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x0081 }
            com.google.android.gms.measurement.internal.zzge r2 = r7.zzt     // Catch:{ Exception -> 0x0081 }
            android.content.Context r2 = r2.zzaw()     // Catch:{ Exception -> 0x0081 }
            r1[r14] = r2     // Catch:{ Exception -> 0x0081 }
            r0.invoke(r13, r1)     // Catch:{ Exception -> 0x0081 }
            goto L_0x00a1
        L_0x0081:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt     // Catch:{ ClassNotFoundException -> 0x0092 }
            com.google.android.gms.measurement.internal.zzeu r1 = r1.zzaA()     // Catch:{ ClassNotFoundException -> 0x0092 }
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzk()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.String r2 = "Failed to invoke Tag Manager's initialize() method"
            r1.zzb(r2, r0)     // Catch:{ ClassNotFoundException -> 0x0092 }
            goto L_0x00a1
        L_0x0092:
            com.google.android.gms.measurement.internal.zzge r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzi()
            java.lang.String r1 = "Tag Manager is not found and thus will not be used"
            r0.zza(r1)
        L_0x00a1:
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x00cd
            java.lang.String r0 = "gclid"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x00cd
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            r1.zzay()
            java.lang.String r4 = r12.getString(r0)
            com.google.android.gms.measurement.internal.zzge r0 = r7.zzt
            com.google.android.gms.common.util.Clock r0 = r0.zzax()
            long r5 = r0.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            r1 = r19
            r1.zzY(r2, r3, r4, r5)
        L_0x00cd:
            com.google.android.gms.measurement.internal.zzge r0 = r7.zzt
            r0.zzay()
            if (r25 == 0) goto L_0x00ef
            boolean r0 = com.google.android.gms.measurement.internal.zzlo.zzan(r21)
            if (r0 == 0) goto L_0x00ef
            com.google.android.gms.measurement.internal.zzge r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzlo r0 = r0.zzv()
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzfe r1 = r1.zzs
            android.os.Bundle r1 = r1.zza()
            r0.zzL(r12, r1)
        L_0x00ef:
            r0 = 40
            if (r27 != 0) goto L_0x0177
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            r1.zzay()
            java.lang.String r1 = "_iap"
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x0177
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzlo r1 = r1.zzv()
            java.lang.String r2 = "event"
            boolean r3 = r1.zzad(r2, r9)
            r4 = 2
            if (r3 != 0) goto L_0x0110
            goto L_0x012a
        L_0x0110:
            java.lang.String[] r3 = com.google.android.gms.measurement.internal.zzhb.zza
            java.lang.String[] r5 = com.google.android.gms.measurement.internal.zzhb.zzb
            boolean r3 = r1.zzaa(r2, r3, r5, r9)
            if (r3 != 0) goto L_0x011d
            r4 = 13
            goto L_0x012a
        L_0x011d:
            com.google.android.gms.measurement.internal.zzge r3 = r1.zzt
            r3.zzf()
            boolean r1 = r1.zzZ(r2, r0, r9)
            if (r1 != 0) goto L_0x0129
            goto L_0x012a
        L_0x0129:
            r4 = 0
        L_0x012a:
            if (r4 == 0) goto L_0x0177
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzeu r1 = r1.zzaA()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()
            com.google.android.gms.measurement.internal.zzge r2 = r7.zzt
            com.google.android.gms.measurement.internal.zzep r2 = r2.zzj()
            java.lang.String r2 = r2.zzd(r9)
            java.lang.String r3 = "Invalid public event name. Event will not be logged (FE)"
            r1.zzb(r3, r2)
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzlo r1 = r1.zzv()
            com.google.android.gms.measurement.internal.zzge r2 = r7.zzt
            r2.zzf()
            java.lang.String r0 = r1.zzD(r9, r0, r15)
            if (r9 == 0) goto L_0x015a
            int r14 = r21.length()
        L_0x015a:
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzlo r1 = r1.zzv()
            com.google.android.gms.measurement.internal.zzln r2 = r7.zzn
            r3 = 0
            java.lang.String r5 = "_ev"
            r20 = r1
            r21 = r2
            r22 = r3
            r23 = r4
            r24 = r5
            r25 = r0
            r26 = r14
            r20.zzO(r21, r22, r23, r24, r25, r26)
            return
        L_0x0177:
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            r1.zzay()
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zziy r1 = r1.zzs()
            com.google.android.gms.measurement.internal.zziq r1 = r1.zzj(r14)
            java.lang.String r2 = "_sc"
            if (r1 == 0) goto L_0x0192
            boolean r3 = r12.containsKey(r2)
            if (r3 != 0) goto L_0x0192
            r1.zzd = r15
        L_0x0192:
            if (r25 == 0) goto L_0x0198
            if (r27 != 0) goto L_0x0198
            r3 = 1
            goto L_0x0199
        L_0x0198:
            r3 = 0
        L_0x0199:
            com.google.android.gms.measurement.internal.zzlo.zzK(r1, r12, r3)
            java.lang.String r1 = "am"
            boolean r1 = r1.equals(r8)
            boolean r3 = com.google.android.gms.measurement.internal.zzlo.zzaj(r21)
            if (r25 == 0) goto L_0x01e9
            com.google.android.gms.measurement.internal.zzhe r4 = r7.zzd
            if (r4 == 0) goto L_0x01e9
            if (r3 != 0) goto L_0x01e9
            if (r1 == 0) goto L_0x01b3
            r16 = 1
            goto L_0x01eb
        L_0x01b3:
            com.google.android.gms.measurement.internal.zzge r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzc()
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzep r1 = r1.zzj()
            java.lang.String r1 = r1.zzd(r9)
            com.google.android.gms.measurement.internal.zzge r2 = r7.zzt
            com.google.android.gms.measurement.internal.zzep r2 = r2.zzj()
            java.lang.String r2 = r2.zzb(r12)
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            r0.zzc(r3, r1, r2)
            com.google.android.gms.measurement.internal.zzhe r0 = r7.zzd
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.measurement.internal.zzhe r1 = r7.zzd
            r2 = r20
            r3 = r21
            r4 = r24
            r5 = r22
            r1.interceptEvent(r2, r3, r4, r5)
            return
        L_0x01e9:
            r16 = r1
        L_0x01eb:
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            boolean r1 = r1.zzM()
            if (r1 == 0) goto L_0x04f0
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzlo r1 = r1.zzv()
            int r1 = r1.zzh(r9)
            if (r1 == 0) goto L_0x0249
            com.google.android.gms.measurement.internal.zzge r2 = r7.zzt
            com.google.android.gms.measurement.internal.zzeu r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzes r2 = r2.zze()
            com.google.android.gms.measurement.internal.zzge r3 = r7.zzt
            com.google.android.gms.measurement.internal.zzep r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r9)
            java.lang.String r4 = "Invalid event name. Event will not be logged (FE)"
            r2.zzb(r4, r3)
            com.google.android.gms.measurement.internal.zzge r2 = r7.zzt
            com.google.android.gms.measurement.internal.zzlo r2 = r2.zzv()
            com.google.android.gms.measurement.internal.zzge r3 = r7.zzt
            r3.zzf()
            java.lang.String r0 = r2.zzD(r9, r0, r15)
            if (r9 == 0) goto L_0x022d
            int r14 = r21.length()
        L_0x022d:
            com.google.android.gms.measurement.internal.zzge r2 = r7.zzt
            com.google.android.gms.measurement.internal.zzlo r2 = r2.zzv()
            com.google.android.gms.measurement.internal.zzln r3 = r7.zzn
            java.lang.String r4 = "_ev"
            r20 = r2
            r21 = r3
            r22 = r28
            r23 = r1
            r24 = r4
            r25 = r0
            r26 = r14
            r20.zzO(r21, r22, r23, r24, r25, r26)
            return
        L_0x0249:
            java.lang.String r0 = "_o"
            java.lang.String r1 = "_sn"
            java.lang.String r3 = "_si"
            java.lang.String[] r1 = new java.lang.String[]{r0, r1, r2, r3}
            java.util.List r5 = com.google.android.gms.common.util.CollectionUtils.listOf((T[]) r1)
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzlo r1 = r1.zzv()
            r2 = r28
            r3 = r21
            r4 = r24
            r6 = r27
            android.os.Bundle r12 = r1.zzu(r2, r3, r4, r5, r6)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r12)
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            r1.zzay()
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zziy r1 = r1.zzs()
            com.google.android.gms.measurement.internal.zziq r1 = r1.zzj(r14)
            java.lang.String r5 = "_ae"
            if (r1 == 0) goto L_0x02ae
            boolean r1 = r5.equals(r9)
            if (r1 == 0) goto L_0x02ae
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzko r1 = r1.zzu()
            com.google.android.gms.measurement.internal.zzkm r1 = r1.zzb
            com.google.android.gms.measurement.internal.zzko r2 = r1.zzc
            com.google.android.gms.measurement.internal.zzge r2 = r2.zzt
            com.google.android.gms.common.util.Clock r2 = r2.zzax()
            long r14 = r2.elapsedRealtime()
            long r3 = r1.zzb
            long r2 = r14 - r3
            r1.zzb = r14
            r14 = 0
            int r1 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r1 <= 0) goto L_0x02ae
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzlo r1 = r1.zzv()
            r1.zzI(r12, r2)
        L_0x02ae:
            com.google.android.gms.internal.measurement.zzos.zzc()
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzag r1 = r1.zzf()
            com.google.android.gms.measurement.internal.zzeg r2 = com.google.android.gms.measurement.internal.zzeh.zzae
            boolean r1 = r1.zzs(r13, r2)
            if (r1 == 0) goto L_0x0338
            java.lang.String r1 = "auto"
            boolean r1 = r1.equals(r8)
            java.lang.String r2 = "_ffr"
            if (r1 != 0) goto L_0x0317
            java.lang.String r1 = "_ssr"
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x0317
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzlo r1 = r1.zzv()
            java.lang.String r2 = r12.getString(r2)
            boolean r3 = com.google.android.gms.common.util.Strings.isEmptyOrWhitespace(r2)
            if (r3 == 0) goto L_0x02e3
            r2 = r13
            goto L_0x02e9
        L_0x02e3:
            if (r2 == 0) goto L_0x02e9
            java.lang.String r2 = r2.trim()
        L_0x02e9:
            com.google.android.gms.measurement.internal.zzge r3 = r1.zzt
            com.google.android.gms.measurement.internal.zzfj r3 = r3.zzm()
            com.google.android.gms.measurement.internal.zzfi r3 = r3.zzp
            java.lang.String r3 = r3.zza()
            boolean r3 = com.google.android.gms.measurement.internal.zzlm.zza(r2, r3)
            if (r3 != 0) goto L_0x0307
            com.google.android.gms.measurement.internal.zzge r1 = r1.zzt
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzfi r1 = r1.zzp
            r1.zzb(r2)
            goto L_0x0338
        L_0x0307:
            com.google.android.gms.measurement.internal.zzge r0 = r1.zzt
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzc()
            java.lang.String r1 = "Not logging duplicate session_start_with_rollout event"
            r0.zza(r1)
            return
        L_0x0317:
            boolean r1 = r5.equals(r9)
            if (r1 == 0) goto L_0x0338
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzlo r1 = r1.zzv()
            com.google.android.gms.measurement.internal.zzge r1 = r1.zzt
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzfi r1 = r1.zzp
            java.lang.String r1 = r1.zza()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x0338
            r12.putString(r2, r1)
        L_0x0338:
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            r14.add(r12)
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzff r1 = r1.zzj
            long r1 = r1.zza()
            r3 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 <= 0) goto L_0x03ca
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzm()
            boolean r1 = r1.zzk(r10)
            if (r1 == 0) goto L_0x03ca
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzfd r1 = r1.zzm
            boolean r1 = r1.zzb()
            if (r1 == 0) goto L_0x03ca
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzeu r1 = r1.zzaA()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzj()
            java.lang.String r2 = "Current session is expired, remove the session number, ID, and engagement time"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.common.util.Clock r1 = r1.zzax()
            long r17 = r1.currentTimeMillis()
            r6 = 0
            java.lang.String r2 = "auto"
            java.lang.String r15 = "_sid"
            r1 = r19
            r24 = r14
            r13 = r3
            r3 = r15
            r4 = r6
            r15 = r5
            r5 = r17
            r1.zzY(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.common.util.Clock r1 = r1.zzax()
            long r5 = r1.currentTimeMillis()
            r4 = 0
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sno"
            r1 = r19
            r1.zzY(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.common.util.Clock r1 = r1.zzax()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_se"
            r1 = r19
            r1.zzY(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzff r1 = r1.zzk
            r1.zzb(r13)
            goto L_0x03ce
        L_0x03ca:
            r15 = r5
            r24 = r14
            r13 = r3
        L_0x03ce:
            java.lang.String r1 = "extend_session"
            long r1 = r12.getLong(r1, r13)
            r3 = 1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x03f5
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzeu r1 = r1.zzaA()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzj()
            java.lang.String r2 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzko r1 = r1.zzu()
            com.google.android.gms.measurement.internal.zzkn r1 = r1.zza
            r2 = 1
            r1.zzb(r10, r2)
        L_0x03f5:
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Set r2 = r12.keySet()
            r1.<init>(r2)
            java.util.Collections.sort(r1)
            int r2 = r1.size()
            r3 = 0
        L_0x0406:
            if (r3 >= r2) goto L_0x0454
            java.lang.Object r4 = r1.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x0451
            com.google.android.gms.measurement.internal.zzge r5 = r7.zzt
            r5.zzv()
            java.lang.Object r5 = r12.get(r4)
            boolean r6 = r5 instanceof android.os.Bundle
            if (r6 == 0) goto L_0x0426
            r6 = 1
            android.os.Bundle[] r13 = new android.os.Bundle[r6]
            android.os.Bundle r5 = (android.os.Bundle) r5
            r6 = 0
            r13[r6] = r5
            goto L_0x044c
        L_0x0426:
            boolean r6 = r5 instanceof android.os.Parcelable[]
            if (r6 == 0) goto L_0x0437
            android.os.Parcelable[] r5 = (android.os.Parcelable[]) r5
            int r6 = r5.length
            java.lang.Class<android.os.Bundle[]> r13 = android.os.Bundle[].class
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r6, r13)
            r13 = r5
            android.os.Bundle[] r13 = (android.os.Bundle[]) r13
            goto L_0x044c
        L_0x0437:
            boolean r6 = r5 instanceof java.util.ArrayList
            if (r6 == 0) goto L_0x044b
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r6 = r5.size()
            android.os.Bundle[] r6 = new android.os.Bundle[r6]
            java.lang.Object[] r5 = r5.toArray(r6)
            r13 = r5
            android.os.Bundle[] r13 = (android.os.Bundle[]) r13
            goto L_0x044c
        L_0x044b:
            r13 = 0
        L_0x044c:
            if (r13 == 0) goto L_0x0451
            r12.putParcelableArray(r4, r13)
        L_0x0451:
            int r3 = r3 + 1
            goto L_0x0406
        L_0x0454:
            r12 = 0
        L_0x0455:
            int r1 = r24.size()
            if (r12 >= r1) goto L_0x04c2
            r13 = r24
            java.lang.Object r1 = r13.get(r12)
            android.os.Bundle r1 = (android.os.Bundle) r1
            if (r12 == 0) goto L_0x0468
            java.lang.String r2 = "_ep"
            goto L_0x0469
        L_0x0468:
            r2 = r9
        L_0x0469:
            r1.putString(r0, r8)
            if (r26 == 0) goto L_0x0478
            com.google.android.gms.measurement.internal.zzge r3 = r7.zzt
            com.google.android.gms.measurement.internal.zzlo r3 = r3.zzv()
            android.os.Bundle r1 = r3.zzt(r1)
        L_0x0478:
            r14 = r1
            com.google.android.gms.measurement.internal.zzaw r5 = new com.google.android.gms.measurement.internal.zzaw
            com.google.android.gms.measurement.internal.zzau r3 = new com.google.android.gms.measurement.internal.zzau
            r3.<init>(r14)
            r1 = r5
            r4 = r20
            r25 = r0
            r0 = r5
            r5 = r22
            r1.<init>(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzjy r1 = r1.zzt()
            r5 = r28
            r1.zzA(r0, r5)
            if (r16 != 0) goto L_0x04bb
            java.util.Set r0 = r7.zze
            java.util.Iterator r0 = r0.iterator()
        L_0x049e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x04bb
            java.lang.Object r1 = r0.next()
            com.google.android.gms.measurement.internal.zzhf r1 = (com.google.android.gms.measurement.internal.zzhf) r1
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>(r14)
            r2 = r20
            r3 = r21
            r5 = r22
            r1.onEvent(r2, r3, r4, r5)
            r5 = r28
            goto L_0x049e
        L_0x04bb:
            int r12 = r12 + 1
            r0 = r25
            r24 = r13
            goto L_0x0455
        L_0x04c2:
            com.google.android.gms.measurement.internal.zzge r0 = r7.zzt
            r0.zzay()
            com.google.android.gms.measurement.internal.zzge r0 = r7.zzt
            com.google.android.gms.measurement.internal.zziy r0 = r0.zzs()
            r1 = 0
            com.google.android.gms.measurement.internal.zziq r0 = r0.zzj(r1)
            if (r0 == 0) goto L_0x04f0
            boolean r0 = r15.equals(r9)
            if (r0 == 0) goto L_0x04f0
            com.google.android.gms.measurement.internal.zzge r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzko r0 = r0.zzu()
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.common.util.Clock r1 = r1.zzax()
            long r1 = r1.elapsedRealtime()
            com.google.android.gms.measurement.internal.zzkm r0 = r0.zzb
            r3 = 1
            r0.zzd(r3, r3, r1)
        L_0x04f0:
            return
        L_0x04f1:
            com.google.android.gms.measurement.internal.zzge r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzc()
            java.lang.String r1 = "Event not sent since app measurement is disabled"
            r0.zza(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzij.zzI(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void zzJ(zzhf zzhf) {
        zza();
        Preconditions.checkNotNull(zzhf);
        if (!this.zze.add(zzhf)) {
            this.zzt.zzaA().zzk().zza("OnEventListener already registered");
        }
    }

    public final void zzK(long j) {
        this.zzg.set((Object) null);
        this.zzt.zzaB().zzp(new zzhr(this, j));
    }

    /* access modifiers changed from: package-private */
    public final void zzL(long j, boolean z) {
        zzg();
        zza();
        this.zzt.zzaA().zzc().zza("Resetting analytics data (FE)");
        zzko zzu = this.zzt.zzu();
        zzu.zzg();
        zzkn zzkn = zzu.zza;
        zzu.zzb.zza();
        zzqr.zzc();
        if (this.zzt.zzf().zzs((String) null, zzeh.zzan)) {
            this.zzt.zzh().zzo();
        }
        boolean zzJ = this.zzt.zzJ();
        zzfj zzm2 = this.zzt.zzm();
        zzm2.zzc.zzb(j);
        if (!TextUtils.isEmpty(zzm2.zzt.zzm().zzp.zza())) {
            zzm2.zzp.zzb((String) null);
        }
        zzpe.zzc();
        if (zzm2.zzt.zzf().zzs((String) null, zzeh.zzaf)) {
            zzm2.zzj.zzb(0);
        }
        zzm2.zzk.zzb(0);
        if (!zzm2.zzt.zzf().zzv()) {
            zzm2.zzi(!zzJ);
        }
        zzm2.zzq.zzb((String) null);
        zzm2.zzr.zzb(0);
        zzm2.zzs.zzb((Bundle) null);
        if (z) {
            this.zzt.zzt().zzC();
        }
        zzpe.zzc();
        if (this.zzt.zzf().zzs((String) null, zzeh.zzaf)) {
            this.zzt.zzu().zza.zza();
        }
        this.zzc = !zzJ;
    }

    /* access modifiers changed from: protected */
    public final void zzM(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelable);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        this.zzt.zzaB().zzp(new zzho(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    /* access modifiers changed from: package-private */
    public final void zzN(String str, String str2, long j, Object obj) {
        this.zzt.zzaB().zzp(new zzhp(this, str, str2, obj, j));
    }

    /* access modifiers changed from: package-private */
    public final void zzO(String str) {
        this.zzg.set(str);
    }

    public final void zzP(Bundle bundle) {
        zzQ(bundle, this.zzt.zzax().currentTimeMillis());
    }

    public final void zzQ(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.zzt.zzaA().zzk().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzha.zza(bundle2, "app_id", String.class, (Object) null);
        zzha.zza(bundle2, "origin", String.class, (Object) null);
        zzha.zza(bundle2, "name", String.class, (Object) null);
        zzha.zza(bundle2, "value", Object.class, (Object) null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, (Object) null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, (Object) null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, (Object) null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, (Object) null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, (Object) null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, (Object) null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, (Object) null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (this.zzt.zzv().zzl(string) != 0) {
            this.zzt.zzaA().zzd().zzb("Invalid conditional user property name", this.zzt.zzj().zzf(string));
        } else if (this.zzt.zzv().zzd(string, obj) == 0) {
            Object zzB = this.zzt.zzv().zzB(string, obj);
            if (zzB == null) {
                this.zzt.zzaA().zzd().zzc("Unable to normalize conditional user property value", this.zzt.zzj().zzf(string), obj);
                return;
            }
            zzha.zzb(bundle2, zzB);
            long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME))) {
                this.zzt.zzf();
                if (j2 > 15552000000L || j2 < 1) {
                    this.zzt.zzaA().zzd().zzc("Invalid conditional user property timeout", this.zzt.zzj().zzf(string), Long.valueOf(j2));
                    return;
                }
            }
            long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
            this.zzt.zzf();
            if (j3 > 15552000000L || j3 < 1) {
                this.zzt.zzaA().zzd().zzc("Invalid conditional user property time to live", this.zzt.zzj().zzf(string), Long.valueOf(j3));
            } else {
                this.zzt.zzaB().zzp(new zzhs(this, bundle2));
            }
        } else {
            this.zzt.zzaA().zzd().zzc("Invalid conditional user property value", this.zzt.zzj().zzf(string), obj);
        }
    }

    public final void zzR(Bundle bundle, int i, long j) {
        zza();
        String zzg2 = zzai.zzg(bundle);
        if (zzg2 != null) {
            this.zzt.zzaA().zzl().zzb("Ignoring invalid consent setting", zzg2);
            this.zzt.zzaA().zzl().zza("Valid consent values are 'granted', 'denied'");
        }
        zzS(zzai.zza(bundle), i, j);
    }

    public final void zzS(zzai zzai, int i, long j) {
        zzai zzai2;
        boolean z;
        boolean z2;
        boolean z3;
        zzai zzai3 = zzai;
        int i2 = i;
        zza();
        if (i2 != -10 && zzai.zze() == null && zzai.zzf() == null) {
            this.zzt.zzaA().zzl().zza("Discarding empty consent settings");
            return;
        }
        synchronized (this.zzh) {
            zzai2 = this.zzi;
            z = true;
            z2 = false;
            if (zzai.zzj(i2, this.zzj)) {
                boolean zzk2 = zzai3.zzk(this.zzi);
                if (zzai3.zzi(zzah.ANALYTICS_STORAGE) && !this.zzi.zzi(zzah.ANALYTICS_STORAGE)) {
                    z2 = true;
                }
                zzai3 = zzai3.zzd(this.zzi);
                this.zzi = zzai3;
                this.zzj = i2;
                z3 = z2;
                z2 = zzk2;
            } else {
                z = false;
                z3 = false;
            }
        }
        if (!z) {
            this.zzt.zzaA().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzai3);
            return;
        }
        long andIncrement = this.zzk.getAndIncrement();
        if (z2) {
            this.zzg.set((Object) null);
            this.zzt.zzaB().zzq(new zzie(this, zzai3, j, i, andIncrement, z3, zzai2));
            return;
        }
        zzif zzif = new zzif(this, zzai3, i, andIncrement, z3, zzai2);
        if (i2 == 30 || i2 == -10) {
            this.zzt.zzaB().zzq(zzif);
        } else {
            this.zzt.zzaB().zzp(zzif);
        }
    }

    public final void zzT(zzhe zzhe) {
        zzhe zzhe2;
        zzg();
        zza();
        if (!(zzhe == null || zzhe == (zzhe2 = this.zzd))) {
            Preconditions.checkState(zzhe2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzhe;
    }

    public final void zzU(Boolean bool) {
        zza();
        this.zzt.zzaB().zzp(new zzid(this, bool));
    }

    /* access modifiers changed from: package-private */
    public final void zzV(zzai zzai) {
        zzg();
        boolean z = (zzai.zzi(zzah.ANALYTICS_STORAGE) && zzai.zzi(zzah.AD_STORAGE)) || this.zzt.zzt().zzM();
        if (z != this.zzt.zzK()) {
            this.zzt.zzG(z);
            zzfj zzm2 = this.zzt.zzm();
            zzge zzge = zzm2.zzt;
            zzm2.zzg();
            Boolean valueOf = zzm2.zza().contains("measurement_enabled_from_api") ? Boolean.valueOf(zzm2.zza().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z || valueOf == null || valueOf.booleanValue()) {
                zzaa(Boolean.valueOf(z), false);
            }
        }
    }

    public final void zzW(String str, String str2, Object obj, boolean z) {
        zzX(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ldl", obj, true, this.zzt.zzax().currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzY(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzg()
            r8.zza()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0064
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x0052
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0052
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            r11 = 1
            java.lang.String r0 = "false"
            boolean r10 = r0.equals(r10)
            r2 = 1
            if (r11 == r10) goto L_0x0037
            r10 = 0
            goto L_0x0038
        L_0x0037:
            r10 = r2
        L_0x0038:
            java.lang.Long r11 = java.lang.Long.valueOf(r10)
            com.google.android.gms.measurement.internal.zzge r10 = r8.zzt
            com.google.android.gms.measurement.internal.zzfj r10 = r10.zzm()
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzh
            long r4 = r11.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x004e
            java.lang.String r0 = "true"
        L_0x004e:
            r10.zzb(r0)
            goto L_0x0061
        L_0x0052:
            if (r11 != 0) goto L_0x0064
            com.google.android.gms.measurement.internal.zzge r10 = r8.zzt
            com.google.android.gms.measurement.internal.zzfj r10 = r10.zzm()
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzh
            java.lang.String r0 = "unset"
            r10.zzb(r0)
        L_0x0061:
            r6 = r11
            r3 = r1
            goto L_0x0066
        L_0x0064:
            r3 = r10
            r6 = r11
        L_0x0066:
            com.google.android.gms.measurement.internal.zzge r10 = r8.zzt
            boolean r10 = r10.zzJ()
            if (r10 != 0) goto L_0x007e
            com.google.android.gms.measurement.internal.zzge r9 = r8.zzt
            com.google.android.gms.measurement.internal.zzeu r9 = r9.zzaA()
            com.google.android.gms.measurement.internal.zzes r9 = r9.zzj()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L_0x007e:
            com.google.android.gms.measurement.internal.zzge r10 = r8.zzt
            boolean r10 = r10.zzM()
            if (r10 != 0) goto L_0x0087
            return
        L_0x0087:
            com.google.android.gms.measurement.internal.zzlj r10 = new com.google.android.gms.measurement.internal.zzlj
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzge r9 = r8.zzt
            com.google.android.gms.measurement.internal.zzjy r9 = r9.zzt()
            r9.zzK(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzij.zzY(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void zzZ(zzhf zzhf) {
        zza();
        Preconditions.checkNotNull(zzhf);
        if (!this.zze.remove(zzhf)) {
            this.zzt.zzaA().zzk().zza("OnEventListener had not been registered");
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return false;
    }

    public final int zzh(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzt.zzf();
        return 25;
    }

    public final Boolean zzi() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.zzt.zzaB().zzd(atomicReference, 15000, "boolean test flag value", new zzhv(this, atomicReference));
    }

    public final Double zzj() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.zzt.zzaB().zzd(atomicReference, 15000, "double test flag value", new zzic(this, atomicReference));
    }

    public final Integer zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.zzt.zzaB().zzd(atomicReference, 15000, "int test flag value", new zzib(this, atomicReference));
    }

    public final Long zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.zzt.zzaB().zzd(atomicReference, 15000, "long test flag value", new zzia(this, atomicReference));
    }

    public final String zzo() {
        return (String) this.zzg.get();
    }

    public final String zzp() {
        zziq zzi2 = this.zzt.zzs().zzi();
        if (zzi2 != null) {
            return zzi2.zzb;
        }
        return null;
    }

    public final String zzq() {
        zziq zzi2 = this.zzt.zzs().zzi();
        if (zzi2 != null) {
            return zzi2.zza;
        }
        return null;
    }

    public final String zzr() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.zzt.zzaB().zzd(atomicReference, 15000, "String test flag value", new zzhz(this, atomicReference));
    }

    public final ArrayList zzs(String str, String str2) {
        if (this.zzt.zzaB().zzs()) {
            this.zzt.zzaA().zzd().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        this.zzt.zzay();
        if (zzab.zza()) {
            this.zzt.zzaA().zzd().zza("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzt.zzaB().zzd(atomicReference, 5000, "get conditional user properties", new zzhu(this, atomicReference, (String) null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return zzlo.zzH(list);
        }
        this.zzt.zzaA().zzd().zzb("Timed out waiting for get conditional user properties", (Object) null);
        return new ArrayList();
    }

    public final List zzt(boolean z) {
        zza();
        this.zzt.zzaA().zzj().zza("Getting user properties (FE)");
        if (!this.zzt.zzaB().zzs()) {
            this.zzt.zzay();
            if (zzab.zza()) {
                this.zzt.zzaA().zzd().zza("Cannot get all user properties from main thread");
                return Collections.emptyList();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzt.zzaB().zzd(atomicReference, 5000, "get user properties", new zzhq(this, atomicReference, z));
            List list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            this.zzt.zzaA().zzd().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
        this.zzt.zzaA().zzd().zza("Cannot get all user properties from analytics worker thread");
        return Collections.emptyList();
    }

    public final Map zzu(String str, String str2, boolean z) {
        if (this.zzt.zzaB().zzs()) {
            this.zzt.zzaA().zzd().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        this.zzt.zzay();
        if (zzab.zza()) {
            this.zzt.zzaA().zzd().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzt.zzaB().zzd(atomicReference, 5000, "get user properties", new zzhw(this, atomicReference, (String) null, str, str2, z));
        List<zzlj> list = (List) atomicReference.get();
        if (list == null) {
            this.zzt.zzaA().zzd().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzlj zzlj : list) {
            Object zza2 = zzlj.zza();
            if (zza2 != null) {
                arrayMap.put(zzlj.zzb, zza2);
            }
        }
        return arrayMap;
    }

    public final void zzz() {
        zzg();
        zza();
        if (this.zzt.zzM()) {
            if (this.zzt.zzf().zzs((String) null, zzeh.zzZ)) {
                zzag zzf2 = this.zzt.zzf();
                zzf2.zzt.zzay();
                Boolean zzk2 = zzf2.zzk("google_analytics_deferred_deep_link_enabled");
                if (zzk2 != null && zzk2.booleanValue()) {
                    this.zzt.zzaA().zzc().zza("Deferred Deep Link feature enabled.");
                    this.zzt.zzaB().zzp(new zzhl(this));
                }
            }
            this.zzt.zzt().zzq();
            this.zzc = false;
            zzfj zzm2 = this.zzt.zzm();
            zzm2.zzg();
            String string = zzm2.zza().getString("previous_os_version", (String) null);
            zzm2.zzt.zzg().zzv();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = zzm2.zza().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (!TextUtils.isEmpty(string)) {
                this.zzt.zzg().zzv();
                if (!string.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", string);
                    zzG(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ou", bundle);
                }
            }
        }
    }

    public final void zzX(String str, String str2, Object obj, boolean z, long j) {
        int i;
        int i2;
        String str3 = str2;
        Object obj2 = obj;
        if (z) {
            i = this.zzt.zzv().zzl(str3);
        } else {
            zzlo zzv = this.zzt.zzv();
            if (zzv.zzad("user property", str3)) {
                if (!zzv.zzaa("user property", zzhd.zza, (String[]) null, str3)) {
                    i = 15;
                } else {
                    zzv.zzt.zzf();
                    if (zzv.zzZ("user property", 24, str3)) {
                        i = 0;
                    }
                }
            }
            i = 6;
        }
        if (i != 0) {
            zzlo zzv2 = this.zzt.zzv();
            this.zzt.zzf();
            this.zzt.zzv().zzO(this.zzn, (String) null, i, "_ev", zzv2.zzD(str3, 24, true), str3 != null ? str2.length() : 0);
            return;
        }
        String str4 = str == null ? "app" : str;
        if (obj2 != null) {
            int zzd2 = this.zzt.zzv().zzd(str3, obj2);
            if (zzd2 != 0) {
                zzlo zzv3 = this.zzt.zzv();
                this.zzt.zzf();
                String zzD = zzv3.zzD(str3, 24, true);
                if ((obj2 instanceof String) || (obj2 instanceof CharSequence)) {
                    i2 = obj.toString().length();
                } else {
                    i2 = 0;
                }
                this.zzt.zzv().zzO(this.zzn, (String) null, zzd2, "_ev", zzD, i2);
                return;
            }
            Object zzB = this.zzt.zzv().zzB(str3, obj2);
            if (zzB != null) {
                zzN(str4, str2, j, zzB);
                return;
            }
            return;
        }
        zzN(str4, str2, j, (Object) null);
    }
}
