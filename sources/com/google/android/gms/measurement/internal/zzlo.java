package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzpn;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.2 */
public final class zzlo extends zzgy {
    private static final String[] zza = {"firebase_", "google_", "ga_"};
    private static final String[] zzb = {"_err"};
    private SecureRandom zzc;
    private final AtomicLong zzd = new AtomicLong(0);
    private int zze;
    private Integer zzf = null;

    zzlo(zzge zzge) {
        super(zzge);
    }

    static MessageDigest zzF() {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static ArrayList zzH(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzac zzac = (zzac) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzac.zza);
            bundle.putString("origin", zzac.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, zzac.zzd);
            bundle.putString("name", zzac.zzc.zzb);
            zzha.zzb(bundle, Preconditions.checkNotNull(zzac.zzc.zza()));
            bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, zzac.zze);
            String str = zzac.zzf;
            if (str != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str);
            }
            zzaw zzaw = zzac.zzg;
            if (zzaw != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzaw.zza);
                zzau zzau = zzaw.zzb;
                if (zzau != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzau.zzc());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, zzac.zzh);
            zzaw zzaw2 = zzac.zzi;
            if (zzaw2 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzaw2.zza);
                zzau zzau2 = zzaw2.zzb;
                if (zzau2 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzau2.zzc());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, zzac.zzc.zzc);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, zzac.zzj);
            zzaw zzaw3 = zzac.zzk;
            if (zzaw3 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzaw3.zza);
                zzau zzau3 = zzaw3.zzb;
                if (zzau3 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzau3.zzc());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static void zzK(zziq zziq, Bundle bundle, boolean z) {
        if (!(bundle == null || zziq == null)) {
            if (!bundle.containsKey("_sc") || z) {
                String str = zziq.zza;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = zziq.zzb;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zziq.zzc);
                return;
            }
            z = false;
        }
        if (bundle != null && zziq == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    static boolean zzaj(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean zzak(String str) {
        Preconditions.checkNotEmpty(str);
        if (str.charAt(0) != '_' || str.equals("_ep")) {
            return true;
        }
        return false;
    }

    static boolean zzal(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    static boolean zzam(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return zzav(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return zzav(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    public static boolean zzan(String str) {
        return !zzb[0].equals(str);
    }

    static final boolean zzaq(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    static final boolean zzar(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private final int zzas(String str) {
        if ("_ldl".equals(str)) {
            this.zzt.zzf();
            return 2048;
        } else if ("_id".equals(str)) {
            this.zzt.zzf();
            return 256;
        } else if ("_lgclid".equals(str)) {
            this.zzt.zzf();
            return 100;
        } else {
            this.zzt.zzf();
            return 36;
        }
    }

    private final Object zzat(int i, Object obj, boolean z, boolean z2) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0 : 1);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zzD(obj.toString(), i, z);
            }
            if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if (parcelable instanceof Bundle) {
                    Bundle zzt = zzt((Bundle) parcelable);
                    if (!zzt.isEmpty()) {
                        arrayList.add(zzt);
                    }
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    private static boolean zzau(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String zza2 : strArr) {
            if (zzlm.zza(str, zza2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean zzav(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    static long zzp(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        int i = 0;
        Preconditions.checkState(length > 0);
        long j = 0;
        while (true) {
            length--;
            if (length < 0 || length < bArr.length - 8) {
                return j;
            }
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    public final Object zzA(String str, Object obj) {
        int i = 256;
        if ("_ev".equals(str)) {
            this.zzt.zzf();
            return zzat(256, obj, true, true);
        }
        if (zzaj(str)) {
            this.zzt.zzf();
        } else {
            this.zzt.zzf();
            i = 100;
        }
        return zzat(i, obj, false, true);
    }

    /* access modifiers changed from: package-private */
    public final Object zzB(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return zzat(zzas(str), obj, true, false);
        }
        return zzat(zzas(str), obj, false, false);
    }

    /* access modifiers changed from: package-private */
    public final String zzC() {
        byte[] bArr = new byte[16];
        zzG().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    public final String zzD(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    public final URL zzE(long j, String str, String str2, long j2) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", new Object[]{String.format("v%s.%s", new Object[]{77000L, Integer.valueOf(zzm())}), str2, str, Long.valueOf(j2)});
            if (str.equals(this.zzt.zzf().zzm())) {
                format = format.concat("&ddl_test=1");
            }
            return new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e) {
            this.zzt.zzaA().zzd().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @EnsuresNonNull({"this.secureRandom"})
    public final SecureRandom zzG() {
        zzg();
        if (this.zzc == null) {
            this.zzc = new SecureRandom();
        }
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final void zzI(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            this.zzt.zzaA().zzk().zzb("Params already contained engagement", Long.valueOf(j2));
        } else {
            j2 = 0;
        }
        bundle.putLong("_et", j + j2);
    }

    /* access modifiers changed from: package-private */
    public final void zzJ(Bundle bundle, int i, String str, String str2, Object obj) {
        if (zzaq(bundle, i)) {
            this.zzt.zzf();
            bundle.putString("_ev", zzD(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", (long) obj.toString().length());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzL(Bundle bundle, Bundle bundle2) {
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                if (!bundle.containsKey(str)) {
                    this.zzt.zzv().zzP(bundle, str, bundle2.get(str));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzM(Parcelable[] parcelableArr, int i, boolean z) {
        Preconditions.checkNotNull(parcelableArr);
        for (Bundle bundle : parcelableArr) {
            int i2 = 0;
            for (String str : new TreeSet(bundle.keySet())) {
                if (zzak(str) && !zzau(str, zzhc.zzd) && (i2 = i2 + 1) > i) {
                    if (z) {
                        this.zzt.zzaA().zze().zzc("Param can't contain more than " + i + " item-scoped custom parameters", this.zzt.zzj().zze(str), this.zzt.zzj().zzb(bundle));
                        zzaq(bundle, 28);
                    } else {
                        this.zzt.zzaA().zze().zzc("Param cannot contain item-scoped custom parameters", this.zzt.zzj().zze(str), this.zzt.zzj().zzb(bundle));
                        zzaq(bundle, 23);
                    }
                    bundle.remove(str);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzN(zzev zzev, int i) {
        int i2 = 0;
        for (String str : new TreeSet(zzev.zzd.keySet())) {
            if (zzak(str) && (i2 = i2 + 1) > i) {
                this.zzt.zzaA().zze().zzc("Event can't contain more than " + i + " params", this.zzt.zzj().zzd(zzev.zza), this.zzt.zzj().zzb(zzev.zzd));
                zzaq(zzev.zzd, 5);
                zzev.zzd.remove(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzO(zzln zzln, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zzaq(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        zzln.zza(str, "_err", bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zzP(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Bundle[]) {
                bundle.putParcelableArray(str, (Bundle[]) obj);
            } else if (str != null) {
                this.zzt.zzaA().zzl().zzc("Not putting event parameter. Invalid value type. name, type", this.zzt.zzj().zze(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public final void zzQ(zzcf zzcf, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e) {
            this.zzt.zzaA().zzk().zzb("Error returning boolean value to wrapper", e);
        }
    }

    public final void zzR(zzcf zzcf, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e) {
            this.zzt.zzaA().zzk().zzb("Error returning bundle list to wrapper", e);
        }
    }

    public final void zzS(zzcf zzcf, Bundle bundle) {
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e) {
            this.zzt.zzaA().zzk().zzb("Error returning bundle value to wrapper", e);
        }
    }

    public final void zzT(zzcf zzcf, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e) {
            this.zzt.zzaA().zzk().zzb("Error returning byte array to wrapper", e);
        }
    }

    public final void zzU(zzcf zzcf, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e) {
            this.zzt.zzaA().zzk().zzb("Error returning int value to wrapper", e);
        }
    }

    public final void zzV(zzcf zzcf, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e) {
            this.zzt.zzaA().zzk().zzb("Error returning long value to wrapper", e);
        }
    }

    public final void zzW(zzcf zzcf, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e) {
            this.zzt.zzaA().zzk().zzb("Error returning string value to wrapper", e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzX(String str, String str2, String str3, Bundle bundle, List list, boolean z) {
        int i;
        String str4;
        int i2;
        int i3;
        String str5;
        int i4;
        String str6 = str2;
        Bundle bundle2 = bundle;
        List list2 = list;
        if (bundle2 != null) {
            zzag zzf2 = this.zzt.zzf();
            zzpn.zzc();
            String str7 = null;
            int i5 = (!zzf2.zzt.zzf().zzs((String) null, zzeh.zzaz) || !zzf2.zzt.zzv().zzai(231100000, true)) ? 0 : 35;
            int i6 = 0;
            for (String str8 : new TreeSet(bundle.keySet())) {
                if (list2 == null || !list2.contains(str8)) {
                    int zzj = !z ? zzj(str8) : 0;
                    if (zzj == 0) {
                        zzj = zzi(str8);
                    }
                    i = zzj;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    zzJ(bundle, i, str8, str8, i == 3 ? str8 : str7);
                    bundle2.remove(str8);
                    i2 = i5;
                    str4 = str7;
                } else {
                    if (zzag(bundle2.get(str8))) {
                        this.zzt.zzaA().zzl().zzd("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str6, str3, str8);
                        str5 = str8;
                        i3 = i5;
                        i4 = 22;
                    } else {
                        String str9 = str3;
                        str5 = str8;
                        i3 = i5;
                        i4 = zza(str, str2, str8, bundle2.get(str8), bundle, list, z, false);
                    }
                    if (i4 != 0 && !"_ev".equals(str5)) {
                        zzJ(bundle, i4, str5, str5, bundle2.get(str5));
                        bundle2.remove(str5);
                    } else if (zzak(str5) && !zzau(str5, zzhc.zzd)) {
                        int i7 = i6 + 1;
                        if (!zzai(231100000, true)) {
                            this.zzt.zzaA().zze().zzc("Item array not supported on client's version of Google Play Services (Android Only)", this.zzt.zzj().zzd(str6), this.zzt.zzj().zzb(bundle2));
                            zzaq(bundle2, 23);
                            bundle2.remove(str5);
                            i2 = i3;
                        } else {
                            i2 = i3;
                            if (i7 > i2) {
                                zzpn.zzc();
                                str4 = null;
                                if (this.zzt.zzf().zzs((String) null, zzeh.zzaz)) {
                                    zzes zze2 = this.zzt.zzaA().zze();
                                    zze2.zzc("Item can't contain more than " + i2 + " item-scoped custom params", this.zzt.zzj().zzd(str6), this.zzt.zzj().zzb(bundle2));
                                    zzaq(bundle2, 28);
                                    bundle2.remove(str5);
                                } else {
                                    this.zzt.zzaA().zze().zzc("Item cannot contain custom parameters", this.zzt.zzj().zzd(str6), this.zzt.zzj().zzb(bundle2));
                                    zzaq(bundle2, 23);
                                    bundle2.remove(str5);
                                }
                                i6 = i7;
                            }
                        }
                        str4 = null;
                        i6 = i7;
                    }
                    i2 = i3;
                    str4 = null;
                }
                i5 = i2;
                str7 = str4;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzY(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (zzar(str)) {
                return true;
            }
            if (this.zzt.zzL()) {
                this.zzt.zzaA().zze().zzb("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzeu.zzn(str));
            }
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            if (this.zzt.zzL()) {
                this.zzt.zzaA().zze().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        } else if (zzar(str2)) {
            return true;
        } else {
            this.zzt.zzaA().zze().zzb("Invalid admob_app_id. Analytics disabled.", zzeu.zzn(str2));
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzZ(String str, int i, String str2) {
        if (str2 == null) {
            this.zzt.zzaA().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            this.zzt.zzaA().zze().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.Object r17, android.os.Bundle r18, java.util.List r19, boolean r20, boolean r21) {
        /*
            r13 = this;
            r7 = r13
            r8 = r16
            r0 = r17
            r1 = r18
            r13.zzg()
            boolean r2 = r13.zzag(r0)
            java.lang.String r3 = "param"
            r4 = 17
            r5 = 0
            if (r2 == 0) goto L_0x00ad
            if (r21 == 0) goto L_0x00aa
            java.lang.String[] r2 = com.google.android.gms.measurement.internal.zzhc.zzc
            boolean r2 = zzau(r8, r2)
            if (r2 != 0) goto L_0x0022
            r0 = 20
            return r0
        L_0x0022:
            com.google.android.gms.measurement.internal.zzge r2 = r7.zzt
            com.google.android.gms.measurement.internal.zzjy r2 = r2.zzt()
            r2.zzg()
            r2.zza()
            boolean r6 = r2.zzN()
            if (r6 != 0) goto L_0x0035
            goto L_0x0047
        L_0x0035:
            com.google.android.gms.measurement.internal.zzge r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzlo r2 = r2.zzv()
            int r2 = r2.zzm()
            r6 = 200900(0x310c4, float:2.81521E-40)
            if (r2 >= r6) goto L_0x0047
            r0 = 25
            return r0
        L_0x0047:
            com.google.android.gms.measurement.internal.zzge r2 = r7.zzt
            r2.zzf()
            boolean r2 = r0 instanceof android.os.Parcelable[]
            if (r2 == 0) goto L_0x0055
            r6 = r0
            android.os.Parcelable[] r6 = (android.os.Parcelable[]) r6
            int r6 = r6.length
            goto L_0x0060
        L_0x0055:
            boolean r6 = r0 instanceof java.util.ArrayList
            if (r6 == 0) goto L_0x00ad
            r6 = r0
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            int r6 = r6.size()
        L_0x0060:
            r9 = 200(0xc8, float:2.8E-43)
            if (r6 <= r9) goto L_0x00ad
            com.google.android.gms.measurement.internal.zzge r10 = r7.zzt
            com.google.android.gms.measurement.internal.zzeu r10 = r10.zzaA()
            com.google.android.gms.measurement.internal.zzes r10 = r10.zzl()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r11 = "Parameter array is too long; discarded. Value kind, name, array length"
            r10.zzd(r11, r3, r8, r6)
            com.google.android.gms.measurement.internal.zzge r6 = r7.zzt
            r6.zzf()
            if (r2 == 0) goto L_0x008e
            r2 = r0
            android.os.Parcelable[] r2 = (android.os.Parcelable[]) r2
            int r6 = r2.length
            if (r6 <= r9) goto L_0x00a7
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r9)
            android.os.Parcelable[] r2 = (android.os.Parcelable[]) r2
            r1.putParcelableArray(r8, r2)
            goto L_0x00a7
        L_0x008e:
            boolean r2 = r0 instanceof java.util.ArrayList
            if (r2 == 0) goto L_0x00a7
            r2 = r0
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r6 = r2.size()
            if (r6 <= r9) goto L_0x00a7
            java.util.ArrayList r6 = new java.util.ArrayList
            java.util.List r2 = r2.subList(r5, r9)
            r6.<init>(r2)
            r1.putParcelableArrayList(r8, r6)
        L_0x00a7:
            r9 = 17
            goto L_0x00ae
        L_0x00aa:
            r0 = 21
            return r0
        L_0x00ad:
            r9 = 0
        L_0x00ae:
            boolean r1 = zzaj(r15)
            if (r1 != 0) goto L_0x00c3
            boolean r1 = zzaj(r16)
            if (r1 == 0) goto L_0x00bb
            goto L_0x00c3
        L_0x00bb:
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            r1.zzf()
            r1 = 100
            goto L_0x00ca
        L_0x00c3:
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            r1.zzf()
            r1 = 256(0x100, float:3.59E-43)
        L_0x00ca:
            boolean r1 = r13.zzab(r3, r8, r1, r0)
            if (r1 == 0) goto L_0x00d1
            return r9
        L_0x00d1:
            if (r21 == 0) goto L_0x0161
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 == 0) goto L_0x00e8
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r5 = r19
            r6 = r20
            r0.zzX(r1, r2, r3, r4, r5, r6)
            goto L_0x0160
        L_0x00e8:
            boolean r1 = r0 instanceof android.os.Parcelable[]
            if (r1 == 0) goto L_0x011f
            r10 = r0
            android.os.Parcelable[] r10 = (android.os.Parcelable[]) r10
            int r11 = r10.length
            r12 = 0
        L_0x00f1:
            if (r12 >= r11) goto L_0x0160
            r0 = r10[r12]
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 != 0) goto L_0x010d
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzeu r1 = r1.zzaA()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzl()
            java.lang.Class r0 = r0.getClass()
            java.lang.String r2 = "All Parcelable[] elements must be of type Bundle. Value type, name"
            r1.zzc(r2, r0, r8)
            goto L_0x0161
        L_0x010d:
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r5 = r19
            r6 = r20
            r0.zzX(r1, r2, r3, r4, r5, r6)
            int r12 = r12 + 1
            goto L_0x00f1
        L_0x011f:
            boolean r1 = r0 instanceof java.util.ArrayList
            if (r1 == 0) goto L_0x0161
            r10 = r0
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            int r11 = r10.size()
            r12 = 0
        L_0x012b:
            if (r12 >= r11) goto L_0x0160
            java.lang.Object r0 = r10.get(r12)
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 != 0) goto L_0x014e
            com.google.android.gms.measurement.internal.zzge r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzeu r1 = r1.zzaA()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzl()
            if (r0 == 0) goto L_0x0146
            java.lang.Class r0 = r0.getClass()
            goto L_0x0148
        L_0x0146:
            java.lang.String r0 = "null"
        L_0x0148:
            java.lang.String r2 = "All ArrayList elements must be of type Bundle. Value type, name"
            r1.zzc(r2, r0, r8)
            goto L_0x0161
        L_0x014e:
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r5 = r19
            r6 = r20
            r0.zzX(r1, r2, r3, r4, r5, r6)
            int r12 = r12 + 1
            goto L_0x012b
        L_0x0160:
            return r9
        L_0x0161:
            r0 = 4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlo.zza(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    /* access modifiers changed from: protected */
    public final void zzaC() {
        zzg();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                this.zzt.zzaA().zzk().zza("Utils falling back to Random for random id");
            }
        }
        this.zzd.set(nextLong);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaa(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.zzt.zzaA().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = zza;
        for (int i = 0; i < 3; i++) {
            if (str2.startsWith(strArr3[i])) {
                this.zzt.zzaA().zze().zzc("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !zzau(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && zzau(str2, strArr2)) {
            return true;
        }
        this.zzt.zzaA().zze().zzc("Name is reserved. Type, name", str, str2);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzab(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String obj2 = obj.toString();
            if (obj2.codePointCount(0, obj2.length()) > i) {
                this.zzt.zzaA().zzl().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(obj2.length()));
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzac(String str, String str2) {
        if (str2 == null) {
            this.zzt.zzaA().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.zzt.zzaA().zze().zzb("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                if (codePointAt == 95) {
                    codePointAt = 95;
                } else {
                    this.zzt.zzaA().zze().zzc("Name must start with a letter or _ (underscore). Type, name", str, str2);
                    return false;
                }
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    this.zzt.zzaA().zze().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzad(String str, String str2) {
        if (str2 == null) {
            this.zzt.zzaA().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.zzt.zzaA().zze().zzb("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                this.zzt.zzaA().zze().zzc("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    this.zzt.zzaA().zze().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzae(String str) {
        zzg();
        if (Wrappers.packageManager(this.zzt.zzaw()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        this.zzt.zzaA().zzc().zzb("Permission not granted", str);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaf(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String zzl = this.zzt.zzf().zzl();
        this.zzt.zzay();
        return zzl.equals(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzag(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzah(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e) {
            this.zzt.zzaA().zzd().zzb("Error obtaining certificate", e);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            this.zzt.zzaA().zzd().zzb("Package name not found", e2);
            return true;
        }
    }

    public final boolean zzai(int i, boolean z) {
        Boolean zzj = this.zzt.zzt().zzj();
        if (zzm() >= i / 1000 || (zzj != null && !zzj.booleanValue())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzao(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            Preconditions.checkNotNull(str);
            return !str.equals(str2);
        } else if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        } else {
            if (isEmpty) {
                return TextUtils.isEmpty(str3) || !str3.equals(str4);
            }
            if (TextUtils.isEmpty(str4)) {
                return false;
            }
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
    }

    /* access modifiers changed from: package-private */
    public final byte[] zzap(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzd(String str, Object obj) {
        boolean z;
        if ("_ldl".equals(str)) {
            z = zzab("user property referrer", str, zzas(str), obj);
        } else {
            z = zzab("user property", str, zzas(str), obj);
        }
        return z ? 0 : 7;
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int zzh(String str) {
        if (!zzac("event", str)) {
            return 2;
        }
        if (!zzaa("event", zzhb.zza, zzhb.zzb, str)) {
            return 13;
        }
        this.zzt.zzf();
        if (!zzZ("event", 40, str)) {
            return 2;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzi(String str) {
        if (!zzac("event param", str)) {
            return 3;
        }
        if (!zzaa("event param", (String[]) null, (String[]) null, str)) {
            return 14;
        }
        this.zzt.zzf();
        if (!zzZ("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzj(String str) {
        if (!zzad("event param", str)) {
            return 3;
        }
        if (!zzaa("event param", (String[]) null, (String[]) null, str)) {
            return 14;
        }
        this.zzt.zzf();
        if (!zzZ("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzl(String str) {
        if (!zzac("user property", str)) {
            return 6;
        }
        if (!zzaa("user property", zzhd.zza, (String[]) null, str)) {
            return 15;
        }
        this.zzt.zzf();
        if (!zzZ("user property", 24, str)) {
            return 6;
        }
        return 0;
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int zzm() {
        if (this.zzf == null) {
            this.zzf = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzt.zzaw()) / 1000);
        }
        return this.zzf.intValue();
    }

    public final int zzo(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(this.zzt.zzaw(), GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public final long zzq() {
        long andIncrement;
        long j;
        if (this.zzd.get() == 0) {
            synchronized (this.zzd) {
                long nextLong = new Random(System.nanoTime() ^ this.zzt.zzax().currentTimeMillis()).nextLong();
                int i = this.zze + 1;
                this.zze = i;
                j = nextLong + ((long) i);
            }
            return j;
        }
        synchronized (this.zzd) {
            this.zzd.compareAndSet(-1, 1);
            andIncrement = this.zzd.getAndIncrement();
        }
        return andIncrement;
    }

    public final long zzr(long j, long j2) {
        return (j + (j2 * 60000)) / 86400000;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzs(Uri uri, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Uri uri2 = uri;
        if (uri2 != null) {
            try {
                if (uri.isHierarchical()) {
                    str8 = uri2.getQueryParameter("utm_campaign");
                    str7 = uri2.getQueryParameter("utm_source");
                    str6 = uri2.getQueryParameter("utm_medium");
                    str5 = uri2.getQueryParameter("gclid");
                    str4 = uri2.getQueryParameter("utm_id");
                    str3 = uri2.getQueryParameter("dclid");
                    str2 = uri2.getQueryParameter("srsltid");
                    str = z ? uri2.getQueryParameter("sfmc_id") : null;
                } else {
                    str8 = null;
                    str7 = null;
                    str6 = null;
                    str5 = null;
                    str4 = null;
                    str3 = null;
                    str2 = null;
                    str = null;
                }
                if (TextUtils.isEmpty(str8) && TextUtils.isEmpty(str7) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && (!z || TextUtils.isEmpty(str))) {
                    return null;
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(str8)) {
                    bundle.putString("campaign", str8);
                }
                if (!TextUtils.isEmpty(str7)) {
                    bundle.putString("source", str7);
                }
                if (!TextUtils.isEmpty(str6)) {
                    bundle.putString("medium", str6);
                }
                if (!TextUtils.isEmpty(str5)) {
                    bundle.putString("gclid", str5);
                }
                String queryParameter = uri2.getQueryParameter("utm_term");
                if (!TextUtils.isEmpty(queryParameter)) {
                    bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter);
                }
                String queryParameter2 = uri2.getQueryParameter("utm_content");
                if (!TextUtils.isEmpty(queryParameter2)) {
                    bundle.putString(FirebaseAnalytics.Param.CONTENT, queryParameter2);
                }
                String queryParameter3 = uri2.getQueryParameter(FirebaseAnalytics.Param.ACLID);
                if (!TextUtils.isEmpty(queryParameter3)) {
                    bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter3);
                }
                String queryParameter4 = uri2.getQueryParameter(FirebaseAnalytics.Param.CP1);
                if (!TextUtils.isEmpty(queryParameter4)) {
                    bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter4);
                }
                String queryParameter5 = uri2.getQueryParameter("anid");
                if (!TextUtils.isEmpty(queryParameter5)) {
                    bundle.putString("anid", queryParameter5);
                }
                if (!TextUtils.isEmpty(str4)) {
                    bundle.putString("campaign_id", str4);
                }
                if (!TextUtils.isEmpty(str3)) {
                    bundle.putString("dclid", str3);
                }
                String queryParameter6 = uri2.getQueryParameter("utm_source_platform");
                if (!TextUtils.isEmpty(queryParameter6)) {
                    bundle.putString("source_platform", queryParameter6);
                }
                String queryParameter7 = uri2.getQueryParameter("utm_creative_format");
                if (!TextUtils.isEmpty(queryParameter7)) {
                    bundle.putString("creative_format", queryParameter7);
                }
                String queryParameter8 = uri2.getQueryParameter("utm_marketing_tactic");
                if (!TextUtils.isEmpty(queryParameter8)) {
                    bundle.putString("marketing_tactic", queryParameter8);
                }
                if (!TextUtils.isEmpty(str2)) {
                    bundle.putString("srsltid", str2);
                }
                if (z && !TextUtils.isEmpty(str)) {
                    bundle.putString("sfmc_id", str);
                }
                return bundle;
            } catch (UnsupportedOperationException e) {
                this.zzt.zzaA().zzk().zzb("Install referrer url isn't a hierarchical URI", e);
                return null;
            }
        } else {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzt(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzA = zzA(str, bundle.get(str));
                if (zzA == null) {
                    this.zzt.zzaA().zzl().zzb("Param value can't be null", this.zzt.zzj().zze(str));
                } else {
                    zzP(bundle2, str, zzA);
                }
            }
        }
        return bundle2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0108 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zzu(java.lang.String r21, java.lang.String r22, android.os.Bundle r23, java.util.List r24, boolean r25) {
        /*
            r20 = this;
            r9 = r20
            r10 = r22
            r11 = r23
            r12 = r24
            java.lang.String[] r0 = com.google.android.gms.measurement.internal.zzhb.zzd
            boolean r13 = zzau(r10, r0)
            if (r11 == 0) goto L_0x010d
            android.os.Bundle r15 = new android.os.Bundle
            r15.<init>(r11)
            com.google.android.gms.measurement.internal.zzge r0 = r9.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            int r8 = r0.zzc()
            java.util.TreeSet r0 = new java.util.TreeSet
            java.util.Set r1 = r23.keySet()
            r0.<init>(r1)
            java.util.Iterator r16 = r0.iterator()
            r17 = 0
            r18 = 0
        L_0x0030:
            boolean r0 = r16.hasNext()
            if (r0 == 0) goto L_0x010b
            java.lang.Object r0 = r16.next()
            r7 = r0
            java.lang.String r7 = (java.lang.String) r7
            if (r12 == 0) goto L_0x0048
            boolean r0 = r12.contains(r7)
            if (r0 != 0) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r2 = 0
            goto L_0x0057
        L_0x0048:
            if (r25 != 0) goto L_0x004f
            int r0 = r9.zzj(r7)
            goto L_0x0050
        L_0x004f:
            r0 = 0
        L_0x0050:
            if (r0 != 0) goto L_0x0056
            int r0 = r9.zzi(r7)
        L_0x0056:
            r2 = r0
        L_0x0057:
            if (r2 == 0) goto L_0x006d
            r0 = 3
            if (r2 != r0) goto L_0x005e
            r5 = r7
            goto L_0x005f
        L_0x005e:
            r5 = 0
        L_0x005f:
            r0 = r20
            r1 = r15
            r3 = r7
            r4 = r7
            r0.zzJ(r1, r2, r3, r4, r5)
            r15.remove(r7)
            r14 = r8
            goto L_0x0108
        L_0x006d:
            java.lang.Object r4 = r11.get(r7)
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r7
            r5 = r15
            r6 = r24
            r19 = r7
            r7 = r25
            r14 = r8
            r8 = r13
            int r2 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 17
            if (r2 != r0) goto L_0x009a
            r2 = 17
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r17)
            r0 = r20
            r1 = r15
            r3 = r19
            r4 = r19
            r0.zzJ(r1, r2, r3, r4, r5)
            goto L_0x00bc
        L_0x009a:
            if (r2 == 0) goto L_0x00bc
            java.lang.String r0 = "_ev"
            r6 = r19
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x00be
            r0 = 21
            if (r2 != r0) goto L_0x00ac
            r3 = r10
            goto L_0x00ad
        L_0x00ac:
            r3 = r6
        L_0x00ad:
            java.lang.Object r5 = r11.get(r6)
            r0 = r20
            r1 = r15
            r4 = r6
            r0.zzJ(r1, r2, r3, r4, r5)
            r15.remove(r6)
            goto L_0x0108
        L_0x00bc:
            r6 = r19
        L_0x00be:
            boolean r0 = zzak(r6)
            if (r0 == 0) goto L_0x0108
            int r0 = r18 + 1
            if (r0 <= r14) goto L_0x0106
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Event can't contain more than "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r2 = " params"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.google.android.gms.measurement.internal.zzge r2 = r9.zzt
            com.google.android.gms.measurement.internal.zzeu r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzes r2 = r2.zze()
            com.google.android.gms.measurement.internal.zzge r3 = r9.zzt
            com.google.android.gms.measurement.internal.zzep r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r10)
            com.google.android.gms.measurement.internal.zzge r4 = r9.zzt
            com.google.android.gms.measurement.internal.zzep r4 = r4.zzj()
            java.lang.String r4 = r4.zzb(r11)
            r2.zzc(r1, r3, r4)
            r1 = 5
            zzaq(r15, r1)
            r15.remove(r6)
        L_0x0106:
            r18 = r0
        L_0x0108:
            r8 = r14
            goto L_0x0030
        L_0x010b:
            r14 = r15
            goto L_0x010e
        L_0x010d:
            r14 = 0
        L_0x010e:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlo.zzu(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean):android.os.Bundle");
    }

    /* access modifiers changed from: package-private */
    public final zzaw zzz(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zzh(str2) == 0) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            bundle2.putString("_o", str3);
            Bundle zzu = zzu(str, str2, bundle2, CollectionUtils.listOf("_o"), true);
            if (z) {
                zzu = zzt(zzu);
            }
            Preconditions.checkNotNull(zzu);
            return new zzaw(str2, new zzau(zzu), str3, j);
        }
        this.zzt.zzaA().zzd().zzb("Invalid conditional property event name", this.zzt.zzj().zzf(str2));
        throw new IllegalArgumentException();
    }
}
