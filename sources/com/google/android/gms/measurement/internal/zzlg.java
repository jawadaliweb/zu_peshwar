package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zzop;
import com.google.android.gms.internal.measurement.zzpw;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.android.gms.internal.measurement.zzra;
import com.google.firebase.messaging.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.2 */
public final class zzlg implements zzgz {
    private static volatile zzlg zzb;
    private long zzA;
    private final Map zzB;
    private final Map zzC;
    private zziq zzD;
    private String zzE;
    private final zzln zzF = new zzlb(this);
    long zza;
    private final zzfv zzc;
    private final zzfa zzd;
    private zzam zze;
    private zzfc zzf;
    private zzkr zzg;
    private zzaa zzh;
    private final zzli zzi;
    private zzio zzj;
    private zzka zzk;
    private final zzkv zzl;
    private zzfm zzm;
    /* access modifiers changed from: private */
    public final zzge zzn;
    private boolean zzo = false;
    private boolean zzp;
    private List zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private FileLock zzw;
    private FileChannel zzx;
    private List zzy;
    private List zzz;

    zzlg(zzlh zzlh, zzge zzge) {
        Preconditions.checkNotNull(zzlh);
        this.zzn = zzge.zzp(zzlh.zza, (zzcl) null, (Long) null);
        this.zzA = -1;
        this.zzl = new zzkv(this);
        zzli zzli = new zzli(this);
        zzli.zzX();
        this.zzi = zzli;
        zzfa zzfa = new zzfa(this);
        zzfa.zzX();
        this.zzd = zzfa;
        zzfv zzfv = new zzfv(this);
        zzfv.zzX();
        this.zzc = zzfv;
        this.zzB = new HashMap();
        this.zzC = new HashMap();
        zzaB().zzp(new zzkw(this, zzlh));
    }

    static final void zzaa(zzfs zzfs, int i, String str) {
        List zzp2 = zzfs.zzp();
        int i2 = 0;
        while (i2 < zzp2.size()) {
            if (!"_err".equals(((zzfx) zzp2.get(i2)).zzg())) {
                i2++;
            } else {
                return;
            }
        }
        zzfw zze2 = zzfx.zze();
        zze2.zzj("_err");
        zze2.zzi(Long.valueOf((long) i).longValue());
        zzfw zze3 = zzfx.zze();
        zze3.zzj("_ev");
        zze3.zzk(str);
        zzfs.zzf((zzfx) zze2.zzaD());
        zzfs.zzf((zzfx) zze3.zzaD());
    }

    static final void zzab(zzfs zzfs, String str) {
        List zzp2 = zzfs.zzp();
        for (int i = 0; i < zzp2.size(); i++) {
            if (str.equals(((zzfx) zzp2.get(i)).zzg())) {
                zzfs.zzh(i);
                return;
            }
        }
    }

    private final zzq zzac(String str) {
        String str2 = str;
        zzam zzam = this.zze;
        zzal(zzam);
        zzh zzj2 = zzam.zzj(str2);
        if (zzj2 == null || TextUtils.isEmpty(zzj2.zzx())) {
            zzaA().zzc().zzb("No app data available; dropping", str2);
            return null;
        }
        Boolean zzad = zzad(zzj2);
        if (zzad == null || zzad.booleanValue()) {
            zzh zzh2 = zzj2;
            zzh2.zza();
            return new zzq(str, zzj2.zzz(), zzj2.zzx(), zzj2.zzb(), zzj2.zzw(), zzj2.zzm(), zzj2.zzj(), (String) null, zzj2.zzal(), false, zzj2.zzy(), 0, 0, 0, zzh2.zzak(), false, zzh2.zzs(), zzh2.zzr(), zzh2.zzk(), zzh2.zzD(), (String) null, zzh(str).zzh(), "", (String) null, zzh2.zzan(), zzh2.zzq());
        }
        zzaA().zzd().zzb("App version does not match; dropping. appId", zzeu.zzn(str));
        return null;
    }

