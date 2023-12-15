package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzcf;
import com.microsoft.appcenter.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.2 */
public final class zzjy extends zzf {
    /* access modifiers changed from: private */
    public final zzjx zza;
    /* access modifiers changed from: private */
    public zzek zzb;
    private volatile Boolean zzc;
    private final zzap zzd;
    private final zzkp zze;
    private final List zzf = new ArrayList();
    private final zzap zzg;

    protected zzjy(zzge zzge) {
        super(zzge);
        this.zze = new zzkp(zzge.zzax());
        this.zza = new zzjx(this);
        this.zzd = new zzji(this, zzge);
        this.zzg = new zzjk(this, zzge);
    }

    private final zzq zzO(boolean z) {
        Pair zza2;
        this.zzt.zzay();
        zzel zzh = this.zzt.zzh();
        String str = null;
        if (z) {
            zzeu zzaA = this.zzt.zzaA();
            if (!(zzaA.zzt.zzm().zzb == null || (zza2 = zzaA.zzt.zzm().zzb.zza()) == null || zza2 == zzfj.zza)) {
                str = String.valueOf(zza2.second) + Constants.COMMON_SCHEMA_PREFIX_SEPARATOR + ((String) zza2.first);
            }
        }
        return zzh.zzj(str);
    }

    /* access modifiers changed from: private */
    public final void zzP() {
        zzg();
        this.zzt.zzaA().zzj().zzb("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        for (Runnable run : this.zzf) {
            try {
                run.run();
            } catch (RuntimeException e) {
                this.zzt.zzaA().zzd().zzb("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zzb();
    }

    /* access modifiers changed from: private */
    public final void zzQ() {
        zzg();
        this.zze.zzb();
        zzap zzap = this.zzd;
        this.zzt.zzf();
        zzap.zzd(((Long) zzeh.zzJ.zza((Object) null)).longValue());
    }

    private final void zzR(Runnable runnable) throws IllegalStateException {
        zzg();
        if (zzL()) {
            runnable.run();
            return;
        }
        this.zzt.zzf();
        if (((long) this.zzf.size()) >= 1000) {
            this.zzt.zzaA().zzd().zza("Discarding data. Max runnable queue size reached");
            return;
        }
        this.zzf.add(runnable);
        this.zzg.zzd(60000);
        zzr();
    }

    private final boolean zzS() {
        this.zzt.zzay();
        return true;
    }

    static /* bridge */ /* synthetic */ void zzo(zzjy zzjy, ComponentName componentName) {
        zzjy.zzg();
        if (zzjy.zzb != null) {
            zzjy.zzb = null;
            zzjy.zzt.zzaA().zzj().zzb("Disconnected from device MeasurementService", componentName);
            zzjy.zzg();
            zzjy.zzr();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzA(zzaw zzaw, String str) {
        Preconditions.checkNotNull(zzaw);
        zzg();
        zza();
        zzS();
        zzR(new zzjn(this, true, zzO(true), this.zzt.zzi().zzo(zzaw), zzaw, str));
    }

    public final void zzB(zzcf zzcf, zzaw zzaw, String str) {
        zzg();
        zza();
        if (this.zzt.zzv().zzo(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            this.zzt.zzaA().zzk().zza("Not bundling data. Service unavailable or out of date");
            this.zzt.zzv().zzT(zzcf, new byte[0]);
            return;
        }
        zzR(new zzjj(this, zzaw, str, zzcf));
    }

    /* access modifiers changed from: protected */
    public final void zzC() {
        zzg();
        zza();
        zzq zzO = zzO(false);
        zzS();
        this.zzt.zzi().zzj();
        zzR(new zzjc(this, zzO));
    }

    /* access modifiers changed from: package-private */
    public final void zzD(zzek zzek, AbstractSafeParcelable abstractSafeParcelable, zzq zzq) {
        int i;
        zzg();
        zza();
        zzS();
        this.zzt.zzf();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            List zzi = this.zzt.zzi().zzi(100);
            if (zzi != null) {
                arrayList.addAll(zzi);
                i = zzi.size();
            } else {
                i = 0;
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) arrayList.get(i4);
                if (abstractSafeParcelable2 instanceof zzaw) {
                    try {
                        zzek.zzk((zzaw) abstractSafeParcelable2, zzq);
                    } catch (RemoteException e) {
                        this.zzt.zzaA().zzd().zzb("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzlj) {
                    try {
                        zzek.zzt((zzlj) abstractSafeParcelable2, zzq);
                    } catch (RemoteException e2) {
                        this.zzt.zzaA().zzd().zzb("Failed to send user property to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzac) {
                    try {
                        zzek.zzn((zzac) abstractSafeParcelable2, zzq);
                    } catch (RemoteException e3) {
                        this.zzt.zzaA().zzd().zzb("Failed to send conditional user property to the service", e3);
                    }
                } else {
                    this.zzt.zzaA().zzd().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzE(zzac zzac) {
        Preconditions.checkNotNull(zzac);
        zzg();
        zza();
        this.zzt.zzay();
        zzR(new zzjo(this, true, zzO(true), this.zzt.zzi().zzn(zzac), new zzac(zzac), zzac));
    }

    /* access modifiers changed from: protected */
    public final void zzF(boolean z) {
        zzg();
        zza();
        if (z) {
            zzS();
            this.zzt.zzi().zzj();
        }
        if (zzM()) {
            zzR(new zzjm(this, zzO(false)));
        }
    }

    /* access modifiers changed from: protected */
    public final void zzG(zziq zziq) {
        zzg();
        zza();
        zzR(new zzjg(this, zziq));
    }

    public final void zzH(Bundle bundle) {
        zzg();
        zza();
        zzR(new zzjh(this, zzO(false), bundle));
    }

    /* access modifiers changed from: protected */
    public final void zzI() {
        zzg();
        zza();
        zzR(new zzjl(this, zzO(true)));
    }

    /* access modifiers changed from: protected */
    public final void zzJ(zzek zzek) {
        zzg();
        Preconditions.checkNotNull(zzek);
        this.zzb = zzek;
        zzQ();
        zzP();
    }

    /* access modifiers changed from: protected */
    public final void zzK(zzlj zzlj) {
        zzg();
        zza();
        zzS();
        zzR(new zzjb(this, zzO(true), this.zzt.zzi().zzp(zzlj), zzlj));
    }

    public final boolean zzL() {
        zzg();
        zza();
        return this.zzb != null;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzM() {
        zzg();
        zza();
        if (!zzN() || this.zzt.zzv().zzm() >= ((Integer) zzeh.zzah.zza((Object) null)).intValue()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0129  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzN() {
        /*
            r6 = this;
            r6.zzg()
            r6.zza()
            java.lang.Boolean r0 = r6.zzc
            if (r0 != 0) goto L_0x0149
            r6.zzg()
            r6.zza()
            com.google.android.gms.measurement.internal.zzge r0 = r6.zzt
            com.google.android.gms.measurement.internal.zzfj r0 = r0.zzm()
            r0.zzg()
            android.content.SharedPreferences r1 = r0.zza()
            java.lang.String r2 = "use_service"
            boolean r1 = r1.contains(r2)
            r3 = 0
            if (r1 != 0) goto L_0x0028
            r0 = 0
            goto L_0x0034
        L_0x0028:
            android.content.SharedPreferences r0 = r0.zza()
            boolean r0 = r0.getBoolean(r2, r3)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L_0x0034:
            r1 = 1
            if (r0 == 0) goto L_0x003f
            boolean r4 = r0.booleanValue()
            if (r4 == 0) goto L_0x003f
            goto L_0x0143
        L_0x003f:
            com.google.android.gms.measurement.internal.zzge r4 = r6.zzt
            r4.zzay()
            com.google.android.gms.measurement.internal.zzge r4 = r6.zzt
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzh()
            int r4 = r4.zzh()
            if (r4 != r1) goto L_0x0053
        L_0x0050:
            r3 = 1
            goto L_0x010b
        L_0x0053:
            com.google.android.gms.measurement.internal.zzge r4 = r6.zzt
            com.google.android.gms.measurement.internal.zzeu r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzj()
            java.lang.String r5 = "Checking service availability"
            r4.zza(r5)
            com.google.android.gms.measurement.internal.zzge r4 = r6.zzt
            com.google.android.gms.measurement.internal.zzlo r4 = r4.zzv()
            r5 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r4 = r4.zzo(r5)
            if (r4 == 0) goto L_0x00fa
            if (r4 == r1) goto L_0x00ea
            r5 = 2
            if (r4 == r5) goto L_0x00c6
            r0 = 3
            if (r4 == r0) goto L_0x00b5
            r0 = 9
            if (r4 == r0) goto L_0x00a5
            r0 = 18
            if (r4 == r0) goto L_0x0095
            com.google.android.gms.measurement.internal.zzge r0 = r6.zzt
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzk()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            java.lang.String r4 = "Unexpected service status"
            r0.zzb(r4, r1)
            goto L_0x00c4
        L_0x0095:
            com.google.android.gms.measurement.internal.zzge r0 = r6.zzt
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzk()
            java.lang.String r3 = "Service updating"
            r0.zza(r3)
            goto L_0x0050
        L_0x00a5:
            com.google.android.gms.measurement.internal.zzge r0 = r6.zzt
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzk()
            java.lang.String r1 = "Service invalid"
            r0.zza(r1)
            goto L_0x00c4
        L_0x00b5:
            com.google.android.gms.measurement.internal.zzge r0 = r6.zzt
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzk()
            java.lang.String r1 = "Service disabled"
            r0.zza(r1)
        L_0x00c4:
            r1 = 0
            goto L_0x010b
        L_0x00c6:
            com.google.android.gms.measurement.internal.zzge r4 = r6.zzt
            com.google.android.gms.measurement.internal.zzeu r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzc()
            java.lang.String r5 = "Service container out of date"
            r4.zza(r5)
            com.google.android.gms.measurement.internal.zzge r4 = r6.zzt
            com.google.android.gms.measurement.internal.zzlo r4 = r4.zzv()
            int r4 = r4.zzm()
            r5 = 17443(0x4423, float:2.4443E-41)
            if (r4 >= r5) goto L_0x00e4
            goto L_0x010b
        L_0x00e4:
            if (r0 != 0) goto L_0x00e7
            goto L_0x00e8
        L_0x00e7:
            r1 = 0
        L_0x00e8:
            r3 = r1
            goto L_0x00c4
        L_0x00ea:
            com.google.android.gms.measurement.internal.zzge r0 = r6.zzt
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzj()
            java.lang.String r4 = "Service missing"
            r0.zza(r4)
            goto L_0x010b
        L_0x00fa:
            com.google.android.gms.measurement.internal.zzge r0 = r6.zzt
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzj()
            java.lang.String r3 = "Service available"
            r0.zza(r3)
            goto L_0x0050
        L_0x010b:
            if (r3 != 0) goto L_0x0129
            com.google.android.gms.measurement.internal.zzge r0 = r6.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            boolean r0 = r0.zzx()
            if (r0 == 0) goto L_0x0129
            com.google.android.gms.measurement.internal.zzge r0 = r6.zzt
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzd()
            java.lang.String r1 = "No way to upload. Consider using the full version of Analytics"
            r0.zza(r1)
            goto L_0x0142
        L_0x0129:
            if (r1 == 0) goto L_0x0142
            com.google.android.gms.measurement.internal.zzge r0 = r6.zzt
            com.google.android.gms.measurement.internal.zzfj r0 = r0.zzm()
            r0.zzg()
            android.content.SharedPreferences r0 = r0.zza()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.putBoolean(r2, r3)
            r0.apply()
        L_0x0142:
            r1 = r3
        L_0x0143:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r6.zzc = r0
        L_0x0149:
            java.lang.Boolean r0 = r6.zzc
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjy.zzN():boolean");
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzj() {
        return this.zzc;
    }

    /* access modifiers changed from: protected */
    public final void zzq() {
        zzg();
        zza();
        zzq zzO = zzO(true);
        this.zzt.zzi().zzk();
        zzR(new zzjf(this, zzO));
    }

    /* access modifiers changed from: package-private */
    public final void zzr() {
        zzg();
        zza();
        if (!zzL()) {
            if (zzN()) {
                this.zza.zzc();
            } else if (!this.zzt.zzf().zzx()) {
                this.zzt.zzay();
                List<ResolveInfo> queryIntentServices = this.zzt.zzaw().getPackageManager().queryIntentServices(new Intent().setClassName(this.zzt.zzaw(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                    this.zzt.zzaA().zzd().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                    return;
                }
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                Context zzaw = this.zzt.zzaw();
                this.zzt.zzay();
                intent.setComponent(new ComponentName(zzaw, "com.google.android.gms.measurement.AppMeasurementService"));
                this.zza.zzb(intent);
            }
        }
    }

    public final void zzs() {
        zzg();
        zza();
        this.zza.zzd();
        try {
            ConnectionTracker.getInstance().unbindService(this.zzt.zzaw(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    public final void zzt(zzcf zzcf) {
        zzg();
        zza();
        zzR(new zzje(this, zzO(false), zzcf));
    }

    public final void zzu(AtomicReference atomicReference) {
        zzg();
        zza();
        zzR(new zzjd(this, atomicReference, zzO(false)));
    }

    /* access modifiers changed from: protected */
    public final void zzv(zzcf zzcf, String str, String str2) {
        zzg();
        zza();
        zzR(new zzjq(this, str, str2, zzO(false), zzcf));
    }

    /* access modifiers changed from: protected */
    public final void zzw(AtomicReference atomicReference, String str, String str2, String str3) {
        zzg();
        zza();
        zzR(new zzjp(this, atomicReference, (String) null, str2, str3, zzO(false)));
    }

    /* access modifiers changed from: protected */
    public final void zzx(AtomicReference atomicReference, boolean z) {
        zzg();
        zza();
        zzR(new zzja(this, atomicReference, zzO(false), z));
    }

    /* access modifiers changed from: protected */
    public final void zzy(zzcf zzcf, String str, String str2, boolean z) {
        zzg();
        zza();
        zzR(new zziz(this, str, str2, zzO(false), z, zzcf));
    }

    /* access modifiers changed from: protected */
    public final void zzz(AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        zzg();
        zza();
        zzR(new zzjr(this, atomicReference, (String) null, str2, str3, zzO(false), z));
    }
}