    private final Boolean zzad(zzh zzh2) {
        try {
            if (zzh2.zzb() != -2147483648L) {
                if (zzh2.zzb() == ((long) Wrappers.packageManager(this.zzn.zzaw()).getPackageInfo(zzh2.zzu(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzn.zzaw()).getPackageInfo(zzh2.zzu(), 0).versionName;
                String zzx2 = zzh2.zzx();
                if (zzx2 != null && zzx2.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final void zzae() {
        zzaB().zzg();
        if (this.zzt || this.zzu || this.zzv) {
            zzaA().zzj().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv));
            return;
        }
        zzaA().zzj().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzq;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            ((List) Preconditions.checkNotNull(this.zzq)).clear();
        }
    }

    private final void zzaf(zzgc zzgc, long j, boolean z) {
        zzll zzll;
        zzam zzam = this.zze;
        zzal(zzam);
        String str = true != z ? "_lte" : "_se";
        zzll zzp2 = zzam.zzp(zzgc.zzaq(), str);
        if (zzp2 == null || zzp2.zze == null) {
            zzll = new zzll(zzgc.zzaq(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, zzax().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzll = new zzll(zzgc.zzaq(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, zzax().currentTimeMillis(), Long.valueOf(((Long) zzp2.zze).longValue() + j));
        }
        zzgl zzd2 = zzgm.zzd();
        zzd2.zzf(str);
        zzd2.zzg(zzax().currentTimeMillis());
        zzd2.zze(((Long) zzll.zze).longValue());
        zzgm zzgm = (zzgm) zzd2.zzaD();
        int zza2 = zzli.zza(zzgc, str);
        if (zza2 >= 0) {
            zzgc.zzan(zza2, zzgm);
        } else {
            zzgc.zzm(zzgm);
        }
        if (j > 0) {
            zzam zzam2 = this.zze;
            zzal(zzam2);
            zzam2.zzL(zzll);
            zzaA().zzj().zzc("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", zzll.zze);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0239  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzag() {
        /*
            r20 = this;
            r0 = r20
            com.google.android.gms.measurement.internal.zzgb r1 = r20.zzaB()
            r1.zzg()
            r20.zzB()
            long r1 = r0.zza
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004e
            r1 = 3600000(0x36ee80, double:1.7786363E-317)
            com.google.android.gms.common.util.Clock r5 = r20.zzax()
            long r5 = r5.elapsedRealtime()
            long r7 = r0.zza
            long r5 = r5 - r7
            long r5 = java.lang.Math.abs(r5)
            long r1 = r1 - r5
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004c
            com.google.android.gms.measurement.internal.zzeu r3 = r20.zzaA()
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzj()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r3.zzb(r2, r1)
            com.google.android.gms.measurement.internal.zzfc r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzkr r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        L_0x004c:
            r0.zza = r3
        L_0x004e:
            com.google.android.gms.measurement.internal.zzge r1 = r0.zzn
            boolean r1 = r1.zzM()
            if (r1 == 0) goto L_0x0256
            boolean r1 = r20.zzai()
            if (r1 != 0) goto L_0x005e
            goto L_0x0256
        L_0x005e:
            com.google.android.gms.common.util.Clock r1 = r20.zzax()
            long r1 = r1.currentTimeMillis()
            r20.zzg()
            com.google.android.gms.measurement.internal.zzeg r5 = com.google.android.gms.measurement.internal.zzeh.zzA
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzam r5 = r0.zze
            zzal(r5)
            boolean r5 = r5.zzH()
            r10 = 1
            if (r5 != 0) goto L_0x0093
            com.google.android.gms.measurement.internal.zzam r5 = r0.zze
            zzal(r5)
            boolean r5 = r5.zzG()
            if (r5 == 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r10 = 0
        L_0x0093:
            if (r10 == 0) goto L_0x00d3
            com.google.android.gms.measurement.internal.zzag r5 = r20.zzg()
            java.lang.String r5 = r5.zzl()
            boolean r11 = android.text.TextUtils.isEmpty(r5)
            if (r11 != 0) goto L_0x00bf
            java.lang.String r11 = ".none."
            boolean r5 = r11.equals(r5)
            if (r5 != 0) goto L_0x00bf
            r20.zzg()
            com.google.android.gms.measurement.internal.zzeg r5 = com.google.android.gms.measurement.internal.zzeh.zzv
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00bf:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzeg r5 = com.google.android.gms.measurement.internal.zzeh.zzu
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00d3:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzeg r5 = com.google.android.gms.measurement.internal.zzeh.zzt
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
        L_0x00e6:
            com.google.android.gms.measurement.internal.zzka r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzff r5 = r5.zzc
            long r13 = r5.zza()
            com.google.android.gms.measurement.internal.zzka r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzff r5 = r5.zzd
            long r15 = r5.zza()
            com.google.android.gms.measurement.internal.zzam r5 = r0.zze
            zzal(r5)
            r17 = r10
            long r9 = r5.zzd()
            com.google.android.gms.measurement.internal.zzam r5 = r0.zze
            zzal(r5)
            r18 = r7
            long r6 = r5.zze()
            long r5 = java.lang.Math.max(r9, r6)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x0117
        L_0x0114:
            r9 = r3
            goto L_0x0190
        L_0x0117:
            long r5 = r5 - r1
            long r5 = java.lang.Math.abs(r5)
            long r5 = r1 - r5
            long r13 = r13 - r1
            long r7 = java.lang.Math.abs(r13)
            long r7 = r1 - r7
            long r15 = r15 - r1
            long r9 = java.lang.Math.abs(r15)
            long r1 = r1 - r9
            long r9 = r5 + r18
            long r7 = java.lang.Math.max(r7, r1)
            if (r17 == 0) goto L_0x013c
            int r13 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x013c
            long r9 = java.lang.Math.min(r5, r7)
            long r9 = r9 + r11
        L_0x013c:
            com.google.android.gms.measurement.internal.zzli r13 = r0.zzi
            zzal(r13)
            boolean r13 = r13.zzw(r7, r11)
            if (r13 != 0) goto L_0x0149
            long r9 = r7 + r11
        L_0x0149:
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x0190
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x0190
            r5 = 0
        L_0x0152:
            r20.zzg()
            r6 = 20
            com.google.android.gms.measurement.internal.zzeg r7 = com.google.android.gms.measurement.internal.zzeh.zzC
            r8 = 0
            java.lang.Object r7 = r7.zza(r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r11 = 0
            int r7 = java.lang.Math.max(r11, r7)
            int r6 = java.lang.Math.min(r6, r7)
            if (r5 >= r6) goto L_0x0114
            r6 = 1
            long r6 = r6 << r5
            r20.zzg()
            com.google.android.gms.measurement.internal.zzeg r12 = com.google.android.gms.measurement.internal.zzeh.zzB
            java.lang.Object r12 = r12.zza(r8)
            java.lang.Long r12 = (java.lang.Long) r12
            long r12 = r12.longValue()
            long r12 = java.lang.Math.max(r3, r12)
            long r12 = r12 * r6
            long r9 = r9 + r12
            int r6 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x018d
            goto L_0x0190
        L_0x018d:
            int r5 = r5 + 1
            goto L_0x0152
        L_0x0190:
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0239
            com.google.android.gms.measurement.internal.zzfa r1 = r0.zzd
            zzal(r1)
            boolean r1 = r1.zza()
            if (r1 == 0) goto L_0x021c
            com.google.android.gms.measurement.internal.zzka r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzff r1 = r1.zzb
            long r1 = r1.zza()
            r20.zzg()
            com.google.android.gms.measurement.internal.zzeg r5 = com.google.android.gms.measurement.internal.zzeh.zzr
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzli r7 = r0.zzi
            zzal(r7)
            boolean r7 = r7.zzw(r1, r5)
            if (r7 != 0) goto L_0x01cb
            long r1 = r1 + r5
            long r9 = java.lang.Math.max(r9, r1)
        L_0x01cb:
            com.google.android.gms.measurement.internal.zzfc r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.common.util.Clock r1 = r20.zzax()
            long r1 = r1.currentTimeMillis()
            long r9 = r9 - r1
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0202
            r20.zzg()
            com.google.android.gms.measurement.internal.zzeg r1 = com.google.android.gms.measurement.internal.zzeh.zzw
            r2 = 0
            java.lang.Object r1 = r1.zza(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r9 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzka r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzff r1 = r1.zzc
            com.google.android.gms.common.util.Clock r2 = r20.zzax()
            long r2 = r2.currentTimeMillis()
            r1.zzb(r2)
        L_0x0202:
            com.google.android.gms.measurement.internal.zzeu r1 = r20.zzaA()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzj()
            java.lang.Long r2 = java.lang.Long.valueOf(r9)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.zzb(r3, r2)
            com.google.android.gms.measurement.internal.zzkr r1 = r0.zzg
            zzal(r1)
            r1.zzd(r9)
            return
        L_0x021c:
            com.google.android.gms.measurement.internal.zzeu r1 = r20.zzaA()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzj()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfc r1 = r20.zzm()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkr r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        L_0x0239:
            com.google.android.gms.measurement.internal.zzeu r1 = r20.zzaA()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzj()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfc r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzkr r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        L_0x0256:
            com.google.android.gms.measurement.internal.zzeu r1 = r20.zzaA()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzj()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfc r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzkr r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlg.zzag():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:360:0x0b36, code lost:
        if (r10 > (com.google.android.gms.measurement.internal.zzag.zzA() + r8)) goto L_0x0b38;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0383 A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccf }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0447 A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccf }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0489 A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccf }] */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x07d7 A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccf }] */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0820 A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccf }] */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0843 A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccf }] */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x08ba A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccf }] */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x08bc A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccf }] */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x08c4 A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccf }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x08f0 A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccf }] */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x0b26 A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccf }] */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0bad A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccf }] */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x0bc9 A[Catch:{ SQLiteException -> 0x0be1 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:55:0x01c0=Splitter:B:55:0x01c0, B:399:0x0cbd=Splitter:B:399:0x0cbd} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzah(java.lang.String r41, long r42) {
        /*
            r40 = this;
            r1 = r40
            java.lang.String r2 = "_npa"
            java.lang.String r3 = "_ai"
            com.google.android.gms.measurement.internal.zzam r4 = r1.zze
            zzal(r4)
            r4.zzw()
            com.google.android.gms.measurement.internal.zzld r4 = new com.google.android.gms.measurement.internal.zzld     // Catch:{ all -> 0x0ccf }
            r12 = 0
            r4.<init>(r1, r12)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0ccf }
            zzal(r5)     // Catch:{ all -> 0x0ccf }
            r6 = 0
            long r9 = r1.zzA     // Catch:{ all -> 0x0ccf }
            r7 = r42
            r11 = r4
            r5.zzU(r6, r7, r9, r11)     // Catch:{ all -> 0x0ccf }
            java.util.List r5 = r4.zzc     // Catch:{ all -> 0x0ccf }
            if (r5 == 0) goto L_0x0cbd
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0ccf }
            if (r5 == 0) goto L_0x002e
            goto L_0x0cbd
        L_0x002e:
            com.google.android.gms.internal.measurement.zzgd r5 = r4.zza     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzkx r5 = r5.zzbB()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgc r5 = (com.google.android.gms.internal.measurement.zzgc) r5     // Catch:{ all -> 0x0ccf }
            r5.zzr()     // Catch:{ all -> 0x0ccf }
            r11 = r12
            r14 = r11
            r8 = 0
            r9 = 0
            r10 = 0
            r13 = -1
            r15 = -1
        L_0x0040:
            java.util.List r12 = r4.zzc     // Catch:{ all -> 0x0ccf }
            int r12 = r12.size()     // Catch:{ all -> 0x0ccf }
            java.lang.String r6 = "_fr"
            java.lang.String r7 = "_et"
            r16 = r10
            java.lang.String r10 = "_e"
            r17 = r13
            r18 = r14
            if (r8 >= r12) goto L_0x04f9
            java.util.List r12 = r4.zzc     // Catch:{ all -> 0x0ccf }
            java.lang.Object r12 = r12.get(r8)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzft r12 = (com.google.android.gms.internal.measurement.zzft) r12     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzkx r12 = r12.zzbB()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfs r12 = (com.google.android.gms.internal.measurement.zzfs) r12     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzfv r14 = r1.zzc     // Catch:{ all -> 0x0ccf }
            zzal(r14)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgd r13 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r13 = r13.zzy()     // Catch:{ all -> 0x0ccf }
            r19 = r2
            java.lang.String r2 = r12.zzo()     // Catch:{ all -> 0x0ccf }
            boolean r2 = r14.zzr(r13, r2)     // Catch:{ all -> 0x0ccf }
            java.lang.String r13 = "_err"
            if (r2 == 0) goto L_0x00f7
            com.google.android.gms.measurement.internal.zzeu r2 = r40.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzk()     // Catch:{ all -> 0x0ccf }
            java.lang.String r6 = "Dropping blocked raw event. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0ccf }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeu.zzn(r7)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzge r10 = r1.zzn     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzep r10 = r10.zzj()     // Catch:{ all -> 0x0ccf }
            java.lang.String r14 = r12.zzo()     // Catch:{ all -> 0x0ccf }
            java.lang.String r10 = r10.zzd(r14)     // Catch:{ all -> 0x0ccf }
            r2.zzc(r6, r7, r10)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzfv r2 = r1.zzc     // Catch:{ all -> 0x0ccf }
            zzal(r2)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0ccf }
            boolean r2 = r2.zzp(r6)     // Catch:{ all -> 0x0ccf }
            if (r2 != 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.zzfv r2 = r1.zzc     // Catch:{ all -> 0x0ccf }
            zzal(r2)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0ccf }
            boolean r2 = r2.zzs(r6)     // Catch:{ all -> 0x0ccf }
            if (r2 == 0) goto L_0x00c3
            goto L_0x00e8
        L_0x00c3:
            java.lang.String r2 = r12.zzo()     // Catch:{ all -> 0x0ccf }
            boolean r2 = r13.equals(r2)     // Catch:{ all -> 0x0ccf }
            if (r2 != 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.zzlo r20 = r40.zzv()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzln r2 = r1.zzF     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r22 = r6.zzy()     // Catch:{ all -> 0x0ccf }
            r23 = 11
            java.lang.String r24 = "_ev"
            java.lang.String r25 = r12.zzo()     // Catch:{ all -> 0x0ccf }
            r26 = 0
            r21 = r2
            r20.zzO(r21, r22, r23, r24, r25, r26)     // Catch:{ all -> 0x0ccf }
        L_0x00e8:
            r21 = r3
            r6 = r8
            r23 = r11
            r10 = r16
            r13 = r17
            r14 = r18
            r11 = r5
            r5 = -1
            goto L_0x04ee
        L_0x00f7:
            java.lang.String r2 = r12.zzo()     // Catch:{ all -> 0x0ccf }
            java.lang.String r14 = com.google.android.gms.measurement.internal.zzhb.zza(r3)     // Catch:{ all -> 0x0ccf }
            boolean r2 = r2.equals(r14)     // Catch:{ all -> 0x0ccf }
            if (r2 == 0) goto L_0x016d
            r12.zzi(r3)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzeu r2 = r40.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzj()     // Catch:{ all -> 0x0ccf }
            java.lang.String r14 = "Renaming ad_impression to _ai"
            r2.zza(r14)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzeu r2 = r40.zzaA()     // Catch:{ all -> 0x0ccf }
            java.lang.String r2 = r2.zzr()     // Catch:{ all -> 0x0ccf }
            r14 = 5
            boolean r2 = android.util.Log.isLoggable(r2, r14)     // Catch:{ all -> 0x0ccf }
            if (r2 == 0) goto L_0x016d
            r2 = 0
        L_0x0125:
            int r14 = r12.zza()     // Catch:{ all -> 0x0ccf }
            if (r2 >= r14) goto L_0x016d
            java.lang.String r14 = "ad_platform"
            com.google.android.gms.internal.measurement.zzfx r20 = r12.zzn(r2)     // Catch:{ all -> 0x0ccf }
            r21 = r3
            java.lang.String r3 = r20.zzg()     // Catch:{ all -> 0x0ccf }
            boolean r3 = r14.equals(r3)     // Catch:{ all -> 0x0ccf }
            if (r3 == 0) goto L_0x0168
            com.google.android.gms.internal.measurement.zzfx r3 = r12.zzn(r2)     // Catch:{ all -> 0x0ccf }
            java.lang.String r3 = r3.zzh()     // Catch:{ all -> 0x0ccf }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0ccf }
            if (r3 != 0) goto L_0x0168
            java.lang.String r3 = "admob"
            com.google.android.gms.internal.measurement.zzfx r14 = r12.zzn(r2)     // Catch:{ all -> 0x0ccf }
            java.lang.String r14 = r14.zzh()     // Catch:{ all -> 0x0ccf }
            boolean r3 = r3.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0ccf }
            if (r3 == 0) goto L_0x0168
            com.google.android.gms.measurement.internal.zzeu r3 = r40.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzl()     // Catch:{ all -> 0x0ccf }
            java.lang.String r14 = "AdMob ad impression logged from app. Potentially duplicative."
            r3.zza(r14)     // Catch:{ all -> 0x0ccf }
        L_0x0168:
            int r2 = r2 + 1
            r3 = r21
            goto L_0x0125
        L_0x016d:
            r21 = r3
            com.google.android.gms.measurement.internal.zzfv r2 = r1.zzc     // Catch:{ all -> 0x0ccf }
            zzal(r2)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgd r3 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r3 = r3.zzy()     // Catch:{ all -> 0x0ccf }
            java.lang.String r14 = r12.zzo()     // Catch:{ all -> 0x0ccf }
            boolean r2 = r2.zzq(r3, r14)     // Catch:{ all -> 0x0ccf }
            java.lang.String r3 = "_c"
            if (r2 != 0) goto L_0x01b7
            com.google.android.gms.measurement.internal.zzli r14 = r1.zzi     // Catch:{ all -> 0x0ccf }
            zzal(r14)     // Catch:{ all -> 0x0ccf }
            java.lang.String r14 = r12.zzo()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)     // Catch:{ all -> 0x0ccf }
            r20 = r9
            int r9 = r14.hashCode()     // Catch:{ all -> 0x0ccf }
            r22 = r8
            r8 = 95027(0x17333, float:1.33161E-40)
            if (r9 == r8) goto L_0x01a0
            goto L_0x01aa
        L_0x01a0:
            java.lang.String r8 = "_ui"
            boolean r8 = r14.equals(r8)
            if (r8 == 0) goto L_0x01aa
            r8 = 0
            goto L_0x01ab
        L_0x01aa:
            r8 = -1
        L_0x01ab:
            if (r8 == 0) goto L_0x01bb
            r25 = r6
            r24 = r7
            r23 = r11
            r2 = 0
            r11 = r5
            goto L_0x0381
        L_0x01b7:
            r22 = r8
            r20 = r9
        L_0x01bb:
            r23 = r11
            r8 = 0
            r9 = 0
            r14 = 0
        L_0x01c0:
            int r11 = r12.zza()     // Catch:{ all -> 0x0ccf }
            r24 = r7
            java.lang.String r7 = "_r"
            if (r8 >= r11) goto L_0x0227
            com.google.android.gms.internal.measurement.zzfx r11 = r12.zzn(r8)     // Catch:{ all -> 0x0ccf }
            java.lang.String r11 = r11.zzg()     // Catch:{ all -> 0x0ccf }
            boolean r11 = r3.equals(r11)     // Catch:{ all -> 0x0ccf }
            if (r11 == 0) goto L_0x01f5
            com.google.android.gms.internal.measurement.zzfx r7 = r12.zzn(r8)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzkx r7 = r7.zzbB()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfw r7 = (com.google.android.gms.internal.measurement.zzfw) r7     // Catch:{ all -> 0x0ccf }
            r11 = r5
            r25 = r6
            r5 = 1
            r7.zzi(r5)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzlb r5 = r7.zzaD()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0ccf }
            r12.zzk(r8, r5)     // Catch:{ all -> 0x0ccf }
            r9 = 1
            goto L_0x021f
        L_0x01f5:
            r11 = r5
            r25 = r6
            com.google.android.gms.internal.measurement.zzfx r5 = r12.zzn(r8)     // Catch:{ all -> 0x0ccf }
            java.lang.String r5 = r5.zzg()     // Catch:{ all -> 0x0ccf }
            boolean r5 = r7.equals(r5)     // Catch:{ all -> 0x0ccf }
            if (r5 == 0) goto L_0x021f
            com.google.android.gms.internal.measurement.zzfx r5 = r12.zzn(r8)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzkx r5 = r5.zzbB()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0ccf }
            r6 = 1
            r5.zzi(r6)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzlb r5 = r5.zzaD()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0ccf }
            r12.zzk(r8, r5)     // Catch:{ all -> 0x0ccf }
            r14 = 1
        L_0x021f:
            int r8 = r8 + 1
            r5 = r11
            r7 = r24
            r6 = r25
            goto L_0x01c0
        L_0x0227:
            r11 = r5
            r25 = r6
            if (r9 != 0) goto L_0x0258
            if (r2 == 0) goto L_0x0258
            com.google.android.gms.measurement.internal.zzeu r5 = r40.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r5 = r5.zzj()     // Catch:{ all -> 0x0ccf }
            java.lang.String r6 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzge r8 = r1.zzn     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzep r8 = r8.zzj()     // Catch:{ all -> 0x0ccf }
            java.lang.String r9 = r12.zzo()     // Catch:{ all -> 0x0ccf }
            java.lang.String r8 = r8.zzd(r9)     // Catch:{ all -> 0x0ccf }
            r5.zzb(r6, r8)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfw r5 = com.google.android.gms.internal.measurement.zzfx.zze()     // Catch:{ all -> 0x0ccf }
            r5.zzj(r3)     // Catch:{ all -> 0x0ccf }
            r8 = 1
            r5.zzi(r8)     // Catch:{ all -> 0x0ccf }
            r12.zze(r5)     // Catch:{ all -> 0x0ccf }
        L_0x0258:
            if (r14 != 0) goto L_0x0284
            com.google.android.gms.measurement.internal.zzeu r5 = r40.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r5 = r5.zzj()     // Catch:{ all -> 0x0ccf }
            java.lang.String r6 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzge r8 = r1.zzn     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzep r8 = r8.zzj()     // Catch:{ all -> 0x0ccf }
            java.lang.String r9 = r12.zzo()     // Catch:{ all -> 0x0ccf }
            java.lang.String r8 = r8.zzd(r9)     // Catch:{ all -> 0x0ccf }
            r5.zzb(r6, r8)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfw r5 = com.google.android.gms.internal.measurement.zzfx.zze()     // Catch:{ all -> 0x0ccf }
            r5.zzj(r7)     // Catch:{ all -> 0x0ccf }
            r8 = 1
            r5.zzi(r8)     // Catch:{ all -> 0x0ccf }
            r12.zze(r5)     // Catch:{ all -> 0x0ccf }
        L_0x0284:
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0ccf }
            zzal(r5)     // Catch:{ all -> 0x0ccf }
            long r27 = r40.zza()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r29 = r6.zzy()     // Catch:{ all -> 0x0ccf }
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 1
            r26 = r5
            com.google.android.gms.measurement.internal.zzak r5 = r26.zzl(r27, r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x0ccf }
            long r5 = r5.zze     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzag r8 = r40.zzg()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgd r9 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r9 = r9.zzy()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzeg r14 = com.google.android.gms.measurement.internal.zzeh.zzo     // Catch:{ all -> 0x0ccf }
            int r8 = r8.zze(r9, r14)     // Catch:{ all -> 0x0ccf }
            long r8 = (long) r8     // Catch:{ all -> 0x0ccf }
            int r14 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r14 <= 0) goto L_0x02be
            zzab(r12, r7)     // Catch:{ all -> 0x0ccf }
            goto L_0x02c0
        L_0x02be:
            r16 = 1
        L_0x02c0:
            java.lang.String r5 = r12.zzo()     // Catch:{ all -> 0x0ccf }
            boolean r5 = com.google.android.gms.measurement.internal.zzlo.zzak(r5)     // Catch:{ all -> 0x0ccf }
            if (r5 == 0) goto L_0x0381
            if (r2 == 0) goto L_0x0381
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0ccf }
            zzal(r5)     // Catch:{ all -> 0x0ccf }
            long r27 = r40.zza()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r29 = r6.zzy()     // Catch:{ all -> 0x0ccf }
            r30 = 0
            r31 = 0
            r32 = 1
            r33 = 0
            r34 = 0
            r26 = r5
            com.google.android.gms.measurement.internal.zzak r5 = r26.zzl(r27, r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x0ccf }
            long r5 = r5.zzc     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzag r7 = r40.zzg()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgd r8 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r8 = r8.zzy()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzeg r9 = com.google.android.gms.measurement.internal.zzeh.zzn     // Catch:{ all -> 0x0ccf }
            int r7 = r7.zze(r8, r9)     // Catch:{ all -> 0x0ccf }
            long r7 = (long) r7     // Catch:{ all -> 0x0ccf }
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0381
            com.google.android.gms.measurement.internal.zzeu r5 = r40.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r5 = r5.zzk()     // Catch:{ all -> 0x0ccf }
            java.lang.String r6 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0ccf }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeu.zzn(r7)     // Catch:{ all -> 0x0ccf }
            r5.zzb(r6, r7)     // Catch:{ all -> 0x0ccf }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = -1
        L_0x031d:
            int r9 = r12.zza()     // Catch:{ all -> 0x0ccf }
            if (r6 >= r9) goto L_0x0347
            com.google.android.gms.internal.measurement.zzfx r9 = r12.zzn(r6)     // Catch:{ all -> 0x0ccf }
            java.lang.String r14 = r9.zzg()     // Catch:{ all -> 0x0ccf }
            boolean r14 = r3.equals(r14)     // Catch:{ all -> 0x0ccf }
            if (r14 == 0) goto L_0x0339
            com.google.android.gms.internal.measurement.zzkx r5 = r9.zzbB()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0ccf }
            r8 = r6
            goto L_0x0344
        L_0x0339:
            java.lang.String r9 = r9.zzg()     // Catch:{ all -> 0x0ccf }
            boolean r9 = r13.equals(r9)     // Catch:{ all -> 0x0ccf }
            if (r9 == 0) goto L_0x0344
            r7 = 1
        L_0x0344:
            int r6 = r6 + 1
            goto L_0x031d
        L_0x0347:
            if (r7 == 0) goto L_0x0350
            if (r5 == 0) goto L_0x034f
            r12.zzh(r8)     // Catch:{ all -> 0x0ccf }
            goto L_0x0381
        L_0x034f:
            r5 = 0
        L_0x0350:
            if (r5 == 0) goto L_0x036a
            com.google.android.gms.internal.measurement.zzkx r5 = r5.zzav()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0ccf }
            r5.zzj(r13)     // Catch:{ all -> 0x0ccf }
            r6 = 10
            r5.zzi(r6)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzlb r5 = r5.zzaD()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0ccf }
            r12.zzk(r8, r5)     // Catch:{ all -> 0x0ccf }
            goto L_0x0381
        L_0x036a:
            com.google.android.gms.measurement.internal.zzeu r5 = r40.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r5 = r5.zzd()     // Catch:{ all -> 0x0ccf }
            java.lang.String r6 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0ccf }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeu.zzn(r7)     // Catch:{ all -> 0x0ccf }
            r5.zzb(r6, r7)     // Catch:{ all -> 0x0ccf }
        L_0x0381:
            if (r2 == 0) goto L_0x043a
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0ccf }
            java.util.List r5 = r12.zzp()     // Catch:{ all -> 0x0ccf }
            r2.<init>(r5)     // Catch:{ all -> 0x0ccf }
            r5 = 0
            r6 = -1
            r7 = -1
        L_0x038f:
            int r8 = r2.size()     // Catch:{ all -> 0x0ccf }
            java.lang.String r9 = "currency"
            java.lang.String r13 = "value"
            if (r5 >= r8) goto L_0x03bf
            java.lang.Object r8 = r2.get(r5)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfx r8 = (com.google.android.gms.internal.measurement.zzfx) r8     // Catch:{ all -> 0x0ccf }
            java.lang.String r8 = r8.zzg()     // Catch:{ all -> 0x0ccf }
            boolean r8 = r13.equals(r8)     // Catch:{ all -> 0x0ccf }
            if (r8 == 0) goto L_0x03ab
            r6 = r5
            goto L_0x03bc
        L_0x03ab:
            java.lang.Object r8 = r2.get(r5)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfx r8 = (com.google.android.gms.internal.measurement.zzfx) r8     // Catch:{ all -> 0x0ccf }
            java.lang.String r8 = r8.zzg()     // Catch:{ all -> 0x0ccf }
            boolean r8 = r9.equals(r8)     // Catch:{ all -> 0x0ccf }
            if (r8 == 0) goto L_0x03bc
            r7 = r5
        L_0x03bc:
            int r5 = r5 + 1
            goto L_0x038f
        L_0x03bf:
            r5 = -1
            if (r6 != r5) goto L_0x03c4
            goto L_0x043b
        L_0x03c4:
            java.lang.Object r5 = r2.get(r6)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0ccf }
            boolean r5 = r5.zzw()     // Catch:{ all -> 0x0ccf }
            if (r5 != 0) goto L_0x03f5
            java.lang.Object r5 = r2.get(r6)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0ccf }
            boolean r5 = r5.zzu()     // Catch:{ all -> 0x0ccf }
            if (r5 != 0) goto L_0x03f5
            com.google.android.gms.measurement.internal.zzeu r2 = r40.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzl()     // Catch:{ all -> 0x0ccf }
            java.lang.String r5 = "Value must be specified with a numeric type."
            r2.zza(r5)     // Catch:{ all -> 0x0ccf }
            r12.zzh(r6)     // Catch:{ all -> 0x0ccf }
            zzab(r12, r3)     // Catch:{ all -> 0x0ccf }
            r2 = 18
            zzaa(r12, r2, r13)     // Catch:{ all -> 0x0ccf }
            goto L_0x043a
        L_0x03f5:
            r5 = -1
            if (r7 != r5) goto L_0x03f9
            goto L_0x0421
        L_0x03f9:
            java.lang.Object r2 = r2.get(r7)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfx r2 = (com.google.android.gms.internal.measurement.zzfx) r2     // Catch:{ all -> 0x0ccf }
            java.lang.String r2 = r2.zzh()     // Catch:{ all -> 0x0ccf }
            int r7 = r2.length()     // Catch:{ all -> 0x0ccf }
            r8 = 3
            if (r7 != r8) goto L_0x0421
            r7 = 0
        L_0x040b:
            int r8 = r2.length()     // Catch:{ all -> 0x0ccf }
            if (r7 >= r8) goto L_0x043b
            int r8 = r2.codePointAt(r7)     // Catch:{ all -> 0x0ccf }
            boolean r13 = java.lang.Character.isLetter(r8)     // Catch:{ all -> 0x0ccf }
            if (r13 == 0) goto L_0x0421
            int r8 = java.lang.Character.charCount(r8)     // Catch:{ all -> 0x0ccf }
            int r7 = r7 + r8
            goto L_0x040b
        L_0x0421:
            com.google.android.gms.measurement.internal.zzeu r2 = r40.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzl()     // Catch:{ all -> 0x0ccf }
            java.lang.String r7 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r7)     // Catch:{ all -> 0x0ccf }
            r12.zzh(r6)     // Catch:{ all -> 0x0ccf }
            zzab(r12, r3)     // Catch:{ all -> 0x0ccf }
            r2 = 19
            zzaa(r12, r2, r9)     // Catch:{ all -> 0x0ccf }
            goto L_0x043b
        L_0x043a:
            r5 = -1
        L_0x043b:
            java.lang.String r2 = r12.zzo()     // Catch:{ all -> 0x0ccf }
            boolean r2 = r10.equals(r2)     // Catch:{ all -> 0x0ccf }
            r6 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x0489
            com.google.android.gms.measurement.internal.zzli r2 = r1.zzi     // Catch:{ all -> 0x0ccf }
            zzal(r2)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzlb r2 = r12.zzaD()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch:{ all -> 0x0ccf }
            r3 = r25
            com.google.android.gms.internal.measurement.zzfx r2 = com.google.android.gms.measurement.internal.zzli.zzB(r2, r3)     // Catch:{ all -> 0x0ccf }
            if (r2 != 0) goto L_0x04d5
            if (r18 == 0) goto L_0x0482
            long r2 = r18.zzc()     // Catch:{ all -> 0x0ccf }
            long r8 = r12.zzc()     // Catch:{ all -> 0x0ccf }
            long r2 = r2 - r8
            long r2 = java.lang.Math.abs(r2)     // Catch:{ all -> 0x0ccf }
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x0482
            com.google.android.gms.internal.measurement.zzkx r2 = r18.zzav()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0ccf }
            boolean r3 = r1.zzaj(r12, r2)     // Catch:{ all -> 0x0ccf }
            if (r3 == 0) goto L_0x0482
            r11.zzS(r15, r2)     // Catch:{ all -> 0x0ccf }
            r13 = r17
        L_0x047e:
            r14 = 0
            r23 = 0
            goto L_0x04da
        L_0x0482:
            r23 = r12
            r14 = r18
            r13 = r20
            goto L_0x04da
        L_0x0489:
            java.lang.String r2 = "_vs"
            java.lang.String r3 = r12.zzo()     // Catch:{ all -> 0x0ccf }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0ccf }
            if (r2 == 0) goto L_0x04d5
            com.google.android.gms.measurement.internal.zzli r2 = r1.zzi     // Catch:{ all -> 0x0ccf }
            zzal(r2)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzlb r2 = r12.zzaD()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch:{ all -> 0x0ccf }
            r8 = r24
            com.google.android.gms.internal.measurement.zzfx r2 = com.google.android.gms.measurement.internal.zzli.zzB(r2, r8)     // Catch:{ all -> 0x0ccf }
            if (r2 != 0) goto L_0x04d5
            if (r23 == 0) goto L_0x04ce
            long r2 = r23.zzc()     // Catch:{ all -> 0x0ccf }
            long r8 = r12.zzc()     // Catch:{ all -> 0x0ccf }
            long r2 = r2 - r8
            long r2 = java.lang.Math.abs(r2)     // Catch:{ all -> 0x0ccf }
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x04ce
            com.google.android.gms.internal.measurement.zzkx r2 = r23.zzav()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0ccf }
            boolean r3 = r1.zzaj(r2, r12)     // Catch:{ all -> 0x0ccf }
            if (r3 == 0) goto L_0x04ce
            r7 = r17
            r11.zzS(r7, r2)     // Catch:{ all -> 0x0ccf }
            r13 = r7
            goto L_0x047e
        L_0x04ce:
            r7 = r17
            r13 = r7
            r14 = r12
            r15 = r20
            goto L_0x04da
        L_0x04d5:
            r7 = r17
            r13 = r7
            r14 = r18
        L_0x04da:
            java.util.List r2 = r4.zzc     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzlb r3 = r12.zzaD()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzft r3 = (com.google.android.gms.internal.measurement.zzft) r3     // Catch:{ all -> 0x0ccf }
            r6 = r22
            r2.set(r6, r3)     // Catch:{ all -> 0x0ccf }
            int r9 = r20 + 1
            r11.zzk(r12)     // Catch:{ all -> 0x0ccf }
            r10 = r16
        L_0x04ee:
            int r8 = r6 + 1
            r5 = r11
            r2 = r19
            r3 = r21
            r11 = r23
            goto L_0x0040
        L_0x04f9:
            r19 = r2
            r11 = r5
            r3 = r6
            r8 = r7
            r20 = r9
            r5 = 0
            r12 = r5
            r2 = 0
        L_0x0504:
            if (r2 >= r9) goto L_0x0554
            com.google.android.gms.internal.measurement.zzft r7 = r11.zze(r2)     // Catch:{ all -> 0x0ccf }
            java.lang.String r14 = r7.zzh()     // Catch:{ all -> 0x0ccf }
            boolean r14 = r10.equals(r14)     // Catch:{ all -> 0x0ccf }
            if (r14 == 0) goto L_0x0527
            com.google.android.gms.measurement.internal.zzli r14 = r1.zzi     // Catch:{ all -> 0x0ccf }
            zzal(r14)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfx r14 = com.google.android.gms.measurement.internal.zzli.zzB(r7, r3)     // Catch:{ all -> 0x0ccf }
            if (r14 == 0) goto L_0x0527
            r11.zzA(r2)     // Catch:{ all -> 0x0ccf }
            int r9 = r9 + -1
            int r2 = r2 + -1
            goto L_0x0551
        L_0x0527:
            com.google.android.gms.measurement.internal.zzli r14 = r1.zzi     // Catch:{ all -> 0x0ccf }
            zzal(r14)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfx r7 = com.google.android.gms.measurement.internal.zzli.zzB(r7, r8)     // Catch:{ all -> 0x0ccf }
            if (r7 == 0) goto L_0x0551
            boolean r14 = r7.zzw()     // Catch:{ all -> 0x0ccf }
            if (r14 == 0) goto L_0x0541
            long r14 = r7.zzd()     // Catch:{ all -> 0x0ccf }
            java.lang.Long r7 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0ccf }
            goto L_0x0542
        L_0x0541:
            r7 = 0
        L_0x0542:
            if (r7 == 0) goto L_0x0551
            long r14 = r7.longValue()     // Catch:{ all -> 0x0ccf }
            int r17 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r17 <= 0) goto L_0x0551
            long r14 = r7.longValue()     // Catch:{ all -> 0x0ccf }
            long r12 = r12 + r14
        L_0x0551:
            r7 = 1
            int r2 = r2 + r7
            goto L_0x0504
        L_0x0554:
            r2 = 0
            r1.zzaf(r11, r12, r2)     // Catch:{ all -> 0x0ccf }
            java.util.List r2 = r11.zzat()     // Catch:{ all -> 0x0ccf }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0ccf }
        L_0x0560:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0ccf }
            java.lang.String r7 = "_se"
            if (r3 == 0) goto L_0x0586
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzft r3 = (com.google.android.gms.internal.measurement.zzft) r3     // Catch:{ all -> 0x0ccf }
            java.lang.String r8 = "_s"
            java.lang.String r3 = r3.zzh()     // Catch:{ all -> 0x0ccf }
            boolean r3 = r8.equals(r3)     // Catch:{ all -> 0x0ccf }
            if (r3 == 0) goto L_0x0560
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0ccf }
            zzal(r2)     // Catch:{ all -> 0x0ccf }
            java.lang.String r3 = r11.zzaq()     // Catch:{ all -> 0x0ccf }
            r2.zzA(r3, r7)     // Catch:{ all -> 0x0ccf }
        L_0x0586:
            java.lang.String r2 = "_sid"
            int r2 = com.google.android.gms.measurement.internal.zzli.zza(r11, r2)     // Catch:{ all -> 0x0ccf }
            if (r2 < 0) goto L_0x0593
            r2 = 1
            r1.zzaf(r11, r12, r2)     // Catch:{ all -> 0x0ccf }
            goto L_0x05b3
        L_0x0593:
            int r2 = com.google.android.gms.measurement.internal.zzli.zza(r11, r7)     // Catch:{ all -> 0x0ccf }
            if (r2 < 0) goto L_0x05b3
            r11.zzB(r2)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzeu r2 = r40.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzd()     // Catch:{ all -> 0x0ccf }
            java.lang.String r3 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0ccf }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeu.zzn(r7)     // Catch:{ all -> 0x0ccf }
            r2.zzb(r3, r7)     // Catch:{ all -> 0x0ccf }
        L_0x05b3:
            com.google.android.gms.measurement.internal.zzli r2 = r1.zzi     // Catch:{ all -> 0x0ccf }
            zzal(r2)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzge r3 = r2.zzt     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzeu r3 = r3.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzj()     // Catch:{ all -> 0x0ccf }
            java.lang.String r7 = "Checking account type status for ad personalization signals"
            r3.zza(r7)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzlg r3 = r2.zzf     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzfv r3 = r3.zzc     // Catch:{ all -> 0x0ccf }
            zzal(r3)     // Catch:{ all -> 0x0ccf }
            java.lang.String r7 = r11.zzaq()     // Catch:{ all -> 0x0ccf }
            boolean r3 = r3.zzn(r7)     // Catch:{ all -> 0x0ccf }
            if (r3 == 0) goto L_0x064a
            com.google.android.gms.measurement.internal.zzlg r3 = r2.zzf     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzam r3 = r3.zze     // Catch:{ all -> 0x0ccf }
            zzal(r3)     // Catch:{ all -> 0x0ccf }
            java.lang.String r7 = r11.zzaq()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzh r3 = r3.zzj(r7)     // Catch:{ all -> 0x0ccf }
            if (r3 == 0) goto L_0x064a
            boolean r3 = r3.zzak()     // Catch:{ all -> 0x0ccf }
            if (r3 == 0) goto L_0x064a
            com.google.android.gms.measurement.internal.zzge r3 = r2.zzt     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzaq r3 = r3.zzg()     // Catch:{ all -> 0x0ccf }
            boolean r3 = r3.zze()     // Catch:{ all -> 0x0ccf }
            if (r3 == 0) goto L_0x064a
            com.google.android.gms.measurement.internal.zzge r3 = r2.zzt     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzeu r3 = r3.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzc()     // Catch:{ all -> 0x0ccf }
            java.lang.String r7 = "Turning off ad personalization due to account type"
            r3.zza(r7)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgl r3 = com.google.android.gms.internal.measurement.zzgm.zzd()     // Catch:{ all -> 0x0ccf }
            r7 = r19
            r3.zzf(r7)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzge r2 = r2.zzt     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzaq r2 = r2.zzg()     // Catch:{ all -> 0x0ccf }
            long r8 = r2.zza()     // Catch:{ all -> 0x0ccf }
            r3.zzg(r8)     // Catch:{ all -> 0x0ccf }
            r8 = 1
            r3.zze(r8)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzlb r2 = r3.zzaD()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgm r2 = (com.google.android.gms.internal.measurement.zzgm) r2     // Catch:{ all -> 0x0ccf }
            r3 = 0
        L_0x062c:
            int r8 = r11.zzb()     // Catch:{ all -> 0x0ccf }
            if (r3 >= r8) goto L_0x0647
            com.google.android.gms.internal.measurement.zzgm r8 = r11.zzap(r3)     // Catch:{ all -> 0x0ccf }
            java.lang.String r8 = r8.zzf()     // Catch:{ all -> 0x0ccf }
            boolean r8 = r7.equals(r8)     // Catch:{ all -> 0x0ccf }
            if (r8 == 0) goto L_0x0644
            r11.zzan(r3, r2)     // Catch:{ all -> 0x0ccf }
            goto L_0x064a
        L_0x0644:
            int r3 = r3 + 1
            goto L_0x062c
        L_0x0647:
            r11.zzm(r2)     // Catch:{ all -> 0x0ccf }
        L_0x064a:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r11.zzai(r2)     // Catch:{ all -> 0x0ccf }
            r2 = -9223372036854775808
            r11.zzQ(r2)     // Catch:{ all -> 0x0ccf }
            r2 = 0
        L_0x0658:
            int r3 = r11.zza()     // Catch:{ all -> 0x0ccf }
            if (r2 >= r3) goto L_0x068b
            com.google.android.gms.internal.measurement.zzft r3 = r11.zze(r2)     // Catch:{ all -> 0x0ccf }
            long r7 = r3.zzd()     // Catch:{ all -> 0x0ccf }
            long r9 = r11.zzd()     // Catch:{ all -> 0x0ccf }
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 >= 0) goto L_0x0675
            long r7 = r3.zzd()     // Catch:{ all -> 0x0ccf }
            r11.zzai(r7)     // Catch:{ all -> 0x0ccf }
        L_0x0675:
            long r7 = r3.zzd()     // Catch:{ all -> 0x0ccf }
            long r9 = r11.zzc()     // Catch:{ all -> 0x0ccf }
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 <= 0) goto L_0x0688
            long r7 = r3.zzd()     // Catch:{ all -> 0x0ccf }
            r11.zzQ(r7)     // Catch:{ all -> 0x0ccf }
        L_0x0688:
            int r2 = r2 + 1
            goto L_0x0658
        L_0x068b:
            r11.zzz()     // Catch:{ all -> 0x0ccf }
            r11.zzo()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzaa r2 = r1.zzh     // Catch:{ all -> 0x0ccf }
            zzal(r2)     // Catch:{ all -> 0x0ccf }
            java.lang.String r20 = r11.zzaq()     // Catch:{ all -> 0x0ccf }
            java.util.List r21 = r11.zzat()     // Catch:{ all -> 0x0ccf }
            java.util.List r22 = r11.zzau()     // Catch:{ all -> 0x0ccf }
            long r7 = r11.zzd()     // Catch:{ all -> 0x0ccf }
            java.lang.Long r23 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0ccf }
            long r7 = r11.zzc()     // Catch:{ all -> 0x0ccf }
            java.lang.Long r24 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0ccf }
            r19 = r2
            java.util.List r2 = r19.zza(r20, r21, r22, r23, r24)     // Catch:{ all -> 0x0ccf }
            r11.zzf(r2)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzag r2 = r40.zzg()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgd r3 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r3 = r3.zzy()     // Catch:{ all -> 0x0ccf }
            boolean r2 = r2.zzw(r3)     // Catch:{ all -> 0x0ccf }
            if (r2 == 0) goto L_0x0a0a
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0ccf }
            r2.<init>()     // Catch:{ all -> 0x0ccf }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0ccf }
            r3.<init>()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzlo r7 = r40.zzv()     // Catch:{ all -> 0x0ccf }
            java.security.SecureRandom r7 = r7.zzG()     // Catch:{ all -> 0x0ccf }
            r8 = 0
        L_0x06de:
            int r9 = r11.zza()     // Catch:{ all -> 0x0ccf }
            if (r8 >= r9) goto L_0x09d4
            com.google.android.gms.internal.measurement.zzft r9 = r11.zze(r8)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzkx r9 = r9.zzbB()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfs r9 = (com.google.android.gms.internal.measurement.zzfs) r9     // Catch:{ all -> 0x0ccf }
            java.lang.String r10 = r9.zzo()     // Catch:{ all -> 0x0ccf }
            java.lang.String r12 = "_ep"
            boolean r10 = r10.equals(r12)     // Catch:{ all -> 0x0ccf }
            java.lang.String r12 = "_efs"
            java.lang.String r13 = "_sr"
            if (r10 == 0) goto L_0x0780
            com.google.android.gms.measurement.internal.zzli r10 = r1.zzi     // Catch:{ all -> 0x0ccf }
            zzal(r10)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzlb r10 = r9.zzaD()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzft r10 = (com.google.android.gms.internal.measurement.zzft) r10     // Catch:{ all -> 0x0ccf }
            java.lang.String r14 = "_en"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzli.zzC(r10, r14)     // Catch:{ all -> 0x0ccf }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0ccf }
            java.lang.Object r14 = r2.get(r10)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzas r14 = (com.google.android.gms.measurement.internal.zzas) r14     // Catch:{ all -> 0x0ccf }
            if (r14 != 0) goto L_0x0735
            com.google.android.gms.measurement.internal.zzam r14 = r1.zze     // Catch:{ all -> 0x0ccf }
            zzal(r14)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgd r15 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r15 = r15.zzy()     // Catch:{ all -> 0x0ccf }
            java.lang.Object r17 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)     // Catch:{ all -> 0x0ccf }
            r5 = r17
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzas r14 = r14.zzn(r15, r5)     // Catch:{ all -> 0x0ccf }
            if (r14 == 0) goto L_0x0735
            r2.put(r10, r14)     // Catch:{ all -> 0x0ccf }
        L_0x0735:
            if (r14 == 0) goto L_0x0774
            java.lang.Long r5 = r14.zzi     // Catch:{ all -> 0x0ccf }
            if (r5 != 0) goto L_0x0774
            java.lang.Long r5 = r14.zzj     // Catch:{ all -> 0x0ccf }
            if (r5 == 0) goto L_0x0753
            long r5 = r5.longValue()     // Catch:{ all -> 0x0ccf }
            r17 = 1
            int r10 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
            if (r10 <= 0) goto L_0x0753
            com.google.android.gms.measurement.internal.zzli r5 = r1.zzi     // Catch:{ all -> 0x0ccf }
            zzal(r5)     // Catch:{ all -> 0x0ccf }
            java.lang.Long r5 = r14.zzj     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzli.zzz(r9, r13, r5)     // Catch:{ all -> 0x0ccf }
        L_0x0753:
            java.lang.Boolean r5 = r14.zzk     // Catch:{ all -> 0x0ccf }
            if (r5 == 0) goto L_0x076b
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x0ccf }
            if (r5 == 0) goto L_0x076b
            com.google.android.gms.measurement.internal.zzli r5 = r1.zzi     // Catch:{ all -> 0x0ccf }
            zzal(r5)     // Catch:{ all -> 0x0ccf }
            r5 = 1
            java.lang.Long r10 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzli.zzz(r9, r12, r10)     // Catch:{ all -> 0x0ccf }
        L_0x076b:
            com.google.android.gms.internal.measurement.zzlb r5 = r9.zzaD()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzft r5 = (com.google.android.gms.internal.measurement.zzft) r5     // Catch:{ all -> 0x0ccf }
            r3.add(r5)     // Catch:{ all -> 0x0ccf }
        L_0x0774:
            r11.zzS(r8, r9)     // Catch:{ all -> 0x0ccf }
        L_0x0777:
            r10 = r3
            r21 = r7
            r5 = r11
            r7 = r2
            r2 = 1
            goto L_0x09c9
        L_0x0780:
            com.google.android.gms.measurement.internal.zzfv r5 = r1.zzc     // Catch:{ all -> 0x0ccf }
            zzal(r5)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0ccf }
            java.lang.String r10 = "measurement.account.time_zone_offset_minutes"
            java.lang.String r10 = r5.zza(r6, r10)     // Catch:{ all -> 0x0ccf }
            boolean r14 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0ccf }
            if (r14 != 0) goto L_0x07b1
            long r5 = java.lang.Long.parseLong(r10)     // Catch:{ NumberFormatException -> 0x079c }
            goto L_0x07b3
        L_0x079c:
            r0 = move-exception
            r10 = r0
            com.google.android.gms.measurement.internal.zzge r5 = r5.zzt     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzeu r5 = r5.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r5 = r5.zzk()     // Catch:{ all -> 0x0ccf }
            java.lang.String r14 = "Unable to parse timezone offset. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeu.zzn(r6)     // Catch:{ all -> 0x0ccf }
            r5.zzc(r14, r6, r10)     // Catch:{ all -> 0x0ccf }
        L_0x07b1:
            r5 = 0
        L_0x07b3:
            com.google.android.gms.measurement.internal.zzlo r10 = r40.zzv()     // Catch:{ all -> 0x0ccf }
            long r14 = r9.zzc()     // Catch:{ all -> 0x0ccf }
            long r14 = r10.zzr(r14, r5)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzlb r10 = r9.zzaD()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzft r10 = (com.google.android.gms.internal.measurement.zzft) r10     // Catch:{ all -> 0x0ccf }
            r43 = r12
            r17 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x0ccf }
            r17 = r5
            java.lang.String r5 = "_dbg"
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0ccf }
            if (r6 != 0) goto L_0x080b
            java.util.List r6 = r10.zzi()     // Catch:{ all -> 0x0ccf }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0ccf }
        L_0x07df:
            boolean r10 = r6.hasNext()     // Catch:{ all -> 0x0ccf }
            if (r10 == 0) goto L_0x080b
            java.lang.Object r10 = r6.next()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzfx r10 = (com.google.android.gms.internal.measurement.zzfx) r10     // Catch:{ all -> 0x0ccf }
            r21 = r6
            java.lang.String r6 = r10.zzg()     // Catch:{ all -> 0x0ccf }
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x0ccf }
            if (r6 == 0) goto L_0x0808
            long r5 = r10.zzd()     // Catch:{ all -> 0x0ccf }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0ccf }
            boolean r5 = r12.equals(r5)     // Catch:{ all -> 0x0ccf }
            if (r5 != 0) goto L_0x0806
            goto L_0x080b
        L_0x0806:
            r5 = 1
            goto L_0x081e
        L_0x0808:
            r6 = r21
            goto L_0x07df
        L_0x080b:
            com.google.android.gms.measurement.internal.zzfv r5 = r1.zzc     // Catch:{ all -> 0x0ccf }
            zzal(r5)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0ccf }
            java.lang.String r10 = r9.zzo()     // Catch:{ all -> 0x0ccf }
            int r5 = r5.zzc(r6, r10)     // Catch:{ all -> 0x0ccf }
        L_0x081e:
            if (r5 > 0) goto L_0x0843
            com.google.android.gms.measurement.internal.zzeu r6 = r40.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzk()     // Catch:{ all -> 0x0ccf }
            java.lang.String r10 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r9.zzo()     // Catch:{ all -> 0x0ccf }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0ccf }
            r6.zzc(r10, r12, r5)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzlb r5 = r9.zzaD()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzft r5 = (com.google.android.gms.internal.measurement.zzft) r5     // Catch:{ all -> 0x0ccf }
            r3.add(r5)     // Catch:{ all -> 0x0ccf }
            r11.zzS(r8, r9)     // Catch:{ all -> 0x0ccf }
            goto L_0x0777
        L_0x0843:
            java.lang.String r6 = r9.zzo()     // Catch:{ all -> 0x0ccf }
            java.lang.Object r6 = r2.get(r6)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzas r6 = (com.google.android.gms.measurement.internal.zzas) r6     // Catch:{ all -> 0x0ccf }
            if (r6 != 0) goto L_0x08a3
            com.google.android.gms.measurement.internal.zzam r6 = r1.zze     // Catch:{ all -> 0x0ccf }
            zzal(r6)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgd r10 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r10 = r10.zzy()     // Catch:{ all -> 0x0ccf }
            java.lang.String r12 = r9.zzo()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzas r6 = r6.zzn(r10, r12)     // Catch:{ all -> 0x0ccf }
            if (r6 != 0) goto L_0x08a3
            com.google.android.gms.measurement.internal.zzeu r6 = r40.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzk()     // Catch:{ all -> 0x0ccf }
            java.lang.String r10 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzgd r12 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r12 = r12.zzy()     // Catch:{ all -> 0x0ccf }
            r21 = r14
            java.lang.String r14 = r9.zzo()     // Catch:{ all -> 0x0ccf }
            r6.zzc(r10, r12, r14)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzas r6 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgd r10 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r24 = r10.zzy()     // Catch:{ all -> 0x0ccf }
            java.lang.String r25 = r9.zzo()     // Catch:{ all -> 0x0ccf }
            r26 = 1
            r28 = 1
            r30 = 1
            long r32 = r9.zzc()     // Catch:{ all -> 0x0ccf }
            r34 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r23 = r6
            r23.<init>(r24, r25, r26, r28, r30, r32, r34, r36, r37, r38, r39)     // Catch:{ all -> 0x0ccf }
            goto L_0x08a5
        L_0x08a3:
            r21 = r14
        L_0x08a5:
            com.google.android.gms.measurement.internal.zzli r10 = r1.zzi     // Catch:{ all -> 0x0ccf }
            zzal(r10)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzlb r10 = r9.zzaD()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzft r10 = (com.google.android.gms.internal.measurement.zzft) r10     // Catch:{ all -> 0x0ccf }
            java.lang.String r12 = "_eid"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzli.zzC(r10, r12)     // Catch:{ all -> 0x0ccf }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ all -> 0x0ccf }
            if (r10 == 0) goto L_0x08bc
            r12 = 1
            goto L_0x08bd
        L_0x08bc:
            r12 = 0
        L_0x08bd:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0ccf }
            r14 = 1
            if (r5 != r14) goto L_0x08f0
            com.google.android.gms.internal.measurement.zzlb r5 = r9.zzaD()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzft r5 = (com.google.android.gms.internal.measurement.zzft) r5     // Catch:{ all -> 0x0ccf }
            r3.add(r5)     // Catch:{ all -> 0x0ccf }
            boolean r5 = r12.booleanValue()     // Catch:{ all -> 0x0ccf }
            if (r5 == 0) goto L_0x08eb
            java.lang.Long r5 = r6.zzi     // Catch:{ all -> 0x0ccf }
            if (r5 != 0) goto L_0x08df
            java.lang.Long r5 = r6.zzj     // Catch:{ all -> 0x0ccf }
            if (r5 != 0) goto L_0x08df
            java.lang.Boolean r5 = r6.zzk     // Catch:{ all -> 0x0ccf }
            if (r5 == 0) goto L_0x08eb
        L_0x08df:
            r5 = 0
            com.google.android.gms.measurement.internal.zzas r6 = r6.zza(r5, r5, r5)     // Catch:{ all -> 0x0ccf }
            java.lang.String r5 = r9.zzo()     // Catch:{ all -> 0x0ccf }
            r2.put(r5, r6)     // Catch:{ all -> 0x0ccf }
        L_0x08eb:
            r11.zzS(r8, r9)     // Catch:{ all -> 0x0ccf }
            goto L_0x0777
        L_0x08f0:
            int r14 = r7.nextInt(r5)     // Catch:{ all -> 0x0ccf }
            if (r14 != 0) goto L_0x0931
            com.google.android.gms.measurement.internal.zzli r10 = r1.zzi     // Catch:{ all -> 0x0ccf }
            zzal(r10)     // Catch:{ all -> 0x0ccf }
            long r14 = (long) r5     // Catch:{ all -> 0x0ccf }
            java.lang.Long r5 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzli.zzz(r9, r13, r5)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzlb r10 = r9.zzaD()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzft r10 = (com.google.android.gms.internal.measurement.zzft) r10     // Catch:{ all -> 0x0ccf }
            r3.add(r10)     // Catch:{ all -> 0x0ccf }
            boolean r10 = r12.booleanValue()     // Catch:{ all -> 0x0ccf }
            if (r10 == 0) goto L_0x0917
            r10 = 0
            com.google.android.gms.measurement.internal.zzas r6 = r6.zza(r10, r5, r10)     // Catch:{ all -> 0x0ccf }
        L_0x0917:
            java.lang.String r5 = r9.zzo()     // Catch:{ all -> 0x0ccf }
            long r12 = r9.zzc()     // Catch:{ all -> 0x0ccf }
            r14 = r21
            com.google.android.gms.measurement.internal.zzas r6 = r6.zzb(r12, r14)     // Catch:{ all -> 0x0ccf }
            r2.put(r5, r6)     // Catch:{ all -> 0x0ccf }
            r10 = r3
            r21 = r7
            r5 = r11
            r7 = r2
            r2 = 1
            goto L_0x09c6
        L_0x0931:
            r14 = r21
            r21 = r7
            java.lang.Long r7 = r6.zzh     // Catch:{ all -> 0x0ccf }
            if (r7 == 0) goto L_0x0946
            long r17 = r7.longValue()     // Catch:{ all -> 0x0ccf }
            r24 = r2
            r25 = r3
            r23 = r10
            r22 = r11
            goto L_0x095c
        L_0x0946:
            com.google.android.gms.measurement.internal.zzlo r7 = r40.zzv()     // Catch:{ all -> 0x0ccf }
            r23 = r10
            r22 = r11
            long r10 = r9.zzb()     // Catch:{ all -> 0x0ccf }
            r24 = r2
            r25 = r3
            r2 = r17
            long r17 = r7.zzr(r10, r2)     // Catch:{ all -> 0x0ccf }
        L_0x095c:
            int r2 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            if (r2 == 0) goto L_0x09aa
            com.google.android.gms.measurement.internal.zzli r2 = r1.zzi     // Catch:{ all -> 0x0ccf }
            zzal(r2)     // Catch:{ all -> 0x0ccf }
            r2 = 1
            java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0ccf }
            r10 = r43
            com.google.android.gms.measurement.internal.zzli.zzz(r9, r10, r7)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzli r7 = r1.zzi     // Catch:{ all -> 0x0ccf }
            zzal(r7)     // Catch:{ all -> 0x0ccf }
            long r10 = (long) r5     // Catch:{ all -> 0x0ccf }
            java.lang.Long r5 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzli.zzz(r9, r13, r5)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzlb r7 = r9.zzaD()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzft r7 = (com.google.android.gms.internal.measurement.zzft) r7     // Catch:{ all -> 0x0ccf }
            r10 = r25
            r10.add(r7)     // Catch:{ all -> 0x0ccf }
            boolean r7 = r12.booleanValue()     // Catch:{ all -> 0x0ccf }
            if (r7 == 0) goto L_0x0998
            r7 = 1
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x0ccf }
            r7 = 0
            com.google.android.gms.measurement.internal.zzas r6 = r6.zza(r7, r5, r11)     // Catch:{ all -> 0x0ccf }
        L_0x0998:
            java.lang.String r5 = r9.zzo()     // Catch:{ all -> 0x0ccf }
            long r11 = r9.zzc()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzas r6 = r6.zzb(r11, r14)     // Catch:{ all -> 0x0ccf }
            r7 = r24
            r7.put(r5, r6)     // Catch:{ all -> 0x0ccf }
            goto L_0x09c4
        L_0x09aa:
            r7 = r24
            r10 = r25
            r2 = 1
            boolean r5 = r12.booleanValue()     // Catch:{ all -> 0x0ccf }
            if (r5 == 0) goto L_0x09c4
            java.lang.String r5 = r9.zzo()     // Catch:{ all -> 0x0ccf }
            r11 = r23
            r12 = 0
            com.google.android.gms.measurement.internal.zzas r6 = r6.zza(r11, r12, r12)     // Catch:{ all -> 0x0ccf }
            r7.put(r5, r6)     // Catch:{ all -> 0x0ccf }
        L_0x09c4:
            r5 = r22
        L_0x09c6:
            r5.zzS(r8, r9)     // Catch:{ all -> 0x0ccf }
        L_0x09c9:
            int r8 = r8 + 1
            r11 = r5
            r2 = r7
            r3 = r10
            r7 = r21
            r5 = 0
            goto L_0x06de
        L_0x09d4:
            r7 = r2
            r10 = r3
            r5 = r11
            int r2 = r10.size()     // Catch:{ all -> 0x0ccf }
            int r3 = r5.zza()     // Catch:{ all -> 0x0ccf }
            if (r2 >= r3) goto L_0x09e7
            r5.zzr()     // Catch:{ all -> 0x0ccf }
            r5.zzg(r10)     // Catch:{ all -> 0x0ccf }
        L_0x09e7:
            java.util.Set r2 = r7.entrySet()     // Catch:{ all -> 0x0ccf }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0ccf }
        L_0x09ef:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0ccf }
            if (r3 == 0) goto L_0x0a0b
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0ccf }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzam r6 = r1.zze     // Catch:{ all -> 0x0ccf }
            zzal(r6)     // Catch:{ all -> 0x0ccf }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzas r3 = (com.google.android.gms.measurement.internal.zzas) r3     // Catch:{ all -> 0x0ccf }
            r6.zzE(r3)     // Catch:{ all -> 0x0ccf }
            goto L_0x09ef
        L_0x0a0a:
            r5 = r11
        L_0x0a0b:
            com.google.android.gms.internal.measurement.zzgd r2 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r2 = r2.zzy()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze     // Catch:{ all -> 0x0ccf }
            zzal(r3)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzh r3 = r3.zzj(r2)     // Catch:{ all -> 0x0ccf }
            if (r3 != 0) goto L_0x0a34
            com.google.android.gms.measurement.internal.zzeu r3 = r40.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzd()     // Catch:{ all -> 0x0ccf }
            java.lang.String r6 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0ccf }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeu.zzn(r7)     // Catch:{ all -> 0x0ccf }
            r3.zzb(r6, r7)     // Catch:{ all -> 0x0ccf }
            goto L_0x0a90
        L_0x0a34:
            int r6 = r5.zza()     // Catch:{ all -> 0x0ccf }
            if (r6 <= 0) goto L_0x0a90
            long r6 = r3.zzn()     // Catch:{ all -> 0x0ccf }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0a48
            r5.zzab(r6)     // Catch:{ all -> 0x0ccf }
            goto L_0x0a4b
        L_0x0a48:
            r5.zzv()     // Catch:{ all -> 0x0ccf }
        L_0x0a4b:
            long r8 = r3.zzp()     // Catch:{ all -> 0x0ccf }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0a56
            goto L_0x0a57
        L_0x0a56:
            r6 = r8
        L_0x0a57:
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0a5f
            r5.zzac(r6)     // Catch:{ all -> 0x0ccf }
            goto L_0x0a62
        L_0x0a5f:
            r5.zzw()     // Catch:{ all -> 0x0ccf }
        L_0x0a62:
            r3.zzF()     // Catch:{ all -> 0x0ccf }
            long r6 = r3.zzo()     // Catch:{ all -> 0x0ccf }
            int r7 = (int) r6     // Catch:{ all -> 0x0ccf }
            r5.zzI(r7)     // Catch:{ all -> 0x0ccf }
            long r6 = r5.zzd()     // Catch:{ all -> 0x0ccf }
            r3.zzac(r6)     // Catch:{ all -> 0x0ccf }
            long r6 = r5.zzc()     // Catch:{ all -> 0x0ccf }
            r3.zzaa(r6)     // Catch:{ all -> 0x0ccf }
            java.lang.String r6 = r3.zzt()     // Catch:{ all -> 0x0ccf }
            if (r6 == 0) goto L_0x0a85
            r5.zzW(r6)     // Catch:{ all -> 0x0ccf }
            goto L_0x0a88
        L_0x0a85:
            r5.zzs()     // Catch:{ all -> 0x0ccf }
        L_0x0a88:
            com.google.android.gms.measurement.internal.zzam r6 = r1.zze     // Catch:{ all -> 0x0ccf }
            zzal(r6)     // Catch:{ all -> 0x0ccf }
            r6.zzD(r3)     // Catch:{ all -> 0x0ccf }
        L_0x0a90:
            int r3 = r5.zza()     // Catch:{ all -> 0x0ccf }
            if (r3 <= 0) goto L_0x0c14
            com.google.android.gms.measurement.internal.zzge r3 = r1.zzn     // Catch:{ all -> 0x0ccf }
            r3.zzay()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzfv r3 = r1.zzc     // Catch:{ all -> 0x0ccf }
            zzal(r3)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzff r3 = r3.zze(r6)     // Catch:{ all -> 0x0ccf }
            r6 = -1
            if (r3 == 0) goto L_0x0abd
            boolean r8 = r3.zzu()     // Catch:{ all -> 0x0ccf }
            if (r8 != 0) goto L_0x0ab5
            goto L_0x0abd
        L_0x0ab5:
            long r8 = r3.zzc()     // Catch:{ all -> 0x0ccf }
            r5.zzK(r8)     // Catch:{ all -> 0x0ccf }
            goto L_0x0ae4
        L_0x0abd:
            com.google.android.gms.internal.measurement.zzgd r3 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r3 = r3.zzG()     // Catch:{ all -> 0x0ccf }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0ccf }
            if (r3 == 0) goto L_0x0acd
            r5.zzK(r6)     // Catch:{ all -> 0x0ccf }
            goto L_0x0ae4
        L_0x0acd:
            com.google.android.gms.measurement.internal.zzeu r3 = r40.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzk()     // Catch:{ all -> 0x0ccf }
            java.lang.String r8 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzgd r9 = r4.zza     // Catch:{ all -> 0x0ccf }
            java.lang.String r9 = r9.zzy()     // Catch:{ all -> 0x0ccf }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeu.zzn(r9)     // Catch:{ all -> 0x0ccf }
            r3.zzb(r8, r9)     // Catch:{ all -> 0x0ccf }
        L_0x0ae4:
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze     // Catch:{ all -> 0x0ccf }
            zzal(r3)     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzlb r5 = r5.zzaD()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.internal.measurement.zzgd r5 = (com.google.android.gms.internal.measurement.zzgd) r5     // Catch:{ all -> 0x0ccf }
            r3.zzg()     // Catch:{ all -> 0x0ccf }
            r3.zzW()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0ccf }
            java.lang.String r8 = r5.zzy()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x0ccf }
            boolean r8 = r5.zzbg()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.common.internal.Preconditions.checkState(r8)     // Catch:{ all -> 0x0ccf }
            r3.zzz()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzge r8 = r3.zzt     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.common.util.Clock r8 = r8.zzax()     // Catch:{ all -> 0x0ccf }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x0ccf }
            long r10 = r5.zzk()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzge r12 = r3.zzt     // Catch:{ all -> 0x0ccf }
            r12.zzf()     // Catch:{ all -> 0x0ccf }
            long r12 = com.google.android.gms.measurement.internal.zzag.zzA()     // Catch:{ all -> 0x0ccf }
            long r12 = r8 - r12
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x0b38
            long r10 = r5.zzk()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzge r12 = r3.zzt     // Catch:{ all -> 0x0ccf }
            r12.zzf()     // Catch:{ all -> 0x0ccf }
            long r12 = com.google.android.gms.measurement.internal.zzag.zzA()     // Catch:{ all -> 0x0ccf }
            long r12 = r12 + r8
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x0b5b
        L_0x0b38:
            com.google.android.gms.measurement.internal.zzge r10 = r3.zzt     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzeu r10 = r10.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r10 = r10.zzk()     // Catch:{ all -> 0x0ccf }
            java.lang.String r11 = "Storing bundle outside of the max uploading time span. appId, now, timestamp"
            java.lang.String r12 = r5.zzy()     // Catch:{ all -> 0x0ccf }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzeu.zzn(r12)     // Catch:{ all -> 0x0ccf }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0ccf }
            long r13 = r5.zzk()     // Catch:{ all -> 0x0ccf }
            java.lang.Long r9 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0ccf }
            r10.zzd(r11, r12, r8, r9)     // Catch:{ all -> 0x0ccf }
        L_0x0b5b:
            byte[] r8 = r5.zzbx()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzlg r9 = r3.zzf     // Catch:{ IOException -> 0x0bfb }
            com.google.android.gms.measurement.internal.zzli r9 = r9.zzi     // Catch:{ IOException -> 0x0bfb }
            zzal(r9)     // Catch:{ IOException -> 0x0bfb }
            byte[] r8 = r9.zzy(r8)     // Catch:{ IOException -> 0x0bfb }
            com.google.android.gms.measurement.internal.zzge r9 = r3.zzt     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzeu r9 = r9.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r9 = r9.zzj()     // Catch:{ all -> 0x0ccf }
            java.lang.String r10 = "Saving bundle, size"
            int r11 = r8.length     // Catch:{ all -> 0x0ccf }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0ccf }
            r9.zzb(r10, r11)     // Catch:{ all -> 0x0ccf }
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ all -> 0x0ccf }
            r9.<init>()     // Catch:{ all -> 0x0ccf }
            java.lang.String r10 = "app_id"
            java.lang.String r11 = r5.zzy()     // Catch:{ all -> 0x0ccf }
            r9.put(r10, r11)     // Catch:{ all -> 0x0ccf }
            java.lang.String r10 = "bundle_end_timestamp"
            long r11 = r5.zzk()     // Catch:{ all -> 0x0ccf }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0ccf }
            r9.put(r10, r11)     // Catch:{ all -> 0x0ccf }
            java.lang.String r10 = "data"
            r9.put(r10, r8)     // Catch:{ all -> 0x0ccf }
            java.lang.String r8 = "has_realtime"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0ccf }
            r9.put(r8, r10)     // Catch:{ all -> 0x0ccf }
            boolean r8 = r5.zzbm()     // Catch:{ all -> 0x0ccf }
            if (r8 == 0) goto L_0x0bba
            java.lang.String r8 = "retry_count"
            int r10 = r5.zze()     // Catch:{ all -> 0x0ccf }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0ccf }
            r9.put(r8, r10)     // Catch:{ all -> 0x0ccf }
        L_0x0bba:
            android.database.sqlite.SQLiteDatabase r8 = r3.zzh()     // Catch:{ SQLiteException -> 0x0be1 }
            java.lang.String r10 = "queue"
            r11 = 0
            long r8 = r8.insert(r10, r11, r9)     // Catch:{ SQLiteException -> 0x0be1 }
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 != 0) goto L_0x0c14
            com.google.android.gms.measurement.internal.zzge r6 = r3.zzt     // Catch:{ SQLiteException -> 0x0be1 }
            com.google.android.gms.measurement.internal.zzeu r6 = r6.zzaA()     // Catch:{ SQLiteException -> 0x0be1 }
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzd()     // Catch:{ SQLiteException -> 0x0be1 }
            java.lang.String r7 = "Failed to insert bundle (got -1). appId"
            java.lang.String r8 = r5.zzy()     // Catch:{ SQLiteException -> 0x0be1 }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeu.zzn(r8)     // Catch:{ SQLiteException -> 0x0be1 }
            r6.zzb(r7, r8)     // Catch:{ SQLiteException -> 0x0be1 }
            goto L_0x0c14
        L_0x0be1:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzge r3 = r3.zzt     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzeu r3 = r3.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzd()     // Catch:{ all -> 0x0ccf }
            java.lang.String r7 = "Error storing bundle. appId"
            java.lang.String r5 = r5.zzy()     // Catch:{ all -> 0x0ccf }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeu.zzn(r5)     // Catch:{ all -> 0x0ccf }
            r3.zzc(r7, r5, r6)     // Catch:{ all -> 0x0ccf }
            goto L_0x0c14
        L_0x0bfb:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzge r3 = r3.zzt     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzeu r3 = r3.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzd()     // Catch:{ all -> 0x0ccf }
            java.lang.String r7 = "Data loss. Failed to serialize bundle. appId"
            java.lang.String r5 = r5.zzy()     // Catch:{ all -> 0x0ccf }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeu.zzn(r5)     // Catch:{ all -> 0x0ccf }
            r3.zzc(r7, r5, r6)     // Catch:{ all -> 0x0ccf }
        L_0x0c14:
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze     // Catch:{ all -> 0x0ccf }
            zzal(r3)     // Catch:{ all -> 0x0ccf }
            java.util.List r4 = r4.zzb     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x0ccf }
            r3.zzg()     // Catch:{ all -> 0x0ccf }
            r3.zzW()     // Catch:{ all -> 0x0ccf }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0ccf }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0ccf }
            r6 = 0
        L_0x0c2c:
            int r7 = r4.size()     // Catch:{ all -> 0x0ccf }
            if (r6 >= r7) goto L_0x0c49
            if (r6 == 0) goto L_0x0c39
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0ccf }
        L_0x0c39:
            java.lang.Object r7 = r4.get(r6)     // Catch:{ all -> 0x0ccf }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0ccf }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0ccf }
            r5.append(r7)     // Catch:{ all -> 0x0ccf }
            int r6 = r6 + 1
            goto L_0x0c2c
        L_0x0c49:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0ccf }
            android.database.sqlite.SQLiteDatabase r6 = r3.zzh()     // Catch:{ all -> 0x0ccf }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0ccf }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0ccf }
            int r6 = r4.size()     // Catch:{ all -> 0x0ccf }
            if (r5 == r6) goto L_0x0c7e
            com.google.android.gms.measurement.internal.zzge r3 = r3.zzt     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzeu r3 = r3.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzd()     // Catch:{ all -> 0x0ccf }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0ccf }
            int r4 = r4.size()     // Catch:{ all -> 0x0ccf }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0ccf }
            r3.zzc(r6, r5, r4)     // Catch:{ all -> 0x0ccf }
        L_0x0c7e:
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze     // Catch:{ all -> 0x0ccf }
            zzal(r3)     // Catch:{ all -> 0x0ccf }
            android.database.sqlite.SQLiteDatabase r4 = r3.zzh()     // Catch:{ all -> 0x0ccf }
            java.lang.String r5 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0c96 }
            r7 = 0
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0c96 }
            r7 = 1
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0c96 }
            r4.execSQL(r5, r6)     // Catch:{ SQLiteException -> 0x0c96 }
            goto L_0x0cab
        L_0x0c96:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.measurement.internal.zzge r3 = r3.zzt     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzeu r3 = r3.zzaA()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzd()     // Catch:{ all -> 0x0ccf }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzeu.zzn(r2)     // Catch:{ all -> 0x0ccf }
            r3.zzc(r5, r2, r4)     // Catch:{ all -> 0x0ccf }
        L_0x0cab:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0ccf }
            zzal(r2)     // Catch:{ all -> 0x0ccf }
            r2.zzC()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            r2 = 1
            return r2
        L_0x0cbd:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0ccf }
            zzal(r2)     // Catch:{ all -> 0x0ccf }
            r2.zzC()     // Catch:{ all -> 0x0ccf }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            r2 = 0
            return r2
        L_0x0ccf:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze
            zzal(r3)
            r3.zzx()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlg.zzah(java.lang.String, long):boolean");
    }

    private final boolean zzai() {
        zzaB().zzg();
        zzB();
        zzam zzam = this.zze;
        zzal(zzam);
        if (zzam.zzF()) {
            return true;
        }
        zzam zzam2 = this.zze;
        zzal(zzam2);
        return !TextUtils.isEmpty(zzam2.zzr());
    }

    private final boolean zzaj(zzfs zzfs, zzfs zzfs2) {
        Preconditions.checkArgument("_e".equals(zzfs.zzo()));
        zzal(this.zzi);
        zzfx zzB2 = zzli.zzB((zzft) zzfs.zzaD(), "_sc");
        String str = null;
        String zzh2 = zzB2 == null ? null : zzB2.zzh();
        zzal(this.zzi);
        zzfx zzB3 = zzli.zzB((zzft) zzfs2.zzaD(), "_pc");
        if (zzB3 != null) {
            str = zzB3.zzh();
        }
        if (str == null || !str.equals(zzh2)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzfs.zzo()));
        zzal(this.zzi);
        zzfx zzB4 = zzli.zzB((zzft) zzfs.zzaD(), "_et");
        if (zzB4 == null || !zzB4.zzw() || zzB4.zzd() <= 0) {
            return true;
        }
        long zzd2 = zzB4.zzd();
        zzal(this.zzi);
        zzfx zzB5 = zzli.zzB((zzft) zzfs2.zzaD(), "_et");
        if (zzB5 != null && zzB5.zzd() > 0) {
            zzd2 += zzB5.zzd();
        }
        zzal(this.zzi);
        zzli.zzz(zzfs2, "_et", Long.valueOf(zzd2));
        zzal(this.zzi);
        zzli.zzz(zzfs, "_fr", 1L);
        return true;
    }

    private static final boolean zzak(zzq zzq2) {
        return !TextUtils.isEmpty(zzq2.zzb) || !TextUtils.isEmpty(zzq2.zzq);
    }

    private static final zzkt zzal(zzkt zzkt) {
        if (zzkt == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (zzkt.zzY()) {
            return zzkt;
        } else {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(zzkt.getClass()))));
        }
    }

    public static zzlg zzt(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzlg.class) {
                if (zzb == null) {
                    zzb = new zzlg((zzlh) Preconditions.checkNotNull(new zzlh(context)), (zzge) null);
                }
            }
        }
        return zzb;
    }

    static /* bridge */ /* synthetic */ void zzy(zzlg zzlg, zzlh zzlh) {
        zzlg.zzaB().zzg();
        zzlg.zzm = new zzfm(zzlg);
        zzam zzam = new zzam(zzlg);
        zzam.zzX();
        zzlg.zze = zzam;
        zzlg.zzg().zzq((zzaf) Preconditions.checkNotNull(zzlg.zzc));
        zzka zzka = new zzka(zzlg);
        zzka.zzX();
        zzlg.zzk = zzka;
        zzaa zzaa = new zzaa(zzlg);
        zzaa.zzX();
        zzlg.zzh = zzaa;
        zzio zzio = new zzio(zzlg);
        zzio.zzX();
        zzlg.zzj = zzio;
        zzkr zzkr = new zzkr(zzlg);
        zzkr.zzX();
        zzlg.zzg = zzkr;
        zzlg.zzf = new zzfc(zzlg);
        if (zzlg.zzr != zzlg.zzs) {
            zzlg.zzaA().zzd().zzc("Not all upload components initialized", Integer.valueOf(zzlg.zzr), Integer.valueOf(zzlg.zzs));
        }
        zzlg.zzo = true;
    }

    /* access modifiers changed from: package-private */
    public final void zzA() {
        zzaB().zzg();
        zzB();
        if (!this.zzp) {
            this.zzp = true;
            if (zzZ()) {
                FileChannel fileChannel = this.zzx;
                zzaB().zzg();
                int i = 0;
                if (fileChannel == null || !fileChannel.isOpen()) {
                    zzaA().zzd().zza("Bad channel to read from");
                } else {
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    try {
                        fileChannel.position(0);
                        int read = fileChannel.read(allocate);
                        if (read == 4) {
                            allocate.flip();
                            i = allocate.getInt();
                        } else if (read != -1) {
                            zzaA().zzk().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                        }
                    } catch (IOException e) {
                        zzaA().zzd().zzb("Failed to read from channel", e);
                    }
                }
                int zzi2 = this.zzn.zzh().zzi();
                zzaB().zzg();
                if (i > zzi2) {
                    zzaA().zzd().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi2));
                } else if (i < zzi2) {
                    FileChannel fileChannel2 = this.zzx;
                    zzaB().zzg();
                    if (fileChannel2 == null || !fileChannel2.isOpen()) {
                        zzaA().zzd().zza("Bad channel to read from");
                    } else {
                        ByteBuffer allocate2 = ByteBuffer.allocate(4);
                        allocate2.putInt(zzi2);
                        allocate2.flip();
                        try {
                            fileChannel2.truncate(0);
                            fileChannel2.write(allocate2);
                            fileChannel2.force(true);
                            if (fileChannel2.size() != 4) {
                                zzaA().zzd().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                            }
                            zzaA().zzj().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi2));
                            return;
                        } catch (IOException e2) {
                            zzaA().zzd().zzb("Failed to write to channel", e2);
                        }
                    }
                    zzaA().zzd().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi2));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzB() {
        if (!this.zzo) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzC(String str, zzgc zzgc) {
        int zza2;
        int indexOf;
        zzfv zzfv = this.zzc;
        zzal(zzfv);
        Set zzk2 = zzfv.zzk(str);
        if (zzk2 != null) {
            zzgc.zzi(zzk2);
        }
        zzfv zzfv2 = this.zzc;
        zzal(zzfv2);
        if (zzfv2.zzv(str)) {
            zzgc.zzp();
        }
        zzfv zzfv3 = this.zzc;
        zzal(zzfv3);
        if (zzfv3.zzy(str)) {
            if (zzg().zzs(str, zzeh.zzar)) {
                String zzas = zzgc.zzas();
                if (!TextUtils.isEmpty(zzas) && (indexOf = zzas.indexOf(".")) != -1) {
                    zzgc.zzY(zzas.substring(0, indexOf));
                }
            } else {
                zzgc.zzu();
            }
        }
        zzfv zzfv4 = this.zzc;
        zzal(zzfv4);
        if (zzfv4.zzz(str) && (zza2 = zzli.zza(zzgc, "_id")) != -1) {
            zzgc.zzB(zza2);
        }
        zzfv zzfv5 = this.zzc;
        zzal(zzfv5);
        if (zzfv5.zzx(str)) {
            zzgc.zzq();
        }
        zzfv zzfv6 = this.zzc;
        zzal(zzfv6);
        if (zzfv6.zzu(str)) {
            zzgc.zzn();
            zzlf zzlf = (zzlf) this.zzC.get(str);
            if (zzlf == null || zzlf.zzb + zzg().zzi(str, zzeh.zzT) < zzax().elapsedRealtime()) {
                zzlf = new zzlf(this);
                this.zzC.put(str, zzlf);
            }
            zzgc.zzR(zzlf.zza);
        }
        zzfv zzfv7 = this.zzc;
        zzal(zzfv7);
        if (zzfv7.zzw(str)) {
            zzgc.zzy();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzD(zzh zzh2) {
        zzaB().zzg();
        if (!TextUtils.isEmpty(zzh2.zzz()) || !TextUtils.isEmpty(zzh2.zzs())) {
            zzkv zzkv = this.zzl;
            Uri.Builder builder = new Uri.Builder();
            String zzz2 = zzh2.zzz();
            if (TextUtils.isEmpty(zzz2)) {
                zzz2 = zzh2.zzs();
            }
            ArrayMap arrayMap = null;
            Uri.Builder appendQueryParameter = builder.scheme((String) zzeh.zze.zza((Object) null)).encodedAuthority((String) zzeh.zzf.zza((Object) null)).path("config/app/".concat(String.valueOf(zzz2))).appendQueryParameter("platform", "android");
            zzkv.zzt.zzf().zzh();
            appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(77000)).appendQueryParameter("runtime_version", "0");
            String uri = builder.build().toString();
            try {
                String str = (String) Preconditions.checkNotNull(zzh2.zzu());
                URL url = new URL(uri);
                zzaA().zzj().zzb("Fetching remote configuration", str);
                zzfv zzfv = this.zzc;
                zzal(zzfv);
                zzff zze2 = zzfv.zze(str);
                zzfv zzfv2 = this.zzc;
                zzal(zzfv2);
                String zzh3 = zzfv2.zzh(str);
                if (zze2 != null) {
                    if (!TextUtils.isEmpty(zzh3)) {
                        ArrayMap arrayMap2 = new ArrayMap();
                        arrayMap2.put("If-Modified-Since", zzh3);
                        arrayMap = arrayMap2;
                    }
                    zzfv zzfv3 = this.zzc;
                    zzal(zzfv3);
                    String zzf2 = zzfv3.zzf(str);
                    if (!TextUtils.isEmpty(zzf2)) {
                        if (arrayMap == null) {
                            arrayMap = new ArrayMap();
                        }
                        arrayMap.put("If-None-Match", zzf2);
                    }
                }
                this.zzt = true;
                zzfa zzfa = this.zzd;
                zzal(zzfa);
                zzky zzky = new zzky(this);
                zzfa.zzg();
                zzfa.zzW();
                Preconditions.checkNotNull(url);
                Preconditions.checkNotNull(zzky);
                zzfa.zzt.zzaB().zzo(new zzez(zzfa, str, url, (byte[]) null, arrayMap, zzky));
            } catch (MalformedURLException unused) {
                zzaA().zzd().zzc("Failed to parse config URL. Not fetching. appId", zzeu.zzn(zzh2.zzu()), uri);
            }
        } else {
            zzI((String) Preconditions.checkNotNull(zzh2.zzu()), 204, (Throwable) null, (byte[]) null, (Map) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzE(zzaw zzaw, zzq zzq2) {
        zzaw zzaw2;
        List<zzac> list;
        List<zzac> list2;
        List<zzac> list3;
        String str;
        zzq zzq3 = zzq2;
        Preconditions.checkNotNull(zzq2);
        Preconditions.checkNotEmpty(zzq3.zza);
        zzaB().zzg();
        zzB();
        String str2 = zzq3.zza;
        long j = zzaw.zzd;
        zzev zzb2 = zzev.zzb(zzaw);
        zzaB().zzg();
        zziq zziq = null;
        if (!(this.zzD == null || (str = this.zzE) == null || !str.equals(str2))) {
            zziq = this.zzD;
        }
        zzlo.zzK(zziq, zzb2.zzd, false);
        zzaw zza2 = zzb2.zza();
        zzal(this.zzi);
        if (zzli.zzA(zza2, zzq3)) {
            if (!zzq3.zzh) {
                zzd(zzq3);
                return;
            }
            List list4 = zzq3.zzt;
            if (list4 == null) {
                zzaw2 = zza2;
            } else if (list4.contains(zza2.zza)) {
                Bundle zzc2 = zza2.zzb.zzc();
                zzc2.putLong("ga_safelisted", 1);
                zzaw2 = new zzaw(zza2.zza, new zzau(zzc2), zza2.zzc, zza2.zzd);
            } else {
                zzaA().zzc().zzd("Dropping non-safelisted event. appId, event name, origin", str2, zza2.zza, zza2.zzc);
                return;
            }
            zzam zzam = this.zze;
            zzal(zzam);
            zzam.zzw();
            try {
                zzam zzam2 = this.zze;
                zzal(zzam2);
                Preconditions.checkNotEmpty(str2);
                zzam2.zzg();
                zzam2.zzW();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    zzam2.zzt.zzaA().zzk().zzc("Invalid time querying timed out conditional properties", zzeu.zzn(str2), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zzam2.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
                }
                for (zzac zzac : list) {
                    if (zzac != null) {
                        zzaA().zzj().zzd("User property timed out", zzac.zza, this.zzn.zzj().zzf(zzac.zzc.zzb), zzac.zzc.zza());
                        zzaw zzaw3 = zzac.zzg;
                        if (zzaw3 != null) {
                            zzY(new zzaw(zzaw3, j), zzq3);
                        }
                        zzam zzam3 = this.zze;
                        zzal(zzam3);
                        zzam3.zza(str2, zzac.zzc.zzb);
                    }
                }
                zzam zzam4 = this.zze;
                zzal(zzam4);
                Preconditions.checkNotEmpty(str2);
                zzam4.zzg();
                zzam4.zzW();
                if (i < 0) {
                    zzam4.zzt.zzaA().zzk().zzc("Invalid time querying expired conditional properties", zzeu.zzn(str2), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzam4.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j)});
                }
                ArrayList<zzaw> arrayList = new ArrayList<>(list2.size());
                for (zzac zzac2 : list2) {
                    if (zzac2 != null) {
                        zzaA().zzj().zzd("User property expired", zzac2.zza, this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzc.zza());
                        zzam zzam5 = this.zze;
                        zzal(zzam5);
                        zzam5.zzA(str2, zzac2.zzc.zzb);
                        zzaw zzaw4 = zzac2.zzk;
                        if (zzaw4 != null) {
                            arrayList.add(zzaw4);
                        }
                        zzam zzam6 = this.zze;
                        zzal(zzam6);
                        zzam6.zza(str2, zzac2.zzc.zzb);
                    }
                }
                for (zzaw zzaw5 : arrayList) {
                    zzY(new zzaw(zzaw5, j), zzq3);
                }
                zzam zzam7 = this.zze;
                zzal(zzam7);
                String str3 = zzaw2.zza;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str3);
                zzam7.zzg();
                zzam7.zzW();
                if (i < 0) {
                    zzam7.zzt.zzaA().zzk().zzd("Invalid time querying triggered conditional properties", zzeu.zzn(str2), zzam7.zzt.zzj().zzd(str3), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzam7.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j)});
                }
                ArrayList<zzaw> arrayList2 = new ArrayList<>(list3.size());
                for (zzac zzac3 : list3) {
                    if (zzac3 != null) {
                        zzlj zzlj = zzac3.zzc;
                        zzll zzll = new zzll((String) Preconditions.checkNotNull(zzac3.zza), zzac3.zzb, zzlj.zzb, j, Preconditions.checkNotNull(zzlj.zza()));
                        zzam zzam8 = this.zze;
                        zzal(zzam8);
                        if (zzam8.zzL(zzll)) {
                            zzaA().zzj().zzd("User property triggered", zzac3.zza, this.zzn.zzj().zzf(zzll.zzc), zzll.zze);
                        } else {
                            zzaA().zzd().zzd("Too many active user properties, ignoring", zzeu.zzn(zzac3.zza), this.zzn.zzj().zzf(zzll.zzc), zzll.zze);
                        }
                        zzaw zzaw6 = zzac3.zzi;
                        if (zzaw6 != null) {
                            arrayList2.add(zzaw6);
                        }
                        zzac3.zzc = new zzlj(zzll);
                        zzac3.zze = true;
                        zzam zzam9 = this.zze;
                        zzal(zzam9);
                        zzam9.zzK(zzac3);
                    }
                }
                zzY(zzaw2, zzq3);
                for (zzaw zzaw7 : arrayList2) {
                    zzY(new zzaw(zzaw7, j), zzq3);
                }
                zzam zzam10 = this.zze;
                zzal(zzam10);
                zzam10.zzC();
            } finally {
                zzam zzam11 = this.zze;
                zzal(zzam11);
                zzam11.zzx();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzF(zzaw zzaw, String str) {
        zzaw zzaw2 = zzaw;
        String str2 = str;
        zzam zzam = this.zze;
        zzal(zzam);
        zzh zzj2 = zzam.zzj(str2);
        if (zzj2 == null || TextUtils.isEmpty(zzj2.zzx())) {
            zzaA().zzc().zzb("No app data available; dropping event", str2);
            return;
        }
        Boolean zzad = zzad(zzj2);
        if (zzad == null) {
            if (!"_ui".equals(zzaw2.zza)) {
                zzaA().zzk().zzb("Could not find package. appId", zzeu.zzn(str));
            }
        } else if (!zzad.booleanValue()) {
            zzaA().zzd().zzb("App version does not match; dropping event. appId", zzeu.zzn(str));
            return;
        }
        String zzz2 = zzj2.zzz();
        String zzx2 = zzj2.zzx();
        long zzb2 = zzj2.zzb();
        String zzw2 = zzj2.zzw();
        long zzm2 = zzj2.zzm();
        long zzj3 = zzj2.zzj();
        zzq zzq2 = r2;
        boolean zzal = zzj2.zzal();
        zzh zzh2 = zzj2;
        String zzy2 = zzh2.zzy();
        zzh2.zza();
        zzq zzq3 = new zzq(str, zzz2, zzx2, zzb2, zzw2, zzm2, zzj3, (String) null, zzal, false, zzy2, 0, 0, 0, zzh2.zzak(), false, zzh2.zzs(), zzh2.zzr(), zzh2.zzk(), zzh2.zzD(), (String) null, zzh(str2).zzh(), "", (String) null, zzh2.zzan(), zzh2.zzq());
        zzG(zzaw2, zzq2);
    }

    /* access modifiers changed from: package-private */
    public final void zzG(zzaw zzaw, zzq zzq2) {
        Preconditions.checkNotEmpty(zzq2.zza);
        zzev zzb2 = zzev.zzb(zzaw);
        zzlo zzv2 = zzv();
        Bundle bundle = zzb2.zzd;
        zzam zzam = this.zze;
        zzal(zzam);
        zzv2.zzL(bundle, zzam.zzi(zzq2.zza));
        zzv().zzN(zzb2, zzg().zzd(zzq2.zza));
        zzaw zza2 = zzb2.zza();
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zza2.zza) && "referrer API v2".equals(zza2.zzb.zzg("_cis"))) {
            String zzg2 = zza2.zzb.zzg("gclid");
            if (!TextUtils.isEmpty(zzg2)) {
                zzW(new zzlj("_lgclid", zza2.zzd, zzg2, DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzq2);
            }
        }
        zzE(zza2, zzq2);
    }

    /* access modifiers changed from: package-private */
    public final void zzH() {
        this.zzs++;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a A[Catch:{ all -> 0x0177, all -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005d A[Catch:{ all -> 0x0177, all -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x012a A[Catch:{ all -> 0x0177, all -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0138 A[Catch:{ all -> 0x0177, all -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x015a A[Catch:{ all -> 0x0177, all -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x015e A[Catch:{ all -> 0x0177, all -> 0x0181 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzI(java.lang.String r8, int r9, java.lang.Throwable r10, byte[] r11, java.util.Map r12) {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.zzgb r0 = r7.zzaB()
            r0.zzg()
            r7.zzB()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            r0 = 0
            if (r11 != 0) goto L_0x0012
            byte[] r11 = new byte[r0]     // Catch:{ all -> 0x0181 }
        L_0x0012:
            com.google.android.gms.measurement.internal.zzeu r1 = r7.zzaA()     // Catch:{ all -> 0x0181 }
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzj()     // Catch:{ all -> 0x0181 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r11.length     // Catch:{ all -> 0x0181 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0181 }
            r1.zzb(r2, r3)     // Catch:{ all -> 0x0181 }
            com.google.android.gms.measurement.internal.zzam r1 = r7.zze     // Catch:{ all -> 0x0181 }
            zzal(r1)     // Catch:{ all -> 0x0181 }
            r1.zzw()     // Catch:{ all -> 0x0181 }
            com.google.android.gms.measurement.internal.zzam r1 = r7.zze     // Catch:{ all -> 0x0177 }
            zzal(r1)     // Catch:{ all -> 0x0177 }
            com.google.android.gms.measurement.internal.zzh r1 = r1.zzj(r8)     // Catch:{ all -> 0x0177 }
            r2 = 200(0xc8, float:2.8E-43)
            r4 = 304(0x130, float:4.26E-43)
            if (r9 == r2) goto L_0x0043
            r2 = 204(0xcc, float:2.86E-43)
            if (r9 == r2) goto L_0x0043
            if (r9 != r4) goto L_0x0047
            r9 = 304(0x130, float:4.26E-43)
        L_0x0043:
            if (r10 != 0) goto L_0x0047
            r2 = 1
            goto L_0x0048
        L_0x0047:
            r2 = 0
        L_0x0048:
            if (r1 != 0) goto L_0x005d
            com.google.android.gms.measurement.internal.zzeu r9 = r7.zzaA()     // Catch:{ all -> 0x0177 }
            com.google.android.gms.measurement.internal.zzes r9 = r9.zzk()     // Catch:{ all -> 0x0177 }
            java.lang.String r10 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeu.zzn(r8)     // Catch:{ all -> 0x0177 }
            r9.zzb(r10, r8)     // Catch:{ all -> 0x0177 }
            goto L_0x0161
        L_0x005d:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00bb
            if (r9 != r5) goto L_0x0064
            goto L_0x00bb
        L_0x0064:
            com.google.android.gms.common.util.Clock r11 = r7.zzax()     // Catch:{ all -> 0x0177 }
            long r11 = r11.currentTimeMillis()     // Catch:{ all -> 0x0177 }
            r1.zzV(r11)     // Catch:{ all -> 0x0177 }
            com.google.android.gms.measurement.internal.zzam r11 = r7.zze     // Catch:{ all -> 0x0177 }
            zzal(r11)     // Catch:{ all -> 0x0177 }
            r11.zzD(r1)     // Catch:{ all -> 0x0177 }
            com.google.android.gms.measurement.internal.zzeu r11 = r7.zzaA()     // Catch:{ all -> 0x0177 }
            com.google.android.gms.measurement.internal.zzes r11 = r11.zzj()     // Catch:{ all -> 0x0177 }
            java.lang.String r12 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0177 }
            r11.zzc(r12, r1, r10)     // Catch:{ all -> 0x0177 }
            com.google.android.gms.measurement.internal.zzfv r10 = r7.zzc     // Catch:{ all -> 0x0177 }
            zzal(r10)     // Catch:{ all -> 0x0177 }
            r10.zzl(r8)     // Catch:{ all -> 0x0177 }
            com.google.android.gms.measurement.internal.zzka r8 = r7.zzk     // Catch:{ all -> 0x0177 }
            com.google.android.gms.measurement.internal.zzff r8 = r8.zzd     // Catch:{ all -> 0x0177 }
            com.google.android.gms.common.util.Clock r10 = r7.zzax()     // Catch:{ all -> 0x0177 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x0177 }
            r8.zzb(r10)     // Catch:{ all -> 0x0177 }
            r8 = 503(0x1f7, float:7.05E-43)
            if (r9 == r8) goto L_0x00a7
            r8 = 429(0x1ad, float:6.01E-43)
            if (r9 != r8) goto L_0x00b6
        L_0x00a7:
            com.google.android.gms.measurement.internal.zzka r8 = r7.zzk     // Catch:{ all -> 0x0177 }
            com.google.android.gms.measurement.internal.zzff r8 = r8.zzb     // Catch:{ all -> 0x0177 }
            com.google.android.gms.common.util.Clock r9 = r7.zzax()     // Catch:{ all -> 0x0177 }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x0177 }
            r8.zzb(r9)     // Catch:{ all -> 0x0177 }
        L_0x00b6:
            r7.zzag()     // Catch:{ all -> 0x0177 }
            goto L_0x0161
        L_0x00bb:
            r10 = 0
            if (r12 == 0) goto L_0x00c7
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r2 = r12.get(r2)     // Catch:{ all -> 0x0177 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x0177 }
            goto L_0x00c8
        L_0x00c7:
            r2 = r10
        L_0x00c8:
            if (r2 == 0) goto L_0x00d7
            boolean r6 = r2.isEmpty()     // Catch:{ all -> 0x0177 }
            if (r6 != 0) goto L_0x00d7
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0177 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0177 }
            goto L_0x00d8
        L_0x00d7:
            r2 = r10
        L_0x00d8:
            if (r12 == 0) goto L_0x00e3
            java.lang.String r6 = "ETag"
            java.lang.Object r12 = r12.get(r6)     // Catch:{ all -> 0x0177 }
            java.util.List r12 = (java.util.List) r12     // Catch:{ all -> 0x0177 }
            goto L_0x00e4
        L_0x00e3:
            r12 = r10
        L_0x00e4:
            if (r12 == 0) goto L_0x00f3
            boolean r6 = r12.isEmpty()     // Catch:{ all -> 0x0177 }
            if (r6 != 0) goto L_0x00f3
            java.lang.Object r12 = r12.get(r0)     // Catch:{ all -> 0x0177 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0177 }
            goto L_0x00f4
        L_0x00f3:
            r12 = r10
        L_0x00f4:
            if (r9 == r5) goto L_0x0102
            if (r9 != r4) goto L_0x00f9
            goto L_0x0102
        L_0x00f9:
            com.google.android.gms.measurement.internal.zzfv r10 = r7.zzc     // Catch:{ all -> 0x0177 }
            zzal(r10)     // Catch:{ all -> 0x0177 }
            r10.zzt(r8, r11, r2, r12)     // Catch:{ all -> 0x0177 }
            goto L_0x0115
        L_0x0102:
            com.google.android.gms.measurement.internal.zzfv r11 = r7.zzc     // Catch:{ all -> 0x0177 }
            zzal(r11)     // Catch:{ all -> 0x0177 }
            com.google.android.gms.internal.measurement.zzff r11 = r11.zze(r8)     // Catch:{ all -> 0x0177 }
            if (r11 != 0) goto L_0x0115
            com.google.android.gms.measurement.internal.zzfv r11 = r7.zzc     // Catch:{ all -> 0x0177 }
            zzal(r11)     // Catch:{ all -> 0x0177 }
            r11.zzt(r8, r10, r10, r10)     // Catch:{ all -> 0x0177 }
        L_0x0115:
            com.google.android.gms.common.util.Clock r10 = r7.zzax()     // Catch:{ all -> 0x0177 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x0177 }
            r1.zzM(r10)     // Catch:{ all -> 0x0177 }
            com.google.android.gms.measurement.internal.zzam r10 = r7.zze     // Catch:{ all -> 0x0177 }
            zzal(r10)     // Catch:{ all -> 0x0177 }
            r10.zzD(r1)     // Catch:{ all -> 0x0177 }
            if (r9 != r5) goto L_0x0138
            com.google.android.gms.measurement.internal.zzeu r9 = r7.zzaA()     // Catch:{ all -> 0x0177 }
            com.google.android.gms.measurement.internal.zzes r9 = r9.zzl()     // Catch:{ all -> 0x0177 }
            java.lang.String r10 = "Config not found. Using empty config. appId"
            r9.zzb(r10, r8)     // Catch:{ all -> 0x0177 }
            goto L_0x0149
        L_0x0138:
            com.google.android.gms.measurement.internal.zzeu r8 = r7.zzaA()     // Catch:{ all -> 0x0177 }
            com.google.android.gms.measurement.internal.zzes r8 = r8.zzj()     // Catch:{ all -> 0x0177 }
            java.lang.String r10 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0177 }
            r8.zzc(r10, r9, r3)     // Catch:{ all -> 0x0177 }
        L_0x0149:
            com.google.android.gms.measurement.internal.zzfa r8 = r7.zzd     // Catch:{ all -> 0x0177 }
            zzal(r8)     // Catch:{ all -> 0x0177 }
            boolean r8 = r8.zza()     // Catch:{ all -> 0x0177 }
            if (r8 == 0) goto L_0x015e
            boolean r8 = r7.zzai()     // Catch:{ all -> 0x0177 }
            if (r8 == 0) goto L_0x015e
            r7.zzX()     // Catch:{ all -> 0x0177 }
            goto L_0x0161
        L_0x015e:
            r7.zzag()     // Catch:{ all -> 0x0177 }
        L_0x0161:
            com.google.android.gms.measurement.internal.zzam r8 = r7.zze     // Catch:{ all -> 0x0177 }
            zzal(r8)     // Catch:{ all -> 0x0177 }
            r8.zzC()     // Catch:{ all -> 0x0177 }
            com.google.android.gms.measurement.internal.zzam r8 = r7.zze     // Catch:{ all -> 0x0181 }
            zzal(r8)     // Catch:{ all -> 0x0181 }
            r8.zzx()     // Catch:{ all -> 0x0181 }
            r7.zzt = r0
            r7.zzae()
            return
        L_0x0177:
            r8 = move-exception
            com.google.android.gms.measurement.internal.zzam r9 = r7.zze     // Catch:{ all -> 0x0181 }
            zzal(r9)     // Catch:{ all -> 0x0181 }
            r9.zzx()     // Catch:{ all -> 0x0181 }
            throw r8     // Catch:{ all -> 0x0181 }
        L_0x0181:
            r8 = move-exception
            r7.zzt = r0
            r7.zzae()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlg.zzI(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzJ(boolean z) {
        zzag();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void zzK(int i, Throwable th, byte[] bArr, String str) {
        zzam zzam;
        zzaB().zzg();
        zzB();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzu = false;
                zzae();
                throw th2;
            }
        }
        List<Long> list = (List) Preconditions.checkNotNull(this.zzy);
        this.zzy = null;
        if (i != 200) {
            if (i == 204) {
                i = 204;
            }
            zzaA().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzk.zzd.zzb(zzax().currentTimeMillis());
            if (i == 503 || i == 429) {
                this.zzk.zzb.zzb(zzax().currentTimeMillis());
            }
            zzam zzam2 = this.zze;
            zzal(zzam2);
            zzam2.zzy(list);
            zzag();
            this.zzu = false;
            zzae();
        }
        if (th == null) {
            try {
                this.zzk.zzc.zzb(zzax().currentTimeMillis());
                this.zzk.zzd.zzb(0);
                zzag();
                zzaA().zzj().zzc("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzam zzam3 = this.zze;
                zzal(zzam3);
                zzam3.zzw();
                try {
                    for (Long l : list) {
                        try {
                            zzam = this.zze;
                            zzal(zzam);
                            long longValue = l.longValue();
                            zzam.zzg();
                            zzam.zzW();
                            if (zzam.zzh().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zzam.zzt.zzaA().zzd().zzb("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            List list2 = this.zzz;
                            if (list2 == null || !list2.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zzam zzam4 = this.zze;
                    zzal(zzam4);
                    zzam4.zzC();
                    zzam zzam5 = this.zze;
                    zzal(zzam5);
                    zzam5.zzx();
                    this.zzz = null;
                    zzfa zzfa = this.zzd;
                    zzal(zzfa);
                    if (!zzfa.zza() || !zzai()) {
                        this.zzA = -1;
                        zzag();
                    } else {
                        zzX();
                    }
                    this.zza = 0;
                } catch (Throwable th3) {
                    zzam zzam6 = this.zze;
                    zzal(zzam6);
                    zzam6.zzx();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                zzaA().zzd().zzb("Database error while trying to delete uploaded bundles", e3);
                this.zza = zzax().elapsedRealtime();
                zzaA().zzj().zzb("Disable upload, time", Long.valueOf(this.zza));
            }
            this.zzu = false;
            zzae();
        }
        zzaA().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
        this.zzk.zzd.zzb(zzax().currentTimeMillis());
        this.zzk.zzb.zzb(zzax().currentTimeMillis());
        zzam zzam22 = this.zze;
        zzal(zzam22);
        zzam22.zzy(list);
        zzag();
        this.zzu = false;
        zzae();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03dc A[Catch:{ RuntimeException -> 0x0364, all -> 0x0576 }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0408 A[Catch:{ RuntimeException -> 0x0364, all -> 0x0576 }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x041d A[SYNTHETIC, Splitter:B:137:0x041d] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x04e1 A[Catch:{ RuntimeException -> 0x0364, all -> 0x0576 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0546 A[Catch:{ RuntimeException -> 0x0364, all -> 0x0576 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0126 A[Catch:{ RuntimeException -> 0x0364, all -> 0x0576 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01ef A[Catch:{ RuntimeException -> 0x0364, all -> 0x0576 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01f5 A[Catch:{ RuntimeException -> 0x0364, all -> 0x0576 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x024e A[Catch:{ RuntimeException -> 0x0364, all -> 0x0576 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x025d A[Catch:{ RuntimeException -> 0x0364, all -> 0x0576 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x026d A[Catch:{ RuntimeException -> 0x0364, all -> 0x0576 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzL(com.google.android.gms.measurement.internal.zzq r24) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "com.android.vending"
            java.lang.String r6 = "_pfo"
            java.lang.String r0 = "_npa"
            java.lang.String r7 = "_uwa"
            java.lang.String r8 = "app_id=?"
            com.google.android.gms.measurement.internal.zzgb r9 = r23.zzaB()
            r9.zzg()
            r23.zzB()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r24)
            java.lang.String r9 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            boolean r9 = zzak(r24)
            if (r9 == 0) goto L_0x0580
            com.google.android.gms.measurement.internal.zzam r9 = r1.zze
            zzal(r9)
            java.lang.String r10 = r2.zza
            com.google.android.gms.measurement.internal.zzh r9 = r9.zzj(r10)
            r10 = 0
            if (r9 == 0) goto L_0x0060
            java.lang.String r12 = r9.zzz()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 == 0) goto L_0x0060
            java.lang.String r12 = r2.zzb
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x0060
            r9.zzM(r10)
            com.google.android.gms.measurement.internal.zzam r12 = r1.zze
            zzal(r12)
            r12.zzD(r9)
            com.google.android.gms.measurement.internal.zzfv r9 = r1.zzc
            zzal(r9)
            java.lang.String r12 = r2.zza
            r9.zzm(r12)
        L_0x0060:
            boolean r9 = r2.zzh
            if (r9 != 0) goto L_0x0068
            r23.zzd(r24)
            return
        L_0x0068:
            long r12 = r2.zzm
            int r9 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r9 != 0) goto L_0x0076
            com.google.android.gms.common.util.Clock r9 = r23.zzax()
            long r12 = r9.currentTimeMillis()
        L_0x0076:
            com.google.android.gms.measurement.internal.zzge r9 = r1.zzn
            com.google.android.gms.measurement.internal.zzaq r9 = r9.zzg()
            r9.zzd()
            int r9 = r2.zzn
            r15 = 1
            if (r9 == 0) goto L_0x009e
            if (r9 == r15) goto L_0x009e
            com.google.android.gms.measurement.internal.zzeu r16 = r23.zzaA()
            com.google.android.gms.measurement.internal.zzes r14 = r16.zzk()
            java.lang.String r10 = r2.zza
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzeu.zzn(r10)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r11 = "Incorrect app type, assuming installed app. appId, appType"
            r14.zzc(r11, r10, r9)
            r9 = 0
        L_0x009e:
            com.google.android.gms.measurement.internal.zzam r10 = r1.zze
            zzal(r10)
            r10.zzw()
            com.google.android.gms.measurement.internal.zzam r10 = r1.zze     // Catch:{ all -> 0x0576 }
            zzal(r10)     // Catch:{ all -> 0x0576 }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzll r10 = r10.zzp(r11, r0)     // Catch:{ all -> 0x0576 }
            r11 = r3
            r20 = r4
            if (r10 == 0) goto L_0x00c3
            java.lang.String r14 = "auto"
            java.lang.String r3 = r10.zzb     // Catch:{ all -> 0x0576 }
            boolean r3 = r14.equals(r3)     // Catch:{ all -> 0x0576 }
            if (r3 == 0) goto L_0x00c1
            goto L_0x00c3
        L_0x00c1:
            r4 = 1
            goto L_0x00fd
        L_0x00c3:
            java.lang.Boolean r3 = r2.zzr     // Catch:{ all -> 0x0576 }
            if (r3 == 0) goto L_0x00f7
            com.google.android.gms.measurement.internal.zzlj r0 = new com.google.android.gms.measurement.internal.zzlj     // Catch:{ all -> 0x0576 }
            java.lang.String r3 = "_npa"
            java.lang.Boolean r4 = r2.zzr     // Catch:{ all -> 0x0576 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x0576 }
            if (r15 == r4) goto L_0x00d6
            r18 = 0
            goto L_0x00d8
        L_0x00d6:
            r18 = 1
        L_0x00d8:
            java.lang.Long r18 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x0576 }
            java.lang.String r19 = "auto"
            r4 = 0
            r14 = r0
            r4 = 1
            r15 = r3
            r16 = r12
            r14.<init>(r15, r16, r18, r19)     // Catch:{ all -> 0x0576 }
            if (r10 == 0) goto L_0x00f3
            java.lang.Object r3 = r10.zze     // Catch:{ all -> 0x0576 }
            java.lang.Long r10 = r0.zzd     // Catch:{ all -> 0x0576 }
            boolean r3 = r3.equals(r10)     // Catch:{ all -> 0x0576 }
            if (r3 != 0) goto L_0x00fd
        L_0x00f3:
            r1.zzW(r0, r2)     // Catch:{ all -> 0x0576 }
            goto L_0x00fd
        L_0x00f7:
            r4 = 1
            if (r10 == 0) goto L_0x00fd
            r1.zzP(r0, r2)     // Catch:{ all -> 0x0576 }
        L_0x00fd:
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0576 }
            zzal(r0)     // Catch:{ all -> 0x0576 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x0576 }
            java.lang.Object r3 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0576 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzh r0 = r0.zzj(r3)     // Catch:{ all -> 0x0576 }
            if (r0 == 0) goto L_0x01ef
            com.google.android.gms.measurement.internal.zzlo r10 = r23.zzv()     // Catch:{ all -> 0x0576 }
            java.lang.String r14 = r2.zzb     // Catch:{ all -> 0x0576 }
            java.lang.String r15 = r0.zzz()     // Catch:{ all -> 0x0576 }
            java.lang.String r3 = r2.zzq     // Catch:{ all -> 0x0576 }
            java.lang.String r4 = r0.zzs()     // Catch:{ all -> 0x0576 }
            boolean r3 = r10.zzao(r14, r15, r3, r4)     // Catch:{ all -> 0x0576 }
            if (r3 == 0) goto L_0x01ef
            com.google.android.gms.measurement.internal.zzeu r3 = r23.zzaA()     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzk()     // Catch:{ all -> 0x0576 }
            java.lang.String r4 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r10 = r0.zzu()     // Catch:{ all -> 0x0576 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzeu.zzn(r10)     // Catch:{ all -> 0x0576 }
            r3.zzb(r4, r10)     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze     // Catch:{ all -> 0x0576 }
            zzal(r3)     // Catch:{ all -> 0x0576 }
            java.lang.String r4 = r0.zzu()     // Catch:{ all -> 0x0576 }
            r3.zzW()     // Catch:{ all -> 0x0576 }
            r3.zzg()     // Catch:{ all -> 0x0576 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)     // Catch:{ all -> 0x0576 }
            android.database.sqlite.SQLiteDatabase r0 = r3.zzh()     // Catch:{ SQLiteException -> 0x01d5 }
            r10 = 1
            java.lang.String[] r14 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x01d5 }
            r10 = 0
            r14[r10] = r4     // Catch:{ SQLiteException -> 0x01d5 }
            java.lang.String r10 = "events"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            java.lang.String r15 = "user_attributes"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            int r10 = r10 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            int r10 = r10 + r15
            java.lang.String r15 = "apps"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            int r10 = r10 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            int r10 = r10 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            int r10 = r10 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            int r10 = r10 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            int r10 = r10 + r15
            java.lang.String r15 = "audience_filter_values"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            int r10 = r10 + r15
            java.lang.String r15 = "consent_settings"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            int r10 = r10 + r15
            com.google.android.gms.internal.measurement.zzph.zzc()     // Catch:{ SQLiteException -> 0x01d5 }
            com.google.android.gms.measurement.internal.zzge r15 = r3.zzt     // Catch:{ SQLiteException -> 0x01d5 }
            com.google.android.gms.measurement.internal.zzag r15 = r15.zzf()     // Catch:{ SQLiteException -> 0x01d5 }
            r21 = r11
            com.google.android.gms.measurement.internal.zzeg r11 = com.google.android.gms.measurement.internal.zzeh.zzat     // Catch:{ SQLiteException -> 0x01d1 }
            r22 = r6
            r6 = 0
            boolean r11 = r15.zzs(r6, r11)     // Catch:{ SQLiteException -> 0x01cf }
            if (r11 == 0) goto L_0x01b9
            java.lang.String r6 = "default_event_params"
            int r0 = r0.delete(r6, r8, r14)     // Catch:{ SQLiteException -> 0x01cf }
            int r10 = r10 + r0
        L_0x01b9:
            if (r10 <= 0) goto L_0x01ed
            com.google.android.gms.measurement.internal.zzge r0 = r3.zzt     // Catch:{ SQLiteException -> 0x01cf }
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()     // Catch:{ SQLiteException -> 0x01cf }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzj()     // Catch:{ SQLiteException -> 0x01cf }
            java.lang.String r6 = "Deleted application data. app, records"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)     // Catch:{ SQLiteException -> 0x01cf }
            r0.zzc(r6, r4, r8)     // Catch:{ SQLiteException -> 0x01cf }
            goto L_0x01ed
        L_0x01cf:
            r0 = move-exception
            goto L_0x01da
        L_0x01d1:
            r0 = move-exception
            r22 = r6
            goto L_0x01da
        L_0x01d5:
            r0 = move-exception
            r22 = r6
            r21 = r11
        L_0x01da:
            com.google.android.gms.measurement.internal.zzge r3 = r3.zzt     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzeu r3 = r3.zzaA()     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzd()     // Catch:{ all -> 0x0576 }
            java.lang.String r6 = "Error deleting application data. appId, error"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeu.zzn(r4)     // Catch:{ all -> 0x0576 }
            r3.zzc(r6, r4, r0)     // Catch:{ all -> 0x0576 }
        L_0x01ed:
            r0 = 0
            goto L_0x01f3
        L_0x01ef:
            r22 = r6
            r21 = r11
        L_0x01f3:
            if (r0 == 0) goto L_0x0249
            long r3 = r0.zzb()     // Catch:{ all -> 0x0576 }
            r10 = -2147483648(0xffffffff80000000, double:NaN)
            int r6 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x020c
            long r3 = r0.zzb()     // Catch:{ all -> 0x0576 }
            long r14 = r2.zzj     // Catch:{ all -> 0x0576 }
            int r6 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x020c
            r15 = 1
            goto L_0x020d
        L_0x020c:
            r15 = 0
        L_0x020d:
            java.lang.String r3 = r0.zzx()     // Catch:{ all -> 0x0576 }
            long r16 = r0.zzb()     // Catch:{ all -> 0x0576 }
            int r0 = (r16 > r10 ? 1 : (r16 == r10 ? 0 : -1))
            if (r0 != 0) goto L_0x0225
            if (r3 == 0) goto L_0x0225
            java.lang.String r0 = r2.zzc     // Catch:{ all -> 0x0576 }
            boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x0576 }
            if (r0 != 0) goto L_0x0225
            r0 = 1
            goto L_0x0226
        L_0x0225:
            r0 = 0
        L_0x0226:
            r0 = r0 | r15
            if (r0 == 0) goto L_0x0249
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x0576 }
            r0.<init>()     // Catch:{ all -> 0x0576 }
            java.lang.String r4 = "_pv"
            r0.putString(r4, r3)     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzaw r3 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x0576 }
            java.lang.String r15 = "_au"
            com.google.android.gms.measurement.internal.zzau r4 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x0576 }
            r4.<init>(r0)     // Catch:{ all -> 0x0576 }
            java.lang.String r17 = "auto"
            r14 = r3
            r16 = r4
            r18 = r12
            r14.<init>(r15, r16, r17, r18)     // Catch:{ all -> 0x0576 }
            r1.zzE(r3, r2)     // Catch:{ all -> 0x0576 }
        L_0x0249:
            r23.zzd(r24)     // Catch:{ all -> 0x0576 }
            if (r9 != 0) goto L_0x025d
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0576 }
            zzal(r0)     // Catch:{ all -> 0x0576 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x0576 }
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzn(r3, r4)     // Catch:{ all -> 0x0576 }
            r15 = 0
            goto L_0x026b
        L_0x025d:
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0576 }
            zzal(r0)     // Catch:{ all -> 0x0576 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x0576 }
            java.lang.String r4 = "_v"
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzn(r3, r4)     // Catch:{ all -> 0x0576 }
            r15 = 1
        L_0x026b:
            if (r0 != 0) goto L_0x0546
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r8 = r12 / r3
            r10 = 1
            long r8 = r8 + r10
            long r8 = r8 * r3
            java.lang.String r3 = "_dac"
            java.lang.String r4 = "_et"
            java.lang.String r6 = "_r"
            java.lang.String r10 = "_c"
            if (r15 != 0) goto L_0x04fb
            com.google.android.gms.measurement.internal.zzlj r0 = new com.google.android.gms.measurement.internal.zzlj     // Catch:{ all -> 0x0576 }
            java.lang.String r15 = "_fot"
            java.lang.Long r18 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0576 }
            java.lang.String r19 = "auto"
            r14 = r0
            r16 = r12
            r14.<init>(r15, r16, r18, r19)     // Catch:{ all -> 0x0576 }
            r1.zzW(r0, r2)     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzgb r0 = r23.zzaB()     // Catch:{ all -> 0x0576 }
            r0.zzg()     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzfm r0 = r1.zzm     // Catch:{ all -> 0x0576 }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x0576 }
            r8 = r0
            com.google.android.gms.measurement.internal.zzfm r8 = (com.google.android.gms.measurement.internal.zzfm) r8     // Catch:{ all -> 0x0576 }
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x0576 }
            if (r0 == 0) goto L_0x0399
            boolean r9 = r0.isEmpty()     // Catch:{ all -> 0x0576 }
            if (r9 == 0) goto L_0x02b0
            goto L_0x0399
        L_0x02b0:
            com.google.android.gms.measurement.internal.zzge r9 = r8.zza     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzgb r9 = r9.zzaB()     // Catch:{ all -> 0x0576 }
            r9.zzg()     // Catch:{ all -> 0x0576 }
            boolean r9 = r8.zza()     // Catch:{ all -> 0x0576 }
            if (r9 != 0) goto L_0x02d0
            com.google.android.gms.measurement.internal.zzge r0 = r8.zza     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzi()     // Catch:{ all -> 0x0576 }
            java.lang.String r5 = "Install Referrer Reporter is not available"
            r0.zza(r5)     // Catch:{ all -> 0x0576 }
            goto L_0x03a8
        L_0x02d0:
            com.google.android.gms.measurement.internal.zzfl r9 = new com.google.android.gms.measurement.internal.zzfl     // Catch:{ all -> 0x0576 }
            r9.<init>(r8, r0)     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzge r0 = r8.zza     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzgb r0 = r0.zzaB()     // Catch:{ all -> 0x0576 }
            r0.zzg()     // Catch:{ all -> 0x0576 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x0576 }
            java.lang.String r11 = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE"
            r0.<init>(r11)     // Catch:{ all -> 0x0576 }
            android.content.ComponentName r11 = new android.content.ComponentName     // Catch:{ all -> 0x0576 }
            java.lang.String r14 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService"
            r11.<init>(r5, r14)     // Catch:{ all -> 0x0576 }
            r0.setComponent(r11)     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzge r11 = r8.zza     // Catch:{ all -> 0x0576 }
            android.content.Context r11 = r11.zzaw()     // Catch:{ all -> 0x0576 }
            android.content.pm.PackageManager r11 = r11.getPackageManager()     // Catch:{ all -> 0x0576 }
            if (r11 != 0) goto L_0x030c
            com.google.android.gms.measurement.internal.zzge r0 = r8.zza     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzm()     // Catch:{ all -> 0x0576 }
            java.lang.String r5 = "Failed to obtain Package Manager to verify binding conditions for Install Referrer"
            r0.zza(r5)     // Catch:{ all -> 0x0576 }
            goto L_0x03a8
        L_0x030c:
            r14 = 0
            java.util.List r11 = r11.queryIntentServices(r0, r14)     // Catch:{ all -> 0x0576 }
            if (r11 == 0) goto L_0x0389
            boolean r15 = r11.isEmpty()     // Catch:{ all -> 0x0576 }
            if (r15 != 0) goto L_0x0389
            java.lang.Object r11 = r11.get(r14)     // Catch:{ all -> 0x0576 }
            android.content.pm.ResolveInfo r11 = (android.content.pm.ResolveInfo) r11     // Catch:{ all -> 0x0576 }
            android.content.pm.ServiceInfo r14 = r11.serviceInfo     // Catch:{ all -> 0x0576 }
            if (r14 == 0) goto L_0x03a8
            android.content.pm.ServiceInfo r14 = r11.serviceInfo     // Catch:{ all -> 0x0576 }
            java.lang.String r14 = r14.packageName     // Catch:{ all -> 0x0576 }
            android.content.pm.ServiceInfo r11 = r11.serviceInfo     // Catch:{ all -> 0x0576 }
            java.lang.String r11 = r11.name     // Catch:{ all -> 0x0576 }
            if (r11 == 0) goto L_0x0379
            boolean r5 = r5.equals(r14)     // Catch:{ all -> 0x0576 }
            if (r5 == 0) goto L_0x0379
            boolean r5 = r8.zza()     // Catch:{ all -> 0x0576 }
            if (r5 == 0) goto L_0x0379
            android.content.Intent r5 = new android.content.Intent     // Catch:{ all -> 0x0576 }
            r5.<init>(r0)     // Catch:{ all -> 0x0576 }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ RuntimeException -> 0x0364 }
            com.google.android.gms.measurement.internal.zzge r11 = r8.zza     // Catch:{ RuntimeException -> 0x0364 }
            android.content.Context r11 = r11.zzaw()     // Catch:{ RuntimeException -> 0x0364 }
            r14 = 1
            boolean r0 = r0.bindService(r11, r5, r9, r14)     // Catch:{ RuntimeException -> 0x0364 }
            com.google.android.gms.measurement.internal.zzge r5 = r8.zza     // Catch:{ RuntimeException -> 0x0364 }
            com.google.android.gms.measurement.internal.zzeu r5 = r5.zzaA()     // Catch:{ RuntimeException -> 0x0364 }
            com.google.android.gms.measurement.internal.zzes r5 = r5.zzj()     // Catch:{ RuntimeException -> 0x0364 }
            java.lang.String r9 = "Install Referrer Service is"
            if (r0 == 0) goto L_0x035e
            java.lang.String r0 = "available"
            goto L_0x0360
        L_0x035e:
            java.lang.String r0 = "not available"
        L_0x0360:
            r5.zzb(r9, r0)     // Catch:{ RuntimeException -> 0x0364 }
            goto L_0x03a8
        L_0x0364:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzge r5 = r8.zza     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzeu r5 = r5.zzaA()     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzes r5 = r5.zzd()     // Catch:{ all -> 0x0576 }
            java.lang.String r8 = "Exception occurred while binding to Install Referrer Service"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0576 }
            r5.zzb(r8, r0)     // Catch:{ all -> 0x0576 }
            goto L_0x03a8
        L_0x0379:
            com.google.android.gms.measurement.internal.zzge r0 = r8.zza     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzk()     // Catch:{ all -> 0x0576 }
            java.lang.String r5 = "Play Store version 8.3.73 or higher required for Install Referrer"
            r0.zza(r5)     // Catch:{ all -> 0x0576 }
            goto L_0x03a8
        L_0x0389:
            com.google.android.gms.measurement.internal.zzge r0 = r8.zza     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzi()     // Catch:{ all -> 0x0576 }
            java.lang.String r5 = "Play Service for fetching Install Referrer is unavailable on device"
            r0.zza(r5)     // Catch:{ all -> 0x0576 }
            goto L_0x03a8
        L_0x0399:
            com.google.android.gms.measurement.internal.zzge r0 = r8.zza     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzm()     // Catch:{ all -> 0x0576 }
            java.lang.String r5 = "Install Referrer Reporter was called with invalid app package name"
            r0.zza(r5)     // Catch:{ all -> 0x0576 }
        L_0x03a8:
            com.google.android.gms.measurement.internal.zzgb r0 = r23.zzaB()     // Catch:{ all -> 0x0576 }
            r0.zzg()     // Catch:{ all -> 0x0576 }
            r23.zzB()     // Catch:{ all -> 0x0576 }
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x0576 }
            r5.<init>()     // Catch:{ all -> 0x0576 }
            r8 = 1
            r5.putLong(r10, r8)     // Catch:{ all -> 0x0576 }
            r5.putLong(r6, r8)     // Catch:{ all -> 0x0576 }
            r8 = 0
            r5.putLong(r7, r8)     // Catch:{ all -> 0x0576 }
            r6 = r22
            r5.putLong(r6, r8)     // Catch:{ all -> 0x0576 }
            r10 = r20
            r5.putLong(r10, r8)     // Catch:{ all -> 0x0576 }
            r11 = r21
            r5.putLong(r11, r8)     // Catch:{ all -> 0x0576 }
            r8 = 1
            r5.putLong(r4, r8)     // Catch:{ all -> 0x0576 }
            boolean r0 = r2.zzp     // Catch:{ all -> 0x0576 }
            if (r0 == 0) goto L_0x03df
            r5.putLong(r3, r8)     // Catch:{ all -> 0x0576 }
        L_0x03df:
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x0576 }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x0576 }
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0576 }
            zzal(r0)     // Catch:{ all -> 0x0576 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x0576 }
            r0.zzg()     // Catch:{ all -> 0x0576 }
            r0.zzW()     // Catch:{ all -> 0x0576 }
            java.lang.String r4 = "first_open_count"
            long r8 = r0.zzc(r3, r4)     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzge r0 = r1.zzn     // Catch:{ all -> 0x0576 }
            android.content.Context r0 = r0.zzaw()     // Catch:{ all -> 0x0576 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x0576 }
            if (r0 != 0) goto L_0x041d
            com.google.android.gms.measurement.internal.zzeu r0 = r23.zzaA()     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzd()     // Catch:{ all -> 0x0576 }
            java.lang.String r4 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeu.zzn(r3)     // Catch:{ all -> 0x0576 }
            r0.zzb(r4, r3)     // Catch:{ all -> 0x0576 }
        L_0x0419:
            r3 = 0
            goto L_0x04dd
        L_0x041d:
            com.google.android.gms.measurement.internal.zzge r0 = r1.zzn     // Catch:{ NameNotFoundException -> 0x042d }
            android.content.Context r0 = r0.zzaw()     // Catch:{ NameNotFoundException -> 0x042d }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x042d }
            r4 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r3, r4)     // Catch:{ NameNotFoundException -> 0x042d }
            goto L_0x0440
        L_0x042d:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzeu r4 = r23.zzaA()     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzd()     // Catch:{ all -> 0x0576 }
            java.lang.String r14 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzeu.zzn(r3)     // Catch:{ all -> 0x0576 }
            r4.zzc(r14, r15, r0)     // Catch:{ all -> 0x0576 }
            r0 = 0
        L_0x0440:
            if (r0 == 0) goto L_0x0497
            long r14 = r0.firstInstallTime     // Catch:{ all -> 0x0576 }
            r16 = 0
            int r4 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r4 == 0) goto L_0x0497
            long r14 = r0.firstInstallTime     // Catch:{ all -> 0x0576 }
            r20 = r10
            r21 = r11
            long r10 = r0.lastUpdateTime     // Catch:{ all -> 0x0576 }
            int r0 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x0478
            com.google.android.gms.measurement.internal.zzag r0 = r23.zzg()     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzeg r4 = com.google.android.gms.measurement.internal.zzeh.zzad     // Catch:{ all -> 0x0576 }
            r10 = 0
            boolean r0 = r0.zzs(r10, r4)     // Catch:{ all -> 0x0576 }
            if (r0 == 0) goto L_0x0472
            r14 = 0
            int r0 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r0 != 0) goto L_0x0470
            r14 = 1
            r5.putLong(r7, r14)     // Catch:{ all -> 0x0576 }
            r8 = 0
        L_0x0470:
            r15 = 0
            goto L_0x047a
        L_0x0472:
            r14 = 1
            r5.putLong(r7, r14)     // Catch:{ all -> 0x0576 }
            goto L_0x0470
        L_0x0478:
            r10 = 0
            r15 = 1
        L_0x047a:
            com.google.android.gms.measurement.internal.zzlj r0 = new com.google.android.gms.measurement.internal.zzlj     // Catch:{ all -> 0x0576 }
            java.lang.String r4 = "_fi"
            r7 = 1
            if (r7 == r15) goto L_0x0484
            r14 = 0
            goto L_0x0486
        L_0x0484:
            r14 = 1
        L_0x0486:
            java.lang.Long r18 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0576 }
            java.lang.String r19 = "auto"
            r14 = r0
            r15 = r4
            r16 = r12
            r14.<init>(r15, r16, r18, r19)     // Catch:{ all -> 0x0576 }
            r1.zzW(r0, r2)     // Catch:{ all -> 0x0576 }
            goto L_0x049c
        L_0x0497:
            r20 = r10
            r21 = r11
            r10 = 0
        L_0x049c:
            com.google.android.gms.measurement.internal.zzge r0 = r1.zzn     // Catch:{ NameNotFoundException -> 0x04ac }
            android.content.Context r0 = r0.zzaw()     // Catch:{ NameNotFoundException -> 0x04ac }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x04ac }
            r4 = 0
            android.content.pm.ApplicationInfo r3 = r0.getApplicationInfo(r3, r4)     // Catch:{ NameNotFoundException -> 0x04ac }
            goto L_0x04bf
        L_0x04ac:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzeu r4 = r23.zzaA()     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzd()     // Catch:{ all -> 0x0576 }
            java.lang.String r7 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeu.zzn(r3)     // Catch:{ all -> 0x0576 }
            r4.zzc(r7, r3, r0)     // Catch:{ all -> 0x0576 }
            r3 = r10
        L_0x04bf:
            if (r3 == 0) goto L_0x0419
            int r0 = r3.flags     // Catch:{ all -> 0x0576 }
            r4 = 1
            r0 = r0 & r4
            if (r0 == 0) goto L_0x04ce
            r4 = r20
            r10 = 1
            r5.putLong(r4, r10)     // Catch:{ all -> 0x0576 }
        L_0x04ce:
            int r0 = r3.flags     // Catch:{ all -> 0x0576 }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0419
            r3 = r21
            r10 = 1
            r5.putLong(r3, r10)     // Catch:{ all -> 0x0576 }
            goto L_0x0419
        L_0x04dd:
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x04e4
            r5.putLong(r6, r8)     // Catch:{ all -> 0x0576 }
        L_0x04e4:
            com.google.android.gms.measurement.internal.zzaw r0 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x0576 }
            java.lang.String r15 = "_f"
            com.google.android.gms.measurement.internal.zzau r3 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x0576 }
            r3.<init>(r5)     // Catch:{ all -> 0x0576 }
            java.lang.String r17 = "auto"
            r14 = r0
            r16 = r3
            r18 = r12
            r14.<init>(r15, r16, r17, r18)     // Catch:{ all -> 0x0576 }
            r1.zzG(r0, r2)     // Catch:{ all -> 0x0576 }
            goto L_0x0565
        L_0x04fb:
            com.google.android.gms.measurement.internal.zzlj r0 = new com.google.android.gms.measurement.internal.zzlj     // Catch:{ all -> 0x0576 }
            java.lang.String r15 = "_fvt"
            java.lang.Long r18 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0576 }
            java.lang.String r19 = "auto"
            r14 = r0
            r16 = r12
            r14.<init>(r15, r16, r18, r19)     // Catch:{ all -> 0x0576 }
            r1.zzW(r0, r2)     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzgb r0 = r23.zzaB()     // Catch:{ all -> 0x0576 }
            r0.zzg()     // Catch:{ all -> 0x0576 }
            r23.zzB()     // Catch:{ all -> 0x0576 }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x0576 }
            r0.<init>()     // Catch:{ all -> 0x0576 }
            r7 = 1
            r0.putLong(r10, r7)     // Catch:{ all -> 0x0576 }
            r0.putLong(r6, r7)     // Catch:{ all -> 0x0576 }
            r0.putLong(r4, r7)     // Catch:{ all -> 0x0576 }
            boolean r4 = r2.zzp     // Catch:{ all -> 0x0576 }
            if (r4 == 0) goto L_0x052f
            r0.putLong(r3, r7)     // Catch:{ all -> 0x0576 }
        L_0x052f:
            com.google.android.gms.measurement.internal.zzaw r3 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x0576 }
            java.lang.String r15 = "_v"
            com.google.android.gms.measurement.internal.zzau r4 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x0576 }
            r4.<init>(r0)     // Catch:{ all -> 0x0576 }
            java.lang.String r17 = "auto"
            r14 = r3
            r16 = r4
            r18 = r12
            r14.<init>(r15, r16, r17, r18)     // Catch:{ all -> 0x0576 }
            r1.zzG(r3, r2)     // Catch:{ all -> 0x0576 }
            goto L_0x0565
        L_0x0546:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x0576 }
            if (r0 == 0) goto L_0x0565
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x0576 }
            r0.<init>()     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzaw r3 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x0576 }
            java.lang.String r15 = "_cd"
            com.google.android.gms.measurement.internal.zzau r4 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x0576 }
            r4.<init>(r0)     // Catch:{ all -> 0x0576 }
            java.lang.String r17 = "auto"
            r14 = r3
            r16 = r4
            r18 = r12
            r14.<init>(r15, r16, r17, r18)     // Catch:{ all -> 0x0576 }
            r1.zzG(r3, r2)     // Catch:{ all -> 0x0576 }
        L_0x0565:
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0576 }
            zzal(r0)     // Catch:{ all -> 0x0576 }
            r0.zzC()     // Catch:{ all -> 0x0576 }
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze
            zzal(r0)
            r0.zzx()
            return
        L_0x0576:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            throw r0
        L_0x0580:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlg.zzL(com.google.android.gms.measurement.internal.zzq):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzM() {
        this.zzr++;
    }

    /* access modifiers changed from: package-private */
    public final void zzN(zzac zzac) {
        zzq zzac2 = zzac((String) Preconditions.checkNotNull(zzac.zza));
        if (zzac2 != null) {
            zzO(zzac, zzac2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzO(zzac zzac, zzq zzq2) {
        Preconditions.checkNotNull(zzac);
        Preconditions.checkNotEmpty(zzac.zza);
        Preconditions.checkNotNull(zzac.zzc);
        Preconditions.checkNotEmpty(zzac.zzc.zzb);
        zzaB().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (zzq2.zzh) {
                zzam zzam = this.zze;
                zzal(zzam);
                zzam.zzw();
                try {
                    zzd(zzq2);
                    String str = (String) Preconditions.checkNotNull(zzac.zza);
                    zzam zzam2 = this.zze;
                    zzal(zzam2);
                    zzac zzk2 = zzam2.zzk(str, zzac.zzc.zzb);
                    if (zzk2 != null) {
                        zzaA().zzc().zzc("Removing conditional user property", zzac.zza, this.zzn.zzj().zzf(zzac.zzc.zzb));
                        zzam zzam3 = this.zze;
                        zzal(zzam3);
                        zzam3.zza(str, zzac.zzc.zzb);
                        if (zzk2.zze) {
                            zzam zzam4 = this.zze;
                            zzal(zzam4);
                            zzam4.zzA(str, zzac.zzc.zzb);
                        }
                        zzaw zzaw = zzac.zzk;
                        if (zzaw != null) {
                            zzau zzau = zzaw.zzb;
                            zzY((zzaw) Preconditions.checkNotNull(zzv().zzz(str, ((zzaw) Preconditions.checkNotNull(zzac.zzk)).zza, zzau != null ? zzau.zzc() : null, zzk2.zzb, zzac.zzk.zzd, true, true)), zzq2);
                        }
                    } else {
                        zzaA().zzk().zzc("Conditional user property doesn't exist", zzeu.zzn(zzac.zza), this.zzn.zzj().zzf(zzac.zzc.zzb));
                    }
                    zzam zzam5 = this.zze;
                    zzal(zzam5);
                    zzam5.zzC();
                } finally {
                    zzam zzam6 = this.zze;
                    zzal(zzam6);
                    zzam6.zzx();
                }
            } else {
                zzd(zzq2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzP(String str, zzq zzq2) {
        zzaB().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (!zzq2.zzh) {
                zzd(zzq2);
            } else if (!"_npa".equals(str) || zzq2.zzr == null) {
                zzaA().zzc().zzb("Removing user property", this.zzn.zzj().zzf(str));
                zzam zzam = this.zze;
                zzal(zzam);
                zzam.zzw();
                try {
                    zzd(zzq2);
                    if ("_id".equals(str)) {
                        zzam zzam2 = this.zze;
                        zzal(zzam2);
                        zzam2.zzA((String) Preconditions.checkNotNull(zzq2.zza), "_lair");
                    }
                    zzam zzam3 = this.zze;
                    zzal(zzam3);
                    zzam3.zzA((String) Preconditions.checkNotNull(zzq2.zza), str);
                    zzam zzam4 = this.zze;
                    zzal(zzam4);
                    zzam4.zzC();
                    zzaA().zzc().zzb("User property removed", this.zzn.zzj().zzf(str));
                } finally {
                    zzam zzam5 = this.zze;
                    zzal(zzam5);
                    zzam5.zzx();
                }
            } else {
                zzaA().zzc().zza("Falling back to manifest metadata value for ad personalization");
                zzW(new zzlj("_npa", zzax().currentTimeMillis(), Long.valueOf(true != zzq2.zzr.booleanValue() ? 0 : 1), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzq2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzQ(zzq zzq2) {
        if (this.zzy != null) {
            ArrayList arrayList = new ArrayList();
            this.zzz = arrayList;
            arrayList.addAll(this.zzy);
        }
        zzam zzam = this.zze;
        zzal(zzam);
        String str = (String) Preconditions.checkNotNull(zzq2.zza);
        Preconditions.checkNotEmpty(str);
        zzam.zzg();
        zzam.zzW();
        try {
            SQLiteDatabase zzh2 = zzam.zzh();
            String[] strArr = {str};
            int delete = zzh2.delete("apps", "app_id=?", strArr) + zzh2.delete("events", "app_id=?", strArr) + zzh2.delete("user_attributes", "app_id=?", strArr) + zzh2.delete("conditional_properties", "app_id=?", strArr) + zzh2.delete("raw_events", "app_id=?", strArr) + zzh2.delete("raw_events_metadata", "app_id=?", strArr) + zzh2.delete("queue", "app_id=?", strArr) + zzh2.delete("audience_filter_values", "app_id=?", strArr) + zzh2.delete("main_event_params", "app_id=?", strArr) + zzh2.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzam.zzt.zzaA().zzj().zzc("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzam.zzt.zzaA().zzd().zzc("Error resetting analytics data. appId, error", zzeu.zzn(str), e);
        }
        if (zzq2.zzh) {
            zzL(zzq2);
        }
    }

    public final void zzR(String str, zziq zziq) {
        zzaB().zzg();
        String str2 = this.zzE;
        if (str2 == null || str2.equals(str) || zziq != null) {
            this.zzE = str;
            this.zzD = zziq;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzS() {
        zzaB().zzg();
        zzam zzam = this.zze;
        zzal(zzam);
        zzam.zzz();
        if (this.zzk.zzc.zza() == 0) {
            this.zzk.zzc.zzb(zzax().currentTimeMillis());
        }
        zzag();
    }

    /* access modifiers changed from: package-private */
    public final void zzT(zzac zzac) {
        zzq zzac2 = zzac((String) Preconditions.checkNotNull(zzac.zza));
        if (zzac2 != null) {
            zzU(zzac, zzac2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzU(zzac zzac, zzq zzq2) {
        Preconditions.checkNotNull(zzac);
        Preconditions.checkNotEmpty(zzac.zza);
        Preconditions.checkNotNull(zzac.zzb);
        Preconditions.checkNotNull(zzac.zzc);
        Preconditions.checkNotEmpty(zzac.zzc.zzb);
        zzaB().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (!zzq2.zzh) {
                zzd(zzq2);
                return;
            }
            zzac zzac2 = new zzac(zzac);
            boolean z = false;
            zzac2.zze = false;
            zzam zzam = this.zze;
            zzal(zzam);
            zzam.zzw();
            try {
                zzam zzam2 = this.zze;
                zzal(zzam2);
                zzac zzk2 = zzam2.zzk((String) Preconditions.checkNotNull(zzac2.zza), zzac2.zzc.zzb);
                if (zzk2 != null && !zzk2.zzb.equals(zzac2.zzb)) {
                    zzaA().zzk().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzb, zzk2.zzb);
                }
                if (zzk2 != null && zzk2.zze) {
                    zzac2.zzb = zzk2.zzb;
                    zzac2.zzd = zzk2.zzd;
                    zzac2.zzh = zzk2.zzh;
                    zzac2.zzf = zzk2.zzf;
                    zzac2.zzi = zzk2.zzi;
                    zzac2.zze = true;
                    zzlj zzlj = zzac2.zzc;
                    zzac2.zzc = new zzlj(zzlj.zzb, zzk2.zzc.zzc, zzlj.zza(), zzk2.zzc.zzf);
                } else if (TextUtils.isEmpty(zzac2.zzf)) {
                    zzlj zzlj2 = zzac2.zzc;
                    zzac2.zzc = new zzlj(zzlj2.zzb, zzac2.zzd, zzlj2.zza(), zzac2.zzc.zzf);
                    zzac2.zze = true;
                    z = true;
                }
                if (zzac2.zze) {
                    zzlj zzlj3 = zzac2.zzc;
                    zzll zzll = new zzll((String) Preconditions.checkNotNull(zzac2.zza), zzac2.zzb, zzlj3.zzb, zzlj3.zzc, Preconditions.checkNotNull(zzlj3.zza()));
                    zzam zzam3 = this.zze;
                    zzal(zzam3);
                    if (zzam3.zzL(zzll)) {
                        zzaA().zzc().zzd("User property updated immediately", zzac2.zza, this.zzn.zzj().zzf(zzll.zzc), zzll.zze);
                    } else {
                        zzaA().zzd().zzd("(2)Too many active user properties, ignoring", zzeu.zzn(zzac2.zza), this.zzn.zzj().zzf(zzll.zzc), zzll.zze);
                    }
                    if (z && zzac2.zzi != null) {
                        zzY(new zzaw(zzac2.zzi, zzac2.zzd), zzq2);
                    }
                }
                zzam zzam4 = this.zze;
                zzal(zzam4);
                if (zzam4.zzK(zzac2)) {
                    zzaA().zzc().zzd("Conditional property added", zzac2.zza, this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzc.zza());
                } else {
                    zzaA().zzd().zzd("Too many conditional properties, ignoring", zzeu.zzn(zzac2.zza), this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzc.zza());
                }
                zzam zzam5 = this.zze;
                zzal(zzam5);
                zzam5.zzC();
            } finally {
                zzam zzam6 = this.zze;
                zzal(zzam6);
                zzam6.zzx();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzV(String str, zzai zzai) {
        zzaB().zzg();
        zzB();
        this.zzB.put(str, zzai);
        zzam zzam = this.zze;
        zzal(zzam);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzai);
        zzam.zzg();
        zzam.zzW();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzai.zzh());
        try {
            if (zzam.zzh().insertWithOnConflict("consent_settings", (String) null, contentValues, 5) == -1) {
                zzam.zzt.zzaA().zzd().zzb("Failed to insert/update consent setting (got -1). appId", zzeu.zzn(str));
            }
        } catch (SQLiteException e) {
            zzam.zzt.zzaA().zzd().zzc("Error storing consent setting. appId, error", zzeu.zzn(str), e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzW(zzlj zzlj, zzq zzq2) {
        long j;
        zzlj zzlj2 = zzlj;
        zzq zzq3 = zzq2;
        zzaB().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (!zzq3.zzh) {
                zzd(zzq3);
                return;
            }
            int zzl2 = zzv().zzl(zzlj2.zzb);
            if (zzl2 != 0) {
                zzlo zzv2 = zzv();
                String str = zzlj2.zzb;
                zzg();
                String zzD2 = zzv2.zzD(str, 24, true);
                String str2 = zzlj2.zzb;
                zzv().zzO(this.zzF, zzq3.zza, zzl2, "_ev", zzD2, str2 != null ? str2.length() : 0);
                return;
            }
            int zzd2 = zzv().zzd(zzlj2.zzb, zzlj.zza());
            if (zzd2 != 0) {
                zzlo zzv3 = zzv();
                String str3 = zzlj2.zzb;
                zzg();
                String zzD3 = zzv3.zzD(str3, 24, true);
                Object zza2 = zzlj.zza();
                zzv().zzO(this.zzF, zzq3.zza, zzd2, "_ev", zzD3, (zza2 == null || (!(zza2 instanceof String) && !(zza2 instanceof CharSequence))) ? 0 : zza2.toString().length());
                return;
            }
            Object zzB2 = zzv().zzB(zzlj2.zzb, zzlj.zza());
            if (zzB2 != null) {
                if ("_sid".equals(zzlj2.zzb)) {
                    long j2 = zzlj2.zzc;
                    String str4 = zzlj2.zzf;
                    String str5 = (String) Preconditions.checkNotNull(zzq3.zza);
                    zzam zzam = this.zze;
                    zzal(zzam);
                    zzll zzp2 = zzam.zzp(str5, "_sno");
                    if (zzp2 != null) {
                        Object obj = zzp2.zze;
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                            zzW(new zzlj("_sno", j2, Long.valueOf(j + 1), str4), zzq3);
                        }
                    }
                    if (zzp2 != null) {
                        zzaA().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", zzp2.zze);
                    }
                    zzam zzam2 = this.zze;
                    zzal(zzam2);
                    zzas zzn2 = zzam2.zzn(str5, "_s");
                    if (zzn2 != null) {
                        j = zzn2.zzc;
                        zzaA().zzj().zzb("Backfill the session number. Last used session number", Long.valueOf(j));
                    } else {
                        j = 0;
                    }
                    zzW(new zzlj("_sno", j2, Long.valueOf(j + 1), str4), zzq3);
                }
                zzll zzll = new zzll((String) Preconditions.checkNotNull(zzq3.zza), (String) Preconditions.checkNotNull(zzlj2.zzf), zzlj2.zzb, zzlj2.zzc, zzB2);
                zzaA().zzj().zzc("Setting user property", this.zzn.zzj().zzf(zzll.zzc), zzB2);
                zzam zzam3 = this.zze;
                zzal(zzam3);
                zzam3.zzw();
                try {
                    if ("_id".equals(zzll.zzc)) {
                        zzam zzam4 = this.zze;
                        zzal(zzam4);
                        zzll zzp3 = zzam4.zzp(zzq3.zza, "_id");
                        if (zzp3 != null && !zzll.zze.equals(zzp3.zze)) {
                            zzam zzam5 = this.zze;
                            zzal(zzam5);
                            zzam5.zzA(zzq3.zza, "_lair");
                        }
                    }
                    zzd(zzq3);
                    zzam zzam6 = this.zze;
                    zzal(zzam6);
                    boolean zzL = zzam6.zzL(zzll);
                    zzam zzam7 = this.zze;
                    zzal(zzam7);
                    zzam7.zzC();
                    if (!zzL) {
                        zzaA().zzd().zzc("Too many unique user properties are set. Ignoring user property", this.zzn.zzj().zzf(zzll.zzc), zzll.zze);
                        zzv().zzO(this.zzF, zzq3.zza, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zzam zzam8 = this.zze;
                    zzal(zzam8);
                    zzam8.zzx();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:206|207) */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0217, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0218, code lost:
        r8.zzt.zzaA().zzd().zzc("Failed to merge queued bundle. appId", com.google.android.gms.measurement.internal.zzeu.zzn(r6), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:?, code lost:
        zzaA().zzd().zzc("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzeu.zzn(r6), r0.zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x04eb, code lost:
        if (r3 != null) goto L_0x04ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0512, code lost:
        if (r3 != null) goto L_0x04ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0515, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0108, code lost:
        if (r11 != null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0112, code lost:
        if (r11 != null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012a, code lost:
        if (r11 != null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r1.zzA = r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:206:0x048c */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x029c A[SYNTHETIC, Splitter:B:146:0x029c] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02a5 A[Catch:{ all -> 0x0130, all -> 0x0537 }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x04a7 A[Catch:{ all -> 0x0130, all -> 0x0537 }] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0533 A[SYNTHETIC, Splitter:B:248:0x0533] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0134 A[Catch:{ all -> 0x0130, all -> 0x0537 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:143:0x0283=Splitter:B:143:0x0283, B:238:0x0516=Splitter:B:238:0x0516, B:197:0x0407=Splitter:B:197:0x0407, B:48:0x010a=Splitter:B:48:0x010a, B:57:0x011b=Splitter:B:57:0x011b, B:60:0x012d=Splitter:B:60:0x012d, B:221:0x04ed=Splitter:B:221:0x04ed} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzX() {
        /*
            r22 = this;
            r1 = r22
            com.google.android.gms.measurement.internal.zzgb r0 = r22.zzaB()
            r0.zzg()
            r22.zzB()
            r2 = 1
            r1.zzv = r2
            r3 = 0
            com.google.android.gms.measurement.internal.zzge r0 = r1.zzn     // Catch:{ all -> 0x0537 }
            r0.zzay()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzge r0 = r1.zzn     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzjy r0 = r0.zzt()     // Catch:{ all -> 0x0537 }
            java.lang.Boolean r0 = r0.zzj()     // Catch:{ all -> 0x0537 }
            if (r0 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzeu r0 = r22.zzaA()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzk()     // Catch:{ all -> 0x0537 }
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
            r0.zza(r2)     // Catch:{ all -> 0x0537 }
            r1.zzv = r3
        L_0x0030:
            r22.zzae()
            return
        L_0x0034:
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0537 }
            if (r0 == 0) goto L_0x004a
            com.google.android.gms.measurement.internal.zzeu r0 = r22.zzaA()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzd()     // Catch:{ all -> 0x0537 }
            java.lang.String r2 = "Upload called in the client side when service should be used"
            r0.zza(r2)     // Catch:{ all -> 0x0537 }
            r1.zzv = r3
            goto L_0x0030
        L_0x004a:
            long r4 = r1.zza     // Catch:{ all -> 0x0537 }
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0058
            r22.zzag()     // Catch:{ all -> 0x0537 }
            r1.zzv = r3
            goto L_0x0030
        L_0x0058:
            com.google.android.gms.measurement.internal.zzgb r0 = r22.zzaB()     // Catch:{ all -> 0x0537 }
            r0.zzg()     // Catch:{ all -> 0x0537 }
            java.util.List r0 = r1.zzy     // Catch:{ all -> 0x0537 }
            if (r0 == 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzeu r0 = r22.zzaA()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzj()     // Catch:{ all -> 0x0537 }
            java.lang.String r2 = "Uploading requested multiple times"
            r0.zza(r2)     // Catch:{ all -> 0x0537 }
            r1.zzv = r3
            goto L_0x0030
        L_0x0073:
            com.google.android.gms.measurement.internal.zzfa r0 = r1.zzd     // Catch:{ all -> 0x0537 }
            zzal(r0)     // Catch:{ all -> 0x0537 }
            boolean r0 = r0.zza()     // Catch:{ all -> 0x0537 }
            if (r0 != 0) goto L_0x0091
            com.google.android.gms.measurement.internal.zzeu r0 = r22.zzaA()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzj()     // Catch:{ all -> 0x0537 }
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r0.zza(r2)     // Catch:{ all -> 0x0537 }
            r22.zzag()     // Catch:{ all -> 0x0537 }
            r1.zzv = r3
            goto L_0x0030
        L_0x0091:
            com.google.android.gms.common.util.Clock r0 = r22.zzax()     // Catch:{ all -> 0x0537 }
            long r4 = r0.currentTimeMillis()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzag r0 = r22.zzg()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzeg r8 = com.google.android.gms.measurement.internal.zzeh.zzR     // Catch:{ all -> 0x0537 }
            r9 = 0
            int r0 = r0.zze(r9, r8)     // Catch:{ all -> 0x0537 }
            r22.zzg()     // Catch:{ all -> 0x0537 }
            long r10 = com.google.android.gms.measurement.internal.zzag.zzz()     // Catch:{ all -> 0x0537 }
            long r10 = r4 - r10
            r8 = 0
        L_0x00ae:
            if (r8 >= r0) goto L_0x00b9
            boolean r12 = r1.zzah(r9, r10)     // Catch:{ all -> 0x0537 }
            if (r12 == 0) goto L_0x00b9
            int r8 = r8 + 1
            goto L_0x00ae
        L_0x00b9:
            com.google.android.gms.measurement.internal.zzka r0 = r1.zzk     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzff r0 = r0.zzc     // Catch:{ all -> 0x0537 }
            long r10 = r0.zza()     // Catch:{ all -> 0x0537 }
            int r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x00dc
            com.google.android.gms.measurement.internal.zzeu r0 = r22.zzaA()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzc()     // Catch:{ all -> 0x0537 }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r4 - r10
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x0537 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0537 }
            r0.zzb(r6, r7)     // Catch:{ all -> 0x0537 }
        L_0x00dc:
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0537 }
            zzal(r0)     // Catch:{ all -> 0x0537 }
            java.lang.String r6 = r0.zzr()     // Catch:{ all -> 0x0537 }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0537 }
            r7 = -1
            if (r0 != 0) goto L_0x04ab
            long r10 = r1.zzA     // Catch:{ all -> 0x0537 }
            int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0138
            com.google.android.gms.measurement.internal.zzam r10 = r1.zze     // Catch:{ all -> 0x0537 }
            zzal(r10)     // Catch:{ all -> 0x0537 }
            android.database.sqlite.SQLiteDatabase r0 = r10.zzh()     // Catch:{ SQLiteException -> 0x0119, all -> 0x0117 }
            java.lang.String r11 = "select rowid from raw_events order by rowid desc limit 1;"
            android.database.Cursor r11 = r0.rawQuery(r11, r9)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0117 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0115 }
            if (r0 != 0) goto L_0x010e
            if (r11 == 0) goto L_0x012d
        L_0x010a:
            r11.close()     // Catch:{ all -> 0x0537 }
            goto L_0x012d
        L_0x010e:
            long r7 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0115 }
            if (r11 == 0) goto L_0x012d
            goto L_0x010a
        L_0x0115:
            r0 = move-exception
            goto L_0x011b
        L_0x0117:
            r0 = move-exception
            goto L_0x0132
        L_0x0119:
            r0 = move-exception
            r11 = r9
        L_0x011b:
            com.google.android.gms.measurement.internal.zzge r10 = r10.zzt     // Catch:{ all -> 0x0130 }
            com.google.android.gms.measurement.internal.zzeu r10 = r10.zzaA()     // Catch:{ all -> 0x0130 }
            com.google.android.gms.measurement.internal.zzes r10 = r10.zzd()     // Catch:{ all -> 0x0130 }
            java.lang.String r12 = "Error querying raw events"
            r10.zzb(r12, r0)     // Catch:{ all -> 0x0130 }
            if (r11 == 0) goto L_0x012d
            goto L_0x010a
        L_0x012d:
            r1.zzA = r7     // Catch:{ all -> 0x0537 }
            goto L_0x0138
        L_0x0130:
            r0 = move-exception
            r9 = r11
        L_0x0132:
            if (r9 == 0) goto L_0x0137
            r9.close()     // Catch:{ all -> 0x0537 }
        L_0x0137:
            throw r0     // Catch:{ all -> 0x0537 }
        L_0x0138:
            com.google.android.gms.measurement.internal.zzag r0 = r22.zzg()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzeg r7 = com.google.android.gms.measurement.internal.zzeh.zzg     // Catch:{ all -> 0x0537 }
            int r0 = r0.zze(r6, r7)     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzag r7 = r22.zzg()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzeg r8 = com.google.android.gms.measurement.internal.zzeh.zzh     // Catch:{ all -> 0x0537 }
            int r7 = r7.zze(r6, r8)     // Catch:{ all -> 0x0537 }
            int r7 = java.lang.Math.max(r3, r7)     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzam r8 = r1.zze     // Catch:{ all -> 0x0537 }
            zzal(r8)     // Catch:{ all -> 0x0537 }
            r8.zzg()     // Catch:{ all -> 0x0537 }
            r8.zzW()     // Catch:{ all -> 0x0537 }
            if (r0 <= 0) goto L_0x015f
            r10 = 1
            goto L_0x0160
        L_0x015f:
            r10 = 0
        L_0x0160:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x0537 }
            if (r7 <= 0) goto L_0x0167
            r10 = 1
            goto L_0x0168
        L_0x0167:
            r10 = 0
        L_0x0168:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x0537 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)     // Catch:{ all -> 0x0537 }
            android.database.sqlite.SQLiteDatabase r11 = r8.zzh()     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            java.lang.String r12 = "queue"
            java.lang.String r13 = "rowid"
            java.lang.String r14 = "data"
            java.lang.String r15 = "retry_count"
            java.lang.String[] r13 = new java.lang.String[]{r13, r14, r15}     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            java.lang.String r14 = "app_id=?"
            java.lang.String[] r15 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            r15[r3] = r6     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0277 }
            if (r0 != 0) goto L_0x01a5
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x0277 }
            if (r11 == 0) goto L_0x01a1
            r11.close()     // Catch:{ all -> 0x0537 }
        L_0x01a1:
            r20 = r4
            goto L_0x029f
        L_0x01a5:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0277 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0277 }
            r13 = 0
        L_0x01ab:
            long r14 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0277 }
            byte[] r0 = r11.getBlob(r2)     // Catch:{ IOException -> 0x0248 }
            com.google.android.gms.measurement.internal.zzlg r9 = r8.zzf     // Catch:{ IOException -> 0x0248 }
            com.google.android.gms.measurement.internal.zzli r9 = r9.zzi     // Catch:{ IOException -> 0x0248 }
            zzal(r9)     // Catch:{ IOException -> 0x0248 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0233 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0233 }
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0233 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x0233 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0233 }
            r3.<init>()     // Catch:{ IOException -> 0x0233 }
            r10 = 1024(0x400, float:1.435E-42)
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x0233 }
            r20 = r4
        L_0x01cf:
            int r4 = r0.read(r10)     // Catch:{ IOException -> 0x0231 }
            if (r4 > 0) goto L_0x022c
            r0.close()     // Catch:{ IOException -> 0x0231 }
            r2.close()     // Catch:{ IOException -> 0x0231 }
            byte[] r0 = r3.toByteArray()     // Catch:{ IOException -> 0x0231 }
            boolean r2 = r12.isEmpty()     // Catch:{ SQLiteException -> 0x0275 }
            if (r2 != 0) goto L_0x01eb
            int r2 = r0.length     // Catch:{ SQLiteException -> 0x0275 }
            int r2 = r2 + r13
            if (r2 <= r7) goto L_0x01eb
            goto L_0x026e
        L_0x01eb:
            com.google.android.gms.internal.measurement.zzgc r2 = com.google.android.gms.internal.measurement.zzgd.zzu()     // Catch:{ IOException -> 0x0217 }
            com.google.android.gms.internal.measurement.zzmh r2 = com.google.android.gms.measurement.internal.zzli.zzl(r2, r0)     // Catch:{ IOException -> 0x0217 }
            com.google.android.gms.internal.measurement.zzgc r2 = (com.google.android.gms.internal.measurement.zzgc) r2     // Catch:{ IOException -> 0x0217 }
            r3 = 2
            boolean r4 = r11.isNull(r3)     // Catch:{ SQLiteException -> 0x0275 }
            if (r4 != 0) goto L_0x0203
            int r4 = r11.getInt(r3)     // Catch:{ SQLiteException -> 0x0275 }
            r2.zzaf(r4)     // Catch:{ SQLiteException -> 0x0275 }
        L_0x0203:
            int r0 = r0.length     // Catch:{ SQLiteException -> 0x0275 }
            int r13 = r13 + r0
            com.google.android.gms.internal.measurement.zzlb r0 = r2.zzaD()     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.internal.measurement.zzgd r0 = (com.google.android.gms.internal.measurement.zzgd) r0     // Catch:{ SQLiteException -> 0x0275 }
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteException -> 0x0275 }
            android.util.Pair r0 = android.util.Pair.create(r0, r2)     // Catch:{ SQLiteException -> 0x0275 }
            r12.add(r0)     // Catch:{ SQLiteException -> 0x0275 }
            goto L_0x025e
        L_0x0217:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzge r2 = r8.zzt     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.measurement.internal.zzeu r2 = r2.zzaA()     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x0275 }
            java.lang.String r3 = "Failed to merge queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeu.zzn(r6)     // Catch:{ SQLiteException -> 0x0275 }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x0275 }
            goto L_0x025e
        L_0x022c:
            r5 = 0
            r3.write(r10, r5, r4)     // Catch:{ IOException -> 0x0231 }
            goto L_0x01cf
        L_0x0231:
            r0 = move-exception
            goto L_0x0236
        L_0x0233:
            r0 = move-exception
            r20 = r4
        L_0x0236:
            com.google.android.gms.measurement.internal.zzge r2 = r9.zzt     // Catch:{ IOException -> 0x0246 }
            com.google.android.gms.measurement.internal.zzeu r2 = r2.zzaA()     // Catch:{ IOException -> 0x0246 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzd()     // Catch:{ IOException -> 0x0246 }
            java.lang.String r3 = "Failed to ungzip content"
            r2.zzb(r3, r0)     // Catch:{ IOException -> 0x0246 }
            throw r0     // Catch:{ IOException -> 0x0246 }
        L_0x0246:
            r0 = move-exception
            goto L_0x024b
        L_0x0248:
            r0 = move-exception
            r20 = r4
        L_0x024b:
            com.google.android.gms.measurement.internal.zzge r2 = r8.zzt     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.measurement.internal.zzeu r2 = r2.zzaA()     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x0275 }
            java.lang.String r3 = "Failed to unzip queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeu.zzn(r6)     // Catch:{ SQLiteException -> 0x0275 }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x0275 }
        L_0x025e:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x0275 }
            if (r0 == 0) goto L_0x026e
            if (r13 <= r7) goto L_0x0267
            goto L_0x026e
        L_0x0267:
            r4 = r20
            r2 = 1
            r3 = 0
            r9 = 0
            goto L_0x01ab
        L_0x026e:
            if (r11 == 0) goto L_0x0273
            r11.close()     // Catch:{ all -> 0x0537 }
        L_0x0273:
            r0 = r12
            goto L_0x029f
        L_0x0275:
            r0 = move-exception
            goto L_0x0283
        L_0x0277:
            r0 = move-exception
            r20 = r4
            goto L_0x0283
        L_0x027b:
            r0 = move-exception
            r9 = 0
            goto L_0x04a5
        L_0x027f:
            r0 = move-exception
            r20 = r4
            r11 = 0
        L_0x0283:
            com.google.android.gms.measurement.internal.zzge r2 = r8.zzt     // Catch:{ all -> 0x04a3 }
            com.google.android.gms.measurement.internal.zzeu r2 = r2.zzaA()     // Catch:{ all -> 0x04a3 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzd()     // Catch:{ all -> 0x04a3 }
            java.lang.String r3 = "Error querying bundles. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeu.zzn(r6)     // Catch:{ all -> 0x04a3 }
            r2.zzc(r3, r4, r0)     // Catch:{ all -> 0x04a3 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x04a3 }
            if (r11 == 0) goto L_0x029f
            r11.close()     // Catch:{ all -> 0x0537 }
        L_0x029f:
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x0537 }
            if (r2 != 0) goto L_0x052a
            com.google.android.gms.measurement.internal.zzai r2 = r1.zzh(r6)     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzah r3 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x0537 }
            boolean r2 = r2.zzi(r3)     // Catch:{ all -> 0x0537 }
            if (r2 == 0) goto L_0x0306
            java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x0537 }
        L_0x02b5:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0537 }
            if (r3 == 0) goto L_0x02d4
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0537 }
            android.util.Pair r3 = (android.util.Pair) r3     // Catch:{ all -> 0x0537 }
            java.lang.Object r3 = r3.first     // Catch:{ all -> 0x0537 }
            com.google.android.gms.internal.measurement.zzgd r3 = (com.google.android.gms.internal.measurement.zzgd) r3     // Catch:{ all -> 0x0537 }
            java.lang.String r4 = r3.zzK()     // Catch:{ all -> 0x0537 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0537 }
            if (r4 != 0) goto L_0x02b5
            java.lang.String r2 = r3.zzK()     // Catch:{ all -> 0x0537 }
            goto L_0x02d5
        L_0x02d4:
            r2 = 0
        L_0x02d5:
            if (r2 == 0) goto L_0x0306
            r3 = 0
        L_0x02d8:
            int r4 = r0.size()     // Catch:{ all -> 0x0537 }
            if (r3 >= r4) goto L_0x0306
            java.lang.Object r4 = r0.get(r3)     // Catch:{ all -> 0x0537 }
            android.util.Pair r4 = (android.util.Pair) r4     // Catch:{ all -> 0x0537 }
            java.lang.Object r4 = r4.first     // Catch:{ all -> 0x0537 }
            com.google.android.gms.internal.measurement.zzgd r4 = (com.google.android.gms.internal.measurement.zzgd) r4     // Catch:{ all -> 0x0537 }
            java.lang.String r5 = r4.zzK()     // Catch:{ all -> 0x0537 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0537 }
            if (r5 == 0) goto L_0x02f3
            goto L_0x0303
        L_0x02f3:
            java.lang.String r4 = r4.zzK()     // Catch:{ all -> 0x0537 }
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0537 }
            if (r4 != 0) goto L_0x0303
            r4 = 0
            java.util.List r0 = r0.subList(r4, r3)     // Catch:{ all -> 0x0537 }
            goto L_0x0306
        L_0x0303:
            int r3 = r3 + 1
            goto L_0x02d8
        L_0x0306:
            com.google.android.gms.internal.measurement.zzga r2 = com.google.android.gms.internal.measurement.zzgb.zza()     // Catch:{ all -> 0x0537 }
            int r3 = r0.size()     // Catch:{ all -> 0x0537 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0537 }
            int r5 = r0.size()     // Catch:{ all -> 0x0537 }
            r4.<init>(r5)     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzag r5 = r22.zzg()     // Catch:{ all -> 0x0537 }
            boolean r5 = r5.zzt(r6)     // Catch:{ all -> 0x0537 }
            if (r5 == 0) goto L_0x032f
            com.google.android.gms.measurement.internal.zzai r5 = r1.zzh(r6)     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzah r7 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x0537 }
            boolean r5 = r5.zzi(r7)     // Catch:{ all -> 0x0537 }
            if (r5 == 0) goto L_0x032f
            r5 = 1
            goto L_0x0330
        L_0x032f:
            r5 = 0
        L_0x0330:
            com.google.android.gms.measurement.internal.zzai r7 = r1.zzh(r6)     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzah r8 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x0537 }
            boolean r7 = r7.zzi(r8)     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzai r8 = r1.zzh(r6)     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzah r9 = com.google.android.gms.measurement.internal.zzah.ANALYTICS_STORAGE     // Catch:{ all -> 0x0537 }
            boolean r8 = r8.zzi(r9)     // Catch:{ all -> 0x0537 }
            com.google.android.gms.internal.measurement.zzqr.zzc()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzag r9 = r22.zzg()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzeg r10 = com.google.android.gms.measurement.internal.zzeh.zzao     // Catch:{ all -> 0x0537 }
            boolean r9 = r9.zzs(r6, r10)     // Catch:{ all -> 0x0537 }
            r10 = 0
        L_0x0352:
            if (r10 >= r3) goto L_0x03d0
            java.lang.Object r11 = r0.get(r10)     // Catch:{ all -> 0x0537 }
            android.util.Pair r11 = (android.util.Pair) r11     // Catch:{ all -> 0x0537 }
            java.lang.Object r11 = r11.first     // Catch:{ all -> 0x0537 }
            com.google.android.gms.internal.measurement.zzgd r11 = (com.google.android.gms.internal.measurement.zzgd) r11     // Catch:{ all -> 0x0537 }
            com.google.android.gms.internal.measurement.zzkx r11 = r11.zzbB()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.internal.measurement.zzgc r11 = (com.google.android.gms.internal.measurement.zzgc) r11     // Catch:{ all -> 0x0537 }
            java.lang.Object r12 = r0.get(r10)     // Catch:{ all -> 0x0537 }
            android.util.Pair r12 = (android.util.Pair) r12     // Catch:{ all -> 0x0537 }
            java.lang.Object r12 = r12.second     // Catch:{ all -> 0x0537 }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0537 }
            r4.add(r12)     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzag r12 = r22.zzg()     // Catch:{ all -> 0x0537 }
            r12.zzh()     // Catch:{ all -> 0x0537 }
            r12 = 77000(0x12cc8, double:3.8043E-319)
            r11.zzam(r12)     // Catch:{ all -> 0x0537 }
            r12 = r20
            r11.zzal(r12)     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzge r14 = r1.zzn     // Catch:{ all -> 0x0537 }
            r14.zzay()     // Catch:{ all -> 0x0537 }
            r14 = 0
            r11.zzag(r14)     // Catch:{ all -> 0x0537 }
            if (r5 != 0) goto L_0x0391
            r11.zzq()     // Catch:{ all -> 0x0537 }
        L_0x0391:
            if (r7 != 0) goto L_0x0399
            r11.zzx()     // Catch:{ all -> 0x0537 }
            r11.zzt()     // Catch:{ all -> 0x0537 }
        L_0x0399:
            if (r8 != 0) goto L_0x039e
            r11.zzn()     // Catch:{ all -> 0x0537 }
        L_0x039e:
            r1.zzC(r6, r11)     // Catch:{ all -> 0x0537 }
            if (r9 != 0) goto L_0x03a6
            r11.zzy()     // Catch:{ all -> 0x0537 }
        L_0x03a6:
            com.google.android.gms.measurement.internal.zzag r14 = r22.zzg()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzeg r15 = com.google.android.gms.measurement.internal.zzeh.zzV     // Catch:{ all -> 0x0537 }
            boolean r14 = r14.zzs(r6, r15)     // Catch:{ all -> 0x0537 }
            if (r14 == 0) goto L_0x03c8
            com.google.android.gms.internal.measurement.zzlb r14 = r11.zzaD()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.internal.measurement.zzgd r14 = (com.google.android.gms.internal.measurement.zzgd) r14     // Catch:{ all -> 0x0537 }
            byte[] r14 = r14.zzbx()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzli r15 = r1.zzi     // Catch:{ all -> 0x0537 }
            zzal(r15)     // Catch:{ all -> 0x0537 }
            long r14 = r15.zzd(r14)     // Catch:{ all -> 0x0537 }
            r11.zzJ(r14)     // Catch:{ all -> 0x0537 }
        L_0x03c8:
            r2.zza(r11)     // Catch:{ all -> 0x0537 }
            int r10 = r10 + 1
            r20 = r12
            goto L_0x0352
        L_0x03d0:
            r12 = r20
            com.google.android.gms.measurement.internal.zzeu r0 = r22.zzaA()     // Catch:{ all -> 0x0537 }
            java.lang.String r0 = r0.zzr()     // Catch:{ all -> 0x0537 }
            r5 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r5)     // Catch:{ all -> 0x0537 }
            if (r0 == 0) goto L_0x03f1
            com.google.android.gms.measurement.internal.zzli r0 = r1.zzi     // Catch:{ all -> 0x0537 }
            zzal(r0)     // Catch:{ all -> 0x0537 }
            com.google.android.gms.internal.measurement.zzlb r5 = r2.zzaD()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.internal.measurement.zzgb r5 = (com.google.android.gms.internal.measurement.zzgb) r5     // Catch:{ all -> 0x0537 }
            java.lang.String r9 = r0.zzm(r5)     // Catch:{ all -> 0x0537 }
            goto L_0x03f2
        L_0x03f1:
            r9 = 0
        L_0x03f2:
            com.google.android.gms.measurement.internal.zzli r0 = r1.zzi     // Catch:{ all -> 0x0537 }
            zzal(r0)     // Catch:{ all -> 0x0537 }
            com.google.android.gms.internal.measurement.zzlb r0 = r2.zzaD()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.internal.measurement.zzgb r0 = (com.google.android.gms.internal.measurement.zzgb) r0     // Catch:{ all -> 0x0537 }
            byte[] r14 = r0.zzbx()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzkv r0 = r1.zzl     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzku r0 = r0.zza(r6)     // Catch:{ all -> 0x0537 }
            boolean r5 = r4.isEmpty()     // Catch:{ MalformedURLException -> 0x048c }
            r7 = 1
            r5 = r5 ^ r7
            com.google.android.gms.common.internal.Preconditions.checkArgument(r5)     // Catch:{ MalformedURLException -> 0x048c }
            java.util.List r5 = r1.zzy     // Catch:{ MalformedURLException -> 0x048c }
            if (r5 == 0) goto L_0x0422
            com.google.android.gms.measurement.internal.zzeu r4 = r22.zzaA()     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzd()     // Catch:{ MalformedURLException -> 0x048c }
            java.lang.String r5 = "Set uploading progress before finishing the previous upload"
            r4.zza(r5)     // Catch:{ MalformedURLException -> 0x048c }
            goto L_0x0429
        L_0x0422:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x048c }
            r5.<init>(r4)     // Catch:{ MalformedURLException -> 0x048c }
            r1.zzy = r5     // Catch:{ MalformedURLException -> 0x048c }
        L_0x0429:
            com.google.android.gms.measurement.internal.zzka r4 = r1.zzk     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.zzff r4 = r4.zzd     // Catch:{ MalformedURLException -> 0x048c }
            r4.zzb(r12)     // Catch:{ MalformedURLException -> 0x048c }
            java.lang.String r4 = "?"
            if (r3 <= 0) goto L_0x043d
            r3 = 0
            com.google.android.gms.internal.measurement.zzgd r2 = r2.zzb(r3)     // Catch:{ MalformedURLException -> 0x048c }
            java.lang.String r4 = r2.zzy()     // Catch:{ MalformedURLException -> 0x048c }
        L_0x043d:
            com.google.android.gms.measurement.internal.zzeu r2 = r22.zzaA()     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzj()     // Catch:{ MalformedURLException -> 0x048c }
            java.lang.String r3 = "Uploading data. app, uncompressed size, data"
            int r5 = r14.length     // Catch:{ MalformedURLException -> 0x048c }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ MalformedURLException -> 0x048c }
            r2.zzd(r3, r4, r5, r9)     // Catch:{ MalformedURLException -> 0x048c }
            r2 = 1
            r1.zzu = r2     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.zzfa r11 = r1.zzd     // Catch:{ MalformedURLException -> 0x048c }
            zzal(r11)     // Catch:{ MalformedURLException -> 0x048c }
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x048c }
            java.lang.String r2 = r0.zza()     // Catch:{ MalformedURLException -> 0x048c }
            r13.<init>(r2)     // Catch:{ MalformedURLException -> 0x048c }
            java.util.Map r15 = r0.zzb()     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.zzkx r2 = new com.google.android.gms.measurement.internal.zzkx     // Catch:{ MalformedURLException -> 0x048c }
            r2.<init>(r1, r6)     // Catch:{ MalformedURLException -> 0x048c }
            r11.zzg()     // Catch:{ MalformedURLException -> 0x048c }
            r11.zzW()     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.zzge r3 = r11.zzt     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.zzgb r3 = r3.zzaB()     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.zzez r4 = new com.google.android.gms.measurement.internal.zzez     // Catch:{ MalformedURLException -> 0x048c }
            r10 = r4
            r12 = r6
            r16 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x048c }
            r3.zzo(r4)     // Catch:{ MalformedURLException -> 0x048c }
            goto L_0x052a
        L_0x048c:
            com.google.android.gms.measurement.internal.zzeu r2 = r22.zzaA()     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzd()     // Catch:{ all -> 0x0537 }
            java.lang.String r3 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeu.zzn(r6)     // Catch:{ all -> 0x0537 }
            java.lang.String r0 = r0.zza()     // Catch:{ all -> 0x0537 }
            r2.zzc(r3, r4, r0)     // Catch:{ all -> 0x0537 }
            goto L_0x052a
        L_0x04a3:
            r0 = move-exception
            r9 = r11
        L_0x04a5:
            if (r9 == 0) goto L_0x04aa
            r9.close()     // Catch:{ all -> 0x0537 }
        L_0x04aa:
            throw r0     // Catch:{ all -> 0x0537 }
        L_0x04ab:
            r12 = r4
            r1.zzA = r7     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0537 }
            zzal(r2)     // Catch:{ all -> 0x0537 }
            r22.zzg()     // Catch:{ all -> 0x0537 }
            long r3 = com.google.android.gms.measurement.internal.zzag.zzz()     // Catch:{ all -> 0x0537 }
            long r4 = r12 - r3
            r2.zzg()     // Catch:{ all -> 0x0537 }
            r2.zzW()     // Catch:{ all -> 0x0537 }
            android.database.sqlite.SQLiteDatabase r0 = r2.zzh()     // Catch:{ SQLiteException -> 0x0501, all -> 0x04fe }
            java.lang.String r3 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0501, all -> 0x04fe }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ SQLiteException -> 0x0501, all -> 0x04fe }
            r5 = 0
            r6[r5] = r4     // Catch:{ SQLiteException -> 0x0501, all -> 0x04fe }
            android.database.Cursor r3 = r0.rawQuery(r3, r6)     // Catch:{ SQLiteException -> 0x0501, all -> 0x04fe }
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x04fc }
            if (r0 != 0) goto L_0x04f1
            com.google.android.gms.measurement.internal.zzge r0 = r2.zzt     // Catch:{ SQLiteException -> 0x04fc }
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzaA()     // Catch:{ SQLiteException -> 0x04fc }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzj()     // Catch:{ SQLiteException -> 0x04fc }
            java.lang.String r4 = "No expired configs for apps with pending events"
            r0.zza(r4)     // Catch:{ SQLiteException -> 0x04fc }
            if (r3 == 0) goto L_0x0515
        L_0x04ed:
            r3.close()     // Catch:{ all -> 0x0537 }
            goto L_0x0515
        L_0x04f1:
            r4 = 0
            java.lang.String r9 = r3.getString(r4)     // Catch:{ SQLiteException -> 0x04fc }
            if (r3 == 0) goto L_0x0516
            r3.close()     // Catch:{ all -> 0x0537 }
            goto L_0x0516
        L_0x04fc:
            r0 = move-exception
            goto L_0x0503
        L_0x04fe:
            r0 = move-exception
            r9 = 0
            goto L_0x0531
        L_0x0501:
            r0 = move-exception
            r3 = 0
        L_0x0503:
            com.google.android.gms.measurement.internal.zzge r2 = r2.zzt     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzeu r2 = r2.zzaA()     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzd()     // Catch:{ all -> 0x052f }
            java.lang.String r4 = "Error selecting expired configs"
            r2.zzb(r4, r0)     // Catch:{ all -> 0x052f }
            if (r3 == 0) goto L_0x0515
            goto L_0x04ed
        L_0x0515:
            r9 = 0
        L_0x0516:
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0537 }
            if (r0 != 0) goto L_0x052a
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0537 }
            zzal(r0)     // Catch:{ all -> 0x0537 }
            com.google.android.gms.measurement.internal.zzh r0 = r0.zzj(r9)     // Catch:{ all -> 0x0537 }
            if (r0 == 0) goto L_0x052a
            r1.zzD(r0)     // Catch:{ all -> 0x0537 }
        L_0x052a:
            r2 = 0
            r1.zzv = r2
            goto L_0x0030
        L_0x052f:
            r0 = move-exception
            r9 = r3
        L_0x0531:
            if (r9 == 0) goto L_0x0536
            r9.close()     // Catch:{ all -> 0x0537 }
        L_0x0536:
            throw r0     // Catch:{ all -> 0x0537 }
        L_0x0537:
            r0 = move-exception
            r2 = 0
            r1.zzv = r2
            r22.zzae()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlg.zzX():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x07d3, code lost:
        if (r14.isEmpty() != false) goto L_0x07d5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0343 A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0386 A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0389 A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x03e8 A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0415  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0577 A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x05b7 A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0630 A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x067b A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0688 A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0695 A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x06cd A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x06de A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x071f A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0746 A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x074b A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0751 A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x07d8 A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x081e A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x086f A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x087c A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0895 A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x0923 A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x0942 A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x09d4 A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x0a82 A[Catch:{ SQLiteException -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x0a98  */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x09e6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01ce A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01e7 A[SYNTHETIC, Splitter:B:55:0x01e7] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x024b A[SYNTHETIC, Splitter:B:69:0x024b] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x025b A[Catch:{ NumberFormatException -> 0x07bd, all -> 0x0b19 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzY(com.google.android.gms.measurement.internal.zzaw r36, com.google.android.gms.measurement.internal.zzq r37) {
        /*
            r35 = this;
            r1 = r35
            r2 = r36
            r3 = r37
            java.lang.String r4 = "metadata_fingerprint"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "raw_events"
            java.lang.String r7 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r37)
            java.lang.String r8 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            long r8 = java.lang.System.nanoTime()
            com.google.android.gms.measurement.internal.zzgb r10 = r35.zzaB()
            r10.zzg()
            r35.zzB()
            java.lang.String r10 = r3.zza
            com.google.android.gms.measurement.internal.zzli r11 = r1.zzi
            zzal(r11)
            boolean r11 = com.google.android.gms.measurement.internal.zzli.zzA(r36, r37)
            if (r11 != 0) goto L_0x0032
            return
        L_0x0032:
            boolean r11 = r3.zzh
            if (r11 == 0) goto L_0x0b24
            com.google.android.gms.measurement.internal.zzfv r11 = r1.zzc
            zzal(r11)
            java.lang.String r12 = r2.zza
            boolean r11 = r11.zzr(r10, r12)
            java.lang.String r15 = "_err"
            r14 = 0
            if (r11 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzeu r3 = r35.zzaA()
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzk()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeu.zzn(r10)
            com.google.android.gms.measurement.internal.zzge r5 = r1.zzn
            com.google.android.gms.measurement.internal.zzep r5 = r5.zzj()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zzd(r6)
            java.lang.String r6 = "Dropping blocked event. appId"
            r3.zzc(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfv r3 = r1.zzc
            zzal(r3)
            boolean r3 = r3.zzp(r10)
            if (r3 != 0) goto L_0x0097
            com.google.android.gms.measurement.internal.zzfv r3 = r1.zzc
            zzal(r3)
            boolean r3 = r3.zzs(r10)
            if (r3 == 0) goto L_0x007a
            goto L_0x0097
        L_0x007a:
            java.lang.String r3 = r2.zza
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzlo r11 = r35.zzv()
            com.google.android.gms.measurement.internal.zzln r12 = r1.zzF
            java.lang.String r2 = r2.zza
            r14 = 11
            r17 = 0
            java.lang.String r15 = "_ev"
            r13 = r10
            r16 = r2
            r11.zzO(r12, r13, r14, r15, r16, r17)
            return
        L_0x0097:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            com.google.android.gms.measurement.internal.zzh r2 = r2.zzj(r10)
            if (r2 == 0) goto L_0x00de
            long r3 = r2.zzl()
            long r5 = r2.zzc()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.common.util.Clock r5 = r35.zzax()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            r35.zzg()
            com.google.android.gms.measurement.internal.zzeg r5 = com.google.android.gms.measurement.internal.zzeh.zzz
            java.lang.Object r5 = r5.zza(r14)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzeu r3 = r35.zzaA()
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzc()
            java.lang.String r4 = "Fetching config for blocked app"
            r3.zza(r4)
            r1.zzD(r2)
        L_0x00de:
            return
        L_0x00df:
            com.google.android.gms.measurement.internal.zzev r2 = com.google.android.gms.measurement.internal.zzev.zzb(r36)
            com.google.android.gms.measurement.internal.zzlo r11 = r35.zzv()
            com.google.android.gms.measurement.internal.zzag r12 = r35.zzg()
            int r12 = r12.zzd(r10)
            r11.zzN(r2, r12)
            com.google.android.gms.internal.measurement.zzpn.zzc()
            com.google.android.gms.measurement.internal.zzag r11 = r35.zzg()
            com.google.android.gms.measurement.internal.zzeg r12 = com.google.android.gms.measurement.internal.zzeh.zzaA
            boolean r11 = r11.zzs(r14, r12)
            if (r11 == 0) goto L_0x0110
            com.google.android.gms.measurement.internal.zzag r11 = r35.zzg()
            com.google.android.gms.measurement.internal.zzeg r12 = com.google.android.gms.measurement.internal.zzeh.zzQ
            r13 = 10
            r14 = 35
            int r11 = r11.zzf(r10, r12, r13, r14)
            goto L_0x0111
        L_0x0110:
            r11 = 0
        L_0x0111:
            java.util.TreeSet r12 = new java.util.TreeSet
            android.os.Bundle r13 = r2.zzd
            java.util.Set r13 = r13.keySet()
            r12.<init>(r13)
            java.util.Iterator r12 = r12.iterator()
        L_0x0120:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x015c
            java.lang.Object r13 = r12.next()
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r14 = "items"
            boolean r14 = r14.equals(r13)
            if (r14 == 0) goto L_0x0120
            com.google.android.gms.measurement.internal.zzlo r14 = r35.zzv()
            r17 = r12
            android.os.Bundle r12 = r2.zzd
            android.os.Parcelable[] r12 = r12.getParcelableArray(r13)
            com.google.android.gms.internal.measurement.zzpn.zzc()
            com.google.android.gms.measurement.internal.zzag r13 = r35.zzg()
            r18 = r15
            com.google.android.gms.measurement.internal.zzeg r15 = com.google.android.gms.measurement.internal.zzeh.zzaA
            r28 = r8
            r8 = 0
            boolean r9 = r13.zzs(r8, r15)
            r14.zzM(r12, r11, r9)
            r12 = r17
            r15 = r18
            r8 = r28
            goto L_0x0120
        L_0x015c:
            r28 = r8
            r18 = r15
            com.google.android.gms.measurement.internal.zzaw r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzeu r8 = r35.zzaA()
            java.lang.String r8 = r8.zzr()
            r9 = 2
            boolean r8 = android.util.Log.isLoggable(r8, r9)
            if (r8 == 0) goto L_0x018a
            com.google.android.gms.measurement.internal.zzeu r8 = r35.zzaA()
            com.google.android.gms.measurement.internal.zzes r8 = r8.zzj()
            com.google.android.gms.measurement.internal.zzge r11 = r1.zzn
            com.google.android.gms.measurement.internal.zzep r11 = r11.zzj()
            java.lang.String r11 = r11.zzc(r2)
            java.lang.String r12 = "Logging event"
            r8.zzb(r12, r11)
        L_0x018a:
            com.google.android.gms.internal.measurement.zzpk.zzc()
            com.google.android.gms.measurement.internal.zzag r8 = r35.zzg()
            com.google.android.gms.measurement.internal.zzeg r11 = com.google.android.gms.measurement.internal.zzeh.zzax
            r14 = 0
            r8.zzs(r14, r11)
            com.google.android.gms.measurement.internal.zzam r8 = r1.zze
            zzal(r8)
            r8.zzw()
            r1.zzd(r3)     // Catch:{ all -> 0x0b19 }
            java.lang.String r8 = "ecommerce_purchase"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0b19 }
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x0b19 }
            java.lang.String r11 = "refund"
            if (r8 != 0) goto L_0x01c3
            java.lang.String r8 = "purchase"
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x0b19 }
            boolean r8 = r8.equals(r12)     // Catch:{ all -> 0x0b19 }
            if (r8 != 0) goto L_0x01c3
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0b19 }
            boolean r8 = r11.equals(r8)     // Catch:{ all -> 0x0b19 }
            if (r8 == 0) goto L_0x01c1
            goto L_0x01c3
        L_0x01c1:
            r8 = 0
            goto L_0x01c4
        L_0x01c3:
            r8 = 1
        L_0x01c4:
            java.lang.String r12 = "_iap"
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x0b19 }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x0b19 }
            if (r12 != 0) goto L_0x01db
            if (r8 == 0) goto L_0x01d2
            r8 = 1
            goto L_0x01db
        L_0x01d2:
            r32 = r4
            r33 = r5
            r4 = r18
            r5 = 1
            goto L_0x0373
        L_0x01db:
            com.google.android.gms.measurement.internal.zzau r12 = r2.zzb     // Catch:{ all -> 0x0b19 }
            java.lang.String r13 = "currency"
            java.lang.String r12 = r12.zzg(r13)     // Catch:{ all -> 0x0b19 }
            java.lang.String r13 = "value"
            if (r8 == 0) goto L_0x024b
            com.google.android.gms.measurement.internal.zzau r8 = r2.zzb     // Catch:{ all -> 0x0b19 }
            java.lang.Double r8 = r8.zzd(r13)     // Catch:{ all -> 0x0b19 }
            double r16 = r8.doubleValue()     // Catch:{ all -> 0x0b19 }
            r19 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r16 = r16 * r19
            r21 = 0
            int r8 = (r16 > r21 ? 1 : (r16 == r21 ? 0 : -1))
            if (r8 != 0) goto L_0x020b
            com.google.android.gms.measurement.internal.zzau r8 = r2.zzb     // Catch:{ all -> 0x0b19 }
            java.lang.Long r8 = r8.zze(r13)     // Catch:{ all -> 0x0b19 }
            long r14 = r8.longValue()     // Catch:{ all -> 0x0b19 }
            double r13 = (double) r14     // Catch:{ all -> 0x0b19 }
            double r16 = r13 * r19
        L_0x020b:
            r13 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r8 = (r16 > r13 ? 1 : (r16 == r13 ? 0 : -1))
            if (r8 > 0) goto L_0x0225
            r13 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r8 = (r16 > r13 ? 1 : (r16 == r13 ? 0 : -1))
            if (r8 < 0) goto L_0x0225
            long r13 = java.lang.Math.round(r16)     // Catch:{ all -> 0x0b19 }
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0b19 }
            boolean r8 = r11.equals(r8)     // Catch:{ all -> 0x0b19 }
            if (r8 == 0) goto L_0x0255
            long r13 = -r13
            goto L_0x0255
        L_0x0225:
            com.google.android.gms.measurement.internal.zzeu r2 = r35.zzaA()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzk()     // Catch:{ all -> 0x0b19 }
            java.lang.String r3 = "Data lost. Currency value is too big. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeu.zzn(r10)     // Catch:{ all -> 0x0b19 }
            java.lang.Double r5 = java.lang.Double.valueOf(r16)     // Catch:{ all -> 0x0b19 }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0b19 }
            zzal(r2)     // Catch:{ all -> 0x0b19 }
            r2.zzC()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x024b:
            com.google.android.gms.measurement.internal.zzau r8 = r2.zzb     // Catch:{ all -> 0x0b19 }
            java.lang.Long r8 = r8.zze(r13)     // Catch:{ all -> 0x0b19 }
            long r13 = r8.longValue()     // Catch:{ all -> 0x0b19 }
        L_0x0255:
            boolean r8 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0b19 }
            if (r8 != 0) goto L_0x01d2
            java.util.Locale r8 = java.util.Locale.US     // Catch:{ all -> 0x0b19 }
            java.lang.String r8 = r12.toUpperCase(r8)     // Catch:{ all -> 0x0b19 }
            java.lang.String r11 = "[A-Z]{3}"
            boolean r11 = r8.matches(r11)     // Catch:{ all -> 0x0b19 }
            if (r11 == 0) goto L_0x01d2
            java.lang.String r11 = "_ltv_"
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0b19 }
            java.lang.String r8 = r11.concat(r8)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze     // Catch:{ all -> 0x0b19 }
            zzal(r11)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzll r11 = r11.zzp(r10, r8)     // Catch:{ all -> 0x0b19 }
            if (r11 == 0) goto L_0x02b7
            java.lang.Object r11 = r11.zze     // Catch:{ all -> 0x0b19 }
            boolean r12 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0b19 }
            if (r12 != 0) goto L_0x0285
            goto L_0x02b7
        L_0x0285:
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0b19 }
            long r11 = r11.longValue()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzll r19 = new com.google.android.gms.measurement.internal.zzll     // Catch:{ all -> 0x0b19 }
            java.lang.String r15 = r2.zzc     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.common.util.Clock r16 = r35.zzax()     // Catch:{ all -> 0x0b19 }
            long r16 = r16.currentTimeMillis()     // Catch:{ all -> 0x0b19 }
            long r11 = r11 + r13
            java.lang.Long r20 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0b19 }
            r11 = r19
            r12 = r10
            r14 = 0
            r13 = r15
            r9 = 0
            r15 = 0
            r14 = r8
            r8 = r18
            r15 = r16
            r17 = r20
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0b19 }
            r32 = r4
            r33 = r5
            r4 = r8
            r8 = r19
            r5 = 1
            goto L_0x0338
        L_0x02b7:
            r15 = r18
            r9 = 0
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze     // Catch:{ all -> 0x0b19 }
            zzal(r11)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzag r12 = r35.zzg()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzeg r9 = com.google.android.gms.measurement.internal.zzeh.zzE     // Catch:{ all -> 0x0b19 }
            int r9 = r12.zze(r10, r9)     // Catch:{ all -> 0x0b19 }
            int r9 = r9 + -1
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0b19 }
            r11.zzg()     // Catch:{ all -> 0x0b19 }
            r11.zzW()     // Catch:{ all -> 0x0b19 }
            android.database.sqlite.SQLiteDatabase r12 = r11.zzh()     // Catch:{ SQLiteException -> 0x0300 }
            r18 = r15
            java.lang.String r15 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r32 = r4
            r4 = 3
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x02f8 }
            r16 = 0
            r4[r16] = r10     // Catch:{ SQLiteException -> 0x02f8 }
            r33 = r5
            r5 = 1
            r4[r5] = r10     // Catch:{ SQLiteException -> 0x02f6 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x02f6 }
            r16 = 2
            r4[r16] = r9     // Catch:{ SQLiteException -> 0x02f6 }
            r12.execSQL(r15, r4)     // Catch:{ SQLiteException -> 0x02f6 }
            goto L_0x031c
        L_0x02f6:
            r0 = move-exception
            goto L_0x0308
        L_0x02f8:
            r0 = move-exception
            goto L_0x02fd
        L_0x02fa:
            r0 = move-exception
            r32 = r4
        L_0x02fd:
            r33 = r5
            goto L_0x0307
        L_0x0300:
            r0 = move-exception
            r32 = r4
            r33 = r5
            r18 = r15
        L_0x0307:
            r5 = 1
        L_0x0308:
            r4 = r0
            com.google.android.gms.measurement.internal.zzge r9 = r11.zzt     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzeu r9 = r9.zzaA()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzes r9 = r9.zzd()     // Catch:{ all -> 0x0b19 }
            java.lang.String r11 = "Error pruning currencies. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzeu.zzn(r10)     // Catch:{ all -> 0x0b19 }
            r9.zzc(r11, r12, r4)     // Catch:{ all -> 0x0b19 }
        L_0x031c:
            com.google.android.gms.measurement.internal.zzll r19 = new com.google.android.gms.measurement.internal.zzll     // Catch:{ all -> 0x0b19 }
            java.lang.String r4 = r2.zzc     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.common.util.Clock r9 = r35.zzax()     // Catch:{ all -> 0x0b19 }
            long r15 = r9.currentTimeMillis()     // Catch:{ all -> 0x0b19 }
            java.lang.Long r17 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0b19 }
            r11 = r19
            r12 = r10
            r13 = r4
            r14 = r8
            r4 = r18
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0b19 }
            r8 = r19
        L_0x0338:
            com.google.android.gms.measurement.internal.zzam r9 = r1.zze     // Catch:{ all -> 0x0b19 }
            zzal(r9)     // Catch:{ all -> 0x0b19 }
            boolean r9 = r9.zzL(r8)     // Catch:{ all -> 0x0b19 }
            if (r9 != 0) goto L_0x0373
            com.google.android.gms.measurement.internal.zzeu r9 = r35.zzaA()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzes r9 = r9.zzd()     // Catch:{ all -> 0x0b19 }
            java.lang.String r11 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzeu.zzn(r10)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzge r13 = r1.zzn     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzep r13 = r13.zzj()     // Catch:{ all -> 0x0b19 }
            java.lang.String r14 = r8.zzc     // Catch:{ all -> 0x0b19 }
            java.lang.String r13 = r13.zzf(r14)     // Catch:{ all -> 0x0b19 }
            java.lang.Object r8 = r8.zze     // Catch:{ all -> 0x0b19 }
            r9.zzd(r11, r12, r13, r8)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzlo r11 = r35.zzv()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzln r12 = r1.zzF     // Catch:{ all -> 0x0b19 }
            r14 = 9
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.zzO(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0b19 }
        L_0x0373:
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0b19 }
            boolean r8 = com.google.android.gms.measurement.internal.zzlo.zzak(r8)     // Catch:{ all -> 0x0b19 }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0b19 }
            boolean r4 = r4.equals(r9)     // Catch:{ all -> 0x0b19 }
            r35.zzv()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzau r9 = r2.zzb     // Catch:{ all -> 0x0b19 }
            if (r9 != 0) goto L_0x0389
            r12 = 0
            goto L_0x03a8
        L_0x0389:
            com.google.android.gms.measurement.internal.zzat r11 = new com.google.android.gms.measurement.internal.zzat     // Catch:{ all -> 0x0b19 }
            r11.<init>(r9)     // Catch:{ all -> 0x0b19 }
            r12 = 0
        L_0x0390:
            boolean r16 = r11.hasNext()     // Catch:{ all -> 0x0b19 }
            if (r16 == 0) goto L_0x03a8
            java.lang.String r14 = r11.next()     // Catch:{ all -> 0x0b19 }
            java.lang.Object r14 = r9.zzf(r14)     // Catch:{ all -> 0x0b19 }
            boolean r15 = r14 instanceof android.os.Parcelable[]     // Catch:{ all -> 0x0b19 }
            if (r15 == 0) goto L_0x0390
            android.os.Parcelable[] r14 = (android.os.Parcelable[]) r14     // Catch:{ all -> 0x0b19 }
            int r14 = r14.length     // Catch:{ all -> 0x0b19 }
            long r14 = (long) r14     // Catch:{ all -> 0x0b19 }
            long r12 = r12 + r14
            goto L_0x0390
        L_0x03a8:
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze     // Catch:{ all -> 0x0b19 }
            zzal(r11)     // Catch:{ all -> 0x0b19 }
            long r14 = r35.zza()     // Catch:{ all -> 0x0b19 }
            r22 = 1
            long r18 = r12 + r22
            r9 = 1
            r20 = 0
            r21 = 0
            r12 = r14
            r30 = r6
            r5 = 0
            r14 = r10
            r15 = r18
            r17 = r9
            r18 = r8
            r19 = r20
            r20 = r4
            com.google.android.gms.measurement.internal.zzak r9 = r11.zzm(r12, r14, r15, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0b19 }
            long r11 = r9.zzb     // Catch:{ all -> 0x0b19 }
            r35.zzg()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzeg r13 = com.google.android.gms.measurement.internal.zzeh.zzk     // Catch:{ all -> 0x0b19 }
            r15 = 0
            java.lang.Object r13 = r13.zza(r15)     // Catch:{ all -> 0x0b19 }
            java.lang.Integer r13 = (java.lang.Integer) r13     // Catch:{ all -> 0x0b19 }
            int r13 = r13.intValue()     // Catch:{ all -> 0x0b19 }
            long r13 = (long) r13     // Catch:{ all -> 0x0b19 }
            long r11 = r11 - r13
            r13 = 1000(0x3e8, double:4.94E-321)
            int r16 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r16 <= 0) goto L_0x0415
            long r11 = r11 % r13
            int r2 = (r11 > r22 ? 1 : (r11 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x0404
            com.google.android.gms.measurement.internal.zzeu r2 = r35.zzaA()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzd()     // Catch:{ all -> 0x0b19 }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeu.zzn(r10)     // Catch:{ all -> 0x0b19 }
            long r5 = r9.zzb     // Catch:{ all -> 0x0b19 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0b19 }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0b19 }
        L_0x0404:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0b19 }
            zzal(r2)     // Catch:{ all -> 0x0b19 }
            r2.zzC()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x0415:
            if (r8 == 0) goto L_0x0471
            long r11 = r9.zza     // Catch:{ all -> 0x0b19 }
            r35.zzg()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzeg r13 = com.google.android.gms.measurement.internal.zzeh.zzm     // Catch:{ all -> 0x0b19 }
            java.lang.Object r13 = r13.zza(r15)     // Catch:{ all -> 0x0b19 }
            java.lang.Integer r13 = (java.lang.Integer) r13     // Catch:{ all -> 0x0b19 }
            int r13 = r13.intValue()     // Catch:{ all -> 0x0b19 }
            long r13 = (long) r13     // Catch:{ all -> 0x0b19 }
            long r11 = r11 - r13
            int r13 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r13 <= 0) goto L_0x0471
            r13 = 1000(0x3e8, double:4.94E-321)
            long r11 = r11 % r13
            int r3 = (r11 > r22 ? 1 : (r11 == r22 ? 0 : -1))
            if (r3 != 0) goto L_0x044c
            com.google.android.gms.measurement.internal.zzeu r3 = r35.zzaA()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzd()     // Catch:{ all -> 0x0b19 }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeu.zzn(r10)     // Catch:{ all -> 0x0b19 }
            long r6 = r9.zza     // Catch:{ all -> 0x0b19 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0b19 }
            r3.zzc(r4, r5, r6)     // Catch:{ all -> 0x0b19 }
        L_0x044c:
            com.google.android.gms.measurement.internal.zzlo r11 = r35.zzv()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzln r12 = r1.zzF     // Catch:{ all -> 0x0b19 }
            r14 = 16
            java.lang.String r15 = "_ev"
            java.lang.String r2 = r2.zza     // Catch:{ all -> 0x0b19 }
            r17 = 0
            r13 = r10
            r16 = r2
            r11.zzO(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0b19 }
            zzal(r2)     // Catch:{ all -> 0x0b19 }
            r2.zzC()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x0471:
            r11 = 1000000(0xf4240, float:1.401298E-39)
            if (r4 == 0) goto L_0x04bf
            long r12 = r9.zzd     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzag r4 = r35.zzg()     // Catch:{ all -> 0x0b19 }
            java.lang.String r14 = r3.zza     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzeg r15 = com.google.android.gms.measurement.internal.zzeh.zzl     // Catch:{ all -> 0x0b19 }
            int r4 = r4.zze(r14, r15)     // Catch:{ all -> 0x0b19 }
            int r4 = java.lang.Math.min(r11, r4)     // Catch:{ all -> 0x0b19 }
            r14 = 0
            int r4 = java.lang.Math.max(r14, r4)     // Catch:{ all -> 0x0b19 }
            long r14 = (long) r4     // Catch:{ all -> 0x0b19 }
            long r12 = r12 - r14
            int r4 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x04bf
            int r2 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x04ae
            com.google.android.gms.measurement.internal.zzeu r2 = r35.zzaA()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzd()     // Catch:{ all -> 0x0b19 }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeu.zzn(r10)     // Catch:{ all -> 0x0b19 }
            long r5 = r9.zzd     // Catch:{ all -> 0x0b19 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0b19 }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0b19 }
        L_0x04ae:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0b19 }
            zzal(r2)     // Catch:{ all -> 0x0b19 }
            r2.zzC()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x04bf:
            com.google.android.gms.measurement.internal.zzau r4 = r2.zzb     // Catch:{ all -> 0x0b19 }
            android.os.Bundle r4 = r4.zzc()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzlo r9 = r35.zzv()     // Catch:{ all -> 0x0b19 }
            java.lang.String r12 = "_o"
            java.lang.String r13 = r2.zzc     // Catch:{ all -> 0x0b19 }
            r9.zzP(r4, r12, r13)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzlo r9 = r35.zzv()     // Catch:{ all -> 0x0b19 }
            boolean r9 = r9.zzaf(r10)     // Catch:{ all -> 0x0b19 }
            java.lang.String r15 = "_r"
            if (r9 == 0) goto L_0x04f0
            com.google.android.gms.measurement.internal.zzlo r9 = r35.zzv()     // Catch:{ all -> 0x0b19 }
            java.lang.String r12 = "_dbg"
            java.lang.Long r13 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x0b19 }
            r9.zzP(r4, r12, r13)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzlo r9 = r35.zzv()     // Catch:{ all -> 0x0b19 }
            r9.zzP(r4, r15, r13)     // Catch:{ all -> 0x0b19 }
        L_0x04f0:
            java.lang.String r9 = "_s"
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x0b19 }
            boolean r9 = r9.equals(r12)     // Catch:{ all -> 0x0b19 }
            if (r9 == 0) goto L_0x0516
            com.google.android.gms.measurement.internal.zzam r9 = r1.zze     // Catch:{ all -> 0x0b19 }
            zzal(r9)     // Catch:{ all -> 0x0b19 }
            java.lang.String r12 = r3.zza     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzll r9 = r9.zzp(r12, r7)     // Catch:{ all -> 0x0b19 }
            if (r9 == 0) goto L_0x0516
            java.lang.Object r12 = r9.zze     // Catch:{ all -> 0x0b19 }
            boolean r12 = r12 instanceof java.lang.Long     // Catch:{ all -> 0x0b19 }
            if (r12 == 0) goto L_0x0516
            com.google.android.gms.measurement.internal.zzlo r12 = r35.zzv()     // Catch:{ all -> 0x0b19 }
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x0b19 }
            r12.zzP(r4, r7, r9)     // Catch:{ all -> 0x0b19 }
        L_0x0516:
            com.google.android.gms.measurement.internal.zzam r7 = r1.zze     // Catch:{ all -> 0x0b19 }
            zzal(r7)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0b19 }
            r7.zzg()     // Catch:{ all -> 0x0b19 }
            r7.zzW()     // Catch:{ all -> 0x0b19 }
            android.database.sqlite.SQLiteDatabase r9 = r7.zzh()     // Catch:{ SQLiteException -> 0x055a }
            com.google.android.gms.measurement.internal.zzge r12 = r7.zzt     // Catch:{ SQLiteException -> 0x055a }
            com.google.android.gms.measurement.internal.zzag r12 = r12.zzf()     // Catch:{ SQLiteException -> 0x055a }
            com.google.android.gms.measurement.internal.zzeg r13 = com.google.android.gms.measurement.internal.zzeh.zzp     // Catch:{ SQLiteException -> 0x055a }
            int r12 = r12.zze(r10, r13)     // Catch:{ SQLiteException -> 0x055a }
            int r11 = java.lang.Math.min(r11, r12)     // Catch:{ SQLiteException -> 0x055a }
            r14 = 0
            int r11 = java.lang.Math.max(r14, r11)     // Catch:{ SQLiteException -> 0x0556 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ SQLiteException -> 0x0556 }
            java.lang.String r12 = "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)"
            r13 = 2
            java.lang.String[] r13 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0556 }
            r13[r14] = r10     // Catch:{ SQLiteException -> 0x0556 }
            r17 = 1
            r13[r17] = r11     // Catch:{ SQLiteException -> 0x0556 }
            r11 = r30
            int r7 = r9.delete(r11, r12, r13)     // Catch:{ SQLiteException -> 0x0554 }
            long r12 = (long) r7
            goto L_0x0573
        L_0x0554:
            r0 = move-exception
            goto L_0x055e
        L_0x0556:
            r0 = move-exception
            r11 = r30
            goto L_0x055e
        L_0x055a:
            r0 = move-exception
            r11 = r30
            r14 = 0
        L_0x055e:
            r9 = r0
            com.google.android.gms.measurement.internal.zzge r7 = r7.zzt     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzeu r7 = r7.zzaA()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzes r7 = r7.zzd()     // Catch:{ all -> 0x0b19 }
            java.lang.String r12 = "Error deleting over the limit events. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeu.zzn(r10)     // Catch:{ all -> 0x0b19 }
            r7.zzc(r12, r13, r9)     // Catch:{ all -> 0x0b19 }
            r12 = r5
        L_0x0573:
            int r7 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x058c
            com.google.android.gms.measurement.internal.zzeu r7 = r35.zzaA()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzes r7 = r7.zzk()     // Catch:{ all -> 0x0b19 }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzeu.zzn(r10)     // Catch:{ all -> 0x0b19 }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0b19 }
            r7.zzc(r9, r14, r12)     // Catch:{ all -> 0x0b19 }
        L_0x058c:
            com.google.android.gms.measurement.internal.zzar r7 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzge r12 = r1.zzn     // Catch:{ all -> 0x0b19 }
            java.lang.String r13 = r2.zzc     // Catch:{ all -> 0x0b19 }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0b19 }
            long r5 = r2.zzd     // Catch:{ all -> 0x0b19 }
            r18 = 0
            r2 = r11
            r11 = r7
            r31 = 0
            r14 = r10
            r36 = r2
            r34 = r15
            r2 = 0
            r15 = r9
            r16 = r5
            r20 = r4
            r11.<init>((com.google.android.gms.measurement.internal.zzge) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (long) r16, (long) r18, (android.os.Bundle) r20)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzam r4 = r1.zze     // Catch:{ all -> 0x0b19 }
            zzal(r4)     // Catch:{ all -> 0x0b19 }
            java.lang.String r5 = r7.zzb     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzas r4 = r4.zzn(r10, r5)     // Catch:{ all -> 0x0b19 }
            if (r4 != 0) goto L_0x0630
            com.google.android.gms.measurement.internal.zzam r4 = r1.zze     // Catch:{ all -> 0x0b19 }
            zzal(r4)     // Catch:{ all -> 0x0b19 }
            long r4 = r4.zzf(r10)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzag r6 = r35.zzg()     // Catch:{ all -> 0x0b19 }
            int r6 = r6.zzb(r10)     // Catch:{ all -> 0x0b19 }
            long r11 = (long) r6     // Catch:{ all -> 0x0b19 }
            int r6 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r6 < 0) goto L_0x0612
            if (r8 == 0) goto L_0x0612
            com.google.android.gms.measurement.internal.zzeu r2 = r35.zzaA()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzd()     // Catch:{ all -> 0x0b19 }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeu.zzn(r10)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzge r5 = r1.zzn     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzep r5 = r5.zzj()     // Catch:{ all -> 0x0b19 }
            java.lang.String r6 = r7.zzb     // Catch:{ all -> 0x0b19 }
            java.lang.String r5 = r5.zzd(r6)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzag r6 = r35.zzg()     // Catch:{ all -> 0x0b19 }
            int r6 = r6.zzb(r10)     // Catch:{ all -> 0x0b19 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0b19 }
            r2.zzd(r3, r4, r5, r6)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzlo r11 = r35.zzv()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzln r12 = r1.zzF     // Catch:{ all -> 0x0b19 }
            r14 = 8
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.zzO(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x0612:
            com.google.android.gms.measurement.internal.zzas r4 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x0b19 }
            java.lang.String r13 = r7.zzb     // Catch:{ all -> 0x0b19 }
            long r5 = r7.zzd     // Catch:{ all -> 0x0b19 }
            r14 = 0
            r16 = 0
            r18 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r11 = r4
            r12 = r10
            r20 = r5
            r11.<init>(r12, r13, r14, r16, r18, r20, r22, r24, r25, r26, r27)     // Catch:{ all -> 0x0b19 }
            goto L_0x063e
        L_0x0630:
            com.google.android.gms.measurement.internal.zzge r5 = r1.zzn     // Catch:{ all -> 0x0b19 }
            long r8 = r4.zzf     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzar r7 = r7.zza(r5, r8)     // Catch:{ all -> 0x0b19 }
            long r5 = r7.zzd     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzas r4 = r4.zzc(r5)     // Catch:{ all -> 0x0b19 }
        L_0x063e:
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0b19 }
            zzal(r5)     // Catch:{ all -> 0x0b19 }
            r5.zzE(r4)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzgb r4 = r35.zzaB()     // Catch:{ all -> 0x0b19 }
            r4.zzg()     // Catch:{ all -> 0x0b19 }
            r35.zzB()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r37)     // Catch:{ all -> 0x0b19 }
            java.lang.String r4 = r7.zza     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)     // Catch:{ all -> 0x0b19 }
            java.lang.String r4 = r7.zza     // Catch:{ all -> 0x0b19 }
            java.lang.String r5 = r3.zza     // Catch:{ all -> 0x0b19 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r4)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.internal.measurement.zzgc r4 = com.google.android.gms.internal.measurement.zzgd.zzu()     // Catch:{ all -> 0x0b19 }
            r5 = 1
            r4.zzad(r5)     // Catch:{ all -> 0x0b19 }
            java.lang.String r6 = "android"
            r4.zzZ(r6)     // Catch:{ all -> 0x0b19 }
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0b19 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b19 }
            if (r6 != 0) goto L_0x0680
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0b19 }
            r4.zzD(r6)     // Catch:{ all -> 0x0b19 }
        L_0x0680:
            java.lang.String r6 = r3.zzd     // Catch:{ all -> 0x0b19 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b19 }
            if (r6 != 0) goto L_0x068d
            java.lang.String r6 = r3.zzd     // Catch:{ all -> 0x0b19 }
            r4.zzF(r6)     // Catch:{ all -> 0x0b19 }
        L_0x068d:
            java.lang.String r6 = r3.zzc     // Catch:{ all -> 0x0b19 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b19 }
            if (r6 != 0) goto L_0x069a
            java.lang.String r6 = r3.zzc     // Catch:{ all -> 0x0b19 }
            r4.zzG(r6)     // Catch:{ all -> 0x0b19 }
        L_0x069a:
            com.google.android.gms.internal.measurement.zzqr.zzc()     // Catch:{ all -> 0x0b19 }
            java.lang.String r6 = r3.zzx     // Catch:{ all -> 0x0b19 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b19 }
            if (r6 != 0) goto L_0x06c4
            com.google.android.gms.measurement.internal.zzag r6 = r35.zzg()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzeg r8 = com.google.android.gms.measurement.internal.zzeh.zzam     // Catch:{ all -> 0x0b19 }
            boolean r6 = r6.zzs(r2, r8)     // Catch:{ all -> 0x0b19 }
            if (r6 != 0) goto L_0x06bf
            com.google.android.gms.measurement.internal.zzag r6 = r35.zzg()     // Catch:{ all -> 0x0b19 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzeg r9 = com.google.android.gms.measurement.internal.zzeh.zzao     // Catch:{ all -> 0x0b19 }
            boolean r6 = r6.zzs(r8, r9)     // Catch:{ all -> 0x0b19 }
            if (r6 == 0) goto L_0x06c4
        L_0x06bf:
            java.lang.String r6 = r3.zzx     // Catch:{ all -> 0x0b19 }
            r4.zzah(r6)     // Catch:{ all -> 0x0b19 }
        L_0x06c4:
            long r8 = r3.zzj     // Catch:{ all -> 0x0b19 }
            r10 = -2147483648(0xffffffff80000000, double:NaN)
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x06d1
            int r6 = (int) r8     // Catch:{ all -> 0x0b19 }
            r4.zzH(r6)     // Catch:{ all -> 0x0b19 }
        L_0x06d1:
            long r8 = r3.zze     // Catch:{ all -> 0x0b19 }
            r4.zzV(r8)     // Catch:{ all -> 0x0b19 }
            java.lang.String r6 = r3.zzb     // Catch:{ all -> 0x0b19 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b19 }
            if (r6 != 0) goto L_0x06e3
            java.lang.String r6 = r3.zzb     // Catch:{ all -> 0x0b19 }
            r4.zzU(r6)     // Catch:{ all -> 0x0b19 }
        L_0x06e3:
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0b19 }
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ all -> 0x0b19 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzai r6 = r1.zzh(r6)     // Catch:{ all -> 0x0b19 }
            java.lang.String r8 = r3.zzv     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzai r8 = com.google.android.gms.measurement.internal.zzai.zzb(r8)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzai r6 = r6.zzc(r8)     // Catch:{ all -> 0x0b19 }
            java.lang.String r6 = r6.zzh()     // Catch:{ all -> 0x0b19 }
            r4.zzL(r6)     // Catch:{ all -> 0x0b19 }
            java.lang.String r6 = r4.zzar()     // Catch:{ all -> 0x0b19 }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x0b19 }
            if (r6 == 0) goto L_0x0717
            java.lang.String r6 = r3.zzq     // Catch:{ all -> 0x0b19 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b19 }
            if (r6 != 0) goto L_0x0717
            java.lang.String r6 = r3.zzq     // Catch:{ all -> 0x0b19 }
            r4.zzC(r6)     // Catch:{ all -> 0x0b19 }
        L_0x0717:
            long r8 = r3.zzf     // Catch:{ all -> 0x0b19 }
            r10 = 0
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0722
            r4.zzM(r8)     // Catch:{ all -> 0x0b19 }
        L_0x0722:
            long r8 = r3.zzs     // Catch:{ all -> 0x0b19 }
            r4.zzP(r8)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzli r6 = r1.zzi     // Catch:{ all -> 0x0b19 }
            zzal(r6)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzlg r8 = r6.zzf     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzge r8 = r8.zzn     // Catch:{ all -> 0x0b19 }
            android.content.Context r8 = r8.zzaw()     // Catch:{ all -> 0x0b19 }
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch:{ all -> 0x0b19 }
            java.lang.String r9 = "com.google.android.gms.measurement"
            android.net.Uri r9 = com.google.android.gms.internal.measurement.zzhq.zza(r9)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzay r10 = com.google.android.gms.measurement.internal.zzay.zza     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.internal.measurement.zzhf r8 = com.google.android.gms.internal.measurement.zzhf.zza(r8, r9, r10)     // Catch:{ all -> 0x0b19 }
            if (r8 != 0) goto L_0x074b
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0b19 }
            goto L_0x074f
        L_0x074b:
            java.util.Map r8 = r8.zzc()     // Catch:{ all -> 0x0b19 }
        L_0x074f:
            if (r8 == 0) goto L_0x07d5
            boolean r9 = r8.isEmpty()     // Catch:{ all -> 0x0b19 }
            if (r9 == 0) goto L_0x0759
            goto L_0x07d5
        L_0x0759:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x0b19 }
            r14.<init>()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzeg r9 = com.google.android.gms.measurement.internal.zzeh.zzP     // Catch:{ all -> 0x0b19 }
            java.lang.Object r9 = r9.zza(r2)     // Catch:{ all -> 0x0b19 }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ all -> 0x0b19 }
            int r9 = r9.intValue()     // Catch:{ all -> 0x0b19 }
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x0b19 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0b19 }
        L_0x0772:
            boolean r10 = r8.hasNext()     // Catch:{ all -> 0x0b19 }
            if (r10 == 0) goto L_0x07cf
            java.lang.Object r10 = r8.next()     // Catch:{ all -> 0x0b19 }
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ all -> 0x0b19 }
            java.lang.Object r11 = r10.getKey()     // Catch:{ all -> 0x0b19 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0b19 }
            java.lang.String r12 = "measurement.id."
            boolean r11 = r11.startsWith(r12)     // Catch:{ all -> 0x0b19 }
            if (r11 == 0) goto L_0x0772
            java.lang.Object r10 = r10.getValue()     // Catch:{ NumberFormatException -> 0x07bd }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ NumberFormatException -> 0x07bd }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x07bd }
            if (r10 == 0) goto L_0x0772
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ NumberFormatException -> 0x07bd }
            r14.add(r10)     // Catch:{ NumberFormatException -> 0x07bd }
            int r10 = r14.size()     // Catch:{ NumberFormatException -> 0x07bd }
            if (r10 < r9) goto L_0x0772
            com.google.android.gms.measurement.internal.zzge r10 = r6.zzt     // Catch:{ NumberFormatException -> 0x07bd }
            com.google.android.gms.measurement.internal.zzeu r10 = r10.zzaA()     // Catch:{ NumberFormatException -> 0x07bd }
            com.google.android.gms.measurement.internal.zzes r10 = r10.zzk()     // Catch:{ NumberFormatException -> 0x07bd }
            java.lang.String r11 = "Too many experiment IDs. Number of IDs"
            int r12 = r14.size()     // Catch:{ NumberFormatException -> 0x07bd }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ NumberFormatException -> 0x07bd }
            r10.zzb(r11, r12)     // Catch:{ NumberFormatException -> 0x07bd }
            goto L_0x07cf
        L_0x07bd:
            r0 = move-exception
            r10 = r0
            com.google.android.gms.measurement.internal.zzge r11 = r6.zzt     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzeu r11 = r11.zzaA()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzes r11 = r11.zzk()     // Catch:{ all -> 0x0b19 }
            java.lang.String r12 = "Experiment ID NumberFormatException"
            r11.zzb(r12, r10)     // Catch:{ all -> 0x0b19 }
            goto L_0x0772
        L_0x07cf:
            boolean r6 = r14.isEmpty()     // Catch:{ all -> 0x0b19 }
            if (r6 == 0) goto L_0x07d6
        L_0x07d5:
            r14 = r2
        L_0x07d6:
            if (r14 == 0) goto L_0x07db
            r4.zzh(r14)     // Catch:{ all -> 0x0b19 }
        L_0x07db:
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0b19 }
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ all -> 0x0b19 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzai r6 = r1.zzh(r6)     // Catch:{ all -> 0x0b19 }
            java.lang.String r8 = r3.zzv     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzai r8 = com.google.android.gms.measurement.internal.zzai.zzb(r8)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzai r6 = r6.zzc(r8)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzah r8 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x0b19 }
            boolean r8 = r6.zzi(r8)     // Catch:{ all -> 0x0b19 }
            if (r8 == 0) goto L_0x0829
            boolean r8 = r3.zzo     // Catch:{ all -> 0x0b19 }
            if (r8 == 0) goto L_0x0829
            com.google.android.gms.measurement.internal.zzka r8 = r1.zzk     // Catch:{ all -> 0x0b19 }
            java.lang.String r9 = r3.zza     // Catch:{ all -> 0x0b19 }
            android.util.Pair r8 = r8.zzd(r9, r6)     // Catch:{ all -> 0x0b19 }
            java.lang.Object r9 = r8.first     // Catch:{ all -> 0x0b19 }
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ all -> 0x0b19 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0b19 }
            if (r9 != 0) goto L_0x0829
            boolean r9 = r3.zzo     // Catch:{ all -> 0x0b19 }
            if (r9 == 0) goto L_0x0829
            java.lang.Object r9 = r8.first     // Catch:{ all -> 0x0b19 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0b19 }
            r4.zzae(r9)     // Catch:{ all -> 0x0b19 }
            java.lang.Object r9 = r8.second     // Catch:{ all -> 0x0b19 }
            if (r9 == 0) goto L_0x0829
            java.lang.Object r8 = r8.second     // Catch:{ all -> 0x0b19 }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0b19 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0b19 }
            r4.zzX(r8)     // Catch:{ all -> 0x0b19 }
        L_0x0829:
            com.google.android.gms.measurement.internal.zzge r8 = r1.zzn     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzaq r8 = r8.zzg()     // Catch:{ all -> 0x0b19 }
            r8.zzv()     // Catch:{ all -> 0x0b19 }
            java.lang.String r8 = android.os.Build.MODEL     // Catch:{ all -> 0x0b19 }
            r4.zzN(r8)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzge r8 = r1.zzn     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzaq r8 = r8.zzg()     // Catch:{ all -> 0x0b19 }
            r8.zzv()     // Catch:{ all -> 0x0b19 }
            java.lang.String r8 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0b19 }
            r4.zzY(r8)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzge r8 = r1.zzn     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzaq r8 = r8.zzg()     // Catch:{ all -> 0x0b19 }
            long r8 = r8.zzb()     // Catch:{ all -> 0x0b19 }
            int r9 = (int) r8     // Catch:{ all -> 0x0b19 }
            r4.zzak(r9)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzge r8 = r1.zzn     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzaq r8 = r8.zzg()     // Catch:{ all -> 0x0b19 }
            java.lang.String r8 = r8.zzc()     // Catch:{ all -> 0x0b19 }
            r4.zzao(r8)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.internal.measurement.zzpw.zzc()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzag r8 = r35.zzg()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzeg r9 = com.google.android.gms.measurement.internal.zzeh.zzaE     // Catch:{ all -> 0x0b19 }
            boolean r8 = r8.zzs(r2, r9)     // Catch:{ all -> 0x0b19 }
            if (r8 == 0) goto L_0x0874
            long r8 = r3.zzz     // Catch:{ all -> 0x0b19 }
            r4.zzaj(r8)     // Catch:{ all -> 0x0b19 }
        L_0x0874:
            com.google.android.gms.measurement.internal.zzge r8 = r1.zzn     // Catch:{ all -> 0x0b19 }
            boolean r8 = r8.zzJ()     // Catch:{ all -> 0x0b19 }
            if (r8 == 0) goto L_0x0888
            r4.zzaq()     // Catch:{ all -> 0x0b19 }
            boolean r8 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0b19 }
            if (r8 != 0) goto L_0x0888
            r4.zzO(r2)     // Catch:{ all -> 0x0b19 }
        L_0x0888:
            com.google.android.gms.measurement.internal.zzam r8 = r1.zze     // Catch:{ all -> 0x0b19 }
            zzal(r8)     // Catch:{ all -> 0x0b19 }
            java.lang.String r9 = r3.zza     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzh r8 = r8.zzj(r9)     // Catch:{ all -> 0x0b19 }
            if (r8 != 0) goto L_0x08fa
            com.google.android.gms.measurement.internal.zzh r8 = new com.google.android.gms.measurement.internal.zzh     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzge r9 = r1.zzn     // Catch:{ all -> 0x0b19 }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0b19 }
            r8.<init>(r9, r10)     // Catch:{ all -> 0x0b19 }
            java.lang.String r9 = r1.zzw(r6)     // Catch:{ all -> 0x0b19 }
            r8.zzI(r9)     // Catch:{ all -> 0x0b19 }
            java.lang.String r9 = r3.zzk     // Catch:{ all -> 0x0b19 }
            r8.zzW(r9)     // Catch:{ all -> 0x0b19 }
            java.lang.String r9 = r3.zzb     // Catch:{ all -> 0x0b19 }
            r8.zzX(r9)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzah r9 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x0b19 }
            boolean r9 = r6.zzi(r9)     // Catch:{ all -> 0x0b19 }
            if (r9 == 0) goto L_0x08c4
            com.google.android.gms.measurement.internal.zzka r9 = r1.zzk     // Catch:{ all -> 0x0b19 }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0b19 }
            boolean r11 = r3.zzo     // Catch:{ all -> 0x0b19 }
            java.lang.String r9 = r9.zzf(r10, r11)     // Catch:{ all -> 0x0b19 }
            r8.zzaf(r9)     // Catch:{ all -> 0x0b19 }
        L_0x08c4:
            r9 = 0
            r8.zzab(r9)     // Catch:{ all -> 0x0b19 }
            r8.zzac(r9)     // Catch:{ all -> 0x0b19 }
            r8.zzaa(r9)     // Catch:{ all -> 0x0b19 }
            java.lang.String r9 = r3.zzc     // Catch:{ all -> 0x0b19 }
            r8.zzK(r9)     // Catch:{ all -> 0x0b19 }
            long r9 = r3.zzj     // Catch:{ all -> 0x0b19 }
            r8.zzL(r9)     // Catch:{ all -> 0x0b19 }
            java.lang.String r9 = r3.zzd     // Catch:{ all -> 0x0b19 }
            r8.zzJ(r9)     // Catch:{ all -> 0x0b19 }
            long r9 = r3.zze     // Catch:{ all -> 0x0b19 }
            r8.zzY(r9)     // Catch:{ all -> 0x0b19 }
            long r9 = r3.zzf     // Catch:{ all -> 0x0b19 }
            r8.zzT(r9)     // Catch:{ all -> 0x0b19 }
            boolean r9 = r3.zzh     // Catch:{ all -> 0x0b19 }
            r8.zzad(r9)     // Catch:{ all -> 0x0b19 }
            long r9 = r3.zzs     // Catch:{ all -> 0x0b19 }
            r8.zzU(r9)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzam r9 = r1.zze     // Catch:{ all -> 0x0b19 }
            zzal(r9)     // Catch:{ all -> 0x0b19 }
            r9.zzD(r8)     // Catch:{ all -> 0x0b19 }
        L_0x08fa:
            com.google.android.gms.measurement.internal.zzah r9 = com.google.android.gms.measurement.internal.zzah.ANALYTICS_STORAGE     // Catch:{ all -> 0x0b19 }
            boolean r6 = r6.zzi(r9)     // Catch:{ all -> 0x0b19 }
            if (r6 == 0) goto L_0x0919
            java.lang.String r6 = r8.zzv()     // Catch:{ all -> 0x0b19 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b19 }
            if (r6 != 0) goto L_0x0919
            java.lang.String r6 = r8.zzv()     // Catch:{ all -> 0x0b19 }
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ all -> 0x0b19 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0b19 }
            r4.zzE(r6)     // Catch:{ all -> 0x0b19 }
        L_0x0919:
            java.lang.String r6 = r8.zzy()     // Catch:{ all -> 0x0b19 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b19 }
            if (r6 != 0) goto L_0x0930
            java.lang.String r6 = r8.zzy()     // Catch:{ all -> 0x0b19 }
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ all -> 0x0b19 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0b19 }
            r4.zzT(r6)     // Catch:{ all -> 0x0b19 }
        L_0x0930:
            com.google.android.gms.measurement.internal.zzam r6 = r1.zze     // Catch:{ all -> 0x0b19 }
            zzal(r6)     // Catch:{ all -> 0x0b19 }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x0b19 }
            java.util.List r3 = r6.zzu(r3)     // Catch:{ all -> 0x0b19 }
            r13 = 0
        L_0x093c:
            int r6 = r3.size()     // Catch:{ all -> 0x0b19 }
            if (r13 >= r6) goto L_0x0972
            com.google.android.gms.internal.measurement.zzgl r6 = com.google.android.gms.internal.measurement.zzgm.zzd()     // Catch:{ all -> 0x0b19 }
            java.lang.Object r8 = r3.get(r13)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzll r8 = (com.google.android.gms.measurement.internal.zzll) r8     // Catch:{ all -> 0x0b19 }
            java.lang.String r8 = r8.zzc     // Catch:{ all -> 0x0b19 }
            r6.zzf(r8)     // Catch:{ all -> 0x0b19 }
            java.lang.Object r8 = r3.get(r13)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzll r8 = (com.google.android.gms.measurement.internal.zzll) r8     // Catch:{ all -> 0x0b19 }
            long r8 = r8.zzd     // Catch:{ all -> 0x0b19 }
            r6.zzg(r8)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzli r8 = r1.zzi     // Catch:{ all -> 0x0b19 }
            zzal(r8)     // Catch:{ all -> 0x0b19 }
            java.lang.Object r9 = r3.get(r13)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzll r9 = (com.google.android.gms.measurement.internal.zzll) r9     // Catch:{ all -> 0x0b19 }
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x0b19 }
            r8.zzu(r6, r9)     // Catch:{ all -> 0x0b19 }
            r4.zzl(r6)     // Catch:{ all -> 0x0b19 }
            int r13 = r13 + 1
            goto L_0x093c
        L_0x0972:
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze     // Catch:{ IOException -> 0x0acf }
            zzal(r3)     // Catch:{ IOException -> 0x0acf }
            com.google.android.gms.internal.measurement.zzlb r6 = r4.zzaD()     // Catch:{ IOException -> 0x0acf }
            com.google.android.gms.internal.measurement.zzgd r6 = (com.google.android.gms.internal.measurement.zzgd) r6     // Catch:{ IOException -> 0x0acf }
            r3.zzg()     // Catch:{ IOException -> 0x0acf }
            r3.zzW()     // Catch:{ IOException -> 0x0acf }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ IOException -> 0x0acf }
            java.lang.String r8 = r6.zzy()     // Catch:{ IOException -> 0x0acf }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ IOException -> 0x0acf }
            byte[] r8 = r6.zzbx()     // Catch:{ IOException -> 0x0acf }
            com.google.android.gms.measurement.internal.zzlg r9 = r3.zzf     // Catch:{ IOException -> 0x0acf }
            com.google.android.gms.measurement.internal.zzli r9 = r9.zzi     // Catch:{ IOException -> 0x0acf }
            zzal(r9)     // Catch:{ IOException -> 0x0acf }
            long r9 = r9.zzd(r8)     // Catch:{ IOException -> 0x0acf }
            android.content.ContentValues r11 = new android.content.ContentValues     // Catch:{ IOException -> 0x0acf }
            r11.<init>()     // Catch:{ IOException -> 0x0acf }
            java.lang.String r12 = r6.zzy()     // Catch:{ IOException -> 0x0acf }
            r13 = r33
            r11.put(r13, r12)     // Catch:{ IOException -> 0x0acf }
            java.lang.Long r12 = java.lang.Long.valueOf(r9)     // Catch:{ IOException -> 0x0acf }
            r14 = r32
            r11.put(r14, r12)     // Catch:{ IOException -> 0x0acf }
            java.lang.String r12 = "metadata"
            r11.put(r12, r8)     // Catch:{ IOException -> 0x0acf }
            android.database.sqlite.SQLiteDatabase r8 = r3.zzh()     // Catch:{ SQLiteException -> 0x0ab5 }
            java.lang.String r12 = "raw_events_metadata"
            r15 = 4
            r8.insertWithOnConflict(r12, r2, r11, r15)     // Catch:{ SQLiteException -> 0x0ab5 }
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze     // Catch:{ all -> 0x0b19 }
            zzal(r3)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzau r4 = r7.zzf     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzat r6 = new com.google.android.gms.measurement.internal.zzat     // Catch:{ all -> 0x0b19 }
            r6.<init>(r4)     // Catch:{ all -> 0x0b19 }
        L_0x09ce:
            boolean r4 = r6.hasNext()     // Catch:{ all -> 0x0b19 }
            if (r4 == 0) goto L_0x09e6
            java.lang.String r4 = r6.next()     // Catch:{ all -> 0x0b19 }
            r8 = r34
            boolean r4 = r8.equals(r4)     // Catch:{ all -> 0x0b19 }
            if (r4 == 0) goto L_0x09e3
        L_0x09e0:
            r31 = 1
            goto L_0x0a24
        L_0x09e3:
            r34 = r8
            goto L_0x09ce
        L_0x09e6:
            com.google.android.gms.measurement.internal.zzfv r4 = r1.zzc     // Catch:{ all -> 0x0b19 }
            zzal(r4)     // Catch:{ all -> 0x0b19 }
            java.lang.String r6 = r7.zza     // Catch:{ all -> 0x0b19 }
            java.lang.String r8 = r7.zzb     // Catch:{ all -> 0x0b19 }
            boolean r4 = r4.zzq(r6, r8)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzam r15 = r1.zze     // Catch:{ all -> 0x0b19 }
            zzal(r15)     // Catch:{ all -> 0x0b19 }
            long r16 = r35.zza()     // Catch:{ all -> 0x0b19 }
            java.lang.String r6 = r7.zza     // Catch:{ all -> 0x0b19 }
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r18 = r6
            com.google.android.gms.measurement.internal.zzak r6 = r15.zzl(r16, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x0b19 }
            if (r4 == 0) goto L_0x0a24
            long r11 = r6.zze     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzag r4 = r35.zzg()     // Catch:{ all -> 0x0b19 }
            java.lang.String r6 = r7.zza     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzeg r8 = com.google.android.gms.measurement.internal.zzeh.zzo     // Catch:{ all -> 0x0b19 }
            int r4 = r4.zze(r6, r8)     // Catch:{ all -> 0x0b19 }
            long r5 = (long) r4     // Catch:{ all -> 0x0b19 }
            int r4 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0a24
            goto L_0x09e0
        L_0x0a24:
            r3.zzg()     // Catch:{ all -> 0x0b19 }
            r3.zzW()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x0b19 }
            java.lang.String r4 = r7.zza     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzlg r4 = r3.zzf     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzli r4 = r4.zzi     // Catch:{ all -> 0x0b19 }
            zzal(r4)     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.internal.measurement.zzft r4 = r4.zzj(r7)     // Catch:{ all -> 0x0b19 }
            byte[] r4 = r4.zzbx()     // Catch:{ all -> 0x0b19 }
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ all -> 0x0b19 }
            r5.<init>()     // Catch:{ all -> 0x0b19 }
            java.lang.String r6 = r7.zza     // Catch:{ all -> 0x0b19 }
            r5.put(r13, r6)     // Catch:{ all -> 0x0b19 }
            java.lang.String r6 = "name"
            java.lang.String r8 = r7.zzb     // Catch:{ all -> 0x0b19 }
            r5.put(r6, r8)     // Catch:{ all -> 0x0b19 }
            java.lang.String r6 = "timestamp"
            long r11 = r7.zzd     // Catch:{ all -> 0x0b19 }
            java.lang.Long r8 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0b19 }
            r5.put(r6, r8)     // Catch:{ all -> 0x0b19 }
            java.lang.Long r6 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0b19 }
            r5.put(r14, r6)     // Catch:{ all -> 0x0b19 }
            java.lang.String r6 = "data"
            r5.put(r6, r4)     // Catch:{ all -> 0x0b19 }
            java.lang.String r4 = "realtime"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r31)     // Catch:{ all -> 0x0b19 }
            r5.put(r4, r6)     // Catch:{ all -> 0x0b19 }
            android.database.sqlite.SQLiteDatabase r4 = r3.zzh()     // Catch:{ SQLiteException -> 0x0a9d }
            r6 = r36
            long r4 = r4.insert(r6, r2, r5)     // Catch:{ SQLiteException -> 0x0a9d }
            r8 = -1
            int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x0a98
            com.google.android.gms.measurement.internal.zzge r2 = r3.zzt     // Catch:{ SQLiteException -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzeu r2 = r2.zzaA()     // Catch:{ SQLiteException -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x0a9d }
            java.lang.String r4 = "Failed to insert raw event (got -1). appId"
            java.lang.String r5 = r7.zza     // Catch:{ SQLiteException -> 0x0a9d }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeu.zzn(r5)     // Catch:{ SQLiteException -> 0x0a9d }
            r2.zzb(r4, r5)     // Catch:{ SQLiteException -> 0x0a9d }
            goto L_0x0ae6
        L_0x0a98:
            r4 = 0
            r1.zza = r4     // Catch:{ all -> 0x0b19 }
            goto L_0x0ae6
        L_0x0a9d:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzge r3 = r3.zzt     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzeu r3 = r3.zzaA()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzd()     // Catch:{ all -> 0x0b19 }
            java.lang.String r4 = "Error storing raw event. appId"
            java.lang.String r5 = r7.zza     // Catch:{ all -> 0x0b19 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeu.zzn(r5)     // Catch:{ all -> 0x0b19 }
            r3.zzc(r4, r5, r2)     // Catch:{ all -> 0x0b19 }
            goto L_0x0ae6
        L_0x0ab5:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzge r3 = r3.zzt     // Catch:{ IOException -> 0x0acf }
            com.google.android.gms.measurement.internal.zzeu r3 = r3.zzaA()     // Catch:{ IOException -> 0x0acf }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzd()     // Catch:{ IOException -> 0x0acf }
            java.lang.String r5 = "Error storing raw event metadata. appId"
            java.lang.String r6 = r6.zzy()     // Catch:{ IOException -> 0x0acf }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeu.zzn(r6)     // Catch:{ IOException -> 0x0acf }
            r3.zzc(r5, r6, r2)     // Catch:{ IOException -> 0x0acf }
            throw r2     // Catch:{ IOException -> 0x0acf }
        L_0x0acf:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzeu r3 = r35.zzaA()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzd()     // Catch:{ all -> 0x0b19 }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r4 = r4.zzaq()     // Catch:{ all -> 0x0b19 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeu.zzn(r4)     // Catch:{ all -> 0x0b19 }
            r3.zzc(r5, r4, r2)     // Catch:{ all -> 0x0b19 }
        L_0x0ae6:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0b19 }
            zzal(r2)     // Catch:{ all -> 0x0b19 }
            r2.zzC()     // Catch:{ all -> 0x0b19 }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            r35.zzag()
            com.google.android.gms.measurement.internal.zzeu r2 = r35.zzaA()
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzj()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r28
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zzb(r4, r3)
            return
        L_0x0b19:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze
            zzal(r3)
            r3.zzx()
            throw r2
        L_0x0b24:
            r1.zzd(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlg.zzY(com.google.android.gms.measurement.internal.zzaw, com.google.android.gms.measurement.internal.zzq):void");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzZ() {
        zzaB().zzg();
        FileLock fileLock = this.zzw;
        if (fileLock == null || !fileLock.isValid()) {
            this.zze.zzt.zzf();
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzn.zzaw().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzx = channel;
                FileLock tryLock = channel.tryLock();
                this.zzw = tryLock;
                if (tryLock != null) {
                    zzaA().zzj().zza("Storage concurrent access okay");
                    return true;
                }
                zzaA().zzd().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                zzaA().zzd().zzb("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                zzaA().zzd().zzb("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                zzaA().zzk().zzb("Storage lock already acquired", e3);
                return false;
            }
        } else {
            zzaA().zzj().zza("Storage concurrent access okay");
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final long zza() {
        long currentTimeMillis = zzax().currentTimeMillis();
        zzka zzka = this.zzk;
        zzka.zzW();
        zzka.zzg();
        long zza2 = zzka.zze.zza();
        if (zza2 == 0) {
            zza2 = ((long) zzka.zzt.zzv().zzG().nextInt(86400000)) + 1;
            zzka.zze.zzb(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    public final zzeu zzaA() {
        return ((zzge) Preconditions.checkNotNull(this.zzn)).zzaA();
    }

    public final zzgb zzaB() {
        return ((zzge) Preconditions.checkNotNull(this.zzn)).zzaB();
    }

    public final Context zzaw() {
        return this.zzn.zzaw();
    }

    public final Clock zzax() {
        return ((zzge) Preconditions.checkNotNull(this.zzn)).zzax();
    }

    public final zzab zzay() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final zzh zzd(zzq zzq2) {
        zzaB().zzg();
        zzB();
        Preconditions.checkNotNull(zzq2);
        Preconditions.checkNotEmpty(zzq2.zza);
        if (!zzq2.zzw.isEmpty()) {
            this.zzC.put(zzq2.zza, new zzlf(this, zzq2.zzw));
        }
        zzam zzam = this.zze;
        zzal(zzam);
        zzh zzj2 = zzam.zzj(zzq2.zza);
        zzai zzc2 = zzh(zzq2.zza).zzc(zzai.zzb(zzq2.zzv));
        String zzf2 = zzc2.zzi(zzah.AD_STORAGE) ? this.zzk.zzf(zzq2.zza, zzq2.zzo) : "";
        if (zzj2 == null) {
            zzj2 = new zzh(this.zzn, zzq2.zza);
            if (zzc2.zzi(zzah.ANALYTICS_STORAGE)) {
                zzj2.zzI(zzw(zzc2));
            }
            if (zzc2.zzi(zzah.AD_STORAGE)) {
                zzj2.zzaf(zzf2);
            }
        } else if (zzc2.zzi(zzah.AD_STORAGE) && zzf2 != null && !zzf2.equals(zzj2.zzB())) {
            zzj2.zzaf(zzf2);
            if (zzq2.zzo && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(zzq2.zza, zzc2).first)) {
                zzj2.zzI(zzw(zzc2));
                zzam zzam2 = this.zze;
                zzal(zzam2);
                if (zzam2.zzp(zzq2.zza, "_id") != null) {
                    zzam zzam3 = this.zze;
                    zzal(zzam3);
                    if (zzam3.zzp(zzq2.zza, "_lair") == null) {
                        zzll zzll = new zzll(zzq2.zza, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lair", zzax().currentTimeMillis(), 1L);
                        zzam zzam4 = this.zze;
                        zzal(zzam4);
                        zzam4.zzL(zzll);
                    }
                }
            }
        } else if (TextUtils.isEmpty(zzj2.zzv()) && zzc2.zzi(zzah.ANALYTICS_STORAGE)) {
            zzj2.zzI(zzw(zzc2));
        }
        zzj2.zzX(zzq2.zzb);
        zzj2.zzG(zzq2.zzq);
        if (!TextUtils.isEmpty(zzq2.zzk)) {
            zzj2.zzW(zzq2.zzk);
        }
        long j = zzq2.zze;
        if (j != 0) {
            zzj2.zzY(j);
        }
        if (!TextUtils.isEmpty(zzq2.zzc)) {
            zzj2.zzK(zzq2.zzc);
        }
        zzj2.zzL(zzq2.zzj);
        String str = zzq2.zzd;
        if (str != null) {
            zzj2.zzJ(str);
        }
        zzj2.zzT(zzq2.zzf);
        zzj2.zzad(zzq2.zzh);
        if (!TextUtils.isEmpty(zzq2.zzg)) {
            zzj2.zzZ(zzq2.zzg);
        }
        zzj2.zzH(zzq2.zzo);
        zzj2.zzae(zzq2.zzr);
        zzj2.zzU(zzq2.zzs);
        zzqr.zzc();
        if (zzg().zzs((String) null, zzeh.zzam) || zzg().zzs(zzq2.zza, zzeh.zzao)) {
            zzj2.zzah(zzq2.zzx);
        }
        zzop.zzc();
        if (zzg().zzs((String) null, zzeh.zzal)) {
            zzj2.zzag(zzq2.zzt);
        } else {
            zzop.zzc();
            if (zzg().zzs((String) null, zzeh.zzak)) {
                zzj2.zzag((List) null);
            }
        }
        zzra.zzc();
        if (zzg().zzs((String) null, zzeh.zzaq)) {
            zzj2.zzai(zzq2.zzy);
        }
        zzpw.zzc();
        if (zzg().zzs((String) null, zzeh.zzaE)) {
            zzj2.zzaj(zzq2.zzz);
        }
        if (zzj2.zzam()) {
            zzam zzam5 = this.zze;
            zzal(zzam5);
            zzam5.zzD(zzj2);
        }
        return zzj2;
    }

    public final zzaa zzf() {
        zzaa zzaa = this.zzh;
        zzal(zzaa);
        return zzaa;
    }

    public final zzag zzg() {
        return ((zzge) Preconditions.checkNotNull(this.zzn)).zzf();
    }

    /* access modifiers changed from: package-private */
    public final zzai zzh(String str) {
        String str2;
        zzai zzai = zzai.zza;
        zzaB().zzg();
        zzB();
        zzai zzai2 = (zzai) this.zzB.get(str);
        if (zzai2 != null) {
            return zzai2;
        }
        zzam zzam = this.zze;
        zzal(zzam);
        Preconditions.checkNotNull(str);
        zzam.zzg();
        zzam.zzW();
        Cursor cursor = null;
        try {
            Cursor rawQuery = zzam.zzh().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
            if (rawQuery.moveToFirst()) {
                str2 = rawQuery.getString(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } else {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                str2 = "G1";
            }
            zzai zzb2 = zzai.zzb(str2);
            zzV(str, zzb2);
            return zzb2;
        } catch (SQLiteException e) {
            zzam.zzt.zzaA().zzd().zzc("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final zzam zzi() {
        zzam zzam = this.zze;
        zzal(zzam);
        return zzam;
    }

    public final zzep zzj() {
        return this.zzn.zzj();
    }

    public final zzfa zzl() {
        zzfa zzfa = this.zzd;
        zzal(zzfa);
        return zzfa;
    }

    public final zzfc zzm() {
        zzfc zzfc = this.zzf;
        if (zzfc != null) {
            return zzfc;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzfv zzo() {
        zzfv zzfv = this.zzc;
        zzal(zzfv);
        return zzfv;
    }

    /* access modifiers changed from: package-private */
    public final zzge zzq() {
        return this.zzn;
    }

    public final zzio zzr() {
        zzio zzio = this.zzj;
        zzal(zzio);
        return zzio;
    }

    public final zzka zzs() {
        return this.zzk;
    }

    public final zzli zzu() {
        zzli zzli = this.zzi;
        zzal(zzli);
        return zzli;
    }

    public final zzlo zzv() {
        return ((zzge) Preconditions.checkNotNull(this.zzn)).zzv();
    }

    /* access modifiers changed from: package-private */
    public final String zzw(zzai zzai) {
        if (!zzai.zzi(zzah.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzv().zzG().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: package-private */
    public final String zzx(zzq zzq2) {
        try {
            return (String) zzaB().zzh(new zzkz(this, zzq2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzaA().zzd().zzc("Failed to get app instance id. appId", zzeu.zzn(zzq2.zza), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzz(Runnable runnable) {
        zzaB().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }
}
